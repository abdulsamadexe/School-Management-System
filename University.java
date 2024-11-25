import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;
public class University {
    private static int totalStudents = 0;
    private static int totalTeachers = 0;
    private static int totalCourses = 0;

    private List<Student> students;
    private List<Teacher> teachers;
    private List<Course> courses;

    public University() {
        students = new ArrayList<>();
        teachers = new ArrayList<>();
        courses = new ArrayList<>();
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
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                result.add(student);
            }
        }
        return result;
    }

    public List<Course> filterCoursesByCredits(int minCredits) {
        List<Course> result = new ArrayList<>();
        for (Course course : courses) {
            if (course.getCredits() >= minCredits) {
                result.add(course);
            }
        }
        return result;
    }

    public void loadData(String filename) {
        try{
            FileReader fr=new FileReader("Univeristy_data.txt");
            Scanner sc=new Scanner(fr);
            while(sc.hasNext()){
                totalStudents=sc.nextInt();
                totalTeachers=sc.nextInt();
                totalCourses=sc.nextInt();
            }
            sc.close();
            fr.close();
        }catch(Exception e){System.out.println(e);}

        try{
            FileReader fr=new FileReader("Student_data.txt");
            Scanner sc=new Scanner(fr);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] data = line.split(",");
                String name = data[0];
                String email = data[1];
                String dateOfBirth = data[2];
                String studentID = data[3];
                String address = data[4];
                Student student = new Student(studentID, name, email, dateOfBirth, address);
                students.add(student);
            }
            sc.close(); 
            fr.close();
            
        }catch(Exception e){System.out.println(e);}

        try{
            FileReader fr1=new FileReader("Teacher_data.txt");
            Scanner sc1=new Scanner(fr1);
            while(sc1.hasNext()){
                String name=sc1.next();
                String email=sc1.next();
                String dateOfBirth=sc1.next();
                String teacherID=sc1.next();
                String specialization=sc1.next();
                Teacher teacher=new Teacher(teacherID,name,email,dateOfBirth,specialization);
                teachers.add(teacher);
            }
            sc1.close();
            fr1.close();
        }catch(Exception e){System.out.println(e);}

        try{
            FileReader fr2=new FileReader("Course_data.txt");
            Scanner sc2=new Scanner(fr2);
            while(sc2.hasNext()){
                String title=sc2.next();
                int credits=sc2.nextInt();
                String courseID=sc2.next();
                Course course=new Course(courseID,title,credits);
                courses.add(course);
            }
            fr2.close();
            sc2.close();
        }catch(Exception e){System.out.println(e);}
        
    }


    public void saveData(String filename) {
        try{
            try{
                FileWriter fw=new FileWriter("Univeristy_data.txt");
                fw.write(totalStudents+" ");
                fw.write(totalTeachers+" ");
                fw.write(totalCourses+" ");
                fw.close();
            }catch(Exception e){System.out.println(e);
            }

            try{
                FileWriter fw=new FileWriter("Student_data.txt");
                for(Student student:students){
                    fw.write(student.getName()+" "+student.getEmail()+" "+student.getDateOfBirth()+" "+student.getStudentID()+" "+student.getAddress()+"\n");
                }
                fw.close();

            }catch(Exception e){System.out.println(e);}

            try{
                FileWriter fw1=new FileWriter("Teacher_data.txt");
                for(Teacher teacher:teachers){
                    fw1.write(teacher.getName()+" "+teacher.getEmail()+" "+teacher.getDateOfBirth()+" "+teacher.getTeacherID()+" "+teacher.getSpecialization()+"\n");
                }
                fw1.close();
            }catch(Exception e){System.out.println(e);}

            try{
                FileWriter fw2=new FileWriter("Course_data.txt");
                for(Course course:courses){
                    fw2.write(course.getTitle()+" "+course.getCredits()+" "+course.getCourseID()+"\n");
                }

                fw2.close();
            }catch(Exception e){System.out.println(e);}


                
        }catch(Exception e){System.out.println(e);}
}}