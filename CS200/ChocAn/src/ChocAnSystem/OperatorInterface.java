package ChocAnSystem;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Operator Interface Class. Creates the GUI and interface that the operator will see.
 * Creates an instance of the operator controller class and calls that to implement the functionality of user tasks.
 * 
 * @author Ben Geary
 * @version 1.0
 *
 */
public class OperatorInterface implements ActionListener {
    private JFrame frameOperator;
    private JPanel panelOptions;
    private JLabel labelOperator;
    private JButton buttonLogout;
    private JButton buttonMemAdd, buttonMemDel, buttonMemUpdate, buttonProAdd, buttonProDel, buttonProUpdate;
    private JLabel labelInputMemNameAdd, labelInputMemAddressAdd, labelInputMemCityAdd, labelInputMemStateAdd,labelInputMemZipAdd, labelInputMemIDAdd, labelInputStatusMemAdd;
    private JLabel labelInputProNameAdd, labelInputProAddressAdd, labelInputProCityAdd, labelInputProStateAdd,labelInputProZipAdd, labelInputProIDAdd, labelInputStatusProAdd;
    private JLabel labelInputMemIDDel, labelInputProIDDel;
    private JLabel labelInputMemNameUpdate, labelInputMemAddressUpdate, labelInputMemCityUpdate, labelInputMemStateUpdate,labelInputMemZipUpdate, labelInputMemIDUpdate, labelStatusMemUpdate;
    private JLabel labelInputProNameUpdate, labelInputProAddressUpdate, labelInputProCityUpdate, labelInputProStateUpdate,labelInputProZipUpdate, labelInputProIDUpdate, labelStatusProUpdate;
    private JLabel labelAddMem, labelDelMem, labelUpdateMem, labelAddPro, labelDelPro, labelUpdatePro;
    private JTextField tfMemNameAdd, tfMemAddressAdd, tfMemCityAdd, tfMemStateAdd, tfMemZipAdd, tfMemIDAdd, tfMemStatusAdd;
    private JTextField tfProNameAdd, tfProAddressAdd, tfProCityAdd, tfProStateAdd, tfProZipAdd, tfProIDAdd, tfProStatusAdd;
    private JTextField tfMemNameUpdate, tfMemAddressUpdate, tfMemCityUpdate, tfMemStateUpdate, tfMemZipUpdate, tfMemIDUpdate, tfMemStatusUpdate;
    private JTextField tfProNameUpdate, tfProAddressUpdate, tfProCityUpdate, tfProStateUpdate, tfProZipUpdate, tfProIDUpdate, tfProStatusUpdate;
    private JTextField tfMemIDDel, tfProIDDel;
    private JTextArea taMemAddFeedback, taMemDelFeedback, taMemUpdateFeedback, taProAddFeedback, taProDelFeedback, taProUpdateFeedback;
    private JPanel panelInputMemAdd, panelInputMemDel, panelInputMemUpdate, panelInputProAdd, panelInputProDel, panelInputProUpdate;
    private JButton buttonSubmitMemAdd, buttonSubmitMemDel, buttonSubmitMemUpdate, buttonSubmitProAdd, buttonSubmitProDel, buttonSubmitProUpdate;
    private JButton buttonSearchMemUpdate, buttonSearchProUpdate;
    private JButton buttonSearchMemDel, buttonSearchProDel;
    
    private boolean memUpdateSearch = false;
    private String memUpdateOldID = "";
    private boolean proUpdateSearch = false;
    private String proUpdateOldID = "";
    

    /**
     * Constructor. Creates an instance of the Operator Interface class with all components and panels.
     * 
     * @author Ben Geary
     * 
     */
    public OperatorInterface(){

        //Creating Option panel and formatting it
        panelOptions = new JPanel();
        panelOptions.setLayout(null);
        panelOptions.setBounds(0,0,450,800);
        panelOptions.setBackground(new Color(112,107,107));


        //Creating Logout Button and formatting it
        buttonLogout = new JButton("Logout");
        buttonLogout.setBounds(1050, 10, 100, 30);
        buttonLogout.addActionListener(this);

        //Creating Operator Label and formatting it in the Option Panel
        labelOperator = new JLabel("Operator Menu");
        labelOperator.setFont(new Font("Times New Roman", Font.BOLD, 40));
        labelOperator.setBounds(100,75,400,50);
        labelOperator.setForeground(new Color(0, 0, 0));

        //Creating Option buttons and formatting them
        buttonMemAdd = createOptButton("Add Member", 130,200,200,50);
        buttonMemAdd.addActionListener(this);
        buttonMemDel = createOptButton("Delete Member", 130,275,200,50);
        buttonMemDel.addActionListener(this);
        buttonMemUpdate = createOptButton("Update Member", 130, 350, 200, 50);
        buttonMemUpdate.addActionListener(this);
        buttonProAdd = createOptButton("Add Provider", 130,425,200,50);
        buttonProAdd.addActionListener(this);
        buttonProDel = createOptButton("Delete Provider", 130,500,200,50);
        buttonProDel.addActionListener(this);
        buttonProUpdate = createOptButton("Update Provider", 130,575,200,50);
        buttonProUpdate.addActionListener(this);


        //Adding Components to Option Panel
        panelOptions.add(labelOperator);
        panelOptions.add(buttonMemAdd);
        panelOptions.add(buttonMemDel);
        panelOptions.add(buttonMemUpdate);
        panelOptions.add(buttonProAdd);
        panelOptions.add(buttonProDel);
        panelOptions.add(buttonProUpdate);

        //Creating Input Panels
        addMemPanelCreate();
        delMemPanelCreate();
        updateMemPanelCreate();
        addProPanelCreate();
        delProPanelCreate();
        updateProPanelCreate();


        //Creating and formatting frame
        frameOperator = new JFrame();
        frameOperator.setLayout(null);
        frameOperator.setSize(1200,800);
        frameOperator.setLocationRelativeTo(null);
        frameOperator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameOperator.add(panelOptions);
        frameOperator.add(buttonLogout);

        frameOperator.add(panelInputMemAdd);
        frameOperator.add(panelInputMemDel);
        frameOperator.add(panelInputMemUpdate);
        frameOperator.add(panelInputProAdd);
        frameOperator.add(panelInputProDel);
        frameOperator.add(panelInputProUpdate);

        frameOperator.setVisible(true);


    }

    /**
     * Creates and populates an option button to be placed into the option panel
     *
     * @author Ben Geary
     *
     * @param title
     * @param x
     * @param y
     * @param width
     * @param height
     * @return JButton object
     */
    private JButton createOptButton(String title, int x, int y, int width, int height){
        JButton temp = new JButton(title);
        temp.setBounds(x,y,width,height);
        temp.setFont(new Font("Times New Roman", Font.BOLD,20));

        return temp;
    }

