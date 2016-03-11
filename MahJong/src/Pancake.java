import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class Pancake extends Circle
{

	public Pancake(int x, int y, Color c) 
	{
		super(x, y, c);
	}
	
	public void draw(Graphics g)
	{
		g.setColor(Tile.MYGREEN);
		g.fillOval(30, 10, 50, 50);
		g.setColor(Color.WHITE);
		super.draw(g);
		g.setColor(Color.BLACK);
		g.drawOval(30, 10, 50, 50);
		Graphics2D	g2 = (Graphics2D)g;
		g2.setColor(Color.WHITE);
		g2.setStroke(new BasicStroke(4.0f, BasicStroke.CAP_ROUND, 
				BasicStroke.JOIN_MITER, 5.0f, new float[] {0.4f, 7.0f}, 10.0f));
		g2.drawOval(35, 15, 40, 40);
		
	}

}