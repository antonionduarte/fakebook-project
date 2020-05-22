package users;

public class FanaticUserClass extends AbstractUser implements FanaticUser {
    
    /* Constructor */

    /**
     * The constructor of Fanatic Users.
     * @param userId The ID of the fanatic user.
     */
    public FanaticUserClass(String userId) {
        super(userId, "fanatic");
    }
}