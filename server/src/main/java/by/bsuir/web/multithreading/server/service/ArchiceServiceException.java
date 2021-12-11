package by.bsuir.web.multithreading.server.service;

import java.io.Serial;

public class ArchiceServiceException extends Exception {

    @Serial
    private static final long serialVersionUID = 4533290456369436693L;

    public ArchiceServiceException() {
    }

    public ArchiceServiceException(String message) {
        super(message);
    }

    public ArchiceServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArchiceServiceException(Throwable cause) {
        super(cause);
    }
}
