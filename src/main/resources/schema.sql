CREATE SCHEMA wikimedia1;

CREATE TABLE wikimedia1.wikimedia1(
    id SERIAL PRIMARY KEY,
    wikiData VARCHAR(50) NOT NULL UNIQUE);

