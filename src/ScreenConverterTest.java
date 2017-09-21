import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ScreenConverterTest
{
	CoordinateConverter sc;
	@Before
	public void setUp() throws Exception
	{
		sc = new CoordinateConverter();
	}

	@Test
	public void test()
	{
		assertEquals(new Complex(-2,2), sc.complexNumberAt(0, 0));
		assertEquals(new Complex(2,2), sc.complexNumberAt(800, 0));
		assertEquals(new Complex(-2,-2), sc.complexNumberAt(0, 800));
		assertEquals(new Complex(2,-2), sc.complexNumberAt(800, 800));
		assertEquals(Complex.zero, sc.complexNumberAt(400, 400));
		sc = new CoordinateConverter(200,200,-2.5,0,-1.0,0);
		assertEquals(Complex.zero, sc.complexNumberAt(200,0));
		assertEquals(new Complex(-1.25,-0.5),sc.complexNumberAt(100, 100));
		assertEquals(new Complex(-1.0,-0.75),sc.complexNumberAt(120, 150));
	}

}
