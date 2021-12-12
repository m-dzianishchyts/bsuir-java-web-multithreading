package by.bsuir.web.multithreading.server.service.impl;

import by.bsuir.web.multithreading.server.dao.PersonnelFileDao;
import by.bsuir.web.multithreading.server.dao.PersonnelFileDaoException;
import by.bsuir.web.multithreading.server.entity.PersonnelFile;
import by.bsuir.web.multithreading.server.service.ArchiveService;
import by.bsuir.web.multithreading.server.service.ArchiveServiceException;

import java.util.List;
import java.util.Optional;

public class ArchiveServiceImpl implements ArchiveService {

    private final PersonnelFileDao personnelFileDao;

    public ArchiveServiceImpl(PersonnelFileDao personnelFileDao) {
        this.personnelFileDao = personnelFileDao;
    }

    @Override
    public List<PersonnelFile> findAllPersonnelFiles() throws ArchiveServiceException {
        try {
            List<PersonnelFile> personnelFileList = personnelFileDao.findAll();
            return personnelFileList;
        } catch (PersonnelFileDaoException e) {
            throw new ArchiveServiceException(e);
        }
    }

    @Override
    public Optional<PersonnelFile> findPersonnelFile(int id) throws ArchiveServiceException {
        try {
            Optional<PersonnelFile> optionalPersonnelFile = personnelFileDao.find(id);
            return optionalPersonnelFile;
        } catch (PersonnelFileDaoException e) {
            throw new ArchiveServiceException(e);
        }
    }

    @Override
    public void savePersonnelFile(PersonnelFile newPersonnelFile) throws ArchiveServiceException {
        try {
            personnelFileDao.save(newPersonnelFile);
        } catch (PersonnelFileDaoException e) {
            throw new ArchiveServiceException(e);
        }
    }

    @Override
    public void editPersonnelFile(int id, PersonnelFile editPersonnelFile) throws ArchiveServiceException {
        try {
            personnelFileDao.update(id, editPersonnelFile);
        } catch (PersonnelFileDaoException e) {
            throw new ArchiveServiceException(e);
        }
    }

    @Override
    public void destroyPersonnelFile(int id) throws ArchiveServiceException {
        try {
            personnelFileDao.delete(id);
        } catch (PersonnelFileDaoException e) {
            throw new ArchiveServiceException(e);
        }
    }
}



