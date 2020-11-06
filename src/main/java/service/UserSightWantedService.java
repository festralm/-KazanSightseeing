package service;


import dao.classes.UserSightVisitedDaoMySql;
import dao.classes.UserSightWantedDaoMySql;
import dao.interfaces.UserSightVisitedDao;
import dao.interfaces.UserSightWantedDao;
import dto.Sight;
import exception.IncorrectSightException;
import exception.IncorrectUserException;
import lombok.SneakyThrows;


public class UserSightWantedService {
    private UserSightWantedDao userSightWantedDao = new UserSightWantedDaoMySql();

    @SneakyThrows
    public boolean addColumn(int userId, int sightId) {
        if (userId < 0) {
            throw new IncorrectUserException();
        }
        if (sightId < 0) {
            throw new IncorrectSightException();
        }

        return userSightWantedDao.addColumn(userId, sightId);
    }

    @SneakyThrows
    public Sight[] getWantedSightsByUserId(int userId) {
        if (userId < 0) {
            throw new IncorrectUserException();
        }

        Sight[] sights = userSightWantedDao.getWantedSightsByUserId(userId);

        if (sights == null) {
            throw new IncorrectSightException();
        }

        return sights;
    }
}