    /**
     * Creates the Add Member Panel as well as all the components inside the panel
     * 
     * @author Ben Geary
     */
    private void addMemPanelCreate(){

        //Creating Add Member Label and formatting it
        labelAddMem = new JLabel("Add Member");
        labelAddMem.setBounds(100,125,300,30);
        labelAddMem.setFont(new Font("Times New Roman", Font.BOLD, 35));

        //Creating the labels for Add Member Panel
        labelInputMemNameAdd = new JLabel("Add Member Name:");
        labelInputMemAddressAdd = new JLabel("Add Member Address:");
        labelInputMemCityAdd = new JLabel("Add Member City:");
        labelInputMemStateAdd = new JLabel("Add Member State:");
        labelInputMemZipAdd = new JLabel("Add Member Zipcode:");
        labelInputMemIDAdd = new JLabel("Add Member ID Number:");
        labelInputStatusMemAdd = new JLabel("Enter Status (ACTIVE or SUSPENDED):");

        //Creating the text-fields for Add Member Panel
        tfMemNameAdd = new JTextField();
        tfMemAddressAdd = new JTextField();
        tfMemCityAdd = new JTextField();
        tfMemStateAdd = new JTextField();
        tfMemZipAdd = new JTextField();
        tfMemIDAdd = new JTextField();
        tfMemStatusAdd = new JTextField();

        //Formatting Member Name label and text-field
        labelInputMemNameAdd.setBounds(50,200,300,30);
        labelInputMemNameAdd.setFont(new Font("Times New Roman", Font.BOLD,15));
        tfMemNameAdd.setBounds(200,205,150,20);

        //Formatting Member Address label and text-field
        labelInputMemAddressAdd.setBounds(50,250,300,30);
        labelInputMemAddressAdd.setFont(new Font("Times New Roman", Font.BOLD,15));
        tfMemAddressAdd.setBounds(220,255,150,20);

        //Formatting Member City label and text-field
        labelInputMemCityAdd.setBounds(50,300,300,30);
        labelInputMemCityAdd.setFont(new Font("Times New Roman", Font.BOLD,15));
        tfMemCityAdd.setBounds(220,305,150,20);

        //Formatting Member State label and text-field
        labelInputMemStateAdd.setBounds(50,350,300,30);
        labelInputMemStateAdd.setFont(new Font("Times New Roman", Font.BOLD,15));
        tfMemStateAdd.setBounds(220,355,150,20);

        //Formatting Member Zip label and text-field
        labelInputMemZipAdd.setBounds(50,400,300,30);
        labelInputMemZipAdd.setFont(new Font("Times New Roman", Font.BOLD,15));
        tfMemZipAdd.setBounds(220,405,150,20);

        //Formatting Member ID label and text-field
        labelInputMemIDAdd.setBounds(50,450,300,30);
        labelInputMemIDAdd.setFont(new Font("Times New Roman", Font.BOLD,15));
        tfMemIDAdd.setBounds(250,455,150,20);

        //Formatting Member Status Label and text-field
        labelInputStatusMemAdd.setBounds(50,500,300,30);
        labelInputStatusMemAdd.setFont(new Font("Times New Roman", Font.BOLD,15));
        tfMemStatusAdd.setBounds(350,505,150,20);

        //Creating and formatting submit button
        buttonSubmitMemAdd = new JButton("Submit New Member");
        buttonSubmitMemAdd.setBounds(100,600,200,30);
        buttonSubmitMemAdd.addActionListener(this);

        //Creating and formatting Feedback Text Area
        taMemAddFeedback = new JTextArea();
        taMemAddFeedback.setBounds(400,600,250,150);
        taMemAddFeedback.setEditable(false);
        taMemAddFeedback.setBorder(BorderFactory.createTitledBorder("Feedback"));


        //Creating Add Member Panel
        panelInputMemAdd = new JPanel();
        panelInputMemAdd.setLayout(null);
        panelInputMemAdd.setBounds(500,0,700,800);
        panelInputMemAdd.setBackground(new Color(245, 245, 245));

        //Adding Components to Panel
        panelInputMemAdd.add(labelInputMemNameAdd);
        panelInputMemAdd.add(labelInputMemAddressAdd);
        panelInputMemAdd.add(labelInputMemCityAdd);
        panelInputMemAdd.add(labelInputMemStateAdd);
        panelInputMemAdd.add(labelInputMemZipAdd);
        panelInputMemAdd.add(labelInputMemIDAdd);
        panelInputMemAdd.add(labelInputStatusMemAdd);
        panelInputMemAdd.add(tfMemNameAdd);
        panelInputMemAdd.add(tfMemAddressAdd);
        panelInputMemAdd.add(tfMemCityAdd);
        panelInputMemAdd.add(tfMemStateAdd);
        panelInputMemAdd.add(tfMemZipAdd);
        panelInputMemAdd.add(tfMemIDAdd);
        panelInputMemAdd.add(tfMemStatusAdd);
        panelInputMemAdd.add(labelAddMem);
        panelInputMemAdd.add(buttonSubmitMemAdd);
        panelInputMemAdd.add(taMemAddFeedback);

        panelInputMemAdd.setVisible(false);
    }

    /**
     * Creates the Delete Member Panel as well as all the components inside the panel
     * 
     * @author Ben Geary
     */
    private void delMemPanelCreate(){

        //Creating Delete Member Label and formatting it
        labelDelMem = new JLabel("Delete Member");
        labelDelMem.setBounds(100,125,300,30);
        labelDelMem.setFont(new Font("Times New Roman", Font.BOLD, 35));

        //Creating label for Member ID to be deleted
        labelInputMemIDDel = new JLabel("ID Number of Member to Delete:");
        labelInputMemIDDel.setBounds(50,200,300,30);
        labelInputMemIDDel.setFont(new Font("Times New Roman", Font.BOLD, 15));

        //Creating text-field to enter member ID to delete and formatting it
        tfMemIDDel = new JTextField();
        tfMemIDDel.setBounds(300,205,150,20);

        //Creating feedback text-area and formatting it
        taMemDelFeedback = new JTextArea();
        taMemDelFeedback.setBounds(400,300,250,150);
        taMemDelFeedback.setEditable(false);
        taMemDelFeedback.setBorder(BorderFactory.createTitledBorder("Feedback"));

        //Creating Submit Delete Member Button and formatting it
        buttonSubmitMemDel = new JButton("Confirm Delete Member");
        buttonSubmitMemDel.setBounds(75,300,200,30);
        buttonSubmitMemDel.addActionListener(this);

        //Creating Delete Member Panel
        panelInputMemDel = new JPanel();
        panelInputMemDel.setLayout(null);
        panelInputMemDel.setBounds(500,0,700,800);
        panelInputMemDel.setBackground(new Color(245, 245, 245));

        //Adding Components to Delete Member Panel
        panelInputMemDel.add(labelDelMem);
        panelInputMemDel.add(labelInputMemIDDel);
        panelInputMemDel.add(tfMemIDDel);
        panelInputMemDel.add(taMemDelFeedback);
        panelInputMemDel.add(buttonSubmitMemDel);

        panelInputMemDel.setVisible(false);
    }
    
