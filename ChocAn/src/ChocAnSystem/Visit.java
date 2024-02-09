package ChocAnSystem;


/**
 * The visit class is an entity class that creates a Visit object. This holds the crucial information for each visit which includes
 * date, time, provider number, member number, service code, and any comments.
 * 
 * @author Ben Geary
 * @version 1.0
 */
public class Visit {
	private String servDate;
	private String currDate;
	private String currTime;
	private int providerNum;
	private int memberNum;
	private int servCode;
	private String comments;
	
	
	/**
	 * This is the primary constructor method for Visit class. Calling this creates a Visit object with the passed in values.
	 * 
	 * @author Ben Geary
	 * @return No actual return value, but constructor returns a new instance of the Visit object.
	 * @param timeIn
	 * @param providerNumIn
	 * @param memberNumIn
	 * @param servCodeIn
	 * @param commentsIn
	 * 
	 * @version 1.0
	 */
	public Visit(String currTimeIn, String servDateIn, String currDateIn, int providerNumIn, int memberNumIn, int servCodeIn, String commentsIn) {
	
		currTime = currTimeIn;
		servDate = servDateIn;
		currDate = currDateIn;
		providerNum = providerNumIn;
		memberNum = memberNumIn;
		servCode = servCodeIn;
		comments = commentsIn;
		
	}
	
	
	/**
	 * Method to return the service date from the visit object
	 * 
	 * @author Ben Geary
	 * @return the service date of the visit object
	 * 
	 */
	public String getServDate() {
		return servDate;
	}
	
	
	/**
	 * Method to return the current date from a Visit object
	 * 
	 * @author Ben Geary
	 * @return Returns the current date of the Visit object
	 * @version 1.0
	 */
	public String getCurrDate() {
		return currDate;
	}
	
	/**
	 * Method to return the current time from the visit object
	 * 
	 * @author Ben Geary
	 * @return Returns the current time of the Visit object
	 * @version 1.0
	 */
	public String getCurrTime() {
		return currTime;
	}
	
	/**
	 * Method to return the provider num from the visit object
	 * 
	 * @author Ben Geary
	 * @return Returns the providerNum of the Visit object
	 * @version 1.0
	 */
	public int getProviderNum() {
		return providerNum;
	}
	
	/**
	 * Method to return the member num from the visit object
	 * 
	 * @author Ben Geary
	 * @return Returns the memberNum of the Visit object
	 * @version 1.0
	 */
	public int getMemberNum() {
		return memberNum;
	}
	
	/**
	 * Method to return the service code from the visit object
	 * 
	 * @author Ben Geary
	 * @return Returns the servCode of the Visit object
	 * @version 1.0
	 */
	public int getServCode() {
		return servCode;
	}
	
	/**
	 * Method to return the comments from the visit object
	 * 
	 * @author Ben Geary
	 * @return Returns the comments of the Visit object
	 * @version 1.0
	 */
	public String getComments() {
		return comments;
	}
}
