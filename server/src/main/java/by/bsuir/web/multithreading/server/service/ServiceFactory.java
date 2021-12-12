package by.bsuir.web.multithreading.server.service;

import by.bsuir.web.multithreading.server.dao.PersonnelFileDao;
import by.bsuir.web.multithreading.server.dao.impl.XmlPersonnelFileDaoImpl;
import by.bsuir.web.multithreading.server.service.impl.AdminStringCommandMapperServiceImpl;
import by.bsuir.web.multithreading.server.service.impl.ArchiveServiceImpl;
import by.bsuir.web.multithreading.server.service.impl.CommandMappingContext;
import by.bsuir.web.multithreading.server.service.impl.StringCommandMapperService;

import java.io.PrintWriter;

/**
 * Factory class for providing services.
 */
public final class ServiceFactory {

    public static final String CLIENT_COMMAND_MAPPER_SERVICE_NAME = "client";
    public static final String SERVER_COMMAND_MAPPER_SERVICE_NAME = "server";
    private static ServiceFactory instance;

    private ArchiveService applianceService;
    private CommandMapperService commandMapperService;
    private CommandMapperService serverCommandMapperService;

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

    /**
     * Synchronized access point to {@link CommandMapperService}.
     *
     * @return {@link CommandMapperService} instance
     */
    public synchronized CommandMapperService getCommandMapperService(String name, PrintWriter writer) {
        if (name.equals(CLIENT_COMMAND_MAPPER_SERVICE_NAME)) {
            if (commandMapperService == null) {
                CommandMappingContext commandMappingContext = new CommandMappingContext(getArchiveService(), writer);
                commandMapperService = new StringCommandMapperService(commandMappingContext);
            }
            return commandMapperService;
        } else if (name.equals(SERVER_COMMAND_MAPPER_SERVICE_NAME)) {
            if (serverCommandMapperService == null) {
                CommandMappingContext commandMappingContext = new CommandMappingContext(getArchiveService(), writer);
                serverCommandMapperService = new AdminStringCommandMapperServiceImpl(commandMappingContext);
            }
            return serverCommandMapperService;
        } else {
            throw new IllegalArgumentException("Unknown " + CommandMapperService.class.getName() + " name.");
        }
    }
}
