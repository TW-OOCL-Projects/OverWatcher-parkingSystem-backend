CREATE TABLE `User` (
  `id` BIGINT  NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name`         VARCHAR(20)  NOT NULL,
  `username`         VARCHAR(20)  NOT NULL,
  `password` VARCHAR(20)  NOT NULL,
  `status` VARCHAR(20)  NOT NULL,
  `role` VARCHAR(20)  NOT NULL,
  `email` VARCHAR(20)  NOT NULL,
  `phone` VARCHAR(20)  NOT NULL,
);

