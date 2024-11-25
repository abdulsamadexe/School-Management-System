import java.util.*;
public class Student extends Person {
    private String studentID;
    private String address;
    private List<Course> enrolledCourses;

    public Student(String studentID, String name, String email, String dateOfBirth, String address) {
        super(name, email, dateOfBirth);
        this.studentID = studentID;
        this.address = address;
        this.enrolledCourses = new ArrayList<>();
    }
    
    public String getStudentID() {
        return studentID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void enrollInCourse(Course course) {
        enrolledCourses.add(course);
        System.out.println("Student " + studentID + " successfully enrolled in " + course.getTitle());
    }

    public void displayCourses() {
        System.out.println("Courses enrolled by " + name + ":");
        for (Course course : enrolledCourses) {
            System.out.println(course.getTitle() + " (" + course.getCredits() + " credits)");
        }
    }

    @Override
    public String displayDetails() {
        return "Student: " + studentID + ", Name: " + name + ", Enrolled in: " + enrolledCourses;
    }
}