package users;

import comments.Comment;
import posts.Post;

public interface User {
    
    /**
     * @return The users' ID.
     */
    String getId();
    
    /**
     * @return The users' kind.
     */
    String getKind();
    
    /**
     * @return Number of friends.
     */
    int getNumFriends();
    
    /**
     * @return Number of posts.
     */
    int getNumPosts();
    
    /**
     * @return Number of comments.
     */
    int getNumComments();
    
    /**
     * Adds another user as a friend.
     * @param user2 The other user.
     */
    void addFriend(User user2);
    
    /**
     * Makes a new post (visible to friends).
     * @param postHashtags The posts' hashtags.
     * @param postTruthfulness The posts' truthfulness.
     * @param postMessage The posts' message.
     */
    void post(DataStructure postHashtags, String postTruthfulness, String postMessage);
    
    /**
     * Adds another users' comment to a post.
     * @param comment The other users' comment.
     */
    void commentPost(Comment comment);
    
    /**
     * Adds a new comment made to another users' post.
     * @param comment The comment made to another users' post.
     */
    void newComment(Comment comment);
    
    /**
     * Gets a post.
     * @param postId The posts' ID.
     * @return The post.
     */
    Post getPost(int postId);
}