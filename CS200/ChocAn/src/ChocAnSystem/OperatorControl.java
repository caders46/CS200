package ChocAnSystem;

import java.util.*;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;


/**
 * The OperatorControl class contains the ArrayLists for our lists of stored members and providers.
 * This class contains the methods for editing this list as well as parsing and saving these lists to files for persistence
 * 
 * @author Gavin Stumpf
 * @version 1.3
 */
public class OperatorControl {
	
	private ArrayList<Member> memberList;
	private ArrayList<Provider> providerList;
	
	
		/**
	 * This is the constructor method for the OperatorControl class.
	 * @author Gavin Stumpf
	 * @return No return value.
	 */
		public OperatorControl() {
			memberList = new ArrayList<Member>();
			providerList = new ArrayList<Provider>();
			
			File memList = new File("C:\\Users\\caded\\git\\spring23team9\\src\\ChocAnSystem\\member.txt");
	        
	        try {
		        Scanner scn = new Scanner(memList);

		        while(scn.hasNextLine()){
		            String in = scn.nextLine();
		            String[] temp = in.split("~");
		            Member temp2 = new Member(temp[0], temp[1], temp[2], temp[3], temp[4], Integer.parseInt(temp[5]), Boolean.parseBoolean(temp[6]));
		            memberList.add(temp2);
		        }
		        
		        scn.close();
	        } catch (Exception e) {
	        	System.out.println("Exception thrown:\n" + e);
	        }
	        
			File provList = new File("C:\\Users\\caded\\git\\spring23team9\\src\\ChocAnSystem\\provider.txt");
	        
	        try {
		        Scanner scn = new Scanner(provList);

		        while(scn.hasNextLine()){
		            String in = scn.nextLine();
		            String[] temp3 = in.split("~");
		            Provider temp4 = new Provider(temp3[0], temp3[1], temp3[2], temp3[3], temp3[4], Integer.parseInt(temp3[5]), Boolean.parseBoolean(temp3[6]));
		            providerList.add(temp4);
		        }
		        
		        scn.close();
	        } catch (Exception e) {
	        	System.out.println("Exception thrown:\n" + e);
	        }
		}
		 /** This is the clearMember() method for the OperatorControl class.
		  * This method takes any existing data in the member file and clears it for a fresh save
		 * @author Gavin Stumpf
		 * @return No return value.
		 */
		private void clearMember() {
			try{
				FileWriter overwriter = new FileWriter("C:\\Users\\caded\\git\\spring23team9\\src\\ChocAnSystem\\member.txt", false);
				overwriter.close();
				
			} catch(Exception e){}
		}
		 /** This is the clearProvider() method for the OperatorControl class.
		  * This method takes any existing data in the provider file and clears it for a fresh save
		 * @author Gavin Stumpf
		 * @return No return value.
		 */
		private void clearProvider() {
			try{
				FileWriter overwriter = new FileWriter("C:\\Users\\caded\\git\\spring23team9\\src\\ChocAnSystem\\provider.txt", false);
				overwriter.close();
				
			} catch(Exception e){}
		}
		 /** This is the saveMember() method for the OperatorControl class.
		  * This method takes the current up to date memberList and writes the data to the member.txt file
		 * @author Gavin Stumpf
		 * @return No return value.
		 */
		private Boolean saveMember() {		
			try {
				clearMember();
				FileWriter writer = new FileWriter("C:\\Users\\caded\\git\\spring23team9\\src\\ChocAnSystem\\member.txt");
				for (int i=0; i<memberList.size(); ++i) {
					Member temp = memberList.get(i);
					writer.write(temp.getMemName() + "~" + temp.getMemAddress() + "~" + temp.getMemCity() + "~" + temp.getMemState() + "~" + temp.getMemZip() + "~" + temp.getMemIDNum() + "~" + temp.getMemStatus() + System.lineSeparator());
				}
				writer.close();
				return true;
			} catch (IOException e) {
				return false;
			}
		}
		 /** This is the saveProvider() method for the OperatorControl class.
		  * This method takes the current up to date providerList and writes the data to the provider.txt file
		 * @author Gavin Stumpf
		 * @return No return value.
		 */
		private Boolean saveProvider() {		
			try {
				clearProvider();
				FileWriter writer = new FileWriter("C:\\Users\\caded\\git\\spring23team9\\src\\ChocAnSystem\\provider.txt");
				for (int i=0; i<providerList.size(); ++i) {
					Provider temp = providerList.get(i);
					writer.write(temp.getName() + "~" + temp.getAddress() + "~" + temp.getCity() + "~" + temp.getState() + "~" + temp.getZip() + "~" + temp.getIDNum() + "~" + temp.getStatus() + System.lineSeparator());
				}
				writer.close();
				return true;
			} catch (IOException e) {
				return false;
			}
		}
		/**
		 * This is the addMember method. It creates a Member object with the passed in parameters and adds this object to the ArrayList memberList.
		 * @author Gavin Stumpf
		 * @return Boolean
		 * 
		 * @param name
		 * @param address
		 * @param city
		 * @param state
		 * @param zipCode
		 * @param iD
		 * @param status
		 * 
		 */
		public boolean addMember(String name, String address, String city, String state, String zipCode, int iD, boolean status) {
			if(name.equals("") || address.equals("") || city.equals("") || state.equals("") || zipCode.equals("")){
				throw new IllegalArgumentException();
			}
			Member member = new Member(name, address, city, state, zipCode, iD, status);
			boolean temp = memberList.add(member);
			saveMember();
			return temp;
		}
		
