import java.util.ArrayList;
import java.util.List;

public class Blog {

    List<BlogPost> blogPosts = new ArrayList<>();

    public void add(BlogPost newPost) {
        blogPosts.add(newPost);
    }

    public void delete(int index) {
        blogPosts.remove(index);
    }

    public void update(int index, BlogPost nameOfNewPost) {
        delete(index);
        add(nameOfNewPost);
    }

    public static void main(String[] args) {

    }

}
