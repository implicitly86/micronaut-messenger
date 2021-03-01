package com.implicitly.messenger.application.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Error;
import io.micronaut.http.hateoas.JsonError;

/**
 * @author Emil Murzakaev.
 */
@Controller
public class ErrorController {

    @Error(status = HttpStatus.NOT_FOUND, global = true)
    public HttpResponse<JsonError> notFound() {
        JsonError error = new JsonError("page not found");
        return HttpResponse.<JsonError>notFound().body(error);
    }

    @Error(global = true)
    public HttpResponse<JsonError> exception(Throwable throwable) {
        JsonError error = new JsonError(throwable.getMessage());
        return HttpResponse.<JsonError>serverError().body(error);
    }

}
