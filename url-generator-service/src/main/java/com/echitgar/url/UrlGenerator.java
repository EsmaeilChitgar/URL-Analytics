package com.echitgar.url;

import java.util.Random;

public class UrlGenerator {
  private int sizeOfRepository = 10000;

  private Random random;

  public UrlGenerator() {
    this.random = new Random();
  }

  public String generateUrl() {
    return "http://com.example/" + random.nextInt(sizeOfRepository + 1);
  }
}
