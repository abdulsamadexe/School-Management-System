import java.util.List;

public class SchoolManagementSystem {
    public static void main(String[] args) {
        University university = new University();
        university.loadData("data.txt");

        // Create test students
        Student student1 = new Student("S001", "JohnDoe", "john.doe@example.com", "1990-01-01", "123MainSt");
        Student student2 = new Student("S002", "JaneSmith", "jane.smith@example.com", "1992-02-02", "456ElmSt");

        // Create test teachers
        Teacher teacher1 = new Teacher("T001", "Dr.Brown", "dr.brown@example.com", "1975-03-03", "Mathematics");
        Teacher teacher2 = new Teacher("T002", "Prof.Green", "prof.green@example.com", "1980-04-04", "Physics");

        // Create test courses
        Course course1 = new Course("C001", "Calculus", teacher1, 3);
        Course course2 = new Course("C002", "Physics", teacher2, 4);

        AdministrativeStaff adminStaff1 = new AdministrativeStaff("A001", "Alice", "123@gmail.com", "1990-01-01", "123MainSt", "Receptionist");
        AdministrativeStaff adminStaff2 = new AdministrativeStaff("A002", "Bob", "ghyt@gmail.com", "1990-01-01", "123MainSt", "Janitor");

        Student student3 = new Student("S003", "JohnDoe", "kju@gmail.com", "1990-01-01", "123MainSt");

       university.removeStudentFromCourse("S002", "C001");

        university.saveData("data.txt");
        }
    }
