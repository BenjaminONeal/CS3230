import java.util.*;

public class TileStack
{
	protected ArrayList<Tile> tileStack = new ArrayList<Tile>();
	
	public TileStack()
	{
		for (int i = 0; i < 4; i++)
		{
			tileStack.add(new Bamboo1Tile());
			tileStack.add(new BambooTile(2));
			tileStack.add(new BambooTile(3));
			tileStack.add(new BambooTile(4));
			tileStack.add(new BambooTile(5));
			tileStack.add(new BambooTile(6));
			tileStack.add(new BambooTile(7));
			tileStack.add(new BambooTile(8));
			tileStack.add(new BambooTile(9));
			tileStack.add(new CircleTile(1));
			tileStack.add(new CircleTile(2));
			tileStack.add(new CircleTile(3));
			tileStack.add(new CircleTile(4));
			tileStack.add(new CircleTile(5));
			tileStack.add(new CircleTile(6));
			tileStack.add(new CircleTile(7));
			tileStack.add(new CircleTile(8));
			tileStack.add(new CircleTile(9));
			tileStack.add(new CharacterTile('1'));
			tileStack.add(new CharacterTile('2'));
			tileStack.add(new CharacterTile('3'));
			tileStack.add(new CharacterTile('4'));
			tileStack.add(new CharacterTile('5'));
			tileStack.add(new CharacterTile('6'));
			tileStack.add(new CharacterTile('7'));
			tileStack.add(new CharacterTile('8'));
			tileStack.add(new CharacterTile('9'));
			tileStack.add(new CharacterTile('N'));
			tileStack.add(new CharacterTile('S'));
			tileStack.add(new CharacterTile('E'));
			tileStack.add(new CharacterTile('W'));
			tileStack.add(new CharacterTile('C'));
			tileStack.add(new CharacterTile('F'));
			tileStack.add(new WhiteDragonTile());		
		}
		
		tileStack.add(new SeasonTile("Spring"));
		tileStack.add(new SeasonTile("Summer"));
		tileStack.add(new SeasonTile("Fall"));
		tileStack.add(new SeasonTile("Winter"));
		tileStack.add(new FlowerTile("Chrysanthemum"));
		tileStack.add(new FlowerTile("Orchid"));
		tileStack.add(new FlowerTile("Plum"));
		tileStack.add(new FlowerTile("Bamboo"));

		Collections.shuffle(tileStack);
	}
}
