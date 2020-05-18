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
    
    void post(DataStructure postHashtags, String postTruthfulness, String postMessage);
    
    void newComment(Comment comment);
    
    void commentPost(Comment comment);
    
    Post getPost(String postId);
}