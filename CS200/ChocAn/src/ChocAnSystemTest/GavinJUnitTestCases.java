package ChocAnSystemTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ChocAnSystem.OperatorControl;
import ChocAnSystem.Provider;

public class GavinJUnitTestCases {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void addMemberSuccessTest() {
		OperatorControl oc = new OperatorControl();
		assertTrue(oc.addMember("name", "address", "city", "state", "zip", 123, false));
	}

	@Test(expected = Exception.class)
	public void addMemberExceptionTest() {
		OperatorControl oc = new OperatorControl();
		oc.addMember("", "", "", "", "", 123, true);
	}

	@Test
	public void addMemberSanityTest() {
		OperatorControl oc = new OperatorControl();
		oc.addMember("name", "address", "city", "state", "zip", 123, true);
		oc.removeMember(123);
		assertTrue(oc.getMemberList().size() == 0);
	}
	
	@Test
	public void addProviderSuccessTest() {
		OperatorControl oc = new OperatorControl();
		assertTrue(oc.addProvider("name", "address", "city", "state", "zip", 123, true));
	}

	@Test(expected = Exception.class)
	public void addProviderExceptionTest() {
		OperatorControl oc = new OperatorControl();
		oc.addProvider("", "", "", "", "", 123, true);
	}

	@Test
	public void addProviderSanityTest() {
		OperatorControl oc = new OperatorControl();
		oc.addProvider("name", "address", "city", "state", "zip", 123, true);
		oc.removeProvider(123);
		assertTrue(oc.getProviderList().size() == 0);
	}
	
	@Test
	public void setAddressSuccessTest(){
		Provider p = new Provider("name", "address", "city", "state", "zip", 123, false);
		p.setAddress("Main Street");
		assertTrue(p.getAddress() == "Main Street");
	}
	
	@Test(expected = Exception.class)
	public void setAddressExceptionTest(){
		Provider p = new Provider("name", "address", "city", "state", "zip", 123, false);
		p.setAddress("");
	}
	
	@Test
	public void setAddressSanityTest() {
		Provider p = new Provider("name", "address", "city", "state", "zip", 123, false);
		String temp = p.getAddress();
		p.setAddress("Main Street");
		p.setAddress("address");
		assertTrue(p.getAddress() == temp);
	}

}
