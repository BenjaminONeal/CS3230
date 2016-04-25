import java.awt.*;
import java.util.ArrayList;

public class BambooTile extends RankTile{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Bamboo> bamboos = new ArrayList<Bamboo>();
	
	public BambooTile(int inRank){
		
		super(inRank);
		setToolTipText(toString());
		
		switch (inRank){
		
		case 2:
			bamboos.add(new Bamboo(48, 15, Color.BLUE));
			bamboos.add(new Bamboo(48, 40, Color.GREEN));
			break;
		case 3:
			bamboos.add(new Bamboo(48, 15, Color.BLUE));
			bamboos.add(new Bamboo(35, 40, Color.GREEN));
			bamboos.add(new Bamboo(65, 40, Color.GREEN));
			break;
		case 4:
			bamboos.add(new Bamboo(33, 15, Color.BLUE));
			bamboos.add(new Bamboo(63, 15, Color.GREEN));
			bamboos.add(new Bamboo(33, 40, Color.GREEN));
			bamboos.add(new Bamboo(63, 40, Color.BLUE));
			break;
		case 5:
			bamboos.add(new Bamboo(33, 15, Color.BLUE));
			bamboos.add(new Bamboo(63, 15, Color.GREEN));
			bamboos.add(new Bamboo(48, 27, Color.RED));
			bamboos.add(new Bamboo(33, 40, Color.GREEN));
			bamboos.add(new Bamboo(63, 40, Color.BLUE));
			break;
		case 6:
			bamboos.add(new Bamboo(33, 15, Color.GREEN));
			bamboos.add(new Bamboo(48, 15, Color.GREEN));
			bamboos.add(new Bamboo(63, 15, Color.GREEN));
			bamboos.add(new Bamboo(33, 40, Color.BLUE));
			bamboos.add(new Bamboo(48, 40, Color.BLUE));
			bamboos.add(new Bamboo(63, 40, Color.BLUE));
			break;
		case 7:
			bamboos.add(new Bamboo(48, 3, Color.RED));
			bamboos.add(new Bamboo(33, 27, Color.GREEN));
			bamboos.add(new Bamboo(48, 27, Color.GREEN));
			bamboos.add(new Bamboo(63, 27, Color.GREEN));
			bamboos.add(new Bamboo(33, 52, Color.BLUE));
			bamboos.add(new Bamboo(48, 52, Color.BLUE));
			bamboos.add(new Bamboo(63, 52, Color.BLUE));
			break;
		case 8:
			bamboos.add(new Bamboo(27, 15, Color.GREEN));
			bamboos.add(new RotatedBamboo(46, -25, Color.GREEN, 45));
			bamboos.add(new RotatedBamboo(23, 55, Color.GREEN, -90));
			bamboos.add(new RotatedBamboo(74, 15, Color.GREEN, 45));
			bamboos.add(new Bamboo(27, 40, Color.BLUE));
			bamboos.add(new RotatedBamboo(-5, 55, Color.BLUE, -45));
			bamboos.add(new RotatedBamboo(74, -25, Color.BLUE, 90));
			bamboos.add(new RotatedBamboo(74, 40, Color.BLUE, -45));
			break;
		case 9:
			bamboos.add(new Bamboo(33, 3, Color.RED));
			bamboos.add(new Bamboo(48, 3, Color.GREEN));
			bamboos.add(new Bamboo(63, 3, Color.BLUE));
			bamboos.add(new Bamboo(33, 27, Color.RED));
			bamboos.add(new Bamboo(48, 27, Color.GREEN));
			bamboos.add(new Bamboo(63, 27, Color.BLUE));
			bamboos.add(new Bamboo(33, 52, Color.RED));
			bamboos.add(new Bamboo(48, 52, Color.GREEN));
			bamboos.add(new Bamboo(63, 52, Color.BLUE));
			break;
			
		}
		
	}
	
	public String toString(){
		
		return "Bamboo " + rank;
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		for (Bamboo b : bamboos)
			if (b != null)
				b.draw(g);
	}
	
	/*public static void main(String[] args)
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
	}*/

}
