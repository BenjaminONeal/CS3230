import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public abstract class PictureTile extends Tile
{
	protected String name;
	
	private Image Spring = 
			Toolkit.getDefaultToolkit().getImage("images/Spring.png");
	private Image Summer = 
			Toolkit.getDefaultToolkit().getImage("images/Summer.png");
	private Image Fall = 
			Toolkit.getDefaultToolkit().getImage("images/Fall.png");
	private Image Winter = 
			Toolkit.getDefaultToolkit().getImage("images/Winter.png");
	private Image Chrysanthemum = 
			Toolkit.getDefaultToolkit().getImage("images/Chrysanthemum.png");
	private Image Orchid = 
			Toolkit.getDefaultToolkit().getImage("images/Orchid.png");
	private Image Plum = 
			Toolkit.getDefaultToolkit().getImage("images/Plum.png");
	private Image Bamboo = 
			Toolkit.getDefaultToolkit().getImage("images/Bamboo.png");
	private Image Sparrow =
			Toolkit.getDefaultToolkit().getImage("images/Sparrow.png");
	
	public PictureTile(String name)
	{
		this.name = name;
		setToolTipText(toString());
	}

	@Override
	public String toString()
	{
		return name;
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
			g.drawImage(Summer, 25, 5, this);
			break;
		case "Fall":
			g.drawImage(Fall, 25, 5, this);
			break;
		case "Winter":
			g.drawImage(Winter, 25, 5, this);
			break;
		case "Chrysanthemum":
			g.drawImage(Chrysanthemum, 25, 5, this);
			break;
		case "Orchid":
			g.drawImage(Orchid, 25, 5, this);
			break;
		case "Plum":
			g.drawImage(Plum, 28, 5, this);
			break;
		case "Bamboo":
			g.drawImage(Bamboo, 30, 5, this);
			break;
		case "Sparrow":
			g.drawImage(Sparrow, 25, 5, this);
		}
	}
	
	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Picture Tiles");

		frame.add(new Bamboo1Tile());

		frame.add(new FlowerTile("Chrysanthemum"));
		frame.add(new FlowerTile("Orchid"));
		frame.add(new FlowerTile("Plum"));
		frame.add(new FlowerTile("Bamboo"));

		frame.add(new SeasonTile("Spring"));
		frame.add(new SeasonTile("Summer"));
		frame.add(new SeasonTile("Fall"));
		frame.add(new SeasonTile("Winter"));

		frame.pack();
		frame.setVisible(true);
	}
}