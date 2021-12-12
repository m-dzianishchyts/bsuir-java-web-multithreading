package by.bsuir.web.multithreading.common;

public enum ArchiveCommandName {
    SHOW_ALL("show-all"),
    SHOW("show"),
    EDIT("edit"),
    SAVE("save"),
    DELETE("delete"),
    SHUTDOWN("shutdown");

    private final String value;

    ArchiveCommandName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
