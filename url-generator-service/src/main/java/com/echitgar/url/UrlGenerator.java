package com.echitgar.url;

import java.util.Random;

public class UrlGenerator {
  private int sizeOfRepository = 10000;

  private Random random;

  public UrlGenerator() {
    this.random = new Random();
  }

  public String generateUrl() {
    return "http://echitgar/" + random.nextInt(sizeOfRepository + 1);
  }
}
