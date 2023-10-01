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
        httpSecurity.csrf().disable()
                .headers().frameOptions().disable();

        if (secured) {
            httpSecurity.authorizeRequests()
                    .antMatchers("/resources/**", "/h2-console/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin().loginPage("/login").permitAll()
                    .defaultSuccessUrl(ItemController.API_PATH, true)
                    .and()
                    .logout().permitAll();
        } else {
            httpSecurity.authorizeRequests()
                    .anyRequest().anonymous()
                    .and()
                    .httpBasic().disable();
        }
    }
}