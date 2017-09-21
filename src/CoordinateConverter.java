public class CoordinateConverter
{
	private int screenWidth, screenHeight;
	private double minMathX, maxMathX, minMathY, maxMathY;
	private double xRatio, yRatio;
	
	public CoordinateConverter(int w, int h, double minX, double maxX, double minY, double maxY)
	{
		setScreenSize(w,h);
		setMathRange(minX, maxX, minY, maxY);
	}
	
	public CoordinateConverter()
	{
		this(800,800,-2.0,2.0,-2.0,2.0);
	}
	
	/**
	 * set the width and height, in pixels of the portion of the screen that is modelling
	 * the complex plane.
	 * @param w
	 * @param h
	 */
	public void setScreenSize(int w, int h)
	{
		screenWidth = Math.max(1, w);
		screenHeight = Math.max(1, h);
		calculateRatios();
	}
	
	/**
	 * @param minX
	 * @param maxX
	 * @param minY
	 * @param maxY
	 */
	public void setMathRange(double minX, double maxX, double minY, double maxY)
	{
		if (minX==maxX)
			throw new RuntimeException("Attempted to reset math range to zero width");
		if (minY==maxY)
			throw new RuntimeException("Attempted to reset math range to zero height");
		minMathX = Math.min(minX, maxX);
		maxMathX = Math.max(minX, maxX);
		minMathY = Math.min(minY, maxY);
		maxMathY = Math.max(minY, maxY);
		if (minMathX != minX)
			System.out.println("Warning... set math range with reversed max/min X values.");
		if (minMathY != minY)
			System.out.println("Warning... set math range with reversed max/min Y values.");
		calculateRatios();
	}
	
	/**
	 * calculate the proportion between the math coordinates and the screen coordinates, 
	 * calculated when either set is resized, to speed up conversion factor later.
	 */
	private void calculateRatios()
	{
		xRatio = (maxMathX-minMathX)/screenWidth;
		yRatio = (maxMathY-minMathY)/screenHeight;
	}

	/**
	 * get the complex number that corresponds to the given coordinates on screen.
	 * @param x
	 * @param y
	 * @return
	 */
	public Complex complexNumberAt(int x, int y)
	{
		return new Complex(minMathX+xRatio*x, maxMathY-yRatio*y);
	}
	
}
