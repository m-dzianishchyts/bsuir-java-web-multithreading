package by.bsuir.web.multithreading.server.command;

import by.bsuir.web.multithreading.common.ArchiveCommandName;
import by.bsuir.web.multithreading.common.UserRole;
import by.bsuir.web.multithreading.server.entity.PersonnelFile;
import by.bsuir.web.multithreading.server.service.ArchiveService;
import by.bsuir.web.multithreading.server.service.ArchiveServiceException;

import java.io.PrintWriter;

public class EditPersonnelFileCommand extends AbstractArchiveCommand {

    private static final ArchiveCommandName commandName = ArchiveCommandName.EDIT;

    private final PersonnelFile editPersonnelFile;

    public EditPersonnelFileCommand(ArchiveService archiveService, PrintWriter writer, UserRole userRole,
                                    PersonnelFile editPersonnelFile) {
        super(archiveService, writer, userRole);
        this.editPersonnelFile = editPersonnelFile;
    }

    @Override
    public void execute() throws CommandException {
        if (!userRole.getAvailableCommands().contains(commandName)) {
            writer.println(NOT_ENOUGH_PERMISSIONS_MESSAGE);
            return;
        }
        try {
            archiveService.editPersonnelFile(editPersonnelFile.getId(), editPersonnelFile);
            writer.println("Personnel file has been edited successfully.");
        } catch (ArchiveServiceException e) {
            throw new CommandException(e);
        }
    }
}
