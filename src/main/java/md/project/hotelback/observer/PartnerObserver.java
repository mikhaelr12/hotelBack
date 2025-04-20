package md.project.hotelback.observer;

import lombok.AllArgsConstructor;
import md.project.hotelback.entity.HotelBooking;
import md.project.hotelback.entity.User;
import md.project.hotelback.repository.UserRepository;
import md.project.hotelback.service.impl.notifications.EmailServiceImpl;
import md.project.hotelback.util.UserExtractServiceImpl;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class PartnerObserver implements Observer {

    private final UserRepository userRepository;
    private final UserExtractServiceImpl userExtractService;

    @Override
    public void update(HotelBooking hotelBooking) {
        List<User> partners = userRepository.findAllByRoleId(3L);
        EmailServiceImpl emailService = new EmailServiceImpl(userExtractService);
        for (User partner : partners) {
            emailService.sendNotificationToPartners(hotelBooking, partner);
        }
    }
}
