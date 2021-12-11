package by.bsuir.web.multithreading.server.dao;

import java.io.Serial;

public class PersonnelFileDaoException extends Exception {

    @Serial
    private static final long serialVersionUID = -182932558565756926L;

    public PersonnelFileDaoException() {
    }

    public PersonnelFileDaoException(String message) {
        super(message);
    }

    public PersonnelFileDaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersonnelFileDaoException(Throwable cause) {
        super(cause);
    }
}
