import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public abstract class ColorConverter
{
	protected int repeatPeriod;
	
	public abstract Color colorFor(int N);
	
	
	public void showDemo()
	{
		showDemo(repeatPeriod);
	}
	
	public void showDemo(int width)
	{
		ColorStripePanel csp = new ColorStripePanel(width);
		JOptionPane.showMessageDialog(null, csp, "Color Sample", JOptionPane.PLAIN_MESSAGE);
	}
	
	public class ColorStripePanel extends JPanel
	{
		private static final long serialVersionUID = 1L; 
		private int myWidth;
		public ColorStripePanel(int w)
		{
			super();
			setPreferredSize(new Dimension(w,20));
			myWidth = w;
		}
		
		public void paintComponent(Graphics g)
		{
			for (int i=0; i<myWidth; i++)
			{
				g.setColor(colorFor(i));
				g.drawLine(i,0,i,20);
			}
		}
	}
}
