package by.bsuir.web.multithreading.server.command;

import by.bsuir.web.multithreading.common.ArchiveCommandName;
import by.bsuir.web.multithreading.common.UserRole;
import by.bsuir.web.multithreading.server.entity.PersonnelFile;
import by.bsuir.web.multithreading.server.service.ArchiveService;
import by.bsuir.web.multithreading.server.service.ArchiveServiceException;

import java.io.PrintWriter;
import java.util.List;
import java.util.StringJoiner;

public class ShowAllPersonnelFilesCommand extends AbstractArchiveCommand {

    private static final ArchiveCommandName commandName = ArchiveCommandName.SHOW_ALL;

    public ShowAllPersonnelFilesCommand(ArchiveService archiveService, PrintWriter writer, UserRole userRole) {
        super(archiveService, writer, userRole);
    }

    @Override
    public void execute() throws CommandException {
        if (!userRole.getAvailableCommands().contains(commandName)) {
            writer.println(NOT_ENOUGH_PERMISSIONS_MESSAGE);
            return;
        }
        try {
            List<PersonnelFile> personnelFileList = archiveService.findAllPersonnelFiles();
            if (personnelFileList.isEmpty()) {
                writer.println("The archive has no personnel files yet.");
                return;
            }
            StringJoiner commandResultJoiner = new StringJoiner(System.lineSeparator());
            commandResultJoiner.add("Personnel files in the archive:");
            personnelFileList.forEach(personnelFile -> commandResultJoiner.add(commandResultJoiner.toString()));
            writer.println(commandResultJoiner);
        } catch (ArchiveServiceException e) {
            throw new CommandException(e);
        }
    }
}
