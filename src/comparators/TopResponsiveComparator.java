package comparators;

import users.User;

import java.util.Comparator;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 *
 * Compares 2 users by: their responsiveness percentage, and their ID.
 */

public class TopResponsiveComparator implements Comparator<User> {
    
    @Override
    public int compare(User user, User topResponsive)  {
        if (topResponsive == null) {
            return 1;
        }
        
        if (user.getResponsiveness() != topResponsive.getResponsiveness()) {
            return (int) (100 * (user.getResponsiveness() - topResponsive.getResponsiveness()));
        }
        
        return user.getId().compareTo(topResponsive.getId());
    }
    
}
