CREATE TABLE `Role` (
  `id` BIGINT  NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name`         VARCHAR(20)
);
insert into Role values (1,'manager');
insert into Role values (2,'admin');
insert into Role values (3,'employee');