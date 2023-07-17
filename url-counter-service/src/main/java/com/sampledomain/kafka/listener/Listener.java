package com.sampledomain.kafka.listener;

import com.sampledomain.messages.Message;
import com.sampledomain.send.elasticsearch.ElasticsearchResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(id = "listenerURLCounter", topics = "${message.topic1}")
public class Listener {
  @Autowired private ElasticsearchResource elasticsearchResource;

  @KafkaHandler
  public void handleSenderMessage(Message message) {
    System.out.println("URLCounter listener: Message received: " + message.message());
    elasticsearchResource.send(message);
  }

  @KafkaHandler
  public void handleSenderMessage(String message) {
    System.out.println("URLCounter listener: String received: " + message);
    elasticsearchResource.send(message);
  }

  @KafkaHandler(isDefault = true)
  public void unknown(Object object) {
    System.out.println("URLCounter listener: Unknown type received: " + object);
  }
}
