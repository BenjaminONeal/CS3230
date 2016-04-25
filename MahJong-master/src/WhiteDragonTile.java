import java.awt.*;

public class WhiteDragonTile extends Tile{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WhiteDragonTile(){
	
		setToolTipText(toString());
	
	}
	
	public String toString(){
		
		return "White Dragon";
		
	}

	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
		g.setColor(Color.BLUE);
		
		boolean filled = true;
		
		for (int i = 5; i < 65; i += 10){
			
			if (filled){
				
				g.fillRect(30, i, 6, 10);
				g.drawRect(75, i, 5, 10);
				filled = false;
				
			}
				
			else{
				
				g.drawRect(30, i, 5, 10);
				g.fillRect(75, i, 6, 11);
				filled = true;
				
			}
			
		}
		
		for (int i = 35; i < 75; i += 10){
			
			if (filled){
				
				g.drawRect(i, 5, 10, 5);
				g.fillRect(i, 60, 10, 6);
				filled = false;
				
			}
				
			else{
				
				g.fillRect(i, 5, 10, 6);
				g.drawRect(i, 60, 10, 5);
				filled = true;
				
			}
			
		}
	
	}
	
	/*public static void main(String[] args)
	{
	
	JFrame	frame = new JFrame();

	frame.setLayout(new FlowLayout());
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setTitle("White Dragon Tile");

	frame.add(new WhiteDragonTile());
	
	frame.pack();
	frame.setVisible(true);
	
	}*/

}
