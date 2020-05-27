package comparators;

import users.User;

import java.util.Comparator;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 */

public class TopLiarComparator implements Comparator<User> {
    
    @Override
    public int compare(User user1, User user2) {
        if (user1.getNumLies() != user2.getNumLies()) {
            return user2.getNumLies() - user1.getNumLies();
        }
        
        if (user1.getNumPosts() + user1.getNumComments() != user2.getNumPosts() + user2.getNumComments()) {
            return (user1.getNumPosts() + user1.getNumComments()) - (user2.getNumPosts() + user2.getNumComments());
        }
        
        return user1.getId().compareTo(user2.getId());
    }
    
}
