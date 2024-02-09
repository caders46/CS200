package ChocAnSystem;

/**
 * 
 * The Provider class is an entity class that creates a Provider object. This holds the crucial information for each Provider which includes
 * name, address, city, state, zip, ID, and status.
 * 
 * @author Sam Risner
 * @version 1.0
 *
 */
public class Provider {
	private String proName;
	private String proAddress;
	private String proCity;
	private String proState;
	private String proZip;
	private int proIDNum;
	private boolean proStatus;
	
	/**
	 * This is the primary constructor method for Provider class. Calling this creates a Provider object with the passed in values.
	 * @author Sam Risner
	 * @return No actual return value, but constructor returns a new instance of the Provider object.
	 * 
	 * @param name
	 * @param address
	 * @param city
	 * @param state
	 * @param zip
	 * @param ID
	 * @param status
	 * 
	 * @version 1.0
	 */
	public Provider(String name, String address, String city, String state, String zip, int ID, boolean status) {
		proName = name;
		proAddress = address;
		proCity = city;
		proState = state;
		proZip = zip;
		proIDNum = ID;
		proStatus = status;
	}
	
	/**
	 * Method to return the name of a Provider object
	 * 
	 * @author Sam Risner
	 * @return Returns the name of the Provider object
	 * @version 1.0
	 */
	public String getName() {
		return proName;
	}
	
	/**
	 * Method to set the name of a Provider object
	 * 
	 * @author Sam Risner
	 * @param name
	 * @return No return type
	 * @version 1.0
	 */
	public void setName(String name) {
		proName = name;
	}
	
	/**
	 * Method to return the address of a Provider object
	 * 
	 * @author Sam Risner
	 * @return Returns the address of the Provider object
	 * @version 1.0
	 */
	public String getAddress() {
		return proAddress;
	}
	
	/**
	 * Method to set the address of a Provider object
	 * 
	 * @author Sam Risner
	 * @param address
	 * @return No return type
	 * @version 1.0
	 */
	public void setAddress(String address) {
		if (address.equals("")) {
			throw new IllegalArgumentException();
		}
		proAddress = address;
	}
	
	/**
	 * Method to return the city of a Provider object
	 * 
	 * @author Sam Risner
	 * @return Returns the city of the Provider object
	 * @version 1.0
	 */
	public String getCity() {
		return proCity;
	}
	
	/**
	 * Method to set the city of a Provider object
	 * 
	 * @author Sam Risner
	 * @param city
	 * @return No return type
	 * @version 1.0
	 */
	public void setCity(String city) {
		proCity = city;
	}
	
	/**
	 * Method to return the state of a Provider object
	 * 
	 * @author Sam Risner
	 * @return Returns the state of a Provider object
	 * @version 1.0
	 */
	public String getState() {
		return proState;
	}
	
	/**
	 * Method to set the state of a Provider object
	 * 
	 * @author Sam Risner
	 * @param state
	 * @return No return type
	 * @version 1.0
	 */
	public void setState(String state) {
		if (state.equals("")) {
			throw new IllegalArgumentException();
		}
		proState = state;
	}
	
	/**
	 * Method to return the Zip Code of a Provider object
	 * 
	 * @author Sam Risner
	 * @return Returns the Zip Code of a Provider object
	 * @version 1.0
	 */
	public String getZip() {
		return proZip;
	}
	
	/**
	 * Method to set the Zip Code of a Provider object
	 * 
	 * @author Sam Risner
	 * @param zip
	 * @return No return type
	 * @version 1.0
	 */
	public void setZip(String zip) {
		if (zip.equals("")) {
			throw new IllegalArgumentException();
		}
		proZip = zip;
	}
	
	/**
	 * Method to return the ID of a Provider object
	 * 
	 * @author Sam Risner
	 * @return Returns the ID of a Provider object
	 * @version 1.0
	 */
	public int getIDNum() {
		return proIDNum;
	}
	
	/**
	 * Method to set the ID of a Provider object
	 * 
	 * @author Sam Risner
	 * @param ID
	 * @return No return type
	 * @version 1.0
	 */
	public void setIDNum(int ID) {
		proIDNum = ID;
	}
	
	/**
	 * Method to return the status of a Provider object
	 * 
	 * @author Sam Risner
	 * @return Returns the status of a Provider object
	 * @version 1.0
	 */
	public boolean getStatus() {
		return proStatus;
	}
	
	/**
	 * Method to set the status of a Provider Object
	 * 
	 * @author Sam Risner
	 * @param status
	 * @return No return type
	 * @version 1.0
	 */
	public void setStatus(boolean status) {
		proStatus = status;
	}
	
	/**
	 * Method to print out all the information of a Provider object
	 * 
	 * @author Sam Risner
	 * @return No return type
	 * @version 1.0
	 */
	public void print() {
	    System.out.println("Name: " + proName);
	    System.out.println("Address: " + proAddress);
	    System.out.println("City: " + proCity);
	    System.out.println("State: " + proState);
	    System.out.println("Zip: " + proZip);
	    System.out.println("ID Number: " + proIDNum);
	    
	    if (proStatus) {
	    	System.out.println("Status: Active");
	    } else {
	    	System.out.println("Status: Inactive");
	    }
	}
}
