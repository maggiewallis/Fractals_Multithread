import static org.junit.Assert.*;

import org.junit.Test;

public class ComplexTest
{

	@Test
	public void testEquals()
	{
		// assertEquals and assertNotEquals versions....
		assertEquals (Complex.one, new Complex(1,0));
		assertNotEquals(Complex.one, new Complex(0,1));
		
		// assertTrue and assertFalse versions....
		assertTrue (Complex.i.equals(new Complex(0,1)));
		assertTrue (new Complex(4,3).equals(new Complex(4,3)));
		assertFalse(Complex.zero.equals(new Complex(0.5, 0.75)));
		assertFalse(new Complex(11,12).equals(new Complex(13, 14)));
	}
	
	@Test
	public void testMagnitude()
	{
		assertEquals(new Complex(3,4).magnitude(), (double) 5, 0.01);
		assertEquals(new Complex(8,15).magnitude(), (double) 17, 0.01);
		assertEquals(new Complex(-7,-24).magnitude(), (double) 25, 0.01);
	}
	
	@Test
	public void testCompareTo()
	{
		assertEquals(new Complex(3,4).compareTo(new Complex(3,4)), 0, 0.01);
		assertEquals(new Complex(8,15).compareTo(new Complex(-7,-24)), -8, 0.01);
		assertEquals(new Complex(5,12).compareTo(new Complex(3,4)), 8, 0.01);
	}
	
	@Test
	public void testPlus()
	{
		assertEquals(new Complex(3,4).plus(new Complex (3,4)),new Complex(6, 8));
		assertEquals(new Complex(-1,-3).plus(new Complex (20,-4)),new Complex(19, -7));
		assertEquals(new Complex(-2,16).plus(new Complex (-10,-4)),new Complex(-12, 12));
	}
	
	@Test
	public void testTimes()
	{
		assertEquals(new Complex(3,4).times(1),new Complex(3, 4));
		assertEquals(new Complex(-3,-4).times(3),new Complex(-9, -12));
		assertEquals(new Complex(-2,5).times(4),new Complex(-8, 20));
	}
	
	@Test
	public void test2Times()
	{
		assertEquals(new Complex(4,-3).times(new Complex(2,5)), new Complex(23,14));
		assertEquals(new Complex(7,-9).times(new Complex(4,-6)), new Complex(-26,-78));
		assertEquals(new Complex(7,2).times(new Complex(7,2)), new Complex(45,28));
		//fix the answer to this
	}
	
	@Test
	public void testSquared()
	{
		assertEquals(new Complex(7,2).squared(), new Complex(45,28));
		assertEquals(new Complex(1,3).squared(), new Complex(-8,6));
		assertEquals(new Complex(4,-7).squared(), new Complex(-33,-56));

	}
	
	@Test
	public void testMinus()
	{
		assertEquals(new Complex(7,2).minus(new Complex(1,2)), new Complex(6,0));
		assertEquals(new Complex(-1,3).minus(new Complex(5,9)), new Complex(-6,-6));
		assertEquals(new Complex(4,-8).minus(new Complex(-3,0)), new Complex(7,-8));

	}

}
