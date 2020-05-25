package users;

import posts.*;
import comments.*;
import enums.*;
import exceptions.InvalidStanceException;

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
     */ 
    @Override
    public void canCommentPost(Post post, Comment comment) throws InvalidStanceException {
        Stance commentStance = comment.getStance();
        if (!commentStance.getValue()) throw new InvalidStanceException();
    }
}
