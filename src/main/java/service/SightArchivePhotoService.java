package service;


import dao.classes.SightArchivePhotoDaoMySql;
import dao.classes.UserSightWantedDaoMySql;
import dao.interfaces.SightArchivePhotoDao;
import dao.interfaces.UserSightWantedDao;
import dto.Sight;
import exception.CouldNotAddSightArchivePhotoException;
import exception.IncorrectSightException;
import exception.IncorrectUserException;
import exception.main.CouldNotAddDataException;
import lombok.SneakyThrows;


public class SightArchivePhotoService {
    private SightArchivePhotoDao sightArchivePhotoDao = new SightArchivePhotoDaoMySql();

    @SneakyThrows
    public boolean addNewSightArchivePhoto(int sightId, String photoPath) {
        if (photoPath == null || sightId < 1) {
            throw new IncorrectSightException();
        }

        boolean added = sightArchivePhotoDao.addNewSightArchivePhoto(sightId, photoPath);

        if (!added) {
            throw new CouldNotAddSightArchivePhotoException();
        }

        return true;
    }
}
