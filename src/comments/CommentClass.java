package comments;

import users.*;
import posts.*;

public class CommentClass implements Comment {

    /* Variables */

    private User userComment;

    private Post post;

    private String stance, message;
    
    public CommentClass(User userComment, Post post, String commentStance, String commentMessage) {
        this.stance = commentStance;
        this.userComment = userComment;
        this.post = post;
        this.stance = commentStance;
        this.message = commentMessage;
    }

    /**
     * @return The comment authors' ID.
     */
    @Override
    public String getAuthorId() {
        return userComment.getId();
    }

    /**
     * @return The comments' stance.
     */
    @Override
    public String getStance() {
        return stance;
    }

    /**
     * @return The comments' message.
     */
    @Override
    public String getMessage() {
        return message;
    }

    /**
     * @return ID of the posts' author (where the comment is located in).
     */
    @Override
    public String getPostAuthorId() {
        return post.getAuthorId();
    }

    /**
     * @return The posts' truthfulness (where the comment is located in).
     */
    @Override
    public String getPostTruthfulness() {
        // TODO: Make this work with an enum
        return null;
    }

    /**
     * @return ID of the post where the comment is located in.
     */
    @Override
    public int getPostId() {
        return post.getId();
    }
    
}
