CREATE TABLE `Parking_Lot` (
  `id` BIGINT  NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name`         VARCHAR(20),
  `size` int,
  `status` VARCHAR(20),
  `init_size` int,
  `user_id` BIGINT
);
insert into Parking_Lot values (1,'南方停车场',10,'开放',20,1);
insert into Parking_Lot values (2,'北方停车场',20,'开放',20,1);
insert into Parking_Lot values (3,'西南停车场',15,'开放',20,1);
insert into Parking_Lot values (4,'东南停车场',9,'开放',20,1);
insert into Parking_Lot values (5,'东南停车场',9,'开放',20,2);
insert into Parking_Lot(id,name,size,status,init_size) values (6,'b1',9,'开放',20);
insert into Parking_Lot(id,name,size,status,init_size) values (7,'b2',9,'开放',20);
insert into Parking_Lot(id,name,size,status,init_size,user_id) values (8,'a1',9,'开放',20,4);
insert into Parking_Lot(id,name,size,status,init_size,user_id) values (9,'a2',0,'开放',20,4);
insert into Parking_Lot(id,name,size,status,init_size,user_id) values (10,'东南停车场',9,'开放',20,5);
insert into Parking_Lot(id,name,size,status,init_size,user_id) values (11,'东北停车场',0,'开放',20,5);
insert into Parking_Lot(id,name,size,status,init_size,user_id) values (12,'东北停车场',9,'开放',20,5);