package posts;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import users.*;
import comments.*;

public class PostClass implements Post {

    /* Variables */
    private int postId;
    private User author;
    private boolean truthfulness;
    private String message;
    private List<Comment> comments;

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
        this.comments = new LinkedList<>();
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
     * Adds a new comment to the post.
     * @param comment New comment.
     */
    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    /**
     * @return Number of comments on the post.
     */
    @Override
    public int getNumComments() {
        return comments.size();
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
        return comments.iterator();
    }
    
}