CREATE TABLE `orders` (
  `id`             INT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `user_id`        INT,
  `type`           VARCHAR(20)  NOT NULL,
  `status`         VARCHAR(20)  NOT NULL,
  `car_id`         VARCHAR(20)  NOT NULL,
  `leave`          VARCHAR(20)  NOT NULL
 );
