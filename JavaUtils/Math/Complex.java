package Math;

/**
 * A Wrapper class for Complex Numbers
 * @author Nishant Maniam
 * @version 1.0.0
 * 
 */
public class Complex {
	private double real;
	private Imaginary imag;
	
	
	//------------CONSTRUCTORS--------------
	/**
	 * Empty Constructor. Creates a Complex number in the form 0 + 0i.
	 */
	public Complex() {
		real = 0;
		imag = new Imaginary(0);
	}
	
	/**
	 * Creates a Complex number d + 0i.
	 * @param d
	 */
	public Complex(double d) {
		real = d;
		imag = new Imaginary(0);
	}
	
	/**
	 * Creates a Complex number d + bi
	 * @param d
	 * @param i
	 */
	public Complex(double d, double b) {
		real = d;
		imag = new Imaginary(b);
	}
	
	/**
	 * Creates a Complex number by parsing String input. Input must be in form a + bi.
	 * @param input
	 */
	public Complex(String input) {
		// TODO Make this robust
		double r = 0, d = 0;
		try {
			String[] vals = input.split(" ");
			r  = Double.parseDouble(vals[0]);
			d = Double.parseDouble(vals[2].substring(0, vals[2].length() - 1));
			if (vals[1].equals("-"))
				d *= -1;
		}
		catch (Exception e) {
			System.err.println("BAD INPUT: " + input + "\nPLEASE FORMAT LIKE THIS: \"a + bi\"");
		}
		finally {
			real = r;
			imag = new Imaginary(d);
		}
	}
	
	/**
	 * Creates a Complex number copy.
	 * @param c
	 */
	public Complex(Complex c) {
		real = c.real;
		imag = new Imaginary(c.getImaginary());
	}
	
	//-------- GETTERS/SETTERS/ETC ----------
	
	public String toString() {
		return "" + real + " " + imag;
	}
	
	/**
	 * Get Real bitch
	 * @return Real part.
	 */
	public double getReal() {
		return real;
	}
	
	/**
	 * Set the Real part.
	 * @param r
	 * @return The Number.
	 */
	public Complex setReal(double r) {
		real = r;
		return this;
	}
	
	/**
	 * Set the Imaginary Part
	 * @param r
	 * @return The Number.
	 */
	public Complex setImaginary(double r) {
		imag.setValue(r);
		return this;
	}
	
	/**
	 * Get the Imaginary Part.
	 * @return Imaginary
	 */
	public double getImaginary() {
		return imag.getValue();
	}
	
	/**
	 * Gets the Magnitude.
	 * @return Magnitude.
	 */
	public double getMagnitude() {
		return Math.sqrt(Math.pow(real, 2) + Math.pow(imag.getValue(), 2));
	}
	
	public boolean equals(Complex a) {
		if ((real == a.real) && (getImaginary() == a.getImaginary()))
				return true;
		return false;
		
	}
	// -------------COMPLEX OPERATIONS------------
	/**
	 * Makes a conjugate. a + bi -> a - bi
	 * @return New Conjugate
	 */
	public Complex conjugate() {
		return new Complex(real, imag.getValue() * -1);
	}
	
	/**
	 * Makes the call a conjugate.
	 * @return This
	 */
	public Complex toConjugate() {
		imag.setValue(imag.getValue() * -1);
		return this;
	}
	
	/**
	 * Return the Angle
	 * @return
	 */
	public double getAngle() {
		return Math.tan(getImaginary() / real);
	}
		
	
	//-------- BINARY OPERATIONS WITH COMPLEX NUMBERS-------------
	/**
	 * Takes a Complex as a parameter and adds it to the Complex call.
	 * @param a
	 * @return The sum.
	 */
	public Complex add(Complex a) {
		real += a.real;
		imag.setValue(imag.getAbsVal() + a.getImaginary());
		return this;
	}
	
	/**
	 * Static wrapper for addition.
	 * @param a
	 * @param b
	 * @return The sum as a new Complex.
	 */
	public static Complex add(Complex a, Complex b) {
		return new Complex(b.real + a.real, b.getImaginary() + a.getImaginary());
	}
	
	/**
	 * Adds a real to a complex.
	 * @param r
	 * @return
	 */
	public Complex add(double r) {
		real += r;
		return this;
	}
	
	/**
	 * Static wrapper for add(double);
	 * @param a
	 * @param r
	 * @return
	 */
	public static Complex add(Complex a, double r) {
		return new Complex(a.real + r, a.getImaginary());
	}
	
	/**
	 * Adds an Imaginary to a complex
	 * @param i
	 * @return
	 */
	public Complex add(Imaginary i){
		setImaginary(i.getValue() + getImaginary());
		return this;
	}
	
