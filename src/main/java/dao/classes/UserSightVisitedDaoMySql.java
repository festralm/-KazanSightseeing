package dao.classes;

import dao.MySqlConnection;
import dao.interfaces.UserSightVisitedDao;
import dao.interfaces.UserSightWantedDao;
import dto.Achievement;
import dto.Sight;
import exception.IncorrectUserException;
import exception.IncorrectUserSightVisitedException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserSightVisitedDaoMySql implements UserSightVisitedDao {
    private final MySqlConnection connection = new MySqlConnection();

    @Override
    public boolean isColumnExist(int userId, int sightId) {
        try (Connection con = connection.getNewConnection()) {
            String sql = "select id " +
                    "from kazansightseeing.user_sight_visited " +
                    "where user_id = ? and sight_id = ?";
            try (PreparedStatement preparedStatement = con.prepareStatement(sql)){
                preparedStatement.setInt(1, userId);
                preparedStatement.setInt(2, sightId);

                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return true;
                }
            }
        }
        catch (SQLException exception) {
            System.out.println("Something went wrong...");
            exception.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addColumn(int userId, int sightId) {
        boolean alreadyVisited = isColumnExist(userId, sightId);
        if (!alreadyVisited) {
            try (Connection con = connection.getNewConnection()) {
                String sql = "insert into kazansightseeing.user_sight_visited " +
                        "(user_id, sight_id) " +
                        "values (?, ?)";
                try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                    preparedStatement.setInt(1, userId);
                    preparedStatement.setInt(2, sightId);

                    preparedStatement.executeUpdate();
                    return true;
                }
            } catch (SQLException exception) {
                System.out.println("Something went wrong...");
                exception.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Sight[] getVisitedSightsByUserId(int userId) {
        try (Connection con = connection.getNewConnection()) {
            String sql1 = "select sight.id, sight.name," +
                    " sight.description, sight.photo_path " +
                    "from kazansightseeing.sight " +
                    "inner join kazansightseeing.user_sight_visited " +
                    "on sight.id = user_sight_visited.sight_id " +
                    "inner join kazansightseeing.user " +
                    "on user_sight_visited.user_id = user.id " +
                    "where user_id = ? " +
                    "order by sight.name";
            return UserSightWantedDaoMySql.getSights(userId, con, sql1);
        }
        catch (SQLException exception) {
            System.out.println("Something went wrong...");
            exception.printStackTrace();
        }
        return null;
    }
}
