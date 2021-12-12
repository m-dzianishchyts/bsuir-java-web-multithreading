package by.bsuir.web.multithreading.server.app;

import by.bsuir.web.multithreading.server.command.Command;
import by.bsuir.web.multithreading.server.service.CommandMapperService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.PrintWriter;

public class ClientHandler implements Runnable {

    private static final Logger logger = LogManager.getLogger(ClientHandler.class);

    private final PrintWriter printWriter;
    private final BufferedReader bufferedReader;
    private final CommandMapperService commandMapperService;

    public ClientHandler(BufferedReader bufferedReader, PrintWriter printWriter,
                         CommandMapperService commandMapperService) {
        this.printWriter = printWriter;
        this.bufferedReader = bufferedReader;
        this.commandMapperService = commandMapperService;
    }

    @Override
    public void run() {
        try {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Command command = commandMapperService.mapCommand(line);
                if (command == null) {
                    printWriter.println("Can't understand your query...");
                } else {
                    command.execute();
                }
            }
        } catch (Exception e) {
            logger.error(e);
        }
    }
}
