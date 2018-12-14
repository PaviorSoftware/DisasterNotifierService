INSERT INTO roles (name)
VALUES ("SYS_ADMIN");
INSERT INTO roles (name)
VALUES ("SYS_USER");

INSERT INTO users (e_mail, firebase_token, latitude, longitude, password, username)
VALUES ("ieee@teicm.gr", "", "40.770820", "22.709802", "EF273EFBE70F384C519FF62A2EF9BFE180AF52EA626675145ED2712D04DDE3CB", "ieee");

INSERT INTO users_roles(user_id, roles_id)
VALUES (1, 1);