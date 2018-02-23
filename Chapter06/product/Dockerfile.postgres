FROM postgres:alpine

ENV POSTGRES_USER=dbuser \
    POSTGRES_PASSWORD=dbpass \
    POSTGRES_DB=product

EXPOSE 5432

RUN mkdir -p /docker-entrypoint-initdb.d

ADD import-postgres.sql /docker-entrypoint-initdb.d/import.sql
