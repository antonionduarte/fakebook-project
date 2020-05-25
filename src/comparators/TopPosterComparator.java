package comparators;

import posts.Post;
import users.User;

import java.util.Comparator;

public class TopPosterComparator implements Comparator<User> {
    
    @Override
    public int compare(User user, User topPoster) {
        if (topPoster == null) {
            return 1;
        }
        
        if (user.getNumPosts() != topPoster.getNumPosts()) {
            return user.getNumPosts() - topPoster.getNumPosts() ;
        }
        
        if (user.getNumComments() != topPoster.getNumComments()) {
            return user.getNumComments() - topPoster.getNumComments();
        }
        
        return user.getId().compareTo(topPoster.getId());
    }
    
}
