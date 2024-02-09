package ChocAnSystem;
public class Member {

	/**
	 * This part of the class creates the Member. It will include the member
	 *  name, address, address, city, state, zip code , and the status
	 * 
	 * @author Kemberlyn Milner
	 * @version 1.1 
	 */
	private String memName;
	private String memAddress;
	private String memCity;
	private String memState;
	private String memZip;
	private int memIDNum;
	private boolean memStatus;

	
	/** 
	 * This part of the class is the main/primary constructor. It will be used to set the appropriate member values
	 * 
	 * @author Kemberlyn Milner
	 * @return No return value
	 * 
	 * @param name
	 * @param address
	 * @param city
	 * @param state
	 * @param zipCode
	 * @param iD
	 * @param status
	 * 
	 * @version 1.1
	 */
	public Member (String name, String address, String city, String state, String zipCode, int iD, boolean status) {
		memName = name;
		memAddress = address;
		memCity = city;
		memState = state;
		memZip = zipCode;
		memIDNum = iD;
		memStatus = status;
	}

	/**
	 * @author Kemberlyn Milner
	 * @param Setting the member's name of the Member class
	 * 
	 * @version 1.1
	 */
	public void setMemName(String name) {
		memName = name;
	}
	
	/**
	 * @author Kemberlyn Milner
	 * @param Setting the member's address of the Member class
	 * 
	 * @version 1.1
	 */	
	public void setMemAddress(String addyName) {
		memAddress = addyName;
	}
	
	/**
	 * @author Kemberlyn Milner
	 * @param Setting the member's city of the Member class
	 * 
	 * @version 1.1
	 */
	public void setMemCity (String cityName) {
		memCity = cityName;
	}
	
	/**
	 * @author Kemberlyn Milner
	 * @param Setting the member's state of the Member class
	 * 
	 * @version 1.1
	 */
	public void setMemState(String stateName) {
		memState = stateName;
	}
	
	/**
	 * @author Kemberlyn Milner
	 * @param Setting the member's zip code of the Member class
	 * 
	 * @version 1.1
	 */
	public void setMemZip (String zipCode) {
		memZip = zipCode;
	}
	
	/**
	 * @author Kemberlyn Milner
	 * @param Setting the member's ID number of the Member class
	 * 
	 * @version 1.1
	 */
	public void setMemIDNum(int iDNum) {
		memIDNum = iDNum;
	}
	
	/**
	 * @author Kemberlyn Milner
	 * @param Setting the member's status of the Member class
	 * 
	 * @version 1.1
	 */
	public void setMemStatus (boolean memActive) {
		memStatus = memActive;
	}
	
	/**
	 * 
	 * @author Kemberlyn Milner
	 * @return Returning the member's name of the Member Class
	 * 
	 * @version 1.1
	 */
	public String getMemName() {
		return memName;
	}

	/**
	 * 
	 * @author Kemberlyn Milner
	 * @return Returning the member's address of the Member Class
	 * 
	 * @version 1.1
	 */
	public String getMemAddress() {
		return memAddress;
	}
	
	/**
	 * 
	 * @author Kemberlyn Milner
	 * @return Returning the member's city of the Member Class
	 * 
	 * @version 1.1
	 */
	public String getMemCity() {
		return memCity;
	}

	/**
	 * 
	 * @author Kemberlyn Milner
	 * @return Returning the member's state of the Member Class
	 * 
	 * @version 1.1
	 */
	public String getMemState() {
		return memState;
	}

	/**
	 * 
	 * @author Kemberlyn Milner
	 * @return Returning the member's zipcode of the Member Class
	 * 
	 * @version 1.1
	 */
	public String getMemZip() {
		return memZip;
	}
	
	/**
	 * 
	 * @author Kemberlyn Milner
	 * @return Returning the member's ID num of the Member Class
	 * 
	 * @version 1.1
	 */
	public int getMemIDNum() {
		return memIDNum;
	}
	
	/**
	 * 
	 * @author Kemberlyn Milner
	 * @return Returning the member's status of the Member Class
	 * 
	 * @version 1.1
	 */
	
	public boolean getMemStatus() {
		return memStatus;
	}
	
	/**
	 * This part of the Member class will print the name, address, city,
	 * state, ID number, and status 
	 * 
	 * @author Kemberlyn Milner
	 * @return will not return, but will print the Member class information
	 * 
	 * @version 1.1
	 */	
	public void printMem() {
		System.out.println("Name: " + memName);
		System.out.println("Address: " + memAddress);
		System.out.println("City: " + memCity);
		System.out.println("State " + memState);
		System.out.println("ID Number: " + memIDNum);
		if(memStatus) {
			System.out.println("Status: Active");
		}
		else {
			System.out.println("Status: Inactive");
		}
	}
}