    /**
     * Creates the Update Member Panel as well as all the components inside the panel
     * 
     * @author Ben Geary
     */
    private void updateMemPanelCreate(){

        //Creating Add Member Label and formatting it
        labelUpdateMem = new JLabel("Update Member");
        labelUpdateMem.setBounds(100,50,300,30);
        labelUpdateMem.setFont(new Font("Times New Roman", Font.BOLD, 35));

        //Creating and Formatting Member ID label and text-field
        labelInputMemIDUpdate = new JLabel("Enter Member ID Number to Update:");
        labelInputMemIDUpdate.setBounds(50,115,350,30);
        labelInputMemIDUpdate.setFont(new Font("Times New Roman", Font.BOLD,15));
        tfMemIDUpdate = new JTextField();
        tfMemIDUpdate.setBounds(320,120,150,20);

        //Creating and formatting search button for member ID to delete
        buttonSearchMemUpdate = new JButton("Search");
        buttonSearchMemUpdate.setBounds(500,120,100,20);
        buttonSearchMemUpdate.addActionListener(this);

        //Creating the labels for Add Member Panel
        labelInputMemNameUpdate = new JLabel("Update Member Name:");
        labelInputMemAddressUpdate = new JLabel("Update Member Address:");
        labelInputMemCityUpdate = new JLabel("Update Member City:");
        labelInputMemStateUpdate = new JLabel("Update Member State:");
        labelInputMemZipUpdate = new JLabel("Update Member Zipcode:");
        labelStatusMemUpdate = new JLabel("Update Status (ACTIVE or SUSPENDED):");

        //Creating the text-fields for Add Member Panel
        tfMemNameUpdate = new JTextField();
        tfMemAddressUpdate = new JTextField();
        tfMemCityUpdate = new JTextField();
        tfMemStateUpdate = new JTextField();
        tfMemZipUpdate = new JTextField();
        tfMemStatusUpdate = new JTextField();

        //Formatting Member Name label and text-field
        labelInputMemNameUpdate.setBounds(50,200,300,30);
        labelInputMemNameUpdate.setFont(new Font("Times New Roman", Font.BOLD,15));
        tfMemNameUpdate.setBounds(230,205,150,20);

        //Formatting Member Address label and text-field
        labelInputMemAddressUpdate.setBounds(50,250,300,30);
        labelInputMemAddressUpdate.setFont(new Font("Times New Roman", Font.BOLD,15));
        tfMemAddressUpdate.setBounds(230,255,150,20);

        //Formatting Member City label and text-field
        labelInputMemCityUpdate.setBounds(50,300,300,30);
        labelInputMemCityUpdate.setFont(new Font("Times New Roman", Font.BOLD,15));
        tfMemCityUpdate.setBounds(230,305,150,20);

        //Formatting Member State label and text-field
        labelInputMemStateUpdate.setBounds(50,350,300,30);
        labelInputMemStateUpdate.setFont(new Font("Times New Roman", Font.BOLD,15));
        tfMemStateUpdate.setBounds(230,355,150,20);

        //Formatting Member Zip label and text-field
        labelInputMemZipUpdate.setBounds(50,400,300,30);
        labelInputMemZipUpdate.setFont(new Font("Times New Roman", Font.BOLD,15));
        tfMemZipUpdate.setBounds(230,405,150,20);

        //Formatting Member Status Label and text-field
        labelStatusMemUpdate.setBounds(50,450,300,30);
        labelStatusMemUpdate.setFont(new Font("Times New Roman", Font.BOLD,15));
        tfMemStatusUpdate.setBounds(350,455,150,20);

        //Creating and formatting submit button
        buttonSubmitMemUpdate = new JButton("Update Existing Member");
        buttonSubmitMemUpdate.setBounds(100,500,200,30);
        buttonSubmitMemUpdate.addActionListener(this);

        //Creating and formatting Feedback Text Area
        taMemUpdateFeedback = new JTextArea();
        taMemUpdateFeedback.setBounds(400,600,250,150);
        taMemUpdateFeedback.setEditable(false);
        taMemUpdateFeedback.setBorder(BorderFactory.createTitledBorder("Feedback"));


        //Creating Member Update Panel
        panelInputMemUpdate = new JPanel();
        panelInputMemUpdate.setLayout(null);
        panelInputMemUpdate.setBounds(500,0,700,800);
        panelInputMemUpdate.setBackground(new Color(245, 245, 245));

        //Adding components to Member Update Panel
        panelInputMemUpdate.add(labelInputMemNameUpdate);
        panelInputMemUpdate.add(labelInputMemAddressUpdate);
        panelInputMemUpdate.add(labelInputMemCityUpdate);
        panelInputMemUpdate.add(labelInputMemStateUpdate);
        panelInputMemUpdate.add(labelInputMemZipUpdate);
        panelInputMemUpdate.add(labelInputMemIDUpdate);
        panelInputMemUpdate.add(labelStatusMemUpdate);
        panelInputMemUpdate.add(tfMemNameUpdate);
        panelInputMemUpdate.add(tfMemAddressUpdate);
        panelInputMemUpdate.add(tfMemCityUpdate);
        panelInputMemUpdate.add(tfMemStateUpdate);
        panelInputMemUpdate.add(tfMemZipUpdate);
        panelInputMemUpdate.add(tfMemIDUpdate);
        panelInputMemUpdate.add(tfMemStatusUpdate);
        panelInputMemUpdate.add(labelUpdateMem);
        panelInputMemUpdate.add(buttonSubmitMemUpdate);
        panelInputMemUpdate.add(taMemUpdateFeedback);
        panelInputMemUpdate.add(buttonSearchMemUpdate);

        panelInputMemUpdate.setVisible(false);
    }
    
