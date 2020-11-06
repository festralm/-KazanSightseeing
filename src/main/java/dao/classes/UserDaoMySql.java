package dao.classes;


import dao.MySqlConnection;
import dao.interfaces.UserDao;
import dto.User;
import exception.CouldNotAddUserSightException;
import exception.IncorrectUserException;
import lombok.SneakyThrows;
import service.UserSightVisitedService;

import java.sql.*;

public class UserDaoMySql implements UserDao {
    private final MySqlConnection connection = new MySqlConnection();

    @Override
    public boolean isUsernameExists(String username) {
        try (Connection con = connection.getNewConnection()) {
            String sql = "select id " +
                    "from kazansightseeing.user " +
                    "where username = ?";
            try (PreparedStatement preparedStatement = con.prepareStatement(sql)){
                preparedStatement.setString(1, username);

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

    @SneakyThrows
    @Override
    public boolean incrementRating(int userId) {
        int rating = getRatingByUserId(userId);
        if (rating == -1) {
            throw new IncorrectUserException();
        }
        try (Connection con = connection.getNewConnection()) {
            String sql = "update kazansightseeing.user " +
                    "set rating = ? " +
                    "where id = ?";

            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                int newRating;
                if (rating == 88) {
                    newRating = 100;
                } else {
                    newRating = rating + 100 / 9;
                }
                preparedStatement.setInt(1, newRating);
                preparedStatement.setInt(2, userId);

                preparedStatement.executeUpdate();

                return true;
            }
        } catch (SQLException exception) {
            System.out.println("Something went wrong...");
            exception.printStackTrace();
        }

        return false;
    }

    @Override
    public int getRatingByUserId(int userId) {
        try (Connection con = connection.getNewConnection()) {
            String sql = "select rating " +
                    "from kazansightseeing.user " +
                    "where id = ?";

            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setInt(1, userId);

                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    return resultSet.getInt(1);
                }
            }
        }
        catch (SQLException exception) {
            System.out.println("Something went wrong...");
            exception.printStackTrace();
        }
        return -1;
    }

    @Override
    public String getPasswordByUsername(String username) {
        try (Connection con = connection.getNewConnection()) {
            String sql = "select password " +
                    "from kazansightseeing.user " +
                    "where (username = ?)";

            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setString(1, username);

                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    return resultSet.getString(1);
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
    public int getUserIdByUsername(String username) {
        try (Connection con = connection.getNewConnection()) {
            String sql = "select id " +
                    "from kazansightseeing.user " +
                    "where (username = ?)";

            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setString(1, username);

                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    return resultSet.getInt(1);
                }
            }
        }
        catch (SQLException exception) {
            System.out.println("Something went wrong...");
            exception.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean addNewUser(User user) {
        try (Connection con = connection.getNewConnection()) {
            String sql = "insert into kazansightseeing.user " +
                    "(username, password, email) " +
                    "values (?, ?, ?)";
            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setString(1, user.getUsername());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.setString(3, user.getEmail());

                preparedStatement.executeUpdate();
                return true;
            }
        } catch (SQLException exception) {
            System.out.println("Something went wrong...");
            exception.printStackTrace();
        }
        return false;
    }

    @Override
    public User getUserByUserId(int userId) {
        try (Connection con = connection.getNewConnection()) {
            String sql = "select username, password, email, birthdate, fullname, " +
                    "photo_path, rating " +
                    "from kazansightseeing.user " +
                    "where (id = ?)";

            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setInt(1, userId);

                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    String username = resultSet.getString(1);
                    String password = resultSet.getString(2);
                    String email = resultSet.getString(3);
                    Date birthdate = resultSet.getDate(4);
                    String fullname = resultSet.getString(5);
                    String photoPath = resultSet.getString(6);
                    int rating = resultSet.getInt(7);

                    return new User(userId, username, password, email, birthdate,
                            fullname, photoPath, rating);
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
    public boolean editUser(User user) {
        try (Connection con = connection.getNewConnection()) {
            String sql = "update kazansightseeing.user " +
                    "set username = ?, password = ?, email = ?, birthdate = ?," +
                    "fullname = ? " +
                    "where id = ?";
            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setString(1, user.getUsername());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.setString(3, user.getEmail());
                preparedStatement.setDate(4, user.getBirthdate());
                preparedStatement.setString(5, user.getFullname());
                preparedStatement.setInt(6, user.getId());

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
