package dao.interfaces;

import dto.Comment;
import dto.Sight;
import exception.IncorrectSightException;

public interface CommentDao {

    boolean addComment(Comment comment);

    Comment[] getCommentsBySightId(int sightId);
}
