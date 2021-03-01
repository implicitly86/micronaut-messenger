FROM ghcr.io/graalvm/graalvm-ce:java11-21.0.0 as graalvm
RUN gu install native-image

COPY target/classes /home/app/classes
COPY target/dependency/* /home/app/libs/
#COPY target/micronaut-demo.jar /home/app/

WORKDIR /home/app

RUN native-image -H:Class=com.implicitly.messenger.Application -H:Name=application --no-fallback --no-server -cp "/home/app/libs/*:/home/app/classes/"

FROM frolvlad/alpine-glibc:alpine-3.12
RUN apk update && apk add libstdc++
COPY --from=graalvm /home/app/application /app/application

EXPOSE 8080
ENTRYPOINT ["/app/application"]
