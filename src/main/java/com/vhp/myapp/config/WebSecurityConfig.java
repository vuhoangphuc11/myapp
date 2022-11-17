package com.vhp.myapp.config;

import com.vhp.myapp.service.CustomOAuth2UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authenticationProvider());
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/oauth2/**", "/login/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                    .loginPage("/app/login")
                .and()
                .oauth2Login()
                .loginPage("/app/login/login")
                .userInfoEndpoint()
                .userService(oauth2UserService)
                .and()
                .successHandler(oauthLoginSuccessHandler)
                .and()
                .logout().logoutSuccessUrl("/app/logout").permitAll();

    }



    @Autowired
    private CustomOAuth2UserService oauth2UserService;
    @Autowired
    private OAuthLoginSuccessHandler oauthLoginSuccessHandler;
}