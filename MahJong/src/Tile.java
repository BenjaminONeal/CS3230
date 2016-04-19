import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Tile extends JPanel
{
	public 	final static Color LIGHTBLUE = new Color(99, 184, 255);	//used to build color in the sides of the tile
	public 	final static Color DARKBLUE = new Color(0, 0, 255);		//same

	public 	final static Color CUSTOM_GREEN = new Color(0, 205, 0);	//used in decorating the tile tops
	
	public	final static Dimension SIZE = new Dimension(92, 98);
	public 	final static Color TOP = new Color(255, 231, 186);		//colors for tops
	public 	final static Color TOPLIGHT	= new Color(255, 250, 240);	//same

	
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
	
	//reference points for tiles
	private static int[] xPoints = {0, 0, 10, 10};
	private static int[] yPoints = {90, 20, 10, 80};
	private static int[] xPointsMid = {10, 10, 20, 20};
	private static int[] yPointsMid = {80, 10, 0, 70};
	private static int[] xPointsSide = {80, 10, 0, 70};
	private static int[] yPointsSide = {80, 80, 90, 90};
	private static int[] xPointsSide2 = {90, 20, 10, 80};
	private static int[] yPointsSide2 = {70, 70, 80, 80};

	//polygons for tiles
	public static Polygon tileBottom;
	public static Polygon tileMiddle;
	public static Polygon tileSide;
	public static Polygon tileSide2;
	
	protected static HashMap<String, String> chineseChars = new HashMap<String, String>();
	
	// static initialization block
	static
	{
		tileBottom = new Polygon(xPoints, yPoints, xPoints.length);
		tileMiddle = new Polygon(xPointsMid, yPointsMid, xPoints.length);
		tileSide = new Polygon(xPointsSide, yPointsSide, xPoints.length);
		tileSide2 = new Polygon(xPointsSide2, yPointsSide2, xPoints.length);
		
		chineseChars.put("1", "\u4E00");
		chineseChars.put("2", "\u4E8C");
		chineseChars.put("3", "\u4E09");
		chineseChars.put("4", "\u56DB");
		chineseChars.put("5", "\u4E94");
		chineseChars.put("6", "\u516D");
		chineseChars.put("7", "\u4E03");
		chineseChars.put("8", "\u516B");
		chineseChars.put("9", "\u4E5D");
		chineseChars.put("N", "\u5317");
		chineseChars.put("E", "\u6771");
		chineseChars.put("W", "\u897F");
		chineseChars.put("S", "\u5357");
		chineseChars.put("C", "\u4E2D");
		chineseChars.put("F", "\u767C");
		chineseChars.put("wan", "\u842C");
	}
	
	public Tile()
	{
		setPreferredSize(SIZE);
		setSize(SIZE);
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

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
			
		Graphics2D g2 = (Graphics2D)g;
		GradientPaint grad = new GradientPaint(0, 70, LIGHTBLUE, 70, 0, DARKBLUE, true);
		g2.setPaint(grad);
		
		g.fillPolygon(tileBottom);
		g.fillPolygon(tileSide);
		
		GradientPaint gradTop = new GradientPaint(20, 70, TOPLIGHT, 70, 0, TOP, false);
		
		g2.setPaint(gradTop);
		g.fillRect(20, 0, 70, 70);
		g.fillPolygon(tileMiddle);
		g.fillPolygon(tileSide2);
		
		g2.setPaint(Color.BLACK);
		g.drawPolygon(tileBottom);
		g.drawPolygon(tileMiddle);
		g.drawPolygon(tileSide);
		g.drawPolygon(tileSide2);
		g.drawRect(20, 0, 70, 70);
	}
	
	public boolean matches(Tile other)
	{
		return this.getClass().equals(other.getClass());
	}
	
	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Tile");
		frame.add(new Tile());
		frame.pack();
		frame.setVisible(true);
	}
}