package md.project.hotelback.service.impl;

import lombok.AllArgsConstructor;
import md.project.hotelback.dto.UserDTO;
import md.project.hotelback.entity.User;
import md.project.hotelback.entity.UserRole;
import md.project.hotelback.exception.UserException;
import md.project.hotelback.repository.RoleRepository;
import md.project.hotelback.repository.UserRepository;
import md.project.hotelback.service.AuthenticationService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final RoleRepository userRole;

    @Override
    public void signup(UserDTO userDTO) {
        var user = userRepository.findByUsername(userDTO.getUsername());
        UserRole role = userRole.findById(1L)
                .orElseThrow();
        if (user.isPresent()) {
            throw new UserException("Username is already in use");
        }
        User newUser = new User();

        newUser.setUsername(userDTO.getUsername());
        newUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        newUser.setEmail(userDTO.getEmail());
        newUser.setUserRole(role);

        if (userDTO.getPhoneNumber() == null || userDTO.getPhoneNumber().isEmpty()) {
            newUser.setPhoneNumber("");
        } else {
            newUser.setPhoneNumber(userDTO.getPhoneNumber());
        }

        userRepository.save(newUser);
    }

    @Override
    public User login(UserDTO userDTO) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userDTO.getUsername(),
                        userDTO.getPassword()
                )
        );

        return userRepository.findByUsername(userDTO.getUsername())
                .orElseThrow();
    }
}
