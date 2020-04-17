package com.hzl.hadoop.mq.rocketmq.config;

import com.hzl.hadoop.mq.rocketmq.channel.InputChannel;
import com.hzl.hadoop.mq.rocketmq.channel.OutputChannel;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

/**
 * description
 *
 * @author hzl 2020/03/25 4:25 PM
 */

@Configuration
@EnableBinding({InputChannel.class, OutputChannel.class})
public class MessageConfig {

}
