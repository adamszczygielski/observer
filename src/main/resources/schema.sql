create table if not exists searches
(
    id bigint auto_increment not null,
    keyword varchar(255) not null,
    category_id varchar(255),
    category_name varchar(255),
    price_from int,
    price_to int,
    last_execution_date timestamp,
    interval_minutes smallint not null,
    source_id smallint not null,
    status_id smallint not null,
    primary key(id),
);

create table if not exists items
(
   id bigint auto_increment not null,
   origin_id varchar(255) not null,
   search_id bigint,
   created_date timestamp not null,
   title varchar(255) not null,
   price varchar(255) not null,
   url varchar(255) not null,
   is_deleted boolean not null,
   is_notification_sent boolean not null,
   source_id smallint not null,
   primary key(id),
   foreign key (search_id) references search(id) on delete cascade
);

create view if not exists searches_v as
(
    select
        s.id,
        s.keyword,
        s.category_id,
        s.category_name,
        s.price_from,
        s.price_to,
        s.last_execution_date,
        s.interval_minutes,
        s.source_id,
        s.status_id,
        count(i.id) as count
    from searches s
    left join items i on s.id = i.search_id and i.is_deleted = false
    group by s.id
    order by s.keyword, s.source_id
);