package zzu.lab305.lib305.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import java.util.Collections;

@Configuration
@EnableWebSecurity
public class springsecurtiy extends WebSecurityConfigurerAdapter {

  @Bean
  public AuthenticationManager authenticationManager(){

     return new ProviderManager(Collections.singletonList(authenticationProvider));



  }


    @Autowired
    public AuthenticationProvider authenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
             http
//
                .authorizeRequests()// 对请求授权
                // error  127.0.0.1 将您重定向的次数过多
                .antMatchers("/login.html",
                        "/authentication/form","/test.html","/doLogin").permitAll()
                .antMatchers("/user/**","/book/find/**").permitAll()// 这些页面不需要身份认证,其他请求需要认证
               .antMatchers("/book/out/","user.html","/book/rebook/**").hasRole("USER")
                .antMatchers("/root.html").hasRole("ROOT")
                .anyRequest() // 任何请求
                .authenticated()//; // 都需要身份认证
                .and()
                .csrf().disable();// 禁用跨站攻击

     }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.authenticationProvider(authenticationProvider);


    }
}
