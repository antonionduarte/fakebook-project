package users;

import java.util.*;

import comments.*;
import exceptions.PostDoesNotExistException;
import exceptions.UserHasNoCommentsException;
import exceptions.UserHasNoFriendsException;
import exceptions.UserHasNoPostsException;
import exceptions.UsersAlreadyFriendsException;
import posts.*;

public abstract class AbstractUser implements User {

    /* Variables */
    private String userId, userKind;
    private SortedMap<String, User> friends;
    protected SortedMap<Integer, Post> posts;
    private Map<String, List<Comment>> comments;

    /**
     * Constructor.
     * @param userId The users' ID.
     * @param userKind The users' kind.
     */
    protected AbstractUser(String userId, String userKind) {
        this.friends = new TreeMap<String, User>();
        this.posts = new TreeMap<>();
        this.comments = new HashMap<>();
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
        return friends.size();
    }
    
    /**
     * @return Number of posts.
     */
    @Override
    public int getNumPosts() {
        return posts.size();
    }
    
    /**
     * @return Number of comments.
     */
    @Override
    public int getNumComments() {
        return comments.size();
    }
    
    /**
     * Adds another user as a friend.
     * @param user The other user.
     */
    @Override
    public void addFriend(User user) throws UsersAlreadyFriendsException {
        if (friends.containsKey(user.getId())) {
            throw new UsersAlreadyFriendsException(userId, user.getId());
        }
        
        friends.put(user.getId(), user);
    }
    
    /**
     * Makes a new post (visible to friends).
     * @param postHashtags The posts' hashtags.
     * @param postTruthfulness The posts' truthfulness.
     * @param postMessage The posts' message.
     */
    @Override
    public void post(Set<String> postHashtags, String postTruthfulness, String postMessage) {
        posts.put(posts.size()+1, new PostClass(posts.size()+1, postHashtags, postTruthfulness, postMessage, this));
    }
    
    /**
     * Adds another users' comment to a post.
     * @param comment The other users' comment.
     * @param postId The ID of the post to add the comment to.
     * @param userComment The user to comment on the post.
     */
    @Override
    public void commentPost(int postId, Comment comment, User userComment) throws PostDoesNotExistException {
        if (!posts.containsKey(postId)) {
            throw new PostDoesNotExistException(userId, postId);
        }
        
        posts.get(postId).addComment(comment, userComment);
    }
    
    /**
     * Adds a new comment made to another users' post.
     * @param comment The comment made to another users' post.
     */
    @Override
    public void newComment(Comment comment) {
        Iterator<String> postHashtags = comment.newPostHashtagsIterator();
        
        while (postHashtags.hasNext()) {
            String hashtag = postHashtags.next();
            
            if (!comments.containsKey(hashtag)) {
                comments.put(hashtag, new LinkedList<>());
            }
            
            comments.get(hashtag).add(comment);
        }
    }
    
    /**
     * Gets a post.
     * @param postId The posts' ID.
     * @return The post.
     */
    @Override
    public Post getPost(int postId) throws PostDoesNotExistException {
        if (!posts.containsKey(postId)) {
            throw new PostDoesNotExistException(userId, postId);
        }
        
        return posts.get(postId);
    }
    
    /**
     * @return The percentage of commented posts in relation to the total posts available to the user.
     */
    @Override
    public double getResponsiveness() {
        return ;
    }
    
    /**
     * @return New friends iterator.
     */
    @Override
    public Iterator<User> newFriendsIterator() throws UserHasNoFriendsException {
        if (friends.isEmpty()) {
            throw new UserHasNoFriendsException(userId);
        }
        
        return friends.values().iterator();
    }
    
    /**
     * @return New posts iterator.
     */
    @Override
    public Iterator<Post> newPostsIterator() throws UserHasNoPostsException {
        if (posts.isEmpty()) {
            throw new UserHasNoPostsException(userId);
        }
        
        return posts.values().iterator();
    }
    
    /**
     * Creates a new iterator for all the comments about a certain hashtag.
     * @param hashtag The posts' hashtag.
     * @return New user comments iterator.
     */
    @Override
    public Iterator<Comment> newCommentsIterator(String hashtag) throws UserHasNoCommentsException {
        if (!comments.containsKey(hashtag)) {
            throw new UserHasNoCommentsException();
        }
        
        return comments.get(hashtag).iterator();
    }

    /**
     * Returns the friends of the User.
     * @return The map of the users' friends.
     */
    @Override
    public SortedMap<String, User> getFriends() {
        return friends;
    }
}