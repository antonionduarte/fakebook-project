package users;

import comments.Comment;
import exceptions.InvalidStanceException;
import fanaticisms.Fanaticism;
import posts.Post;
import posts.PostClass;

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
        super(userId, "fanatic");
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
        if (validPostHashtags(postHashtags)) {
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
        return false;
    }

    /* Private methods */
    
    private boolean validPostHashtags(Set<String> postHashtags) {
        Iterator<Fanaticism> iterator = fanaticisms.iterator();

        while (iterator.hasNext()) {
            Fanaticism fanaticism = iterator.next();

            if (postHashtags.contains(fanaticism.getHashtag()) && !fanaticism.getStance()) {
                return false;
            }
        }
        return true;
    }



    // private void postCoiso() {
    //     int coiso = fanaticisms.indexOf(fanaticism);
    // }
    
    /**
     * Olhando para aquilo up there, a ideia vai ser comparar
     * a posição na Lista dos fanaticismos. (ig)?
     */
    
}