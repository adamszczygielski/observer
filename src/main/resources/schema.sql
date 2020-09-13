--drop view if exists search_v;
--drop table if exists parameter;
--drop table if exists item;
--drop table if exists search;

create table if not exists search
(
    id bigint auto_increment not null,
    keyword varchar(255) not null,
    category varchar(255),
    date_updated timestamp not null,
    time_interval smallint not null,
    is_active boolean not null,
    source_id smallint not null,
    primary key(id),
);

create table if not exists item
(
   id bigint auto_increment not null,
   origin_id varchar(255) not null,
   search_id bigint,
   date_created timestamp not null,
   title varchar(255) not null,
   price varchar(255) not null,
   url varchar(255) not null,
   is_active boolean not null,
   is_notified boolean not null,
   primary key(id),
   foreign key (search_id) references search(id) on delete cascade
);

create table if not exists parameter
(
    id bigint auto_increment not null,
    search_id bigint,
    type_id smallint not null,
    value varchar(255) not null,
    primary key(id),
    foreign key (search_id) references search(id) on delete cascade
);

create or replace view search_v as
(
    select s.id, s.keyword, s.category, s.date_updated, s.time_interval, s.is_active, s.source_id, count(i.id) as count
    from search s
    left join item i on s.id = i.search_id and i.is_active = true
    group by s.id
    order by count desc, s.keyword, s.source_id
);