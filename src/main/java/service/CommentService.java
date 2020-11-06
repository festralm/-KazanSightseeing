package service;


import dao.classes.CommentDaoMySql;
import dao.classes.UserDaoMySql;
import dao.interfaces.CommentDao;
import dao.interfaces.UserDao;
import dto.Comment;
import exception.*;
import lombok.SneakyThrows;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;


public class CommentService {
    private CommentDao commentDao = new CommentDaoMySql();

    @SneakyThrows
    public boolean addComment(int userId, int sightId, String comment) {
        if (userId < 1) {
            throw new IncorrectUserException();
        }
        if (sightId < 1) {
            throw new IncorrectSightException();
        }
        if (comment == null) {
            throw new IncorrectCommentException();
        }

        boolean added = commentDao.addComment(new Comment(userId, sightId, comment));

        if (!added) {
            throw new CouldNotAddCommentException();
        }
        return true;
    }

    @SneakyThrows
    public Comment[] getCommentsBySightId(int sightId) {
        if (sightId < 1) {
            throw new IncorrectSightException();
        }

        Comment[] comments = commentDao.getCommentsBySightId(sightId);

        if (comments == null) {
            throw new IncorrectSightException();
        }

        return comments;
    }
}
