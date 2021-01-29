package com.rainlf.ms.shopgoods.infrastucture.message;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

/**
 * @author : rain
 * @date : 2021/1/29 12:00
 */
@Configuration
@EnableBinding(MessageTopic.class)
public class MessageConfig {
}
