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
    try {
        PrintWriter writer = new PrintWriter("Course_data.txt");
        for(Course course: courses.getAll()){
            writer.print(course.getCourseID()+" ");
            writer.print(course.getTitle()+" ");
            writer.println(course.getCredits()+"");
            Teacher assignedTeacher = course.getAssignedTeacher();
            if (assignedTeacher != null) {
                writer.print(assignedTeacher.getTeacherID()+" ");
                writer.print(assignedTeacher.getName()+" ");
                writer.print(assignedTeacher.getEmail()+" ");
                writer.print(assignedTeacher.getDateOfBirth()+" ");
                writer.println(assignedTeacher.getSpecialization()+" ");
            } else {
                writer.println("null");
            }
            List<Student> enrolledStudents = course.getEnrolledStudents();
            for (Student student : enrolledStudents) {
                writer.print(student.getStudentID()+" ");
                writer.print(student.getName()+" ");
                writer.print(student.getEmail()+" ");
                writer.print(student.getDateOfBirth()+" ");
                writer.println(student.getAddress()+" ");

            }
            List<Integer> grades = course.getGrades();
            for (Integer grade : grades) {
                if (grade != null) {
                    writer.print(grade+" ");
                } else {
                    writer.print("null"+" ");
                }
            }
            writer.println("\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing to file");
        }
        }
    }
