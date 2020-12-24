
SET NAMES utf8mb4;

SET FOREIGN_KEY_CHECKS = 0;-- Table structure for eclb_contract
-- ----------------------------
DROP TABLE
IF
	EXISTS `products`;
CREATE TABLE `products` (
	`id` BIGINT ( 20 ) UNSIGNED NOT NULL AUTO_INCREMENT,
	`name` VARCHAR ( 150 ) NOT NULL DEFAULT '' COMMENT '商品名称',
	`sort` BIGINT ( 20 ) NOT NULL DEFAULT 1 COMMENT '排序',
	`no` VARCHAR ( 250 ) NOT NULL DEFAULT '' COMMENT '商品编号',
	`descriptiodn` VARCHAR ( 250 ) NOT NULL DEFAULT '' COMMENT '商品描述',
	`category_id` BIGINT ( 20 ) NOT NULL DEFAULT 1 COMMENT '商品类别id',
	`is_single` TINYINT ( 1 ) NOT NULL DEFAULT TRUE COMMENT '是否可以选规格',
	`support_takeaway` TINYINT ( 1 ) NOT NULL DEFAULT TRUE COMMENT '是否支持外卖',
	`name_image` VARCHAR ( 250 ) NOT NULL DEFAULT '' COMMENT '暂时未知',
	`show_trademark` TINYINT ( 1 ) NOT NULL DEFAULT TRUE COMMENT '是否显示商标',
	`is_premade` VARCHAR ( 2 ) NOT NULL DEFAULT '1' COMMENT '是否预制',
	`remark` VARCHAR ( 250 ) NOT NULL DEFAULT '' COMMENT '备注',
	`is_enable` INTEGER ( 1 ) NOT NULL DEFAULT 1 COMMENT '是否启用',
	`price` DECIMAL DEFAULT 0 NOT NULL COMMENT '单价',
	`tax_rate` FLOAT DEFAULT 0 NOT NULL COMMENT '税率',
	`category_image_url` VARCHAR ( 250 ) NOT NULL DEFAULT '' COMMENT '商品分类图片地址',
	`object_version_number` BIGINT ( 20 ) NOT NULL DEFAULT '1' COMMENT '行版本号，用来处理锁',
	`created_by` BIGINT ( 20 ) NOT NULL DEFAULT '-1' COMMENT '记录创建人',
	`creation_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建日期',
	`last_updated_by` BIGINT ( 20 ) NOT NULL DEFAULT '-1' COMMENT '记录更新人',
	`last_update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录更新日期',
	PRIMARY KEY ( `id` )
) ENGINE = INNODB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8mb4 COMMENT = '商品信息';

SET FOREIGN_KEY_CHECKS = 1;