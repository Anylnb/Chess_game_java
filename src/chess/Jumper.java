package chess;

import java.util.ArrayList;

public class Jumper extends Piece
{
	public Jumper (int curr_x, int curr_y, boolean side)
	{
		x=curr_x;
		y=curr_y;
		white=side;
		name="J";
		//wayList = new ArrayList<Way>();
	}

	@Override
	public void getWay(Board tempBoard) {
		Way way1 = new Way(2, 0, false);
		Way way2 = new Way(-2, 0, false);
		Way way3 = new Way(0, 2, false);
		Way way4 = new Way(0, -2, false);
		wayList = new ArrayList<Way>();
		wayList.add(way1);
		wayList.add(way2);
		wayList.add(way3);
		wayList.add(way4);

		getAllWay(tempBoard);
	}
}
