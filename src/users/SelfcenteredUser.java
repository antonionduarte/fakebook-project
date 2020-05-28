package users;

import posts.*;
import comments.*;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 *
 * Manages the functionality concerning a self centered user.
 */

public interface SelfcenteredUser extends User {
    
    /**
     * Checks if the user can comment on a specific post.
     * @param post The post that user would comment on.
     * @param comment The comment to place on the post.
     */  
    void canCommentPost(Post post, Comment comment);
}
