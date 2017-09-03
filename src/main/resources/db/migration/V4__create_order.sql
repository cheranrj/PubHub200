CREATE TABLE orders
(
 id INT PRIMARY KEY AUTO_INCREMENT,
 user_id INT,
 total_price INT NOT NULL DEFAULT 0,
 
 ordered_date TIMESTAMP DEFAULT NOW(),
 modified_date TIMESTAMP DEFAULT NOW(),
 cancelled_date DATETIME,
 delivered_date DATETIME,
 status VARCHAR(50) DEFAULT 'ORDERED' ,
  reason VARCHAR(100) ,
  paymentmode VARCHAR(4),
 
 CONSTRAINT fk_userss FOREIGN KEY(user_id) REFERENCES users(id)
 );
 
-- select * from orders;