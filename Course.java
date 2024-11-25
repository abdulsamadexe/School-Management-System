import java.util.ArrayList;
import java.util.List;
public class Course {
    private String courseID;
    private String title;
    private int credits;
    private Teacher assignedTeacher;
    private List<Student> enrolledStudents;

    public Course(String courseID, String title, int credits) {
        this.courseID = courseID;
        this.title = title;
        this.credits = credits;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getCourseID() {
        return courseID;
    }

    public String getTitle() {
        return title;
    }

    public int getCredits() {
        return credits;
    }

    public void setAssignedTeacher(Teacher teacher) {
        this.assignedTeacher = teacher;
    }

    public void addStudent(Student student) {
        enrolledStudents.add(student);
        System.out.println("Student " + student.getStudentID() + " added to " + title);
    }

    public void removeStudent(Student student) {
        if (enrolledStudents.remove(student)) {
            System.out.println("Student " + student.getStudentID() + " removed from " + title);
        } else {
            System.out.println("Student " + student.getStudentID() + " is not enrolled in " + title);
        }
    }

    public double calculateAverageGrade() {
        // Placeholder for grade calculation logic
        return 0.0;
    }
}