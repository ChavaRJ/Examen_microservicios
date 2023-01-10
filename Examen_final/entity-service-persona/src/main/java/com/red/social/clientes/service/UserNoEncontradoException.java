package com.red.social.clientes.service;

public class UserNoEncontradoException extends RuntimeException {
  private final String id;

  public UserNoEncontradoException(String message, String id) {
    super(message);
    this.id = id;
  }

  public static UserNoEncontradoException from(String message, String id) {
    return new UserNoEncontradoException(message, id);
  }

  public String getId() {
    return id;
  }
}
