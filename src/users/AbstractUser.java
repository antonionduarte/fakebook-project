package users;

import comments.Comment;
import posts.Post;

public abstract class AbstractUser implements User {

    /* Variables */
    private String userId, userKind;
    
    /**
     * Constructor.
     * @param userId
     * @param userKind
     */
    protected AbstractUser(String userId, String userKind) {
        this.userId = userId;
        this.userKind = userKind;
    }
    
    /**
     * @return The users' ID.
     */
    @Override
    public String getId() {
        return null;
    }
    
    /**
     * @return The users' kind.
     */
    @Override
    public String getKind() {
        return null;
    }
    
    /**
     * @return Number of friends.
     */
    @Override
    public int getNumFriends() {
        return 0;
    }
    
    /**
     * @return Number of posts.
     */
    @Override
    public int getNumPosts() {
        return 0;
    }
    
    /**
     * @return Number of comments.
     */
    @Override
    public int getNumComments() {
        return 0;
    }
    
    /**
     * Adds another user as a friend.
     * @param user2 The other user.
     */
    @Override
    public void addFriend(User user2) {
    
    }
    
    /**
     * Makes a new post (visible to friends).
     * @param postHashtags The posts' hashtags.
     * @param postTruthfulness The posts' truthfulness.
     * @param postMessage The posts' message.
     */
    @Override
    public void post(DataStructure postHashtags, String postTruthfulness, String postMessage) {
    
    }
    
    /**
     * Adds another users' comment to a post.
     * @param comment The other users' comment.
     */
    @Override
    public void commentPost(Comment comment) {
    
    }
    
    /**
     * Adds a new comment made to another users' post.
     * @param comment The comment made to another users' post.
     */
    @Override
    public void newComment(Comment comment) {
    
    }
    
    /**
     * Gets a post.
     * @param postId The posts' ID.
     * @return The post.
     */
    @Override
    public Post getPost(int postId) {
        return null;
    }
}