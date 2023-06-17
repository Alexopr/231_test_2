package web.DAO;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext()
    private EntityManager entityManager;

    private List<User> users;

    {
        users = new ArrayList<User>();

        users.add(new User(1, "Alex_1", "Got_1", "1_alex.got@gmail.com"));
        users.add(new User(2, "Alex_2", "Got_2", "2_alex.got@gmail.com"));
        users.add(new User(3, "Alex_3", "Got_3", "3_alex.got@gmail.com"));
    }
    @Override
    public List<User> index() {
        return users;
    }
    @Override
    public User show(int id) {
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }
    @Override
    @Transactional
    public void save(User user) {
        user.setId(users.size() + 1); // Надо будет исправить на уникальный id, когда поключишь БД
        users.add(user);
    }
    @Override
    @Transactional
    public void update(User updateUser) {
        entityManager.merge(updateUser);
    }
    @Override
    @Transactional
    public void delete(int id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }
}
