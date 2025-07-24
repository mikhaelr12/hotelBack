package md.project.hotelback.job;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import md.project.hotelback.service.impl.BookingManagerImpl;
import md.project.hotelback.service.impl.BookingServiceImpl;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookingsJob {

    private final BookingManagerImpl bookingManager;

    @Transactional
    @Scheduled(cron = "0 * * * * *")
    public void completeFinishedBookings(){
        bookingManager.completeBookings();
    }

    @Transactional
    @Scheduled(cron = "0 * * * * *")
    public void cancelUnpaidExpiredBookings(){
        bookingManager.cancelUnpaidExpiredBookings();
    }

}
