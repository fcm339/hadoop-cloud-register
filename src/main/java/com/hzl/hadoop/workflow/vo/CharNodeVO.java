package com.hzl.hadoop.workflow.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description
 * 前端流程图节点实体类
 *
 * @author hzl 2021/11/24 9:24 AM
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CharNodeVO {

	private String name;

	private int nodeType;

	private String nodeId;

	private int positionX;

	private int positionY;

	private String className;

	private boolean removable;
}
