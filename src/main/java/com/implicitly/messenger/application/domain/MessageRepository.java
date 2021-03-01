package com.implicitly.messenger.application.domain;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

/**
 * @author Emil Murzakaev.
 */
@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {
}
