create table if not exists covid_case(
    id              AUTO_INCREMENT PRIMARY KEY,
    country         VARCHAR(60),
    country_code    VARCHAR(10),
    province        VARCHAR(30),
    city            VARCHAR(60),
    city_code       VARCHAR(10),
    lat             VARCHAR(10),
    lon             VARCHAR(10),
    confirmed       INT,
    deaths          INT,
    recovered       INT,
    active          INT,
    date_of         TIMESTAMP
);

create table if not exists summary(
    id              AUTO_INCREMENT PRIMARY KEY,
    new_confirmed   INT,
    total_confirmed INT,
    new_deaths      INT,
    total_deaths    INT,
    new_recovered   INT,
    total_recovered INT
);

create table if not exists country_case(
    id              AUTO_INCREMENT PRIMARY KEY,
    summary_id      BIGINT NOT NULL,
    country         VARCHAR(60),
    country_code    VARCHAR(10),
    slug            VARCHAR(10),
    new_confirmed   INT,
    total_confirmed INT,
    new_deaths      INT,
    total_deaths    INT,
    new_recovered   INT,
    total_recovered INT,
    date_of          TIMESTAMP,
    FOREIGN KEY (summary_id) REFERENCES summary(id);
);

create index country_case_date on country_case(date_of);