package md.project.hotelback.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String username;
    private String email;
    private String credential;
    private String password;
    private String phoneNumber;
}
