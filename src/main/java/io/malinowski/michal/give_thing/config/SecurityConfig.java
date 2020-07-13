package io.malinowski.michal.give_thing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final DataSource dataSource;

    public SecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
//                .inMemoryAuthentication()
//                .withUser("user").password("{noop}user").roles("USER")
//                .and()
//                .withUser("admin").password("{noop}admin").roles("ADMIN");

                .jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
                .usersByUsernameQuery("SELECT login, password, active FROM users WHERE login=?")
                .authoritiesByUsernameQuery("SELECT login, users_roles.roles " +
                        "FROM users " +
                        "JOIN users_roles ON " +
                        "users.id=users_roles.user_id " +
                        "WHERE login =?");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**"); //odblokowanie ścieżki
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/register").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .usernameParameter("login")
                .passwordParameter("password")
                .defaultSuccessUrl("/")
                .loginPage("/login")
                .and()
                .logout()
                .logoutSuccessUrl("/");
    }
}
