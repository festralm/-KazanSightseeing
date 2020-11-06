package dao.classes;

import dao.MySqlConnection;
import dao.interfaces.UserSightVisitedDao;
import dao.interfaces.UserSightWantedDao;
import dto.Sight;
import exception.IncorrectUserSightWantedException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserSightWantedDaoMySql implements UserSightWantedDao {
    private final MySqlConnection connection = new MySqlConnection();

    @Override
    public boolean isColumnExist(int userId, int sightId) {
        try (Connection con = connection.getNewConnection()) {
            String sql = "select id " +
                    "from kazansightseeing.user_sight_wanted " +
                    "where user_id = ? and sight_id = ?";
            try (PreparedStatement preparedStatement = con.prepareStatement(sql)){
                preparedStatement.setInt(1, userId);
                preparedStatement.setInt(2, sightId);

                ResultSet resultSet = preparedStatement.executeQuery();

                return resultSet.next();
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
                String sql = "insert into kazansightseeing.user_sight_wanted " +
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
    public Sight[] getWantedSightsByUserId(int userId) {
        try (Connection con = connection.getNewConnection()) {
            String sql1 = "select sight.id, sight.name," +
                    " sight.description, sight.photo_path " +
                    "from kazansightseeing.sight " +
                    "inner join kazansightseeing.user_sight_wanted " +
                    "on sight.id = user_sight_wanted.sight_id " +
                    "inner join kazansightseeing.user " +
                    "on user_sight_wanted.user_id = user.id " +
                    "where user_id = ? " +
                    "order by sight.name";
            return getSights(userId, con, sql1);
        }
        catch (SQLException exception) {
            System.out.println("Something went wrong...");
            exception.printStackTrace();
        }
        return null;
    }

    static Sight[] getSights(int userId, Connection con, String sql1) throws SQLException {
        try (PreparedStatement preparedStatement = con.prepareStatement(sql1)){
            preparedStatement.setInt(1, userId);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Sight> result = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String description = resultSet.getString(3);
                String photoPath = resultSet.getString(4);

                result.add(new Sight(id, name, description, photoPath));
            }
            return result.toArray(new Sight[] {});
        }
    }
}
