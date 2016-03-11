public class Lab3
{
	public static void main(String[] args)
	{
		Tile	c0 = new CircleTile(3);
		Tile	c1 = new CircleTile(3);
		Tile	c2 = new CircleTile(4);

		if (c0.matches(c1) && !c0.matches(c2))
			System.out.println("Circle Tile matches:          PASS");
		else
			System.out.println("Circle Tile matches:          FAIL");

		Tile	b0 = new BambooTile(3);
		Tile	b1 = new BambooTile(3);
		Tile	b2 = new BambooTile(4);

		if (b0.matches(b1) && !b0.matches(b2))
			System.out.println("Bamboo Tile matches:          PASS");
		else
			System.out.println("Bamboo Tile matches:          FAIL");


		if (c0.matches(b0))
			System.out.println("Circle/Bamboo Tile matches:   Fail");
		else
			System.out.println("Circle/Bamboo Tile matches:   PASS");


		Tile	ch0 = new CharacterTile('3');
		Tile	ch1 = new CharacterTile('3');
		Tile	ch2 = new CharacterTile('W');

		if (ch0.matches(ch1) && !ch0.matches(ch2))
			System.out.println("Character Tile matches:       PASS");
		else
			System.out.println("Character Tile matches:       FAIL");

		Tile	p0 = new SeasonTile("Spring");
		Tile	p1 = new SeasonTile("Summer");
		Tile	p2 = new FlowerTile("Plum");
		Tile	p3 = new FlowerTile("Orchid");

		if (p0.matches(p1) && p2.matches(p3) && !p0.matches(p2))
			System.out.println("Picture Tile matches:         PASS");
		else
			System.out.println("Picture Tile matches:         FAIL");


		Tile	wd0 = new WhiteDragonTile();
		Tile	wd1 = new WhiteDragonTile();
		Tile	b1t0 = new Bamboo1Tile();
		Tile	b1t1 = new Bamboo1Tile();

		if (wd0.matches(wd1) && b1t0.matches(b1t1) && !wd0.matches(b1t0))
			System.out.println("Special Case Tiles matches:   PASS");
		else
			System.out.println("Special Case Tiles matches:   FAIL");


		System.out.println();
		System.out.printf("Should print Circle 3%20s%n", c0);
		System.out.printf("Should print Bambbo 3%20s%n", b0);
		System.out.printf("Should print Character 3%20s%n", ch0);
		System.out.printf("Should print West Wind%20s%n", ch2);
		System.out.printf("Should print Spring%20s%n", p0);
		System.out.printf("Should print White Dragon%20s%n", wd0);
		System.out.printf("Should print Bamboo 1%20s%n", b1t1);
	}
}
