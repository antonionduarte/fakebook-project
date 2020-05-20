package users;

public class FanaticUserClass extends AbstractUser implements FanaticUser {
    
    /* Constructor */

    /**
     * The constructor of Fanatic Users.
     * @param userId The ID of the fanatic user.
     * @param userKind The kind of the user (fanatic).
     */
    public FanaticUserClass(String userId, String userKind) {
        super(userId, userKind);
    }
}