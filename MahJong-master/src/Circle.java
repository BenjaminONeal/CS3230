import java.awt.*;
import javax.swing.*;

public class Circle extends JPanel
{
	private static final long serialVersionUID = 1L;
	protected int xCoord;
	protected int yCoord;
	protected Color color;
	
	public Circle(int xCoord, int yCoord, Color color)
	{	
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.color = color;
	}
	
	public void draw(Graphics g)
	{
		g.setColor(color);
		g.fillOval(xCoord, yCoord, 15, 15);
		g.setColor(Color.WHITE);
		g.drawLine(xCoord + 3, yCoord + 3, xCoord + 12, yCoord + 12);
		g.drawLine(xCoord + 3, yCoord + 12, xCoord + 12, yCoord + 3);
	}
}
