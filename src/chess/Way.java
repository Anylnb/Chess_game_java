package chess;

/*
 * Class: Way
 * Description: Store the factor directions that a Piece can move  
 */

public class Way 
{
	public int x;
	public int y;
	public boolean unlimited;
	
	public Way(int way_x, int way_y, boolean l)
	{
		x=way_x;
		y=way_y;
		unlimited=l;
	}

}
