package ChocAnSystem;

/**
 * Valid User Class. Creates accounts for all users: Operators, Managers, and Providers.
 * Used by the Credentials class and stored in the Valid User List. Used for logging in (checking passwords) and adding new accounts.
 * 
 * @author Cade Dees
 * @version 1.0
 * 
 */
public class ValidUser {
	//userType for providers will be their provider number. Otherwise it is a traditional username.
	String userType;
	String username;
	String password;
	
	/**
	 * This is the primary constructor method for ValidUser class. Calling this creates a ValidUser object with the passed in values.
	 * @author Cade Dees
	 * @return No actual return value, but constructor returns a new instance of the ValidUser object.
	 * 
	 * @param uT
	 * @param us
	 * @param pw
	 * 
	 * @version 1.0
	 */
	public ValidUser(String uT, String us, String pw) {
		userType = uT;
		username = us;
		password = pw;
		if (uT == "" || us == "" || pw == "") {
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * Method to get the userType of a ValidUser object
	 * 
	 * @author Cade Dees
	 * @return String
	 * @version 1.0
	 */
	public String getUserType() {
		return userType;
	}
	
	/**
	 * Method to get the username of a ValidUser object
	 * 
	 * @author Cade Dees
	 * @return String
	 * @version 1.0
	 */
	public String getName() {
		return username;
	}
	
	/**
	 * Method to check the password of a ValidUser object with a given password attempt.
	 * 
	 * @author Cade Dees
	 * @return boolean
	 * @version 1.0
	 */
	public boolean checkPass(String passwordEntry) {
		if(passwordEntry.equals(password)) {
			return true;
		}
		return false;
	}
	
}
