public class SchoolManagementSystem {
    public static void main(String[] args) {
        University university = new University();
        Course course1 = new Course("C001", "Mathematics", 4);
        Course course2 = new Course("C002", "Physics", 3);
        Course course3 = new Course("C003", "Chemistry", 3);
        university.addCourse(course1);
        university.addCourse(course2);
        university.addCourse(course3);

        Teacher teacher1 = new Teacher("T001", "John", "abc@gmail.com", "01-01-1980", "Mathematics");
        Teacher teacher2 = new Teacher("T002", "Jane", "sda@gmail.com", "02-02-1985", "Physics");
        university.addTeacher(teacher1);
        university.addTeacher(teacher2);

        Student student1 = new Student("S001", "Alice", "fds@gmail.com", "01-01-2000", "123 Main St");
        Student student2 = new Student("S002", "Bob", "gfr@gmail.com", "02-02-2001", "456 Elm St");
        university.addStudent(student1);
        university.addStudent(student2);

        course1.setAssignedTeacher(teacher2);
        course2.setAssignedTeacher(teacher1);
        course3.setAssignedTeacher(teacher1);

        student1.enrollInCourse(course1);
        course1.addStudent(student1);
        student1.enrollInCourse(course2);
        course2.addStudent(student1);
        student2.enrollInCourse(course1);
        course1.addStudent(student2);

        teacher1.assignCourse(course1);
        teacher1.assignCourse(course2);
        teacher2.assignCourse(course3);

        university.saveData("University_data.txt");


    }
}
