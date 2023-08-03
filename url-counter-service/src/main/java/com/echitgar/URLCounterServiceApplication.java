package com.echitgar;

import com.echitgar.common.kafka.listener.Listener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableDiscoveryClient
@Import(value = {Listener.class})
public class URLCounterServiceApplication {
  public static void main(String[] args) {
    SpringApplication.run(URLCounterServiceApplication.class, args);
  }
}
