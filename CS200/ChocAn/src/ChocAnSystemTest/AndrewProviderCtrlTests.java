package ChocAnSystemTest;


import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ChocAnSystem.OperatorControl;
import ChocAnSystem.ProviderControl;

public class cadedwProviderCtrlTests {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetDirectory() {
		ProviderControl provCtrl = new ProviderControl();
		ArrayList<String[]> provDir = provCtrl.getDirectory();
		String[] testZero = {"123456", "523.12", "chocolate detox"};
		String[] entryZero = provDir.get(0);
		for(int i = 0; i<testZero.length; i++) {
			Assert.assertEquals(testZero[i], entryZero[i]);
		}
		
	}

	@Test (expected = IllegalArgumentException.class)
	public void failBillHealthcare() {
			ProviderControl provCtrl = new ProviderControl();
			provCtrl.billHealthcare("", "01/01/1999", "01/02/1999", 333333333, 999999999, 123456, "");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void failAddProvider() {
		OperatorControl opCtrl = new OperatorControl();
		opCtrl.addMember("", "123 Main", "Ttown", "AL", "35404", 91203845, false); 
	}

}
