package users;

public class NaiveUserClass extends AbstractUser implements NaiveUser {
    
    /* Constructor */

    /**
     * The constructor of Naive Users.
     * @param userId The ID of the naive user.
     * @param userKind The kind of the user (naive).
     */
    public NaiveUserClass(String userId, String userKind) {
        super(userId, userKind);
    }
}