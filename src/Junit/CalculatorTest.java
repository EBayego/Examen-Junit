package Junit;

import static Junit.Calculator.ipAdressType;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

	@Test
	public void ipAdressTypeTest() {
		assertThrows(RuntimeException.class, () -> {
			ipAdressType(null, null);
		});
		assertThrows(RuntimeException.class, () -> {
			ipAdressType("", "");
		});
		assertEquals("b", ipAdressType("10.0.100.23", "255.255.0.0"));
		assertEquals("a", ipAdressType("10.0.100.23", null));
		assertThrows(RuntimeException.class, () -> {
			ipAdressType("10.0.100.29", "255.255.0.0");
		});
		assertEquals("c", ipAdressType("200.30.110.5/24", ""));
	}
}
