import java.awt.*;

public class Pancake extends Circle{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Pancake(int x, int y){
		
		super(x, y, Color.RED);
		
	}
	
	public void draw(Graphics g){
		
		g.setColor(Color.GREEN);
		g.fillOval(x - 20, y - 20, 55, 55);
		g.setColor(Color.BLACK);
		g.drawOval(x - 20, y - 20, 55, 55);
		g.setColor(Color.WHITE);
		g.fillOval(x, y - 9, 6, 6);
		g.fillOval(x, y + 18, 6, 6);
		g.fillOval(x - 10, y - 9, 6, 6);
		g.fillOval(x - 10, y, 6, 6);
		g.fillOval(x - 10, y + 9, 6, 6);
		g.fillOval(x - 10, y + 18, 6, 6);
		g.fillOval(x + 10, y - 9, 6, 6);
		g.fillOval(x + 10, y + 18, 6, 6);
		g.fillOval(x + 20, y - 9, 6, 6);
		g.fillOval(x + 20, y, 6, 6);
		g.fillOval(x + 20, y + 9, 6, 6);
		g.fillOval(x + 20, y + 18, 6, 6);
		super.draw(g);
		
	}

	
	
}
