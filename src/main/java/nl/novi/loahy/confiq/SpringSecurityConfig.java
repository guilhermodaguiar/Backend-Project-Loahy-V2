package nl.novi.loahy.confiq;

import nl.novi.loahy.filters.JwtRequestFilter;
import nl.novi.loahy.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //JWT token authentication
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/users/").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/users/all").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/users").permitAll()
                .antMatchers(HttpMethod.GET, "/users/{user_email}").permitAll()
                .antMatchers(HttpMethod.POST, "/users/create").permitAll()
                .antMatchers(HttpMethod.PUT, "/users/{user_email}").permitAll()
                .antMatchers(HttpMethod.DELETE,"/users/delete/{user_email}").hasRole("ADMIN")

                .antMatchers(HttpMethod.POST, "/contact-remarks/post").permitAll()
                .antMatchers(HttpMethod.GET, "/contact-remarks/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/contact-remarks/**").hasRole("ADMIN")

                .antMatchers(HttpMethod.GET, "/products").permitAll()
                .antMatchers(HttpMethod.GET, "/products/{productId}").permitAll()
                .antMatchers(HttpMethod.POST, "/products/{id}/picture").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/products/{id}/picture").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/products/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/products/").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/products/{productId}").hasRole("ADMIN")

                .antMatchers(HttpMethod.GET, "/shopping-carts/all").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/shopping-carts/create").permitAll()
                .antMatchers(HttpMethod.PUT, "/shopping-carts/{id}").permitAll()
                .antMatchers(HttpMethod.DELETE, "shopping-carts/{id}").permitAll()
                .antMatchers(HttpMethod.GET,"/shopping-carts/{id}").permitAll()

                .antMatchers(HttpMethod.GET, "/orders/all").permitAll()
                .antMatchers(HttpMethod.GET, "/orders/{id}").permitAll()
                .antMatchers(HttpMethod.POST, "/orders/create").permitAll()
                .antMatchers(HttpMethod.PUT, "/orders/{id}").permitAll()
                .antMatchers(HttpMethod.PUT, "/orders/{id}/{userId}").permitAll()
                .antMatchers(HttpMethod.PUT, "/orders/{id}/{productId}").permitAll()
                .antMatchers(HttpMethod.DELETE, "/orders/delete/{id}").hasRole("ADMIN")


                .antMatchers(HttpMethod.GET, "/products/image-download/{fileName").permitAll()
                .antMatchers(HttpMethod.POST, "/products/image-upload").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/products/image-delete").hasRole("ADMIN")

                .antMatchers("/authenticated").authenticated()
                .antMatchers("/authenticate").permitAll()
                .anyRequest().permitAll()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

    }

}