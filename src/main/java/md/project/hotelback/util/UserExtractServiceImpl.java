package md.project.hotelback.util;

import lombok.AllArgsConstructor;
import md.project.hotelback.entity.User;
import md.project.hotelback.exception.UserException;
import md.project.hotelback.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserExtractServiceImpl {

    private final JwtServiceImpl jwtService;
    private final UserRepository userRepository;

    public User getUser(String jwtToken) {
        String username = jwtService.extractUsername(jwtToken);
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UserException("No user found"));
    }
}
