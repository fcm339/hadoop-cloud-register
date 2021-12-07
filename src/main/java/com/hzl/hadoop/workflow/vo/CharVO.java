package com.hzl.hadoop.workflow.vo;

import lombok.*;

import java.util.List;

/**
 * description
 *
 * @author hzl 2021/11/24 9:28 AM
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CharVO {

	List<CharNodeVO> nodes;

	List<CharConnectionVO> connections;
}
