package by.bsuir.web.multithreading.server.service.impl;

import by.bsuir.web.multithreading.common.ArchiveCommandName;
import by.bsuir.web.multithreading.common.UserRole;
import by.bsuir.web.multithreading.server.command.ArchiveApplicationShutdownCommand;
import by.bsuir.web.multithreading.server.command.Command;
import by.bsuir.web.multithreading.server.service.CommandMapperServiceException;

public class AdminStringCommandMapperServiceImpl extends StringCommandMapperService {
    public AdminStringCommandMapperServiceImpl(CommandMappingContext commandMappingContext) {
        super(commandMappingContext);
    }

    @Override
    public Command mapCommand(Object commandKey) throws CommandMapperServiceException {
        String lexicalCommand = (String) commandKey;
        String[] commandTokens = lexicalCommand.split(LEXICAL_COMMAND_SEPARATOR_PATTERN);
        if (commandTokens.length < 1) {
            throw new CommandMapperServiceException("Command is empty or blank.");
        }
        UserRole userRole = parseUserRole(commandTokens[USER_ROLE_INDEX]);
        String commandName = commandTokens[COMMAND_NAME_INDEX].toLowerCase();
        Command command;
        if (commandName.equals(ArchiveCommandName.SHUTDOWN.getValue())) {
            command = new ArchiveApplicationShutdownCommand(commandMappingContext.getWriter(), userRole);
        } else {
            command = super.mapCommand(commandKey);
        }
        return command;
    }
}
