package users;

import comments.Comment;
import exceptions.InvalidCommentStanceException;
import exceptions.InvalidStanceException;
import exceptions.UserDoesNotHaveAccessToPostException;
import fanaticisms.Fanaticism;
import posts.Post;
import posts.PostClass;
import enums.*;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FanaticUserClass extends AbstractUser implements FanaticUser {
    
    /* Variables */
    private List<Fanaticism> fanaticisms;

    /**
     * Constructor.
     * @param userId The ID of the fanatic user.
     */
    public FanaticUserClass(String userId, List<Fanaticism> fanaticisms) {
        super(userId, UserKind.FANATIC);
        this.fanaticisms = fanaticisms;
    }
    
    /**
     * Makes a new post (visible to friends).
     * @param postHashtags The posts' hashtags.
     * @param postTruthfulness The posts' truthfulness.
     * @param postMessage The posts' message.
     */
    @Override
    public void post(Set<String> postHashtags, String postTruthfulness, String postMessage) throws InvalidStanceException {
        if (!validPostHashtags(postHashtags, Stance.valueOf(postTruthfulness.toUpperCase()))) {
            throw new InvalidStanceException();
        }
        
        posts.put(posts.size()+1, new PostClass(posts.size()+1, postHashtags, postTruthfulness, postMessage, this));
    }

    /**
     * Checks if the user can comment on a specific post.
     * @param post The post that user would comment on.
     * @param comment The comment to place on the post.
     */
    @Override
    public void canCommentPost(Post post, Comment comment) throws UserDoesNotHaveAccessToPostException, InvalidCommentStanceException {
        if (!(post.getAuthorFriends().containsKey(this.getId()) || post.getAuthorId().equals(this.getId()))) {
            throw new UserDoesNotHaveAccessToPostException(this.getId(), post.getId(), post.getAuthorId());
        }
        
        Set<String> postHashtags = post.getHashtags();
        
        for (Fanaticism fanaticism: fanaticisms) {
            if (postHashtags.contains(fanaticism.getHashtag())) {
                if (fanaticism.getStance() ^ comment.getStance().getValue() ^ post.getTruthfulness().getValue()) {
                    return;
                }
                else {
                    throw new InvalidCommentStanceException();
                }
            }
        }
    }

    /* Private methods */
    
    private boolean validPostHashtags(Set<String> postHashtags, Stance postTruthfulness) {
        for (Fanaticism fanaticism: fanaticisms) {
            if (postHashtags.contains(fanaticism.getHashtag()) && (fanaticism.getStance() != postTruthfulness.getValue())) {
                return false;
            }
        }
        return true;
    }
}