		/**
		 * This is the removeMember method. It searches for a member object in the ArrayList memberList that has a matching iD value to the parameter, then the object at that index is removed from memberList.
		 * @author Gavin Stumpf
		 * @return Boolean
		 * 
		 * @param iD
		 * 
		 */
		public boolean removeMember(int iD) {
			for (int i = 0; i < memberList.size(); ++i) {
				if (iD == memberList.get(i).getMemIDNum()) {
					memberList.remove(i);
					saveMember();
					return true;
				}
			}
			return false;
		}
		
		/**
		 * This is the updateMemberInfo method. It searches for a member object in the ArrayList memberList that has a matching iD value to the parameter iD, creates a Member object with the passed in parameters not including iD and sets this object in the ArrayList memberList as the index of the found object.
		 * @author Gavin Stumpf
		 * @return Boolean
		 * 
		 * @param iD
		 * @param name
		 * @param address
		 * @param city
		 * @param state
		 * @param zipCode
		 * @param newiD
		 * @param status
		 * 
		 */
		public boolean updateMemberInfo(int iD, String name, String address, String city, String state, String zipCode, int newiD, boolean status) {
			for (int i = 0; i < memberList.size(); ++i) {
				if (iD == memberList.get(i).getMemIDNum()) {
					Member member = new Member(name, address, city, state, zipCode, newiD, status);
					memberList.set(i, member);
					saveMember();
					return true;
				}
			}
			return false;
		}
		
		/**
		 * This is the addProvider method. It creates a Provider object with the passed in parameters and adds this object to the ArrayList providerList.
		 * @author Gavin Stumpf
		 * @return Boolean
		 * 
		 * @param name
		 * @param address
		 * @param city
		 * @param state
		 * @param zip
		 * @param ID
		 * @param status
		 * 
		 */
		public boolean addProvider(String name, String address, String city, String state, String zip, int ID, boolean status) {
				if(name.equals("") || address.equals("") || city.equals("") || state.equals("") || zip.equals("")){
					throw new IllegalArgumentException();
				}
			Provider provider = new Provider(name, address, city, state, zip, ID, status);
			boolean temp = providerList.add(provider);
			saveProvider();
			return temp;
		}
		
