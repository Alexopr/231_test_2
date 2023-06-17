package web.DAO;

import web.model.User;

import java.util.List;

public interface UserDAO {
    List<User> index();
    User show(int id);
    void save(User user);
    void update(User updateUser);
    void delete(int id);
}
