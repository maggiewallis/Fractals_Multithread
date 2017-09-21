import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class FractalPane extends JPanel implements ComponentListener, MouseListener
{
	private static final long serialVersionUID = 1L; // don't worry about this.
	private CoordinateConverter coordConverter;
	private ColorConverter  colorMap;
	private int startX, startY;
	private final int THRESHOLD = 10;
	private final int MAX_DEPTH = 4000;

	public FractalPane()
	{
		super();
		this.addComponentListener(this);
		this.addMouseListener(this);
		coordConverter = new CoordinateConverter();
		colorMap = new RainbowColorConverter();
		
	}
	
	public void componentResized(ComponentEvent e) 
	{
        coordConverter.setScreenSize(getBounds().width, getBounds().height);
        repaint();
    }

    /**
	 * for a given pixel coordinate pair (x,y) runs through the z = z^2 + c cycle, and determines the color for that pixel
	 * @param x
	 * @param y
	 * @return
	 */
    public Color calculateColorAt(int x, int y)
    {
    	
	    Complex c = coordConverter.complexNumberAt(x, y);
	    Color col = null;
		Complex z = Complex.zero;
		
		//-------------------------------
		int k = 0;	
		for (int i = 0; i < MAX_DEPTH; i++)
			{
				if (z.magnitude() >= THRESHOLD)
					break;
				z = (z.times(z)).plus(c);
				k = i;
			}
		col = colorMap.colorFor(k);
		//-------------------------------
		return col;
    }
    
	public void paintComponent(Graphics g)
	{
		for (int y=0;y<getBounds().height; y++)
			for (int x=0; x<getBounds().width; x++)
			{	
				g.setColor(calculateColorAt(x,y));  // the good stuff!
				g.fillRect(x, y, 1, 1);
			}
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		startX = e.getX();
		startY = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		int endX = e.getX();
		int endY = e.getY();
		
		int minX = Math.min(startX, endX);
		int maxX = Math.max(startX, endX);
		int minY = Math.min(startY, endY);
		int maxY = Math.max(startY, endY);
		
		if (minX < maxX && minY < maxY)
		{
			Complex c1= coordConverter.complexNumberAt(minX, minY);
			Complex c2= coordConverter.complexNumberAt(maxX, maxY);
			
			coordConverter.setMathRange(c1.getRe(), c2.getRe(), c2.getIm(), c1.getIm());
			repaint();
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
	
	public void componentHidden(ComponentEvent e) {}

    public void componentMoved(ComponentEvent e) {}

    public void componentShown(ComponentEvent e) {}
	
    
}

