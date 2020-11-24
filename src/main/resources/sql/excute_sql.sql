
SET NAMES utf8mb4;

SET FOREIGN_KEY_CHECKS = 0;-- ----------------------------
-- Table structure for eclb_contract
-- ----------------------------
DROP TABLE
IF
	EXISTS `excute_sql`;
CREATE TABLE `excute_sql` (
	`id` BIGINT ( 20 ) UNSIGNED NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(150) DEFAULT NULL COMMENT '功能名称',
	`sql_string` VARCHAR(10000) DEFAULT NULL COMMENT 'sql字符串',
	`object_version_number` BIGINT ( 20 ) NOT NULL DEFAULT '1' COMMENT '行版本号，用来处理锁',
	`created_by` BIGINT ( 20 ) NOT NULL DEFAULT '-1' COMMENT '记录创建人',
	`creation_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建日期',
	`last_updated_by` BIGINT ( 20 ) NOT NULL DEFAULT '-1' COMMENT '记录更新人',
	`last_update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录更新日期',
	PRIMARY KEY ( `id` )
) ENGINE = INNODB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8mb4 COMMENT = '伊利股票';
DROP TABLE
IF
	EXISTS `excute_sql_oauth`;
CREATE TABLE `excute_sql_oauth` (
	`id` BIGINT ( 20 ) UNSIGNED NOT NULL AUTO_INCREMENT,
	`sql_id` BIGINT ( 20, 2 ) DEFAULT NULL COMMENT 'excute_sql的主键',
	`employee_num` VARCHAR ( 128 ) DEFAULT NULL COMMENT '员工编号',
	`object_version_number` BIGINT ( 20 ) NOT NULL DEFAULT '1' COMMENT '行版本号，用来处理锁',
	`created_by` BIGINT ( 20 ) NOT NULL DEFAULT '-1' COMMENT '记录创建人',
	`creation_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建日期',
	`last_updated_by` BIGINT ( 20 ) NOT NULL DEFAULT '-1' COMMENT '记录更新人',
	`last_update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录更新日期',
	PRIMARY KEY ( `id` )
) ENGINE = INNODB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8mb4 COMMENT = '伊利股票';

SET FOREIGN_KEY_CHECKS = 1;