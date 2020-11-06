package service;


import dao.classes.UserSightFavoriteDaoMySql;
import dao.classes.UserSightWantedDaoMySql;
import dao.interfaces.UserSightFavoriteDao;
import dao.interfaces.UserSightWantedDao;
import dto.Sight;
import exception.IncorrectSightException;
import exception.IncorrectUserException;
import lombok.SneakyThrows;


public class UserSightFavoriteService {
    private UserSightFavoriteDao userSightFavoriteDao = new UserSightFavoriteDaoMySql();

    @SneakyThrows
    public boolean addColumn(int userId, int sightId) {
        if (userId < 0) {
            throw new IncorrectUserException();
        }
        if (sightId < 0) {
            throw new IncorrectSightException();
        }

        return userSightFavoriteDao.addColumn(userId, sightId);
    }

    @SneakyThrows
    public Sight[] getFavoriteSightsByUserId(int userId) {
        if (userId < 0) {
            throw new IncorrectUserException();
        }

        Sight[] sights = userSightFavoriteDao.getFavoriteSightsByUserId(userId);

        if (sights == null) {
            throw new IncorrectSightException();
        }

        return sights;
    }
}
