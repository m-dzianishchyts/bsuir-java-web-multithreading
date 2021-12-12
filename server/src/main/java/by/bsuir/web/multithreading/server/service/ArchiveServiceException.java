package by.bsuir.web.multithreading.server.service;

import java.io.Serial;

public class ArchiveServiceException extends Exception {

    @Serial
    private static final long serialVersionUID = 4533290456369436693L;

    public ArchiveServiceException() {
    }

    public ArchiveServiceException(String message) {
        super(message);
    }

    public ArchiveServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArchiveServiceException(Throwable cause) {
        super(cause);
    }
}
