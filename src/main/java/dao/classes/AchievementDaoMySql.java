package dao.classes;

import dao.MySqlConnection;
import dao.interfaces.AchievementDao;
import dto.Achievement;
import dto.Comment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AchievementDaoMySql implements AchievementDao {
    private final MySqlConnection connection = new MySqlConnection();

    @Override
    public Achievement[] getAchievementsByUsertId(int userId) {
        try (Connection con = connection.getNewConnection()) {
            String sql1 = "select achievement.id, achievement.name, " +
                    "achievement.photo_path, achievement.description " +
                    "from kazansightseeing.achievement " +
                    "inner join kazansightseeing.user_achievement " +
                    "on achievement.id = user_achievement.achievement_id " +
                    "inner join kazansightseeing.user " +
                    "on user_achievement.user_id = user.id " +
                    "where user_id = ? " +
                    "order by achievement.name";
            try (PreparedStatement preparedStatement = con.prepareStatement(sql1)){
                preparedStatement.setInt(1, userId);

                ResultSet resultSet = preparedStatement.executeQuery();

                List<Achievement> result = new ArrayList<>();
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String photoPath = resultSet.getString(3);
                    String description = resultSet.getString(4);

                    result.add(new Achievement(id, name, photoPath, description));
                }
                return result.toArray(new Achievement[] {});
            }
        }
        catch (SQLException exception) {
            System.out.println("Something went wrong...");
            exception.printStackTrace();
        }
        return null;
    }
}
