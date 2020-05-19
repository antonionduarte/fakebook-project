package fakebook;

import comments.Comment;
import posts.Post;
import users.LiarUser;
import users.User;
import users.UserCollection;
import users.UserCollectionClass;

import java.util.Iterator;

public class FakebookClass implements Fakebook {
    
    /* Variables */
    private UserCollection users;
    
    /* Constructor */
    public FakebookClass() {
        users = new UserCollectionClass();
    }
    
    /**
     * Checks if the specified user kind is "fanatic".
     * @param userKind User kind.
     */
    @Override
    public boolean userKindIsFanatic(String userKind) {
        return userKind.equals("fanatic");
    }
    
    /**
     * Registers a new user.
     * @param userKind User kind.
     * @param userId The new users' ID.
     */
    @Override
    public void registerUser(String userKind, String userId) {
        users.registerUser(userKind, userId);
    }
    
    /**
     * Registers a new fanatic user.
     * @param userId The new users' ID.
     * @param fanaticisms The new users' fanaticisms.
     */
    @Override
    public void registerFanatic(String userId, DataStructure fanaticisms) {
        users.registerFanatic(userId, fanaticisms);
    }
    
    /**
     * Creates a bidirectional friend relationship between 2 users.
     * @param userId1 The first user.
     * @param userId2 The second user.
     */
    @Override
    public void addFriend(String userId1, String userId2) {
        users.addFriend(userId1, userId2);
    }
    
    /**
     * Allows a user to make a new post (visible to his friends).
     * @param userId The users' ID.
     * @param postHashtags The posts' hashtags.
     * @param postTruthfulness The posts' truthfulness.
     * @param postMessage The posts' message.
     */
    @Override
    public void post(String userId, DataStructure postHashtags, String postTruthfulness, String postMessage) {
        users.post(userId, postHashtags, postTruthfulness, postMessage);
    }
    
    /**
     * Gets a users' number of friends.
     * @param userId The users' ID.
     * @return The users' number of friends.
     */
    @Override
    public int getUserNumFriends(String userId) {
        return users.getUserNumFriends(userId);
    }
    
    /**
     * Gets a users' number of posts.
     * @param userId The users' ID.
     * @return The users' number of posts.
     */
    @Override
    public int getUserNumPosts(String userId) {
        return users.getUserNumPosts(userId);
    }
    
    /**
     * Allows a user to comment on another users' (or his own) post.
     * @param userIdComment ID of the user that wants to comment on the post.
     * @param userIdPost ID of the author of the post.
     * @param postId The posts' ID.
     * @param commentStance The comments' stance.
     * @param commentMessage The comments' message.
     */
    @Override
    public void commentPost(String userIdComment, String userIdPost, int postId, String commentStance, String commentMessage) {
        users.commentPost(userIdComment, userIdPost, postId, commentStance, commentMessage);
    }
    
    /**
     * Gets a users' specified post.
     * @param userId The users' ID.
     * @param postId The posts' ID.
     * @return The users' post.
     */
    @Override
    public Post getUserPost(String userId, String postId) {
        return users.getUserPost(userId, postId);
    }
    
    /**
     * @return The most popular post.
     */
    @Override
    public Post getTopPost() {
        return users.getTopPost();
    }
    
    /**
     * @return The top poster.
     */
    @Override
    public User getTopPoster() {
        return users.getTopPoster();
    }
    
    /**
     * @return The top responsive user.
     */
    @Override
    public User getTopResponsive() {
        return users.getTopResponsive();
    }
    
    /**
     * @return The user with the most lies.
     */
    @Override
    public LiarUser getTopLiar() {
        return users.getTopLiar();
    }
    
    /**
     * @return New users iterator.
     */
    @Override
    public Iterator<User> newUsersIterator() {
        return users.newUsersIterator();
    }
    
    /**
     * Creates a new iterator for a users' friends.
     * @param userId The users' ID.
     * @return New users' friends iterator.
     */
    @Override
    public Iterator<User> newUserFriendsIterator(String userId) {
        return users.newUserFriendsIterator(userId);
    }
    
    /**
     * Creates a new iterator for a users' posts.
     * @param userId The users' ID.
     * @return New users' posts iterator.
     */
    @Override
    public Iterator<Post> newUserPostsIterator(String userId) {
        return users.newUserPostsIterator(userId);
    }
    
    /**
     * Creates a new iterator for a users' comments about a certain hashtag.
     * @param userId The users' ID.
     * @param hashtag The posts' hashtag.
     * @return New user comments iterator.
     */
    @Override
    public Iterator<Comment> newUserCommentsIterator(String userId, String hashtag) {
        return users.newUserCommentsIterator(userId, hashtag);
    }
    
    /**
     * Creates a new iterator for all of a specified hashtags' fanatics.
     * @param hashtag The specified hashtag.
     * @return New topic fanatics iterator.
     */
    @Override
    public Iterator<User> newTopicFanaticsIterator(String hashtag) {
        return users.newTopFanaticsIterator(hashtag);
    }
    
}
