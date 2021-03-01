package com.implicitly.messenger.application.service;

import com.implicitly.messenger.application.model.MessageDto;
import io.micronaut.messaging.annotation.Body;
import io.micronaut.nats.annotation.NatsListener;
import io.micronaut.nats.annotation.Subject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Emil Murzakaev.
 */
@Slf4j
@NatsListener
@RequiredArgsConstructor
public class MessageListener {

    private final MessageService messageService;

    @Subject("message")
    public void receive(@Body MessageDto message) {
        messageService.createMessage(message);
    }

}
