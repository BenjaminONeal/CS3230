import java.awt.*;

public class RotatedBamboo extends Bamboo{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int deg;
	
	public RotatedBamboo(int x, int y, Color color, int deg){
		
		super(x, y, color);
		this.deg = deg;
		
	}
	
	public void draw(Graphics g){
		
		Graphics2D g2 = (Graphics2D)g;
		
		g2.rotate(Math.toRadians(deg));
		super.draw(g2);
		
	}

}
