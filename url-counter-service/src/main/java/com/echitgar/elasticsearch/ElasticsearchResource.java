package com.echitgar.elasticsearch;

import static com.echitgar.common.log.LogManager.LOG;

import com.echitgar.common.elasticsearch.model.ElasticsearchMessage;
import com.echitgar.common.elasticsearch.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ElasticsearchResource {
  @Autowired private MessageService messageService;

  public void send(ElasticsearchMessage message) {
    messageService.save(message);
    LOG.info("URlCounter: send to elasticsearch....................................... " + message);
  }
}
