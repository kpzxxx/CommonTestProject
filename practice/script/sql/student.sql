-- auto-generated definition
create table student
(
  id          bigint auto_increment
    primary key,
  phone       varchar(64)                        not null,
  gender      int      default 1                 null,
  name        varchar(255)                       not null,
  pic         longblob                           null,
  pic_name    varchar(255)                       null,
  update_time datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
  version     int      default 0                 not null,
  constraint student_phone_uindex
    unique (phone)
);

