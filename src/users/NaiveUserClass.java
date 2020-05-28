package users;

import exceptions.UserDoesNotHaveAccessToPostException;
import posts.*;
import comments.*;
import enums.*;
import exceptions.InvalidStanceException;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 */

public class NaiveUserClass extends AbstractUser implements NaiveUser {
    
    /**
     * Constructor.
     * @param userId The ID of the naive user.
     */
    public NaiveUserClass(String userId) {
        super(userId, UserKind.NAIVE);
    }

    /**
     * Checks if the user can comment on a specific post.
     * @param post The post the user wants to comment on.
     * @param comment The comment to place on the post.
     */ 
    @Override
    public void canCommentPost(Post post, Comment comment) throws UserDoesNotHaveAccessToPostException, InvalidStanceException {
        if (!(post.getAuthorFriends().containsKey(this.getId()) || post.getAuthorId().equals(this.getId()))) {
            throw new UserDoesNotHaveAccessToPostException(this.getId(), post.getId(), post.getAuthorId());
        }
        if (!comment.getStance().getValue()) {
            throw new InvalidStanceException();
        }
    }
}
