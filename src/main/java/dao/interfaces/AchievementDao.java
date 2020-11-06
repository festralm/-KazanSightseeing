package dao.interfaces;

import dto.Achievement;
import dto.Comment;

public interface AchievementDao {
    Achievement[] getAchievementsByUsertId(int userId);
}
