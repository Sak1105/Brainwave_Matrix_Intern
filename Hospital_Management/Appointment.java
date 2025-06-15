
public class Appointment {
    private String appointmentId;
    private Patient patient;
    private Doctor doctor;
    private String appointmentDate;

    public Appointment(String appointmentId, Patient patient, Doctor doctor, String appointmentDate) {
        this.appointmentId = appointmentId;
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentId() { return appointmentId; }
    public Patient getPatient() { return patient; }
    public Doctor getDoctor() { return doctor; }
    public String getAppointmentDate() { return appointmentDate; }

    @Override
    public String toString() {
        return "Appointment ID: " + appointmentId + ", Patient: " + patient.getName() + ", Doctor: " + doctor.getName() + ", Date: " + appointmentDate;
    }
}
