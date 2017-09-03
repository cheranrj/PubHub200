create table role
(
	id INT primary key AUTO_INCREMENT,
	name VARCHAR(200) unique NOT NULL,
	active varchar(5) default true,
	created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

insert into role ( name ) values ('Admin');
insert into role ( name ) values ('User');



