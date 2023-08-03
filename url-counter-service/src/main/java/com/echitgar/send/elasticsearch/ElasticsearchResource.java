package com.echitgar.send.elasticsearch;

import com.echitgar.schema.Message;
import jakarta.annotation.PostConstruct;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.xcontent.XContentBuilder;
import org.elasticsearch.xcontent.XContentFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static com.echitgar.common.log.LogManager.LOG;

@Component
public class ElasticsearchResource {
  RestHighLevelClient client;

  @Value("${elastic.host}")
  private String host;

  @Value("${elastic.port}")
  private int port;

  @Value("${elastic.indexName}")
  private String indexName;

  @Value("${elastic.documentType}")
  private String documentType;

  @Value("${elastic.field.name}")
  private String fieldName;

  @PostConstruct
  public void initialize() {
    client = new RestHighLevelClient(RestClient.builder(new HttpHost(host, port, "http")));
  }

  public void send(Message message) {
    send(message.toString());
  }

  public void send(String message) {
    try {
      XContentBuilder builder = XContentFactory.jsonBuilder();
      builder.startObject();
      builder.field(fieldName, message);
      builder.endObject();

      IndexRequest request = new IndexRequest(indexName, documentType).source(builder);

      client.index(request, RequestOptions.DEFAULT);

      LOG.info(
          "URlCounter: send to elasticsearch....................................... " + message);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
