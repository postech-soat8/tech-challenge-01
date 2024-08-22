package br.com.soat8.techchallenge.domain.exception;

public class CpfNotExistsException extends RuntimeException {
    public CpfNotExistsException(String message) {
        super(message);
    }
}
