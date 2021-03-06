abstract public class RankTile extends Tile
{
	private static final long serialVersionUID = 1L;
	protected int rank;
	
	public RankTile(int rank)
	{
		this.rank = rank;
	}

	boolean matches(Tile inOther)
	{
		RankTile otherTile = (RankTile) inOther;
		if (this.getClass() == inOther.getClass() && this.rank == otherTile.rank) 
			return true;
		else
			return false;
	}
}
