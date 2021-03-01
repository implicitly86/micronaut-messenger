create sequence user_seq;
create table "user" (
    id          number          not null,
    name        varchar2(255)   not null,
    age         number(2),
    is_deleted  number(1)       default 0 not null,
    constraint user__pk primary key (id),
    constraint user_unique_name unique (name)
);

comment on table "user" is 'Пользователь';
comment on column "user".id is 'Уникальный идентификатор';
comment on column "user".name is 'Имя пользователя';
comment on column "user".age is 'Возраст';
comment on column "user".is_deleted is 'Признак удаления записи';
