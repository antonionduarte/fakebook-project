package posts;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.List;
import java.util.Set;

import users.*;
import comments.*;

public class PostClass implements Post {

    /* Variables */
    private int postId;
    private Set<String> hashtags;
    private boolean truthfulness;
    private String message;
    private User author;
    private List<Comment> comments;
    private SortedMap<String, User> authorFriends; 

    /**
     * Constructor.
     * @param postId The ID of the post.
     * @param truthfulness The truthfulness of the post.
     * @param message The message of the post.
     */
    public PostClass(int postId, Set<String> hashtags, String truthfulness, String message, User author) {
        this.postId = postId;
        this.hashtags = hashtags;
        this.truthfulness = truthfulness.equals("honest");
        this.message = message;
        this.author = author;
        this.comments = new LinkedList<>();
        this.authorFriends = new TreeMap<>(author.getFriends());
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

    /**
     * Returns the friend list of the author of the post, at the time of creation.
     * @return The friend list of the post's author at creation time.
     */
    @Override
    public SortedMap<String, User> getAuthorFriends() {
        return authorFriends;
    }
    
}