package zzu.lab305.lib305.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zzu.lab305.lib305.Exception.usernameException;
import zzu.lab305.lib305.entity.User;
import zzu.lab305.lib305.entity.UserExample;
import zzu.lab305.lib305.impl.UserMapper;
import zzu.lab305.lib305.service.userService;

import java.util.List;

@Service
public class userServiceImpl implements userService {

    @Autowired
    UserMapper userMapper;

    @Override
    public int adduser(User user) throws usernameException {
        String userSnum = user.getUserSnum();
        if(!userSnum.matches("20[0-9]{9}"))
            throw new usernameException("学号格式不正确");
        UserExample example= new UserExample();
        example.createCriteria().andUserSnumEqualTo(userSnum);
        List<User> userList = userMapper.selectByExample(example);
        if(userList!=null && userList.isEmpty()) {
            user.setUserStatus(true);
            user.setUserRole("USER");
            int result = userMapper.insert(user);
            return result;

        }else if (!userList.isEmpty())
            throw new usernameException("学号已经被注册");

       return 0;
    }

    @Override
    public List<User> findUser(User user) {

        UserExample example=new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if (user.getUserSpec()!=null)
            criteria.andUserSpecEqualTo(user.getUserSpec());
        if(user.getUserGroup()!=null)
            criteria.andUserGroupEqualTo(user.getUserGroup());
        if (user.getUserStatus()!=null)
         criteria.andUserStatusEqualTo(user.getUserStatus());

        List<User> users = userMapper.selectByExample(example);


        return users;
    }


    @Override
    public List<User> findAll() {
        return userMapper.selectByExample(null);


    }

    @Override
    public User findUserByName(String username) {
        UserExample example=new UserExample();
        example.createCriteria().andUserSnumEqualTo(username);
        List<User> list = userMapper.selectByExample(example);
        if (!list.isEmpty())
        return list.get(0);

        return null;
    }

    @Override
    public int update(User user) {

        int i = userMapper.updateByPrimaryKey(user);

        return i;
    }

    @Override
    public User findById(Integer id) {

        return userMapper.selectByPrimaryKey(id);
    }


}
