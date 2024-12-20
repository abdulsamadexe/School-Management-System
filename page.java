import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class page {
    private JFrame frame;
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private JLabel headerLabel;

    public page() {
        frame = new JFrame("Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600); 
        frame.setLocationRelativeTo(null); 

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout); 

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.decode("#F0EBD8"));
        headerLabel = new JLabel("Add Course");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 30)); 
        headerLabel.setForeground(Color.decode("#1D2D44"));
        headerPanel.add(headerLabel);

        frame.add(headerPanel, BorderLayout.NORTH);

        mainPanel.add(createFormPanel(new String[]{"Course Title", "Course ID", "Course Credits"}, new String[]{"string", "courseId", "int"}), "AddCourse");
        mainPanel.add(createFormPanel(new String[]{"Teacher Name", "Course ID"}, new String[]{"string", "courseId"}), "AssignTeacherToCourse");
        mainPanel.add(createFormPanel(new String[]{"Student Name", "Course ID"}, new String[]{"string", "courseId"}), "EnrollStudentInCourse");
        mainPanel.add(createFormPanel(new String[]{"Student Name", "Course ID"}, new String[]{"string", "courseId"}), "RemoveStudentFromCourse");
        mainPanel.add(createFormPanel(new String[]{"Course ID"}, new String[]{"courseId"}), "CalculateAverageGrade");
        mainPanel.add(createFormPanel(new String[]{"Teacher Name", "Email", "DOB", "Teacher ID", "Specialization"}, new String[]{"string", "email", "dob", "teacherId", "string"}), "AddTeacher");
        mainPanel.add(createFormPanel(new String[]{"Teacher Name", "Course ID"}, new String[]{"string", "courseId"}), "AssignCourseToTeacher");
        mainPanel.add(createFormPanel(new String[]{"Student Name", "Email", "DOB", "Student ID", "Address"}, new String[]{"string", "email", "dob", "studentId", "string"}), "AddStudent");
        mainPanel.add(createFormPanel(new String[]{"Student Name", "Grade"}, new String[]{"string", "int"}), "AssignGradeToStudent");

        frame.add(mainPanel, BorderLayout.CENTER);

        createMenuBar(frame);

        frame.setVisible(true);
    }

    private JPanel createFormPanel(String[] labels, String[] types) {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.decode("#F0EBD8")); 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 10, 15, 10); 

        Font labelFont = new Font("Arial", Font.PLAIN, 20);

        JTextField[] textFields = new JTextField[labels.length];

        for (int i = 0; i < labels.length; i++) {
            JLabel label = new JLabel(labels[i] + ":");
            label.setFont(labelFont);
            label.setForeground(Color.decode("#0D1321")); 
            JTextField textField = new JTextField(15); 
            textField.setPreferredSize(new Dimension(150, 30)); 
            textFields[i] = textField;

            gbc.gridx = 0;
            gbc.gridy = i;
            gbc.anchor = GridBagConstraints.WEST;
            panel.add(label, gbc);

            gbc.gridx = 1;
            gbc.gridy = i;
            gbc.anchor = GridBagConstraints.WEST;
            panel.add(textField, gbc);
        }

        gbc.gridx = 0;
        gbc.gridy = labels.length;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 20)); 
        submitButton.setBackground(Color.decode("#1D2D44")); 
        submitButton.setForeground(Color.WHITE); 
        panel.add(submitButton, gbc);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean valid = true;
                StringBuilder inputData = new StringBuilder();
                for (int i = 0; i < labels.length; i++) {
                    String input = textFields[i].getText().trim();
                    if (input.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, labels[i] + " cannot be empty", "Input Error", JOptionPane.ERROR_MESSAGE);
                        valid = false;
                        break;
                    }
                    if (!validateInput(input, types[i])) {
                        JOptionPane.showMessageDialog(frame, "Invalid input for " + labels[i], "Input Error", JOptionPane.ERROR_MESSAGE);
                        valid = false;
                        break;
                    }
                    inputData.append(labels[i]).append(": ").append(input).append("\n");
                }
                if (valid) {
                    System.out.println(inputData.toString());
                }
            }
        });

        return panel;
    }

    private boolean validateInput(String input, String type) {
        switch (type) {
            case "courseId":
            return input.matches("^C\\d+");  
            case "studentId":
                return input.matches("^S\\d+"); 
            case "teacherId":
                return input.matches("^T\\d+"); 
            case "email":
                return input.matches(".*@gmail.com$");
            case "dob":
                return input.matches("^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-(\\d{4})$");
            case "int":
                return input.matches("\\d+"); 
            case "string":
                return input.matches("[a-zA-Z ]+"); 
            default:
                return false;
        }
    }

    private void createMenuBar(JFrame frame) {
        JMenuBar menuBar = new JMenuBar();

        JMenu courseMenu = new JMenu("Course");
        courseMenu.setFont(new Font("Arial", Font.PLAIN, 20)); 
        JMenuItem addCourse = new JMenuItem("Add Course");
        JMenuItem assignTeacherToCourse = new JMenuItem("Assign Teacher to Course");
        JMenuItem enrollStudentInCourse = new JMenuItem("Enroll Student in Course");
        JMenuItem removeStudentFromCourse = new JMenuItem("Remove Student from Course");
        JMenuItem calculateAverageGrade = new JMenuItem("Calculate Average Grade");

        addCourse.setFont(new Font("Arial", Font.PLAIN, 20)); 
        assignTeacherToCourse.setFont(new Font("Arial", Font.PLAIN, 20)); 
        enrollStudentInCourse.setFont(new Font("Arial", Font.PLAIN, 20)); 
        removeStudentFromCourse.setFont(new Font("Arial", Font.PLAIN, 20)); 
        calculateAverageGrade.setFont(new Font("Arial", Font.PLAIN, 20)); 

        courseMenu.add(addCourse);
        courseMenu.add(assignTeacherToCourse);
        courseMenu.add(enrollStudentInCourse);
        courseMenu.add(removeStudentFromCourse);
        courseMenu.add(calculateAverageGrade);

        JMenu teacherMenu = new JMenu("Teacher");
        teacherMenu.setFont(new Font("Arial", Font.PLAIN, 20)); 
        JMenuItem addTeacher = new JMenuItem("Add Teacher");
        JMenuItem assignCourseToTeacher = new JMenuItem("Assign Course to Teacher");

        addTeacher.setFont(new Font("Arial", Font.PLAIN, 20)); 
        assignCourseToTeacher.setFont(new Font("Arial", Font.PLAIN, 20)); 

        teacherMenu.add(addTeacher);
        teacherMenu.add(assignCourseToTeacher);

        JMenu studentMenu = new JMenu("Student");
        studentMenu.setFont(new Font("Arial", Font.PLAIN, 20)); 
        JMenuItem addStudent = new JMenuItem("Add Student");
        JMenuItem assignGradeToStudent = new JMenuItem("Assign Grade to Student");

        addStudent.setFont(new Font("Arial", Font.PLAIN, 20)); 
        assignGradeToStudent.setFont(new Font("Arial", Font.PLAIN, 20)); 

        studentMenu.add(addStudent);
        studentMenu.add(assignGradeToStudent);

        menuBar.add(courseMenu);
        menuBar.add(teacherMenu);
        menuBar.add(studentMenu);

        frame.setJMenuBar(menuBar);

        addCourse.addActionListener(e -> {
            showPanel("AddCourse", "Add Course");
        });
        assignTeacherToCourse.addActionListener(e -> {
            showPanel("AssignTeacherToCourse", "Assign Teacher to Course");
        });
        enrollStudentInCourse.addActionListener(e -> {
            showPanel("EnrollStudentInCourse", "Enroll Student in Course");
        });
        removeStudentFromCourse.addActionListener(e -> {
            showPanel("RemoveStudentFromCourse", "Remove Student from Course");
        });
        calculateAverageGrade.addActionListener(e -> {
            showPanel("CalculateAverageGrade", "Calculate Average Grade");
        });
        addTeacher.addActionListener(e -> {
            showPanel("AddTeacher", "Add Teacher");
        });
        assignCourseToTeacher.addActionListener(e -> {
            showPanel("AssignCourseToTeacher", "Assign Course to Teacher");
        });
        addStudent.addActionListener(e -> {
            showPanel("AddStudent", "Add Student");
        });
        assignGradeToStudent.addActionListener(e -> {
            showPanel("AssignGradeToStudent", "Assign Grade to Student");
        });
    }

    private void showPanel(String panelName, String labelText) {
        cardLayout.show(mainPanel, panelName);
        headerLabel.setText(labelText);
    }

    // public static void main(String[] args) {
    //     new page();
    // }
}
