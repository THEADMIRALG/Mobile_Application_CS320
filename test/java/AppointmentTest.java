import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class AppointmentTest {

    Appointment tomorrowAppointment;


    @BeforeEach
    public void setup() {
        tomorrowAppointment = new Appointment("testID", LocalDateTime.now().plusDays(1), "Java 101 lecture");
    }

    @Test
    public void setAppointmentId_ok() {
        tomorrowAppointment.setAppointmentId("123456789");
        assertEquals("123456789", tomorrowAppointment.getAppointmentId());
    }

    @Test
    public void setAppointmentId_null(){
        String newAppointmentId = null;
        assertThrows(IllegalArgumentException.class, ()  -> tomorrowAppointment.setAppointmentId(newAppointmentId));
    }

    @Test
    public void setAppointmentId_longerThan10() {
        String newAppointmentId = "1234567891011";
        assertThrows(IllegalArgumentException.class, () -> tomorrowAppointment.setAppointmentId(newAppointmentId));
    }
}
