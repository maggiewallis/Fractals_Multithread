import java.awt.Color;

public class GrayColorConverter extends ColorConverter
{

	public GrayColorConverter()
	{
		repeatPeriod = 256;
	}
	
	public Color colorFor(int N)
	{
		return new Color(N%256,N%256,N%256);
	}

}
