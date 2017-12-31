import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

class BrokenClassTest {

	static BrokenClass test = new BrokenClass();
	
	@Test
	void testIsCardAMatch() {
		BrokenClass test = new BrokenClass();
		
		boolean expected = true;
		boolean actual = test.isCardAMatch("hearts", "HEARTS");
		
		assertEquals("error", expected, actual);
	}

	@Test
	void testBaseEncodeFileName() {
		
		String expected = "c2VjcmV0s";
		String actual = test.baseEncodeFileName("secret");
		
		assertEquals("error", expected, actual);
	}

	@Test
	void testRoundUp() {
		Scanner scnr = new Scanner(System.in);
		float input = scnr.nextFloat();
		int actual = test.roundUp(input);
		int expected = (Math.round(input));
		
		assertEquals("error", expected, actual);
	}

	@Test
	void testSum() {
		int actual = test.sum(Integer.MAX_VALUE, 1);
		int expected = Integer.MAX_VALUE;
		
		assertEquals("error", expected, actual);
	}

}
