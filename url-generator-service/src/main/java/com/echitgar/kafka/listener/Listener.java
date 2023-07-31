package com.echitgar.kafka.listener;

import static com.echitgar.common.log.LogManager.LOG;

import com.echitgar.schema.Message;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(id = "url-generator-listener-id", topics = "${kafka.topic1}")
public class Listener {
  @KafkaHandler
  public void handleSenderMessage(Message message) {
    LOG.info("listener: Message received: " + message.getMessage());
  }

  @KafkaHandler
  public void handleSenderMessage(String message) {
    LOG.info("listener: String received: " + message);
  }

  @KafkaHandler(isDefault = true)
  public void unknown(Object object) {
    LOG.warn("listener: Unknown type received: " + object);
  }
}
