package users;

import posts.*;
import comments.*;
import exceptions.*;

import java.util.Set;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 */

public interface LiarUser extends User {

    /**
     * Makes a new post (visible to friends).
     * @param postHashtags The posts' hashtags.
     * @param postTruthfulness The posts' truthfulness.
     * @param postMessage The posts' message.
     */
    void post(Set<String> postHashtags, String postTruthfulness, String postMessage) throws InvalidStanceException;

    /**
     * Checks if the user can comment on a specific post.
     * @param post The post that user would comment on.
     * @param comment The comment to place on the post.
     */
    void canCommentPost(Post post, Comment comment) throws InvalidStanceException;
}