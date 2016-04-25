import java.awt.*;
import java.net.URL;

import javax.swing.*;

public class SeasonTile extends PictureTile{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	private URL url;
	private	ImageIcon	image;

	public SeasonTile(String inName){
		
		super(inName);
		
		switch (inName){
			
		case "Spring":
			x = 27;
			y = 17;
			url = SeasonTile.class.getResource("images/Spring.png");
			image = new ImageIcon(url);
			image = new ImageIcon(image.getImage().getScaledInstance(55, -1, 
					Image.SCALE_SMOOTH));
			break;
		case "Summer":
			x = 27;
			y = 10;
			url = SeasonTile.class.getResource("images/Summer.png");
			image = new ImageIcon(url);
			image = new ImageIcon(image.getImage().getScaledInstance(55, -1, 
					Image.SCALE_SMOOTH));
			break;
		case "Fall":
			x = 25;
			y = 7;
			url = SeasonTile.class.getResource("images/Fall.png");
			image = new ImageIcon(url);
			image = new ImageIcon(image.getImage().getScaledInstance(55, -1, 
					Image.SCALE_SMOOTH));
			break;
		case "Winter":
			x = 27;
			y = 10;
			url = SeasonTile.class.getResource("images/Winter.png");
			image = new ImageIcon(url);
			image = new ImageIcon(image.getImage().getScaledInstance(55, -1, 
					Image.SCALE_SMOOTH));
			break;
			
		}
		
	}
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
		g.drawImage(image.getImage(), x, y, this);
		
	}
	
}
