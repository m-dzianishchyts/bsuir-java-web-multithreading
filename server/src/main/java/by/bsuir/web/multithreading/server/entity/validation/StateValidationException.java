package by.bsuir.web.multithreading.server.entity.validation;

import java.io.Serial;

public class StateValidationException extends Exception {

    @Serial
    private static final long serialVersionUID = 5470561642854709353L;

    public StateValidationException() {
    }

    public StateValidationException(String message) {
        super(message);
    }

    public StateValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public StateValidationException(Throwable cause) {
        super(cause);
    }
}
