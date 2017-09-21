import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Complex implements Comparable<Complex>
{
	private double Re, Im;
	
	public static final Complex one = new Complex(1,0);
	public static final Complex i = new Complex(0,1);
	public static final Complex zero = new Complex(0,0);
	
	public Complex(double real, double imaginary)
	{
		Re = real;
		Im = imaginary;
	}
	
	public Complex()
	{
		this(0,0);
	}
	//------------------------------------------------------------------------------------------------ Accessors
	public double getRe()
	{
		return Re;
	}

	public double getIm()
	{
		return Im;
	}
	
	public String toString()
	{
		NumberFormat formatter = new DecimalFormat("0.000E0"); 
		
		return "("+formatter.format(Re)+" + "+formatter.format(Im)+"·i)";
		
	}
	//------------------------------------------------------------------------------------------------ Comparisons
	/**
	 * indicates whether "this" Complex is mathematically equivalent to "o". 
	 */
	public boolean equals(Object o)
	{
		if (!(o instanceof Complex))
			return false;  // bail if "o" is some other object than a Complex.
		Complex obj = (Complex)o; // creates a variable "obj" that we _know_ is a Complex (but is just a typecast version of "o").
		//---------------------------------------
		if (this.getRe() == obj.getRe())
		{
			if(this.getIm() == obj.getIm())
				{
					return true;
				}
		}
		//if (this.getRe() != obj.getRe() || this.getIm() != obj.getIm())
			return false;
		//---------------------------------------
	}

	
	public double magnitude()
	{
		// --------------------------------------
		double distance = (this.getRe())*(this.getRe()) + (this.getIm())*(this.getIm());
		return Math.sqrt(distance);	
	    // --------------------------------------
	}

	@Override
	
	public int compareTo(Complex c)
	{
		// --------------------------------------
		int difference = (int)(this.magnitude() - c.magnitude());
		return difference;
		//---------------------------------------
	}
	
	
	public int compareTo(double r)
	{
		return this.compareTo(new Complex(r,0));
	}
	
	public Complex plus(Complex c)
	{
		// --------------------------------------
		double real = this.getRe() + c.getRe();
		double imaginary = this.getIm() + c.getIm();
		Complex Comp = new Complex (real, imaginary);
		return Comp;
		// --------------------------------------
	}
	
	/**
	 * @param r - a real number
	 * @return a new complex that is the sum of this complex and r.
	 */
	public Complex plus(double r)
	{
		return this.plus(new Complex(r,0));
	}
	
	/**
	 * @param m - a real number
	 * @return a new complex that is the product of "this" complex and the real "m."
	 */
	public Complex times(double m)
	{
		// ---------------------------------------
		double real = (this.getRe() * m);
		double imaginary = (this.getIm() * m);
		Complex Comp = new Complex (real, imaginary);
		return Comp;
		// ---------------------------------------
	}
	
	/**
	 * @param c - another complex number
	 * @return - a new complex that is the product of "this" and the complex "c."
	 */
	public Complex times(Complex c)
	{
		// ---------------------------------------
		double term1 = this.getRe()*c.getRe();
		double term2 = this.getRe()*c.getIm();
		double term3 = this.getIm()*c.getRe();
		double term4 = -(this.getIm()*c.getIm());
		double real = term1 + term4;
		double imaginary = term2 + term3;
		Complex Comp = new Complex(real, imaginary);
		return Comp;
		// ---------------------------------------
	}
	/**
	 * @return - a new complex that is the square of "this."
	 */
	public Complex squared()
	{
		// ---------------------------------------
		Complex Comp = this.times(this);
		return Comp;
		// ---------------------------------------
	}
	
	/**
	 * @param c - another complex number
	 * @return - a new complex that is equivalent to "this" minus c.
	 */
	public Complex minus(Complex c)
	{
		// --------------------------------------
		double real = this.getRe() - c.getRe();
		double imaginary = this.getIm() - c.getIm();
		Complex Comp = new Complex (real, imaginary);
		return Comp;
		// --------------------------------------
	}
	
	/**
	 * @param r - a real number
	 * @return - a new complex that is equivalent to "this" minus r.
	 */
	public Complex minus(double r)
	{
		return this.minus(new Complex(r,0));
	}
}
