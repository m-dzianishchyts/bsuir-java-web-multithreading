package by.bsuir.web.multithreading.server.service;

import by.bsuir.web.multithreading.server.command.Command;

public interface CommandMapperService {

    Command mapCommand(Object commandKey) throws CommandMapperServiceException;
}
