package dao.interfaces;

import dto.Sight;
import exception.IncorrectUserSightWantedException;

public interface UserSightWantedDao {
    boolean isColumnExist(int userId, int sightId) throws IncorrectUserSightWantedException;

    boolean addColumn(int userId, int sightId) throws IncorrectUserSightWantedException;

    Sight[] getWantedSightsByUserId(int userId);
}
