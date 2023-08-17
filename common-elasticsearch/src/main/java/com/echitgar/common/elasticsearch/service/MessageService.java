package com.echitgar.common.elasticsearch.service;

import co.elastic.clients.elasticsearch._types.query_dsl.Operator;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import com.echitgar.common.elasticsearch.model.ElasticsearchMessage;
import com.echitgar.common.elasticsearch.repository.MessageRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.client.elc.QueryBuilders;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
  @Autowired private MessageRepository messageRepository;
  @Autowired private ElasticsearchOperations elasticsearchOperations;

  public List<ElasticsearchMessage> listAll() {
    return this.messageRepository.findAll();
  }

  public ElasticsearchMessage save(ElasticsearchMessage message) {
    return this.messageRepository.save(message);
  }

  public long count() {
    return this.messageRepository.count();
  }

  public List<ElasticsearchMessage> search(String keywords) {
    Float nonExistingBoost = null;
    // even though it exists in SpringBoot, ElasticSearch has no boost for this type of query
    // when you analyze what matchQuery returns, it also has nothing related to boost
    Query query =
        QueryBuilders.matchQuery("message", keywords, Operator.Or, nonExistingBoost)._toQuery();
    NativeQuery nativeQuery = NativeQuery.builder().withQuery(query).build();
    SearchHits<ElasticsearchMessage> result =
        this.elasticsearchOperations.search(nativeQuery, ElasticsearchMessage.class);
    return result.stream().map(SearchHit::getContent).collect(Collectors.toList());
  }
}
