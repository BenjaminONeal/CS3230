import java.awt.*;

import javax.swing.*;

abstract public class Tile extends JPanel
{
	private static final long serialVersionUID = 1L;
	private static final Dimension SIZE;
	private static final GradientPaint GRADIENT1;
	private static final GradientPaint GRADIENT2;
	private static final GradientPaint GRADIENT3;
	private static final GradientPaint GRADIENT4;
	private static final GradientPaint GRADIENT5;
	private static final Polygon POLYGON1;
	private static final Polygon POLYGON2;
	private static final Polygon POLYGON3;
	private static final Polygon POLYGON4;
	
	protected int xCoord;
	protected int yCoord;
	protected Tile left = null;
	protected Tile left2 = null;
	protected Tile right = null;
	protected Tile right2 = null;
	protected Tile top = null;
	protected Tile bottom = null;
	protected Tile bottom2 = null;
	protected Tile bottom3 = null;
	protected Tile bottom4 = null;
	private int zOrder;
	
	public 	final static Color LIGHTBLUE = new Color(99, 184, 255);
	public 	final static Color DARKBLUE = new Color(0, 0, 255);

	public 	final static Color CUSTOM_GREEN = new Color(0, 205, 0);
	
	public 	final static Color TOP = new Color(255, 231, 186);
	public 	final static Color TOPLIGHT	= new Color(255, 250, 240);
	
	public Tile()
	{	
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
	
	public void paintComponent(Graphics g)
	{		
		super.paintComponent(g);		
		Graphics2D g2 = (Graphics2D)g;
		g2.setPaint(GRADIENT1);
		g2.fillRect(25, 0, 60, 75);
		g2.setPaint(GRADIENT2);
		g2.fillPolygon(POLYGON1);
		g2.setPaint(GRADIENT3);
		g2.fillPolygon(POLYGON2);
		g2.setPaint(GRADIENT4);
		g2.fillPolygon(POLYGON3);
		g2.setPaint(GRADIENT5);
		g2.fillPolygon(POLYGON4);
	}
	
	static
	{	
		SIZE = new Dimension(85, 100);
		GRADIENT1 = new GradientPaint(85, 0, LIGHTBLUE, 25,75, Color.WHITE);
		GRADIENT2 = new GradientPaint(25, 0, LIGHTBLUE, 13, 87, Color.WHITE);
		GRADIENT3 = new GradientPaint(13, 13, DARKBLUE, 6, 100, Color.WHITE);
		GRADIENT4 = new GradientPaint(85, 85, Color.LIGHT_GRAY, 13, 87, Color.WHITE);
		GRADIENT5 = new GradientPaint(73, 87, DARKBLUE, 6, 100, Color.WHITE);
		
		int[] xCoord1 = { 25, 13, 13, 25 };
		int[] yCoord1 = { 0, 13, 87, 75 };
		int[] xCoord2 = { 13, 6, 6, 13 };
		int[] yCoord2 = { 13, 25, 99, 87 };
		int[] xCoord3 = { 25, 13, 73, 85 };
		int[] yCoord3 = { 75, 87, 87, 75 };
		int[] xCoord4 = { 13, 6, 60, 73 };
		int[] yCoord4 = { 87, 99, 99, 87 };
		
		POLYGON1 = new Polygon(xCoord1, yCoord1, 4);
		POLYGON2 = new Polygon(xCoord2, yCoord2, 4);
		POLYGON3 = new Polygon(xCoord3, yCoord3, 4);
		POLYGON4 = new Polygon(xCoord4, yCoord4, 4);
	}

	boolean matches(Tile inOther)
	{	
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