
public abstract class PictureTile extends Tile {
	private String name;
	PictureTile(String name) 
	{
		this.name = name;
	}
	public String toString()
	{
		return name;
	}
}
