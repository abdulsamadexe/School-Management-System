import java.util.List;

public class SchoolManagementSystem {
    public static void main(String[] args) {
        University university = new University();
        university.loadData("data.txt");


        university.saveData("data.txt");
        }
    }
