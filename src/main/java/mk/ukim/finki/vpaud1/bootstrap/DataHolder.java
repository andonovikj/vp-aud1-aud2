package mk.ukim.finki.vpaud1.bootstrap;

import mk.ukim.finki.vpaud1.model.Category;
import mk.ukim.finki.vpaud1.model.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Category> categories = new ArrayList<>();

    public static List<User> users = new ArrayList<>();

    @PostConstruct
    public void init() {
        categories.add(new Category("Software", "Soft categories"));
        categories.add(new Category("Books", "Books categories"));

        users.add(new User ("mila.andonovikj", "ma", "Mila", "Andonovikj"));
        users.add(new User ("ivana.andreevska", "ia", "Ivana", "Andreevska"));
    }
}
