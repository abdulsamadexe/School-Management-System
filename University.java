import java.io.*;
import java.util.*;
public class University {
    private static int totalStudents = 0;
    private static int totalTeachers = 0;
    private static int totalCourses = 0;

    private Repository<Student> students;
    private Repository<Teacher> teachers;
    private Repository<Course> courses;

    public University() {
        students = new Repository<>();
        teachers = new Repository<>();
        courses = new Repository<>();     
    }

    public void addStudent(Student student) {
        students.add(student);
        totalStudents++;
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
        totalTeachers++;
    }

    public void addCourse(Course course) {
        courses.add(course);
        totalCourses++;
    }

    public void displaySystemStats() {
        System.out.println("Total Students: " + totalStudents);
        System.out.println("Total Teachers: " + totalTeachers);
        System.out.println("Total Courses: " + totalCourses);
    }

    public List<Student> searchStudentByName(String name) {
        List<Student> result = new ArrayList<>();
        for (Student student : students.getAll()) {
            if (student.getName().equalsIgnoreCase(name)) {
                result.add(student);
            }
        }
        return result;
    }

    public List<Course> filterCoursesByCredits(int minCredits) {
        List<Course> result = new ArrayList<>();
        for (Course course : courses.getAll()) {
            if (course.getCredits() >= minCredits) {
                result.add(course);
            }
        }
        return result;
    }


    public void loadData(String filename) {
        
    }


    public void saveData(String filename) {
       
    }

    public static void main(String[] args) {
        
    }
}