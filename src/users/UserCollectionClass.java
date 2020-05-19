package users;

import comments.Comment;
import comments.CommentClass;
import exceptions.NoPostsException;
import exceptions.NoTopPosterException;
import posts.Post;

import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;

public class UserCollectionClass implements UserCollection {
    
    /* Variables */
    private SortedMap<String, User> users;
    private Post topPost;
    private User topPoster;
    
    /* Constructor */
    public UserCollectionClass() {
        users = new TreeMap<>();
        topPost = null;
        topPoster = null;
    }
    
    /**
     * Registers a new user.
     * @param userKind User kind.
     * @param userId The new users' ID.
     */
    @Override
    public void registerUser(String userKind, String userId) {
        
        if (userKind.equals("naive")) {
            users.put(userId, new NaiveUserClass(userId));
        }
        else if (userKind.equals("liar")) {
            users.put(userId, new LiarUserClass(userId));
        }
        else if (userKind.equals("selfcentered")) {
            users.put(userId, new SelfcenteredUserClass(userId));
        }
    }
    
    /**
     * Registers a new fanatic user.
     * @param userId The new users' ID.
     * @param fanaticisms The new users' fanaticisms.
     */
    @Override
    public void registerFanatic(String userId, DataStructure fanaticisms) {
        users.put(userId, new FanaticUserClass(userId, fanaticisms));
    }
    
    /**
     * Creates a bidirectional friend relationship between 2 users.
     * @param userId1 The first user.
     * @param userId2 The second user.
     */
    @Override
    public void addFriend(String userId1, String userId2) {
        User user1 = users.get(userId1);
        User user2 = users.get(userId2);
        
        user1.addFriend(user2);
        user2.addFriend(user1);
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
        users.get(userId).post(postHashtags, postTruthfulness, postMessage);
    }
    
    /**
     * Gets a users' number of friends.
     * @param userId The users' ID.
     * @return The users' number of friends.
     */
    @Override
    public int getUserNumFriends(String userId) {
        return users.get(userId).getNumFriends();
    }
    
    /**
     * Gets a users' number of posts.
     * @param userId The users' ID.
     * @return The users' number of posts.
     */
    @Override
    public int getUserNumPosts(String userId) {
        return users.get(userId).getNumPosts();
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
        User userComment = users.get(userIdComment);
        User userPost = users.get(userIdPost);
        Comment comment = new CommentClass(userComment, postId, commentStance, commentMessage);
        
        userComment.newComment(comment);
        userPost.commentPost(comment);
    }
    
    /**
     * Gets a users' specified post.
     * @param userId The users' ID.
     * @param postId The posts' ID.
     * @return The users' post.
     */
    @Override
    public Post getUserPost(String userId, String postId) {
        return users.get(userId).getPost(postId);
    }
    
    /**
     * @return The most popular post.
     */
    @Override
    public Post getTopPost() throws NoPostsException {
        
        if (topPost == null) {
            throw new NoPostsException();
        }
        
        return topPost;
    }
    
    /**
     * @return The top poster.
     */
    @Override
    public User getTopPoster() throws NoTopPosterException {
        User topPoster = null;
        
        for (User user: users.values()) {
            
            if (topPoster == null || user.getNumPosts() > topPoster.getNumPosts()) {
                topPoster = user;
            }
            else if (user.getNumPosts() == topPoster.getNumPosts() && user.getNumComments() > topPoster.getNumComments()) {
                topPoster = user;
            }
            else if (user.getNumPosts() == topPoster.getNumPosts() && user.getNumComments() == topPoster.getNumComments() &&
                user.getId().compareTo(topPoster.getId()) < 0) {
                topPoster = user;
            }
        }
        
        if (topPoster == null) {
            throw new NoTopPosterException();
        }
        
        return topPoster;
    }
    
    /**
     * @return The top responsive user.
     */
    @Override
    public User getTopResponsive() {
        return null;
    }
    
    /**
     * @return The user with the most lies.
     */
    @Override
    public LiarUser getTopLiar() {
        return null;
    }
    
    /**
     * @return New users iterator.
     */
    @Override
    public Iterator<User> newUsersIterator() {
        return null;
    }
    
    /**
     * Creates a new iterator for a users' friends.
     * @param userId The users' ID.
     * @return New users' friends iterator.
     */
    @Override
    public Iterator<User> newUserFriendsIterator(String userId) {
        return null;
    }
    
    /**
     * Creates a new iterator for a users' posts.
     * @param userId The users' ID.
     * @return New users' posts iterator.
     */
    @Override
    public Iterator<Post> newUserPostsIterator(String userId) {
        return null;
    }
    
    /**
     * Creates a new iterator for a users' comments about a certain hashtag.
     * @param userId The users' ID.
     * @param hashtag The posts' hashtag.
     * @return New user comments iterator.
     */
    @Override
    public Iterator<Comment> newUserCommentsIterator(String userId, String hashtag) {
        return null;
    }
    
    /**
     * Creates a new iterator for all of a specified hashtags' fanatics.
     * @param hashtag The specified hashtag.
     * @return New topic fanatics iterator.
     */
    @Override
    public Iterator<User> newTopFanaticsIterator(String hashtag) {
        return null;
    }
    
    /* Private methods */
    
    private void updateTopPost(Post post) {
    
        if (topPost == null || post.getNumComments() > topPost.getNumComments() ||
            post.getNumComments() == topPost.getNumComments() && post.getAuthorId().compareTo(topPost.getAuthorId()) < 0 ||
            post.getNumComments() == topPost.getNumComments() && post.getAuthorId().compareTo(topPost.getAuthorId()) == 0 && post.getId() > topPost.getId()) {
            topPost = post;
        }
    }
}
