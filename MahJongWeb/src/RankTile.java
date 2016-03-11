import java.util.Objects;


// TODO No modification needed in this class
public abstract class RankTile extends Tile
{
	protected int rank;
	
	public RankTile(int rank)
	{
		this.rank = rank;
	}
	
	@Override
	public boolean matches(Tile other)
	{
		RankTile otherObject = (RankTile) other;
		return super.matches(other)
				&& rank == otherObject.rank
				&& Objects.equals(rank, otherObject.rank);
	}
}