package md.project.hotelback.service;

import md.project.hotelback.dto.NotificationDTO;
import md.project.hotelback.entity.HotelBooking;

public interface NotificationService {

    void sendNotification(String jwt, HotelBooking hotelBooking);
}
