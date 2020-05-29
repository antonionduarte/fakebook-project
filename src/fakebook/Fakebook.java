package fakebook;

import comments.Comment;
import exceptions.*;
import fanaticisms.Fanaticism;
import posts.Post;
import users.FanaticUser;
import users.User;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 *
 * Manages all the fakebook operations and interactions between users.
 */

public interface Fakebook {
    
    /**
     * Registers a new user.
     * @param userKind User kind.
     * @param userId The new users' ID.
     */
    void registerUser(String userKind, String userId) throws InvalidUserKindException, UserAlreadyExistsException;
    
    /**
     * Checks if a user kind is "fanatic".
     * @param userKind The user kind.
     * @return True if the user kind is "fanatic".
     */
    boolean userKindIsFanatic(String userKind);
    
    /**
     * Registers a new fanatic user.
     * @param userId The new users' ID.
     * @param fanaticisms The new users' fanaticisms.
     */
    void registerFanatic(String userId, List<Fanaticism> fanaticisms) throws UserAlreadyExistsException;
    
    /**
     * Creates a bidirectional friend relationship between 2 users.
     * @param userId1 The first user.
     * @param userId2 The second user.
     */
    void addFriend(String userId1, String userId2) throws UserDoesNotExistException, SameUserException;
    
    /**
     * Allows a user to make a new post (visible to his friends).
     * @param userId The users' ID.
     * @param postHashtags The posts' hashtags.
     * @param postTruthfulness The posts' truthfulness.
     * @param postMessage The posts' message.
     */
    void post(String userId, Set<String> postHashtags, String postTruthfulness, String postMessage) throws UserDoesNotExistException;
    
    /**
     * Gets a specified user.
     * @param userId The users' ID.
     * @return The specified user.
     */
    User getUser(String userId);
    
    /**
     * Allows a user to comment on another users' (or his own) post.
     * @param userIdComment ID of the user that wants to comment on the post.
     * @param userIdPost ID of the author of the post.
     * @param postId The posts' ID.
     * @param commentStance The comments' stance.
     * @param commentMessage The comments' message.
     */
    void commentPost(String userIdComment, String userIdPost, int postId, String commentStance, String commentMessage) throws UserDoesNotExistException;
    
    /**
     * Gets a users' specified post.
     * @param userId The users' ID.
     * @param postId The posts' ID.
     * @return The users' post.
     */
    Post getUserPost(String userId, int postId) throws UserDoesNotExistException;
    
    /**
     * @return The most popular post.
     */
    Post getTopPost() throws NoTopPostException;
    
    /**
     * @return The top poster.
     */
    User getTopPoster() throws NoTopPosterException;
    
    /**
     * @return The top responsive user.
     */
    User getTopResponsive() throws NoTopResponsiveException;
    
    /**
     * @return The user with the most lies.
     */
    User getTopLiar() throws NoTopLiarException;
    
    /**
     * @return New users iterator.
     */
    Iterator<User> newUsersIterator() throws NoUsersException;
    
    /**
     * Creates a new iterator for a users' friends.
     * @param userId The users' ID.
     * @return New users' friends iterator.
     */
    Iterator<User> newUserFriendsIterator(String userId) throws UserDoesNotExistException;
    
    /**
     * Creates a new iterator for a users' posts.
     * @param userId The users' ID.
     * @return New users' posts iterator.
     */
    Iterator<Post> newUserPostsIterator(String userId) throws UserDoesNotExistException;
    
    /**
     * Creates a new iterator for a users' comments about a certain hashtag.
     * @param userId The users' ID.
     * @param hashtag The posts' hashtag.
     * @return New user comments iterator.
     */
    Iterator<Comment> newUserCommentsIterator(String userId, String hashtag) throws UserDoesNotExistException;
    
    /**
     * Creates a new iterator for all of a specified hashtags' fanatics.
     * @param hashtag The specified hashtag.
     * @return New topic fanatics iterator.
     */
    Iterator<FanaticUser> newTopicFanaticsIterator(String hashtag) throws InvalidFanaticismException;
    
    /**
     * Creates a new Iterator of a specific amount of posts on a given topic.
     * @param hashtag Topic hashtag to iterate posts from.
     * @param amount Amount of posts to iterate.
     * @return New topic posts iterator.
     */
    Iterator<Post> newTopicPostsIterator(String hashtag, int amount) throws InvalidNumberOfPostsException, InvalidHashtagException;
    
}
