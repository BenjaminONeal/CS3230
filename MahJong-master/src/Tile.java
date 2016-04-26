import java.awt.*;

import javax.swing.*;

abstract public class Tile extends JPanel
{
	private static final long serialVersionUID = 1L;
	private static final Dimension SIZE;
	private static final GradientPaint GRAD1;
	private static final GradientPaint GRAD2;
	private static final GradientPaint GRAD3;
	private static final GradientPaint GRAD4;
	private static final GradientPaint GRAD5;
	private static final Polygon POLY1;
	private static final Polygon POLY2;
	private static final Polygon POLY3;
	private static final Polygon POLY4;
	
	protected int x;
	protected int y;
	private int zOrder;
	protected Tile left = null;
	protected Tile left2 = null;
	protected Tile right = null;
	protected Tile right2 = null;
	protected Tile top = null;
	protected Tile bottom = null;
	protected Tile bottom2 = null;
	protected Tile bottom3 = null;
	protected Tile bottom4 = null;
	
	public 	final static Color LIGHTBLUE = new Color(99, 184, 255);	//used to build color in the sides of the tile
	public 	final static Color DARKBLUE = new Color(0, 0, 255);		//same

	public 	final static Color CUSTOM_GREEN = new Color(0, 205, 0);	//used in decorating the tile tops
	

	public 	final static Color TOP = new Color(255, 231, 186);		//colors for tops
	public 	final static Color TOPLIGHT	= new Color(255, 250, 240);	//same
	
	public Tile(){
		
		setSize(SIZE);
		setPreferredSize(SIZE);
		setOpaque(false);
		
	}
	
	public void setZOrder()
	{
		zOrder = getParent().getComponentZOrder(this);
	}


	public int getZOrder()
	{
		return zOrder;
	}
	
	public void paintComponent(Graphics g){
			
		super.paintComponent(g);
			
		Graphics2D g2 = (Graphics2D)g;
			
		g2.setPaint(GRAD1);
		g2.fillRect(25, 0, 60, 75);
			
		g2.setPaint(GRAD2);
		g2.fillPolygon(POLY1);
			
		g2.setPaint(GRAD3);
		g2.fillPolygon(POLY2);
		
		g2.setPaint(GRAD4);
		g2.fillPolygon(POLY3);
		
		g2.setPaint(GRAD5);
		g2.fillPolygon(POLY4);
		
	}
	
	static{
		
		SIZE = new Dimension(85, 100);
		GRAD1 = new GradientPaint(85, 0, LIGHTBLUE, 25,75, Color.WHITE);
		GRAD2 = new GradientPaint(25, 0, LIGHTBLUE, 13, 87, Color.WHITE);
		GRAD3 = new GradientPaint(13, 13, DARKBLUE, 6, 100, Color.WHITE);
		GRAD4 = new GradientPaint(85, 85, Color.LIGHT_GRAY, 13, 87, Color.WHITE);
		GRAD5 = new GradientPaint(73, 87, DARKBLUE, 6, 100, Color.WHITE);
		
		int[] x1 = { 25, 13, 13, 25 };
		int[] y1 = { 0, 13, 87, 75 };
		int[] x2 = { 13, 6, 6, 13 };
		int[] y2 = { 13, 25, 99, 87 };
		int[] x3 = { 25, 13, 73, 85 };
		int[] y3 = { 75, 87, 87, 75 };
		int[] x4 = { 13, 6, 60, 73 };
		int[] y4 = { 87, 99, 99, 87 };
		
		POLY1 = new Polygon(x1, y1, 4);
		POLY2 = new Polygon(x2, y2, 4);
		POLY3 = new Polygon(x3, y3, 4);
		POLY4 = new Polygon(x4, y4, 4);
	}

	boolean matches(Tile inOther){
		
		if (this.getClass() == inOther.getClass()) 
			return true;
		else
			return false;
		
	}
	
	/*public static void main(String[] args){
		
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Tile");

		frame.add(new Tile());

		frame.pack();
		frame.setVisible(true);
		
	}*/
	
}
