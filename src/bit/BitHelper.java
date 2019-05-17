package bit;

public class BitHelper {

	public static boolean isOppSign(int a, int b) {
		return ((a ^ b) < 0) ? true : false;
	}

}
