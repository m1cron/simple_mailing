CREATE ROLE mailing WITH
    LOGIN
    NOSUPERUSER
    NOCREATEDB
    NOCREATEROLE
    INHERIT
    NOREPLICATION;

ALTER ROLE mailing
    PASSWORD 'mailing';

CREATE DATABASE mailing
    WITH
    OWNER = mailing
    ENCODING = 'UTF8';
