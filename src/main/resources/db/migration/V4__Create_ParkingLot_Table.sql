CREATE TABLE `Parking_Lot` (
  `id` BIGINT  NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name`         VARCHAR(20),
  `size` int,
  `status` VARCHAR(20),
  `init_size` int,
  `user_id` BIGINT
);
insert into Parking_Lot values (1,'南方停车场',10,'开放',20,1);
insert into Parking_Lot values (2,'北方停车场',23,'开放',20,1);
insert into Parking_Lot values (3,'西南停车场',15,'开放',20,1);
insert into Parking_Lot values (4,'东南停车场',9,'开放',20,1);