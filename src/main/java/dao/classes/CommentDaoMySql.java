package dao.classes;

import dao.MySqlConnection;
import dao.interfaces.CommentDao;
import dto.Comment;
import exception.IncorrectSightException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentDaoMySql implements CommentDao {
    private final MySqlConnection connection = new MySqlConnection();
    @Override
    public boolean addComment(Comment comment) {
        try (Connection con = connection.getNewConnection()) {
            String sql = "insert into kazansightseeing.comment " +
                    "(user_id, sight_id, description) " +
                    "values (?, ?, ?)";
            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setInt(1, comment.getUserId());
                preparedStatement.setInt(2, comment.getSightId());
                preparedStatement.setString(3, comment.getDescription());

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
    public Comment[] getCommentsBySightId(int sightId) {
        try (Connection con = connection.getNewConnection()) {
            List<Comment> result = new ArrayList<>();
            String sql1 = "select comment.id, comment.user_id, comment.sight_id, " +
                    "comment.description, comment.datetime " +
                    "from kazansightseeing.comment " +
                    "inner join kazansightseeing.user " +
                    "on user.id = comment.user_id " +
                    "where comment.sight_id = ? " +
                    "order by datetime";
            try (PreparedStatement preparedStatement = con.prepareStatement(sql1)){
                preparedStatement.setInt(1, sightId);

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    int userId = resultSet.getInt(2);
                    String description = resultSet.getString(4);
                    Date datetime = resultSet.getDate(5);

                    result.add(new Comment(id, userId, sightId, description, datetime));
                }
                return result.toArray(new Comment[] {});
            }
        }
        catch (SQLException exception) {
            System.out.println("Something went wrong...");
            exception.printStackTrace();
        }
        return null;
    }
}
