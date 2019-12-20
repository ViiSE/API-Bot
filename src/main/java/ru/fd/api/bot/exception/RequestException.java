package ru.fd.api.bot.exception;

public class RequestException extends Exception {

    public RequestException(String message) {
        super(message);
    }

    public RequestException(Exception ex) {
        super(ex);
    }
}
