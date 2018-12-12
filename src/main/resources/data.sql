INSERT INTO roles (name)
VALUES ("SYS_ADMIN");
INSERT INTO roles (name)
VALUES ("SYS_USER");

INSERT INTO users (e_mail, firebase_token, latitude, longitude, password, username)
VALUES ("ieee@teicm.gr", "", "0", "0", "F3EFF1B3CA2FDA16FCB1476FD749C59C3D12D665C78EA73E95037A2B050D15CC", "ieee");

INSERT INTO users_roles(user_id, roles_id)
VALUES (1, 1);

INSERT INTO users (e_mail, firebase_token, latitude, longitude, password, username)
VALUES ("user@example.net", "", "0", "0", "EF273EFBE70F384C519FF62A2EF9BFE180AF52EA626675145ED2712D04DDE3CB", "guest");

INSERT INTO users_roles(user_id, roles_id)
VALUES (2, 2);