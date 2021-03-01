package com.implicitly.messenger;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.h2.tools.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "micronaut-demo",
                version = "0.0"
        )
)
public class Application {

    public static void main(String[] args) throws Exception {
        Server.createWebServer().start();
        Micronaut.build(args)
                .mainClass(Application.class)
                .defaultEnvironments("default")
                .start();
    }
}
