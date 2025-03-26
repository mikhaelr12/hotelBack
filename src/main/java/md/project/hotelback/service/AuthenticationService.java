package md.project.hotelback.service;

import md.project.hotelback.dto.UserDTO;
import md.project.hotelback.entity.User;

public interface AuthenticationService {
    void signup(UserDTO userDTO);

    User login(UserDTO userDTO);
}
