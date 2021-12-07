package com.hzl.hadoop.workflow.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description
 * 前端流程图连接关系实体类
 * @author hzl 2021/11/24 9:27 AM
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CharConnectionVO {

	private String connectionId;

	private String pageSourceId;

	private String pageTargetId;
}
