package dao.interfaces;

import dto.Sight;
import exception.IncorrectUserSightFavoriteException;
import exception.IncorrectUserSightWantedException;

public interface UserSightFavoriteDao {
    boolean isColumnExist(int userId, int sightId) throws IncorrectUserSightFavoriteException;

    boolean addColumn(int userId, int sightId) throws IncorrectUserSightFavoriteException;

    Sight[] getFavoriteSightsByUserId(int userId);
}
