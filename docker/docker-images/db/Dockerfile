FROM mysql:latest

COPY conf/my.cnf /etc/mysql/my.cnf
COPY dump/init_db.sql docker-entrypoint-initdb.d/
COPY dump/fill_db.sql docker-entrypoint-initdb.d/
