import java.util.ArrayList;
import java.util.List;
public class Teacher extends Person implements Reportable {
    private String teacherID;
    private String specialization;
    private List<Course> coursesTaught;

    public Teacher(String teacherID, String name, String email, String dateOfBirth, String specialization) {
        super(name, email, dateOfBirth);
        this.teacherID = teacherID;
        this.specialization = specialization;
        this.coursesTaught = new ArrayList<>();
    }

    public String getTeacherID() {
        return teacherID;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    



    public void assignCourse(Course course) {
        coursesTaught.add(course);
        System.out.println("Teacher " + teacherID + " assigned to teach " + course.getTitle());
    }

    public void displayCourses() {
        System.out.println("Courses taught by " + name + ":");
        for (Course course : coursesTaught) {
            System.out.println(course.getTitle() + " (" + course.getCourseID() + ")");
        }
    }

    @Override
    public String displayDetails() {
        return "Teacher: " + teacherID + ", Name: " + name + ", Specialization: " + specialization;
    }

    @Override
    public String generateReport() {
        return "Teacher Report: " + displayDetails();
    }
}