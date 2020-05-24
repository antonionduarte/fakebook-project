package users;

import exceptions.*;
import posts.*;

import java.util.Set;

public interface FanaticUser extends User {

    void post(Set<String> postHashtags, String postTruthfulness, String postMessage) throws InvalidStanceException;
    
    /**
     * Checks if the user can comment on a specific post.
     * @param post The post that user would comment on.
     * @param comment The comment to place on the post.
     * @return True if theu user can comment, false if otherwise.
     */
    boolean canCommentPost(Post post);
}