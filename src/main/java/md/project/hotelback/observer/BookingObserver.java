package md.project.hotelback.observer;

import lombok.AllArgsConstructor;
import md.project.hotelback.entity.HotelBooking;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class BookingObserver {
    private final List<Observer> observers;

    public void notifyObservers(HotelBooking hotelBooking) {
        for (Observer observer : observers) {
            observer.update(hotelBooking);
        }
    }
}
