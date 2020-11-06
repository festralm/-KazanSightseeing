package dao.classes;


import dao.MySqlConnection;
import dao.interfaces.SightDao;
import dto.Sight;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SightDaoMySql implements SightDao {
    private final MySqlConnection connection = new MySqlConnection();

    @Override
    public Sight getSightById(int sightId) {
        try (Connection con = connection.getNewConnection()) {
            String sql1 = "select name, description, photo_path " +
                    "from kazansightseeing.sight " +
                    "where id = ?";
            try (PreparedStatement preparedStatement = con.prepareStatement(sql1)){
                preparedStatement.setInt(1, sightId);

                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    String name = resultSet.getString(1);
                    String description = resultSet.getString(2);
                    String photoPath = resultSet.getString(3);

                    return new Sight(sightId, name, description, photoPath);
                }
            }
        }
        catch (SQLException exception) {
            System.out.println("Something went wrong...");
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public String[] getArchivePhotoPathsForSight(int sightId) {
        try (Connection con = connection.getNewConnection()) {
            List<String> result = new ArrayList<>();
            String sql1 = "select sight_archive_photo.photo_path " +
                    "from kazansightseeing.sight " +
                    "inner join kazansightseeing.sight_archive_photo " +
                    "on sight.id = sight_archive_photo.sight_id " +
                    "where sight.id = ?";
            try (PreparedStatement preparedStatement = con.prepareStatement(sql1)){
                preparedStatement.setInt(1, sightId);

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    String photoPath = resultSet.getString(1);

                        result.add(photoPath);
                }
                return result.toArray(new String[] {});
            }
        }
        catch (SQLException exception) {
            System.out.println("Something went wrong...");
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addNewSight(Sight sight) {
        try (Connection con = connection.getNewConnection()) {
            String sql = "insert into kazansightseeing.sight " +
                    "(name, description, photo_path) " +
                    "values (?, ?, ?)";
            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setString(1, sight.getName());
                preparedStatement.setString(2, sight.getDescription());
                preparedStatement.setString(3, sight.getPhotoPath());

                preparedStatement.executeUpdate();
                return true;
            }
        } catch (SQLException exception) {
            System.out.println("Something went wrong...");
            exception.printStackTrace();
        }
        return false;
    }
}
