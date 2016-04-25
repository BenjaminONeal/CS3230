import java.awt.*;


public class CharacterTile extends Tile{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] character = { "\u4E00", "\u4E8C", "\u4E09", "\u56DB", "\u4E94", "\u516D", 
			"\u4E03", "\u516B", "\u4E5D" };
	protected char symbol;
	
	public CharacterTile(char inSymbol){
		
			symbol = inSymbol;
			setToolTipText(toString());
			
	}
	
	boolean matches(Tile inOther){
		
		CharacterTile otherTile = (CharacterTile) inOther;
		
		if (this.getClass() == inOther.getClass() && this.symbol == otherTile.symbol) 
			return true;
		else
			return false;
		
	}
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
		Font f = g.getFont().deriveFont(30F);
		Font h = g.getFont().deriveFont(5);
		
		switch(symbol){
			
			case 'N' :
			case 'n' :
				g.setColor(Color.RED);
				g.drawString("N", 73, 15);
				g.setFont(f);
				g.setColor(Color.BLACK);
				g.drawString("\u5317", 40, 50);
				break;
			case 'E' :
			case 'e' :
				g.setFont(h);
				g.setColor(Color.RED);
				g.drawString("E", 73, 15);
				g.setFont(f);
				g.setColor(Color.BLACK);
				g.drawString("\u6771", 40, 50);
				break;
			case 'W' :
			case 'w' :
				g.setFont(h);
				g.setColor(Color.RED);
				g.drawString("W", 73, 15);
				g.setFont(f);
				g.setColor(Color.BLACK);
				g.drawString("\u897F", 40, 50);
				break;
			case 'S' :
			case 's' :
				g.setFont(h);
				g.setColor(Color.RED);
				g.drawString("S", 73, 15);
				g.setFont(f);
				g.setColor(Color.BLACK);
				g.drawString("\u5357", 40, 50);
				break;
			case 'C' :
			case 'c' :
				g.setFont(h);
				g.setColor(Color.RED);
				g.drawString("C", 73, 15);
				g.setFont(f);
				g.setColor(Color.RED);
				g.drawString("\u4E2D", 40, 50);
				break;
			case 'F' :
			case 'f' :
				g.setFont(h);
				g.setColor(Color.RED);
				g.drawString("F", 73, 15);
				g.setFont(f);
				g.setColor(Color.GREEN);
				g.drawString("\u767C", 40, 50);
				break;
			default:
				g.setFont(h);
				g.setColor(Color.RED);
				g.drawString("" + symbol, 73, 15);
				g.setFont(f);
				g.setColor(Color.BLACK);
				g.drawString(character[symbol - 49], 40, 30);
				g.setFont(f);
				g.setColor(Color.RED);
				g.drawString("\u842C", 40, 65);
			
		}
		
	}
	
	public String toString(){
		
		switch(symbol){
		
		case 'N' :
		case 'n' :
			return "North Wind";
		case 'E' :
		case 'e' :
			return "East Wind";
		case 'W' :
		case 'w' :
			return "West Wind";
		case 'S' :
		case 's' :
			return "South Wind";
		case 'C' :
		case 'c' :
			return "Red Dragon";
		case 'F' :
		case 'f' :
			return "Green Dragon";
		default:
			return "Character " + symbol;
			
		}
		
	}
	
	/*public static void main(String[] args)
	{
		JFrame		frame = new JFrame();
		JPanel		tiles = new JPanel();
		JScrollPane	scroller = new JScrollPane(tiles);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Character Tiles");
		frame.add(scroller);

		// Try something like this if your tiles don't fit on the screen.
		// Replace "tile width" and "tile height" with your values.
		scroller.setPreferredSize(new Dimension(8 * 85, 40 + 100));

		tiles.add(new CharacterTile('1'));
		tiles.add(new CharacterTile('2'));
		tiles.add(new CharacterTile('3'));
		tiles.add(new CharacterTile('4'));
		tiles.add(new CharacterTile('5'));
		tiles.add(new CharacterTile('6'));
		tiles.add(new CharacterTile('7'));
		tiles.add(new CharacterTile('8'));
		tiles.add(new CharacterTile('9'));
		tiles.add(new CharacterTile('N'));
		tiles.add(new CharacterTile('E'));
		tiles.add(new CharacterTile('W'));
		tiles.add(new CharacterTile('S'));
		tiles.add(new CharacterTile('C'));
		tiles.add(new CharacterTile('F'));

		frame.pack();
		frame.setVisible(true);
	}*/

}
