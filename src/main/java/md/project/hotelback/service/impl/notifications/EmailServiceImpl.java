package md.project.hotelback.service.impl.notifications;

import md.project.hotelback.dto.NotificationDTO;
import md.project.hotelback.entity.HotelBooking;
import md.project.hotelback.entity.User;
import md.project.hotelback.repository.UserRepository;
import md.project.hotelback.service.NotificationService;
import md.project.hotelback.util.BookingMessage;
import md.project.hotelback.util.JwtServiceImpl;
import md.project.hotelback.util.UserExtractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component("email")
public class EmailServiceImpl implements NotificationService {

    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UserExtractServiceImpl userExtractService;


    @Override
    public void sendNotification(String jwt, HotelBooking hotelBooking) {
        User user = userExtractService.getUser(jwt);
        var text = new BookingMessage();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(user.getEmail());
        message.setSubject("Booking confirmation");
        message.setText(text.generateMessage(hotelBooking));
        mailSender.send(message);
    }
}
