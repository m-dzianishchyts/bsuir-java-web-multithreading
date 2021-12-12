package by.bsuir.web.multithreading.server.command;

import by.bsuir.web.multithreading.common.ArchiveCommandName;
import by.bsuir.web.multithreading.common.UserRole;
import by.bsuir.web.multithreading.server.app.ArchiveApplication;

import java.io.PrintWriter;

import static by.bsuir.web.multithreading.server.command.AbstractArchiveCommand.NOT_ENOUGH_PERMISSIONS_MESSAGE;

public class ArchiveApplicationShutdownCommand implements Command {

    private static final ArchiveCommandName commandName = ArchiveCommandName.SHUTDOWN;

    protected final PrintWriter writer;
    protected final UserRole userRole;

    public ArchiveApplicationShutdownCommand(PrintWriter writer, UserRole userRole) {
        this.writer = writer;
        this.userRole = userRole;
    }

    @Override
    public void execute() {
        if (!userRole.getAvailableCommands().contains(commandName)) {
            writer.println(NOT_ENOUGH_PERMISSIONS_MESSAGE);
            return;
        }
        ArchiveApplication.getInstance().shutdown();
    }
}
