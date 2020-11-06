package dao.interfaces;

import dto.Sight;
import exception.IncorrectUserException;
import exception.IncorrectUserSightVisitedException;

public interface UserSightVisitedDao {
    boolean isColumnExist(int userId, int sightId) throws IncorrectUserException, IncorrectUserSightVisitedException;

    boolean addColumn(int userId, int sightId) throws IncorrectUserException, IncorrectUserSightVisitedException;

    Sight[] getVisitedSightsByUserId(int userId);
}
