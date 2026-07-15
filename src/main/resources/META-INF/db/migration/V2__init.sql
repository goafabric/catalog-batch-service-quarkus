create table if not exists condition
(
	id varchar(36) not null primary key,

	code varchar(255),
	display varchar(255),
	shortname varchar(255),

    version bigint default 0
);


create table if not exists insurance
(
	id varchar(36) not null primary key,

	code varchar(255),
	display varchar(255),
	shortname varchar(255),

    version bigint default 0
);


create table if not exists chargeitem
(
	id varchar(36) not null primary key,

	code varchar(255),
	display varchar(255),
	price decimal,

    version bigint default 0
);
