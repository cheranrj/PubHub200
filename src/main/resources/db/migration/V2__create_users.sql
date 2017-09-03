
CREATE TABLE users
(
 id INT PRIMARY KEY AUTO_INCREMENT,
 NAME VARCHAR(200)  NOT NULL,
 email VARCHAR(200) UNIQUE NOT NULL,
 PASSWORD VARCHAR(200) NOT NULL,
 role_id INT DEFAULT 2,
  CONSTRAINT fk_users FOREIGN KEY(role_id) REFERENCES role(id)
);



--select * from users;

--UPDATE users
--SET role_id = 1
--WHERE id = 3;



