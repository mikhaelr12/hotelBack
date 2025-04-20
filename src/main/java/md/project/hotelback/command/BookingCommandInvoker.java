package md.project.hotelback.command;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@AllArgsConstructor
public class BookingCommandInvoker {

    private Map<String ,Command> commands;

    public void executeCommand(String commandKey, String jwt, Long bookingId) {
        Command command = commands.get(commandKey);
        command.execute(jwt, bookingId);
    }
}
