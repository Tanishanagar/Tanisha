import java.awt.*;
import java.awt.event.*;

public class crtproject {
    private Frame mainFrame;
    private TextField usernameField;
    private TextField passwordField;
    private Label messageLabel;

    public crtproject() {
        prepareGUI();
    }

    public static void main(String[] args) {
        crtproject crtproject  = new crtproject();
        crtproject.showLoginForm();
    }

    private void prepareGUI() {
        mainFrame = new Frame("Login and Logout Example");
        mainFrame.setSize(300, 200);
        mainFrame.setLayout(new GridLayout(4, 2));
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        messageLabel = new Label();
        usernameField = new TextField();
        passwordField = new TextField();
        passwordField.setEchoChar('*');

        mainFrame.add(new Label("Username:"));
        mainFrame.add(usernameField);
        mainFrame.add(new Label("Password:"));
        mainFrame.add(passwordField);
        mainFrame.add(messageLabel);
    }

    private void showLoginForm() {
        Button loginButton = new Button("Login");
        Button logoutButton = new Button("Logout");
        logoutButton.setEnabled(false); // Disable logout initially

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = passwordField.getText();
                
                if (username.equals("user") && password.equals("pass")) { // Sample credentials
                    messageLabel.setText("Login successful!");
                    loginButton.setEnabled(false);
                    logoutButton.setEnabled(true);
                } else {
                    messageLabel.setText("Invalid credentials!");
                }
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                messageLabel.setText("Logged out.");
                usernameField.setText("");
                passwordField.setText("");
                loginButton.setEnabled(true);
                logoutButton.setEnabled(false);
            }
        });

        mainFrame.add(loginButton);
        mainFrame.add(logoutButton);
        mainFrame.setVisible(true);
    }
}
