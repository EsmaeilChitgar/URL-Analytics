package com.sampledomain.listener;

import com.sampledomain.messages.Message;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(id = "listenerURLGenerator", topics = "${message.topic1}")
public class Listener {
  @KafkaHandler
  public void handleSenderMessage(Message msg) {
    System.out.println("URLGenerator listener: Message received: " + msg.message());
  }

  @KafkaHandler(isDefault = true)
  public void unknown(Object object) {
    System.out.println("URLGenerator listener: Unknown type received: " + object);
  }
}
