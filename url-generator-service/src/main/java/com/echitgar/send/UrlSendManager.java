package com.echitgar.send;

import static com.echitgar.log.LogManager.LOG;

import com.echitgar.messages.Message;
import com.echitgar.url.UrlGenerator;
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

  private final ScheduledExecutorService scheduler;

  @Value(value = "${message.topic1}")
  private String topicUrl;

  @Autowired private KafkaTemplate<String, Object> kafkaTemplate;

  public UrlSendManager() {
    this.urlGenerator = new UrlGenerator();
    scheduler = Executors.newSingleThreadScheduledExecutor();
  }

  @Bean
  public void send() {
    scheduler.scheduleAtFixedRate(
        () -> {
          Message message = new Message(urlGenerator.generateUrl());
          kafkaTemplate.send(topicUrl, message.message());
          LOG.info("URLGeneratorServiceApplication sends url: " + message);
        },
        1,
        1,
        TimeUnit.SECONDS);
  }
}
