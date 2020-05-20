package posts;

import comments.Comment;

import java.util.Iterator;

public interface Post {
    
    /**
     * @return The posts' ID.
     */
    int getId();
    
    /**
     * @return The posts' truthfulness.
     */
    boolean getTruthfulness();
    
    /**
     * @return The posts' message.
     */
    String getMessage();
    
    /**
     * @return Number of comments on the post.
     */
    int getNumComments();
    
    /**
     * @return The posts authors' ID.
     */
    String getAuthorId();
    
    /**
     * @return New comments iterator.
     */
    Iterator<Comment> newCommentsIterator();
    
}