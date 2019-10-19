alter table organization add column email varchar(512) not null unique;
alter table organization add column username varchar(512) not null unique;
alter table organization add column password varchar(512) not null;