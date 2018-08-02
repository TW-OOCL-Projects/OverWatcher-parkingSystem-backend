CREATE TABLE `User` (
  `id` BIGINT  NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name`         VARCHAR(20)  ,
  `user_name`         VARCHAR(20)  ,
  `password` VARCHAR(60)  ,
  `status` VARCHAR(20)  ,
  `email` VARCHAR(20)  ,
  `phone` VARCHAR(20)
);

-- username=wer password=war
INSERT INTO `User` VALUES (1, '小明','wer', '$2a$10$EgmhRAlC5iw.KeENZ5.RYebSEHTcO8yl9lOf/r36GoyGb4uNOOhr2','alive','544097676@qq.com','13011112222');
INSERT INTO `User` VALUES (2, '小红','dsa', '$2a$10$EgmhRAlC5iw.KeENZ5.RYebSEHTcO8yl9lOf/r36GoyGb4uNOOhr2','alive','544097676@qq.com','13011112222');
INSERT INTO `User` VALUES (3, '小刚','dsa', '$2a$10$EgmhRAlC5iw.KeENZ5.RYebSEHTcO8yl9lOf/r36GoyGb4uNOOhr2','alive','544097676@qq.com','13011112222');
INSERT INTO `User` VALUES (4, '小亮','wfdsfer', '$2a$10$EgmhRAlC5iw.KeENZ5.RYebSEHTcO8yl9lOf/r36GoyGb4uNOOhr2','alive','544097676@qq.com','13011112222');
INSERT INTO `User` VALUES (5, '小新','wfdfser', '$2a$10$EgmhRAlC5iw.KeENZ5.RYebSEHTcO8yl9lOf/r36GoyGb4uNOOhr2','alive','544097676@qq.com','13011112222');
INSERT INTO `User` VALUES (6, '小烘','wefdsfr', '$2a$10$EgmhRAlC5iw.KeENZ5.RYebSEHTcO8yl9lOf/r36GoyGb4uNOOhr2','alive','544097676@qq.com','13011112222');
INSERT INTO `User` VALUES (7, '小干','wefdsfsr', '$2a$10$EgmhRAlC5iw.KeENZ5.RYebSEHTcO8yl9lOf/r36GoyGb4uNOOhr2','alive','544097676@qq.com','13011112222');
INSERT INTO `User` VALUES (8, '小配','wfdser', '$2a$10$EgmhRAlC5iw.KeENZ5.RYebSEHTcO8yl9lOf/r36GoyGb4uNOOhr2','alive','544097676@qq.com','13011112222');
INSERT INTO `User` VALUES (9, '小了','wfsdfer', '$2a$10$EgmhRAlC5iw.KeENZ5.RYebSEHTcO8yl9lOf/r36GoyGb4uNOOhr2','alive','544097676@qq.com','13011112222');
INSERT INTO `User` VALUES (10, '小时','wfsdfer', '$2a$10$EgmhRAlC5iw.KeENZ5.RYebSEHTcO8yl9lOf/r36GoyGb4uNOOhr2','alive','544097676@qq.com','13011112222');
INSERT INTO `User` VALUES (11, '小发','wefsdr', '$2a$10$EgmhRAlC5iw.KeENZ5.RYebSEHTcO8yl9lOf/r36GoyGb4uNOOhr2','alive','544097676@qq.com','13011112222');