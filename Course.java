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

    public void writeData() {
        System.out.println("Writing data to file");
        try{
            FileWriter writer = new FileWriter("Course_data.txt");
            writer.write("Course ID: " + courseID + "\n");
            writer.write("Title: " + title + "\n");
            writer.write("Credits: " + credits + "\n");
            writer.write("Teacher: " + assignedTeacher.getName() + "\n");
            writer.write("Students: \n");
            for (int i = 0; i < enrolledStudents.size(); i++) {
                writer.write(enrolledStudents.get(i).getStudentID() + " - " + grades.get(i) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Course course = new Course("CSC101", "Intro to Programming", 3);
        Teacher teacher = new Teacher("John Doe", "jdoe", "asd", "01/01/2000", "Computer Science");
        course.setAssignedTeacher(teacher);
        Student student1 = new Student("Alice", "alice", "asd", "01/01/2000", "123");
        Student student2 = new Student("Bob", "bob", "asd", "01/01/2000", "456");
        course.addStudent(student1);
        course.addStudent(student2);
        course.assignGrade(student1, 90);
        course.assignGrade(student2, 85);
        course.writeData();
        
    }
}