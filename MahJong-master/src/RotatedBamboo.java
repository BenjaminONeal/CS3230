import java.awt.*;

public class RotatedBamboo extends Bamboo
{
	private static final long serialVersionUID = 1L;
	private int degree;
	public RotatedBamboo(int x, int y, Color color, int degree)
	{
		super(x, y, color);
		this.degree = degree;
	}
	
	public void draw(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		
		g2.rotate(Math.toRadians(degree));
		super.draw(g2);
	}
}
