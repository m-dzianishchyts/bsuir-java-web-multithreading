package by.bsuir.web.multithreading.server.command;

public interface Command {

    void execute() throws CommandException;
}
