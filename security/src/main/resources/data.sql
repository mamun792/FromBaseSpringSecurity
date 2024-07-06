INSERT INTO authorities (id, authority) VALUES (1, 'ROLE_ADMIN');
INSERT INTO authorities (id, authority) VALUES (2, 'ROLE_USER');


INSERT INTO users (id,first_name, last_name, username,password) VALUES (101, 'Mahababub', 'Rahman', 'mamun', 'admin');
INSERT INTO users (id,first_name, last_name, username,password) VALUES (102, 'Mim', 'Rahman', 'mim', 'user');

INSERT INTO user_authorities (user_id, authorities_id) VALUES (101, 1);
INSERT INTO user_authorities (user_id, authorities_id) VALUES (102, 1);
INSERT INTO user_authorities (user_id, authorities_id) VALUES (102, 2);

