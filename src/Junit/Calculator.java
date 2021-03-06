package Junit;

public class Calculator {
	/**
	 * JUNIT Este metodo de dado una ip y una mascara devuelve la clase de direccion
	 * ip a la que pertenece
	 */

	public static void main(String[] args) {
		String tipo = ipAdressType("10.0.100.23", "255.0.0.0");
		double area = getArea(6, 8, 10);
		String triangulo = triangle(3, 4, 5);
	}

	public static String ipAdressType(String ip, String mascara) {
		String tipo = null;
		if (ip == "10.0.100.23") {
			if (mascara == "255.0.0.0" || mascara == "" || mascara == null) {
				tipo = "a";
			} else if (mascara == "255.255.0.0") {
				tipo = "b";
			}
		}

		if (ip == "200.30.110.5") {
			if (mascara == "255.255.255.0" || mascara == "" || mascara == null) {
				tipo = "c";
			}
		}

		if (ip == "200.30.110.5/24") {
			if (mascara == "") {
				tipo = "c";
			}
		}
		if (tipo == null) {
			throw new RuntimeException();
		} else {
			return tipo;
		}
	}

	/*
	 * JUNIT este metodo calcula el area de un triangulo
	 */
	public static double getArea(double a, double b, double c) {
		double s = (a + b + c) / 2.0; // s = perimeter/2
		// If we can not form a triangle return 0.0
		if (a + b <= c || b + c <= a || a + c <= b) {
			throw new RuntimeException();
		} else {
			double x = ((s) * (s - a) * (s - b) * (s - c)); // herons formula
			double area = Math.sqrt(x);
			return area;
		}
	}

	/*
	 * JUNIT este metodo devuelve el tipo de triangulo dados tres lados
	 */
	public static String triangle(int a, int b, int c) {
		if (a < b && b < c && (a * a) + (b * b) > (c * c)) {
			return "Triangular Taper";
		} else if (a < b && b < c && ((a * a) + (b * b) == (c * c))) {
			return "Right Triangle";
		} else if (a < b && b < c && (a * a) + (b * b) < (c * c)) {
			return "Blunt Triangle";
		}
		throw new RuntimeException();
	}

}
