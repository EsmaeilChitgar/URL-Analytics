package com.sampledomain;

import com.sampledomain.bootstrap.BootstrapService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
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
