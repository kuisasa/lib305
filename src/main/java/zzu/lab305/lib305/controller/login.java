package zzu.lab305.lib305.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import zzu.lab305.lib305.config.myDetailService;
import zzu.lab305.lib305.config.myProvider;
import zzu.lab305.lib305.entity.Result;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

@RestController
public class login {
@Autowired
  AuthenticationManager authenticationManager;

    @RequestMapping("/doLogin")
    public Result dologin(@RequestParam("userName")String userName, @RequestParam("password") String password, HttpServletRequest request){


        try {
            // 内部登录请求
            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(userName, password, AuthorityUtils.commaSeparatedStringToAuthorityList(""));
            // 验证
            Authentication auth = authenticationManager.authenticate(authRequest);
            SecurityContextHolder.getContext().setAuthentication(auth);
            return new Result(true,request.getSession().getId());
        } catch (AuthenticationException e) {
           return new Result(false,e.getMessage());
        }

    }

    @RequestMapping("/test")
    public void test(@RequestParam("scanUtils")String xx){

        System.out.println(xx);
    }


}
