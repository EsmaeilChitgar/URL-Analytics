package com.echitgar.kafka.event;

import static com.echitgar.common.log.LogManager.LOG;

import com.echitgar.common.elasticsearch.model.ElasticsearchMessage;
import com.echitgar.common.kafka.event.KafkaMessageEvent;
import com.echitgar.elasticsearch.ElasticsearchResource;
import com.echitgar.schema.Message;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessageEventListener implements ApplicationListener<KafkaMessageEvent> {
  @Autowired private ElasticsearchResource elasticsearchResource;

  @Override
  public void onApplicationEvent(KafkaMessageEvent event) {
    Message kafkaMessage = event.getMessage();
    ElasticsearchMessage elasticsearchMessage =
        ElasticsearchMessage.builder()
            .id(UUID.randomUUID())
            .message(kafkaMessage.getMessage())
            .description(kafkaMessage.getDescription())
            .build();
    elasticsearchResource.send(elasticsearchMessage);

    LOG.info("Receive message in event listener: " + kafkaMessage);
  }
}
