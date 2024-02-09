package ChocAnSystemTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ChocAnSystem.ProviderControl;
import ChocAnSystem.Visit;

public class BenJUnitTests {

	
	/**
	 * These test are testing the Bill Healthcare feature. cadedw McNeil wrote the provider control class so his methods will be tested
	 * in addition to the methods I wrote inside the interface class as well as the Visit class
	 * 
	 * @author Ben Geary
	 * 
	 */
	
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetCurrDateVisit() {
		String currDate = "04-17-2023";
		String servDate = "03-15-2023";
		String currTime = "02:23:34";
		String comments = "No comment";
		int proNum = 123456789;
		int memNum = 111111111;
		int servCode = 123456;
		Visit tempVis = new Visit(currTime, servDate, currDate, proNum, memNum, servCode, comments);
		assertTrue(tempVis.getCurrDate().equals(currDate));
	}

	@Test
	public void testGetCurrTime() {
		String currDate = "04-17-2023";
		String servDate = "03-15-2023";
		String currTime = "02:23:34";
		String comments = "No comment";
		int proNum = 123456789;
		int memNum = 111111111;
		int servCode = 123456;
		Visit tempVis = new Visit(currTime, servDate, currDate, proNum, memNum, servCode, comments);
		assertTrue(tempVis.getCurrTime().equals(currTime));
	}
	
	@Test
	public void testGetServDate() {
		String currDate = "04-17-2023";
		String servDate = "03-15-2023";
		String currTime = "02:23:34";
		String comments = "No comment";
		int proNum = 123456789;
		int memNum = 111111111;
		int servCode = 123456;
		Visit tempVis = new Visit(currTime, servDate, currDate, proNum, memNum, servCode, comments);
		assertTrue(tempVis.getServDate().equals(servDate));
	}
	
	@Test
	public void testGetProNum() {
		String currDate = "04-17-2023";
		String servDate = "03-15-2023";
		String currTime = "02:23:34";
		String comments = "No comment";
		int proNum = 123456789;
		int memNum = 111111111;
		int servCode = 123456;
		Visit tempVis = new Visit(currTime, servDate, currDate, proNum, memNum, servCode, comments);
		assertTrue(tempVis.getProviderNum() == proNum);
	}
	
	@Test 
	public void testGetMemNum() {
		String currDate = "04-17-2023";
		String servDate = "03-15-2023";
		String currTime = "02:23:34";
		String comments = "No comment";
		int proNum = 123456789;
		int memNum = 111111111;
		int servCode = 123456;
		Visit tempVis = new Visit(currTime, servDate, currDate, proNum, memNum, servCode, comments);
		assertTrue(tempVis.getMemberNum() == memNum);
	}
	
	@Test 
	public void testGetServCode() {
		String currDate = "04-17-2023";
		String servDate = "03-15-2023";
		String currTime = "02:23:34";
		String comments = "No comment";
		int proNum = 123456789;
		int memNum = 111111111;
		int servCode = 123456;
		Visit tempVis = new Visit(currTime, servDate, currDate, proNum, memNum, servCode, comments);
		assertTrue(tempVis.getServCode() == servCode);
	}
	
	@Test
	public void testGetComments() {
		String currDate = "04-17-2023";
		String servDate = "03-15-2023";
		String currTime = "02:23:34";
		String comments = "No comment";
		int proNum = 123456789;
		int memNum = 111111111;
		int servCode = 123456;
		Visit tempVis = new Visit(currTime, servDate, currDate, proNum, memNum, servCode, comments);
		assertTrue(tempVis.getComments().equals(comments));
	}
	
	@Test
	public void testAddVisit() {
		ProviderControl provider = new ProviderControl();
		String currDate = "04-17-2023";
		String servDate = "03-15-2023";
		String currTime = "02:23:34";
		String comments = "No comment";
		int proNum = 123456789;
		int memNum = 111111111;
		int servCode = 123456;
		
		boolean add = provider.billHealthcare(currTime, servDate, currDate, proNum, memNum, servCode, comments);
		assertTrue(add == true);
	}
	
	@Test(expected = Exception.class)
	public void testBadEntryBillHealthcare() {
		ProviderControl provider = new ProviderControl();
		String currDate = "";
		String servDate = "";
		String currTime = "";
		String comments = "";
		int proNum = 123456789;
		int memNum = 111111111;
		int servCode = 123456;
		
		boolean add = provider.billHealthcare(currTime, servDate, currDate, proNum, memNum, servCode, comments);
	}
	

}
