package tk.ta4anka.employeemanager.config;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;


import javax.sql.DataSource;

// 2) Spring Security Configuration

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = "tk.ta4anka.employeemanager")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/","/registration").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);

        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .usersByUsernameQuery(
                        "SELECT username, password, active \n" +
                                " FROM users \n" +
                                " WHERE username=?")

                .authoritiesByUsernameQuery(
                        "SELECT u.username, r.name \n" +
                                "FROM users u INNER JOIN user_role ur\n" +
                                "ON u.id = ur.user_id INNER JOIN roles r\n" +
                                "ON ur.role_id = r.id\n" +
                                "WHERE u.username = ?;");
    }

/*
       @Bean  TODO: FOR TESTNING --> DELETE
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("1")
                        .roles("U")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }*/


/*    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    };*/

}