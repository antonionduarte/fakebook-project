package comparators;

import users.User;

import java.util.Comparator;

public class TopLiarComparator implements Comparator<User> {
    
    @Override
    public int compare(User user, User topLiar) {
        if (topLiar == null) {
            return user.getNumLies();
        }
        
        if (user.getNumLies() != topLiar.getNumLies()) {
            return user.getNumLies() - topLiar.getNumLies();
        }
        
        if (user.getNumPosts() + user.getNumComments() != topLiar.getNumPosts() + topLiar.getNumComments()) {
            return topLiar.getNumPosts() + topLiar.getNumComments() - (user.getNumPosts() + user.getNumComments());
        }
        
        return topLiar.getId().compareTo(user.getId());
    }
    
}
