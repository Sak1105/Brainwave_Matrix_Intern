import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HospitalManagementSystem hms = new HospitalManagementSystem();

        // Registering some doctors (self-added for simplicity)
        Doctor doc1 = new Doctor("D1", "Dr. Anjali Srivastava", "Cardiology");
        Doctor doc2 = new Doctor("D2", "Dr. Anita Khare", "Gynecologist");
        Doctor doc3 = new Doctor("D3", "Dr. D K Singh", "Dermatologist");
        Doctor doc4 = new Doctor("D4", "Dr. A K Chaturvedi", "Neurology");
        Doctor doc5 = new Doctor("D5", "Dr. Mittal", "Orthopaedics");
        Doctor doc6 = new Doctor("D6", "Dr. Srivesh", "Gastroentrologist");
        Doctor doc7 = new Doctor("D7", "Dr. Emily Brown", "Dentist");
        hms.registerDoctor(doc1);
        hms.registerDoctor(doc2);
        hms.registerDoctor(doc3);
        hms.registerDoctor(doc4);
        hms.registerDoctor(doc5);
        hms.registerDoctor(doc6);
        hms.registerDoctor(doc7);
        System.out.println("Homepage");
        while (true) {
            System.out.println("Patient Registration  --- y/n");
            char p = scanner.next().charAt(0);
            if(p=='y') {
                // Input for Patient Registration
                while (true) {
                    System.out.println("Enter patient details for registration:");
                    scanner.nextLine();
                    System.out.print("Name: ");
                    String name = scanner.nextLine();

                    System.out.print("DOB: ");
                    String dob = scanner.nextLine();

                    System.out.print("Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();  // consume the newline

                    System.out.print("Contact Info: ");
                    String contactInfo = scanner.nextLine();

                    // Register the patient using the generated sequential ID (P1, P2, etc.)
                    hms.registerPatient(name, dob, age, contactInfo);

                    System.out.println("Schedule Appointment  --- y/n");
                    p = scanner.next().charAt(0);
                    scanner.nextLine();
                    if ( p== 'y') {
                        // Scheduling an Appointment
                        System.out.println("Select Doctor for Appointment :");
                        hms.displayDoctors();
                        int doctorChoice = scanner.nextInt();
                        Doctor selectedDoctor = hms.selectedDoctor(doctorChoice-1);

                        System.out.print("Enter appointment date (yyyy-mm-dd): ");
                        String appointmentDateStr = scanner.next();

                        Patient patient = hms.getPatients().get(hms.getPatients().size() - 1);  // Get the last registered patient
                        hms.scheduleAppointment(patient, selectedDoctor, appointmentDateStr);

                        
                    }
                    System.out.print("Enter another patients details: y/n :");
                    p = scanner.next().charAt(0);
                    if ( p== 'n' )
                        break;
                }

                System.out.println("Patient Login ---y/n");
                p=scanner.next().charAt(0);
                scanner.nextLine();
                if(p=='y')
                {
                    System.out.println("Enter PatientId:");
                    String pid= scanner.next().substring(1);
                    Patient patient = hms.patientid(Integer.parseInt(pid)-1);
                    System.out.println("Updating Medical Records  --- y/n");
                    // Medical Records Input (Diagnosis and Prescription)
                    scanner.nextLine();  // consume the newline
                    System.out.println("Select Doctor consulted :");
                    hms.displayDoctors();
                    int doctorChoice = scanner.nextInt();
                    Doctor selectedDoctor = hms.selectedDoctor(doctorChoice-1);
                    scanner.nextLine();
                    System.out.print("Enter Diagnosis: ");
                    String diagnosis = scanner.nextLine();

                    System.out.print("Enter Prescription: ");
                    String prescription = scanner.nextLine();

                    // Update medical records for the patient
                    hms.updateMedicalRecords(patient.getid(), diagnosis, prescription, selectedDoctor);


                    System.out.println("Generate Bill  --- y/n");
                    p = scanner.next().charAt(0);
                    if ( p== 'y') {
                    hms.generateBill(patient, Arrays.asList("Consultation", "Blood Test"), 150.00);
                    }

                    System.out.println("View Medical Records  --- y/n");
                    p = scanner.next().charAt(0);
                    if ( p== 'y') {
                    hms.printAllMedicalRecords();
                    }

                    System.out.print("Get another patients details: y/n :");
                    char ch = scanner.next().charAt(0);
                    if ( ch== 'n' )
                        break;
                }
            }

            System.out.println("Inventory details --y/n");
            p=scanner.next().charAt(0);
            if (p=='y') {
                System.out.println("Manage Inventory -- y/n");
                p=scanner.next().charAt(0);
                if (p=='y') {
                    while(true) {
                        System.out.println("Enter item and quantity");
                        String item = scanner.next();
                        int q=scanner.nextInt();
                        hms.manageInventory(item, q);
                        System.out.println("Press q to quit updating inventory");
                        p = scanner.next().charAt(0);
                        if (p == 'q')
                            break;
                    }
                }
                System.out.println("Display Inventory -- y/n");
                p=scanner.next().charAt(0);
                if (p=='y')
                    hms.displayInventory();
            }

            System.out.println("Staff Management  ---y/n");
            p=scanner.next().charAt(0);
            if (p=='y') {
            // Function to add staff members
                while (true) {
                    System.out.println("Enter staff details to Register/Login:");
                    scanner.nextLine();
                    System.out.print("Enter Staff Name: ");
                    String staffName = scanner.nextLine();
                    System.out.print("Enter Staff Role: ");
                    String staffRole = scanner.nextLine();
                    System.out.print("Enter Staff Contact Info: ");
                    String coninfo = scanner.nextLine();
                    hms.addStaff(staffName, staffRole, coninfo);
                
            // Function to update staff attendance
                    System.out.println("Mark Attendance --- y/n");
                    p=scanner.next().charAt(0);
                    scanner.nextLine();
                    if(p=='y') {
                        System.out.println("Enter the Staff ID to update attendance:");
                        String staffId = scanner.nextLine();
                        System.out.print("Enter new attendance value: ");
                        int attendance = scanner.nextInt();
                        hms.updateStaffAttendance(staffId, attendance);
                    }

                    System.out.println("Press q to quit staff management:");
                    p = scanner.next().charAt(0);
                    if (p == 'q')
                        break;
                    // Function to display all staff members
                }
                System.out.println("Dispaly Staff --- y/n");
                p=scanner.next().charAt(0);
                if(p=='y') 
                    hms.displayStaff();
            }
            System.out.println("Return to Homepage ---y/n");
            p=scanner.next().charAt(0);
            if (p=='n')
                break;
        }
        scanner.close();
    
    }
}