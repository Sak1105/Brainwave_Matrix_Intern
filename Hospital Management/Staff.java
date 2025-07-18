class Staff {
    private String staffId;
    private String name;
    private String role;
    private String contactInfo;
    private int attendance;  

    public Staff(String staffId, String name, String role, String contactInfo) {
        this.staffId = staffId;
        this.name = name;
        this.role = role;
        this.contactInfo = contactInfo;
        this.attendance = 0;  // Initial attendance is zero
    }

    // Getters
    public String getStaffId() { return staffId; }
    public String getName() { return name; }
    public String getRole() { return role; }
    public String getContactInfo() { return contactInfo; }
    public int getAttendance() { return attendance; }
    public void setRole(String role) { this.role = role; }
    public void setContactInfo(String contactInfo) { this.contactInfo = contactInfo; }

    public void markAttendance(int attendanece) {
        attendanece++;
        System.out.println(name + "'s attendance updated. Days worked: " + attendance);
    }

    @Override
    public String toString() {
        return "Staff ID: " + staffId + ", Name: " + name + ", Role: " + role + ", Contact: " + contactInfo + ", Attendance: " + attendance + " days";
    }
}
