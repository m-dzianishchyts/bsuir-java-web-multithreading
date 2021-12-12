package by.bsuir.web.multithreading.server.command;

import java.io.Serial;

public class CommandException extends Exception {

    @Serial
    private static final long serialVersionUID = 2356399458685854416L;

    public CommandException() {
    }

    public CommandException(String message) {
        super(message);
    }

    public CommandException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommandException(Throwable cause) {
        super(cause);
    }
}