    /**
     * Creates the Add Provider Panel as well as all the components inside the panel
     * 
     * @author Ben Geary
     */
    private void addProPanelCreate(){
        //Creating Add Member Label and formatting it
        labelAddPro = new JLabel("Add Provider");
        labelAddPro.setBounds(100,125,300,30);
        labelAddPro.setFont(new Font("Times New Roman", Font.BOLD, 35));

        //Creating the labels for Add Member Panel
        labelInputProNameAdd = new JLabel("Add Provider Name:");
        labelInputProAddressAdd = new JLabel("Add Provider Address:");
        labelInputProCityAdd = new JLabel("Add Provider City:");
        labelInputProStateAdd = new JLabel("Add Provider State:");
        labelInputProZipAdd = new JLabel("Add Provider Zipcode:");
        labelInputProIDAdd = new JLabel("Add Provider ID Number:");
        labelInputStatusProAdd = new JLabel("Enter Status (ACTIVE or SUSPENDED):");

        //Creating the text-fields for Add Member Panel
        tfProNameAdd = new JTextField();
        tfProAddressAdd = new JTextField();
        tfProCityAdd = new JTextField();
        tfProStateAdd = new JTextField();
        tfProZipAdd = new JTextField();
        tfProIDAdd = new JTextField();
        tfProStatusAdd = new JTextField();

        //Formatting Member Name label and text-field
        labelInputProNameAdd.setBounds(50,200,300,30);
        labelInputProNameAdd.setFont(new Font("Times New Roman", Font.BOLD,15));
        tfProNameAdd.setBounds(200,205,150,20);

        //Formatting Member Address label and text-field
        labelInputProAddressAdd.setBounds(50,250,300,30);
        labelInputProAddressAdd.setFont(new Font("Times New Roman", Font.BOLD,15));
        tfProAddressAdd.setBounds(220,255,150,20);

        //Formatting Member City label and text-field
        labelInputProCityAdd.setBounds(50,300,300,30);
        labelInputProCityAdd.setFont(new Font("Times New Roman", Font.BOLD,15));
        tfProCityAdd.setBounds(220,305,150,20);

        //Formatting Member State label and text-field
        labelInputProStateAdd.setBounds(50,350,300,30);
        labelInputProStateAdd.setFont(new Font("Times New Roman", Font.BOLD,15));
        tfProStateAdd.setBounds(220,355,150,20);

        //Formatting Member Zip label and text-field
        labelInputProZipAdd.setBounds(50,400,300,30);
        labelInputProZipAdd.setFont(new Font("Times New Roman", Font.BOLD,15));
        tfProZipAdd.setBounds(220,405,150,20);

        //Formatting Member ID label and text-field
        labelInputProIDAdd.setBounds(50,450,300,30);
        labelInputProIDAdd.setFont(new Font("Times New Roman", Font.BOLD,15));
        tfProIDAdd.setBounds(250,455,150,20);

        //Formatting Member Status Label and text-field
        labelInputStatusProAdd.setBounds(50,500,300,30);
        labelInputStatusProAdd.setFont(new Font("Times New Roman", Font.BOLD,15));
        tfProStatusAdd.setBounds(350,505,150,20);

        //Creating and formatting submit button
        buttonSubmitProAdd = new JButton("Submit New Provider");
        buttonSubmitProAdd.setBounds(100,600,200,30);
        buttonSubmitProAdd.addActionListener(this);

        //Creating and formatting Feedback Text Area
        taProAddFeedback = new JTextArea();
        taProAddFeedback.setBounds(400,600,250,150);
        taProAddFeedback.setEditable(false);
        taProAddFeedback.setBorder(BorderFactory.createTitledBorder("Feedback"));


        //Creating Add Member Panel
        panelInputProAdd = new JPanel();
        panelInputProAdd.setLayout(null);
        panelInputProAdd.setBounds(500,0,700,800);
        panelInputProAdd.setBackground(new Color(245, 245, 245));

        //Adding Components to Panel
        panelInputProAdd.add(labelInputProNameAdd);
        panelInputProAdd.add(labelInputProAddressAdd);
        panelInputProAdd.add(labelInputProCityAdd);
        panelInputProAdd.add(labelInputProStateAdd);
        panelInputProAdd.add(labelInputProZipAdd);
        panelInputProAdd.add(labelInputProIDAdd);
        panelInputProAdd.add(labelInputStatusProAdd);
        panelInputProAdd.add(tfProNameAdd);
        panelInputProAdd.add(tfProAddressAdd);
        panelInputProAdd.add(tfProCityAdd);
        panelInputProAdd.add(tfProStateAdd);
        panelInputProAdd.add(tfProZipAdd);
        panelInputProAdd.add(tfProIDAdd);
        panelInputProAdd.add(tfProStatusAdd);
        panelInputProAdd.add(labelAddPro);
        panelInputProAdd.add(buttonSubmitProAdd);
        panelInputProAdd.add(taProAddFeedback);

        panelInputProAdd.setVisible(false);
    }
    
    /**
     * Creates the Delete Provider Panel as well as all the components inside the panel
     * 
     * @author Ben Geary
     */
    private void delProPanelCreate(){
        //Creating Delete Member Label and formatting it
        labelDelPro = new JLabel("Delete Provider");
        labelDelPro.setBounds(100,125,300,30);
        labelDelPro.setFont(new Font("Times New Roman", Font.BOLD, 35));

        //Creating label for Member ID to be deleted
        labelInputProIDDel = new JLabel("ID Number of Member to Delete:");
        labelInputProIDDel.setBounds(50,200,300,30);
        labelInputProIDDel.setFont(new Font("Times New Roman", Font.BOLD, 15));

        //Creating text-field to enter member ID to delete and formatting it
        tfProIDDel = new JTextField();
        tfProIDDel.setBounds(300,205,150,20);

        //Creating feedback text-area and formatting it
        taProDelFeedback = new JTextArea();
        taProDelFeedback.setBounds(400,300,250,150);
        taProDelFeedback.setEditable(false);
        taProDelFeedback.setBorder(BorderFactory.createTitledBorder("Feedback"));

        //Creating Submit Delete Member Button and formatting it
        buttonSubmitProDel = new JButton("Confirm Delete Provider");
        buttonSubmitProDel.setBounds(75,300,200,30);
        buttonSubmitProDel.addActionListener(this);

        //Creating Delete Member Panel
        panelInputProDel = new JPanel();
        panelInputProDel.setLayout(null);
        panelInputProDel.setBounds(500,0,700,800);
        panelInputProDel.setBackground(new Color(245, 245, 245));

        //Adding Components to Delete Member Panel
        panelInputProDel.add(labelDelPro);
        panelInputProDel.add(labelInputProIDDel);
        panelInputProDel.add(tfProIDDel);
        panelInputProDel.add(taProDelFeedback);
        panelInputProDel.add(buttonSubmitProDel);

        panelInputProDel.setVisible(false);
    }
    
