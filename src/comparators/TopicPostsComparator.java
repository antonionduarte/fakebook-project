package comparators;

import java.util.Comparator;
import posts.*;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 *
 * Compares 2 posts by: the number of comments, the post authors' ID, and the posts' ID.
 */

public class TopicPostsComparator implements Comparator<Post> {

    @Override
    public int compare(Post post1, Post post2) {
        if (post1.getNumComments() != post2.getNumComments()) {
            return post2.getNumComments() - post1.getNumComments();
        }
        
        if (post1.getAuthorId().compareTo(post2.getAuthorId()) != 0) {
            return post1.getAuthorId().compareTo(post2.getAuthorId());
        }
        
        return post2.getId() - post1.getId();
    }
    
}