		/**
		 * This is the removeProvider method. It searches for a provider object in the ArrayList providerList that has a matching ID value to the parameter, then the object at that index is removed from providerList.
		 * @author Gavin Stumpf
		 * @return Boolean
		 * 
		 * @param ID
		 * 
		 */
		public boolean removeProvider(int ID) {
			for (int i = 0; i < providerList.size(); ++i) {
				if (ID == providerList.get(i).getIDNum()) {
					providerList.remove(i);
					saveProvider();
					return true;
				}
			}
			return false;
		}
		
		/**
		 * This is the updateProviderInfo method. It searches for a provider object in the ArrayList providerList that has a matching ID value to the parameter ID, creates a provider object with the passed in parameters not including ID and sets this object in the ArrayList providerList as the index of the found object.
		 * @author Gavin Stumpf
		 * @return Boolean
		 * 
		 * @param ID
		 * @param name
		 * @param address
		 * @param city
		 * @param state
		 * @param zip
		 * @param newID
		 * @param status
		 * 
		 */
		public boolean updateProviderInfo(int ID, String name, String address, String city, String state, String zip, int newID, boolean status) {
			for (int i = 0; i < providerList.size(); ++i) {
				if (ID == providerList.get(i).getIDNum()) {
					Provider provider = new Provider(name, address, city, state, zip, newID, status);
					providerList.set(i, provider);
					saveProvider();
					return true;
				}
			}
			return false;
		}
		
		 /** This is the getMember() method for the OperatorControl class.
		  * This method returns a member in the memberList given a member id
		 * @author Gavin Stumpf
		 * 
		 * @param id
		 * 
		 * @return Member
		 */
		public Member getMember(int id) {
			for (int i = 0; i < memberList.size(); ++i) {
				if (id == memberList.get(i).getMemIDNum()) {
					return memberList.get(i);
				}
			}
					return memberList.get(0);
				
		}
		 /** This is the getProvider() method for the OperatorControl class.
		  * This method returns a provider in the providerList given a provider id
		 * @author Gavin Stumpf
		 * 
		 * @param id
		 * 
		 * @return Provider
		 */
		public Provider getProvider(int id) {
			for (int i = 0; i < providerList.size(); ++i) {
				if (id == providerList.get(i).getIDNum()) {
					return providerList.get(i);
				}
			}
					return providerList.get(0);
				
		}
		
		/**
		 * This is the getMemberList method. It returns the private ArrayList variable memberList for other classes to access when called.
		 * @author Gavin Stumpf
		 * @return ArrayList
		 * 
		 */
		public ArrayList<Member> getMemberList() {
			return memberList;
		}
		
		/**
		 * This is the getProviderList method. It returns the private ArrayList variable providerList for other classes to access when called.
		 * @author Gavin Stumpf
		 * @return ArrayList
		 * 
		 */
		public ArrayList<Provider> getProviderList() {
			return providerList;
		}
		 /** This is the validateMember method for the OperatorControl class.
		  * This method returns a string, "VALID" or "INVALID", depending on if the member id parameter is found in one of the member objects in the memberList.
		 * @author Gavin Stumpf
		 * 
		 * @param memberNumber
		 * 
		 * @return String
		 */
	    public String validateMember(int memberNumber){
	        try{

	            for(int i = 0; i<memberList.size(); i++){
	                if(memberList.get(i).getMemIDNum()==memberNumber){
	                    if(memberList.get(i).getMemStatus()){
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
		 /** This is the validateProvider method for the OperatorControl class.
		  * This method returns a string, "VALID" or "INVALID", depending on if the provider id parameter is found in one of the provider objects in the providerList.
		 * @author Gavin Stumpf
		 * 
		 * @param providerNumber
		 * 
		 * @return String
		 */
	    public String validateProvider(int providerNumber){
	        try{

	            for(int i = 0; i<providerList.size(); i++){
	                if(providerList.get(i).getIDNum()==providerNumber){
	                    if(providerList.get(i).getStatus()){
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
		
}
