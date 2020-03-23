package com.hzl.hadoop.util.seal.configuration;

import lombok.*;

/**
 * @Description: 印章圆圈类
 * @Author Ran.chunlin
 * @Date: Created in 15:41 2018-10-04
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SealCircle {

	/**
	 * 线宽度
	 */
	private Integer lineSize;
	/**
	 * 半径
	 */
	private Integer width;
	/**
	 * 半径
	 */
	private Integer height;

}
