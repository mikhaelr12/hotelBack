package md.project.hotelback.service.impl.notifications;

import md.project.hotelback.entity.HotelBooking;
import md.project.hotelback.entity.User;
import md.project.hotelback.factory.AbstractNotificationProcessor;
import md.project.hotelback.util.BookingMessage;
import md.project.hotelback.util.UserExtractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component("email")
public class EmailServiceImpl extends AbstractNotificationProcessor {

    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UserExtractServiceImpl userExtractService;

    @Autowired
    private BookingMessage bookingMessage;

    public EmailServiceImpl(UserExtractServiceImpl userExtractService) {
        super(userExtractService);
    }


    @Override
    protected String prepareMessage(HotelBooking hotelBooking) {
        return bookingMessage.generateMessage(hotelBooking);

    }

    @Override
    protected void doSendNotification(User user, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from);
        mailMessage.setTo(user.getEmail());
        mailMessage.setSubject("Booking Confirmation");
        mailMessage.setText(message);
        mailSender.send(mailMessage);
    }

    public void sendNotificationToAdmins(HotelBooking hotelBooking, User user) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(user.getEmail());
        message.setSubject("Booking confirmation");
        message.setText(bookingMessage.generateMessage(hotelBooking));
        mailSender.send(message);
    }

    public void sendNotificationToPartners(HotelBooking hotelBooking, User partner) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(partner.getEmail());
        message.setSubject("Booking confirmation");
        message.setText(bookingMessage.generateMessage(hotelBooking));
        mailSender.send(message);
    }
}
