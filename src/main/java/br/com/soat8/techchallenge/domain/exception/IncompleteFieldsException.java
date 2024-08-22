package br.com.soat8.techchallenge.domain.exception;

public class IncompleteFieldsException extends RuntimeException {
    public IncompleteFieldsException(String message) {
        super(message);
    }
}
