package com.hzl.hadoop.config.mybatis;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * description
 * 自动填充
 * https://baomidou.com/guide/auto-fill-metainfo.html
 *
 * @author hzl 2021/11/03 6:09 PM
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

	@Override
	public void insertFill(MetaObject metaObject) {
		this.strictInsertFill(metaObject, "createTime", () -> LocalDateTime.now(), LocalDateTime.class);
		this.strictInsertFill(metaObject, "updateTime", () -> LocalDateTime.now(), LocalDateTime.class);

		this.strictInsertFill(metaObject, "createBy", Long.class, 0L);
		this.strictInsertFill(metaObject, "tenantId", Long.class, 0L);
		this.strictInsertFill(metaObject, "versionNum", Integer.class, 0);
		this.strictInsertFill(metaObject, "updateBy", Long.class, 0L);


	}

	@Override
	public void updateFill(MetaObject metaObject) {
		this.strictInsertFill(metaObject, "updateTime", () -> LocalDateTime.now(), LocalDateTime.class);

		this.strictInsertFill(metaObject, "versionNum", Integer.class, 0);

		this.strictInsertFill(metaObject, "updateBy", Long.class, 0L);


	}
}
