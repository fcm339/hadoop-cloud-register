
SET NAMES utf8mb4;

SET FOREIGN_KEY_CHECKS = 0;
-- Table structure for eclb_contract
-- ----------------------------
DROP TABLE
IF
	EXISTS `products`;
CREATE TABLE `products` (
	`id` BIGINT ( 20 ) UNSIGNED NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(150)  NOT NULL DEFAULT '' COMMENT '商品名称',
	`sort` BIGINT(20)  NOT NULL DEFAULT 1 COMMENT '排序',
	`no` VARCHAR(250)  NOT NULL DEFAULT ''  COMMENT '商品编号',
  `descriptiodn` VARCHAR(250)  NOT NULL DEFAULT ''  COMMENT '商品描述',
  `category_id` BIGINT ( 20 ) NOT NULL DEFAULT 1 COMMENT '商品类别id',
  `is_single` tinyint(1) NOT NULL DEFAULT true COMMENT '是否可以选规格',




	`category_image_url` VARCHAR(250)  NOT NULL DEFAULT ''  COMMENT '商品分类图片地址',
	`object_version_number` BIGINT ( 20 ) NOT NULL DEFAULT '1' COMMENT '行版本号，用来处理锁',
	`created_by` BIGINT ( 20 ) NOT NULL DEFAULT '-1' COMMENT '记录创建人',
	`creation_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建日期',
	`last_updated_by` BIGINT ( 20 ) NOT NULL DEFAULT '-1' COMMENT '记录更新人',
	`last_update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录更新日期',
	PRIMARY KEY ( `id` )
) ENGINE = INNODB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8mb4 COMMENT = '商品信息';

SET FOREIGN_KEY_CHECKS = 1;