package com.implicitly.messenger.application.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import lombok.SneakyThrows;

import java.net.URI;

/**
 * @author Emil Murzakaev.
 */
@Controller
public class IndexController {

    @Get(uri = "/")
    @SneakyThrows
    public HttpResponse<Void> index() {
        return HttpResponse.redirect(new URI("/swagger/views/swagger-ui"));
    }

}
