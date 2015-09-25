package chess;

import java.util.ArrayList;

public class Knight extends Piece
{
	public Knight (int curr_x, int curr_y, boolean side)
	{
		x=curr_x;
		y=curr_y;
		white=side;
		name="H";
	}

	public void getWay(Board tempBoard)
	{
		Way way1=new Way(-1,2,false);
		Way way2=new Way(1,2,false);
		Way way3=new Way(2,1,false);
		Way way4=new Way(2,-1,false);
		Way way5=new Way(1,-2,false);
		Way way6=new Way(-1,-2,false);
		Way way7=new Way(-2,-1,false);
		Way way8=new Way(-2,1,false);
		wayList=new ArrayList<Way>();
		wayList.add(way1);
		wayList.add(way2);
		wayList.add(way3);
		wayList.add(way4);
		wayList.add(way5);
		wayList.add(way6);
		wayList.add(way7);
		wayList.add(way8);
		getAllWay(tempBoard);
	}
}
