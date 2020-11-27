
insert into  user (user_id,user_name,password) values
    ('user id 1', 'user name 1', 'password1');
insert into  user (user_id,user_name,password) values
    ('user id 2', 'user name 2', 'password2');

insert into role(id, name) values(1,"admin");

insert into role(id, name) values(2,"user");

insert into user(id, password, user_id, user_name, role_id) values(1,"admin", "admin", "admin", 1);
insert into user(id, password, user_id, user_name, role_id) values(2,"user", "user", "user", 2);
