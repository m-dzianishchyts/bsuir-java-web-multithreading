package by.bsuir.web.multithreading.server.command;

import by.bsuir.web.multithreading.common.ArchiveCommandName;
import by.bsuir.web.multithreading.common.UserRole;
import by.bsuir.web.multithreading.server.entity.PersonnelFile;
import by.bsuir.web.multithreading.server.service.ArchiveService;
import by.bsuir.web.multithreading.server.service.ArchiveServiceException;

import java.io.PrintWriter;
import java.util.Optional;

public class ShowPersonnelFileCommand extends AbstractArchiveCommand {

    private static final ArchiveCommandName commandName = ArchiveCommandName.SHOW;

    private final int showId;

    public ShowPersonnelFileCommand(ArchiveService archiveService, PrintWriter writer, UserRole userRole, int showId) {
        super(archiveService, writer, userRole);
        this.showId = showId;
    }

    @Override
    public void execute() throws CommandException {
        if (!userRole.getAvailableCommands().contains(commandName)) {
            writer.println(NOT_ENOUGH_PERMISSIONS_MESSAGE);
            return;
        }
        try {
            Optional<PersonnelFile> optionalPersonnelFile = archiveService.findPersonnelFile(showId);
            if (optionalPersonnelFile.isPresent()) {
                writer.println("Personnel file:" + System.lineSeparator() + optionalPersonnelFile.get());
            } else {
                writer.println("Personnel file with the specified ID has been not found.");
            }
        } catch (ArchiveServiceException e) {
            throw new CommandException(e);
        }
    }
}
