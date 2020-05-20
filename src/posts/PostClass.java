package posts;

import java.util.Iterator;
import users.*;
import comments.Comment;

public class PostClass implements Post {

    /* Variables */

    private int postId, numComments;

    private User author;

    private boolean truthfulness;

    private String message;

    /* Constructor */

    /**
     * The Constructor of PostClass.
     * @param postId The ID of the post.
     * @param truthfulness The truthfulness of the post.
     * @param message The message of the post.
     */
    public PostClass(int postId, boolean truthfulness, String message, User author) {
        this.postId = postId;
        this.truthfulness = truthfulness;
        this.message = message;
        this.numComments = 0;
        this.author = author;
    }

    /* Methods */


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
     * 
     */
    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public int getNumComments() {
        return numComments;
    }

    @Override
    public String getAuthorId() {
        return author.getId();
    }

    @Override
    public Iterator<Comment> newCommentsIterator() {
        return comments.newCommentsIterator();
    }
    
}