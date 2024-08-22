package br.com.soat8.techchallenge.domain.exception;

public class NotFoundProductException extends RuntimeException {
    public NotFoundProductException(String message) {
        super(message);
    }
}
