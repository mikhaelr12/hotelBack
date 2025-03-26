package md.project.hotelback.controller;

import lombok.AllArgsConstructor;
import md.project.hotelback.dto.UserDTO;
import md.project.hotelback.dto.response.LoginResponse;
import md.project.hotelback.entity.User;
import md.project.hotelback.service.AuthenticationService;
import md.project.hotelback.util.JwtServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    private final JwtServiceImpl jwtService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDTO userDTO){
        authenticationService.signup(userDTO);
        return ResponseEntity.ok("Account created");
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody UserDTO userDTO){
        User authenticatedUser = authenticationService.login(userDTO);
        String token = jwtService.generateToken(authenticatedUser);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(token);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());
        return ResponseEntity.ok(loginResponse);
    }
}