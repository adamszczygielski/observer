--drop view search_v;
--drop table item;
--drop table search;

create table if not exists search
(
    id bigint auto_increment not null,
    keyword varchar(255) not null,
    category varchar(255),
    last_update timestamp,
    time_interval integer not null,
    is_active boolean not null,
    "SOURCE" varchar(255) not null,
    primary key(id)
);

create table if not exists item
(
   item_id bigint auto_increment not null,
   origin_id varchar(255) not null,
   search_id bigint, --TODO change to not null somehow
   creation_date timestamp,
   title varchar(255) not null,
   price varchar(255) not null,
   url varchar(255) not null,
   is_active boolean not null,
   foreign key (search_id) references search(id)
);

create or replace view search_v as (
select s.id, s.keyword, s.category, s.last_update, s.time_interval, s.is_active, s.source, count(i.item_id) as count
from search s left join item i on s.id = i.search_id and i.is_active = true
group by s.keyword, s.id, s.category
order by s.is_active desc, count desc);

