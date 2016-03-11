import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class CharacterTile extends AbstractCharacterTile
{
	private String chineseSymbol;

	public CharacterTile(char symbol) 
	{
		super(symbol);
		setToolTipText(toString());
		chineseSymbol = Tile.chineseChars.get(Character.toString(symbol));
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		g.setColor(Color.RED);
		g.drawString(Character.toString(symbol), 75, 15);
		
		if (symbol >= '1' && symbol <= '9') 
		{
			drawSymbol(g, Color.BLACK);
		}
	}
	
	@Override
	public void drawSymbol(Graphics g, Color c) 
	{
		Font f = g.getFont();
		FontMetrics fm = g.getFontMetrics();
		int wid = fm.stringWidth(chineseSymbol);
		
		g.setColor(c);
		f = f.deriveFont(f.getSize2D() * 2F);
		g.setFont(f);
		g.drawString( chineseSymbol, (getWidth() - (wid - 5)) / 2, (getHeight() + 25) / 4);
		
		g.setColor(Color.RED);
		g.drawString(Tile.chineseChars.get("wan"), (getWidth() - (wid - 5)) / 2, (getHeight() + 25) / 2);
	}
	
	public static void main(String[] args)
	{
		JFrame		frame = new JFrame();
		JPanel		tiles = new JPanel();
		JScrollPane	scroller = new JScrollPane(tiles);
		

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Character Tiles");
		frame.add(scroller);

		// Try something like this if your tiles don't fit on the screen.
		// Replace "tile width" and "tile height" with your values.
		// scroller.setPreferredSize(new Dimension(15 * 92, 40 + 98));

		tiles.add(new CharacterTile('1'));
		tiles.add(new CharacterTile('2'));
		tiles.add(new CharacterTile('3'));
		tiles.add(new CharacterTile('4'));
		tiles.add(new CharacterTile('5'));
		tiles.add(new CharacterTile('6'));
		tiles.add(new CharacterTile('7'));
		tiles.add(new CharacterTile('8'));
		tiles.add(new CharacterTile('9'));
		frame.pack();
		frame.setVisible(true);
	}
}