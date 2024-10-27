public class EHR {
    private String recordid;
    private Patient patient;
    private Doctor doctor;
    private String diagnosis;
    private String prescription;

    EHR (String id, Patient patient, Doctor doctor, String dia , String pres) {
        this.recordid = id;
        this.patient = patient;
        this.doctor = doctor;
        this.diagnosis = dia;
        this.prescription = pres;
    }

    public String getRecordId() { return recordid; }
    public Patient getPatient() { return patient; }
    public Doctor getDoctor() { return doctor; }
    public String getDiagnosis() { return diagnosis; }
    public String getPrescription() { return prescription; }

    @Override
    public String toString() {
        return "Medical Record ID: " + recordid + ", Patient: " + patient.getName() + ", Doctor: " + doctor.getName() + ", Diagnosis: " + diagnosis + ", Prescription: " + prescription;
    }
}
