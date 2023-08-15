package com.echitgar.common.model;

import java.util.UUID;
import lombok.*;
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
public class Message {
  @Id private UUID id;
  private String description;

  @Field(
      type = FieldType.Text,
      analyzer = "autocomplete_index",
      searchAnalyzer = "autocomplete_search")
  private String message;
}
