import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JFrame;


public class BambooTile extends RankTile
{	
	public BambooTile(int rank)
	{
		super(rank);
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
		switch(rank){
		case 2:
			drawBamboo(g, 49, 13, Color.BLUE);
			drawBamboo(g, 49, 34, MYGREEN);
			break;
		case 3:
			drawBamboo(g, 49, 13, Color.BLUE);
			drawBamboo(g, 35, 34, MYGREEN);
			drawBamboo(g, 63, 34, MYGREEN);
			break;
		case 4:
			drawBamboo(g, 35, 13, Color.BLUE);
			drawBamboo(g, 35, 34, MYGREEN);
			drawBamboo(g, 63, 13, MYGREEN);
			drawBamboo(g, 63, 34, Color.BLUE);
			break;
		case 5:
			drawBamboo(g, 28, 13, MYGREEN);
			drawBamboo(g, 28, 34, Color.BLUE);
			drawBamboo(g, 49, 25, Color.RED);
			drawBamboo(g, 70, 13, Color.BLUE);
			drawBamboo(g, 70, 34, MYGREEN);
			break;
		case 6:
			drawBamboo(g, 28, 13, MYGREEN);
			drawBamboo(g, 28, 34, Color.BLUE);
			drawBamboo(g, 49, 13, MYGREEN);
			drawBamboo(g, 49, 34, Color.BLUE);
			drawBamboo(g, 70, 13, MYGREEN);
			drawBamboo(g, 70, 34, Color.BLUE);
			break;
		case 7:
			drawBamboo(g, 49, 3, Color.RED);
			drawBamboo(g, 28, 25, MYGREEN);
			drawBamboo(g, 28, 46, Color.BLUE);
			drawBamboo(g, 49, 25, MYGREEN);
			drawBamboo(g, 49, 46, Color.BLUE);
			drawBamboo(g, 70, 25, MYGREEN);
			drawBamboo(g, 70, 46, Color.BLUE);
			break;
		case 8:
			drawBamboo(g, 28, 3, MYGREEN);
			drawBamboo(g, 28, 46, Color.BLUE);
			drawBamboo(g, 49, 3, MYGREEN);
			drawBamboo(g, 49, 46, Color.BLUE);
			drawBamboo(g, 70, 3, MYGREEN);
			drawBamboo(g, 70, 46, Color.BLUE);
			drawBamboo(g, 35, 24, Color.RED);
			drawBamboo(g, 63, 24, Color.RED);
			break;
		case 9:
			drawBamboo(g, 28, 3, Color.RED);
			drawBamboo(g, 28, 24, Color.RED);
			drawBamboo(g, 49, 3, Color.BLUE);
			drawBamboo(g, 49, 24, Color.BLUE);
			drawBamboo(g, 70, 3, MYGREEN);
			drawBamboo(g, 70, 24, MYGREEN);
			drawBamboo(g, 28, 46, Color.RED);
			drawBamboo(g, 49, 46, Color.BLUE);
			drawBamboo(g, 70, 46, MYGREEN);
			break;
		}
		
	}
	
	public void drawBamboo(Graphics g, int x, int y, Color c)
	{
		g.setColor(c);
		g.fillOval(x, y, 10, 5);
		g.fillOval(x, y+16, 10, 5);
		g.fillRoundRect(x+2, y+1, 6, 20, 2, 2);
		g.setColor(Color.WHITE);
		g.drawLine(x+5, y+2, x+5, y+19);
		g.setColor(c);
		g.fillOval(x, y+8, 10, 5);
	}
	
	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Bamboo Tiles");

		frame.add(new BambooTile(2));
		frame.add(new BambooTile(3));
		frame.add(new BambooTile(4));
		frame.add(new BambooTile(5));
		frame.add(new BambooTile(6));
		frame.add(new BambooTile(7));
		frame.add(new BambooTile(8));
		frame.add(new BambooTile(9));

		frame.pack();
		frame.setVisible(true);
	}
	
}