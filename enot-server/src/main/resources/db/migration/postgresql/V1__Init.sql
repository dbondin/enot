CREATE TABLE enot_user (
	id bigint NOT NULL,
	active bool NOT NULL,
	created_timestamp timestamp NOT NULL,
	modified_timestamp timestamp NOT NULL,
	admin bool NOT NULL,
	name varchar(255) NOT NULL,
	password varchar(255) NOT NULL,
	CONSTRAINT enot_user_pk PRIMARY KEY (id),
	CONSTRAINT enot_user_name_uk UNIQUE (name)
);

CREATE SEQUENCE enot_user_id_seq
	MINVALUE 1
	INCREMENT BY 1
	CACHE 1
	NO CYCLE
	OWNED BY enot_user.id
;
