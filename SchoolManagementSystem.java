import java.util.List;

public class SchoolManagementSystem {
    public static void main(String[] args) {
        University university = new University();
        university.loadData("data.txt");
        university.addTeacher(new Teacher("T001", "JohnDoe", "abc@gmail.com", "01/01/1990", "Mathematics"));
        university.assignTeacherToCourse("T001", "C004");
        
        university.saveData("data.txt");


        }
    }
