CREATE  TABLE schedule
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    writer     VARCHAR(255)          NULL,
    todo       VARCHAR(255)          NULL,
    date       DATE                  NOT NULL,
    password   VARCHAR(255)          NOT NULL ,
    created_at datetime              NULL,
    updated_at datetime              NULL,
    CONSTRAINT pk_todo PRIMARY KEY (id)
);