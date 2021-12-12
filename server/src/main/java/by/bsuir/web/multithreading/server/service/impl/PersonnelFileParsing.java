package by.bsuir.web.multithreading.server.service.impl;

import by.bsuir.web.multithreading.server.entity.ContactLinks;
import by.bsuir.web.multithreading.server.entity.Contacts;
import by.bsuir.web.multithreading.server.entity.Gender;
import by.bsuir.web.multithreading.server.entity.PersonnelFile;
import by.bsuir.web.multithreading.server.entity.Position;
import by.bsuir.web.multithreading.server.entity.validation.StateValidationException;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

public final class PersonnelFileParsing {

    private static final int PERSONNEL_FILE_PARAMETERS = PersonnelFile.class.getDeclaredFields().length;
    static final int ID_INDEX = 2;
    private static final int FIRST_NAME_INDEX = 3;
    private static final int LAST_NAME_INDEX = 4;
    private static final int GENDER_INDEX = 5;
    private static final int BIRTH_DATE_INDEX = 6;
    private static final int POSITION_DIVISION_INDEX = 7;
    private static final int POSITION_TITLE_INDEX = 8;
    private static final int CONTACTS_EMAIL_INDEX = 9;
    private static final int CONTACTS_PHONE_INDEX = 10;
    private static final int CONTACTS_LINKS_INDEX = 11;

    private PersonnelFileParsing() {
    }

    public static PersonnelFile parsePersonnelFile(String[] tokens)
            throws IllegalArgumentException, DateTimeParseException, StateValidationException {
        if (tokens.length < PERSONNEL_FILE_PARAMETERS) {
            throw new IllegalArgumentException("Not enough parameters for personnel file. Required: "
                                               + PERSONNEL_FILE_PARAMETERS);
        }
        int id = Integer.parseInt(tokens[ID_INDEX]);
        String firstName = tokens[FIRST_NAME_INDEX];
        String lastName = tokens[LAST_NAME_INDEX];
        Gender gender = Gender.fromValue(tokens[GENDER_INDEX]);
        LocalDate birthDate = LocalDate.parse(tokens[BIRTH_DATE_INDEX]);
        Position position = parsePosition(tokens);
        Contacts contacts = parseContacts(tokens);

        PersonnelFile personnelFile = new PersonnelFile();
        personnelFile.setId(id);
        personnelFile.setFirstName(firstName);
        personnelFile.setLastName(lastName);
        personnelFile.setGender(gender);
        personnelFile.setBirthDate(birthDate);
        personnelFile.setPosition(position);
        personnelFile.setContacts(contacts);
        return personnelFile;
    }

    private static Position parsePosition(String[] tokens) {
        Position position = new Position();
        position.setDivision(tokens[POSITION_DIVISION_INDEX]);
        position.setTitle(tokens[POSITION_TITLE_INDEX]);
        return position;
    }

    private static Contacts parseContacts(String[] tokens) throws StateValidationException {
        Contacts contacts = new Contacts();
        contacts.setEmail(tokens[CONTACTS_EMAIL_INDEX]);
        contacts.setPhone(tokens[CONTACTS_PHONE_INDEX]);
        ContactLinks contactLinks = new ContactLinks();
        List<String> linkList = Arrays.stream(tokens).skip(CONTACTS_LINKS_INDEX - 1L).toList();
        contactLinks.setLinkList(linkList);
        contacts.setContactLinks(contactLinks);
        return contacts;
    }
}
