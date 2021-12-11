package by.bsuir.web.multithreading.server.dao;

import by.bsuir.web.multithreading.server.entity.PersonnelFile;

import java.util.List;
import java.util.Optional;

/**
 * DAO interface for accessing personnel file entities.
 */
public interface PersonnelFileDao {

    /**
     * Find all personnel files in data source.
     *
     * @return list of found personnel files entities
     */
    List<PersonnelFile> findAll() throws PersonnelFileDaoException;

    /**
     * Find personnel file by id in data source.
     *
     * @return empty {@link Optional} if no personnel files with the specified id exist in data source,
     * {@link Optional} with entity inside otherwise
     */
    Optional<PersonnelFile> find(int id) throws PersonnelFileDaoException;

    /**
     * Save personnel file into data source.
     */
    void save(PersonnelFile newPersonnelFile) throws PersonnelFileDaoException;

    /**
     * Update personnel file in data source by id.
     */
    void update(int id, PersonnelFile updatePersonnelFile) throws PersonnelFileDaoException;

    /**
     * Delete personnel file from data source by id.
     */
    void delete(int id) throws PersonnelFileDaoException;
}