    /**
     * Creates the Update Provider Panel as well as all the components inside the panel
     * 
     * @author Ben Geary
     */
    private void updateProPanelCreate(){
        //Creating Add Member Label and formatting it
        labelUpdatePro = new JLabel("Update Provider");
        labelUpdatePro.setBounds(100,50,300,30);
        labelUpdatePro.setFont(new Font("Times New Roman", Font.BOLD, 35));

        //Creating and Formatting Member ID label and text-field
        labelInputProIDUpdate = new JLabel("Enter Proivder ID Number to Update:");
        labelInputProIDUpdate.setBounds(50,115,350,30);
        labelInputProIDUpdate.setFont(new Font("Times New Roman", Font.BOLD,15));
        tfProIDUpdate = new JTextField();
        tfProIDUpdate.setBounds(320,120,150,20);

        //Creating and formatting search button for member ID to delete
        buttonSearchProUpdate = new JButton("Search");
        buttonSearchProUpdate.setBounds(500,120,100,20);
        buttonSearchProUpdate.addActionListener(this);

        //Creating the labels for Add Member Panel
        labelInputProNameUpdate = new JLabel("Update Provider Name:");
        labelInputProAddressUpdate = new JLabel("Update Provider Address:");
        labelInputProCityUpdate = new JLabel("Update Provider City:");
        labelInputProStateUpdate = new JLabel("Update Provider State:");
        labelInputProZipUpdate = new JLabel("Update Provider Zipcode:");
        labelStatusProUpdate = new JLabel("Update Status (ACTIVE or SUSPENDED):");

        //Creating the text-fields for Add Member Panel
        tfProNameUpdate = new JTextField();
        tfProAddressUpdate = new JTextField();
        tfProCityUpdate = new JTextField();
        tfProStateUpdate = new JTextField();
        tfProZipUpdate = new JTextField();
        tfProStatusUpdate = new JTextField();

        //Formatting Member Name label and text-field
        labelInputProNameUpdate.setBounds(50,200,300,30);
        labelInputProNameUpdate.setFont(new Font("Times New Roman", Font.BOLD,15));
        tfProNameUpdate.setBounds(230,205,150,20);

        //Formatting Member Address label and text-field
        labelInputProAddressUpdate.setBounds(50,250,300,30);
        labelInputProAddressUpdate.setFont(new Font("Times New Roman", Font.BOLD,15));
        tfProAddressUpdate.setBounds(230,255,150,20);

        //Formatting Member City label and text-field
        labelInputProCityUpdate.setBounds(50,300,300,30);
        labelInputProCityUpdate.setFont(new Font("Times New Roman", Font.BOLD,15));
        tfProCityUpdate.setBounds(230,305,150,20);

        //Formatting Member State label and text-field
        labelInputProStateUpdate.setBounds(50,350,300,30);
        labelInputProStateUpdate.setFont(new Font("Times New Roman", Font.BOLD,15));
        tfProStateUpdate.setBounds(230,355,150,20);

        //Formatting Member Zip label and text-field
        labelInputProZipUpdate.setBounds(50,400,300,30);
        labelInputProZipUpdate.setFont(new Font("Times New Roman", Font.BOLD,15));
        tfProZipUpdate.setBounds(230,405,150,20);

        //Formatting Member Status Label and text-field
        labelStatusProUpdate.setBounds(50,450,300,30);
        labelStatusProUpdate.setFont(new Font("Times New Roman", Font.BOLD,15));
        tfProStatusUpdate.setBounds(350,455,150,20);

        //Creating and formatting submit button
        buttonSubmitProUpdate = new JButton("Update Existing Provider");
        buttonSubmitProUpdate.setBounds(100,500,200,30);
        buttonSubmitProUpdate.addActionListener(this);

        //Creating and formatting Feedback Text Area
        taProUpdateFeedback = new JTextArea();
        taProUpdateFeedback.setBounds(400,600,250,150);
        taProUpdateFeedback.setEditable(false);
        taProUpdateFeedback.setBorder(BorderFactory.createTitledBorder("Feedback"));


        //Creating Member Update Panel
        panelInputProUpdate = new JPanel();
        panelInputProUpdate.setLayout(null);
        panelInputProUpdate.setBounds(500,0,700,800);
        panelInputProUpdate.setBackground(new Color(245, 245, 245));

        //Adding components to Member Update Panel
        panelInputProUpdate.add(labelInputProNameUpdate);
        panelInputProUpdate.add(labelInputProAddressUpdate);
        panelInputProUpdate.add(labelInputProCityUpdate);
        panelInputProUpdate.add(labelInputProStateUpdate);
        panelInputProUpdate.add(labelInputProZipUpdate);
        panelInputProUpdate.add(labelInputProIDUpdate);
        panelInputProUpdate.add(labelStatusProUpdate);
        panelInputProUpdate.add(tfProNameUpdate);
        panelInputProUpdate.add(tfProAddressUpdate);
        panelInputProUpdate.add(tfProCityUpdate);
        panelInputProUpdate.add(tfProStateUpdate);
        panelInputProUpdate.add(tfProZipUpdate);
        panelInputProUpdate.add(tfProIDUpdate);
        panelInputProUpdate.add(tfProStatusUpdate);
        panelInputProUpdate.add(labelUpdatePro);
        panelInputProUpdate.add(buttonSubmitProUpdate);
        panelInputProUpdate.add(taProUpdateFeedback);
        panelInputProUpdate.add(buttonSearchProUpdate);

        panelInputProUpdate.setVisible(false);

    }

    /**
     * Clears the components in the Add Member Panel when a different option is selected
     * or when a valid submission occurs
     *
     * @author Ben Geary
     *
     */
    private void clearAddMemPanel(){
    	tfMemNameAdd.setText("");
    	tfMemAddressAdd.setText("");
    	tfMemCityAdd.setText("");
    	tfMemStateAdd.setText("");
    	tfMemZipAdd.setText("");
    	tfMemIDAdd.setText("");
    	tfMemStatusAdd.setText("");
    	taMemAddFeedback.setText("");
    }
    
    /**
     * Clears the components in the Delete Member Panel when a different option is selected
     * or when a valid submission occurs
     *
     * @author Ben Geary
     *
     */
    private void clearDelMemPanel() {
    	tfMemIDDel.setText("");
    	taMemDelFeedback.setText("");
    }
    
