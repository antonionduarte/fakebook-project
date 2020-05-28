package users;

import exceptions.InvalidCommentStanceException;
import exceptions.InvalidStanceException;
import exceptions.UserDoesNotHaveAccessToPostException;
import posts.*;
import comments.*;
import enums.*;

import java.util.Set;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 *
 * Manages the functionality concerning a liar user.
 */

public class LiarUserClass extends AbstractUser implements LiarUser {
    
    /**
     * Constructor.
     * @param userId The ID of the liar user.
     */
    public LiarUserClass(String userId) {
        super(userId, UserKind.LIAR);
    }
    
    /**
     * Makes a new post (visible to friends).
     * @param postHashtags The posts' hashtags.
     * @param postTruthfulness The posts' truthfulness.
     * @param postMessage The posts' message.
     */
    @Override
    public void post(Set<String> postHashtags, String postTruthfulness, String postMessage) throws InvalidStanceException {
        if (postTruthfulness.equals(Stance.HONEST.getMessage())) {
            throw new InvalidStanceException();
        }
        
        posts.put(posts.size()+1, new PostClass(posts.size()+1, postHashtags, postTruthfulness, postMessage, this));
        numLies++;
    }

    /**
     * Checks if the user can comment on a specific post.
     * @param post The post that user would comment on.
     * @param comment The comment to place on the post.
     */
    @Override
    public void canCommentPost(Post post, Comment comment) throws UserDoesNotHaveAccessToPostException, InvalidCommentStanceException {
        if (!post.getAuthorFriends().containsKey(this.getId()) && !post.getAuthorId().equals(this.getId())) {
            throw new UserDoesNotHaveAccessToPostException(this.getId(), post.getId(), post.getAuthorId());
        }
        if (post.getTruthfulness().getValue() == comment.getStance().getValue()) {
            throw new InvalidCommentStanceException();
        }
    }
    
}
