package chess;

import java.util.ArrayList;

public class Blocker extends Piece
{
	public Blocker (int curr_x, int curr_y, boolean side)
	{
		x=curr_x;
		y=curr_y;
		white=side;
		name="L";
		//wayList = new ArrayList<Way>();
	}

	@Override
	public void getWay(Board tempBoard) {
		//unlimited move for Hori
		//limited move for Vertical
		Way way1 = new Way(1, 0, true);
		Way way2 = new Way(-1, 0, true);
		Way way3 = new Way(0, 1, false);
		Way way4 = new Way(0, -1, false);
		wayList = new ArrayList<Way>();
		wayList.add(way1);
		wayList.add(way2);
		wayList.add(way3);
		wayList.add(way4);

		getAllWay(tempBoard);
	}
}
