package users;

public abstract class AbstractUserClass implements User {

    /* Variables */

    /**
     * Identifier of the user
     */
    private String userId;

    /**
     * The type of the user (Fanatic, Liar, Naive, Selfcentered)
     */
    private String userKind;

    /**
     * Number of friends that the user has
     */
    private int numFriends;
    
    /**
     * Number of posts that the user made
     */
    private int numPosts;

    /**
     * Number of comments that the user made
     */
    private int numComments;

    /* Constructor */
    
    /**
     * 
     * @param userId
     * @param userKind
     */
    protected AbstractUserClass(String userId, String userKind) {
        this.userId = userId;
        this.userKind = userKind;
        numFriends = 0;
        numPosts = 0;
        numComments = 0;
    }

    @Override
    public String getId() {
        return userId;
    }

    @Override
    public String getKind() {
        return userKind;
    }

    @Override
    public int getNumFriends() {
        return numFriends;
    }

    @Override
    public int getNumPosts() {
        return numPosts;
    }

    @Override
    public int getNumComments() {
        return numComments;
    }

    public void addFriend(User user2) {
        
    } 

    public void post(DataStructure postHashtags, String postTruthfulness, String postMessage) {
        
    }

    public 
}