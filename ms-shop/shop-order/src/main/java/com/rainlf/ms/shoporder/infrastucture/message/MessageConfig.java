package com.rainlf.ms.shoporder.infrastucture.message;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

/**
 * @author : rain
 * @date : 2021/1/29 11:21
 */
@Configuration
@EnableBinding(MessageTopic.class)
public class MessageConfig {
}
