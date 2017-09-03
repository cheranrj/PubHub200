CREATE TABLE books
(
 id INT PRIMARY KEY AUTO_INCREMENT,
 name VARCHAR(200) NOT NULL,
 price FLOAT NOT NULL,
 released_date date 
);

insert into books ( name,price,released_date) values ('Core Java', 350,'2017-08-10');
insert into books ( name,price,released_date) values ('MySQL', 200,'2017-08-20');
insert into books ( name,price,released_date) values ('Javascript', 250, '2017-08-12');

insert into books ( name,price,released_date) values ('Sachin Tendulkar', 500,'2017-08-19');
insert into books ( name,price,released_date) values ('BatMan The Killing Joke', 100,'2017-08-25');
insert into books ( name,price,released_date) values ('half girlfriend', 400, '2017-08-29');

insert into books ( name,price,released_date) values ('Wings of Fire',450, '2017-08-30');


