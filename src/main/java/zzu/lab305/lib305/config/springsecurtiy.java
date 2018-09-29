package zzu.lab305.lib305.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class springsecurtiy extends WebSecurityConfigurerAdapter {



    @Autowired
    public AuthenticationProvider authenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
             http.httpBasic()
// formLogin().// 表单登录  来身份认证
//                .loginPage("/login.html")// 自定义登录页面
//                .loginProcessingUrl("/authentication/form")// 自定义登录路径
                .and()
                .authorizeRequests()// 对请求授权
                // error  127.0.0.1 将您重定向的次数过多
                .antMatchers("/login.html",
                        "/authentication/form","/test.html").permitAll()
                .antMatchers("/user/**","/user.html","/book/find/**").permitAll()// 这些页面不需要身份认证,其他请求需要认证
               .antMatchers("/user/**","/book/out/").hasRole("USER")
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
