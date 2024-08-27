class StaffMember {
    private int staffId;
    private String fullName;
    private String role;
    private double pay;

    public StaffMember(int staffId, String fullName, String role, double pay) {
        this.staffId = staffId;
        this.fullName = fullName;
        this.role = role;
        this.pay = pay;
    }

    public int getStaffId() {
        return staffId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getRole() {
        return role;
    }

    public double getPay() {
        return pay;
    }

    @Override
    public String toString() {
        return "StaffMember[ID=" + staffId + ", Name=" + fullName + ", Role=" + role + ", Pay=" + pay + "]";
    }
}

public class StaffManagement {
    private StaffMember[] staffList;
    private int currentIndex;

    public StaffManagement(int capacity) {
        staffList = new StaffMember[capacity];
        currentIndex = 0;
    }

    public void addStaffMember(StaffMember staff) {
        if (currentIndex < staffList.length) {
            staffList[currentIndex++] = staff;
        } else {
            System.out.println("Staff list is full.");
        }
    }

    public StaffMember findStaffMember(int staffId) {
        for (int i = 0; i < currentIndex; i++) {
            if (staffList[i].getStaffId() == staffId) {
                return staffList[i];
            }
        }
        return null;
    }

    public void removeStaffMember(int staffId) {
        for (int i = 0; i < currentIndex; i++) {
            if (staffList[i].getStaffId() == staffId) {
                staffList[i] = staffList[currentIndex - 1];
                staffList[currentIndex - 1] = null;
                currentIndex--;
                return;
            }
        }
        System.out.println("Staff member not found.");
    }

    public void displayAllStaff() {
        for (int i = 0; i < currentIndex; i++) {
            System.out.println(staffList[i]);
        }
    }

    public static void main(String[] args) {
        StaffManagement management = new StaffManagement(10);

        management.addStaffMember(new StaffMember(1, "John Doe", "Developer", 50000));
        management.addStaffMember(new StaffMember(2, "Jane Smith", "Manager", 60000));
        management.addStaffMember(new StaffMember(3, "Emily Davis", "Designer", 55000));

        System.out.println("All Staff Members:");
        management.displayAllStaff();

        System.out.println("\nSearching for Staff Member with ID 2:");
        StaffMember staff = management.findStaffMember(2);
        System.out.println(staff != null ? staff : "Staff member not found");

        System.out.println("\nRemoving Staff Member with ID 2:");
        management.removeStaffMember(2);
        management.displayAllStaff();
    }
}
