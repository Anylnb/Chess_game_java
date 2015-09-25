package chess;

import java.util.ArrayList;

public class Rook extends Piece
{
	public Rook (int curr_x, int curr_y, boolean side)
	{
		x=curr_x;
		y=curr_y;
		white=side;
		name="R";
	}
	/*!
	 * Get all the directions the piece can move.
	 * @see chess.Piece#getWay(chess.Board)
	 */
	public void getWay(Board tempBoard)
	{
		Way way1=new Way(0,1,true);
		Way way2=new Way(1,0,true);
		Way way3=new Way(0,-1,true);
		Way way4=new Way(-1,0,true);

		wayList=new ArrayList<Way>();
		wayList.add(way1);
		wayList.add(way2);
		wayList.add(way3);
		wayList.add(way4);

		getAllWay(tempBoard);
	}

}
