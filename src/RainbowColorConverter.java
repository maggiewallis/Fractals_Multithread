import java.awt.Color;

public class RainbowColorConverter extends ColorConverter
{

	public RainbowColorConverter()
	{
		repeatPeriod = 500;
	}
	
	public Color colorFor(int N)
	{
		//return new Color(N%100,N%150,N%10 + 190); //bright purple and blue
		//return new Color(100,N%150,N%10 + 190); //slightly darker purple, more purple
		//return new Color(200,N%150,N%10); //firey, red and orange
		//return new Color(100,N%255,N%255); //bright teal and red
		//return new Color(N%100, N%200, N%200); //black and bright blue      
		//return new Color(200 -N%40, N%250, N%200 + 55); //PINK
		//return new Color(N%200 +40, N%200 +40, N%200+40); //shades of grey
		//return new Color(N%255,N%113,N%100 + 26); //dark blue and pink combo
		//return new Color(N%253+ 2, N%54 + 132, N%80 + 130); //calm green and pale pink
		//return new Color(N%131 + 95,2 + N%224, N%195 + 31); //looks like tropical starbursts
		return new Color(226 - N%131, 226 - N%224, 226 - N%195); //grey background with rainbow inside
	}

}