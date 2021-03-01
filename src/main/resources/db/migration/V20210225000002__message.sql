create sequence message_seq;
create table message (
    id              number      not null,
    author_id       number      not null,
    receiver_id     number      not null,
    text            clob        not null,
    creation_date   timestamp   not null,
    is_deleted      number(1)   default 0 not null,
    constraint message__pk primary key (id)
);

comment on table message is 'Сообщение';
comment on column message.id is 'Уникальный идентификатор';
comment on column message.author_id is 'Идентификатор автора';
comment on column message.receiver_id is 'Идентификатор получателя';
comment on column message.text is 'Текст сообщения';
comment on column message.creation_date is 'Дата создания записи';
comment on column message.is_deleted is 'Признак удаления записи';
