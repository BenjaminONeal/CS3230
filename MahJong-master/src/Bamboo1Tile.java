import java.awt.*;
import java.net.*;
import javax.swing.*;

public class Bamboo1Tile extends PictureTile{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private	ImageIcon	image;
	private URL url;
	Dimension	screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	public Bamboo1Tile(){
		
		super("sparrow");
		
		url = Bamboo1Tile.class.getResource("images/Sparrow.png");
		image = new ImageIcon(url);
		image = new ImageIcon(image.getImage().getScaledInstance(50, -1, 
				Image.SCALE_SMOOTH));
		
	}
	
public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
		g.drawImage(image.getImage(), 30, 15, this);
		
	}
	
	public String toString(){
		
		return "Bamboo 1";
		
	}
	
}
