CREATE TABLE `orders` (
  `id`             INT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `uesr_id`        INT,
  `type`           VARCHAR(20)  NOT NULL,
  `stauts`         VARCHAR(20)  NOT NULL,
  `car_id`          VARCHAR(20)  NOT NULL

 );
