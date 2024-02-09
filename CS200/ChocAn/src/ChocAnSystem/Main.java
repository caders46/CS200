package ChocAnSystem;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {


        //ProviderControl pro = new ProviderControl();
        //ArrayList<String[]> temp = pro.getDirectory();
        
        /*for (int i = 0; i < temp.size(); i++) {
        	String[] tempArr = temp.get(i);
        	for (int k = 0; k < tempArr.length; k++) {
        		System.out.print(tempArr[k] + " ");
        	}
        	System.out.println("");
        }
		*/
        //LoginInterface login = new LoginInterface();
        //ManagerInterface manager = new ManagerInterface(credList);
        //OperatorInterface operator = new OperatorInterface();
		WeeklyData wkData = new WeeklyData();
		
		System.out.println(wkData.genEFTRep());
	}
}
