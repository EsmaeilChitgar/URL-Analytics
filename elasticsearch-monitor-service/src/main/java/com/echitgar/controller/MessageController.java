package com.echitgar.controller;

import com.echitgar.common.elasticsearch.model.ElasticsearchMessage;
import com.echitgar.common.elasticsearch.service.MessageService;
import java.util.List;
import java.util.stream.Stream;

import com.echitgar.common.exception.web.api.InvalidRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class MessageController {
  @Autowired private MessageService messageService;

  @GetMapping
  public List<ElasticsearchMessage> getAllMessages() {
    return this.messageService.listAll();
  }

  @GetMapping(path = "/query")
  @ResponseBody
  public List<ElasticsearchMessage> searchMessages(@RequestParam String keywords) {
    return this.messageService.search(keywords);
  }

  @GetMapping("/suggestion")
  @ResponseBody
  public List<String> fetchSuggestions(@RequestParam(value = "q", required = false) String query) {
    //An example of how throw an exception with status code and message
    if (query.contains("@")){
      throw new InvalidRequestException(HttpStatus.FORBIDDEN, "@ not allowed");
    }

    List<ElasticsearchMessage> messages = this.messageService.search(query);
    return messages.stream().flatMap(message -> Stream.of(message.getMessage())).toList();
  }
}
