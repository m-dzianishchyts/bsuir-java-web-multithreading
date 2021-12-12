package by.bsuir.web.multithreading.server.command;

import by.bsuir.web.multithreading.common.UserRole;
import by.bsuir.web.multithreading.server.service.ArchiveService;

import java.io.PrintWriter;

public abstract class AbstractArchiveCommand implements Command {

    protected static final String NOT_ENOUGH_PERMISSIONS_MESSAGE = "You have no permissions to perform this operation.";

    protected final ArchiveService archiveService;
    protected final PrintWriter writer;
    protected final UserRole userRole;

    protected AbstractArchiveCommand(ArchiveService archiveService, PrintWriter writer, UserRole userRole) {
        this.archiveService = archiveService;
        this.writer = writer;
        this.userRole = userRole;
    }
}
