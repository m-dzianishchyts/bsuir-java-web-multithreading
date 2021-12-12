package by.bsuir.web.multithreading.server.service;

import by.bsuir.web.multithreading.server.entity.PersonnelFile;

import java.util.List;
import java.util.Optional;

/**
 * Interface of archive service.
 */
public interface ArchiveService {

    /**
     * Find all personnel files in the archive.
     *
     * @return all personnel files
     */
    List<PersonnelFile> findAllPersonnelFiles() throws ArchiveServiceException;

    /**
     * Find personnel file by id in the archive.
     *
     * @return empty {@link Optional} if no personnel files with the specified id exist in the archive,
     * {@link Optional} with entity inside otherwise
     */
    Optional<PersonnelFile> findPersonnelFile(int id) throws ArchiveServiceException;

    /**
     * Save new personnel file into the archive.
     */
    void savePersonnelFile(PersonnelFile newPersonnelFile) throws ArchiveServiceException;

    /**
     * Edit personnel file in the archive.
     */
    void editPersonnelFile(int id, PersonnelFile editPersonnelFile) throws ArchiveServiceException;

    /**
     * Destroy personnel file in the archive.
     */
    void destroyPersonnelFile(int id) throws ArchiveServiceException;
}
