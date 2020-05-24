package users;

import exceptions.InvalidStanceException;
import posts.*;
import comments.*;
import enums.*;

import java.util.Set;

public class LiarUserClass extends AbstractUser implements LiarUser {

    /* Variables */
    private int numLies;
    
    /**
     * Constructor.
     * @param userId The ID of the liar user.
     */
    public LiarUserClass(String userId) {
        super(userId, "liar");
        this.numLies = 0;
    }

    /**
     * @return The number of lies.
     */
    @Override
    public int getNumLies() {
        return numLies;
    }
    
    /**
     * Makes a new post (visible to friends).
     * @param postHashtags The posts' hashtags.
     * @param postTruthfulness The posts' truthfulness.
     * @param postMessage The posts' message.
     */
    @Override
    public void post(Set<String> postHashtags, String postTruthfulness, String postMessage) throws InvalidStanceException {
        if (postTruthfulness.equals("honest")) {
            throw new InvalidStanceException();
        }
        
        posts.put(posts.size()+1, new PostClass(posts.size()+1, postHashtags, postTruthfulness, postMessage, this));
    }

    /**
     * Checks if the user can comment on a specific post.
     * @param post The post that user would comment on.
     * @param comment The comment to place on the post.
     * @return True if the user can comment, false if otherwise.
     */
    @Override
    public boolean canCommentPost(Post post, Comment comment) {
        Stance postTruthfulness = post.getTruthfulness();
        Stance commentStance = comment.getStance();
        return postTruthfulness.getValue() != commentStance.getValue();
    }
}
