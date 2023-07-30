package com.echitgar;

import com.echitgar.bootstrap.BootstrapService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
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
