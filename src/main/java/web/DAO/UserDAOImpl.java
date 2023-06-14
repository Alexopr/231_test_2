package web.DAO;

import org.springframework.stereotype.Component;
import web.model.User;

import java.util.ArrayList;
import java.util.List;
@Component
public class UserDAOImpl implements UserDAO {
    private List<User> users;

    {
        users = new ArrayList<User>();

        users.add(new User(1, "Alex_1", "Got_1", "1_alex.got@gmail.com"));
        users.add(new User(2, "Alex_2", "Got_2", "2_alex.got@gmail.com"));
        users.add(new User(3, "Alex_3", "Got_3", "3_alex.got@gmail.com"));
    }
    public List<User> index() {
        return users;
    }
    public User show(int id) {
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }
    public void save(User user) {
        user.setId(users.size() + 1); // Надо будет исправить на уникальный id, когда поключишь БД
        users.add(user);
    }
    public void update(int id, User updatedUser) {
        User userToBeUpdated = show(id);
        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setSurname(updatedUser.getSurname());
        userToBeUpdated.setEmail(updatedUser.getEmail());
    }
    public void delete(int id) {
        users.removeIf(p ->p.getId() == id);
    }
}
