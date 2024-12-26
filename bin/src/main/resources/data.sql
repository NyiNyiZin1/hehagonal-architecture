CREATE TABLE account(
	id INT NOT NULL,
  	PRIMARY KEY(id)
);

CREATE TABLE activity (
id INT NOT NULL,
transfer_time DATETIME NOT NULL,
owner_account_id INT NOT NULL,
source_account_id INT NOT NULL,
target_account_id INT NOT NULL,
amount INT NOT NULL,
PRIMARY KEY(id)
);


insert into account (id) values (1);
insert into account (id) values (2);

insert into activity (id, transfer_time, owner_account_id, source_account_id, target_account_id, amount)
values (1, '2018-08-08 08:00:00.0', 1, 1, 2, 500);

insert into activity (id, transfer_time, owner_account_id, source_account_id, target_account_id, amount)
values (2, '2018-08-08 08:00:00.0', 2, 1, 2, 500);

insert into activity (id, transfer_time, owner_account_id, source_account_id, target_account_id, amount)
values (3, '2018-08-09 10:00:00.0', 1, 2, 1, 1000);

insert into activity (id, transfer_time, owner_account_id, source_account_id, target_account_id, amount)
values (4, '2018-08-09 10:00:00.0', 2, 2, 1, 1000);

insert into activity (id, transfer_time, owner_account_id, source_account_id, target_account_id, amount)
values (5, '2019-08-09 09:00:00.0', 1, 1, 2, 1000);

insert into activity (id, transfer_time, owner_account_id, source_account_id, target_account_id, amount)
values (6, '2019-08-09 09:00:00.0', 2, 1, 2, 1000);

insert into activity (id, transfer_time, owner_account_id, source_account_id, target_account_id, amount)
values (7, '2019-08-09 10:00:00.0', 1, 2, 1, 1000);

insert into activity (id, transfer_time, owner_account_id, source_account_id, target_account_id, amount)
values (8, '2019-08-09 10:00:00.0', 2, 2, 1, 1000);