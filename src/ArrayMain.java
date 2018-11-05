import java.util.Arrays;

public class ArrayMain {

	public static void main(String[] args) {
		
		int[] arr = {1, 2, 3, 4, 5, 6, 7};
		
		System.out.println(Arrays.toString(arr));
		
		// Array rotation 
		ArrayHelper.rotateArray(arr, 2);
		System.out.println(Arrays.toString(arr));
		
	}
	
}
