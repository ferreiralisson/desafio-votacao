CREATE TABLE `address` (
    `id`    bigint NOT NULL AUTO_INCREMENT,
    `cep` varchar(8) DEFAULT NULL,
    `state` varchar(255) DEFAULT NULL,
    `city` varchar(255) DEFAULT NULL,
    `neighborhood` varchar(255) DEFAULT NULL,
    `street` varchar(255) DEFAULT NULL,
    `service` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;