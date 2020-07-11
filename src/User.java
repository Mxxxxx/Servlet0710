import java.util.ArrayList;
import java.util.List;

/**
 * @Author Meng Xin
 * @Date 2020/7/10 19:01
 */
public class User {
    String username;
    String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    private static final List<User> userList = new ArrayList<>();

    static {
        userList.add(new User("MX", "123"));
    }

    public static User login(String username, String password) {
        for (User user : userList) {
            if (user.username.equals(username) && user.password.equals(password)) {
                return user;
            }
        }

        return null;
    }

    public static void zhuce(String username, String password) {
        User user = new User(username, password);
        userList.add(user);
    }
}
