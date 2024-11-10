CREATE DATABASE IF NOT EXISTS order_db;
USE order_db;
CREATE TABLE IF NOT EXISTS order_tbl
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id     INT,
    product_id  INT,
    count       INT,
    amount      DECIMAL(8, 2),
    status      INT,
    create_time DATETIME,
    update_time DATETIME
);

-- UNDO_LOG table
-- 注意此处0.7.0+ 增加字段 context
CREATE TABLE `undo_log`
(
    `id`            bigint(20)   NOT NULL AUTO_INCREMENT,
    `branch_id`     bigint(20)   NOT NULL,
    `xid`           varchar(100) NOT NULL,
    `context`       varchar(128) NOT NULL,
    `rollback_info` longblob     NOT NULL,
    `log_status`    int(11)      NOT NULL,
    `log_created`   datetime     NOT NULL,
    `log_modified`  datetime     NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `ux_undo_log` (`xid`, `branch_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

CREATE DATABASE IF NOT EXISTS inventory_db;
USE inventory_db;
CREATE TABLE IF NOT EXISTS inventory_tbl
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    product_id  INT,
    total       INT,
    used        INT,
    residue     INT COMMENT '剩余库存数量',
    create_time DATETIME,
    update_time DATETIME
);
INSERT INTO inventory_tbl (product_id, total, used, residue, create_time, update_time)
VALUES (1, 100, 20, 80, NOW(), NOW()),
       (2, 200, 50, 150, NOW(), NOW()),
       (3, 300, 100, 200, NOW(), NOW());
-- UNDO_LOG Table
-- 注意此处0.7.0+ 增加字段 context
CREATE TABLE `undo_log`
(
    `id`            bigint(20)   NOT NULL AUTO_INCREMENT,
    `branch_id`     bigint(20)   NOT NULL,
    `xid`           varchar(100) NOT NULL,
    `context`       varchar(128) NOT NULL,
    `rollback_info` longblob     NOT NULL,
    `log_status`    int(11)      NOT NULL,
    `log_created`   datetime     NOT NULL,
    `log_modified`  datetime     NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `ux_undo_log` (`xid`, `branch_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;