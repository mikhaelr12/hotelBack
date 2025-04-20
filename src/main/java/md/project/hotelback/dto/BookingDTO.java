package md.project.hotelback.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import md.project.hotelback.entity.BookingStatus;
import md.project.hotelback.entity.Hotel;
import md.project.hotelback.entity.Room;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class BookingDTO {
    private Long bookingId;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private Room room;
    private Long roomId;
    private Double price;
    private BookingStatus status;
    private String notificationType;
    private Hotel hotel;
    private Long hotelId;

    public BookingDTO(Builder builder){
        this.bookingId = builder.bookingId;
        this.checkIn = builder.checkIn;
        this.checkOut = builder.checkOut;
        this.roomId = builder.roomId;
        this.price = builder.price;
        this.status = builder.status;
        this.notificationType = builder.notificationType;
        this.hotel = builder.hotel;
        this.hotelId = builder.hotelId;
    }

    public static class Builder{
        private Long bookingId;
        private LocalDate checkIn;
        private LocalDate checkOut;
        private Room room;
        private Long roomId;
        private Double price;
        private BookingStatus status;
        private String notificationType;
        private Hotel hotel;
        private Long hotelId;

        public Builder bookingId(Long bookingId){
            this.bookingId = bookingId;
            return this;
        }
        public Builder checkIn(LocalDate checkIn){
            this.checkIn = checkIn;
            return this;
        }
        public Builder checkOut(LocalDate checkOut){
            this.checkOut = checkOut;
            return this;
        }
        public Builder room(Room room){
            this.room = room;
            return this;
        }
        public Builder roomId(Long roomId){
            this.roomId = roomId;
            return this;
        }
        public Builder price(Double price){
            this.price = price;
            return this;
        }
        public Builder status(BookingStatus status){
            this.status = status;
            return this;
        }
        public Builder notificationType(String notificationType){
            this.notificationType = notificationType;
            return this;
        }
        public Builder hotel(Hotel hotel){
            this.hotel = hotel;
            return this;
        }

        public Builder hotelId(Long hotelId){
            this.hotelId = hotelId;
            return this;
        }

        public BookingDTO build(){

            return new BookingDTO(this);
        }
    }
}
