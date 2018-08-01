CREATE TABLE `Parking_Lot` (
  `id` BIGINT  NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name`         VARCHAR(20),
  `size` int,
  `status` VARCHAR(20),
  `user_id` BIGINT
);