package comparators;

import users.User;

import java.util.Comparator;

public class TopLiarComparator implements Comparator<User> {
    
    @Override
    public int compare(User user, User topLiar) {
        if (topLiar == null) {
            return 1;
        }
        
        if (user.getNumLies() != topLiar.getNumLies()) {
            return user.getNumLies() - topLiar.getNumLies();
        }
        
        return user.getNumPosts() + user.getNumComments() - (topLiar.getNumPosts() + topLiar.getNumComments());
    }
    
}
