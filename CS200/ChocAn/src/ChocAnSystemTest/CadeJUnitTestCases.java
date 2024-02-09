package ChocAnSystemTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ChocAnSystem.Credentials;
import ChocAnSystem.ValidUser;

public class CadeJUnitTestCases {

	@Before
	public void setUp() throws Exception {
	}

	@Test(expected = Exception.class)
	public void addValidMemberException() {
		ValidUser user = new ValidUser("", "", "");
	}
	
	@Test
	public void testGetType() {
		String type = "manager";
		String password = "1234";
		String username = "manager99";
		ValidUser user = new ValidUser(type, username, password);
		assertTrue(user.getUserType().equals(type));
	}
	
	@Test
	public void testGetName() {
		String type = "manager";
		String password = "1234";
		String username = "manager99";
		ValidUser user = new ValidUser(type, username, password);
		assertTrue(user.getName().equals(username));
	}
	
	@Test
	public void testCheckPass() {
		String type = "manager";
		String password = "1234";
		String username = "manager99";
		ValidUser user = new ValidUser(type, username, password);
		assertTrue(user.checkPass(password));
	}
	
	@Test
	public void testReadVerifyCreds() {
		Credentials creds = new Credentials();
		assertTrue(creds.verifyCreds("manager1", "1234").equals("manager"));
	}
	
	@Test
	public void testAddValidUser() {
		Credentials creds = new Credentials();
		creds.addValidUser("operator", "Bill", "4321");
		assertTrue(creds.verifyCreds("Bill", "4321").equals("operator"));
	}

}
