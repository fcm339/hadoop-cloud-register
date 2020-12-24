
SET NAMES utf8mb4;

SET FOREIGN_KEY_CHECKS = 0;
-- Table structure for eclb_contract
-- ----------------------------
DROP TABLE
IF
	EXISTS `images`;
CREATE TABLE `images` (
	`id` BIGINT ( 20 ) UNSIGNED NOT NULL AUTO_INCREMENT,
	`url` VARCHAR(150)  NOT NULL DEFAULT '' COMMENT '图片地址',
	`object_version_number` BIGINT ( 20 ) NOT NULL DEFAULT '1' COMMENT '行版本号，用来处理锁',
	`created_by` BIGINT ( 20 ) NOT NULL DEFAULT '-1' COMMENT '记录创建人',
	`creation_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建日期',
	`last_updated_by` BIGINT ( 20 ) NOT NULL DEFAULT '-1' COMMENT '记录更新人',
	`last_update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录更新日期',
	PRIMARY KEY ( `id` )
) ENGINE = INNODB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8mb4 COMMENT = '图片表';

SET FOREIGN_KEY_CHECKS = 1;