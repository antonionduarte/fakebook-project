package users;

import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Map;
import comments.*;
import posts.*;

public abstract class AbstractUser implements User {

    /* Variables */
    private String userId, userKind;
    private int numFriends, numComments, numPosts;
    private SortedMap<String, User> friends;
    private PostCollection posts;
    private CommentCollection comments;

    /**
     * Constructor.
     * @param userId The users' ID.
     * @param userKind The users' kind.
     */
    protected AbstractUser(String userId, String userKind) {
        this.friends = new TreeMap<String, User>();
        this.posts = new PostCollectionClass();
        this.comments = new CommentCollectionClass();
        this.numPosts = 0;
        this.numComments = 0;
        this.numFriends = 0;
        this.userId = userId;
        this.userKind = userKind;
    }
    
    /**
     * @return The users' ID.
     */
    @Override
    public String getId() {
        return userId;
    }
    
    /**
     * @return The users' kind.
     */
    @Override
    public String getKind() {
        return userKind;
    }
    
    /**
     * @return Number of friends.
     */
    @Override
    public int getNumFriends() {
        return numFriends;
    }
    
    /**
     * @return Number of posts.
     */
    @Override
    public int getNumPosts() {
        return numPosts;
    }
    
    /**
     * @return Number of comments.
     */
    @Override
    public int getNumComments() {
        return numComments;
    }
    
    /**
     * Adds another user as a friend.
     * @param user The other user.
     */
    @Override
    public void addFriend(User user) {
        friends.put(user.getId(), user);
    }
    
    /**
     * Makes a new post (visible to friends).
     * @param postHashtags The posts' hashtags.
     * @param postTruthfulness The posts' truthfulness.
     * @param postMessage The posts' message.
     */
    @Override
    public void post(Map postHashtags, String postTruthfulness, String postMessage) {
        posts.addPost(postHashtags, postTruthfulness, postMessage);
    }
    
    /**
     * Adds another users' comment to a post.
     * @param comment The other users' comment.
     * @param postId The ID of the post to add the comment to.
     */
    @Override
    public void commentPost(String postId, Comment comment) {
        posts.addComment(postId, comment);
    }
    
    /**
     * Adds a new comment made to another users' post.
     * @param comment The comment made to another users' post.
     */
    @Override
    public void newComment(Comment comment) {
        comments.addComment(comment);
    }
    
    /**
     * Gets a post.
     * @param postId The posts' ID.
     * @return The post.
     */
    @Override
    public Post getPost(int postId) {
        return posts.getPost(postId);
    }
}