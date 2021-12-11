package by.bsuir.web.multithreading.server.service;

import by.bsuir.web.multithreading.server.dao.PersonnelFileDao;
import by.bsuir.web.multithreading.server.dao.impl.XmlPersonnelFileDaoImpl;
import by.bsuir.web.multithreading.server.service.impl.ArchiveServiceImpl;

/**
 * Factory class for providing services.
 */
public final class ServiceFactory {

    private static ServiceFactory instance;

    private ArchiveService applianceService;

    private ServiceFactory() {
    }

    /**
     * Synchronized access point to {@link ServiceFactory}.
     *
     * @return factory instance
     */
    public static synchronized ServiceFactory getInstance() {
        if (instance == null) {
            instance = new ServiceFactory();
        }
        return instance;
    }

    /**
     * Synchronized access point to {@link ArchiveService}.
     *
     * @return {@link ArchiveService} instance
     */
    public synchronized ArchiveService getArchiveService() {
        if (applianceService == null) {
            PersonnelFileDao personnelFileDao = new XmlPersonnelFileDaoImpl();
            applianceService = new ArchiveServiceImpl(personnelFileDao);
        }
        return applianceService;
    }
}
