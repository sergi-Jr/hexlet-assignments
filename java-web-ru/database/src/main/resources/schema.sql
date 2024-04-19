drop table if exists products;

create table Products(
    id int primary key auto_increment,
    title varchar(100),
    price int
);