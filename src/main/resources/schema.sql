
-- zmeneny dialect na mariaDB a potom data.sql bug

# MA VOBEC TATO SCHEMA DOPAD NA NASU DATABZU?!
create table user (
#     zmena z User na Users
    id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    username    VARCHAR(128),
    phone       VARCHAR(16) UNIQUE,
    password    VARCHAR(128)
);

create table service (
    id              BIGINT PRIMARY KEY AUTO_INCREMENT,
    requestor_id    BIGINT,
#  id IDENTITY,		? PRIMARY KEY
    service_name    VARCHAR(255),
#     servicename?
    estimated_hours INT,
    description     VARCHAR(255),
    averaged_rating DOUBLE
);
# is there need for requestor_id?

CREATE TABLE likes(
    id              BIGINT PRIMARY KEY auto_increment,
    service_id      BIGINT,
    like_date       DATE,
    user_id         BIGINT,
    hours           BIGINT,
    rating_log      BIGINT
);

CREATE TABLE rating
(
    id              BIGINT PRIMARY KEY AUTO_INCREMENT,
    rating_date     DATE,
    service_id      BIGINT,
    user_id         BIGINT,
    stars           INT

);
# zbehlo
ALTER TABLE service
    ADD constraint us_fk_user foreign key (user_id)
        REFERENCES user (id);

# ---------------------------
ALTER TABLE likes
    ADD constraint likes_fk_user foreign key (user_id)
        REFERENCES user (id);

ALTER TABLE likes
    ADD constraint us_fk_service foreign key (service_id)
        REFERENCES service (id);


ALTER TABLE rating
    ADD constraint rating_us_fk foreign key (user_id)
        REFERENCES user (id);

ALTER TABLE rating
    ADD constraint service_us_fk foreign key (service_id)
        REFERENCES service (id);
