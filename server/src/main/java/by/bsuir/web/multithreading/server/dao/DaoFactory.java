package by.bsuir.web.multithreading.server.dao;

import by.bsuir.web.multithreading.server.dao.impl.XmlPersonnelFileDaoImpl;

/**
 * Factory class for DAO providing.
 */
public final class DaoFactory {

    private static DaoFactory instance;

    private PersonnelFileDao personnelFileDAO;

    private DaoFactory() {
    }

    /**
     * Synchronized access point to {@link DaoFactory}.
     *
     * @return factory instance
     */
    public static synchronized DaoFactory getInstance() {
        if (instance == null) {
            instance = new DaoFactory();
        }
        return instance;
    }

    /**
     * Synchronized access point to {@link PersonnelFileDao}.
     *
     * @return {@link PersonnelFileDao} instance
     */
    public synchronized PersonnelFileDao getPersonnelFileDao() {
        if (personnelFileDAO == null) {
            personnelFileDAO = new XmlPersonnelFileDaoImpl();
        }
        return personnelFileDAO;
    }
}
