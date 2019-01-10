
CREATE TABLE public.ufs_fulfillment
(
    ufs_fulfillment_id bigint NOT NULL DEFAULT nextval('ufs_fulfillment_ufs_fulfillment_id_seq'::regclass),
    status boolean NOT NULL,
    vendor character varying(255) COLLATE pg_catalog."default" NOT NULL,
    vendor_category character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT ufs_fulfillment_pkey PRIMARY KEY (ufs_fulfillment_id),
    CONSTRAINT uk_3921svxffmmidl4vpi8f52j0k UNIQUE (vendor)

)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.ufs_fulfillment
    OWNER to postgres;