package lab11;

import static org.junit.Assert.*;

import org.junit.Test;

public class polynomialTest {

	@Test
	public void testExpression() {
		polynomial test = new polynomial();
		polynomial root = test.expression("2x+3x");
		assertEquals("5x",root.display());
	}

}
