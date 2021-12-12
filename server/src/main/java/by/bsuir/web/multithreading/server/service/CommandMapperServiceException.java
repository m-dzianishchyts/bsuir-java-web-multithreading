package by.bsuir.web.multithreading.server.service;

import java.io.Serial;

public class CommandMapperServiceException extends Exception {

    @Serial
    private static final long serialVersionUID = 3540576539895576834L;

    public CommandMapperServiceException() {
    }

    public CommandMapperServiceException(String message) {
        super(message);
    }

    public CommandMapperServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommandMapperServiceException(Throwable cause) {
        super(cause);
    }
}
