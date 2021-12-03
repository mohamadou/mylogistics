package com.mohamadou.mylogistics.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;


@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .cors().and().csrf().disable() // Comment on production: this Allow to send POST request on postman without the csrf
        .authorizeRequests()
            .antMatchers("/delivery").authenticated()
            .antMatchers("/customer").authenticated()
            .antMatchers("/address").authenticated()
            .antMatchers("/parcel").authenticated()
        .and()
        .formLogin()
        .and().
        httpBasic();
    }


    /**
     * InMemoryAuthentication Configuration
     * @param //auth
     * @throws Exception
     */
   // @Override
    /*protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("john").password("1234").authorities("ROL_ADMIN")
                .and()
                .withUser("ndeye").password("4321").authorities("ROL_MANAGER")
                .and()
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }*/


    /**
     * InMemoryUserDetailsManager configuration
     * @param //auth
     * @throws Exception
     */
    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
        UserDetails user1 = User.withUsername("john").password("1234").authorities("ROL_ADMIN").build();
        UserDetails user2 = User.withUsername("ndeye").password("4321").authorities("ROL_MANAGER").build();

        inMemoryUserDetailsManager.createUser(user1);
        inMemoryUserDetailsManager.createUser(user2);

        auth.userDetailsService(inMemoryUserDetailsManager);
    }*/

    @Bean
    UserDetailsService userDetailsService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
