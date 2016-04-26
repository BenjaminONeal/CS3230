import java.awt.*;

import javax.swing.*;

public class Bamboo extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	private int xCoord;
	private int yCoord;
	private Color color;
	
	public Bamboo(int xCoord, int yCoord, Color color)
	{	
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.color = color;
	}
	
	public void draw(Graphics g)
	{	
		g.setColor(color);
		g.fillArc(xCoord, yCoord, 11, 11, 0, 180);
		g.fillRect(xCoord + 4, yCoord + 1, 4, 7);
		g.setColor(Color.WHITE);
		g.drawLine(xCoord + 6, yCoord + 5, xCoord + 6, yCoord + 7);
		
		g.setColor(color);
		g.fillArc(xCoord, yCoord + 7, 11, 11, 0, 180);
		g.fillRect(xCoord + 4, yCoord + 8, 4, 7);
		g.setColor(Color.WHITE);
		g.drawLine(xCoord + 6, yCoord + 12, xCoord + 6, yCoord + 14);
		
		g.setColor(color);
		g.fillArc(xCoord, yCoord + 14, 11, 11, 0, 180);	
	}
}
