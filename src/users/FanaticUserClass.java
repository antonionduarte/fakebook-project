package users;

import fanaticisms.Fanaticism;

import java.util.List;

public class FanaticUserClass extends AbstractUser implements FanaticUser {
    
    /* Variables */
    private List<Fanaticism> fanaticisms;

    /**
     * Constructor.
     * @param userId The ID of the fanatic user.
     */
    public FanaticUserClass(String userId, List<Fanaticism> fanaticisms) {
        super(userId, "fanatic");
        this.fanaticisms = fanaticisms;
    }
    
}