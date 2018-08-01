CREATE TABLE `Parking_Lot` (
  `id` BIGINT  NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name`         VARCHAR(20),
  `size` int,
  `status` VARCHAR(20),
  `initSize` int,
  `user_id` BIGINT
);
insert into Parking_Lot values (1,'South Parking Lot',10,'open',1);
insert into Parking_Lot values (2,'North Parking Lot',23,'open',1);
insert into Parking_Lot values (3,'East Parking Lot',15,'open',1);
insert into Parking_Lot values (4,'West Parking Lot',9,'open',1);