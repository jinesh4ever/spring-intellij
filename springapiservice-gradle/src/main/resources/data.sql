drop table if exists public.ufs_fulfillment;
drop table if exists public.ufs_batch_process;
drop sequence if exists ufs_fulfillment_ufs_fulfillment_id_seq;
drop sequence if exists ufs_batch_process_ufs_batch_process_id_seq;
create sequence if not exists  ufs_fulfillment_ufs_fulfillment_id_seq;
create sequence if not exists  ufs_batch_process_ufs_batch_process_id_seq;

CREATE TABLE if not exists  public.ufs_fulfillment
(
    ufs_fulfillment_id bigint NOT NULL DEFAULT nextval('ufs_fulfillment_ufs_fulfillment_id_seq'::regclass),
    status boolean NOT NULL,
    vendor character varying(255) COLLATE pg_catalog."default" NOT NULL,
    vendor_category character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT ufs_fulfillment_pkey PRIMARY KEY (ufs_fulfillment_id)
    --CONSTRAINT uk_3921svxffmmidl4vpi8f52j0k UNIQUE (vendor)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.ufs_fulfillment
    OWNER to postgres;


CREATE TABLE public.ufs_batch_process
(
    ufs_batch_process_id bigint NOT NULL DEFAULT nextval('ufs_batch_process_ufs_batch_process_id_seq'::regclass),
    processed_time timestamp without time zone NOT NULL,
    status boolean NOT NULL,
    vendor character varying(255) COLLATE pg_catalog."default" NOT NULL,
    vendor_category character varying(255) COLLATE pg_catalog."default" ,
    CONSTRAINT ufs_batch_process_pkey PRIMARY KEY (ufs_batch_process_id)
    --CONSTRAINT uk_p0gpebt4owgqvif4hqtprh4iy UNIQUE (vendor)

)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.ufs_batch_process
    OWNER to postgres;

insert into ufs_fulfillment(vendor, status, vendor_category) values('VNDR1',true,'VNDR_CAT1');
insert into ufs_fulfillment(vendor, status, vendor_category) values('VNDR2',true,'VNDR_CAT2');
insert into ufs_fulfillment(vendor, status, vendor_category) values('VNDR3',true,'VNDR_CAT3');
insert into ufs_fulfillment(vendor, status, vendor_category) values('VNDR4',true,'VNDR_CAT4');
insert into ufs_fulfillment(vendor, status, vendor_category) values('VNDR5',true,'VNDR_CAT5');