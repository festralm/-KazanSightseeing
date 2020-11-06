package dao.classes;

import dao.MySqlConnection;
import dao.interfaces.SightArchivePhotoDao;
import dao.interfaces.UserSightVisitedDao;
import dto.Sight;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SightArchivePhotoDaoMySql implements SightArchivePhotoDao {
    private final MySqlConnection connection = new MySqlConnection();
    public boolean isColumnExist(int userId, String photoPath) {
        try (Connection con = connection.getNewConnection()) {
            String sql = "select id " +
                    "from kazansightseeing.sight_archive_photo " +
                    "where sight_id = ? and photo_path = ?";
            try (PreparedStatement preparedStatement = con.prepareStatement(sql)){
                preparedStatement.setInt(1, userId);
                preparedStatement.setString(2, photoPath);

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
    public boolean addNewSightArchivePhoto(int sightId, String photoPath) {
        boolean alreadyExists = isColumnExist(sightId, photoPath);
        if (!alreadyExists) {
            try (Connection con = connection.getNewConnection()) {
                String sql = "insert into kazansightseeing.sight_archive_photo " +
                        "(sight_id, photo_path) " +
                        "values (?, ?)";
                try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                    preparedStatement.setInt(1, sightId);
                    preparedStatement.setString(2, photoPath);

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
}
