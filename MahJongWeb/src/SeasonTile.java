import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class SeasonTile extends PictureTile
{
	private Image Spring = 
			new ImageIcon(this.getClass().getResource("/images/Spring.png")).getImage();
	private Image Summer = 
			new ImageIcon(this.getClass().getResource("/images/Summer.png")).getImage();
	private Image Fall = 
			new ImageIcon(this.getClass().getResource("/images/Fall.png")).getImage();
	private Image Winter = 
			new ImageIcon(this.getClass().getResource("/images/Winter.png")).getImage();
	
	public SeasonTile(String name)
	{
		super(name);
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		switch(name){
		case "Spring":
			g.drawImage(Spring, 25, 10, this);
			break;
		case "Summer":
			g.drawImage(Summer, 24, 5, this);
			break;
		case "Fall":
			g.drawImage(Fall, 25, 5, this);
			break;
		case "Winter":
			g.drawImage(Winter, 25, 5, this);
			break;
		}
	}
	
	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Season Tiles");

		frame.add(new SeasonTile("Spring"));
		frame.add(new SeasonTile("Summer"));
		frame.add(new SeasonTile("Fall"));
		frame.add(new SeasonTile("Winter"));

		frame.pack();
		frame.setVisible(true);
	}
}