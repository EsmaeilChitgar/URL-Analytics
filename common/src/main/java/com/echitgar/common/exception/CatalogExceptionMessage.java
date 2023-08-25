package com.echitgar.common.exception;

public final class CatalogExceptionMessage {
  public static final String ENTITY_ALREADY_EXISTS = "Entity already exists";

  private CatalogExceptionMessage() {}

  public static String invalidCharacter(String character) {
    return String.format("%s is invalid character.", character);
  }
}
