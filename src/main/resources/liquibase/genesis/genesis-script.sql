create type skill_tp as enum ('DANCER', 'COOKER');
create type donate_st as enum ('AWAITING_VALIDATION', 'FINISHED');

CREATE SEQUENCE user_id_seq
INCREMENT 1
START 1;

CREATE SEQUENCE user_skill_id_seq
INCREMENT 1
START 1;

CREATE SEQUENCE organization_id_seq
INCREMENT 1
START 1;

CREATE SEQUENCE campaign_id_seq
INCREMENT 1
START 1;

CREATE SEQUENCE item_id_seq
INCREMENT 1
START 1;

CREATE SEQUENCE campaign_item_id_seq
INCREMENT 1
START 1;

CREATE SEQUENCE donation_id_seq
INCREMENT 1
START 1;

CREATE SEQUENCE event_id_seq
INCREMENT 1
START 1;

create table "user" (
	id int,
	username varchar(2048) not null unique,
	email varchar(2048) not null unique,
	first_name varchar(512) not null,
	last_name varchar(512) not null,
	cpf varchar(11) not null unique,
	cnpj varchar(14) not null unique,
	image_url varchar(2048) not null unique,
	primary key (id)
);

ALTER TABLE "user" ALTER COLUMN id SET DEFAULT nextval('user_id_seq');

create table user_skill (
	id int,
	user_id int,
	skill skill_tp not null,
	primary key (id),
	foreign key (user_id) references "user" (id)
);

ALTER TABLE user_skill ALTER COLUMN id SET DEFAULT nextval('user_skill_id_seq');

create table organization(
	id int,
	name varchar(256) not null,
	description varchar(512) not null,
	cnpj varchar(14) not null unique,
	latitude int not null,
	longitude int not null,
	primary key (id)
);

ALTER TABLE organization ALTER COLUMN id SET DEFAULT nextval('organization_id_seq');

create table campaign(
	id int,
	organization_id int,
	title varchar(256) not null,
	description varchar(512) not null,
	start_date timestamp not null,
	end_date timestamp not null,
	primary key(id),
	foreign key (organization_id) references organization(id)
);

ALTER TABLE campaign ALTER COLUMN id SET DEFAULT nextval('campaign_id_seq');

create table item(
	id int,
	title varchar(256) not null,
	description varchar(512) not null,
	primary key(id)
);

ALTER TABLE item ALTER COLUMN id SET DEFAULT nextval('item_id_seq');

create table campaign_item(
	id int,
	campaign_id int,
	item_id int not null,
	quantity int not null,
	is_completed boolean not null,
	primary key(id),
	foreign key (campaign_id) references campaign(id),
	foreign key (item_id) references item(id)
);

ALTER TABLE campaign_item ALTER COLUMN id SET DEFAULT nextval('campaign_item_id_seq');

create table donation(
	id int,
	user_id int,
	item_id int not null,
	campaign_id int not null,
	quantity int not null,
	created_date timestamp not null,
	status donate_st not null,
	primary key(id),
	foreign key (item_id) references item(id),
	foreign key (campaign_id) references campaign(id)
);

ALTER TABLE donation ALTER COLUMN id SET DEFAULT nextval('donation_id_seq');

create table event(
	id int,
	campaign_id int,
	title varchar(256) not null,
	description varchar(512) not null,
	start_date timestamp not null,
	end_date timestamp not null,
	latitude int not null,
	longitude int not null,
	primary key(id)
);

ALTER TABLE event ALTER COLUMN id SET DEFAULT nextval('event_id_seq');