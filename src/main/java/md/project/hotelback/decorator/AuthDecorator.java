package md.project.hotelback.decorator;

import lombok.AllArgsConstructor;
import md.project.hotelback.dto.UserDTO;
import md.project.hotelback.entity.User;
import md.project.hotelback.service.AuthenticationService;

@AllArgsConstructor
public abstract class AuthDecorator implements AuthenticationService {

    protected AuthenticationService authService;

    @Override
    public void signup(UserDTO userDTO) {
        authService.signup(userDTO);
    }

    @Override
    public User login(UserDTO userDTO) {
        return authService.login(userDTO);
    }
}
