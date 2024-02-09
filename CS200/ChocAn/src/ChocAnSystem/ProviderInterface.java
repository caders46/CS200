package ChocAnSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

/**
 * Provider Interface Class. Creates the GUI and interface for the Provider User. Creates an instance of the Provider
 * controller and calls that to implement the functionality of the required tasks.
 * 
 * @author Ben Geary
 * @Version 1.0
 */
public class ProviderInterface implements ActionListener {

    private JFrame frameProvider;
    private JButton buttonLogout;

    //Creating the globals for the options panel and all its components
    private JPanel panelOptions;
    private JButton buttonReqProDir, buttonBillHealth, buttonVerifyMem;
    private JLabel labelProvider;

    //Creating the globals for the input panels
    private JPanel panelInputReqDir, panelInputBillHealth, panelInputVerifyMem;
    private JLabel labelReqDir, labelBillHealth, labelVerifyMem;

    //Creating Request Provider Directory Specific Components
    private JTextArea taReqDir;

    //Creating Bill Healthcare Specific Components
    private JLabel labelMemNum, labelServCode, labelCurrDate, labelCurrTime, labelProNum, labelServDate, labelComments;
    private JTextField tfMemNum, tfServCode, tfCurrDate, tfCurrTime, tfProNum, tfServDate;
    private JTextArea taMemFeedback, taServCodeFeedback, taOverallFeedback, taComments;
    private JButton buttonMemSearch, buttonServCodeSearch, buttonBillService;

    //Creating Verify Member Specific Components
    private JLabel labelVerifyMemNum;
    private JTextField tfVerifyMemNum;
    private JTextArea taVerifyMemNum;
    private JButton buttonVerifyMemNum;
    
    //Creating global flags for bill healthcare process
    private boolean validMem = false;
    private boolean validServCode = false;


