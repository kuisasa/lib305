package zzu.lab305.lib305.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import zzu.lab305.lib305.entity.User;
import zzu.lab305.lib305.entity.UserExample;
import zzu.lab305.lib305.impl.UserMapper;

import java.util.ArrayList;
import java.util.List;

@Component("myservice")
public class myDetailService implements UserDetailsService {
   @Autowired
   UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserExample example =new UserExample();
        example.createCriteria().andUserSnumEqualTo(username);

        List<User> users = userMapper.selectByExample(example);

        if (users.isEmpty())
            throw new UsernameNotFoundException("用户名未找到");
        else {
            User user=users.get(0);
            List<GrantedAuthority>list=new ArrayList<>();
            if ("ROOT".equals(user.getUserSnum())) {
                list.add(new SimpleGrantedAuthority("ROLE_ROOT"));

                return new org.springframework.security.core.userdetails.User(user.getUserSnum(), user.getUserPassword(),true,true,true,true, list);
            }

            list.add(new SimpleGrantedAuthority("ROLE_USER"));
           return new org.springframework.security.core.userdetails.User(user.getUserSnum(),user.getUserPassword(),true,true,true,true,list);


        }


    }
}
