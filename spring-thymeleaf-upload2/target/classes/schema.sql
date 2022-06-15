CREATE TABLE firm(id INTEGER NOT NULL AUTO_INCREMENT,
                name TEXT NOT NULL);
CREATE TABLE os(id INTEGER NOT NULL AUTO_INCREMENT,
                name TEXT NOT NULL,
                developer TEXT NOT NULL);
CREATE TABLE smart(id INTEGER NOT NULL AUTO_INCREMENT,
                name TEXT NOT NULL,
                firm_id INTEGER NOT NULL,
                os_id INTEGER NOT NULL,
                size float,
                color text);