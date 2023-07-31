package com.echitgar.send.elasticsearch;

import static com.echitgar.common.log.LogManager.LOG;

import com.echitgar.schema.Message;
import java.io.IOException;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.xcontent.XContentBuilder;
import org.elasticsearch.xcontent.XContentFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ElasticsearchResource {
  RestHighLevelClient client;

  @Value("${elasticsearch.host}")
  private String host;

  @Value("${elasticsearch.port}")
  private Integer port;

  @Value("${elasticsearch.indexName}")
  private String indexName;

  @Value("${elasticsearch.documentType}")
  private String documentType;

  @Value("${elasticsearch.field.name}")
  private String fieldName;

  public ElasticsearchResource() {
    client =
        new RestHighLevelClient(
            RestClient.builder(new HttpHost(host, port, "http")));
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
