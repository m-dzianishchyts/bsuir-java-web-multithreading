package by.bsuir.web.multithreading.server.service.impl;

import by.bsuir.web.multithreading.common.ArchiveCommandName;
import by.bsuir.web.multithreading.common.UserRole;
import by.bsuir.web.multithreading.server.command.Command;
import by.bsuir.web.multithreading.server.command.DeletePersonnelFileCommand;
import by.bsuir.web.multithreading.server.command.EditPersonnelFileCommand;
import by.bsuir.web.multithreading.server.command.SavePersonnelFileCommand;
import by.bsuir.web.multithreading.server.command.ShowAllPersonnelFilesCommand;
import by.bsuir.web.multithreading.server.command.ShowPersonnelFileCommand;
import by.bsuir.web.multithreading.server.entity.PersonnelFile;
import by.bsuir.web.multithreading.server.service.CommandMapperService;
import by.bsuir.web.multithreading.server.service.CommandMapperServiceException;

public class StringCommandMapperService implements CommandMapperService {

    protected static final int USER_ROLE_INDEX = 0;
    protected static final int COMMAND_NAME_INDEX = 1;
    protected static final int ID_INDEX = PersonnelFileParsing.ID_INDEX;
    protected static final String LEXICAL_COMMAND_SEPARATOR_PATTERN = "\s+";

    protected final CommandMappingContext commandMappingContext;

    public StringCommandMapperService(CommandMappingContext commandMappingContext) {
        this.commandMappingContext = commandMappingContext;
    }

    protected static UserRole parseUserRole(String lexicalUserRole) throws IllegalArgumentException {
        UserRole userRole = UserRole.fromValue(lexicalUserRole);
        return userRole;
    }

    protected static int parseId(String lexicalId) throws IllegalArgumentException {
        int id = Integer.parseInt(lexicalId);
        return id;
    }

    @Override
    public Command mapCommand(Object commandKey) throws CommandMapperServiceException {
        try {
            String lexicalCommand = (String) commandKey;
            String[] commandTokens = lexicalCommand.split(LEXICAL_COMMAND_SEPARATOR_PATTERN);
            if (commandTokens.length < 1) {
                throw new CommandMapperServiceException("Command is empty or blank.");
            }
            String commandName = commandTokens[COMMAND_NAME_INDEX].toLowerCase();
            UserRole userRole = parseUserRole(commandTokens[USER_ROLE_INDEX]);
            Command command;
            if (commandName.equals(ArchiveCommandName.SHOW_ALL.getValue())) {
                command = new ShowAllPersonnelFilesCommand(commandMappingContext.getArchiveService(),
                                                           commandMappingContext.getWriter(), userRole);
            } else if (commandName.equals(ArchiveCommandName.SHOW.getValue())) {
                int id = parseId(commandTokens[ID_INDEX]);
                command = new ShowPersonnelFileCommand(commandMappingContext.getArchiveService(),
                                                       commandMappingContext.getWriter(), userRole, id);
            } else if (commandName.equals(ArchiveCommandName.EDIT.getValue())) {
                PersonnelFile editPersonnelFile = PersonnelFileParsing.parsePersonnelFile(commandTokens);
                command = new EditPersonnelFileCommand(commandMappingContext.getArchiveService(),
                                                       commandMappingContext.getWriter(), userRole, editPersonnelFile);
            } else if (commandName.equals(ArchiveCommandName.SAVE.getValue())) {
                PersonnelFile savePersonnelFile = PersonnelFileParsing.parsePersonnelFile(commandTokens);
                command = new SavePersonnelFileCommand(commandMappingContext.getArchiveService(),
                                                       commandMappingContext.getWriter(), userRole, savePersonnelFile);
            } else if (commandName.equals(ArchiveCommandName.DELETE.getValue())) {
                int id = parseId(commandTokens[ID_INDEX]);
                command = new DeletePersonnelFileCommand(commandMappingContext.getArchiveService(),
                                                         commandMappingContext.getWriter(), userRole, id);
            } else {
                throw new CommandMapperServiceException(String.format("Unknown command name: \"%s\"", lexicalCommand));
            }
            return command;
        } catch (Exception e) {
            throw new CommandMapperServiceException(e);
        }
    }
}
