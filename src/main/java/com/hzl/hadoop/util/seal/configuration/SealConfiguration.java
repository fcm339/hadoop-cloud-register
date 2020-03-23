package com.hzl.hadoop.util.seal.configuration;

import lombok.*;

import java.awt.*;

/**
 * @Description: 印章配置类
 * @Author Ran.chunlin
 * @Date: Created in 12:17 2018-10-04
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SealConfiguration {
    /**
     * 主文字
     */
    private SealFont mainFont;
    /**
     * 副文字
     */
    private SealFont viceFont;
    /**
     * 抬头文字
     */
    private SealFont titleFont;
    /**
     * 中心文字
     */
    private SealFont centerFont;
    /**
     * 边线圆
     */
    private SealCircle borderCircle;
    /**
     * 内边线圆
     */
    private SealCircle borderInnerCircle;
    /**
     * 内线圆
     */
    private SealCircle innerCircle;
    /**
     * 背景色，默认红色
     */
    private Color backgroudColor = Color.RED;
    /**
     * 图片输出尺寸，默认300
     */
    private Integer imageSize = 300;


}
