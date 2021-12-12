package by.bsuir.web.multithreading.server.command;

import by.bsuir.web.multithreading.common.ArchiveCommandName;
import by.bsuir.web.multithreading.common.UserRole;
import by.bsuir.web.multithreading.server.entity.PersonnelFile;
import by.bsuir.web.multithreading.server.service.ArchiveService;
import by.bsuir.web.multithreading.server.service.ArchiveServiceException;

import java.io.PrintWriter;

public class SavePersonnelFileCommand extends AbstractArchiveCommand {

    private static final ArchiveCommandName commandName = ArchiveCommandName.SAVE;

    private final PersonnelFile savePersonnelFile;

    public SavePersonnelFileCommand(ArchiveService archiveService, PrintWriter writer, UserRole userRole,
                                    PersonnelFile savePersonnelFile) {
        super(archiveService, writer, userRole);
        this.savePersonnelFile = savePersonnelFile;
    }

    @Override
    public void execute() throws CommandException {
        if (!userRole.getAvailableCommands().contains(commandName)) {
            writer.println(NOT_ENOUGH_PERMISSIONS_MESSAGE);
            return;
        }
        try {
            archiveService.savePersonnelFile(savePersonnelFile);
            writer.println("Personnel file has been saved successfully.");
        } catch (ArchiveServiceException e) {
            throw new CommandException(e);
        }
    }
}
