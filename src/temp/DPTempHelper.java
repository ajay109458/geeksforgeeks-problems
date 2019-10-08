package temp;

public class DPTempHelper {
	
	
	
	public static void main(String[] args) {
		int[] arr1 = {3, 10, 2, 1, 20};
		System.out.println(DPQuestions.LIS(arr1));
		
		String s1 = "AGGTAB"; 
	    String s2 = "GXTXAYB";
	    
	    System.out.println(DPQuestions.lcs(s1, s2));
	    System.out.println(DPQuestions.lcsDP(s1, s2));
	}

}
