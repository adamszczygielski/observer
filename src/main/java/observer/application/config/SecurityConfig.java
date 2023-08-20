package observer.application.config;

import observer.application.controller.ItemController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${observer.secured}")
    private Boolean secured;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        if (secured) {
            httpSecurity.authorizeRequests()
                    .antMatchers("/resources/**").permitAll()
                    .antMatchers("/h2-console/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin().loginPage("/login").permitAll()
                    .defaultSuccessUrl(ItemController.API_PATH, true)
                    .and()
                    .logout().permitAll()
                    .and()
                    .csrf().disable()
                    .headers().frameOptions().disable();
        } else {
            httpSecurity.csrf().disable()
                    .authorizeRequests().anyRequest().anonymous()
                    .and()
                    .httpBasic().disable();
        }
    }
}