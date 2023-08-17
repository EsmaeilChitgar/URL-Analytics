package com.echitgar.common.kafka.listener;

import static com.echitgar.common.log.LogManager.LOG;

import com.echitgar.common.kafka.event.KafkaMessageEvent;
import com.echitgar.common.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(id = "${spring.application.name}-listener-id", topics = "${kafka.topic1}")
public class Listener {
  @Autowired private ApplicationEventPublisher applicationEventPublisher;

  @KafkaHandler
  public void handleSenderMessage(Message message) {
    LOG.info("listener: Message received: " + message.getMessage());
  }

  @KafkaHandler
  public void handleSenderMessage(String message) {
    LOG.info("listener: String received: " + message);

    KafkaMessageEvent event = new KafkaMessageEvent(this, message);
    applicationEventPublisher.publishEvent(event);
  }

  @KafkaHandler(isDefault = true)
  public void unknown(Object object) {
    LOG.warn("listener: Unknown type received: " + object);

    KafkaMessageEvent event = new KafkaMessageEvent(this, "Unknown type received: " + object);
    applicationEventPublisher.publishEvent(event);
  }
}