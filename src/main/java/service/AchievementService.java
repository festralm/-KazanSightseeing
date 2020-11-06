package service;


import dao.classes.AchievementDaoMySql;
import dao.interfaces.AchievementDao;
import dto.Achievement;
import dto.Comment;
import exception.IncorrectAchievementException;
import exception.IncorrectSightException;
import exception.IncorrectUserException;
import lombok.SneakyThrows;


public class AchievementService {
    private AchievementDao achievementDao = new AchievementDaoMySql();

    @SneakyThrows
    public Achievement[] getAchievementsByUserId(int userId) {
        if (userId < 1) {
            throw new IncorrectUserException();
        }

        Achievement[] achievements = achievementDao.getAchievementsByUsertId(userId);

        if (achievements == null) {
            throw new IncorrectAchievementException();
        }

        return achievements;
    }
}
