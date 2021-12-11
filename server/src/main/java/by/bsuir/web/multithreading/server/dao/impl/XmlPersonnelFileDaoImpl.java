package by.bsuir.web.multithreading.server.dao.impl;

import by.bsuir.web.multithreading.server.dao.PersonnelFileDao;
import by.bsuir.web.multithreading.server.dao.PersonnelFileDaoException;
import by.bsuir.web.multithreading.server.entity.PersonnelFile;
import by.bsuir.web.multithreading.server.entity.PersonnelFiles;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of {@link PersonnelFileDao}.
 */
public class XmlPersonnelFileDaoImpl implements PersonnelFileDao {

    private static final String PATH_TO_XML_FILE = "xml/appliance/appliances.xml";
    private PersonnelFiles files;

    @Override
    public synchronized List<PersonnelFile> findAll() throws PersonnelFileDaoException {
        if (files == null) {
            loadPersonnelFiles();
        }

        return List.copyOf(files.getFileList());
    }

    @Override
    public synchronized Optional<PersonnelFile> find(int id) throws PersonnelFileDaoException {
        if (files == null) {
            loadPersonnelFiles();
        }

        Optional<PersonnelFile> optionalPersonnelFile = files.getFileList().stream()
                                                             .filter(personnelFile -> personnelFile.getId() == id)
                                                             .findAny();
        return optionalPersonnelFile;
    }

    @Override
    public synchronized void save(PersonnelFile newPersonnelFile) throws PersonnelFileDaoException {
        if (files == null) {
            loadPersonnelFiles();
        }

        boolean idDuplicateExists = files.getFileList().stream()
                                         .anyMatch(personnelFile -> personnelFile.getId() == newPersonnelFile.getId());
        if (idDuplicateExists) {
            throw new PersonnelFileDaoException("ID duplicate: " + newPersonnelFile.getId());
        }
        files.getFileList().add(newPersonnelFile);
        savePersonnelFiles();
    }

    @Override
    public synchronized void update(int id, PersonnelFile updatePersonnelFile) throws PersonnelFileDaoException {
        if (files == null) {
            loadPersonnelFiles();
        }

        boolean idExists = files.getFileList().stream().anyMatch(personnelFile -> personnelFile.getId() == id);
        if (!idExists) {
            throw new PersonnelFileDaoException("ID not found: " + id);
        }
        List<PersonnelFile> fileList =
                files.getFileList().stream()
                     .map(personnelFile -> personnelFile.getId() == id ? updatePersonnelFile : personnelFile)
                     .toList();
        files.setFileList(fileList);
        savePersonnelFiles();
    }

    @Override
    public synchronized void delete(int id) throws PersonnelFileDaoException {
        if (files == null) {
            loadPersonnelFiles();
        }

        List<PersonnelFile> fileList = files.getFileList().stream()
                                            .filter(personnelFile -> personnelFile.getId() == id)
                                            .toList();
        files.setFileList(fileList);
        savePersonnelFiles();
    }

    private void loadPersonnelFiles() throws PersonnelFileDaoException {
        try (InputStream inputStream = new FileInputStream(PATH_TO_XML_FILE)) {
            JAXBContext jaxbContext = JAXBContext.newInstance(PersonnelFiles.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            files = (PersonnelFiles) unmarshaller.unmarshal(inputStream);
        } catch (JAXBException | IOException e) {
            throw new PersonnelFileDaoException(e);
        }
    }

    private void savePersonnelFiles() throws PersonnelFileDaoException {
        File outputFile = new File(PATH_TO_XML_FILE);
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(PersonnelFiles.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.marshal(files, outputFile);
        } catch (JAXBException e) {
            throw new PersonnelFileDaoException(e);
        }
    }
}
