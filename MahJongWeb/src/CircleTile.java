import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JFrame;


public class CircleTile extends RankTile
{
	final Circle circles[] = new Circle[9];
	
	public CircleTile(int rank)
	{
		super(rank);
		setToolTipText(toString());
		switch(rank){
		case 1:
			circles[0] = new Pancake( 49, 29, Color.RED);
			break;
		case 2:
			circles[0] = new Circle(45 + 3, 35 - 21, MYGREEN);
			circles[1] = new Circle(45 + 3, 35 + 9, Color.RED);
			break;
		case 3:
			circles[0] = new Circle(25, 5, Color.BLUE);
			circles[1] = new Circle(49, 29, Color.RED);
			circles[2] = new Circle(72, 52, MYGREEN);
			break;
		case 4:
			circles[0] = new Circle(45 - 12, 35 - 21, Color.BLUE);
			circles[1] = new Circle(45 - 12, 35 + 9, MYGREEN);
			circles[2] = new Circle(45 + 18, 35 - 21, MYGREEN);
			circles[3] = new Circle(45 + 18, 35 + 9, Color.BLUE);
			break;
		case 5:
			circles[0] = new Circle(25, 5, Color.BLUE);
			circles[1] = new Circle(49, 29, Color.RED);
			circles[2] = new Circle(72, 52, Color.BLUE);
			circles[3] = new Circle(72, 5, MYGREEN);
			circles[4] = new Circle(25, 52, MYGREEN);
			break;
		case 6:
			circles[0] = new Circle(45 - 12, 5, MYGREEN);
			circles[1] = new Circle(45 + 18, 5, MYGREEN);
			circles[2] = new Circle(45 - 12, 29, Color.RED);
			circles[3] = new Circle(45 + 18, 29, Color.RED);
			circles[4] = new Circle(45 - 12, 52, Color.RED);
			circles[5] = new Circle(45 + 18, 52, Color.RED);
			break;
		case 7:
			circles[0] = new Circle(25, 5, MYGREEN);
			circles[1] = new Circle(49, 15, MYGREEN);
			circles[2] = new Circle(72, 27, MYGREEN);
			circles[3] = new Circle(45 - 12, 38, Color.RED);
			circles[4] = new Circle(45 + 18, 38, Color.RED);
			circles[5] = new Circle(45 - 12, 52, Color.RED);
			circles[6] = new Circle(45 + 18, 52, Color.RED);
			break;
		case 8:
			circles[0] = new Circle(45 - 12, 2, Color.BLUE);
			circles[1] = new Circle(45 + 18, 2, Color.BLUE);
			circles[2] = new Circle(45 - 12, 20, Color.BLUE);
			circles[3] = new Circle(45 + 18, 20, Color.BLUE);
			circles[4] = new Circle(45 - 12, 38, Color.BLUE);
			circles[5] = new Circle(45 + 18, 38, Color.BLUE);
			circles[6] = new Circle(45 + 18, 55, Color.BLUE);
			circles[7] = new Circle(45 - 12, 55, Color.BLUE);
			break;
		case 9:
			circles[0] = new Circle(25, 5, MYGREEN);
			circles[1] = new Circle(49, 5, MYGREEN);
			circles[2] = new Circle(72, 5, MYGREEN);
			circles[3] = new Circle(25, 29, Color.RED);
			circles[4] = new Circle(49, 29, Color.RED);
			circles[5] = new Circle(72, 29, Color.RED);
			circles[6] = new Circle(25, 52, Color.BLUE);
			circles[7] = new Circle(49, 52, Color.BLUE);
			circles[8] = new Circle(72, 52, Color.BLUE);
			break;
		}
	}

	@Override
	public String toString()
	{
		return "Circle " + rank ;
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		for (Circle c : circles)
			if (c != null)
				c.draw(g);
	}
	
	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Circle Tiles");

		frame.add(new CircleTile(1));
		frame.add(new CircleTile(2));
		frame.add(new CircleTile(3));
		frame.add(new CircleTile(4));
		frame.add(new CircleTile(5));
		frame.add(new CircleTile(6));
		frame.add(new CircleTile(7));
		frame.add(new CircleTile(8));
		frame.add(new CircleTile(9));

		frame.pack();
		frame.setVisible(true);
	}
}