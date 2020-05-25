package comparators;

import users.LiarUser;

import java.util.Comparator;

public class TopLiarComparator implements Comparator<LiarUser> {
    
    @Override
    public int compare(LiarUser user, LiarUser topLiar) {
        if (topLiar == null) {
            return 1;
        }
        
        if (user.getNumLies() != topLiar.getNumLies()) {
            return user.getNumLies() - topLiar.getNumLies();
        }
        
        return user.getNumPosts() + user.getNumComments() - (topLiar.getNumPosts() + topLiar.getNumComments());
    }
    
}
