import java.io.*;
import java.util.*;
public class University {
    private static int totalStudents = 0;
    private static int totalTeachers = 0;
    private static int totalCourses = 0;
    private static int totaladministrativestaff=0;

    private Repository<Student> students;
    private Repository<Teacher> teachers;
    private Repository<Course> courses;
    private Repository<AdministrativeStaff> adminstaff;

    public University() {
        students = new Repository<>();
        teachers = new Repository<>();
        courses = new Repository<>(); 
        adminstaff=new Repository<>();    
    }

    public void addStudent(Student student) {
        students.add(student);
        totalStudents++;
    }

    public void addAdminstaff(AdministrativeStaff s){
        adminstaff.add(s);
        totaladministrativestaff++;
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
        try (Scanner scanner = new Scanner(new File("Course_data.txt"))) {
            Course currentCourse = null;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) {
                    continue;
                }
                String[] parts = line.split(" ");
                if (parts[0].startsWith("C")) {
                    String courseID = parts[0];
                    String title = parts[1];
                    int credits = Integer.parseInt(parts[2]);
                    currentCourse = new Course(courseID, title, credits);
                    addCourse(currentCourse);
                } else if (parts[0].startsWith("T")) {
                    String teacherID = parts[0];
                    String name = parts[1];
                    String email = parts[2];
                    String dateOfBirth = parts[3];
                    String specialization = parts[4];
                    Teacher teacher = new Teacher(teacherID, name, email, dateOfBirth, specialization);
                    if (currentCourse != null) {
                        currentCourse.setAssignedTeacher(teacher);
                    }
                } else if (parts[0].startsWith("S")) {
                    String studentID = parts[0];
                    String name = parts[1];
                    String email = parts[2];
                    String dateOfBirth = parts[3];
                    String address = parts[4];
                    Student student = new Student(studentID, name, email, dateOfBirth, address);
                    if (currentCourse != null) {
                        currentCourse.addStudent(student);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }



        try (Scanner scanner = new Scanner(new File("Student_data.txt"))) {
            while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] parts = line.split(" ");
            String studentID = parts[0];
            String name = parts[1];
            String email = parts[2];
            String dateOfBirth = parts[3];
            String address = parts[4];
            Student student = new Student(studentID, name, email, dateOfBirth, address);
            addStudent(student);

            while (scanner.hasNextLine()) {
                String courseLine = scanner.nextLine().trim();
                if (courseLine.isEmpty()) {
                    break;
                }
                String[] courseParts = courseLine.split(" ");
                String courseID = courseParts[0];
                String title = courseParts[1];
                int credits = Integer.parseInt(courseParts[2]);
                Course course = null;
                for (Course c : courses.getAll()) {
                    if (c.getCourseID().equals(courseID)) {
                        course = c;
                        break;
                    }
                }
                if (course == null) {
                    course = new Course(courseID, title, credits);
                    addCourse(course);
                }
                student.enrollInCourse(course);
            }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
        

        try (Scanner scanner = new Scanner(new File("Teacher_data.txt"))) {
            while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] parts = line.split(" ");
            String teacherID = parts[0];
            String name = parts[1];
            String email = parts[2];
            String dateOfBirth = parts[3];
            String specialization = parts[4];
            Teacher teacher = new Teacher(teacherID, name, email, dateOfBirth, specialization);
            addTeacher(teacher);
            while (scanner.hasNextLine()) {
                String courseLine = scanner.nextLine().trim();
                if (courseLine.isEmpty()) {
                    break;
                }
                String[] courseParts = courseLine.split(" ");
                String courseID = courseParts[0];
                String title = courseParts[1];
                int credits = Integer.parseInt(courseParts[2]);
                Course course = null;
                for (Course c : courses.getAll()) {
                    if (c.getCourseID().equals(courseID)) {
                        course = c;
                        break;
                    }
                }
                if (course == null) {
                    course = new Course(courseID, title, credits);
                    addCourse(course);
                }
                teacher.assignCourse(course);
            }
         }
        }catch (FileNotFoundException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }

    
        try (Scanner sc = new Scanner(new File("University_data.txt"))) {
            totalStudents = Integer.parseInt(sc.nextLine());
            totalTeachers = Integer.parseInt(sc.nextLine());
            totalCourses = Integer.parseInt(sc.nextLine());
            totaladministrativestaff = Integer.parseInt(sc.nextLine());
        } catch (FileNotFoundException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing number from file: " + e.getMessage());
        }

