package UI;

import DatabaseHandler.Connect;
import Model.LoginUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginPage extends JFrame {
    private JTextField LP_userName;
    private JPanel LP_panel;
    private JPanel LP_componentsPanel;
    private JPasswordField LP_password;
    private JComboBox LP_employee_status_box;
    private JButton LP_SignIn;
    private JButton forgotMyPassword;

    public static final int HEIGHT = 700;
    public static final int WIDTH = 1000;
    public LoginPage() {
        // Let's make our JFrame

        setTitle("Login");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //Let's add an icon for this frame
        ImageIcon EGA_icon = new ImageIcon("src/Images/logistics.png");
        setIconImage(EGA_icon.getImage());

        //Adding the panel of Login Page in this Frame
        add(LP_panel);

        //Setting actions for ForgotMyPasswod Button
        forgotMyPassword.addActionListener(this::forgotMyPasswordAction);

        //seeting actions for the signIN button
        LP_SignIn.addActionListener(this::signInAction);

        LP_panel.setBackground(new Color(46, 250, 255));
        LP_componentsPanel.setBackground(new Color(2, 2, 16,20));
        setVisible(true);
    }

    //Let's write the method which define the action for username and password
    public void signInAction(ActionEvent event)
    {
        LoginUser lu = new LoginUser(LP_userName.getText().toString(), LP_password.getPassword().toString());
        Connect con = new Connect();
        con.userAuthentication(lu);
    }
    //Let's write the functionality of forgot my password account in a seperate method
    public void forgotMyPasswordAction(ActionEvent event)
    {
        ForgotPass dialog = new ForgotPass();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

}
