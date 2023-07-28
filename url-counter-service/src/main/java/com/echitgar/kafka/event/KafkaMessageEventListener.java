package com.echitgar.kafka.event;

import static com.echitgar.common.log.LogManager.LOG;

import com.echitgar.common.kafka.event.KafkaMessageEvent;
import com.echitgar.send.elasticsearch.ElasticsearchResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessageEventListener implements ApplicationListener<KafkaMessageEvent> {
  @Autowired private ElasticsearchResource elasticsearchResource;

  @Override
  public void onApplicationEvent(KafkaMessageEvent event) {
    String message = event.getMessage();
    elasticsearchResource.send(message);

    LOG.info("recieve message in event listener: " + event.getMessage());
  }
}
