package zzu.lab305.lib305.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import zzu.lab305.lib305.Exception.usernameException;
import zzu.lab305.lib305.entity.Result;
import zzu.lab305.lib305.entity.User;
import zzu.lab305.lib305.service.userService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class userController {
    @Autowired
    zzu.lab305.lib305.service.userService userService;



    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    public Result add(@Validated @RequestBody User user) {

        try {
            int i = userService.adduser(user);
            if (i != 0)
                return new Result(true, "注册成功");

        } catch (usernameException e) {

            return new Result(false, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "注册失败");
        }
        return new Result(false, "注册失败");
    }

    @RequestMapping("/find")
    public List<User> findUsers(@RequestBody User user) {

        List<User> user1 = userService.findUser(user);
        return user1;

    }
    @RequestMapping("/find/{userSnum}")
    public User finduser(@PathVariable("userSnum") String userSnum){
        User userByName = userService.findUserByName(userSnum);

        return userByName;
    }


    @RequestMapping("/findall")
    public List<User> findall(){

        return userService.findAll();
    }



    @RequestMapping("/update")
    public Result update(@RequestParam(value = "password",required = false) String password,@RequestParam(value = "group",required = false)String group){



        UserDetails  principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = principal.getUsername();
        User userByName = userService.findUserByName(username);
        if (password!=null) {

            userByName.setUserPassword(password);
        }
        if (group!=null) {
            userByName.setUserGroup(group);
        }
           int update = userService.update(userByName);

        if (update!=0)
            return new Result(true,"修改成功");

        return new Result(false,"修改失败");



    }

}
