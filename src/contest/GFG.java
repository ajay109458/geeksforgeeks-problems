package contest;

import java.util.Scanner;

public class GFG {
	public static void main(String[] args) {
		IOFunction();
	}

	static void operations(int a, int b, int c) {

		long op1 = (long) Math.pow(a, b);

		System.out.println(op1);

		long op2 = ((long) Math.pow(a, b)) ^ c;

		System.out.println(op2);

		if (c == 0)
			return;

		long op3 = ((long) Math.pow(a, b)) % c;

		System.out.println(op3);
	}

	static void findJumps(long N, long X) {

		long noOfStones = (long) (N / 2 + 1);

		long minJump = Math.min(X / 2, (long)(noOfStones - 1 - X/2));
		
		System.out.println(minJump);
		
	}
	
	 static void IOFunction(){
	        Scanner sc = new Scanner(System.in);
			int t = sc.nextInt();
			
			
			while(t-- > 0){
			    
			    String s = sc.nextLine();
			    System.out.println(s);
			    
			    
			}
			
	    }
}
