package ChocAnSystem;

public class Timer {
	
	public Timer() {}
	
	public static boolean runAccountingProcedure() {
		ManagerControl mngProv = new ManagerControl();
		return mngProv.generateReportsManager(true, true, true, true);
		
	}
}