    /**
     * Clears the components in the Update Member Panel when a different option is selected
     * or when a valid submission occurs
     *
     * @author Ben Geary
     *
     */
    private void clearUpdateMemPanel() {
    	tfMemNameUpdate.setText("");
    	tfMemAddressUpdate.setText("");
    	tfMemCityUpdate.setText("");
    	tfMemStateUpdate.setText("");
    	tfMemZipUpdate.setText("");
    	tfMemIDUpdate.setText("");
    	tfMemStatusUpdate.setText("");
    	taMemUpdateFeedback.setText("");
    	memUpdateSearch = false;
    	memUpdateOldID = "";
    	
    }
    
    /**
     * Clears the components in the Add Provider Panel when a different option is selected
     * or when a valid submission occurs
     *
     * @author Ben Geary
     *
     */
    private void clearAddProPanel() {
    	tfProNameAdd.setText("");
    	tfProAddressAdd.setText("");
    	tfProCityAdd.setText("");
    	tfProStateAdd.setText("");
    	tfProZipAdd.setText("");
    	tfProIDAdd.setText("");
    	tfProStatusAdd.setText("");
    	taProAddFeedback.setText("");
    	
    }
    
    /**
     * Clears the components in the Delete Provider Panel when a different option is selected
     * or when a valid submission occurs
     *
     * @author Ben Geary
     *
     */
    private void clearDelProPanel() {
    	tfProIDDel.setText("");
    	taProDelFeedback.setText("");
    }
    
    /**
     * Clears the components in the Update Provider Panel when a different option is selected
     * or when a valid submission occurs
     *
     * @author Ben Geary
     *
     */
    private void clearUpdateProPanel() {
    	tfProNameUpdate.setText("");
    	tfProAddressUpdate.setText("");
    	tfProCityUpdate.setText("");
    	tfProStateUpdate.setText("");
    	tfProZipUpdate.setText("");
    	tfProIDUpdate.setText("");
    	tfProStatusUpdate.setText("");
    	taProUpdateFeedback.setText("");
    	proUpdateSearch = false;
    	proUpdateOldID = "";
    }


    
    /**
     * Helper function to search if the member num is a valid entry and exists.
     * If member num exists then it removes the member.
     * 
     * @author Ben Geary
     */
    private void searchMemNumAndDelete() {
        String strTempNum = tfMemIDDel.getText();
        String validCheck = "";
        OperatorControl op = new OperatorControl();
        if (strTempNum.matches("\\d+")) {
        	if (strTempNum.length() == 9) {
        		int iTempNum = Integer.parseInt(strTempNum);
        		validCheck = op.validateMember(iTempNum);
        	}
        	else {
        		taMemDelFeedback.setText("INVALID ENTRY");
        		return;
        	}
        	
        	if (!validCheck.equals("INVALID")) {
        		int iTempNum = Integer.parseInt(strTempNum);
        		boolean removed = op.removeMember(iTempNum);
        		if (removed == true) {
        			clearDelMemPanel();
        			taMemDelFeedback.setText("Member " + strTempNum + " has been removed.");
        		}
        		else {
        			clearDelMemPanel();
        			taMemDelFeedback.setText("Member removal failed");
        		}
        	}
        }
    }
    
    
    /**
     * Helper function to search if the provider num is a valid entry and exists.
     * If provider num exists then it removes the member.
     * 
     * @author Ben Geary
     */
    private void searchProNumAndDelete() {
        String strTempNum = tfProIDDel.getText();
        String validCheck = "";
        OperatorControl op = new OperatorControl();
        if (strTempNum.matches("\\d+")) {
        	if (strTempNum.length() == 9) {
        		int iTempNum = Integer.parseInt(strTempNum);
        		validCheck = op.validateProvider(iTempNum);
        	}
        	else {
        		taProDelFeedback.setText("INVALID ENTRY");
        		return;
        	}
        	
        	if (!validCheck.equals("INVALID")) {
        		int iTempNum = Integer.parseInt(strTempNum);
        		boolean removed = op.removeProvider(iTempNum);
        		if (removed == true) {
        			clearDelMemPanel();
        			taProDelFeedback.setText("Provider " + strTempNum + " has been removed.");
        		}
        		else {
        			clearDelMemPanel();
        			taProDelFeedback.setText("Provider removal failed");
        		}
        	}
        }
    }
    
    
    private boolean searchMemNumAndPopulate() {
        String strTempNum = tfMemIDUpdate.getText();
        String validCheck = "";
        OperatorControl op = new OperatorControl();
        if (strTempNum.matches("\\d+")) {
        	if (strTempNum.length() == 9) {
        		int iTempNum = Integer.parseInt(strTempNum);
        		validCheck = op.validateMember(iTempNum);
        	}
        	else {
        		taMemUpdateFeedback.setText("INVALID MEMBER NUMBER");
        		return false;
        	}
        	
        	if (!validCheck.equals("INVALID")) {
        		int iTempNum = Integer.parseInt(strTempNum);
        		Member tempMem = op.getMember(iTempNum);
        		String tempMemName = tempMem.getMemName();
        		String tempMemAdd = tempMem.getMemAddress();
        		String tempMemCity = tempMem.getMemCity();
        		String tempMemZip = tempMem.getMemZip();
        		String tempMemState = tempMem.getMemState();
        		Boolean tempMemStatus = tempMem.getMemStatus();
        		
        		tfMemNameUpdate.setText(tempMemName);
        		tfMemAddressUpdate.setText(tempMemAdd);
        		tfMemCityUpdate.setText(tempMemCity);
        		tfMemStateUpdate.setText(tempMemState);
        		tfMemZipUpdate.setText(tempMemZip);
        		
        		if (tempMemStatus == true) {
        			tfMemStatusUpdate.setText("ACTIVE");
        		}
        		else {
        			tfMemStatusUpdate.setText("SUSPENDED");
        		}
        		
        		return true;
        	}
        }
        return false;
    }
    
    private boolean checkAddMemInput() {
    	String nameTemp = tfMemNameAdd.getText();
    	String addTemp = tfMemAddressAdd.getText();        
    	String stateTemp = tfMemStateAdd.getText();
    	String zipTemp = tfMemZipAdd.getText();
    	String cityTemp = tfMemCityAdd.getText();
    	String idTemp = tfMemIDAdd.getText();
    	String statusTemp = tfMemStatusAdd.getText();
    	
    	if (nameTemp.length() > 25) {
    		taMemAddFeedback.setText("Name is too long");
    		return false;
    	}
    	else if(addTemp.length() > 25) {
    		taMemAddFeedback.setText("Address is too long");
    		return false;
    	}
    	else if(stateTemp.length() != 2) {
    		taMemAddFeedback.setText("State input is invalid");
    		return false;
    	}
    	else if(zipTemp.length() != 5) {
    		taMemAddFeedback.setText("Zip input is invalid");
    		return false;
    	}
    	else if(cityTemp.length() > 14) {
    		taMemAddFeedback.setText("City is too long");
    		return false;
    	}
    	else if(idTemp.length() != 9 || !idTemp.matches("\\d+")) {
    		taMemAddFeedback.setText("Member input is invalid");
    		return false;
    	}
    	else if (statusTemp.equals("ACTIVE") && statusTemp.equals("SUSPENDED")) {
    		System.out.println(statusTemp);
    		taMemAddFeedback.setText("Status input is invalid");
    		return false;
    	}
    	return true;
    }
    
