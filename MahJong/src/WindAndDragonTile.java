import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class WindAndDragonTile extends AbstractCharacterTile
{
	private String chineseSymbol;

	public WindAndDragonTile(char symbol) 
	{
		super(symbol);
		chineseSymbol = Tile.chineseChars.get(Character.toString(symbol));
		setToolTipText(toString());
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.setColor(Color.RED);
		g.drawString(Character.toString(symbol), 75, 15);
		
		if (symbol == 'N' || symbol == 'E' || symbol == 'W' || symbol == 'S' )
		{
			drawSymbol(g, Color.BLACK);
		}
		
		if (symbol == 'C' )
		{
			drawSymbol(g, Color.RED);
		}
		
		if (symbol == 'F' )
		{
			drawSymbol(g, Color.GREEN);
		}

	}
	
	@Override
	public void drawSymbol(Graphics g, Color c)
	{
		Font f = g.getFont();
		FontMetrics fm = g.getFontMetrics();
		int wid = fm.stringWidth(chineseSymbol);
		
		g.setColor(c);
		f = f.deriveFont(f.getSize2D() * 4.5F);
		g.setFont(f);
		g.drawString( chineseSymbol, (getWidth() - (wid + 25) ) / 2, (getHeight() + 20) / 2);
	}
	
	public static void main(String[] args)
	{
		JFrame		frame = new JFrame();
		JPanel		tiles = new JPanel();
		JScrollPane	scroller = new JScrollPane(tiles);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Character Tiles");
		frame.add(scroller);

		tiles.add(new WindAndDragonTile('N'));
		tiles.add(new WindAndDragonTile('E'));
		tiles.add(new WindAndDragonTile('W'));
		tiles.add(new WindAndDragonTile('S'));
		tiles.add(new WindAndDragonTile('C'));
		tiles.add(new WindAndDragonTile('F'));
		frame.pack();
		frame.setVisible(true);
	}
}