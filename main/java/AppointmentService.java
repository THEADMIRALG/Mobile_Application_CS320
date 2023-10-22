import java.time.LocalDateTime;
import java.util.ArrayList;


public class AppointmentService {

    static ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();


    public static void addAppointment(Appointment newAppointment) {
        if (appointmentList.stream().noneMatch(c -> c.getAppointmentId().equals(newAppointment.getAppointmentId()))) {
            appointmentList.add(newAppointment);
        }
    }


    public static void delete(String id) {
        appointmentList.remove(appointmentList.stream().filter(c -> c.getAppointmentId().equals(id)).findFirst().orElse(null));
    }


    public void updateAppointment(Appointment updateAppointment) {
        Appointment matchingAppointment = appointmentList.stream().filter(c -> c.getAppointmentId().equals(updateAppointment.getAppointmentId())).findFirst().orElse(null);
        if(matchingAppointment != null) {
            matchingAppointment.setAppointmentDate(updateAppointment.getAppointmentDate());
            matchingAppointment.setAppointmentDescription(updateAppointment.getAppointmentDescription());

        }
        else{
            throw new IllegalArgumentException("Appointment Id not found.");
        }
    }


}
