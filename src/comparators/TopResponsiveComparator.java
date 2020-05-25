package comparators;

import users.User;

import java.util.Comparator;

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
