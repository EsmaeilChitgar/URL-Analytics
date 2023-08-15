package com.echitgar.elasticsearch;

import static com.echitgar.common.log.LogManager.LOG;

import com.echitgar.common.model.Message;
import com.echitgar.elasticsearch.service.MessageService;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ElasticsearchResource {
  @Autowired private MessageService messageService;

  public void send(Message message) {
    send(message.toString());
  }

  public void send(String messageString) {
    Message message = new Message(UUID.randomUUID(), "", messageString);
    messageService.save(message);

    LOG.info(
        "URlCounter: send to elasticsearch....................................... "
            + messageString);
  }
}
