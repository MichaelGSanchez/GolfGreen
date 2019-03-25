```sql
CREATE TABLE IF NOT EXISTS `${Course}` (
`course_id`             INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, 
`course_name`           TEXT, 
`price`                 INTEGER NOT NULL, 
`difficulty`            INTEGER NOT NULL, 
`url`                   TEXT, 
`phone_number`          INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS `${CourseLocation}` (
`course_id`             INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, 
`location_id`           INTEGER NOT NULL, FOREIGN KEY(`location_id`) 
			                  REFERENCES `Location`(`location_id`) ON UPDATE
			                  NO ACTION ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS `${Location}` (
`location_id`           INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
 `latitude`             INTEGER NOT NULL, 
 `longitude`            INTEGER, 
 `city`                 TEXT,
 `zip`                  INTEGER,
 `max_radius`           INTEGER NOT NULL,
 `time_stamp`           INTEGER, 
 `user_id`              INTEGER NOT NULL,
 FOREIGN KEY(`user_id`) REFERENCES `User`(`user_id`)
                        ON UPDATE NO ACTION ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS `${User}` (
 `user_id`              INTEGER PRIMARY KEY AUTOINCREMENT,
 `first_name`           TEXT, 
 `last_name`            TEXT, 
 `user_name`            TEXT, 
 `favorite_course`      TEXT
 );



```