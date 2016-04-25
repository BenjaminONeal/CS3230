import java.awt.*;
import javax.swing.*;

public class Bamboo extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	private Color color;
	
	public Bamboo(int x, int y, Color color){
		
		this.x = x;
		this.y = y;
		this.color = color;
		
	}
	
	public void draw(Graphics g){
		
		g.setColor(color);
		g.fillArc(x, y, 11, 11, 0, 180);
		g.fillRect(x + 4, y + 1, 4, 7);
		g.setColor(Color.WHITE);
		g.drawLine(x + 6, y + 5, x + 6, y + 7);
		
		g.setColor(color);
		g.fillArc(x, y + 7, 11, 11, 0, 180);
		g.fillRect(x + 4, y + 8, 4, 7);
		g.setColor(Color.WHITE);
		g.drawLine(x + 6, y + 12, x + 6, y + 14);
		
		g.setColor(color);
		g.fillArc(x, y + 14, 11, 11, 0, 180);
		
	}

}
