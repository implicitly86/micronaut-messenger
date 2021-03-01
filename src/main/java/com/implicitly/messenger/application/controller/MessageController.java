package com.implicitly.messenger.application.controller;

import com.implicitly.messenger.application.model.MessageDto;
import com.implicitly.messenger.application.service.MessageSender;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Emil Murzakaev.
 */
@Slf4j
@Controller("/message")
@RequiredArgsConstructor
public class MessageController {

    private final MessageSender messageSender;

    @Post(uri = "/hello", processes = MediaType.APPLICATION_JSON)
    public MessageDto hello(@Body MessageDto message) {
        messageSender.send(message);
        return message;
    }

}
