package users;

public class NaiveUserClass extends AbstractUser implements NaiveUser {
    
    /**
     * Constructor.
     * @param userId The ID of the naive user.
     */
    public NaiveUserClass(String userId) {
        super(userId, "naive");
    }
    
}
