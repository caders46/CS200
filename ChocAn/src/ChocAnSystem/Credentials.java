package ChocAnSystem;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Credentials Class. Creates the Valid User list.
 * Allows operators to add providers and managers, and allows the login to check a username and password with existing valid users.
 * 
 * @author Cade Dees
 * @version 1.0
 * 
 */
public class Credentials {
	ArrayList<ValidUser> validUserList;
	
	/*
	 * ADD AddValidUser TO CLASS DIAGRAM
	 */
	
	
	/**
	 * Constructor. Creates and instance of the Credentials class and populates the ArrayList from the credentials.txt
	 * 
	 * @author Cade Dees & Ben Geary
	 * 
	 */
	public Credentials(){
		validUserList = new ArrayList<ValidUser>();
		
		//CHANGE FILE PATH TO YOUR OWN WHEN TESTING
		File credentialFile = new File("C:\\Users\\caded\\git\\spring23team9\\src\\ChocAnSystem\\credentials.txt");
        try {
	        Scanner scn = new Scanner(credentialFile);

	        while(scn.hasNextLine()){
	            String in = scn.nextLine();
	            String[] temp = in.split("~");
	            ValidUser newUser = new ValidUser(temp[2], temp[0], temp[1]);
	            validUserList.add(newUser);
	        }
	        
	        scn.close();
        } catch (Exception e) {
        	System.out.println("Exception thrown:\n" + e);
        }
	}
	
	/**
	 * Method to add a ValidUser object to the validUserList ArrayList.
	 * 
	 * @author Cade Dees
	 * @return No return type.
	 * @version 1.0
	 */
	public void addValidUser(String type, String name, String pass) {
		ValidUser newUser = new ValidUser(type, name, pass);
		validUserList.add(newUser);
	}
	
	/**
	 * Method to verify given credentials with the records in the validUserList.
	 * 
	 * @author Cade Dees
	 * @return String
	 * @version 1.0
	 */
	public String verifyCreds(String username, String password) {
		for(int i = 0; i < validUserList.size(); i++) {
			if(validUserList.get(i).getName().equals(username)) {
				if(validUserList.get(i).checkPass(password)) {
					return validUserList.get(i).getUserType();
				}
			}
		}
		return "";
	}
}
