package by.bsuir.web.multithreading.server.service.impl;

import by.bsuir.web.multithreading.server.service.ArchiveService;

import java.io.PrintWriter;

public class CommandMappingContext {

    private final ArchiveService archiveService;
    private final PrintWriter writer;

    public CommandMappingContext(ArchiveService archiveService, PrintWriter writer) {
        this.archiveService = archiveService;
        this.writer = writer;
    }

    public ArchiveService getArchiveService() {
        return archiveService;
    }

    public PrintWriter getWriter() {
        return writer;
    }
}
