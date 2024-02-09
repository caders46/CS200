package ChocAnSystemTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


/*
 * 
 * For the Junit Case, the zip code will be tested for success, sanity, and exception
 * 
 * @author Kemberlyn Milner  
 */
import ChocAnSystem.Member;

public class KemberlynMilnerJUnitTest {

	Member mem;
	@Before
	public void setUp() throws Exception {
		mem = new Member("Kem Mil", "123 Ses St", "Brooklyn", "NY", "12345", 111222333, false);

	}

	@Test
	public void getStatusSuccess() {
		Boolean stat = false;
		assertTrue(mem.getMemStatus()== stat);		
	}
	
	@Test (expected = Exception.class)
	public void setStatusException() {
		Member newMem = new Member("Kem Mil", "123 Ses St", "Brooklyn", "NY", "12345", 111222333, false);
		newMem.setMemStatus(true);
	}
	
	@Test
	public void getStatusSanity() {
		Member newMem = new Member("Jim Mel", "124 Ses St", "Brooklyn", "NY", "12345", 111222334, false);
		assertTrue(mem.getMemStatus() == (newMem.getMemStatus()));
	}
	
	@Test
	public void getZipSuccess() {
		String zipCode = "12345";
		assertTrue(mem.getMemZip().equals(zipCode));
	}
	
	@Test (expected = Exception.class)
	public void setZipException() {
		String zipCode = "";
		mem.setMemZip(zipCode);
	}
	
	@Test
	public void setZipSanity() {
		Member sani = new Member("Lim Myl", "125 Ses St", "Brooklyn", "NY", "12345", 111222335, false);
		mem.setMemZip(sani.getMemZip());
		assertTrue(mem.getMemZip() == mem.getMemZip());
		
	}
	
	

}
