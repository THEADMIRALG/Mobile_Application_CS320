import java.time.LocalDateTime;

public class Appointment {
    private String appointmentId;
    private LocalDateTime appointmentDate;
    private String appointmentDescription;

    public Appointment(String appointmentId, LocalDateTime appointmentDate, String appointmentDescription) {
        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.appointmentDescription = appointmentDescription;
    }

    public void setAppointmentId(String appointmentId) {
        if (appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException("ID does not fulfill requirements.");
        }
        else {
            this.appointmentId = appointmentId;
        }
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        if (appointmentDate == null || appointmentDate.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Date does not fulfill requirements.");
        }
        else {
            this.appointmentDate = appointmentDate;
        }
    }

    public void setAppointmentDescription(String appointmentDescription) {
        if (appointmentDescription == null || appointmentDescription.length() > 50) {
            throw new IllegalArgumentException("Description does not fulfill requirements.");
        }
        else {
            this.appointmentDescription = appointmentDescription;
        }
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public String getAppointmentDescription() {
        return appointmentDescription;
    }
}