package fakebook;

public interface Fakebook {
    
    /**
     * Checks if the specified user kind is "fanatic".
     * @param userKind User kind.
     */
    boolean userKindIsFanatic(String userKind);
    
    /**
     * Registers a new user.
     * @param userKind User kind.
     * @param userId The new users' ID.
     */
    void registerUser(String userKind, String userId);
    
    /**
     * Registers a new fanatic user.
     * @param userId The new users' ID.
     * @param fanaticisms The new users' fanaticisms.
     */
    void registerFanatic(String userId, DataStructure fanaticisms);
    
    
    
    
    
    
    
    
}
