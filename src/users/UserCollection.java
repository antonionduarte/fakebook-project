package users;

import comments.Comment;
import posts.Post;

import java.util.Iterator;

public interface UserCollection {
    
    /**
     * Registers a new user.
     * @param userKind User kind.
     * @param userId The new users' ID.
     */
    void registerUser(String userKind, String userId);
    
    /**
     * Registers a new fanatic user.
     * @param userId The new users' ID.
     * @param fanaticisms The new users' fanaticisms.
     */
    void registerFanatic(String userId, DataStructure fanaticisms);
    
    /**
     * Creates a bidirectional friend relationship between 2 users.
     * @param userId1 The first user.
     * @param userId2 The second user.
     */
    void addFriend(String userId1, String userId2);
    
    /**
     * Allows a user to make a new post (visible to his friends).
     * @param userId The users' ID.
     * @param postHashtags The posts' hashtags.
     * @param postTruthfulness The posts' truthfulness.
     * @param postMessage The posts' message.
     */
    void post(String userId, DataStructure postHashtags, String postTruthfulness, String postMessage);
    
    /**
     * Gets a users' number of friends.
     * @param userId The users' ID.
     * @return The users' number of friends.
     */
    int getUserNumFriends(String userId);
    
    /**
     * Gets a users' number of posts.
     * @param userId The users' ID.
     * @return The users' number of posts.
     */
    int getUserNumPosts(String userId);
    
    /**
     * Allows a user to comment on another users' (or his own) post.
     * @param userIdComment ID of the user that wants to comment on the post.
     * @param userIdPost ID of the author of the post.
     * @param postId The posts' ID.
     * @param commentStance The comments' stance.
     * @param commentMessage The comments' message.
     */
    void commentPost(String userIdComment, String userIdPost, int postId, String commentStance, String commentMessage);
    
    /**
     * Gets a users' specified post.
     * @param userId The users' ID.
     * @param postId The posts' ID.
     * @return The users' post.
     */
    Post getUserPost(String userId, String postId);
    
    /**
     * @return The most popular post.
     */
    Post getMostPopularPost();
    
    /**
     * @return The top poster.
     */
    User getTopPoster();
    
    /**
     * @return The top responsive user.
     */
    User getTopResponsive();
    
    /**
     * @return The user with the most lies.
     */
    LiarUser getTopLiar();
    
    /**
     * @return New users iterator.
     */
    Iterator<User> newUsersIterator();
    
    /**
     * Creates a new iterator for a users' friends.
     * @param userId The users' ID.
     * @return New users' friends iterator.
     */
    Iterator<User> newUserFriendsIterator(String userId);
    
    /**
     * Creates a new iterator for a users' posts.
     * @param userId The users' ID.
     * @return New users' posts iterator.
     */
    Iterator<Post> newUserPostsIterator(String userId);
    
    /**
     * Creates a new iterator for a users' comments about a certain hashtag.
     * @param userId The users' ID.
     * @param hashtag The posts' hashtag.
     * @return New user comments iterator.
     */
    Iterator<Comment> newUserCommentsIterator(String userId, String hashtag);
    
    /**
     * Creates a new iterator for all of a specified hashtags' fanatics.
     * @param hashtag The specified hashtag.
     * @return New topic fanatics iterator.
     */
    Iterator<User> newTopFanaticsIterator(String hashtag);
    
}