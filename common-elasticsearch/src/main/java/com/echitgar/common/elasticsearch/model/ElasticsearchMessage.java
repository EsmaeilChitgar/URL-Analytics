package com.echitgar.common.elasticsearch.model;

import com.echitgar.schema.Message;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "messageindex")
@Setting(settingPath = "es-config/elastic-analyzer.json")
public class ElasticsearchMessage extends Message {
  @Id private UUID id;
  private String description;

  @Field(
      type = FieldType.Text,
      analyzer = "autocomplete_index",
      searchAnalyzer = "autocomplete_search")
  private String message;
}
