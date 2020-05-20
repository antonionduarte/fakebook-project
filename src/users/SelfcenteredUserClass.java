package users;

public class SelfcenteredUserClass extends AbstractUser implements SelfcenteredUser {
        
    /* Constructor */

    /**
     * The constructor of Selfcentered Users.
     * @param userId The ID of the selfcentered user.
     * @param userKind The kind of the user (selfcentered).
     */
    public SelfcenteredUserClass(String userId, String userKind) {
        super(userId, userKind);
    }
}