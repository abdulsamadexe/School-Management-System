public class SchoolManagementSystem {
    public static void main(String[] args) {
        University university = new University();
        // Load existing data from files
        university.loadData("data.txt");

        // Print loaded students
        System.out.println("Loaded Students:");

        // Print loaded teachers
        System.out.println("Loaded Teachers:");
        for (Teacher teacher : university.getTeachers()) {
            System.out.println(teacher.displayDetails());
        }

        // Print loaded administrative staff
        System.out.println("Loaded Administrative Staff:");
        for (AdministrativeStaff staff : university.getAllAdministrativeStaff()) {
            System.out.println(staff.displayDetails());
        }

        // Print loaded courses
        System.out.println("Loaded Courses:");
        for (Course course : university.getCourses()) {
            System.out.println(course.getCourseID() + " - " + course.getTitle() + " (" + course.getCredits() + " credits)");
            if (course.getAssignedTeacher() != null) {
                System.out.println("  Taught by: " + course.getAssignedTeacher().getName());
            }
            System.out.println("  Enrolled Students:");
            for (Student student : course.getEnrolledStudents()) {
                System.out.println("    " + student.getName());
            }
        }




        // Save updated data back to files
        university.saveData("data.txt");

        // Display system stats
        university.displaySystemStats();


        }
    }
