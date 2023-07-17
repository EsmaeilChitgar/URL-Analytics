package com.sampledomain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class URLGeneratorServiceApplication {
  public static void main(String[] args) {
    SpringApplication.run(URLGeneratorServiceApplication.class, args);

    UrlSendManager urlSendManager = new UrlSendManager();
    urlSendManager.send();
  }
}
