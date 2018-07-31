CREATE TABLE `User` (
  `id` BIGINT  NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name`         VARCHAR(20)  ,
  `user_name`         VARCHAR(20)  ,
  `password` VARCHAR(60)  ,
  `status` VARCHAR(20)  ,
  `role` VARCHAR(20)  ,
  `email` VARCHAR(20)  ,
  `phone` VARCHAR(20)
);

-- username=wer password=war
INSERT INTO `User` VALUES (1, '小明','wer', '$2a$10$EgmhRAlC5iw.KeENZ5.RYebSEHTcO8yl9lOf/r36GoyGb4uNOOhr2','alive','admin','544097676@qq.com','1213545');