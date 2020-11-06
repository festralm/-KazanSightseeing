package dao.interfaces;

import dto.User;
import exception.CouldNotAddUserSightException;
import exception.IncorrectUserException;

public interface UserDao {

    boolean isUsernameExists(String username);

    boolean incrementRating(int userId) throws IncorrectUserException, CouldNotAddUserSightException;

    int getRatingByUserId(int userId);

    String getPasswordByUsername(String username);

    int getUserIdByUsername(String username);

    boolean addNewUser(User user);

    User getUserByUserId(int userId);

    boolean editUser(User user);
}
