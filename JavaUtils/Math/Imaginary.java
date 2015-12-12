
package Math;

/**
 * @author Nishant Maniam
 * @version 1.0.0
 *
 */
public class Imaginary {
	private double value;
	private char sign;
	
	public Imaginary(double val) {
		value = val;
		sign = (value >= 0 ? '+' : '-');
	}
	
	public Imaginary setValue(double val) {
		value = val;
		return this;
	}
	public static Imaginary setValue(Imaginary i , double val) {
		return i.setValue(val);
	}
	public double getValue() {
		return value;
	}
	public static double getValue(Imaginary i) {
		return i.getValue();
	}
	public double getAbsVal() {
		return Math.abs(value);
	}
	
	public String toString() {
		if (sign == '-')
			return "" + "- " + getAbsVal() +"i";
		return "" + "+ " + value +"i";
	}
	
	public double imultiply(Imaginary b) {
		return value * b.value * -1;
	}
}
