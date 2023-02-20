drop table item, member_streets, order_item;

create table member(
    member_id bigint auto_increment primary key,
    name varchar(20) null,
    street varchar(255) null,
    zipcode varchar(255) null
);

create table orders(
    order_id bigint auto_increment primary key,
    member bigint not null,
    orderdate datetime null,
    orderstatus varchar(20) null
);