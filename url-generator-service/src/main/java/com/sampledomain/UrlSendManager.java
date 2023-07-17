package com.sampledomain;

import com.sampledomain.messages.Message;
import com.sampledomain.url.UrlGenerator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

@Configuration
public class UrlSendManager {
  private final UrlGenerator urlGenerator;

  @Value(value = "${message.topic1}")
  private String topicUrl;

  @Autowired private KafkaTemplate<String, Object> kafkaTemplate;

  public UrlSendManager() {
    this.urlGenerator = new UrlGenerator();
  }

  @Bean
  public void send() {
    ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    scheduler.scheduleAtFixedRate(
        () -> {
          var message = new Message(urlGenerator.generateUrl());
          System.out.println("URLGeneratorServiceApplication sends url: " + message);
          kafkaTemplate.send(topicUrl, message);
        },
        1,
        1,
        TimeUnit.SECONDS);
  }
}
