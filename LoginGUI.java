import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null); 
        frame.setLayout(new BorderLayout());
        frame.setResizable(false); 

        frame.getContentPane().setBackground(Color.decode("#F0EBD8"));
        // line to add hex color to background
        

        JLabel welcomeLabel = new JLabel("<html>Welcome to Student Management<br><center>System</center></html>", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeLabel.setForeground(Color.decode("#1D2D44"));
        frame.add(welcomeLabel, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setOpaque(false); 
        frame.add(panel, BorderLayout.CENTER);

        JLabel userLabel = new JLabel("User:");
        userLabel.setBounds(50, 60, 100, 30);
        userLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        userText.setBounds(160, 60, 250, 30);
        userText.setFont(new Font("Arial", Font.PLAIN, 20));
        userText.setText("Enter username");
        userText.setForeground(Color.GRAY);
        userText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (userText.getText().equals("Enter username")) {
                    userText.setText("");
                    userText.setForeground(Color.BLACK);
                }
            }            
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (userText.getText().isEmpty()) {
                    userText.setForeground(Color.GRAY);
                    userText.setText("Enter username");
                }
            }
        });
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 110, 100, 30);
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        passwordText.setBounds(160, 110, 250, 30);
        passwordText.setFont(new Font("Arial", Font.PLAIN, 20));
        passwordText.setEchoChar((char) 0);
        passwordText.setText("Enter password");
        passwordText.setForeground(Color.GRAY);
        passwordText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (String.valueOf(passwordText.getPassword()).equals("Enter password")) {
                    passwordText.setText("");
                    passwordText.setEchoChar('•');
                    passwordText.setForeground(Color.BLACK);
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (String.valueOf(passwordText.getPassword()).isEmpty()) {
                    passwordText.setForeground(Color.GRAY);
                    passwordText.setEchoChar((char) 0);
                    passwordText.setText("Enter password");
                }
            }
        });
        panel.add(passwordText);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(200, 160, 100, 40);
        loginButton.setBackground(Color.decode("#3E5C76"));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Arial", Font.BOLD, 18));
        loginButton.setFocusPainted(false);
        loginButton.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());
                if ("admin".equals(username) && "12345".equals(password)) {
                    frame.dispose();
                    new page();
                } else {
                    UIManager.put("Button.focus", new Color(0, 0, 0, 0));
                    JOptionPane.showMessageDialog(null, "Invalid username or password", "Message", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        frame.setVisible(true);
    }
}
