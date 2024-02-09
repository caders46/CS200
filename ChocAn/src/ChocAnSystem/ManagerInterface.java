package ChocAnSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Manager Interface Class. Creates the GUI and interface that the Manager user will see.
 * Creates and Instance of the manager operator and calls that to implement the functionality of the required tasks.
 * 
 * @author Ben Geary
 * @version 1.0
 *
 */
public class ManagerInterface implements ActionListener {
    private JButton buttonLogout;
    private JFrame frameManager;
    private JPanel panelManOpt;
    private JCheckBox chbxEFTReport;
    private JCheckBox chbxAPReport;
    private JCheckBox chbxProReport;
    private JCheckBox chbxCustReport;
    private JButton buttonGenerate;
    private JLabel labelManager;
    
    private ManagerControl manager = new ManagerControl();

    
    /**
     * Constructor. Creates an instance of the Manager Interface class with all components and panels
     * 
     * @author Ben Geary
     * @version 1.0
     */
    public ManagerInterface(){

        //Creating Option Panel for left side of frame
        panelManOpt = new JPanel();
        panelManOpt.setLayout(null);
        panelManOpt.setBounds(0,0,500,800);
        panelManOpt.setBackground(new Color(112, 107, 107));

        //Creating checkboxes for option panel
        chbxEFTReport = new JCheckBox("Generate EFT Report");
        chbxAPReport = new JCheckBox("Generate Accounts Payable Report");
        chbxCustReport = new JCheckBox("Generate Customer Reports");
        chbxProReport = new JCheckBox("Generate Provider Reports");

        //Formatting Report Checkboxes
        chbxEFTReport.setBounds(100,200,250,30);
        chbxAPReport.setBounds(100,280,250,30);
        chbxProReport.setBounds(100,360,250,30);
        chbxCustReport.setBounds(100, 440, 250,30);

        //Creating and formatting generate button
        buttonGenerate = new JButton("Generate Reports");
        buttonGenerate.setBounds(100,600, 300,80);
        buttonGenerate.addActionListener(this);

        //Creating and formatting Manager Label
        labelManager = new JLabel("Manager Menu");
        labelManager.setFont(new Font("Times New Roman", Font.BOLD, 40));
        labelManager.setBounds(100,100,400,50);
        labelManager.setForeground(new Color(0, 0, 0));


        panelManOpt.add(chbxEFTReport);
        panelManOpt.add(chbxAPReport);
        panelManOpt.add(chbxProReport);
        panelManOpt.add(chbxCustReport);
        panelManOpt.add(buttonGenerate);
        panelManOpt.add(labelManager);

        //Creating and formatting logout button
        buttonLogout = new JButton("Logout");
        buttonLogout.setBounds(650, 20, 100, 30);
        buttonLogout.addActionListener(this);

        frameManager = new JFrame();
        frameManager.setLayout(null);
        frameManager.setSize(800,800);
        frameManager.setLocationRelativeTo(null);
        frameManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameManager.add(panelManOpt);
        //frameManager.add(tempLabel);
        frameManager.add(buttonLogout);
        frameManager.setVisible(true);
    }

    /**
     * The primary driver of the software. Takes any action of the user and calls the manager controller
     * to perform the action. Uses ActionListener to get the button clicks and then checks what the user has selected
     * 
     * @author Ben Geary
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonLogout){
            LoginInterface loginInterface = new LoginInterface();
            frameManager.dispose();
        }
        else if (e.getSource() == buttonGenerate) {
        	boolean eft = false;
        	boolean ap = false;
        	boolean pro = false;
        	boolean cust = false;
            if (chbxEFTReport.isSelected()){
                //TODO Add manager control class call (EFT REPORT)
            	eft = true;
                System.out.println("EFT Report Selected");
            }
            if(chbxAPReport.isSelected()){
                //TODO Add manager control class call (AP REPORT)
            	ap = true;
                System.out.println("AP Report Selected");
            }
            if (chbxProReport.isSelected()){
                //TODO Add manager control class call (PROVIDER REPORT)
            	pro = true;
                System.out.println("Provider Report Selected");
            }
            if (chbxCustReport.isSelected()){
                //TODO Add manager control class call (CUSTOMER REPORT)
            	cust = true;
                System.out.println("Customer Report Selected");
            }
            
            boolean validGen = manager.generateReportsManager(eft, ap, pro, cust);
            System.out.println(validGen);

            chbxEFTReport.setSelected(false);
            chbxAPReport.setSelected(false);
            chbxProReport.setSelected(false);
            chbxCustReport.setSelected(false);

        }
    }
}
