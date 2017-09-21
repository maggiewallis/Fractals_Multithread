import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FractalFrame extends JFrame
{
	private static final long serialVersionUID = 1L; 
	private JPanel myPanel; 
	public FractalFrame()
	{
		super("Fractals!");
		myPanel = new ThreadedFractalPane(); // replace with ThreadedFractalPane once you have the initial image working.(800,800);
		getContentPane().setLayout(new GridLayout(1,1));
		getContentPane().add(myPanel);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(800,600);
	}
}
