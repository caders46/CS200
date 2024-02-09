package ChocAnSystemTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ChocAnSystem.OperatorControl;
import ChocAnSystem.Provider;

public class SamJUnitTestCases {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAddProvider() {
		OperatorControl oc = new OperatorControl();
		assertTrue(oc.addProvider("John Smith", "123 Circle", "Yahoo", "Alabama", "47849", 123, false));
	}
	
	@Test
	public void testSetState() {
		Provider prov = new Provider("Dr. A. Geary", "172 Amish Lane", "Lancester", "PA", "47563", 123, false);
		prov.setState("Florida");
		assertEquals(prov.getState(), "Florida");
	}
	
	@Test (expected = Exception.class)
	public void testSetState2() {
		Provider prov = new Provider("Mickey Mouse", "273 Disney World", "Orlando", "Florida", "73849", 123, false);
		prov.setState("");
	}
	
	@Test
	public void testSetZip() {
		Provider prov = new Provider("K. Milner", "283 Trina Ln", "Tuscaloosa", "Alabama", "73748", 123, false);
		prov.setZip("73921");
		assertEquals(prov.getZip(), "73921");
	}
	
	@Test (expected = Exception.class)
	public void testSetZip2() {
		Provider prov = new Provider("R. McDonald", "2734 Flower Trail", "Los Angeles", "California", "36472", 123, false);
		prov.setZip("");
	}

}
