import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class FlowerTile extends PictureTile
{
	private Image Chrysanthemum = 
			new ImageIcon(this.getClass().getResource("/images/Chrysanthemum.png")).getImage();
	private Image Orchid = 
			new ImageIcon(this.getClass().getResource("/images/Orchid.png")).getImage();
	private Image Plum = 
			new ImageIcon(this.getClass().getResource("/images/Plum.png")).getImage();
	private Image Bamboo = 
			new ImageIcon(this.getClass().getResource("/images/Bamboo.png")).getImage();
	
	public FlowerTile(String name)
	{
		super(name);
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		switch(name){
		case "Chrysanthemum":
			g.drawImage(Chrysanthemum, 22, 5, this);
			break;
		case "Orchid":
			g.drawImage(Orchid, 22, 5, this);
			break;
		case "Plum":
			g.drawImage(Plum, 28, 5, this);
			break;
		case "Bamboo":
			g.drawImage(Bamboo, 30, 5, this);
			break;
		}
	}
	
	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Flower Tiles");

		frame.add(new FlowerTile("Chrysanthemum"));
		frame.add(new FlowerTile("Orchid"));
		frame.add(new FlowerTile("Plum"));
		frame.add(new FlowerTile("Bamboo"));

		frame.pack();
		frame.setVisible(true);
	}
}