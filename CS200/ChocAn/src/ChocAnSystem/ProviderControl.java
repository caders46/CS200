package ChocAnSystem;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;




public class ProviderControl {
//index 0: service code; index 1: cost; index 2: name;
    ArrayList<String[]> providerDirectory;
	
	public ProviderControl() {
		
	providerDirectory = new ArrayList<String[]>();
		//CHANGE FILE PATH TO YOUR OWN WHEN TESTING
        File providerDir = new File("C:\\Users\\caded\\git\\spring23team9\\src\\ChocAnSystem\\providerDirectory.txt");
        
        try {
	        Scanner scn = new Scanner(providerDir);

	        while(scn.hasNextLine()){
	            String in = scn.nextLine();
	            String[] temp = in.split("~");
	            providerDirectory.add(temp);
	        }
	        
	        scn.close();
        } catch (Exception e) {
        	System.out.println("Exception thrown:\n" + e);
        }
	
	}

    public ArrayList<String[]> getDirectory(){
        return providerDirectory;
    }

        /**
         * Creates a new visit object and adds it to the visits.txt file
         * @author cadedw McNeil
         * @param currTimeIn
         * @param servDateIn
         * @param currDateIn
         * @param providerNumIn
         * @param memberNumIn
         * @param servCodeIn
         * @param commentsIn
         * @return true if the visit is successfully added
         */
    public boolean billHealthcare(String currTimeIn, String servDateIn, String currDateIn, int providerNumIn, int memberNumIn, int servCodeIn, String commentsIn){

    	if (currTimeIn.equals("") || servDateIn.equals("") || currDateIn.equals("") || commentsIn.equals("")) {
    		throw new IllegalArgumentException();
    	}
    	try{
            WeeklyData weeklydata = new WeeklyData();
            weeklydata.addVisit(currTimeIn, servDateIn, currDateIn, providerNumIn, memberNumIn, servCodeIn, commentsIn);
            
            /*File weeklyVisit = new File("VisitData.txt");
            FileWriter writer = new FileWriter(weeklyVisit);
            writer.write(newBill.getDate() + "~" + newBill.getTime()+"~"+newBill.getProviderNum()+"~"+newBill.getMemberNum()+"~"+newBill.getServCode()+"~"+newBill.getComments());
            writer.close();*/
            return true;
        } catch (Exception e) {
        	
            return false;
        }   
    }

    /**
     * Checks the status of a member
     * @author cadedw McNeil
     * @param memberNumber
     * @return String representing the member's status, either Valid, Suspended, or Invalid
     */
    
    public String validateMember(int memberNumber){
        try{

            OperatorControl opCtrl = new OperatorControl();
            ArrayList<Member> memList = opCtrl.getMemberList();
            for(int i = 0; i<memList.size(); i++){
                if(memList.get(i).getMemIDNum()==memberNumber){
                    if(memList.get(i).getMemStatus()){
                        return "VALID";
                    }
                    else {
                    	return "SUSPENDED";
                    }
                }
            }

            return "INVALID";
        }catch (Exception e){}
        return "INVALID";
    }
    
    /**
     * Validates a provider number
     * @author cadedw McNeil
     * @param proNum
     * @return boolean representing the provider status, valid=>true.
     */
    public boolean validateProvider(int proNum) {
    	try {
    		OperatorControl opCtrl = new OperatorControl();
    		String output = opCtrl.validateProvider(proNum);
    		if(output.equals("VALID")) {
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    	catch(Exception e) {
    		return false;
    	}
    }

    




}
