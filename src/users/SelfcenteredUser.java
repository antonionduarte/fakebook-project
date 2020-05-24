package users;

import posts.*;
import comments.*;

public interface SelfcenteredUser extends User {
    
    /**
     * Checks if the user can comment on a specific post.
     * @param post The post that user would comment on.
     * @param comment The comment to place on the post.
     */  
    void canCommentPost(Post post, Comment comment);
    
}