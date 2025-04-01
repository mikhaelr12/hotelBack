package md.project.hotelback.dto;

import lombok.Data;

@Data
public class MailDTO {
    private String sendTo;
    private String text;
    private String subject;
}
