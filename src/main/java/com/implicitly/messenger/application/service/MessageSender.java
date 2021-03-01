package com.implicitly.messenger.application.service;

import com.implicitly.messenger.application.model.MessageDto;
import io.micronaut.nats.annotation.NatsClient;
import io.micronaut.nats.annotation.Subject;

/**
 * @author Emil Murzakaev.
 */
@NatsClient
public interface MessageSender {

    @Subject("message")
    void send(MessageDto message);

}
