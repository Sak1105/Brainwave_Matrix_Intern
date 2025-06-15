import java.util.*;


class HospitalManagementSystem {
    private List<Patient> patients;
    private List<Doctor> doctors;
    private List<Appointment> appointments;
    private List<Staff> staffMembers;
    private Inventory inventory;
    private int patientcounter;

    public HospitalManagementSystem() {
        patients = new ArrayList<>();
        doctors = new ArrayList<>();
        appointments = new ArrayList<>();
        inventory = new Inventory();
        staffMembers = new ArrayList<>();
    }

    public List<Patient> getPatients() {
        return patients;
    }
    // Methods to manage patients
    public void registerPatient(String name, String dob, int age, String contactInfo) {
        String patientId = "P" + patientcounter++;  // Generate IDs like P1, P2, etc.
        Patient patient = new Patient(patientId,name, dob, age, contactInfo);
        patients.add(patient);
        System.out.println("Patient Registered: " + patient);
    }
    public Patient patientid(int n) {
        return patients.get(n);
    }

    // Methods to manage doctors
    public void registerDoctor(Doctor doctor) {
        doctors.add(doctor);
        System.out.println("Doctor Registered: " + doctor);
    }

    public Doctor selectedDoctor(int n) {
        return doctors.get(n);
    }

    // Methods to manage appointments
    public void scheduleAppointment(Patient patient, Doctor doctor, String date) {
        String appointmentId = "APPT" + (appointments.size() + 1);
        Appointment appointment = new Appointment(appointmentId, patient, doctor, date);
        appointments.add(appointment);
        patient.addAppointment(appointment);
        doctor.addAppointment(appointment);
        System.out.println("Appointment Scheduled: " + appointment);
    }

    // Method to update medical records (diagnosis and prescription)
    public void updateMedicalRecords(String patientId, String diagnosis, String prescription, Doctor doctor) {
        for (Patient patient : patients) {
            if (patient.getid().equals(patientId)) {
                String recordId = "REC" + (patient.getMedicalRecords().size() + 1); // Record IDs like REC1, REC2
                EHR record = new EHR(recordId, patient, doctor, diagnosis, prescription);
                patient.addMedicalRecord(record);
                System.out.println("Medical Record Updated: " + record);
                return;
            }
        }
        System.out.println("Patient with ID " + patientId + " not found.");
    }

    // Method to print medical records for all patients
    public void printAllMedicalRecords() {
        for (Patient patient : patients) {
            System.out.println("Medical Records for Patient: " + patient.getName());
            List<EHR> records = patient.getMedicalRecords();
            if (records.isEmpty()) {
                System.out.println("No medical records found.");
            } else {
                for (EHR record : records) {
                    System.out.println(record);
                }
            }
        }
    }

    // Methods to manage billing
    public void generateBill(Patient patient, List<String> services, double amount) {
        String billId = "BILL" + (patient.getid() + "-" + (int)(Math.random() * 1000));
        Bill bill = new Bill(billId, patient, services, amount);
        System.out.println("Bill Generated: " + bill);
    }

    // Inventory management
    public void manageInventory(String item, int quantity) {
        inventory.updateStock(item, quantity);
        System.out.println("Inventory Updated: " + item + ", Quantity: " + quantity);
    }

    // Display all registered patients
    public void displayPatients() {
        System.out.println("Registered Patients:");
        for (Patient p : patients) {
            System.out.println(p);
        }
    }

    // Display all registered doctors
    public void displayDoctors() {
        System.out.println("Registered Doctors:");
        for (Doctor d : doctors) {
            System.out.println(d);
        }
    }

    // Display inventory
    public void displayInventory() {
        inventory.displayStock();
    }

    // Methods to manage staff
    public void addStaff(String staffName,String staffRole,String coninfo) {
        int staffnum = 0;
        String staffid = "S"+staffnum++;
        Staff staff = new Staff(staffid, staffName, staffRole, coninfo);
        staffMembers.add(staff);
        System.out.println("Staff added: " + staff);
    }

    public void updateStaffAttendance(String staffId, int att) {
        for (Staff staff : staffMembers) {
            if (staff.getStaffId().equals(staffId)) {
                staff.markAttendance(att);
                System.out.println("Attendance updated: " + staff);
                return;
            }
        }
        System.out.println("Staff with ID " + staffId + " not found.");
    }

    public void displayStaff() {
        System.out.println("Hospital Staff:");
        if (staffMembers.isEmpty()) {
            System.out.println("No staff members registered.");
        } else {
            for (Staff staff : staffMembers) {
                System.out.println(staff);
            }
        }
    }
}
