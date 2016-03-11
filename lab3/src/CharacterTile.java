
public class CharacterTile extends Tile
{
	protected char symbol;	
	public CharacterTile(char symbol)
	{
		this.symbol = symbol;
	}
	public boolean matches(Tile other)
	{
		if (!super.matches(other)) return false;
		
		CharacterTile ct = (CharacterTile) other;
		return symbol == ct.symbol;
	}
	public String toString()
	{
		switch (symbol)
		{
			case 'N': return "North Wind";
			case 'E': return "East Wind";
			case 'W': return "West Wind";
			case 'S': return "South Wind";
			case 'C': return "Red Dragon";
			case 'F': return "Green Dragon";
			default: return "Character " + symbol;
		}
	}
	public static void main(String[] args)
	{
		CharacterTile ct = new CharacterTile('N');
		System.out.println(ct.toString());
	}
}
