package com.echitgar.common.kafka.event;

import com.echitgar.schema.Message;
import org.springframework.context.ApplicationEvent;

public class KafkaMessageEvent extends ApplicationEvent {
  private final Message message;

  public KafkaMessageEvent(Object source, Message message) {
    super(source);
    this.message = message;
  }

  public Message getMessage() {
    return message;
  }
}
