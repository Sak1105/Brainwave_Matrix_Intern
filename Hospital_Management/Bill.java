import java.util.*;

public class Bill {
    private String billid;
    private Patient patient;
    private List<String> Services;
    private double totalamount;

    Bill(String bid , Patient patient , List<String> services , double ta) {
        this.billid = bid;
        this.patient = patient;
        this.Services = services;
        this.totalamount = ta;
    }

    public String getBillId() { return billid; }
    public Patient getPatient() { return patient; }
    public List<String> getServices() { return Services; }
    public double getTotalAmount() { return totalamount; }

    @Override
    public String toString() {
        return "Bill ID: " + billid + ", Patient: " + patient.getName() + ", Total Amount: $" + totalamount;
    }
}
