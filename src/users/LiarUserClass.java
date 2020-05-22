package users;

public class LiarUserClass extends AbstractUser implements LiarUser {

    /* Variables */
    private int numLies;
    
    /**
     * Constructor.
     * @param userId The ID of the liar user.
     */
    public LiarUserClass(String userId) {
        super(userId, "liar");
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
