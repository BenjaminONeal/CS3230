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
		g.fillOval(x, y, 12 , 12);
		g.setColor(Color.WHITE);
		g.drawLine(x+4, y+4, x+8, y+8);
		g.drawLine(x+8, y+4, x+4, y+8);
	}
}