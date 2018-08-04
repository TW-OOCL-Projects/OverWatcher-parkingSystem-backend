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
INSERT INTO `User` VALUES (1, '小明','wer', '$2a$10$EgmhRAlC5iw.KeENZ5.RYebSEHTcO8yl9lOf/r36GoyGb4uNOOhr2','上班','544097676@qq.com','19011112222');
INSERT INTO `User` VALUES (2, '小红','daa', '$2a$10$EgmhRAlC5iw.KeENZ5.RYebSEHTcO8yl9lOf/r36GoyGb4uNOOhr2','上班','544657676@qq.com','12011112222');
INSERT INTO `User` VALUES (3, '小刚','aaa', '$2a$10$EgmhRAlC5iw.KeENZ5.RYebSEHTcO8yl9lOf/r36GoyGb4uNOOhr2','上班','854097676@qq.com','14011112222');
INSERT INTO `User` VALUES (4, '小亮','us1', '$2a$10$EgmhRAlC5iw.KeENZ5.RYebSEHTcO8yl9lOf/r36GoyGb4uNOOhr2','上班','785097676@qq.com','18011112222');
INSERT INTO `User` VALUES (5, '小新','us2', '$2a$10$EgmhRAlC5iw.KeENZ5.RYebSEHTcO8yl9lOf/r36GoyGb4uNOOhr2','上班','685097676@qq.com','16015412222');
INSERT INTO `User` VALUES (6, '小烘','us3', '$2a$10$EgmhRAlC5iw.KeENZ5.RYebSEHTcO8yl9lOf/r36GoyGb4uNOOhr2','上班','254097676@qq.com','16018112222');
INSERT INTO `User` VALUES (7, '小干','us4', '$2a$10$EgmhRAlC5iw.KeENZ5.RYebSEHTcO8yl9lOf/r36GoyGb4uNOOhr2','下班','424097676@qq.com','17011212222');
INSERT INTO `User` VALUES (8, '小配','us5', '$2a$10$EgmhRAlC5iw.KeENZ5.RYebSEHTcO8yl9lOf/r36GoyGb4uNOOhr2','上班','528097676@qq.com','15018182222');
INSERT INTO `User` VALUES (9, '小了','us6', '$2a$10$EgmhRAlC5iw.KeENZ5.RYebSEHTcO8yl9lOf/r36GoyGb4uNOOhr2','下班','248097676@qq.com','15011812222');
INSERT INTO `User` VALUES (10, '小时','us7', '$2a$10$EgmhRAlC5iw.KeENZ5.RYebSEHTcO8yl9lOf/r36GoyGb4uNOOhr2','下班','254097676@qq.com','16011412222');
INSERT INTO `User` VALUES (11, '小发','us8', '$2a$10$EgmhRAlC5iw.KeENZ5.RYebSEHTcO8yl9lOf/r36GoyGb4uNOOhr2','上班','654097676@qq.com','15011112222');