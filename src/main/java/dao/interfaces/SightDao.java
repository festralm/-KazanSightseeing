package dao.interfaces;

import dto.Sight;
import exception.*;

public interface SightDao {

    Sight getSightById(int sightId);

    String[] getArchivePhotoPathsForSight(int id) throws IncorrectSightException;

    boolean addNewSight(Sight sight);
}
