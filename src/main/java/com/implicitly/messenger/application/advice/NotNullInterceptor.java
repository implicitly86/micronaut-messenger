package com.implicitly.messenger.application.advice;

import io.micronaut.aop.MethodInterceptor;
import io.micronaut.aop.MethodInvocationContext;
import io.micronaut.core.type.MutableArgumentValue;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Singleton;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Emil Murzakaev.
 */
@Slf4j
@Singleton
public class NotNullInterceptor implements MethodInterceptor<Object, Object> {

    @Override
    public Object intercept(MethodInvocationContext<Object, Object> context) {
        Optional<Map.Entry<String, MutableArgumentValue<?>>> nullParam = context.getParameters()
                .entrySet()
                .stream()
                .filter(entry -> {
                    MutableArgumentValue<?> argumentValue = entry.getValue();
                    return Objects.isNull(argumentValue.getValue());
                })
                .findFirst();
        if (nullParam.isPresent()) {
            throw new IllegalArgumentException("Null parameter [" + nullParam.get().getKey() + "] not allowed");
        }
        String parameters = Stream.of(context.getParameterValues())
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        log.debug("invoke {}({})", context.getMethodName(), parameters);
        Object result = context.proceed();
        log.debug("result {}({}) : {}", context.getMethodName(), parameters, result);
        return result;
    }

}
