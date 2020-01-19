import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import practice.ArrayPractice;

public class PracticeTest {
	
	@Test
	void checkParanthesis() {
		ArrayPractice.printParanthesis(3);
	}
	
	@Test
	@DisplayName("Test : Alternate sorting of the array")
	void checkArrayAlternateSorting() {
		int[] arr = { 7, 1, 2, 3, 4, 5, 6 };

		ArrayPractice.alternateSorting(arr);

		assertArrayEquals(new int[] { 1, 7, 2, 4, 3, 6, 5 }, arr);
	}

}
