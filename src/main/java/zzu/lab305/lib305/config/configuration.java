package zzu.lab305.lib305.config;

import com.github.pagehelper.PageInterceptor;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class configuration
{
//    @Bean
//    public PageInterceptor pageInterceptor(){
//        PageInterceptor pageInterceptor=  new PageInterceptor();
//        Properties properties=new Properties();
//        return pageInterceptor;
//
//
//
//
//    }
@Bean
ConfigurationCustomizer mybatisConfigurationCustomizer() {
    return new ConfigurationCustomizer() {
        @Override
        public void customize(org.apache.ibatis.session.Configuration configuration) {

            PageInterceptor pageInterceptor=new PageInterceptor();
            Properties properties=new Properties();
            properties.setProperty("helperDialect","mysql");
            pageInterceptor.setProperties(properties);
            configuration.addInterceptor(pageInterceptor);


        }


    };
}

}
