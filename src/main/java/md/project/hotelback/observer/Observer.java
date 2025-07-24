package md.project.hotelback.observer;

import md.project.hotelback.entity.HotelBooking;

public interface Observer {

    void update(HotelBooking hotelBooking);
}
