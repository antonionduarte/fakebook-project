package comments;

import enums.*;
import users.*;
import posts.*;

import java.util.Set;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 */

public class CommentClass implements Comment {

    /* Variables */
    private User userComment;
    private Post post;
    private String message;
    private Stance stance;
    
    public CommentClass(User userComment, Post post, String commentStance, String commentMessage) {
        this.userComment = userComment;
        this.post = post;
        this.stance = Stance.valueOf(commentStance.toUpperCase());
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
    public Stance getStance() {
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
        return post.getTruthfulness().getMessage();
    }

    /**
     * @return ID of the post where the comment is located in.
     */
    @Override
    public int getPostId() {
        return post.getId();
    }
    
    /**
     * @return Post in which the comment is located in.
     */
    @Override
    public Post getPost() {
        return post;
    }
    
    /**
     * @return New post hashtags iterator.
     */
    @Override
    public Set<String> getPostHashtags() {
        return post.getHashtags();
    }
    
}
