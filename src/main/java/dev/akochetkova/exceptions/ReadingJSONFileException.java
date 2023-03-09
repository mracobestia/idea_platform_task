package dev.akochetkova.exceptions;

import lombok.Getter;

@Getter
public class ReadingJSONFileException extends RuntimeException {

    private final String errorMessage;

    public ReadingJSONFileException(String message) {
        this.errorMessage = message;
    }
}
