package ChocAnSystem;
//testChanges
import java.io.*;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * The Weekly Data class contains an ArrayList that holds all of the Visits in a week and functions to
 * output this data into several reports.
 * 
 * @author cadedw McNeil
 * @version 1.1
 */

public class WeeklyData {

	ArrayList<Visit> visitList = new ArrayList<Visit>();

	public WeeklyData() {
		File visitFile = new File("C:\\Users\\caded\\git\\spring23team9\\src\\ChocAnSystem\\visits.txt");
		
		try {
			Scanner scn = new Scanner(visitFile);
		while(scn.hasNextLine()) {
			String line = scn.nextLine();
			String[] arr = line.split("~");
			visitList.add(new Visit(arr[0], arr[1], arr[2], Integer.parseInt(arr[3]), Integer.parseInt(arr[4]), Integer.parseInt(arr[5]), arr[6]));
			}
			scn.close();
		}
		catch(FileNotFoundException e){
		}
	}
	/**
	 * Adds a visit to the instance's VisitList and saves the updated visit list to visits.txt
	 * @author cadedw McNeil
	 * 
	 * @param currTimeIn
	 * @param servDateIn
	 * @param currDateIn
	 * @param providerNumIn
	 * @param memberNumIn
	 * @param servCodeIn
	 * @param commentsIn
	 */
	public void addVisit(String currTimeIn, String servDateIn, String currDateIn, int providerNumIn, int memberNumIn, int servCodeIn, String commentsIn) {
		Visit visit = new Visit(currTimeIn, servDateIn, currDateIn, providerNumIn, memberNumIn, servCodeIn, commentsIn);
		visitList.add(visit);
		saveVisitList();
	}
	/**
	 * Clears the visits.txt file. To be used as a helper function with saveVisitList.
	 * @author cadedw McNeil
	 */
	public void delVisitList(){
		try{
			FileWriter overwriter = new FileWriter("C:\\Users\\caded\\git\\spring23team9\\src\\ChocAnSystem\\visits.txt", false);
			overwriter.close();
			
		} catch(Exception e){}
	}
	/**
	 * Writes the visit list to the visits.txt
	 * @author cadedw McNeil
	 * @return true if the save is successful
	 */
	public boolean saveVisitList(){
		try{ 
			delVisitList();
			FileWriter writer = new FileWriter("C:\\Users\\caded\\git\\spring23team9\\src\\ChocAnSystem\\visits.txt");
			for(int i = 0; i<visitList.size(); i++){
				Visit tempVisit = visitList.get(i);
				writer.write(tempVisit.getCurrTime() + "~" + tempVisit.getServDate() + "~" + tempVisit.getCurrDate() + "~" + tempVisit.getProviderNum() + "~" + tempVisit.getMemberNum() + "~" + tempVisit.getServCode() + "~" + tempVisit.getComments());
			}
			writer.close(); 
			return true;
		} catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
		
	}
	/**
	 * Generates the EFT Report. The provAmt array has two columns. col[0] contains every provider number in the directory. col[1]
	 * contains the corresponding balance for each provider.
	 * @author cadedw McNeil 
	 * @return true if the report generation is successful
	 */
	public boolean genEFTRep(){
		//display sums by provider
		try {
		OperatorControl opControl = new OperatorControl();
		ProviderControl provControl = new ProviderControl();
		ArrayList<String[]> provDir = provControl.getDirectory();
		int numProviders = opControl.getProviderList().size();
		String[][] provAmtArray = new String[numProviders][2];
		String[] nameArray = new String[numProviders];
		
		//Populate Col[0] with provider numbers
		for(int i = 0; i<opControl.getProviderList().size(); i++) {
			Provider tempProv = (Provider) opControl.getProviderList().get(i);
			provAmtArray[i][0] = Integer.toString(tempProv.getIDNum());
			nameArray[i] = tempProv.getName();
		}
		//Populate Col[1] with Claim balances for the week
		for(int i = 0; i<visitList.size(); i++) {
			Visit tempVisit = visitList.get(i);
			int provNum = tempVisit.getProviderNum();
			
			for(int j=0; j<numProviders; j++) {
				if(Integer.parseInt(provAmtArray[j][0])==provNum) {
					if(provAmtArray[j][1]==null) {
						provAmtArray[j][1] = "0";
					}
					
					double tempCost = Double.parseDouble(provAmtArray[j][1]);
					
					for(int k=0; k<provDir.size(); k++) {
						String[] tempEntry = provDir.get(k);
						if(tempVisit.getServCode()==Integer.parseInt(tempEntry[0])) {
							tempCost+= Double.parseDouble(tempEntry[1]);
						}
					}
					
					provAmtArray[j][1] = Double.toString(tempCost);
					System.out.println(provAmtArray[j][1]);
					if(provAmtArray[j][1]==null) {
						provAmtArray[j][1] = "0";
					}
				}
			}	
		}
		
		//Output to text file
		System.out.println("To output");
		File eftRep = new File ("C:\\Users\\caded\\git\\spring23team9\\src\\ChocAnSystem\\eftreport.txt");
		FileWriter writer = new FileWriter(eftRep, false);
		for(int i = 0; i<numProviders ; i++) {
			writer.write(nameArray[i] + " " + provAmtArray[i][0] + " " + String.format("%,.2f", Double.parseDouble(provAmtArray[i][1])));
			writer.write(System.lineSeparator());
		}
		writer.close();
		return true;
		
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		
	}
	
	/**
	 * Generate the Accounts Payable Report
	 * @author cadedw McNeil
	 * @return true if the report is generated successfully
	 */
	public boolean genAPRep() {
		//col[0] is prov numbers, col[1] is weekly balance, col[2] is visit count
		try {
		OperatorControl opControl = new OperatorControl();
		ProviderControl provControl = new ProviderControl();
		ArrayList<String[]> provDir = provControl.getDirectory();
		int numProviders = opControl.getProviderList().size();
		String[][] provAmtArray = new String[numProviders][3];
		
		//Populate Col[0] with provider numbers
		for(int i = 0; i<opControl.getProviderList().size(); i++) {
			Provider tempProv = (Provider) opControl.getProviderList().get(i);
			provAmtArray[i][0] = Integer.toString(tempProv.getIDNum());
			provAmtArray[i][2]="0";
		}
		//Populate Col[1] with Claim balances for the week and Col[2] with Visit count for the week
		for(int i = 0; i<visitList.size(); i++) {
			Visit tempVisit = visitList.get(i);
			int provNum = tempVisit.getProviderNum();
			
			for(int j=0; j<numProviders; j++) {
				if(provAmtArray[j][0].equals(Integer.toString(provNum))) {
					
					if(Integer.parseInt(provAmtArray[j][0])==provNum) {
						if(provAmtArray[j][1]==null) {
							provAmtArray[j][1] = "0";
						}
						
						double tempCost = Double.parseDouble(provAmtArray[j][1]);
						
						for(int k=0; k<provDir.size(); k++) {
							String[] tempEntry = provDir.get(k);
							if(tempVisit.getServCode()==Integer.parseInt(tempEntry[0])) {
								tempCost+= Double.parseDouble(tempEntry[1]);
							}
						}
						
						provAmtArray[j][1] = Double.toString(tempCost);
					}
					
					provAmtArray[j][2]=Integer.toString(Integer.parseInt(provAmtArray[j][2])+1);
				}
			}	
		}

			
			File APRep = new File ("C:\\Users\\caded\\git\\spring23team9\\src\\ChocAnSystem\\apreport.txt");
			FileWriter writer = new FileWriter(APRep, false);
			for(int i = 0; i<numProviders ; i++) {
				writer.write(provAmtArray[i][0] + " " + String.format("%,.2lf", Double.parseDouble(provAmtArray[i][1]))+" "+provAmtArray[i][2]);
				writer.write(System.lineSeparator());
			}
		writer.close();
		return true;
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		
	}
	/**
	 * Generates the Provider Report
	 * @author cadedw McNeil
	 * @return true if the report is generated successfully
	 */
	public boolean genProRep() {
		/**
		 * Generate report by provider
		 */
		OperatorControl opControl = new OperatorControl();
		try {
			File provRep = new File ("C:\\Users\\caded\\git\\spring23team9\\src\\ChocAnSystem\\providerreport.txt");
			FileWriter writer = new FileWriter(provRep, false);
		
		for(int i = 0; i<opControl.getProviderList().size(); i++) {
			Provider temp = opControl.getProviderList().get(i);
			
			writer.write(temp.getName() + System.lineSeparator());
			writer.write(temp.getIDNum() + System.lineSeparator());
			writer.write(temp.getAddress() + System.lineSeparator());
			writer.write(temp.getCity() + System.lineSeparator());
			writer.write(temp.getState() + System.lineSeparator());
			writer.write(temp.getZip() + System.lineSeparator());
			int visitCount = 0;
			double amtCount = 0;
			for(int j=0; j<visitList.size(); j++) {
				if(visitList.get(j).getProviderNum()==temp.getIDNum()) {
					
					Visit provVisit = visitList.get(i);
					ArrayList<ChocAnSystem.Member> tempMemList = opControl.getMemberList();
					String tempMemName = "";
					ProviderControl provCtrl = new ProviderControl();
					ArrayList<String[]> provDir = provCtrl.getDirectory();
					double tempCost = 0;
					
					for(int k=0; k<tempMemList.size(); k++){
						if(provVisit.getMemberNum()==tempMemList.get(k).getMemIDNum()) {
							visitCount++;
							tempMemName = tempMemList.get(k).getMemName();
						}
					}  
					for(int l=0; l<provDir.size(); l++){
						//System.out.println(provVisit.getServCode() + " " + provDir.get(l)[0]);
						if(Integer.toString(provVisit.getServCode()).equals(provDir.get(l)[0])) {
							tempCost = Double.parseDouble(provDir.get(l)[1]);
							amtCount +=tempCost;
							//System.out.println(tempCost + " " + tempMemName);
						}
					}
					writer.write(provVisit.getServDate() + System.lineSeparator());
					writer.write(provVisit.getCurrTime() + System.lineSeparator());
					writer.write(tempMemName + System.lineSeparator());
					writer.write(provVisit.getMemberNum() + System.lineSeparator());
					writer.write(provVisit.getServCode() + System.lineSeparator());
					writer.write(tempCost + System.lineSeparator());
					
					
				}
			}
			writer.write("Number of visits: "+ visitCount + System.lineSeparator());
			writer.write("Amount to be paid: "+ amtCount + System.lineSeparator());
			writer.write(System.lineSeparator());
			
		}

		writer.close();
		return true;
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	/**
	 * Generates the Customer Report
	 * @author cadedw McNeil
	 * @return true if the report is generated successfully
	 */
	public boolean genCustRep() {
		try {
			OperatorControl opControl = new OperatorControl();
			ProviderControl provControl = new ProviderControl();

			ArrayList<String[]> provDir = provControl.getDirectory();
			ArrayList<Provider> provList = opControl.getProviderList();
			ArrayList<ChocAnSystem.Member> memList= opControl.getMemberList(); 
			
			File custRepFile = new File("C:\\Users\\caded\\git\\spring23team9\\src\\ChocAnSystem\\customerreport.txt");
			FileWriter owriter = new FileWriter(custRepFile, false);

			boolean hasVisit;

			for(int i = 0; i<memList.size(); i++){
				hasVisit = false;
				ChocAnSystem.Member tempMem = memList.get(i);
				String[][] holdExtraVisitData = new String[1000][3];
				int visitCount = 0;
				for(int j = 0; j<visitList.size(); j++){
					Visit tempVisit = visitList.get(j);
					if(tempMem.getMemIDNum() == tempVisit.getMemberNum()){
						hasVisit = true;
						holdExtraVisitData[visitCount][0] = tempVisit.getServDate();

						int tempProvNum = tempVisit.getProviderNum();
						holdExtraVisitData[visitCount][1] = "";
						for(int k = 0; k<provList.size(); k++){
							Provider tempProvider = provList.get(k);
							if(tempProvNum== tempProvider.getIDNum()){
								holdExtraVisitData[visitCount][1] = tempProvider.getName();
							}
						}

						int tempServCode = tempVisit.getServCode();
						holdExtraVisitData[visitCount][2] = "";
						for(int l=0; l<provDir.size(); l++){
							String[] tempEntry = provDir.get(l);
							System.out.println(tempServCode + " " + Integer.parseInt(tempEntry[0]));
							if(tempServCode == Integer.parseInt(tempEntry[0])){
								holdExtraVisitData[visitCount][2] = tempEntry[2];
							}
						}
						visitCount++;
					}
				}
				if(hasVisit){
					owriter.write(tempMem.getMemName() + System.lineSeparator());
					owriter.write(tempMem.getMemIDNum() + System.lineSeparator());
					owriter.write(tempMem.getMemAddress() + System.lineSeparator());
					owriter.write(tempMem.getMemCity() + System.lineSeparator());
					owriter.write(tempMem.getMemState() + System.lineSeparator());
					owriter.write(tempMem.getMemZip() + System.lineSeparator());
					for(int m = 0; m<visitCount; m++){
						owriter.write(holdExtraVisitData[m][0] + System.lineSeparator());
						owriter.write(holdExtraVisitData[m][1] + System.lineSeparator());
						owriter.write(holdExtraVisitData[m][2] + System.lineSeparator());
					}
				}
			} 
			owriter.close();
			
			return true;
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}
	
}
