package com.echitgar.repository;

import com.echitgar.common.model.User;
import java.util.List;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.stereotype.Repository;

@EnableElasticsearchRepositories
@Repository
public interface UserRepository extends ElasticsearchRepository<User, Long> {
  List<User> findAll();
}
