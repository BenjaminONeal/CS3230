import java.awt.*;
import java.net.URL;

import javax.swing.*;

public class SeasonTile extends PictureTile
{
	private static final long serialVersionUID = 1L;
	private int xCoord;
	private int yCoord;
	private	ImageIcon image;
	private URL url;

	public SeasonTile(String inName)
	{
		super(inName);
		
		switch (inName)
		{	
			case "Spring":
				xCoord = 27;
				yCoord = 17;
				url = SeasonTile.class.getResource("images/Spring.png");
				image = new ImageIcon(url);
				image = new ImageIcon(image.getImage().getScaledInstance(55, -1, Image.SCALE_SMOOTH));
				break;
			case "Summer":
				xCoord = 27;
				yCoord = 10;
				url = SeasonTile.class.getResource("images/Summer.png");
				image = new ImageIcon(url);
				image = new ImageIcon(image.getImage().getScaledInstance(55, -1, Image.SCALE_SMOOTH));
				break;
			case "Fall":
				xCoord = 25;
				yCoord = 7;
				url = SeasonTile.class.getResource("images/Fall.png");
				image = new ImageIcon(url);
				image = new ImageIcon(image.getImage().getScaledInstance(55, -1, Image.SCALE_SMOOTH));
				break;
			case "Winter":
				xCoord = 27;
				yCoord = 10;
				url = SeasonTile.class.getResource("images/Winter.png");
				image = new ImageIcon(url);
				image = new ImageIcon(image.getImage().getScaledInstance(55, -1, 
						Image.SCALE_SMOOTH));
				break;		
		}
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(image.getImage(), xCoord, yCoord, this);
	}
}
