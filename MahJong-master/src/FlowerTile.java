import java.awt.*;
import javax.swing.*;
import java.net.*;

public class FlowerTile extends PictureTile{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	private URL url;
	private	ImageIcon	image;
	
	public FlowerTile(String inName){
		
		super(inName);
		
		switch (inName){
		
		case "Chrysanthemum":
			x = 30;
			y = 15;
			url = FlowerTile.class.getResource("images/Chrysanthemum.png");
			image = new ImageIcon(url);
			image = new ImageIcon(image.getImage().getScaledInstance(50, -1, 
					Image.SCALE_SMOOTH));
			break;
		case "Orchid":
			x = 30;
			y = 10;
			url = FlowerTile.class.getResource("images/Orchid.png");
			image = new ImageIcon(url);
			image = new ImageIcon(image.getImage().getScaledInstance(50, -1, 
					Image.SCALE_SMOOTH));
			break;
		case "Plum":
			x = 30;
			y = 10;
			url = FlowerTile.class.getResource("images/Plum.png");
			image = new ImageIcon(url);
			image = new ImageIcon(image.getImage().getScaledInstance(50, -1, 
					Image.SCALE_SMOOTH));
			break;
		case "Bamboo":
			x = 30;
			y = 7;
			url = FlowerTile.class.getResource("images/Bamboo.png");
			image = new ImageIcon(url);
			image = new ImageIcon(image.getImage().getScaledInstance(50, -1, 
					Image.SCALE_SMOOTH));
			break;
			
		}
		
	}
	
public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
		g.drawImage(image.getImage(), x, y, this);
		
	}

}
