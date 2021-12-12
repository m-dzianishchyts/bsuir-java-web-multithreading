package by.bsuir.web.multithreading.server;

import by.bsuir.web.multithreading.server.app.ArchiveApplication;

public class ArchiveServer {

    public static void main(String[] args) {
        ArchiveApplication.getInstance().launch();
    }
}
