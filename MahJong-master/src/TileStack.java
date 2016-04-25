import java.util.*;

public class TileStack{
	
	protected ArrayList<Tile> stack = new ArrayList<Tile>();
	//protected long seedCaptured = 0;
	
	public TileStack(){ //TileStack(boolean nGame)
		
		for (int i = 0; i < 4; i++){
		
			stack.add(new Bamboo1Tile());
			stack.add(new BambooTile(2));
			stack.add(new BambooTile(3));
			stack.add(new BambooTile(4));
			stack.add(new BambooTile(5));
			stack.add(new BambooTile(6));
			stack.add(new BambooTile(7));
			stack.add(new BambooTile(8));
			stack.add(new BambooTile(9));
			stack.add(new CircleTile(1));
			stack.add(new CircleTile(2));
			stack.add(new CircleTile(3));
			stack.add(new CircleTile(4));
			stack.add(new CircleTile(5));
			stack.add(new CircleTile(6));
			stack.add(new CircleTile(7));
			stack.add(new CircleTile(8));
			stack.add(new CircleTile(9));
			stack.add(new CharacterTile('1'));
			stack.add(new CharacterTile('2'));
			stack.add(new CharacterTile('3'));
			stack.add(new CharacterTile('4'));
			stack.add(new CharacterTile('5'));
			stack.add(new CharacterTile('6'));
			stack.add(new CharacterTile('7'));
			stack.add(new CharacterTile('8'));
			stack.add(new CharacterTile('9'));
			stack.add(new CharacterTile('N'));
			stack.add(new CharacterTile('S'));
			stack.add(new CharacterTile('E'));
			stack.add(new CharacterTile('W'));
			stack.add(new CharacterTile('C'));
			stack.add(new CharacterTile('F'));
			stack.add(new WhiteDragonTile());
			
		}
		
		stack.add(new SeasonTile("Spring"));
		stack.add(new SeasonTile("Summer"));
		stack.add(new SeasonTile("Fall"));
		stack.add(new SeasonTile("Winter"));
		stack.add(new FlowerTile("Chrysanthemum"));
		stack.add(new FlowerTile("Orchid"));
		stack.add(new FlowerTile("Plum"));
		stack.add(new FlowerTile("Bamboo"));
		
		//if (!nGame){
		
			//seedCaptured = System.currentTimeMillis();
			Collections.shuffle(stack);
			
		//}
		
	}

}
