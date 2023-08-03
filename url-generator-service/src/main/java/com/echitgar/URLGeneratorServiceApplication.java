package com.echitgar;

import com.echitgar.bootstrap.BootstrapService;
import com.echitgar.common.kafka.listener.Listener;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableDiscoveryClient
@Import(value = {Listener.class})
public class URLGeneratorServiceApplication {
  @Autowired BootstrapService bootstrapService;

  public static void main(String[] args) {
    SpringApplication.run(URLGeneratorServiceApplication.class, args);
  }

  @PostConstruct
  public void initialize() {
    bootstrapService.run();
  }
}
