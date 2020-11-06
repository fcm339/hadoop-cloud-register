
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for eclb_contract
-- ----------------------------
DROP TABLE IF EXISTS `gp_zx`;
CREATE TABLE `gp_zx` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `init_price` decimal(20,2) DEFAULT NULL COMMENT '开盘价',
  `current_price` decimal(20,2) DEFAULT NULL COMMENT '当前价',
  `max_price` decimal(20,2) DEFAULT NULL COMMENT '最高价',
  `min_pirce` decimal(20,2) DEFAULT NULL COMMENT '最低价',
  `turnover` decimal(20,2) DEFAULT NULL COMMENT '成交额',
  `number` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '成交数',
  `created_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='伊利股票';

SET FOREIGN_KEY_CHECKS = 1;

ALTER TABLE `gp_zx` ADD yesterday_end_price  decimal(20,2) NOT NULL DEFAULT 0 COMMENT '昨日收盘价' AFTER init_price;

ALTER TABLE `gp_zx` ADD gp_name  VARCHAR(24) NOT NULL DEFAULT "" COMMENT '股票名称' AFTER id;

ALTER TABLE `gp_zx` ADD auction  decimal(20,2) NOT NULL DEFAULT 0 COMMENT '竞卖价，即卖一报价' AFTER number;

ALTER TABLE `gp_zx` ADD bidding_price  decimal(20,2) NOT NULL DEFAULT 0 COMMENT '竞买价，即买一报价' AFTER number;

ALTER TABLE `gp_zx` ADD gp_code  VARCHAR(24) NOT NULL DEFAULT "" COMMENT '股票名称' AFTER gp_name;


-- TRUNCATE gp_zx;
-- SHOW CREATE TABLE gp_zx;