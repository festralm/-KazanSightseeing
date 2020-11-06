package service;


import dao.classes.UserDaoMySql;
import dao.interfaces.UserDao;
import dto.Comment;
import dto.User;
import exception.*;
import lombok.SneakyThrows;

import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.sql.Date;
import java.util.Base64;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;


public class UserService {
    private UserDao userDao = new UserDaoMySql();

    @SneakyThrows
    public boolean isUsernameExists(String username) {
        if (username == null) {
            throw new IncorrectUserException();
        }

        return userDao.isUsernameExists(username);
    }

    @SneakyThrows
    public boolean incrementRating(int userId) {
        if (userId < 1) {
            throw new IncorrectUserException();
        }

        boolean incremented = userDao.incrementRating(userId);

        if (!incremented) {
            throw new CouldNotEditRatingException();
        }

        return true;
    }

    @SneakyThrows
    public boolean authenticateUser(String username, char[] password) {
        if (username == null || password == null) {
            throw new IncorrectUserException();
        }

        String usersPassword = userDao.getPasswordByUsername(username);

        return usersPassword != null && PasswordAuthentication.authenticate(password, usersPassword);
    }

    @SneakyThrows
    public int getUserIdByUsername(String username) {
        if (username == null) {
            throw new IncorrectUserException();
        }

        int id = userDao.getUserIdByUsername(username);
        if (id == 0) {
            throw new IncorrectUserException();
        }

        return id;
    }

    @SneakyThrows
    public boolean addNewUser(String username, char[] password, String email) {

        if (username == null || password == null || email == null) {
            throw new IncorrectUserException();
        }

        boolean added = userDao.addNewUser(
                new User(username, PasswordAuthentication.hashPassword(password), email)
        );

        if (!added) {
            throw new CouldNotAddUserException();
        }
        return true;
    }

    @SneakyThrows
    public int getRatingByUserId(int userId) {
        if (userId < 1) {
            throw new IncorrectUserException();
        }

        int rating = userDao.getRatingByUserId(userId);

        if (rating == -1) {
            throw new IncorrectUserException();
        }

        return rating;
    }

    @SneakyThrows
    public boolean addVisitedSight(int userId, int sightId) {
        if (userId < 1) {
            throw new IncorrectUserException();
        }


        if (sightId < 1) {
            throw new IncorrectSightException();
        }

        UserSightVisitedService userSightVisitedService = new UserSightVisitedService();
        boolean added = userSightVisitedService.addColumn(userId, sightId);
        if (added) {
            incrementRating(userId);
        }

        return true;
    }

    @SneakyThrows
    public User getUserByUserId(int userId) {
        if (userId < 1) {
            throw new IncorrectUserException();
        }

        User user = userDao.getUserByUserId(userId);

        if (user == null) {
            throw new IncorrectUserException();
        }
        return user;
    }

    @SneakyThrows
    public boolean editUserById(String fullname, String username, String email,
                                Date birthdate, char[] password, int userId) {
        if (username == null || password == null || email == null) {
            throw new IncorrectUserException();
        }

        boolean edited = userDao.editUser(
                new User(userId, username, PasswordAuthentication.hashPassword(password), email,
                        birthdate, fullname)
        );

        if (!edited) {
            throw new CouldNotEditUserException();
        }
        return true;
    }

    static class PasswordAuthentication
    {
        public static final String ID = "$31$";
        public static final int cost = 15;
        private static final String ALGORITHM = "PBKDF2WithHmacSHA1";
        private static final int SIZE = 128;
        private static final byte[] salt = new byte[] {-116, 36, 30, -44, 126, 72, 30, -126,
                -39, -21, 51, 121, -72, 77, -113, 57 };

        private static int iterations(int cost)
        {
            if ((cost < 0) || (cost > 30))
                throw new IllegalArgumentException("cost: " + cost);
            return 1 << cost;
        }

        public static String hashPassword(char[] password)
        {
            byte[] dk = pbkdf2(password, salt, 1 << cost);
            byte[] hash = new byte[salt.length + dk.length];
            System.arraycopy(salt, 0, hash, 0, salt.length);
            System.arraycopy(dk, 0, hash, salt.length, dk.length);
            Base64.Encoder enc = Base64.getUrlEncoder().withoutPadding();
            return ID + cost + '$' + enc.encodeToString(hash);
        }

        public static boolean authenticate(char[] password, String token)
        {
            String passwordToken = hashPassword(password);
            return passwordToken.equals(token);
        }

        private static byte[] pbkdf2(char[] password, byte[] salt, int iterations)
        {
            KeySpec spec = new PBEKeySpec(password, salt, iterations, SIZE);
            try {
                SecretKeyFactory f = SecretKeyFactory.getInstance(ALGORITHM);
                return f.generateSecret(spec).getEncoded();
            }
            catch (NoSuchAlgorithmException ex) {
                throw new IllegalStateException("Missing algorithm: " + ALGORITHM, ex);
            }
            catch (InvalidKeySpecException ex) {
                throw new IllegalStateException("Invalid SecretKeyFactory", ex);
            }
        }
    }

}
