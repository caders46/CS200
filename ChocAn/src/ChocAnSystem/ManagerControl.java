package ChocAnSystem;

/**
 * 
 * The ManagerControl class is an controller class that allows the manager to interact with entity classes. This holds the crucial functions each Manager can do including
 * generating reports and notifying the user.
 * 
 * @author Sam Risner
 * @version 1.0
 *
 */
public class ManagerControl {
	private WeeklyData weekly;
	/**
	 * This is the primary constructor method for ManagerControl class.
	 * @author Sam Risner
	 * @return No actual return value, but constructor returns a new instance of the ManagerControl object.
	 * 
	 * @version 1.0
	 */
	public ManagerControl() {
		weekly = new WeeklyData();
	};
	
	/**
	 * Method to print generate the selected reports that the Manager selects
	 * @author Sam Risner
	 * @param EFT
	 * @param AP
	 * @param Pro
	 * @param Cust
	 * @return Returns a boolean to determine whether selected reports are successfully printed.
	 * 
	 * @version 1.0
	 */
	public boolean generateReportsManager(boolean EFT, boolean AP, boolean Pro, boolean Cust) {
		if (EFT) {
			if (weekly.genEFTRep() == false) {
				return false;
			}
		}
		
		if(AP) {
			if (weekly.genAPRep() == false) {
				return false;
			}
		}
		
		if (Pro) {
			if (weekly.genProRep() == false) {
				return false;
			}
		}
		
		if (Cust) {
			if (weekly.genCustRep() == false) {
				return false;
			}
		}
		
		return true;
	}
}
