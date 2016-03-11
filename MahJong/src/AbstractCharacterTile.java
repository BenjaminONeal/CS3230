import java.awt.Color;
import java.awt.Graphics;
import java.util.Objects;


public abstract class AbstractCharacterTile extends Tile
{
	protected char symbol;
	
	
	public AbstractCharacterTile(char symbol)
	{
		this.symbol = symbol;
	}
	
	public abstract void drawSymbol(Graphics g, Color c);
	
	@Override
	public boolean matches(Tile other)
	{
		AbstractCharacterTile otherObject = (AbstractCharacterTile) other;
		return super.matches(other)
				&& symbol == otherObject.symbol
				&& Objects.equals(symbol, otherObject.symbol);
	}

	@Override
	public String toString()
	{
		if (symbol >= '1' && symbol <= '9')
		{
			return "Character " + symbol;
		}
		else if (symbol == 'N')
		{
			return "North Wind";
		}
		else if (symbol == 'E')
		{
			return "East Wind";
		}
		else if (symbol == 'W')
		{
			return "West Wind";
		}
		else if (symbol == 'S')
		{
			return "South Wind";
		}
		else if (symbol == 'C')
		{
			return "Red Dragon";
		}
		else if (symbol == 'F')
		{
			return "Green Dragon";
		}
		else
		{
			return "Invalid Character symbol";
		}
	}
}