package com.echitgar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@EnableElasticsearchRepositories
@SpringBootApplication
@EnableDiscoveryClient
public class ElasticsearchMonitorServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(ElasticsearchMonitorServiceApplication.class, args);
  }
}
