import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class Bamboo1Tile extends PictureTile
{
	private Image Bamboo1 = 
			new ImageIcon(this.getClass().getResource("/images/Sparrow.png")).getImage();
	
	public Bamboo1Tile()
	{
		super("Bamboo 1");
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(Bamboo1, 25, 5, this);
	}
	
	@Override
	public String toString()
	{
		return "Bamboo 1";
	}
	
	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Bamboo 1 Tile");

		frame.add(new Bamboo1Tile());

		frame.pack();
		frame.setVisible(true);
	}
}