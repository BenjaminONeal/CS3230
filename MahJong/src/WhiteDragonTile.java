import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

import javax.swing.JFrame;


public class WhiteDragonTile extends Tile
{
	@Override
	public String toString()
	{
		return "White Dragon";
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Stroke blocks = new BasicStroke(4, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL, 
				0, new float[]{6, 14}, 0);
		g.setColor(Color.BLUE);
		g.drawRect(28, 8, 54, 54);
		g.drawRect(32, 12, 46, 46);
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(blocks);
		g2.drawRect(30, 10, 50, 50);
		
		
	}
	
	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("White Dragon Tile");

		frame.add(new WhiteDragonTile());

		frame.pack();
		frame.setVisible(true);
	}
}