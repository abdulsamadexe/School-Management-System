import java.util.*;
import java.io.*;
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

    public Teacher getAssignedTeacher() {
        return assignedTeacher;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public void setAssignedTeacher(Teacher teacher) {
        this.assignedTeacher = teacher;
        teacher.assignCourse(this);
    }

    public void addStudent(Student student) {
        enrolledStudents.add(student);
        grades.add(null);
        System.out.println("Student " + student.getStudentID() + " added to " + title);
        student.enrollInCourse(this);
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

    public boolean issame(Course c){
        return this.courseID.equals(c.getCourseID()) && this.courseID.equals(c.getCourseID()) && this.credits==c.getCredits();
    }
    
}