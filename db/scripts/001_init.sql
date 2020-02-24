-- *************** SqlDBM: PostgreSQL ****************;
-- ***************************************************;

-- DROP TABLE "info";


-- DROP TABLE "photo";

-- ************************************** "photo"

CREATE TABLE "photo"
(
    "photo_id" int  NOT NULL,
    "link"     text NOT NULL

);

CREATE UNIQUE INDEX "PK_photo" ON "photo"
    (
     "photo_id"
        );


-- ************************************** "info"

CREATE TABLE "info"
(
    "info_id"  int         NOT NULL,
    "name"     varchar(50) NOT NULL,
    "data"     text        NOT NULL,
    "photo_id" int         NULL,
    "status"   int         NOT NULL,
    "category" int         NOT NULL,
    CONSTRAINT "FK_21" FOREIGN KEY ("photo_id") REFERENCES "photo" ("photo_id")
);

CREATE UNIQUE INDEX "PK_info" ON "info"
    (
     "info_id"
        );

CREATE INDEX "fkIdx_21" ON "info"
    (
     "photo_id"
        );

CREATE SEQUENCE info_seq
    START 1
    INCREMENT 1
    MINVALUE 1
    OWNED BY info.info_id;






