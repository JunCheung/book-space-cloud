CREATE TABLE `books`
(
    `id`          bigint                                                       NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name`        varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Book’s name',
    `cover`       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci         DEFAULT NULL COMMENT 'Book’s cover URL',
    `author`      varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT 'Author’s name',
    `publication` date                                                                  DEFAULT NULL COMMENT 'Publication date',
    `isbn`        char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci             DEFAULT NULL COMMENT 'ISBN',
    `create_time` datetime                                                     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
    `update_time` datetime                                                     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
    `deleted`     bit(1)                                                       NOT NULL DEFAULT b'0' COMMENT 'Is Deleted',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
