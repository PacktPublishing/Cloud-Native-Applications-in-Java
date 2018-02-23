create table product(id serial primary key, name varchar(20), cat_id int not null);
begin;
insert into product(name, cat_id) values ('Apples', 1);
insert into product(name, cat_id) values ('Oranges', 1);
insert into product(name, cat_id) values ('Bananas', 1);
insert into product(name, cat_id) values ('Carrots', 2);
insert into product(name, cat_id) values ('Beans', 2);
insert into product(name, cat_id) values ('Peas', 2);
commit;
