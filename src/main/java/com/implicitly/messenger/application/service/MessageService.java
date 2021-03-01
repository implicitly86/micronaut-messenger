package com.implicitly.messenger.application.service;

import com.implicitly.messenger.application.advice.NotNull;
import com.implicitly.messenger.application.model.MessageDto;

/**
 * @author Emil Murzakaev.
 */
public interface MessageService {

    @NotNull
    MessageDto createMessage(MessageDto message);

}
