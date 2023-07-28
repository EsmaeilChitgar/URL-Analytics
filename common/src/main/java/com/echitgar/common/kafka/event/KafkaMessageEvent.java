package com.echitgar.common.kafka.event;

import org.springframework.context.ApplicationEvent;

public class KafkaMessageEvent extends ApplicationEvent {
  private final String message;

  public KafkaMessageEvent(Object source, String message) {
    super(source);
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
