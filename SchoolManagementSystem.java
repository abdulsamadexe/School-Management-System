import java.util.List;

public class SchoolManagementSystem {
    public static void main(String[] args) {
        University university = new University();
        university.loadData("data.txt");
        // university.addTeacher(new Teacher("T002", "John", "abc@gmail.com", "01/01/1990", "Mathematics"));
        // Course course = new Course("C025", "Civics", 2);
        // university.addCourse(course);
        
        university.assignTeacherToCourse("T111", "C111");
        
        university.saveData("data.txt");


        }
    }
