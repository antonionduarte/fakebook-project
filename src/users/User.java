package users;

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
}