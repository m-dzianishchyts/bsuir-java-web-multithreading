package by.bsuir.web.multithreading.server.app;

import by.bsuir.web.multithreading.server.command.Command;
import by.bsuir.web.multithreading.server.command.CommandException;
import by.bsuir.web.multithreading.server.service.CommandMapperService;
import by.bsuir.web.multithreading.server.service.CommandMapperServiceException;
import by.bsuir.web.multithreading.server.service.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ArchiveApplication implements Runnable {

    private static final Logger logger = LogManager.getLogger(ArchiveApplication.class);

    private static final int SERVER_PORT = 49999;

    private static ArchiveApplication instance;

    private final CommandMapperService adminCommandMapperService;
    private final ExecutorService executorService;
    private boolean isRunning;

    private ArchiveApplication(ExecutorService executorService, CommandMapperService adminCommandMapperService) {
        this.executorService = executorService;
        this.adminCommandMapperService = adminCommandMapperService;
    }

    public static synchronized ArchiveApplication getInstance() {
        if (instance == null) {
            instance = new ArchiveApplication(
                    Executors.newCachedThreadPool(),
                    ServiceFactory.getInstance().getCommandMapperService("server", new PrintWriter(System.out))
            );
        }
        return instance;
    }

    public synchronized void shutdown() {
        isRunning = false;
    }

    public synchronized void launch() {
        if (!isRunning) {
            Thread applicationThread = new Thread(getInstance(), ArchiveApplication.class.getName());
            applicationThread.start();

            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                String input = scanner.next();
                try {
                    Command command = adminCommandMapperService.mapCommand(input);
                    command.execute();
                } catch (CommandMapperServiceException e) {
                    logger.error(String.format("Unknown command: \"%s\"", input));
                } catch (CommandException e) {
                    logger.error(e);
                }
            }
        }
    }

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            while (isRunning) {
                Socket clientSocket = serverSocket.accept();
                BufferedReader clientReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream(),
                                                                                       StandardCharsets.UTF_8));
                PrintWriter clientWriter = new PrintWriter(clientSocket.getOutputStream(), true);
                CommandMapperService commandMapperService = ServiceFactory.getInstance().getCommandMapperService(
                        ServiceFactory.CLIENT_COMMAND_MAPPER_SERVICE_NAME, clientWriter
                );
                ClientHandler clientJob = new ClientHandler(clientReader, clientWriter, commandMapperService);
                executorService.submit(clientJob);
            }
        } catch (IOException e) {
            logger.error(e);
        }
    }
}
