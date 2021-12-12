package by.bsuir.web.multithreading.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ArchiveClient {

    private static final String SERVER_HOSTNAME = "localhost";
    private static final int SERVER_PORT = 49999;

    private static ArchiveClient instance;

    private final String serverHostname;
    private final int serverHostPort;

    private ArchiveClient(String serverHostname, int serverPort) {
        this.serverHostname = serverHostname;
        this.serverHostPort = serverPort;
    }

    public static synchronized ArchiveClient getInstance() {
        if (instance == null) {
            instance = new ArchiveClient(SERVER_HOSTNAME, SERVER_PORT);
        }
        return instance;
    }

    public static void main(String[] args) {
        ArchiveClient.getInstance().start();
    }

    public void start() {
        try (Socket socket = new Socket(serverHostname, serverHostPort)) {
            Scanner scanner = new Scanner(System.in);
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                writer.println(line);
                String response = reader.readLine();
                System.out.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
