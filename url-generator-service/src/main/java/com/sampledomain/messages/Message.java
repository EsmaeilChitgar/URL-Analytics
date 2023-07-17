package com.sampledomain.messages;

import java.util.Objects;

public final class Message {
  private final String message;

  public Message(String message) {
    this.message = message;
  }

  public String message() {
    return message;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (obj == null || obj.getClass() != this.getClass()) return false;
    var that = (Message) obj;
    return Objects.equals(this.message, that.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message);
  }

  @Override
  public String toString() {
    return "Message[" + "message=" + message + ']';
  }
}