        try (Scanner scanner = new Scanner(new File("AdministrativeStaff.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) {
                    continue;
                }
                String[] parts = line.split(" ");
                String staffID = parts[0];
                String name = parts[1];
                String email = parts[2];
                String dateOfBirth = parts[3];
                String role = parts[4];
                String department = parts[5];
                AdministrativeStaff staff = new AdministrativeStaff(staffID, name, email, dateOfBirth, role, department);
                addAdminstaff(staff);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
        public void saveData(String filename) {
            try {
                PrintWriter writer = new PrintWriter(new FileWriter("Course_data.txt", false));
                for (Course course : courses.getAll()) {
                    writer.print(course.getCourseID() + " ");
                    writer.print(course.getTitle() + " ");
                    writer.println(course.getCredits() + "");
                    Teacher assignedTeacher = course.getAssignedTeacher();
                    if (assignedTeacher != null) {
                        writer.print(assignedTeacher.getTeacherID() + " ");
                        writer.print(assignedTeacher.getName() + " ");
                        writer.print(assignedTeacher.getEmail() + " ");
                        writer.print(assignedTeacher.getDateOfBirth() + " ");
                        writer.println(assignedTeacher.getSpecialization() + " ");
                    } else {
                        writer.println("null");
                    }
                    List<Student> enrolledStudents = course.getEnrolledStudents();
                    for (Student student : enrolledStudents) {
                        writer.print(student.getStudentID() + " ");
                        writer.print(student.getName() + " ");
                        writer.print(student.getEmail() + " ");
                        writer.print(student.getDateOfBirth() + " ");
                        writer.println(student.getAddress() + " ");
                    }
                    List<Integer> grades = course.getGrades();
                    for (Integer grade : grades) {
                        if (grade != null) {
                            writer.print(grade + " ");
                        } else {
                            writer.print("null" + " ");
                        }
                    }
                    writer.println("\n");
                }
                writer.close();
            } catch (IOException e) {
                System.out.println("Error writing to file");
            }

            try {
                PrintWriter writer = new PrintWriter(new FileWriter("Teacher_data.txt", false));
                for (Teacher teacher : teachers.getAll()) {
                    writer.print(teacher.getTeacherID() + " ");
                    writer.print(teacher.getName() + " ");
                    writer.print(teacher.getEmail() + " ");
                    writer.print(teacher.getDateOfBirth() + " ");
                    writer.println(teacher.getSpecialization() + " ");

                    List<Course> coursesTaught = teacher.getCoursesTaught();
                    for (Course course : coursesTaught) {
                        writer.print(course.getCourseID() + " ");
                        writer.print(course.getTitle() + " ");
                        writer.println(course.getCredits() + " ");
                    }

                    writer.println("\n");
                }
                writer.close();
            } catch (IOException e) {
                System.out.println("Error writing to file");
            }

            try {
                PrintWriter writer = new PrintWriter(new FileWriter("Student_data.txt", false));
                for (Student student : students.getAll()) {
                    writer.print(student.getStudentID() + " ");
                    writer.print(student.getName() + " ");
                    writer.print(student.getEmail() + " ");
                    writer.print(student.getDateOfBirth() + " ");
                    writer.println(student.getAddress() + " ");
                    List<Course> enrolledCourses = student.getEnrolledCourses();
                    for (Course course : enrolledCourses) {
                        writer.print(course.getCourseID() + " ");
                        writer.print(course.getTitle() + " ");
                        writer.println(course.getCredits() + " ");
                    }
                    writer.println("\n");
                }
                writer.close();
            } catch (IOException e) {
                System.out.println("Error writing to file");
            }

            try {
                PrintWriter writer = new PrintWriter(new FileWriter("University_data.txt", false));
                writer.println(totalStudents);
                writer.println(totalTeachers);
                writer.println(totalCourses);
                writer.println(totaladministrativestaff);
                writer.close();
            } catch (IOException e) {
                System.out.println("Error writing to file");
            }

            try {
                PrintWriter writer = new PrintWriter(new FileWriter("Administrative_staff.txt", false));
                for (AdministrativeStaff staff : adminstaff.getAll()) {
                    writer.print(staff.getStaffID() + " ");
                    writer.print(staff.getName() + " ");
                    writer.print(staff.getEmail() + " ");
                    writer.print(staff.getDateOfBirth() + " ");
                    writer.print(staff.getRole() + " ");
                    writer.println(staff.getDepartment() + " ");
                }
                writer.close();
            } catch (IOException e) {
                System.out.println("Error writing to file: " + e.getMessage());
            }
        }
    }
