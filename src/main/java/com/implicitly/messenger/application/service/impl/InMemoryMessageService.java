package com.implicitly.messenger.application.service.impl;

import com.implicitly.messenger.application.domain.Message;
import com.implicitly.messenger.application.domain.MessageRepository;
import com.implicitly.messenger.application.model.MessageDto;
import com.implicitly.messenger.application.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

/**
 * @author Emil Murzakaev.
 */
@Slf4j
@Singleton
@RequiredArgsConstructor
public class InMemoryMessageService implements MessageService {

    private final MessageRepository repository;

    @Override
    @Transactional
    public MessageDto createMessage(MessageDto message) {
        Message entity = new Message();
        entity.setText(message.getMessage());
        entity.setAuthorId(1L);
        entity.setReceiverId(1L);
        entity.setCreationDate(LocalDateTime.now());
        repository.save(entity);
        return message;
    }

}
