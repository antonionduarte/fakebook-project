package fakebook;

import comments.Comment;
import comments.CommentClass;
import comparators.TopLiarComparator;
import comparators.TopPostComparator;
import comparators.TopPosterComparator;
import comparators.TopResponsiveComparator;
import comparators.TopicPostsComparator;
import enums.UserKind;
import exceptions.*;
import fanaticisms.Fanaticism;
import posts.Post;
import users.*;

import java.util.*;

public class FakebookClass implements Fakebook {
    
    /* Variables */
    private SortedMap<String, User> users;
    private Post topPost;
    private User topPoster, topResponsive;
    private User topLiar;
    private Map<String, SortedMap<String, FanaticUser>> topicsFanatics;
    private Map<String, List<Post>> topicsPosts;
    
    /* Constructor */
    public FakebookClass() {
        users = new TreeMap<>();
        topPost = null;
        topPoster = null;
        topResponsive = null;
        topLiar = null;
        topicsFanatics = new HashMap<>();
        topicsPosts = new HashMap<>();
    }
    
    /**
     * Registers a new user.
     * @param userKind User kind.
     * @param userId The new users' ID.
     */
    @Override
    public void registerUser(String userKind, String userId) throws InvalidUserKindException, UserAlreadyExistsException {
        if (!validUserKind(userKind)) {
            throw new InvalidUserKindException(userKind);
        }
        if (users.containsKey(userId)) {
            throw new UserAlreadyExistsException(userId);
        }
        
        switch (UserKind.valueOf(userKind.toUpperCase())) {
            case NAIVE:
                users.put(userId, new NaiveUserClass(userId));
                break;
            case LIAR:
                users.put(userId, new LiarUserClass(userId));
                break;
            case SELFCENTERED:
                users.put(userId, new SelfcenteredUserClass(userId));
                break;
            default:
                break;
        }
    }
    
    /**
     * Checks if a user kind is "fanatic".
     * @param userKind The user kind.
     * @return True if the user kind is "fanatic".
     */
    @Override
    public boolean userKindIsFanatic(String userKind) {
        return userKind.toUpperCase().equals(UserKind.FANATIC.toString());
    }
    
    /**
     * Registers a new fanatic user.
     * @param userId The new users' ID.
     * @param fanaticisms The new users' fanaticisms.
     */
    @Override
    public void registerFanatic(String userId, List<Fanaticism> fanaticisms) throws UserAlreadyExistsException {
        if (users.containsKey(userId)) {
            throw new UserAlreadyExistsException(userId);
        }
        
        FanaticUser user = new FanaticUserClass(userId, fanaticisms);
        users.put(userId, user);
        
        for (Fanaticism fanaticism: fanaticisms) {
            if (!topicsFanatics.containsKey(fanaticism.getHashtag())) {
                topicsFanatics.put(fanaticism.getHashtag(), new TreeMap<>());
            }
            
            topicsFanatics.get(fanaticism.getHashtag()).put(userId, user);
        }
    }
    
