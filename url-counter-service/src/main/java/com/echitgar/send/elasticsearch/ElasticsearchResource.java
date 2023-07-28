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
import org.springframework.stereotype.Component;

@Component
public class ElasticsearchResource {
  RestHighLevelClient client;

  public ElasticsearchResource() {
    String elasticsearchHost = "localhost";
    int elasticsearchPort = 9200;
    client =
        new RestHighLevelClient(
            RestClient.builder(new HttpHost(elasticsearchHost, elasticsearchPort, "http")));
  }

  public void send(Message message) {
    send(message.toString());
  }

  public void send(String message) {
    try {
      XContentBuilder builder = XContentFactory.jsonBuilder();
      builder.startObject();
      builder.field("message", message);
      builder.endObject();

      String indexName = "my_index";
      String documentType = "_doc";
      IndexRequest request = new IndexRequest(indexName, documentType).source(builder);

      client.index(request, RequestOptions.DEFAULT);

      LOG.info(
          "URlCounter: send to elasticsearch....................................... " + message);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
