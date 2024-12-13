import java.util.ArrayList;
import java.util.List;
public class Course {
    private String courseID;
    private String title;
    private int credits;
    private Teacher assignedTeacher;
    private List<Student> enrolledStudents;
    private List<Integer> grades;

    public Course(String courseID, String title,Teacher teacher, int credits) {
        this.courseID = courseID;
        this.title = title;
        this.credits = credits;
        this.assignedTeacher = teacher;
        this.enrolledStudents = new ArrayList<>(100);
        grades = new ArrayList<>(enrolledStudents.size());
        for (int i = 0; i < enrolledStudents.size(); i++) {
            grades.add(null);
        }
    }
    public Course(String courseID, String title, int credits) {
        this.courseID = courseID;
        this.title = title;
        this.credits = credits;
        this.assignedTeacher = null;
        this.enrolledStudents = new ArrayList<>(100);
        grades = new ArrayList<>(enrolledStudents.size());
        for (int i = 0; i < enrolledStudents.size(); i++) {
            grades.add(null);
         }
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
        grades.add(null);
        System.out.println("Student " + student.getStudentID() + " added to " + title);
    }

    public void removeStudent(Student student) {
        int index = enrolledStudents.indexOf(student);
        if (index != -1) {
            enrolledStudents.remove(index);
            grades.remove(index);
            System.out.println("Student " + student.getStudentID() + " removed from " + title);
        } else {
            System.out.println("Student " + student.getStudentID() + " is not enrolled in " + title);
        }
    }
    public void assignGrade(Student s, int grade) {
        int index = enrolledStudents.indexOf(s);
        if (index != -1) {
            grades.set(index, grade);
            System.out.println("Grade " + grade + " assigned to " + s.getStudentID() + " for " + title);
        } else {
            System.out.println(s.getStudentID() + " is not enrolled in " + title);
        }
        }

    public double calculateAverageGrade() {
        int sum = 0;
        for (Integer grade : grades) {
            if (grade != null) {
                sum += grade;
            }
            }
        if (enrolledStudents.size() > 0) {
            return (double) sum / enrolledStudents.size();
        }
        return 0.0;
    }

    public static void main(String[] args) {
        Course course = new Course("C001", "Mathematics", 4);
        Student student1 = new Student("S001", "Alice", "abc", "01-01-2000", "123 Main St");
        Student student2 = new Student("S002", "Bob", "def", "02-02-2001", "456 Elm St");
        Student student3 = new Student("S003", "Charlie", "ghi", "03-03-2002", "789 Oak St");

        course.addStudent(student1);
        course.addStudent(student2);
        course.addStudent(student3);

        course.removeStudent(student1);
        course.assignGrade(student2, 90);
        course.assignGrade(student3, 85);
        System.out.println("Average grade for " + course.getTitle() + ": " + course.calculateAverageGrade());

    }
}