package md.project.hotelback.config;

import md.project.hotelback.decorator.EmailAuthDecorator;
import md.project.hotelback.repository.UserRepository;
import md.project.hotelback.service.AuthenticationService;
import md.project.hotelback.service.impl.AuthenticationServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AuthConfig {

    @Bean
    public AuthenticationService authenticationService(
            AuthenticationServiceImpl baseAuthService,
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager) {

        return new EmailAuthDecorator(baseAuthService, userRepository, passwordEncoder, authenticationManager);
    }
}
