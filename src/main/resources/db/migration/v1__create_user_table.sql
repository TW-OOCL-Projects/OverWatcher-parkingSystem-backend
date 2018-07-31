CREATE TABLE `SYS_USER` (
  `id` BIGINT  NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `username`         VARCHAR(20)  NOT NULL,
  `password` VARCHAR(20)  NOT NULL
);

CREATE TABLE `SYS_ROLE` (
  `id` BIGINT  NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name`         VARCHAR(20)  NOT NULL
);

CREATE TABLE `SYS_USER_ROLES` (
  `SYS_USER_ID` BIGINT  NOT NULL ,
  `ROLES_ID`  BIGINT NOT NULL
);


insert into SYS_USER (id,username, password) values (1,'admin', 'admin');
insert into SYS_USER (id,username, password) values (2,'leo', 'leo');

insert into SYS_ROLE(id,name) values(1,'ROLE_ADMIN');
insert into SYS_ROLE(id,name) values(2,'ROLE_USER');

insert into SYS_USER_ROLES(SYS_USER_ID,ROLES_ID) values(1,1);
insert into SYS_USER_ROLES(SYS_USER_ID,ROLES_ID) values(2,2);
