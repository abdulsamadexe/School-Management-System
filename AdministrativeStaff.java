import java.util.List;
public class AdministrativeStaff extends Person implements Reportable {
    private String staffID;
    private String role;
    private String department;

    public AdministrativeStaff(String staffID, String name, String email, String dateOfBirth, String role, String department) {
        super(name, email, dateOfBirth);
        this.staffID = staffID;
        this.role = role;
        this.department = department;
    }

    public String generateReport(List<Person> people) {
        StringBuilder report = new StringBuilder();
        for (Person person : people) {
            report.append(person.displayDetails()).append("\n");
        }
        return report.toString();
    }

    @Override
    public String displayDetails() {
        return "Staff: " + staffID + ", Name: " + name + ", Role: " + role + ", Department: " + department;
    }

    @Override
    public String generateReport() {
        return "Administrative Staff Report: " + displayDetails();
    }
}