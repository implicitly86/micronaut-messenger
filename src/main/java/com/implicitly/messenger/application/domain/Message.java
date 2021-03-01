package com.implicitly.messenger.application.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * @author Emil Murzakaev.
 */
@Data
@Entity
@ToString(of = "id")
@Table(name = "message")
@EqualsAndHashCode(of = "id")
public class Message {

    @Id
    @GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sequence", allocationSize = 1, sequenceName = "message_seq")
    private Long id;

    @Column(name = "author_id")
    private Long authorId;

    @Column(name = "receiver_id")
    private Long receiverId;

    @Lob
    @Column(name = "text")
    private String text;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Column(name = "is_deleted")
    private boolean isDeleted;

}
