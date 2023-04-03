--liquibase formatted sql

--change set couldlie:1
ALTER TABLE apartment ADD COLUMN URL VARCHAR(250);
ALTER TABLE rent_apartment ADD COLUMN URL VARCHAR(250);