    /**
     * Constructor. Creates an instance of the Provider Interface with all components and panels
     *
     * @author Ben Geary
     */
    public ProviderInterface(){

        //Creating and formatting option panel
        panelOptions = new JPanel();
        panelOptions.setLayout(null);
        panelOptions.setBounds(0,0,450,800);
        panelOptions.setBackground(new Color(112,107,107));

        //Creating and formatting options buttons
        buttonReqProDir = createOptButton("Request Provider Directory", 55,200,350,50);
        buttonReqProDir.addActionListener(this);
        buttonVerifyMem = createOptButton("Verify Member", 130,275,200,50);
        buttonVerifyMem.addActionListener(this);
        buttonBillHealth = createOptButton("Bill for Services", 130, 350, 200, 50);
        buttonBillHealth.addActionListener(this);

        //Creating Provider Label and formatting it in the Options Panel
        labelProvider = new JLabel("Provider Menu");
        labelProvider.setFont(new Font("Times New Roman", Font.BOLD, 40));
        labelProvider.setBounds(100,75,400,50);
        labelProvider.setForeground(new Color(0, 0, 0));

        //Creating and formatting logout button
        buttonLogout = new JButton("Logout");
        buttonLogout.setBounds(1050, 10, 100, 30);
        buttonLogout.addActionListener(this);

        //Creating and formatting Input Panels. See functions for further explanation
        reqProDirPanelCreat();
        billHealthPanelCreate();
        verifyMemPanelCreate();


        //Adding Components to Options Panel
        panelOptions.add(buttonBillHealth);
        panelOptions.add(buttonReqProDir);
        panelOptions.add(buttonVerifyMem);
        panelOptions.add(labelProvider);


        //Creating and formatting provider frame
        frameProvider = new JFrame();
        frameProvider.setSize(1200,800);
        frameProvider.setLayout(null);
        frameProvider.setResizable(false);
        frameProvider.setLocationRelativeTo(null);
        frameProvider.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Adding Components to frame
        frameProvider.add(buttonLogout);
        frameProvider.add(panelOptions);
        frameProvider.add(panelInputBillHealth);
        frameProvider.add(panelInputReqDir);
        frameProvider.add(panelInputVerifyMem);

        frameProvider.setVisible(true);

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
     * This function creates the components for the Request Provider Directory Panel
     *
     * @author Ben Geary
     *
     */
    private void reqProDirPanelCreat(){

        //Creating Request Provider Directory Label and formatting it
        labelReqDir = new JLabel("Request Provider Directory");
        labelReqDir.setBounds(100,125,400,30);
        labelReqDir.setFont(new Font("Times New Roman", Font.BOLD, 30));

        //Creating Text area where provider directory will be displayed
        taReqDir = new JTextArea();
        taReqDir.setBounds(50,170,500,500);
        taReqDir.setEditable(false);


        //Creating Request Provider Directory Panel
        panelInputReqDir = new JPanel();
        panelInputReqDir.setLayout(null);
        panelInputReqDir.setBounds(500,0,700,800);
        panelInputReqDir.setBackground(new Color(245, 245, 245));

        //Adding Components to panel
        panelInputReqDir.add(labelReqDir);
        panelInputReqDir.add(taReqDir);

        panelInputReqDir.setVisible(false);


    }

    /**
     * This function creates the components for the Bill Healthcare Panel
     *
     * @author Ben Geary
     *
     */
    private void billHealthPanelCreate(){

        //Creating Bill Healthcare Label and formatting it
        labelBillHealth = new JLabel("Bill a Service");
        labelBillHealth.setBounds(100,95,400,30);
        labelBillHealth.setFont(new Font("Times New Roman", Font.BOLD, 30));

        //Creating Member search label, text-field, button, and feedback text-area
        labelMemNum = new JLabel("Member Number:");
        labelMemNum.setFont(new Font("Times New Roman", Font.BOLD, 15));
        labelMemNum.setBounds(75, 150, 200, 20);
        tfMemNum = new JTextField();
        tfMemNum.setBounds(200, 150, 125, 20);
        buttonMemSearch = new JButton("Search Member");
        buttonMemSearch.setBounds(350, 150, 125, 20);
        buttonMemSearch.addActionListener(this);
        taMemFeedback = new JTextArea();
        taMemFeedback.setBounds(500,135,150,50);
        taMemFeedback.setEditable(false);
        taMemFeedback.setBorder(BorderFactory.createTitledBorder("Feedback"));

        //Creating Service code search label, text-field, button, and feedback text-area
        labelServCode = new JLabel("Service Code:");
        labelServCode.setFont(new Font("Times New Roman", Font.BOLD, 15));
        labelServCode.setBounds(75, 200, 200, 20);
        tfServCode = new JTextField();
        tfServCode.setBounds(180, 200, 125, 20);
        buttonServCodeSearch = new JButton("Search Service Code");
        buttonServCodeSearch.setBounds(320, 200, 170, 20);
        buttonServCodeSearch.addActionListener(this);
        taServCodeFeedback = new JTextArea();
        taServCodeFeedback.setBounds(320,225,300,75);
        taServCodeFeedback.setEditable(false);
        taServCodeFeedback.setBorder(BorderFactory.createTitledBorder("Feedback"));

        //Creating current date label and text-field
        labelCurrDate = new JLabel("Current Date (MM-DD-YYYY):");
        labelCurrDate.setFont(new Font("Times New Roman", Font.BOLD, 15));
        labelCurrDate.setBounds(75, 350, 400, 20);
        tfCurrDate = new JTextField();
        tfCurrDate.setBounds(300, 350, 100,20);

        //Creating current time label and text-field
        labelCurrTime = new JLabel("Current Time (HH:MM:SS):");
        labelCurrTime.setFont(new Font("Times New Roman", Font.BOLD, 15));
        labelCurrTime.setBounds(75, 380, 400, 20);
        tfCurrTime = new JTextField();
        tfCurrTime.setBounds(300, 380, 100,20);

        //Creating date of service label and text-field
        labelServDate = new JLabel("Service Date (MM-DD-YYYY):");
        labelServDate.setFont(new Font("Times New Roman", Font.BOLD, 15));
        labelServDate.setBounds(75, 410, 400, 20);
        tfServDate = new JTextField();
        tfServDate.setBounds(300, 410, 100,20);

        //Creating provider number label and text-field
        labelProNum = new JLabel("Provider Number:");
        labelProNum.setFont(new Font("Times New Roman", Font.BOLD, 15));
        labelProNum.setBounds(75, 440, 400, 20);
        tfProNum = new JTextField();
        tfProNum.setBounds(300, 440, 100,20);

        //Creating comments label and text-area
        labelComments = new JLabel("Comments:");
        labelComments.setFont(new Font("Times New Roman", Font.BOLD, 15));
        labelComments.setBounds(75, 470, 300, 20);
        taComments = new JTextArea();
        taComments.setBounds(75, 500, 400, 100);

        //Creating bill service button
        buttonBillService = new JButton("Bill Service");
        buttonBillService.setBounds(75, 650, 150, 40);
        buttonBillService.addActionListener(this);


        //Creating overall feedback text-area
        taOverallFeedback = new JTextArea();
        taOverallFeedback.setBounds(400, 650, 200, 75);
        taOverallFeedback.setEditable(false);
        taOverallFeedback.setBorder(BorderFactory.createTitledBorder("Feedback"));



        //Creating Bill Healthcare Panel
        panelInputBillHealth = new JPanel();
        panelInputBillHealth.setLayout(null);
        panelInputBillHealth.setBounds(500,0,700,800);
        panelInputBillHealth.setBackground(new Color(245, 245, 245));

        //Adding components to bill healthcare panel
        panelInputBillHealth.add(labelBillHealth);
        panelInputBillHealth.add(labelMemNum);
        panelInputBillHealth.add(tfMemNum);
        panelInputBillHealth.add(buttonMemSearch);
        panelInputBillHealth.add(taMemFeedback);
        panelInputBillHealth.add(labelServCode);
        panelInputBillHealth.add(buttonServCodeSearch);
        panelInputBillHealth.add(tfServCode);
        panelInputBillHealth.add(taServCodeFeedback);
        panelInputBillHealth.add(labelCurrDate);
        panelInputBillHealth.add(tfCurrDate);
        panelInputBillHealth.add(labelCurrTime);
        panelInputBillHealth.add(tfCurrTime);
        panelInputBillHealth.add(labelServDate);
        panelInputBillHealth.add(tfServDate);
        panelInputBillHealth.add(labelProNum);
        panelInputBillHealth.add(tfProNum);
        panelInputBillHealth.add(labelComments);
        panelInputBillHealth.add(taComments);
        panelInputBillHealth.add(buttonBillService);
        panelInputBillHealth.add(taOverallFeedback);

        panelInputBillHealth.setVisible(false);
    }

    /**
     * This function creates the components for the Verify Member Panel
     *
     * @author Ben Geary
     *
     */
    private void verifyMemPanelCreate(){

        //Creating Verify Member Label and formatting it
        labelVerifyMem = new JLabel("Verify Member");
        labelVerifyMem.setBounds(100,125,400,30);
        labelVerifyMem.setFont(new Font("Times New Roman", Font.BOLD, 30));

        //Creating verify member number label, text-field, button, and feedback text-area
        labelVerifyMemNum = new JLabel("Member Number:");
        labelVerifyMemNum.setBounds(75, 200, 150, 20);
        labelVerifyMemNum.setFont(new Font("Times New Roman", Font.BOLD, 15));
        tfVerifyMemNum = new JTextField();
        tfVerifyMemNum.setBounds(200, 200, 200, 20);
        buttonVerifyMemNum = new JButton("Search Member");
        buttonVerifyMemNum.setBounds(450, 200, 150, 20);
        buttonVerifyMemNum.addActionListener(this);
        taVerifyMemNum = new JTextArea();
        taVerifyMemNum.setBounds(200, 250, 250, 75);
        taVerifyMemNum.setEditable(false);
        taVerifyMemNum.setBorder(BorderFactory.createTitledBorder("Feedback"));

        //Creating Verify Member Panel
        panelInputVerifyMem = new JPanel();
        panelInputVerifyMem.setLayout(null);
        panelInputVerifyMem.setBounds(500,0,700,800);
        panelInputVerifyMem.setBackground(new Color(245, 245, 245));

        //Adding components to Verify Member panel
        panelInputVerifyMem.add(labelVerifyMem);
        panelInputVerifyMem.add(labelVerifyMemNum);
        panelInputVerifyMem.add(tfVerifyMemNum);
        panelInputVerifyMem.add(buttonVerifyMemNum);
        panelInputVerifyMem.add(taVerifyMemNum);

        panelInputVerifyMem.setVisible(false);
    }

    /**
     * Clears the components in the Request Directory Panel when a different option is selected
     *
     * @author Ben Geary
     *
     */
    private void clearProReqDirPanel(){
        taReqDir.setText("");
    }

    /**
     * Clears the components in the Bill Healthcare Panel when a different option is selected
     * or when the submit button is clicked and a valid submission takes place
     *
     * @author Ben Geary
     *
     */
    private void clearBillHealthPanel(){
        tfMemNum.setText("");
        tfServCode.setText("");
        tfCurrDate.setText("");
        tfCurrTime.setText("");
        tfServDate.setText("");
        tfProNum.setText("");
        taComments.setText("");
        taMemFeedback.setText("");
        taServCodeFeedback.setText("");
        taOverallFeedback.setText("");
        validMem = false;
        validServCode = false;
    }

    /**
     * Clears the components in the Verify Member Panel when a different option is selected
     *
     * @author Ben Geary
     *
     */
    private void clearVerifyMemPanel(){
        tfVerifyMemNum.setText("");
        taVerifyMemNum.setText("");
    }
    
    /**
     * Helper function to search if the member num is valid, invalid, or suspended.
     * Sets the text-area depending on the results.
     * 
     * @author Ben Geary
     */
    private void searchMemNum() {
    	ProviderControl provider = new ProviderControl();
        String strTempNum = tfVerifyMemNum.getText();
        String validCheck = "";
        if (strTempNum.matches("\\d+")) {
        	if (strTempNum.length() == 9) {
        		int iTempNum = Integer.parseInt(strTempNum);
        		validCheck = provider.validateMember(iTempNum);
        	}
        	else {
        		taVerifyMemNum.setText("INVALID ENTRY");
        		return;
        	}
        	
        	
            if (validCheck == "VALID") {
            	taVerifyMemNum.setText("MEMBER IS VALID");
            }
            else if (validCheck == "SUSPENDED") {
            	taVerifyMemNum.setText("MEMBER IS SUSPENDED");
            }
            else if (validCheck == "INVALID") {
            	taVerifyMemNum.setText("MEMBER NUMBER IS INVALID");
            }
            else {
            	taVerifyMemNum.setText("SOMETHING FUCKED UP");
            }
            
        }
        else {
        	taVerifyMemNum.setText("INVALID ENTRY");
        }
    }

    
    /**
     * Helper function to search if the member num is valid, invalid, or suspended.
     * Sets the text-area in bill healthcare to display the results
     * 
     * @author Ben Geary
     */
    private boolean searchMemNumBillHealthcare() {
    	ProviderControl provider = new ProviderControl();
        String strTempNum = tfMemNum.getText();
        String validCheck = "";
        if (strTempNum.matches("\\d+")) {
        	if (strTempNum.length() == 9) {
        		int iTempNum = Integer.parseInt(strTempNum);
        		validCheck = provider.validateMember(iTempNum);
        	}
        	else {
        		taMemFeedback.setText("INVALID ENTRY");
        		return false;
        	}
        	
        	
            if (validCheck == "VALID") {
            	taMemFeedback.setText("MEMBER IS VALID");
            	return true;
            }
            else if (validCheck == "SUSPENDED") {
            	taMemFeedback.setText("MEMBER IS SUSPENDED");
            	return false;
            }
            else if (validCheck == "INVALID") {
            	taMemFeedback.setText("MEMBER NUMBER IS INVALID");
            	return false;
            }
            else {
            	taMemFeedback.setText("SOMETHING FUCKED UP");
            	return false;
            }
            
        }
        else {
        	taMemFeedback.setText("INVALID ENTRY");
        	return false;
        }
    }
    
    
    /**
     * Helper function to search if the servicen code is valid.
     * Sets the text-area in bill healthcare to display the results.
     * 
     * @author Ben Geary
     * @return A boolean is returned to indicate whether the service code is valid or not
     */
    private boolean searchServCode() {
    	ProviderControl provider = new ProviderControl();
    	ArrayList<String[]> tempList = provider.getDirectory();
    	String servCodeIn = tfServCode.getText();
    	
    	for (int i = 0; i < tempList.size(); i++) {
    		String[] temp = tempList.get(i);
    		String servCodeTemp = temp[0];
    		if (servCodeTemp.equals(servCodeIn)) {
    			String desc = temp[2];
    			taServCodeFeedback.setText(desc);
    			return true;
    		}
    	}
    	
    	taServCodeFeedback.setText("Service Code does NOT Exist");
    	return false;
    }
    
    
    /**
     * Helper function to verify that all inputs for the visit are formatted correctly
     * 
     * @author Ben Geary
     * @return Returns a boolean to indicate valid input or not
     */
    private boolean verifyVisitInput(){
    	String currDate = tfCurrDate.getText();
    	String currTime = tfCurrTime.getText();
    	String servDate = tfServDate.getText();
    	String comments = taComments.getText();
    	String proNum = tfProNum.getText();
    	
    	DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("MM-dd-uuuu");
    	DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm:ss");
    	
    	
    	//Checking the currDate format
    	try {
    		LocalDate currentDate = LocalDate.parse(currDate, formatterDate);
    	}
    	catch (DateTimeParseException e) {
    		taOverallFeedback.setText("Invalid Current Date Format");
    		System.out.println(e);
    		return false;
    	}
    	
    	//Checking the currTime format
    	try {
    		LocalTime currentTime = LocalTime.parse(currTime, formatterTime);
    	}
    	catch(DateTimeParseException e) {
    		taOverallFeedback.setText("Invalid Current Time Format");
    		System.out.println(e);
    		return false;
    	}
    	
    	//Checking the servDate format
    	try {
    		LocalDate serviceDate = LocalDate.parse(currDate, formatterDate);
    	}
    	catch (DateTimeParseException e) {
    		taOverallFeedback.setText("Invalid Service Date Format");
    		System.out.println(e);
    		return false;
    	}
    	
    	if (comments.length() > 100) {
    		taOverallFeedback.setText("Comments has too many characters");
    		return false;
    	}
    	
    	
    	if (proNum.matches("\\d+")) {
    		if(proNum.length() == 9) {
    			int iTempProNum = Integer.parseInt(proNum);
    			ProviderControl pro = new ProviderControl();
    			boolean validProNum = pro.validateProvider(iTempProNum);
    			
    			if (validProNum == false) {
    				taOverallFeedback.setText("Invalid Provider Number");
    				return false;
    			}
    		}
    		else {
				taOverallFeedback.setText("Invalid Provider Number");
				return false;
    		}
    	}
    	else {
    		taOverallFeedback.setText("Invalid Provider Number");
    		return false;
    	}
    	
    	return true;
    	
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonLogout){
            LoginInterface loginInterface = new LoginInterface();
            frameProvider.dispose();
        }
        if (e.getSource() == buttonReqProDir){
        	
        	//Clearing other panels and setting their visibility to false
            clearBillHealthPanel();
            clearVerifyMemPanel();
            panelInputBillHealth.setVisible(false);
            panelInputVerifyMem.setVisible(false);
            
            //Populating the text-area with the Provider Directory Data
            ProviderControl provider = new ProviderControl();
            String reqDirIn = "Service Code         Cost          Description \n";
            ArrayList<String[]> tempList = provider.getDirectory();
            for (int i = 0; i < tempList.size(); i++) {
            	String[] tempArr = tempList.get(i);
            	String tempServCode = tempArr[0];
            	String tempCost = tempArr[1];	
            	String tempDesc = tempArr[2];
            	
            	//Formatting tempCost so they are all the same size
            	if (tempCost.length() < 6) {
            		int k = 6 - tempCost.length();
            		for (int j = 0; j < k; j++) {
            			tempCost = tempCost + "  ";
            		}
            	}
            	
            	String tempCat = tempServCode + "                    " + tempCost + "      " + tempDesc + "\n";
            	reqDirIn = reqDirIn + tempCat;
            }
            
            taReqDir.setText(reqDirIn);
            
            panelInputReqDir.setVisible(true);
            
            
            
        }
        
        
        if (e.getSource() == buttonBillHealth){
            clearProReqDirPanel();
            clearVerifyMemPanel();
            panelInputReqDir.setVisible(false);
            panelInputVerifyMem.setVisible(false);
            panelInputBillHealth.setVisible(true);
        }
        
        
        if (e.getSource() == buttonVerifyMem){
            clearBillHealthPanel();
            clearProReqDirPanel();
            panelInputBillHealth.setVisible(false);
            panelInputReqDir.setVisible(false);
            panelInputVerifyMem.setVisible(true);
        }
        
        //Driver Code to search the member list and see if the member Number passed in is valid
        if (e.getSource() == buttonVerifyMemNum) {
        	taVerifyMemNum.setText("");
        	searchMemNum();
        }
        
        
        //Driver Code to search the member list and see if the member Number passed in is valid
        if (e.getSource() == buttonMemSearch) {
        	taMemFeedback.setText("");
        	validMem = searchMemNumBillHealthcare();
        }
        
        //Driver Code to search the provider directory and see if the service code passed in is valid
        if(e.getSource() == buttonServCodeSearch) {
        	taServCodeFeedback.setText("");
        	validServCode = searchServCode();
        }
        
        if (e.getSource() == buttonBillService) {
        	boolean validInput = verifyVisitInput();
        	
        	if (validInput == true && validMem == true && validServCode == true) {
            	String memNum = tfMemNum.getText();
            	String servCode = tfServCode.getText();
            	String currDate = tfCurrDate.getText();
            	String currTime = tfCurrTime.getText();
            	String servDate = tfServDate.getText();
            	String comments = taComments.getText();
            	String proNum = tfProNum.getText();
            	
            	if (comments.equals("")) {
            		comments = "No comment";
            	}
            	
            	int proNumInt = Integer.parseInt(proNum);
            	int memNumInt = Integer.parseInt(memNum);
            	int servCodeInt = Integer.parseInt(servCode);
            	
            	ProviderControl provider = new ProviderControl();
            	boolean validVisitEntry = provider.billHealthcare(currTime, servDate, currDate, proNumInt, memNumInt, servCodeInt, comments);
            	
            	if (validVisitEntry == true) {
            		clearBillHealthPanel();
            		taOverallFeedback.setText("Service has been Billed");
            	}
            	else if(validVisitEntry == false) {
            		clearBillHealthPanel();
            		taOverallFeedback.setText("Service failed to be billed");
            	}
        	}
        	
        }
        
    }
}