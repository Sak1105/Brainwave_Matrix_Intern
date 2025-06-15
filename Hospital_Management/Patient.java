import java.util.*;

public class Patient {
    String id;
    String name;
    String dob;
    int age;
    String contactinfo;
    List<Appointment> appointments;
    List<EHR> medicalrecords;

    Patient (String id , String name , String dob , int age , String coninfo) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.age = age;
        this.contactinfo = coninfo;
        this.appointments = new ArrayList<>();
        this.medicalrecords = new ArrayList<>();
    }

    public String getid() { return id;}
    public String getName() {return name;}
    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }
    public void addMedicalRecord(EHR record) {
        medicalrecords.add(record);
    }
    public List<EHR> getMedicalRecords() {
        return medicalrecords;
    }

    @Override
    public String toString() {
        return "Patient ID: " + id + ", Name: " + name + ", DOB " + dob + ", Age: " + age + ", Contact: " + contactinfo;
    }
}
