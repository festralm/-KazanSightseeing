package dao.interfaces;

import dto.Sight;
import exception.IncorrectUserSightFavoriteException;

public interface SightArchivePhotoDao {
    boolean addNewSightArchivePhoto(int sightId, String photoPath);
}
