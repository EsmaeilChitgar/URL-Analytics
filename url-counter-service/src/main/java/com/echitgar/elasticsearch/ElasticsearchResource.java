package com.echitgar.elasticsearch;

import static com.echitgar.common.log.LogManager.LOG;

import com.echitgar.common.model.User;
import com.echitgar.elasticsearch.service.UserService;
import com.echitgar.schema.Message;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ElasticsearchResource {
  @Autowired private UserService userService;

  public void send(Message message) {
    send(message.toString());
  }

  public void send(String message) {
    User user = new User();
    user.setFirstName("firstname");
    user.setLastName("lastname");
    user.setCountry(message);
    user.setId(UUID.randomUUID().toString());
    userService.save(user);

    LOG.info("URlCounter: send to elasticsearch....................................... " + message);
  }
}
