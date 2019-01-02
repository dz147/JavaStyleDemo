package javaConfiguration.root;

import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class ShiroConfig {

    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(new JdbcRealm());
        return manager;
    }

    @Bean
    ShiroFilterFactoryBean shiroFilter() {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager());
        bean.setLoginUrl("/loginUser");
        bean.setSuccessUrl("/home");
        bean.setUnauthorizedUrl("/500");

        // 规则设定
        // 基于 url 的规则
        HashMap<String, String> map = new HashMap<>();
        map.put("/admin/**", "authc");
        map.put("/policy/**", "authc");
        map.put("/policy/view", "anon");
        map.put("/logout", "logout");
        bean.setFilterChainDefinitionMap(map);

        return bean;
    }
}
