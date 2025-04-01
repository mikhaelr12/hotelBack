package md.project.hotelback.dto;

import lombok.Data;

@Data
public class NotificationDTO {
    private String phone;
    private String sendTo;
    private String subject;
    private String message;

}
