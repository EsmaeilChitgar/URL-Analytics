package com.echitgar.common.elasticsearch.repository;

import com.echitgar.common.elasticsearch.model.ElasticsearchMessage;
import java.util.List;
import java.util.UUID;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.stereotype.Repository;

@EnableElasticsearchRepositories
@Repository
public interface MessageRepository extends ElasticsearchRepository<ElasticsearchMessage, UUID> {
  List<ElasticsearchMessage> findAll();
}
