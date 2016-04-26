import java.awt.*;

public class Pancake extends Circle
{
	private static final long serialVersionUID = 1L;

	public Pancake(int xCoord, int yCoord)
	{	
		super(xCoord, yCoord, Color.RED);
	}
	
	public void draw(Graphics g)
	{
		g.setColor(Color.GREEN);
		g.fillOval(xCoord - 20, yCoord - 20, 55, 55);
		g.setColor(Color.BLACK);
		g.drawOval(xCoord - 20, yCoord - 20, 55, 55);
		g.setColor(Color.WHITE);
		g.fillOval(xCoord, yCoord - 9, 6, 6);
		g.fillOval(xCoord, yCoord + 18, 6, 6);
		g.fillOval(xCoord - 10, yCoord - 9, 6, 6);
		g.fillOval(xCoord - 10, yCoord, 6, 6);
		g.fillOval(xCoord - 10, yCoord + 9, 6, 6);
		g.fillOval(xCoord - 10, yCoord + 18, 6, 6);
		g.fillOval(xCoord + 10, yCoord - 9, 6, 6);
		g.fillOval(xCoord + 10, yCoord + 18, 6, 6);
		g.fillOval(xCoord + 20, yCoord - 9, 6, 6);
		g.fillOval(xCoord + 20, yCoord, 6, 6);
		g.fillOval(xCoord + 20, yCoord + 9, 6, 6);
		g.fillOval(xCoord + 20, yCoord + 18, 6, 6);
		super.draw(g);
	}
}
