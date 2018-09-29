package zzu.lab305.lib305.service;



import zzu.lab305.lib305.Exception.usernameException;
import zzu.lab305.lib305.entity.User;

import java.util.List;

public interface userService {


    public int adduser(User user) throws usernameException;

    public User findUser(User user);

    public List<User> findAll();

    public User findUserByName(String username);

    public int update(User user);
}
