import java.awt.*;
import javax.swing.*;

public class Circle extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int x;
	protected int y;
	protected Color color;
	
	public Circle(int x, int y, Color color){
		
		this.x = x;
		this.y = y;
		this.color = color;
		
	}
	
	public void draw(Graphics g){
		
		g.setColor(color);
		g.fillOval(x, y, 15, 15);
		g.setColor(Color.WHITE);
		g.drawLine(x + 3, y + 3, x + 12, y + 12);
		g.drawLine(x + 3, y + 12, x + 12, y + 3);
		
	}
	
}