    private boolean checkAddProInput() {
    	String nameTemp = tfProNameAdd.getText();
    	String addTemp = tfProAddressAdd.getText();        
    	String stateTemp = tfProStateAdd.getText();
    	String zipTemp = tfProZipAdd.getText();
    	String cityTemp = tfProCityAdd.getText();
    	String idTemp = tfProIDAdd.getText();
    	String statusTemp = tfProStatusAdd.getText();
    	
    	if (nameTemp.length() > 25) {
    		taProAddFeedback.setText("Name is too long");
    		return false;
    	}
    	else if(addTemp.length() > 25) {
    		taProAddFeedback.setText("Address is too long");
    		return false;
    	}
    	else if(stateTemp.length() != 2) {
    		taProAddFeedback.setText("State input is invalid");
    		return false;
    	}
    	else if(zipTemp.length() != 5) {
    		taProAddFeedback.setText("Zip input is invalid");
    		return false;
    	}
    	else if(cityTemp.length() > 14) {
    		taProAddFeedback.setText("City is too long");
    		return false;
    	}
    	else if(idTemp.length() != 9 || !idTemp.matches("\\d+")) {
    		taProAddFeedback.setText("Provider number input is invalid");
    		return false;
    	}
    	else if (statusTemp.equals("ACTIVE") && statusTemp.equals("SUSPENDED")) {
    		//System.out.println(statusTemp);
    		taProAddFeedback.setText("Status input is invalid");
    		return false;
    	}
    	return true;
    }
    
    private boolean searchProNumAndPopulate() {
        String strTempNum = tfProIDUpdate.getText();
        String validCheck = "";
        OperatorControl op = new OperatorControl();
        if (strTempNum.matches("\\d+")) {
        	if (strTempNum.length() == 9) {
        		int iTempNum = Integer.parseInt(strTempNum);
        		validCheck = op.validateProvider(iTempNum);
        	}
        	else {
        		taProUpdateFeedback.setText("INVALID MEMBER NUMBER");
        		return false;
        	}
        	
        	if (!validCheck.equals("INVALID")) {
        		int iTempNum = Integer.parseInt(strTempNum);
        		Provider tempPro = op.getProvider(iTempNum);
        		String tempMemName = tempPro.getName();
        		String tempMemAdd = tempPro.getAddress();
        		String tempMemCity = tempPro.getCity();
        		String tempMemZip = tempPro.getZip();
        		String tempMemState = tempPro.getState();
        		Boolean tempMemStatus = tempPro.getStatus();
        		
        		tfProNameUpdate.setText(tempMemName);
        		tfProAddressUpdate.setText(tempMemAdd);
        		tfProCityUpdate.setText(tempMemCity);
        		tfProStateUpdate.setText(tempMemState);
        		tfProZipUpdate.setText(tempMemZip);
        		
        		if (tempMemStatus == true) {
        			tfProStatusUpdate.setText("ACTIVE");
        		}
        		else {
        			tfProStatusUpdate.setText("SUSPENDED");
        		}
        		
        		return true;
        	}
        }
        return false;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonLogout){
            //tempCredList.addValidUser("manager", "ben","123");
            LoginInterface loginInterface = new LoginInterface();
            frameOperator.dispose();
        }
        if(e.getSource() == buttonMemAdd){
        	
        	clearDelMemPanel();
        	clearUpdateMemPanel();
        	clearAddProPanel();
        	clearDelProPanel();
        	clearUpdateProPanel();
            panelInputMemUpdate.setVisible(false);
            panelInputMemDel.setVisible(false);
            panelInputProAdd.setVisible(false);
            panelInputProDel.setVisible(false);
            panelInputProUpdate.setVisible(false);
            panelInputMemAdd.setVisible(true);
        }
        if(e.getSource() == buttonMemDel){
        	
        	clearAddMemPanel();
        	clearUpdateMemPanel();
        	clearAddProPanel();
        	clearDelProPanel();
        	clearUpdateProPanel();
            panelInputMemUpdate.setVisible(false);
            panelInputProAdd.setVisible(false);
            panelInputProDel.setVisible(false);
            panelInputProUpdate.setVisible(false);
            panelInputMemAdd.setVisible(false);
            panelInputMemDel.setVisible(true);
        }
        if(e.getSource() == buttonMemUpdate){
        	
        	clearAddMemPanel();
        	clearDelMemPanel();
        	clearAddProPanel();
        	clearDelProPanel();
        	clearUpdateProPanel();
            panelInputMemDel.setVisible(false);
            panelInputProAdd.setVisible(false);
            panelInputProDel.setVisible(false);
            panelInputProUpdate.setVisible(false);
            panelInputMemAdd.setVisible(false);
            panelInputMemUpdate.setVisible(true);
        }
        if(e.getSource() == buttonProAdd){
        	
        	clearAddMemPanel();
        	clearDelMemPanel();
        	clearUpdateMemPanel();
        	clearDelProPanel();
        	clearUpdateProPanel();
            panelInputMemUpdate.setVisible(false);
            panelInputMemDel.setVisible(false);
            panelInputProDel.setVisible(false);
            panelInputProUpdate.setVisible(false);
            panelInputMemAdd.setVisible(false);
            panelInputProAdd.setVisible(true);
        }
        if(e.getSource() == buttonProDel){
        	
        	clearAddMemPanel();
        	clearDelMemPanel();
        	clearUpdateMemPanel();
        	clearAddProPanel();
        	clearUpdateProPanel();
            panelInputMemUpdate.setVisible(false);
            panelInputMemDel.setVisible(false);
            panelInputProAdd.setVisible(false);
            panelInputProUpdate.setVisible(false);
            panelInputMemAdd.setVisible(false);
            panelInputProDel.setVisible(true);
        }
        if(e.getSource() == buttonProUpdate){
        	
        	clearAddMemPanel();
        	clearDelMemPanel();
        	clearUpdateMemPanel();
        	clearAddProPanel();
        	clearDelProPanel();
            panelInputMemUpdate.setVisible(false);
            panelInputMemDel.setVisible(false);
            panelInputProAdd.setVisible(false);
            panelInputProDel.setVisible(false);
            panelInputMemAdd.setVisible(false);
            panelInputProUpdate.setVisible(true);
        }
        
        
        //Driver code for adding a member using the input and operator control
        if (e.getSource() == buttonSubmitMemAdd) {
        	taMemAddFeedback.setText("");
        	boolean validInput = checkAddMemInput();
        	if (validInput == true) {
        		OperatorControl op = new OperatorControl();
            	String nameTemp = tfMemNameAdd.getText();
            	String addTemp = tfMemAddressAdd.getText();        
            	String stateTemp = tfMemStateAdd.getText();
            	String zipTemp = tfMemZipAdd.getText();
            	String cityTemp = tfMemCityAdd.getText();
            	String idTemp = tfMemIDAdd.getText();
            	String statusTemp = tfMemStatusAdd.getText();
            	boolean statusTempBool = false;
            	int idTempInt = Integer.parseInt(idTemp);
            	if (statusTemp.equals("ACTIVE")) {
            		statusTempBool = true;
            	}
            	else {
            		statusTempBool = false;
            	}
            	
        		boolean add = op.addMember(nameTemp, addTemp, cityTemp, stateTemp, zipTemp, idTempInt, statusTempBool);
        		if (add == true) {
            		clearAddMemPanel();
            		taMemAddFeedback.setText("Member has been added");
        		}
        		else if (add == false) {
            		clearAddMemPanel();
            		taMemAddFeedback.setText("Member add failed :(");
        		}
        		
        	}
        }