    /**
     * Creates a bidirectional friend relationship between 2 users.
     * @param userId1 The first user.
     * @param userId2 The second user.
     */
    @Override
    public void addFriend(String userId1, String userId2) throws UserDoesNotExistException, SameUserException {
        if (!users.containsKey(userId1)) {
            throw new UserDoesNotExistException(userId1);
        }
        if (!users.containsKey(userId2)) {
            throw new UserDoesNotExistException(userId2);
        }
        if (userId1.equals(userId2)) {
            throw new SameUserException(userId1);
        }
        
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
    public void post(String userId, Set<String> postHashtags, String postTruthfulness, String postMessage) throws UserDoesNotExistException {
        if (!users.containsKey(userId)) {
            throw new UserDoesNotExistException(userId);
        }
        
        User user = users.get(userId);
        user.post(postHashtags, postTruthfulness, postMessage);
        
        updateTopPoster(user);
        updateTopLiar(user);
    
        for (String hashtag: postHashtags) {
            if (!topicsPosts.containsKey(hashtag)) {
                topicsPosts.put(hashtag, new LinkedList<>());
            }
            
            topicsPosts.get(hashtag).add(user.getPost(user.getNumPosts()));
        }
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
    public void commentPost(String userIdComment, String userIdPost, int postId, String commentStance, String commentMessage) throws UserDoesNotExistException {
        if (!users.containsKey(userIdComment)) {
            throw new UserDoesNotExistException(userIdComment);
        }
        if (!users.containsKey(userIdPost)) {
            throw new UserDoesNotExistException(userIdPost);
        }
        
        User userComment = users.get(userIdComment);
        User userPost = users.get(userIdPost);
        Post post = userPost.getPost(postId);
        Comment comment = new CommentClass(userComment, post, commentStance, commentMessage);
        
        userComment.canCommentPost(post, comment);
        userPost.commentPost(postId, comment);
        userComment.newComment(comment);
        
        updateTopPost(post);
        updateTopPoster(userPost);
        updateTopResponsive(userComment);
        updateTopLiar(userComment);
    }
    
    /**
     * Gets a users' specified post.
     * @param userId The users' ID.
     * @param postId The posts' ID.
     * @return The users' post.
     */
    @Override
    public Post getUserPost(String userId, int postId) throws UserDoesNotExistException {
        if (!users.containsKey(userId)) {
            throw new UserDoesNotExistException(userId);
        }
        
        return users.get(userId).getPost(postId);
    }
    
    /**
     * @return The most popular post.
     */
    @Override
    public Post getTopPost() throws NoTopPostException {
        if (topPost == null) {
            throw new NoTopPostException();
        }
        
        return topPost;
    }
    
    /**
     * @return The top poster.
     */
    @Override
    public User getTopPoster() throws NoTopPosterException {
        if (topPoster == null) {
            throw new NoTopPosterException();
        }
        
        return topPoster;
    }
    
    /**
     * @return The top responsive user.
     */
    @Override
    public User getTopResponsive() throws NoTopResponsiveException {
        if (topResponsive == null) {
            throw new NoTopResponsiveException();
        }
        
        return topResponsive;
    }
    
    /**
     * @return The user with the most lies.
     */
    @Override
    public User getTopLiar() throws NoTopLiarException {
        if (topLiar == null) {
            throw new NoTopLiarException();
        }
        
        return topLiar;
    }
    
    /**
     * @return New users iterator.
     */
    @Override
    public Iterator<User> newUsersIterator() throws NoUsersException {
        if (users.isEmpty()) {
            throw new NoUsersException();
        }
        
        return users.values().iterator();
    }
    
    /**
     * Creates a new iterator for a users' friends.
     * @param userId The users' ID.
     * @return New users' friends iterator.
     */
    @Override
    public Iterator<User> newUserFriendsIterator(String userId) throws UserDoesNotExistException {
        if (!users.containsKey(userId)) {
            throw new UserDoesNotExistException(userId);
        }
        
        return users.get(userId).newFriendsIterator();
    }
    
    /**
     * Creates a new iterator for a users' posts.
     * @param userId The users' ID.
     * @return New users' posts iterator.
     */
    @Override
    public Iterator<Post> newUserPostsIterator(String userId) throws UserDoesNotExistException {
        if (!users.containsKey(userId)) {
            throw new UserDoesNotExistException(userId);
        }
        
        return users.get(userId).newPostsIterator();
    }
    
    /**
     * Creates a new iterator for a users' comments about a certain hashtag.
     * @param userId The users' ID.
     * @param hashtag The posts' hashtag.
     * @return New user comments iterator.
     */
    @Override
    public Iterator<Comment> newUserCommentsIterator(String userId, String hashtag) throws UserDoesNotExistException {
        if (!users.containsKey(userId)) {
            throw new UserDoesNotExistException(userId);
        }
        
        return users.get(userId).newCommentsIterator(hashtag);
    }
    
    /**
     * Creates a new iterator for all of a specified hashtags' fanatics.
     * @param hashtag The specified hashtag.
     * @return New topic fanatics iterator.
     */
    @Override
    public Iterator<FanaticUser> newTopicFanaticsIterator(String hashtag) throws InvalidFanaticismException {
        if (!topicsFanatics.containsKey(hashtag)) {
            throw new InvalidFanaticismException(hashtag);
        }
        
        return topicsFanatics.get(hashtag).values().iterator();
    }

    public Iterator<Post> newTopicPostsIterator(String hashtag, int amount) throws InvalidNumberOfPostsException, InvalidHashtagException {
        if (amount < 1) {
             throw new InvalidNumberOfPostsException();
        }
        if (!topicsPosts.containsKey(hashtag)) {
             throw new InvalidHashtagException(hashtag);
        }
        
        List<Post> auxiliaryList = new LinkedList<>();
        topicsPosts.get(hashtag).sort(new TopicPostsComparator());
        Iterator<Post> auxiliaryIterator = topicsPosts.get(hashtag).iterator();
        
        for (int i = 0; i < amount && auxiliaryIterator.hasNext(); i++) {
            Post nextPost = auxiliaryIterator.next();
            auxiliaryList.add(nextPost);
        }
        
        return auxiliaryList.iterator();
    }
    
    /* Private methods */
    
    private boolean validUserKind(String userKind) {
        for (UserKind kind: UserKind.values()) {
            if (kind.toString().equals(userKind.toUpperCase())) {
                return true;
            }
        }
        return false;
    }
    
    private void updateTopPost(Post post) {
        if (new TopPostComparator().compare(post, topPost) > 0) {
            topPost = post;
        }
    }
    
    private void updateTopPoster(User user) {
        if (new TopPosterComparator().compare(user, topPoster) > 0) {
            topPoster = user;
        }
    }
    
    private void updateTopResponsive(User user) {
        if (new TopResponsiveComparator().compare(user,topResponsive) > 0) {
            topResponsive = user;
        }
    }
    
    private void updateTopLiar(User user) {
        if (new TopLiarComparator().compare(user, topLiar) > 0) {
            topLiar = user;
        }
    }
}
