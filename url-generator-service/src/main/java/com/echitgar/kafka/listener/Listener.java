package com.echitgar.kafka.listener;

import static com.echitgar.log.LogManager.LOG;

import com.echitgar.messages.Message;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(id = "listenerURLGenerator", topics = "${message.topic1}")
public class Listener {
  @KafkaHandler
  public void handleSenderMessage(Message msg) {
    LOG.info("URLGenerator listener: Message received: " + msg.message());
  }

  @KafkaHandler
  public void handleSenderMessage(String msg) {
    LOG.info("URLGenerator listener: String received: " + msg);
  }

  @KafkaHandler(isDefault = true)
  public void unknown(Object object) {
    LOG.error("URLGenerator listener: Unknown type received: " + object);
  }
}
