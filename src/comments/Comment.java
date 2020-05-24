package comments;

import java.util.Iterator;

public interface Comment {
    
    /**
     * @return The comment authors' ID.
     */
    String getAuthorId();
    
    /**
     * @return The comments' stance.
     */
    String getStance();
    
    /**
     * @return The comments' message.
     */
    String getMessage();
    
    /**
     * @return ID of the posts' author (where the comment is located in).
     */
    String getPostAuthorId();
    
    /**
     * @return The posts' truthfulness (where the comment is located in).
     */
    String getPostTruthfulness();
    
    /**
     * @return ID of the post where the comment is located in.
     */
    int getPostId();
    
    /**
     * @return New post hashtags iterator.
     */
    Iterator<String> newPostHashtagsIterator();
    
}