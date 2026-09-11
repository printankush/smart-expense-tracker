import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPage extends JFrame {

    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JButton btnExit;

    public LoginPage() {

        setTitle("Smart Expense Tracker - Login");
        setSize(520, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(null);

        // Light Blue Background
        getContentPane().setBackground(new Color(230, 240, 255));

        // =========================
        // Title
        // =========================
        JLabel title = new JLabel("SMART EXPENSE TRACKER");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setForeground(new Color(25, 60, 120));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBounds(30, 25, 450, 40);
        add(title);

        // =========================
        // Subtitle
        // =========================
        JLabel subtitle = new JLabel("Manage Your Daily Expenses Efficiently");
        subtitle.setFont(new Font("Arial", Font.ITALIC, 15));
        subtitle.setForeground(Color.GRAY);
        subtitle.setHorizontalAlignment(SwingConstants.CENTER);
        subtitle.setBounds(50, 65, 410, 25);
        add(subtitle);

        // =========================
        // Welcome
        // =========================
        JLabel welcome = new JLabel("Welcome! Please Login");
        welcome.setFont(new Font("Arial", Font.BOLD, 18));
        welcome.setForeground(new Color(70, 70, 70));
        welcome.setHorizontalAlignment(SwingConstants.CENTER);
        welcome.setBounds(90, 105, 320, 25);
        add(welcome);

        // =========================
        // Username
        // =========================
        JLabel lblUser = new JLabel("Username");
        lblUser.setFont(new Font("Arial", Font.BOLD, 15));
        lblUser.setBounds(60, 165, 100, 25);
        add(lblUser);

        txtUsername = new JTextField();
        txtUsername.setBounds(170, 160, 260, 35);
        txtUsername.setFont(new Font("Arial", Font.PLAIN, 15));
        add(txtUsername);

        // =========================
        // Password
        // =========================
        JLabel lblPass = new JLabel("Password");
        lblPass.setFont(new Font("Arial", Font.BOLD, 15));
        lblPass.setBounds(60, 225, 100, 25);
        add(lblPass);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(170, 220, 260, 35);
        txtPassword.setFont(new Font("Arial", Font.PLAIN, 15));
        add(txtPassword);

        // =========================
        // Login Button
        // =========================
        btnLogin = new JButton("Login");
        btnLogin.setBounds(90, 310, 150, 45);
        btnLogin.setBackground(new Color(52, 152, 219));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFocusPainted(false);
        btnLogin.setFont(new Font("Arial", Font.BOLD, 15));
        add(btnLogin);

        // =========================
        // Exit Button
        // =========================
        btnExit = new JButton("Exit");
        btnExit.setBounds(270, 310, 150, 45);
        btnExit.setBackground(new Color(231, 76, 60));
        btnExit.setForeground(Color.WHITE);
        btnExit.setFocusPainted(false);
        btnExit.setFont(new Font("Arial", Font.BOLD, 15));
        add(btnExit);
        // =========================
        // Login Action
        // =========================
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String user = txtUsername.getText().trim();
                String pass = String.valueOf(txtPassword.getPassword());

                if (user.isEmpty() || pass.isEmpty()) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Please enter Username and Password."
                    );
                    return;
                }

                if (user.equals("admin") && pass.equals("1234")) {

                    dispose();
                    new Dashboard();

                } else {

                    JOptionPane.showMessageDialog(
                            null,
                            "Invalid Username or Password"
                    );
                }
            }
        });

        // Press Enter to Login
        txtPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnLogin.doClick();
            }
        });

        // Exit Action
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }
}