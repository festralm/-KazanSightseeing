package service;


import dao.classes.SightDaoMySql;
import dao.interfaces.SightDao;
import dto.User;
import exception.CouldNotAddSightException;
import exception.CouldNotAddUserException;
import exception.IncorrectUserException;
import exception.IncorrectSightException;
import dto.Sight;
import lombok.SneakyThrows;

import java.lang.reflect.Array;
import java.util.Arrays;


public class SightService {
    private SightDao sightDao = new SightDaoMySql();

    @SneakyThrows
    public Sight getSightById(int sightId)  {
        if (sightId < 1) {
            throw new IncorrectUserException();
        }

        Sight sight = sightDao.getSightById(sightId);

        if (sight == null || sight.getName() == null ||
                sight.getDescription() == null || sight.getPhotoPath() == null) {
            throw new IncorrectSightException();
        }

        return sight;
    }

    @SneakyThrows
    public void addArchivePhotosToSight(Sight sight) {
        if (sight == null) {
            throw new IncorrectSightException();
        }

        String[] archivePhotoPaths = sightDao.getArchivePhotoPathsForSight(sight.getId());

        if (archivePhotoPaths == null) {
            throw new IncorrectSightException();
        }
        sight.setArchivePhotoPaths(archivePhotoPaths);
    }

    @SneakyThrows
    public boolean addNewSight(String name, String description, String photoPath) {

        if (name == null || description == null || photoPath == null) {
            throw new IncorrectSightException();
        }

        boolean added = sightDao.addNewSight(
                new Sight(name, description, photoPath)
        );

        if (!added) {
            throw new CouldNotAddSightException();
        }
        return true;
    }
}
