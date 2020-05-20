package users;

public class LiarUserClass extends AbstractUser implements LiarUser {

    /* Variables */
    int numLies;
    
    /**
     * Constructor.
     * @param userId The ID of the liar user.
     * @param userKind The kind of the user (liar).
     */
    public LiarUserClass(String userId, String userKind) {
        super(userId, userKind);
        this.numLies = 0;
    }

    /**
     * @return The number of lies.
     */
    @Override
    public int getNumLies() {
        return numLies;
    }
    
}