	public static Complex add(Complex a, Imaginary i) {
		return new Complex(a.real, a.getImaginary() + i.getValue());
	}
	
	
	/**
	 * Takes a Complex as a parameter and subtracts the argument.
	 * @param a
	 * @return The difference.
	 */
	public Complex subtract(Complex a) {
		real -= a.real;
		imag.setValue(imag.getAbsVal() - a.getImaginary());
		return this;
	}
	/**
	 * Static wrapper for subtraction.
	 * @param a
	 * @param b
	 * @return The difference as a new Complex..
	 */
	public static Complex subtract(Complex a, Complex b) {
		return new Complex(a.real - b.real, a.getImaginary() - b.getImaginary());
	}
	
	/**
	 * Subtracts a double.
	 * @param r
	 * @return
	 */
	public Complex subtract(double r) {
		real -= r;
		return this;
	}
	
	/**
	 * STATIC WRAPPER BLAH BLAH
	 * @param a
	 * @param r
	 * @return
	 */
	public static Complex subtract(Complex a, double r) {
		return new Complex(a.real - r, a.getImaginary());
	}
	
	/**
	 * Subtracts an imaginary.
	 * @param i
	 * @return
	 */
	public Complex subtract(Imaginary i) {
		imag.setValue(getImaginary() - i.getValue());
		return this;
	}
	
	/**
	 * Wrapper
	 * @param a
	 * @param i
	 * @return
	 */
	public static Complex subtract(Complex a, Imaginary i) {
		return new Complex(a.real, a.getImaginary() - i.getValue());
	}
	/**
	 * 
	 * Takes a Complex number and returns the product.
	 * @param b
	 * @return The product.
	 */
	public Complex multiply(Complex b) {
		double ac = real * b.real;
		double DiBi = imag.imultiply(b.imag);
		double imagA = imag.getValue() * b.real;
		double imagB = b.getImaginary() * real;
		real = ac + DiBi;
		imag.setValue(imagA + imagB);
		return this;
	}
	
	/**
	 * Static wrapper for Multiply. Does not change state.
	 * @param a
	 * @param b
	 * @return The product as a new Complex.
	 */
	public static Complex multiply(Complex a, Complex b) {
		double ac = a.real * b.real;
		double DiBi = a.imag.imultiply(b.imag);
		double imagA = a.getImaginary() * b.real;
		double imagB = b.getImaginary() * a.real;
		return new Complex(ac + DiBi, imagA + imagB);
	}
	/**
	 * Takes a Complex number and returns the quotient.
	 * @param b
	 * @return The quotient.
	 */
	public Complex divide(Complex b) {
		Complex numer = multiply(this, b.conjugate());
		Complex denom = multiply(b, b.conjugate());
		real = numer.real / denom.real;
		imag.setValue(numer.getImaginary());
		return this;
	}
	
	/**
	 * @param a
	 * @param b
	 * @return The quotient as a new Complex.
	 */
	public static Complex divide(Complex a, Complex b) {
		Complex numer = multiply(a, b.conjugate());
		Complex denom = multiply(b, b.conjugate());
		return new Complex(numer.real / denom.real , numer.getImaginary());
	}
	
	// -------------EXPONENTIATION AND ROOTS-------------
		/**
		 * Instance square
		 * @return
		 */
		public Complex square() {
			return multiply(this);
		}
		/**
		 * Static Square.
		 * @param a
		 * @return
		 */
		public static Complex square(Complex a) {
			return multiply(a, a);
		}
		
		public Complex sqrt() {
			double p = Math.sqrt(Math.sqrt(Math.pow(real, 2) + Math.pow(getImaginary(), 2)) + real)/Math.sqrt(2);
			double b = 1;
			if (getImaginary() < 0)
				b = -1;
			double q = b * Math.sqrt(Math.sqrt(Math.pow(real, 2) + Math.pow(getImaginary(), 2)) - real)/Math.sqrt(2);
			
			real = p; imag.setValue(q);
			return this;
		}
		
		public static Complex sqrt(Complex a) {
			double p = Math.sqrt(Math.sqrt(Math.pow(a.real, 2) + Math.pow(a.getImaginary(), 2)) + a.real)/Math.sqrt(2);
			double b = 1;
			if (a.getImaginary() < 0)
				b = -1;
			double q = b * Math.sqrt(Math.sqrt(Math.pow(a.real, 2) + Math.pow(a.getImaginary(), 2)) - a.real)/Math.sqrt(2);
			return new Complex(p, q);
			
		}
//		public Complex 
		
		
		
		
		

//	public String prettyDiv(Complex b) {
//		Complex numer = this.multiply(b.conjugate());
//		Complex denom = b.multiply(b.conjugate());
//		imag.setValue(numer.getImaginary());
//		String top = this.toString();
//		real = numer.real / denom.real;
//		String frac = top + "\n------------\n    " + denom.real;
//		return frac;
//	}
//	
//	public String pretty() {
//		return null;	
//	}
	
	
	
}
