import java.util.List;

public class SchoolManagementSystem {
    public static void main(String[] args) {
        University university = new University();
        university.loadData("data.txt");
        // university.addTeacher(new Teacher("T002", "JohnDoe", "abc@gmail.com", "01/01/1990", "Mathematics"));
        // university.assignTeacherToCourse("T002", "C004");
        // university.enrollStudentInCourse("S003", "C005");
        Course course = new Course("C993", "Physics", 3);
        university.addCourse(course);
        
        university.assignTeacherToCourse("T001", "C993");
        university.saveData("data.txt");
        }
    }
