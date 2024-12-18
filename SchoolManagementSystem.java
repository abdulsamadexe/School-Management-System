public class SchoolManagementSystem {
    public static void main(String[] args) {
        University university = new University();
    // Load existing data from files
    university.loadData("data.txt");

    // Create 3 students
    Student student1 = new Student("S003", "Charlie", "charlie@example.com", "03-03-2002", "789 Pine St");
    Student student2 = new Student("S004", "David", "david@example.com", "04-04-2003", "101 Maple St");
    Student student3 = new Student("S005", "Eve", "eve@example.com", "05-05-2004", "202 Oak St");

    // Add students to university
    university.addStudent(student1);
    university.addStudent(student2);
    university.addStudent(student3);

    // Create 3 courses
    Course course1 = new Course("C004", "Biology", 4);
    Course course2 = new Course("C005", "History", 3);
    Course course3 = new Course("C006", "Geography", 3);

    // Add courses to university
    university.addCourse(course1);
    university.addCourse(course2);
    university.addCourse(course3);

    // Create 3 teachers
    Teacher teacher1 = new Teacher("T003", "Alice", "alice@example.com", "06-06-1980", "Biology");
    Teacher teacher2 = new Teacher("T004", "Bob", "bob@example.com", "07-07-1981", "History");
    Teacher teacher3 = new Teacher("T005", "Carol", "carol@example.com", "08-08-1982", "Geography");

    // Add teachers to university
    university.addTeacher(teacher1);
    university.addTeacher(teacher2);
    university.addTeacher(teacher3);

    // Assign teachers to courses
    course1.setAssignedTeacher(teacher1);
    course2.setAssignedTeacher(teacher2);
    course3.setAssignedTeacher(teacher3);

    // Enroll students in courses
    course1.addStudent(student1);
    course1.addStudent(student2);
    course2.addStudent(student2);
    course2.addStudent(student3);
    course3.addStudent(student1);
    course3.addStudent(student3);

    // Create 3 administrative staff
    AdministrativeStaff admin1 = new AdministrativeStaff("A001", "Frank", "frank@example.com", "09-09-1970", "Registrar", "Administration");
    AdministrativeStaff admin2 = new AdministrativeStaff("A002", "Grace", "grace@example.com", "10-10-1971", "Accountant", "Finance");
    AdministrativeStaff admin3 = new AdministrativeStaff("A003", "Hank", "hank@example.com", "11-11-1972", "Librarian", "Library");

    // Add administrative staff to university
    university.addAdminstaff(admin1);
    university.addAdminstaff(admin2);
    university.addAdminstaff(admin3);

    // Save updated data back to files
    university.saveData("data.txt");

    // Display system stats
    university.displaySystemStats();


    }
}
