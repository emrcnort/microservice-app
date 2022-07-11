--CQL Commands

CREATE KEYSPACE springcloud
    WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 3};

use springcloud;

CREATE TABLE accounts(
                    id text PRIMARY KEY,
                    uname text,
                    email text,
                    pwd text,
                    name text,
                    surname text,
                    birth_date date,
                    created_at date,
                    is_active boolean
);

INSERT INTO springcloud.accounts (id, uname, email, pwd, created_at, is_active)
VALUES ('c4b65263-fe58-4846-83e8-f0e1c13d518f', 'RATTO', 'Rissella@gmail.com','pwd123',toDate(now()),true);

select * from accounts;

TRUNCATE  springcloud.accounts;