import java.util.*;
import java.awt.*;

public class CircleTile extends RankTile
{
	private static final long serialVersionUID = 1L;
	private ArrayList<Circle> circlesList = new ArrayList<Circle>();
	
	public CircleTile(int inRank)
	{	
		super(inRank);
		setToolTipText(toString());
		
		switch (inRank)
		{
			case 1:
				circlesList.add(new Pancake(48, 30));
				break;
			case 2:
				circlesList.add(new Circle(48, 5, Color.GREEN));
				circlesList.add(new Circle(48, 55, Color.RED));
				break;
			case 3:
				circlesList.add(new Circle(33, 5, Color.BLUE));
				circlesList.add(new Circle(48, 30, Color.RED));
				circlesList.add(new Circle(63, 55, Color.GREEN));
				break;
			case 4:
				circlesList.add(new Circle(33, 5, Color.BLUE));
				circlesList.add(new Circle(63, 5, Color.GREEN));
				circlesList.add(new Circle(33, 55, Color.GREEN));
				circlesList.add(new Circle(63, 55, Color.BLUE));
				break;
			case 5:
				circlesList.add(new Circle(33, 5, Color.BLUE));
				circlesList.add(new Circle(63, 5, Color.GREEN));
				circlesList.add(new Circle(48, 30, Color.RED));
				circlesList.add(new Circle(33, 55, Color.GREEN));
				circlesList.add(new Circle(63, 55, Color.BLUE));
				break;
			case 6:
				circlesList.add(new Circle(33, 5, Color.GREEN));
				circlesList.add(new Circle(63, 5, Color.GREEN));
				circlesList.add(new Circle(33, 30, Color.RED));
				circlesList.add(new Circle(63, 30, Color.RED));
				circlesList.add(new Circle(33, 55, Color.RED));
				circlesList.add(new Circle(63, 55, Color.RED));
				break;
			case 7:
				circlesList.add(new Circle(33, 5, Color.GREEN));
				circlesList.add(new Circle(51, 10, Color.GREEN));
				circlesList.add(new Circle(68, 15, Color.GREEN));
				circlesList.add(new Circle(33, 35, Color.RED));
				circlesList.add(new Circle(63, 35, Color.RED));
				circlesList.add(new Circle(33, 55, Color.RED));
				circlesList.add(new Circle(63, 55, Color.RED));
				break;
			case 8:
				circlesList.add(new Circle(33, 5, Color.BLUE));
				circlesList.add(new Circle(63, 5, Color.BLUE));
				circlesList.add(new Circle(33, 22, Color.BLUE));
				circlesList.add(new Circle(63, 22, Color.BLUE));
				circlesList.add(new Circle(33, 38, Color.BLUE));
				circlesList.add(new Circle(63, 38, Color.BLUE));
				circlesList.add(new Circle(33, 55, Color.BLUE));
				circlesList.add(new Circle(63, 55, Color.BLUE));
				break;
			case 9:
				circlesList.add(new Circle(28, 5, Color.GREEN));
				circlesList.add(new Circle(68, 5, Color.GREEN));
				circlesList.add(new Circle(48, 5, Color.GREEN));
				circlesList.add(new Circle(28, 30, Color.RED));
				circlesList.add(new Circle(48, 30, Color.RED));
				circlesList.add(new Circle(68, 30, Color.RED));
				circlesList.add(new Circle(28, 55, Color.BLUE));
				circlesList.add(new Circle(48, 55, Color.BLUE));
				circlesList.add(new Circle(68, 55, Color.BLUE));
				break;
		}
	}
	
	public String toString()
	{	
		return "Circle " + rank;	
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		for (Circle c : circlesList)
			if (c != null)
				c.draw(g);
	}
	
	/*public static void main(String[] args)
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
	}*/

}
