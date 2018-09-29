package zzu.lab305.lib305.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zzu.lab305.lib305.Exception.usernameException;
import zzu.lab305.lib305.entity.Result;
import zzu.lab305.lib305.entity.User;
import zzu.lab305.lib305.service.userService;

@RestController
@RequestMapping("/user")
public class userController {
    @Autowired
    zzu.lab305.lib305.service.userService userService;

    @RequestMapping("/add")
    public Result add(@Validated  @RequestBody User user) {
         UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(principal.getUsername());
         try {
            int i = userService.adduser(user);
            if (i != 0)
                return new Result(true, "注册成功");

        } catch (usernameException e) {

            return new Result(false,e.getMessage());
        }catch (Exception e)
        {
            e.printStackTrace();
            return new Result(false,"注册失败");
        }
        return new Result(false, "注册失败");
    }





}
