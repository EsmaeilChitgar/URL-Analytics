package com.echitgar.kafka.listener;

import static com.echitgar.log.LogManager.LOG;

import com.echitgar.messages.Message;
import com.echitgar.send.elasticsearch.ElasticsearchResource;
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
    LOG.info("URLCounter listener: Message received: " + message.message());
    elasticsearchResource.send(message);
  }

  @KafkaHandler
  public void handleSenderMessage(String message) {
    LOG.info("URLCounter listener: String received: " + message);
    elasticsearchResource.send(message);
  }

  @KafkaHandler(isDefault = true)
  public void unknown(Object object) {
    LOG.warn("URLCounter listener: Unknown type received: " + object);
  }
}