        //Driver code for deleting member using operator control
        if(e.getSource() == buttonSubmitMemDel){
        	taMemDelFeedback.setText("");
        	searchMemNumAndDelete();	
        }
        
        //Driver code for populating text-fields with existing member info
        if (e.getSource() == buttonSearchMemUpdate) {
        	memUpdateSearch = searchMemNumAndPopulate();
        	if (memUpdateSearch == true) {
        		memUpdateOldID = tfMemIDUpdate.getText();
        	}
        	
        }
        
        //Driver code for taking input from existing member and updating it using operator controller
        if(e.getSource() == buttonSubmitMemUpdate) {
        	
        	if(memUpdateSearch == true) {
            	OperatorControl op = new OperatorControl();
            	String updateName = tfMemNameUpdate.getText();
            	String updateAdd = tfMemAddressUpdate.getText();
            	String updateCity = tfMemCityUpdate.getText();
            	String updateState = tfMemStateUpdate.getText();
            	String updateZip = tfMemZipUpdate.getText();
            	String updateNewId = tfMemIDUpdate.getText();
            	String updateStatus = tfMemStatusUpdate.getText();
            	
            	boolean newStatus = false;
            	if(updateStatus.equals("ACTIVE")) {
            		newStatus = true;
            	}
            	else if (updateStatus.equals("SUSPENDED")) {
            		newStatus = false;
            	}
            	
            	int oldID = Integer.parseInt(memUpdateOldID);
            	int newID = Integer.parseInt(updateNewId);
            	
            	boolean update = op.updateMemberInfo(oldID, updateName, updateAdd, updateCity, updateState, updateZip, newID, newStatus);
            	
            	if (update == true) {
            		clearUpdateMemPanel();
            		taMemUpdateFeedback.setText("Provider has been updated");
            	}
            	else if (update == false) {
            		clearUpdateMemPanel();
            		taMemUpdateFeedback.setText("Provider Update Failed");
            	}
        	}
        	
        	
        	
        }
        
        
        //Driver Code for interaction of adding Provider between interface and operator controller
        if (e.getSource() == buttonSubmitProAdd) {
        	taProAddFeedback.setText("");
        	boolean validInput = checkAddProInput();
        	if (validInput == true) {
        		OperatorControl op = new OperatorControl();
            	String nameTemp = tfProNameAdd.getText();
            	String addTemp = tfProAddressAdd.getText();        
            	String stateTemp = tfProStateAdd.getText();
            	String zipTemp = tfProZipAdd.getText();
            	String cityTemp = tfProCityAdd.getText();
            	String idTemp = tfProIDAdd.getText();
            	String statusTemp = tfProStatusAdd.getText();
            	boolean statusTempBool = false;
            	int idTempInt = Integer.parseInt(idTemp);
            	if (statusTemp.equals("ACTIVE")) {
            		statusTempBool = true;
            	}
            	else {
            		statusTempBool = false;
            	}
            	
        		boolean add = op.addProvider(nameTemp, addTemp, cityTemp, stateTemp, zipTemp, idTempInt, statusTempBool);
        		if (add == true) {
            		clearAddProPanel();
            		taProAddFeedback.setText("Provider has been added");
        		}
        		else if (add == false) {
            		clearAddProPanel();
            		taProAddFeedback.setText("Provider add failed :(");
        		}
        		
        	}
        }
        
        //Driver code for deleting provider using operator control
        if(e.getSource() == buttonSubmitProDel) {
        	taProDelFeedback.setText("");
        	searchProNumAndDelete();
        }
        
        //Driver code for populating text-fields with existing provider info
        if(e.getSource() == buttonSearchProUpdate) {
        	proUpdateSearch = searchProNumAndPopulate();
        	if (proUpdateSearch == true) {
        		proUpdateOldID = tfProIDUpdate.getText();
        	}
        }
        
        //Driver code for taking input on existing provider and updating it using operator controller
        if (e.getSource() == buttonSubmitProUpdate) {
        	
        	if(proUpdateSearch == true) {
            	OperatorControl op = new OperatorControl();
            	String updateName = tfProNameUpdate.getText();
            	String updateAdd = tfProAddressUpdate.getText();
            	String updateCity = tfProCityUpdate.getText();
            	String updateState = tfProStateUpdate.getText();
            	String updateZip = tfProZipUpdate.getText();
            	String updateNewId = tfProIDUpdate.getText();
            	String updateStatus = tfProStatusUpdate.getText();
            	
            	boolean newStatus = false;
            	if(updateStatus.equals("ACTIVE")) {
            		newStatus = true;
            	}
            	else if (updateStatus.equals("SUSPENDED")) {
            		newStatus = false;
            	}
            	
            	int oldID = Integer.parseInt(proUpdateOldID);
            	int newID = Integer.parseInt(updateNewId);
            	
            	boolean update = op.updateProviderInfo(oldID, updateName, updateAdd, updateCity, updateState, updateZip, newID, newStatus);
            	
            	if (update == true) {
            		clearUpdateProPanel();
            		taProUpdateFeedback.setText("Member has been updated");
            	}
            	else if (update == false) {
            		clearUpdateProPanel();
            		taProUpdateFeedback.setText("Member Update Failed");
            	}
        	}
        }
        
        
    }
}
