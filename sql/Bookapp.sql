select * from users;

insert into users(NAME,email,PASSWORD)values('cheran','cheranrj@gmail.com','helloword');

insert into users(Name,email,PASSWORD,role_id)values('venky','venky@gmail.com','venkyword',1);

insert into books(Name,price) values ('Wings of Fire: An Autobiography of Abdul Kalam',250);

select * from role;

select * from books;

select * from orders;

select * from order_items;

DELETE from users where id = 135;

UPDATE users
SET role_id = 2
WHERE id = 133;

DELETE from users where id = 144;


