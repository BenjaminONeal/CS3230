import java.awt.Color;
import java.awt.Graphics;


public class Circle
{
	private int x;
	private int y;
	private Color c;
	
	public Circle(int x, int y, Color c) 
	{
		super();
		this.x = x;
		this.y = y;
		this.c = c;
	}
	
	public void draw(Graphics g)
	{
		g.setColor(c);
		g.fillOval(x, y, 14, 14);
		g.setColor(Color.WHITE);
		g.drawLine(x+5, y+5, x+9, y+9);
		g.drawLine(x+9, y+5, x+5, y+9);
	}
}