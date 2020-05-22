package users;

import comments.Comment;
import exceptions.UserHasNoCommentsException;
import exceptions.UserHasNoFriendsException;
import exceptions.UserHasNoPostsException;
import exceptions.UsersAlreadyFriendsException;
import posts.Post;
import java.util.Map;

import java.util.Iterator;

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
     * @param user The other user.
     */
    void addFriend(User user) throws UsersAlreadyFriendsException;
    
    /**
     * Makes a new post (visible to friends).
     * @param postHashtags The posts' hashtags.
     * @param postTruthfulness The posts' truthfulness.
     * @param postMessage The posts' message.
     */
    void post(Map postHashtags, String postTruthfulness, String postMessage);
    
    /**
     * Adds another users' comment to a post.
     * @param comment The other users' comment.
     * @param postId The ID of the post to add the comment to.
     */
    void commentPost(String postId, Comment comment);
    
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
    
    /**
     * @return The percentage of commented posts in relation to the total posts available to the user.
     */
    boolean getResponsiveness();
    
    /**
     * @return New friends iterator.
     */
    Iterator<User> newFriendsIterator() throws UserHasNoFriendsException;
    
    /**
     * @return New posts iterator.
     */
    Iterator<Post> newPostsIterator() throws UserHasNoPostsException;
    
    /**
     * Creates a new iterator for all the comments about a certain hashtag.
     * @param hashtag The posts' hashtag.
     * @return New user comments iterator.
     */
    Iterator<Comment> newCommentsIterator(String hashtag) throws UserHasNoCommentsException;
    
}
