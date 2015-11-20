package com.stormpath.examples.bootang;

import com.stormpath.spring.config.StormpathWebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public class SecurityConfig extends StormpathWebSecurityConfigurerAdapter {

    @Override
    public void doConfigure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/profile").fullyAuthenticated()
                .antMatchers("/error").permitAll()
                .antMatchers("/**").permitAll();
    }

}
