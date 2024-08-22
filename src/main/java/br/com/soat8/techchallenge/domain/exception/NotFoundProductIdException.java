package br.com.soat8.techchallenge.domain.exception;

public class NotFoundProductIdException extends RuntimeException {
    public NotFoundProductIdException(String message) {
        super(message);
    }
}
