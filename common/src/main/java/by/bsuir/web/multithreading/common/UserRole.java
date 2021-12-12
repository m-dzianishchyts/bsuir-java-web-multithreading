package by.bsuir.web.multithreading.common;

import java.util.Arrays;
import java.util.List;

public enum UserRole {
    NEWCOMER(),
    ASSISTANT(ArchiveCommandName.SHOW_ALL, ArchiveCommandName.SHOW),
    MANAGER(ArchiveCommandName.SHOW_ALL, ArchiveCommandName.SHOW, ArchiveCommandName.EDIT, ArchiveCommandName.SAVE),
    ADMIN(ArchiveCommandName.SHOW_ALL, ArchiveCommandName.SHOW, ArchiveCommandName.EDIT, ArchiveCommandName.SAVE,
          ArchiveCommandName.DELETE),
    SERVER(ArchiveCommandName.values());

    private final List<ArchiveCommandName> availableCommands;

    UserRole(ArchiveCommandName... availableCommands) {
        this.availableCommands = Arrays.stream(availableCommands).distinct().toList();
    }

    public static UserRole fromValue(String value) throws IllegalArgumentException {
        for (UserRole userRole : UserRole.values()) {
            if (userRole.name().equalsIgnoreCase(value)) {
                return userRole;
            }
        }
        throw new IllegalArgumentException(value);
    }

    public List<ArchiveCommandName> getAvailableCommands() {
        return List.copyOf(availableCommands);
    }
}
