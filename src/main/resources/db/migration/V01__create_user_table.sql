CREATE TABLE user
(
    id      VARCHAR(36) CONSTRAINT user_id_pkey PRIMARY KEY,
    login    VARCHAR(50) unique NOT NULL
);
