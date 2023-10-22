import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class AppointmentServiceTest {

    AppointmentService appointmentService;

    @BeforeEach
    public void setup() {

        appointmentService = new AppointmentService();
        // Clear the list so that tests don't affect each other
        AppointmentService.appointmentList.clear();
        AppointmentService.appointmentList.add(new Appointment("1", LocalDateTime.now(), "This is the first test"));
        AppointmentService.appointmentList.add(new Appointment("2", LocalDateTime.now(), "This is the second test"));
        AppointmentService.appointmentList.add(new Appointment("3", LocalDateTime.now(), "This is the third test"));
        AppointmentService.appointmentList.add(new Appointment("4", LocalDateTime.now(), "This is the fourth test"));
    }

    @Test
    public void addAppointmentTest_ok() {
        Appointment taskToBeAdded =new Appointment("5", LocalDateTime.now(), "This is a test");
        appointmentService.addAppointment(taskToBeAdded);
        assertEquals(5, AppointmentService.appointmentList.size());
    }
    @Test
    public void addAppointmentTest_duplicateID() {
        Appointment appointmentToBeAdded =new Appointment("1", LocalDateTime.now(), "This is a test");
        AppointmentService.addAppointment(appointmentToBeAdded);
        assertEquals(4, appointmentService.appointmentList.size());
    }
    @Test
    public void deleteAppointmentTest_ok () {
        String deleteId = "1";
        AppointmentService.delete(deleteId);
        assertEquals(3, AppointmentService.appointmentList.size());
    }
    @Test
    public void deleteAppointmentTest_noId() {
        String deleteId = "6";
        appointmentService.delete(deleteId);
        assertEquals(4, AppointmentService.appointmentList.size());
    }

    @Test
    public void updateAppointmentTest_ok () {
        Appointment appointmentToBeUpdated =new Appointment("4", LocalDateTime.now(), "This is the third test");
        appointmentService.updateAppointment(appointmentToBeUpdated);
        assertEquals(LocalDateTime.now(), AppointmentService.appointmentList.get(3).getAppointmentDate());
        assertEquals("This is the third test", AppointmentService.appointmentList.get(3).getAppointmentDescription());
    }
    @Test
    public void updateAppointmentTest_duplicate () {
        Appointment appointmentToBeUpdated =new Appointment("5", LocalDateTime.now(), "This is the third test");
        assertThrows(IllegalArgumentException.class, () ->appointmentService.updateAppointment(appointmentToBeUpdated));
    }
}
