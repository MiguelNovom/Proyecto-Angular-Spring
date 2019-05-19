/* Creamos algunos usuarios con sus roles */
INSERT INTO `users` (email, password, enabled, nombre, apellidos, telefono) VALUES ('profesor@bolsadeideas.com','$2a$10$nX/.Z5rEg3by7yuxGcLdv.81ApjTiPRoFl1fRUg8uTi8nOTcl0DuS',1, 'Andres', 'Guzman','123456789');
INSERT INTO `users` (email, password, enabled, nombre, apellidos, telefono) VALUES ('miguel.novom@gmail.com','$2a$10$BFks8A7cfSWVTNvhyXyyi.23lluWZSK4YHS31ipTJwb2hgVhWJssy',1, 'Miguel', 'Novo Martínez','123456789');

INSERT INTO `roles` (nombre) VALUES ('ROLE_USER');
INSERT INTO `roles` (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO `users_roles` (user_id, role_id) VALUES (1, 1);
INSERT INTO `users_roles` (user_id, role_id) VALUES (2, 2);
INSERT INTO `users_roles` (user_id, role_id) VALUES (2, 1);