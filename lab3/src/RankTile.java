
public abstract class RankTile extends Tile
{
	protected int rank;
	public RankTile(){};
	public RankTile(int rank)
	{
		this.rank = rank;
	}
	
	public boolean matches(Tile other)
	{
		if (!super.matches(other)) return false;
		
		RankTile rt = (RankTile) other;
		return rank == rt.rank;
	}
}
