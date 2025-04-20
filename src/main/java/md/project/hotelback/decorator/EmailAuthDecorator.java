package md.project.hotelback.decorator;

import md.project.hotelback.dto.UserDTO;
import md.project.hotelback.entity.User;
import md.project.hotelback.exception.UserException;
import md.project.hotelback.repository.UserRepository;
import md.project.hotelback.service.AuthenticationService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

public class EmailAuthDecorator extends AuthDecorator {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;


    public EmailAuthDecorator(AuthenticationService authenticationService,
                              UserRepository userRepository,
                              PasswordEncoder passwordEncoder,
                              AuthenticationManager authenticationManager) {
        super(authenticationService);
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public void signup(UserDTO userDTO) {
        super.signup(userDTO);
    }

    @Override
    public User login(UserDTO userDTO) {
        String identifier = userDTO.getCredential();
        if (identifier != null && !identifier.isEmpty()) {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(identifier, userDTO.getPassword())
            );
            if (identifier.contains("@")) {
                return userRepository.findByEmail(identifier)
                        .orElseThrow(() -> new UserException("Invalid credentials"));
            } else {
                return userRepository.findByUsername(identifier)
                        .orElseThrow(() -> new UserException("Invalid credentials"));
            }
        }
        return super.login(userDTO);
    }
}
