-- V1__create_products_table.sql
create sequence product_id_seq start with 1 increment by 50;

create table products
(
    id bigint default nextval('product_id_seq') not null,
    code text not null unique,
    name text not null,
    description text,
    price numeric not null,
    image_url text,
    primary key (id)
);