package users;

import posts.*;
import comments.*;
import enums.*;

public class NaiveUserClass extends AbstractUser implements NaiveUser {
    
    /**
     * Constructor.
     * @param userId The ID of the naive user.
     */
    public NaiveUserClass(String userId) {
        super(userId, "naive");
    }

    /**
     * Checks if the user can comment on a specific post.
     * @param post The post that user would comment on.
     * @param comment The comment to place on the post.
     * @return True if the user can comment, false if otherwise.
     */ 
    @Override
    public boolean canCommentPost(Post post, Comment comment) {
        Stance commentStance = comment.getStance();
        return commentStance.getValue();
    }
    
}
