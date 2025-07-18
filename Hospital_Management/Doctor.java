import java.util.*;

public class Doctor {
    String id;
    String name;
    String specialization;
    List<Appointment> appointments;

    Doctor (String id , String name , String spz) {
        this.id = id;
        this.name = name;
        this.specialization = spz ;
        this.appointments = new ArrayList<>();
    }

    public String getid () { return id; }

    public String getName() { return name; }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    @Override
    public String toString() {
        return "Doctor ID: " + id + ", Name: " + name + ", Specialization: " + specialization;
    }
}
