package service;


import dao.classes.SightDaoMySql;
import dao.classes.UserSightVisitedDaoMySql;
import dao.interfaces.SightDao;
import dao.interfaces.UserSightVisitedDao;
import dto.Achievement;
import dto.Sight;
import exception.IncorrectSightException;
import exception.IncorrectUserException;
import lombok.SneakyThrows;


public class UserSightVisitedService {
    private UserSightVisitedDao userSightVisitedDao = new UserSightVisitedDaoMySql();

    @SneakyThrows
    public boolean addColumn(int userId, int sightId) {
        if (userId < 0) {
            throw new IncorrectUserException();
        }
        if (sightId < 0) {
            throw new IncorrectSightException();
        }

        return userSightVisitedDao.addColumn(userId, sightId);

    }

    @SneakyThrows
    public Sight[] getVisitedSightsByUserId(int userId) {
        if (userId < 0) {
            throw new IncorrectUserException();
        }

        Sight[] sights = userSightVisitedDao.getVisitedSightsByUserId(userId);

        if (sights == null) {
            throw new IncorrectSightException();
        }

        return sights;
    }
}
