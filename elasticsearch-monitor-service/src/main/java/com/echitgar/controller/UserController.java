package com.echitgar.controller;

import com.echitgar.common.model.User;
import com.echitgar.service.UserService;
import java.util.List;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
  @Autowired private UserService userService;

  @GetMapping
  public List<User> getAllUsers() {
    return this.userService.listAll();
  }

  @GetMapping(path = "/query")
  @ResponseBody
  public List<User> searchUsers(@RequestParam String keywords) {
    return this.userService.search(keywords);
  }

  @GetMapping("/suggestion")
  @ResponseBody
  public List<String> fetchSuggestions(@RequestParam(value = "q", required = false) String query) {
    List<User> users = this.userService.search(query);
    return users.stream().flatMap(user -> Stream.of(user.getCountry())).toList();
  }
}
