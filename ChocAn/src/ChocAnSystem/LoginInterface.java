package ChocAnSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * Login Interface Class. Creates the GUI and interface that all users will see.
 * Creates an instance of the credentials class and calls that to implement the functionality of verification.
 * 
 * @author Ben Geary
 * @version 1.0
 * 
 */
public class LoginInterface implements ActionListener{

    private JFrame frameLogin;
    private JPanel panelLogin;
    private JLabel labelLogin;
    private JLabel labelUsername;
    private JLabel labelPassword;
    private JButton buttonLogin;
    private JTextField tfUsername;
    private JPasswordField pfPassword;
    private Credentials tempList = new Credentials();

    /**
     * Constructor. Creates an instance of the Login Interface class with all components and panels.
     * 
     * @author Ben Geary
     * 
     */
    public LoginInterface(){
    	
    	
    	//TEST DUMMY CREDENTIALS. NEEDS TO BE REMOVED AFTER TESTING
//        tempList.addValidUser("manager", "manager1", "123");
//        tempList.addValidUser("provider", "provider1", "123");
//        tempList.addValidUser("manager", "manager2", "123");
//        tempList.addValidUser("provider", "provider2", "123");
//        tempList.addValidUser("operator", "operator1", "123");
//        tempList.addValidUser("operator", "operator2", "123");

        panelLogin = new JPanel();
        panelLogin.setLayout(null);

        labelLogin = new JLabel("Login Menu");
        labelLogin.setFont(new Font("Times New Roman",Font.BOLD, 40));
        labelLogin.setBounds(300,70,300,100);
        labelLogin.setForeground(new Color(27, 75, 131));

        labelUsername = new JLabel("Username:");
        labelUsername.setFont(new Font("Times New Roman",Font.BOLD, 20));
        labelUsername.setBounds(150, 150, 150, 40);
        labelUsername.setForeground(new Color(0,0,0));

        labelPassword = new JLabel("Password:");
        labelPassword.setFont(new Font("Times New Roman",Font.BOLD, 20));
        labelPassword.setBounds(150, 200, 150,40 );
        labelPassword.setForeground(new Color(0,0,0));

        tfUsername = new JTextField(20);
        tfUsername.setBounds(250,162,190,20);

        buttonLogin = new JButton("Login");
        buttonLogin.setBounds(300, 260, 180, 40);
        buttonLogin.addActionListener(this);

        pfPassword = new JPasswordField(20);
        pfPassword.setBounds(250, 210, 190, 20);



        panelLogin.add(labelPassword);
        panelLogin.add(labelLogin);
        panelLogin.add(labelUsername);
        panelLogin.add(tfUsername);
        panelLogin.add(pfPassword);
        panelLogin.add(buttonLogin);

        frameLogin = new JFrame();
        frameLogin.setSize(800,500);
        frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameLogin.setLocationRelativeTo(null);
        frameLogin.getContentPane().setBackground(new Color(112, 112, 112));
        frameLogin.setResizable(false);
        frameLogin.add(panelLogin);
        frameLogin.setVisible(true);





    }

    /**
     * The primary driver of the login interface. Takes the input from the user and calls the credential class to validate
     * the login info. Uses ActionListener to get the button clicks and then checks what the user typed in
     * 
     * @author Ben Geary
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonLogin){
        	
        	//AWARE THAT GETTEXT FOR PASSWORD FIELDS IS DEPRECATED. POSSIBLE SECURITY ISSUE
            String username = tfUsername.getText();
            String password = pfPassword.getText();

            String validity = tempList.verifyCreds(username,password);
            if (!Objects.equals(validity, "")){
                if(Objects.equals(validity, "operator")){
                    OperatorInterface opInterface = new OperatorInterface();
                    frameLogin.dispose();
                }
                else if (Objects.equals(validity, "manager")) {
                    ManagerInterface manInterface = new ManagerInterface();
                    frameLogin.dispose();
                }
                else if (Objects.equals(validity, "provider")) {
                    ProviderInterface proInterface = new ProviderInterface();
                    frameLogin.dispose();
                }
                else{
                    tfUsername.setText("FUCKED UP");
                    pfPassword.setText("");
                }
            }
            else {
                tfUsername.setText("Invalid Username or Password");
                pfPassword.setText("");

            }

        }
    }

}

