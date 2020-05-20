package posts;

import java.util.Iterator;
import users.*;
import comments.*;

public class PostClass implements Post {

    /* Variables */
    private int postId;
    private User author;
    private boolean truthfulness;
    private String message;
    private CommentCollection comments;

    /**
     * Constructor.
     * @param postId The ID of the post.
     * @param truthfulness The truthfulness of the post.
     * @param message The message of the post.
     */
    public PostClass(int postId, boolean truthfulness, String message, User author) {
        this.postId = postId;
        this.truthfulness = truthfulness;
        this.message = message;
        this.author = author;
        this.comments = new CommentCollectionClass();
    }

    /**
     * @return The posts authors' ID.
     */
    @Override
    public int getId() {
        return postId;
    }

    /**
     * @return The posts' truthfulness.
     */
    @Override
    public boolean getTruthfulness() {
        return truthfulness;
    }

    /**
     * @return The posts' message.
     */
    @Override
    public String getMessage() {
        return message;
    }

    /**
     * @return Number of comments on the post.
     */
    @Override
    public int getNumComments() {
        return comments.getSize();
    }
 
    /**
     * @return The post authors' ID.
     */
    @Override
    public String getAuthorId() {
        return author.getId();
    }

    /**
     * @return New comments iterator.
     */
    @Override
    public Iterator<Comment> newCommentsIterator() {
        return comments.newCommentsIterator();
    }
    
}