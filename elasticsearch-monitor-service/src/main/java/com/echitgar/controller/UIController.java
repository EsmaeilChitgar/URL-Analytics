package com.echitgar.controller;

import com.echitgar.common.model.ElasticsearchMessage;
import com.echitgar.service.MessageService;
import java.util.List;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UIController {
  private MessageService messageService;

  @Autowired
  public UIController(MessageService messageService) {
    this.messageService = messageService;
  }

  // when reload localhost:8080/search
  @GetMapping("/search")
  public String home(Model model) {
    List<ElasticsearchMessage> Messages = this.messageService.search("com");
    List<String> messageStrings =
        Messages.stream().flatMap(message -> Stream.of(message.getMessage())).toList();
    model.addAttribute("names", messageStrings);
    return "search";
  }
}
