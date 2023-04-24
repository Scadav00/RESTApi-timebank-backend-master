package net.btcmp.timebank;

 import net.btcmp.timebank.dto.AuthenticatedUserDto;
import net.btcmp.timebank.entity.User;
import net.btcmp.timebank.exception.UserNotFoundException;
import net.btcmp.timebank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

//    -------------------------------------------

    @Override
    public UserDetails loadUserByUsername(String name) throws UserNotFoundException {
        User user = this.userRepository.findByUsername(name);
        if (user != null) {
            return new AuthenticatedUserDto(user);
        }

        else{
            throw new UserNotFoundException("No user Found");
        }

    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
//    ---------------------------------------------


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(this::authorizeHttpRequests)
                .formLogin(this::formLogin)
                .cors().disable()
                .csrf().disable()
                .build();
    }


    private void formLogin(FormLoginConfigurer<HttpSecurity> formLogin) {
        formLogin
                .successForwardUrl("/authorizations/me")
                .failureForwardUrl("/authorizations/unauthorized");
    }

    private void authorizeHttpRequests(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry authz) {
        authz
                .anyRequest()
                // all requests are permitted
                .permitAll();
    }

}
