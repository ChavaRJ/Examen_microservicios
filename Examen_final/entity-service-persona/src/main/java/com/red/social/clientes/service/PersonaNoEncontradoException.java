package com.red.social.clientes.service;

public class PersonaNoEncontradoException extends RuntimeException {
  private final String id;

  public PersonaNoEncontradoException(String message, String id) {
    super(message);
    this.id = id;
  }

  public static PersonaNoEncontradoException from(String message, String id) {
    return new PersonaNoEncontradoException(message, id);
  }

  public String getId() {
    return id;
  }
}
