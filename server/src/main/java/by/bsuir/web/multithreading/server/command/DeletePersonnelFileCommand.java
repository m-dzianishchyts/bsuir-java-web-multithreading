package by.bsuir.web.multithreading.server.command;

import by.bsuir.web.multithreading.common.ArchiveCommandName;
import by.bsuir.web.multithreading.common.UserRole;
import by.bsuir.web.multithreading.server.service.ArchiveService;
import by.bsuir.web.multithreading.server.service.ArchiveServiceException;

import java.io.PrintWriter;

public class DeletePersonnelFileCommand extends AbstractArchiveCommand {

    private static final ArchiveCommandName commandName = ArchiveCommandName.DELETE;

    private final int deleteId;

    public DeletePersonnelFileCommand(ArchiveService archiveService, PrintWriter writer,
                                      UserRole userRole, int deleteId) {
        super(archiveService, writer, userRole);
        this.deleteId = deleteId;
    }

    @Override
    public void execute() {
        if (!userRole.getAvailableCommands().contains(commandName)) {
            writer.println(NOT_ENOUGH_PERMISSIONS_MESSAGE);
            return;
        }
        try {
            archiveService.destroyPersonnelFile(deleteId);
            writer.println("Personnel file has been deleted successfully.");
        } catch (ArchiveServiceException e) {
            writer.println("Personnel file with the specified ID has been not found.");
        }
    }
}
