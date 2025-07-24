package md.project.hotelback.command;

public interface Command {
    void execute(String jwt, Long bookingId);
}
