package comparators;

import posts.Post;

import java.util.Comparator;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 */

public class TopPostComparator implements Comparator<Post> {
    
    @Override
    public int compare(Post post, Post topPost) {
        if (topPost == null) {
            return 1;
        }
        
        if (post.getNumComments() != topPost.getNumComments()) {
            return post.getNumComments() - topPost.getNumComments() ;
        }
        
        if (post.getAuthorId().compareTo(topPost.getAuthorId()) != 0) {
            return topPost.getAuthorId().compareTo(post.getAuthorId());
        }
        
        return post.getId() - topPost.getId();
    }
    
}
