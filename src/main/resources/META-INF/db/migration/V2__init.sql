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

create index if not exists idx_condition_code    on condition  (code);
create index if not exists idx_condition_display on condition  (display);

create index if not exists idx_insurance_code    on insurance  (code);
create index if not exists idx_insurance_display on insurance  (display);

create index if not exists idx_chargeitem_code    on chargeitem (code);
create index if not exists idx_chargeitem_display on chargeitem (display);
