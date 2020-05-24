package users;

import posts.*;
import comments.*;

public class SelfcenteredUserClass extends AbstractUser implements SelfcenteredUser {
    
    /**
     * Constructor.
     * @param userId The ID of the selfcentered user.
     */
    public SelfcenteredUserClass(String userId) {
        super(userId, "selfcentered");
    } 
    
    /**
     * Checks if the user can comment on a specific post.
     * @param post The post that user would comment on.
     * @param comment The comment to place on the post.
     * @return True if the user can comment, false if otherwise.
     */
    @Override
    public boolean canCommentPost(Post post, Comment comment) {
        return post.getAuthorId().equals(this.getId());
    }
}
