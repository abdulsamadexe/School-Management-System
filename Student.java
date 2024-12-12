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


    public static void main(String[] args) {
        Student student1 = new Student("S001", "Alice", "abc", "01-01-2000", "123 Main St");
        Student student2 = new Student("S002", "Bob", "def", "02-02-2001", "456 Elm St");
        Course course1 = new Course("C001", "Mathematics", 4);
        Course course2 = new Course("C002", "Physics", 3);
        student1.enrollInCourse(course1);
        student1.enrollInCourse(course2);
        student2.enrollInCourse(course1);
        student1.displayCourses();
        student2.displayCourses();

    }
}

