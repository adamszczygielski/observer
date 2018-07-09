create table if not exists search
(
    id bigint auto_increment not null,
    key_words varchar(255) not null,
    last_update timestamp,
    time_interval integer not null,
    is_active boolean not null,
    primary key(id)
);

create table if not exists item
(
   item_id bigint not null,
   search_id bigint not null,
   creation_date timestamp,
   title varchar(255) not null,
   price varchar(255) not null,
   url varchar(255) not null,
   is_active boolean not null,
   foreign key (search_id) references search(id)
);

create or replace view search_v as (
select s.id, s.key_words, s.last_update, s.time_interval, s.is_active, count(i.item_id) count
from search s left join item i on s.id = i.search_id and i.is_active = true
group by s.key_words, s.id
order by s.is_active desc, count desc);