import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import dp.DPHelper;
import temp.DPQuestions;

public class DPTests {

	@Test
	void checkLIS() {
		
		 int[] arr = {3, 10, 2, 1, 20};
		
		 int actualLIS = DPHelper.LIS(arr);
		 
		 assertEquals(3, actualLIS);
		 
	}
	
	@Test 
	void checkLCS() {
		String a = "AGGTAB";
		String b = "GXTXAYB";
		
		int lcsLength = DPQuestions.LCS(a, b);
		
		assertEquals(4, lcsLength);
	}
	
}
