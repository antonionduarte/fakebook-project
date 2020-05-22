package users;

public class SelfcenteredUserClass extends AbstractUser implements SelfcenteredUser {
    
    /**
     * Constructor.
     * @param userId The ID of the selfcentered user.
     */
    public SelfcenteredUserClass(String userId) {
        super(userId, "selfcentered");
    }
    
}
