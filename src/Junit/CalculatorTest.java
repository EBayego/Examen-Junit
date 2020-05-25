package Junit;

import static Junit.Calculator.getArea;
import static Junit.Calculator.ipAdressType;
import static Junit.Calculator.triangle;
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

	@Test
	public void getAreaTest() {
		assertThrows(RuntimeException.class, () -> {
			getArea(1, 2, 3);
		});
		assertEquals(24.0, getArea(6, 8, 10), 0);
		assertEquals(6.0, getArea(3, 4, 5), 0);
		assertThrows(RuntimeException.class, () -> {
			getArea(0, 0, 0);
		});
		assertThrows(RuntimeException.class, () -> {
			getArea(-6, -8, -10);
		});
		assertThrows(RuntimeException.class, () -> {
			getArea(60, 80, -10);
		});
	}

	@Test
	public void triangleTest() {
		assertEquals("Right Triangle", triangle(3, 4, 5));
		assertEquals("Blunt Triangle", triangle(3, 4, 12));
		assertEquals("Triangular Taper", triangle(6, 7, 8));
		assertThrows(RuntimeException.class, () -> {
			triangle(0, 0, 0);
		});
		assertThrows(RuntimeException.class, () -> {
			triangle(-6, -7, -8);
		});
		assertEquals("Triangular Taper", triangle(-10, -8, -6));
		assertEquals("Triangular Taper", triangle(-5, -4, -3));
	}
}
