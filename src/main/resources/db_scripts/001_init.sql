-- Database: Library

-- DROP DATABASE "Library";

CREATE DATABASE "Library"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Russian_Russia.1251'
    LC_CTYPE = 'Russian_Russia.1251'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

-- Table: public.category

-- DROP TABLE public.category;

CREATE TABLE public.category
(
    id integer NOT NULL,
    name character varying(50) COLLATE pg_catalog."default" NOT NULL
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.category
    OWNER to postgres;

-- Index: PK_category

-- DROP INDEX public."PK_category";

CREATE UNIQUE INDEX "PK_category"
    ON public.category USING btree
    (id ASC NULLS LAST)
    TABLESPACE pg_default;

-- Table: public.photo

-- DROP TABLE public.photo;

CREATE TABLE public.photo
(
    id integer NOT NULL,
    link text COLLATE pg_catalog."default" NOT NULL
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.photo
    OWNER to postgres;

-- Index: PK_photo

-- DROP INDEX public."PK_photo";

CREATE UNIQUE INDEX "PK_photo"
    ON public.photo USING btree
    (id ASC NULLS LAST)
    TABLESPACE pg_default;

-- Table: public.info

-- DROP TABLE public.info;

CREATE TABLE public.info
(
    id integer NOT NULL,
    name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    data json NOT NULL,
    photo_id integer,
    category_id integer NOT NULL,
    CONSTRAINT "FK_21" FOREIGN KEY (photo_id)
        REFERENCES public.photo (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT "FK_24" FOREIGN KEY (category_id)
        REFERENCES public.category (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.info
    OWNER to postgres;

-- Index: PK_info

-- DROP INDEX public."PK_info";

CREATE UNIQUE INDEX "PK_info"
    ON public.info USING btree
    (id ASC NULLS LAST)
    TABLESPACE pg_default;


-- Index: fkIdx_21

-- DROP INDEX public."fkIdx_21";

CREATE INDEX "fkIdx_21"
    ON public.info USING btree
    (photo_id ASC NULLS LAST)
    TABLESPACE pg_default;


-- Index: fkIdx_24

-- DROP INDEX public."fkIdx_24";

CREATE INDEX "fkIdx_24"
    ON public.info USING btree
    (category_id ASC NULLS LAST)
    TABLESPACE pg_default;