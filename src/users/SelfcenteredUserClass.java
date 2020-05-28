package users;

import enums.UserKind;
import posts.*;
import comments.*;
import exceptions.UserCannotCommentOnPostException;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 */

public class SelfcenteredUserClass extends AbstractUser implements SelfcenteredUser {
    
    /**
     * Constructor.
     * @param userId The ID of the selfcentered user.
     */
    public SelfcenteredUserClass(String userId) {
        super(userId, UserKind.SELFCENTERED);
    } 
    
    /**
     * Checks if the user can comment on a specific post.
     * @param post The post that user would comment on.
     * @param comment The comment to place on the post.
     */
    @Override
    public void canCommentPost(Post post, Comment comment) throws UserCannotCommentOnPostException {
        if (!post.getAuthorId().equals(this.getId())) {
            throw new UserCannotCommentOnPostException(this.getId());
        }
    }
}
