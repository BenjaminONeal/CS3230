
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.JFrame;


	public class RotatedBamboo extends RankTile
	{	
		public RotatedBamboo(int rank)
		{
			super(rank);
			setToolTipText(toString());
		}

		@Override
		public String toString()
		{
			return "Bamboo " + rank;
		}
		
		@Override
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D)g;
			AffineTransform old = g2d.getTransform();
	        
			drawBamboo(g, 28, 3, CUSTOM_GREEN);
			drawBamboo(g, 28, 46, Color.BLUE);
			drawBamboo(g, 70, 3, CUSTOM_GREEN);
			drawBamboo(g, 70, 46, Color.BLUE);
			g2d.rotate(Math.toRadians(45));//start rotating
			drawBamboo(g, 45, -15, CUSTOM_GREEN);
//			drawBamboo(g, 49, 46, Color.BLUE);
//			drawBamboo(g, 35, 24, Color.RED);
//			drawBamboo(g, 63, 24, Color.RED);
			g2d.setTransform(old);//stop rotating
		}

	public void drawBamboo(Graphics g, int x, int y, Color c)
	{
		g.setColor(c);
		g.fillOval(x, y, 11, 5);
		g.fillOval(x, y+8, 11, 5);
		g.fillOval(x, y+16, 11, 5);
		g.fillRoundRect(x+3, y+1, 6, 20, 2, 2);
		g.setColor(Color.WHITE);
		g.drawLine(x+6, y+4, x+6, y+16);	//Vertical line
		g.drawLine(x+3, y+10, x+8, y+10);	//Horizontal line
	}
		
	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Bamboo Tiles");

		frame.add(new RotatedBamboo(8));

		frame.pack();
		frame.setVisible(true);
	}
}
