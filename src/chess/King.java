package chess;

import java.util.ArrayList;

public class King extends Piece
{

	public King (int curr_x, int curr_y, boolean side)
	{
		x=curr_x;
		y=curr_y;
		white=side;
		name="K";
	}
	public void getWay(Board tempBoard)
	{
		Way way1=new Way(1,0,false);
		Way way2=new Way(-1,0,false);
		Way way3=new Way(1,1,false);
		Way way4=new Way(1,-1,false);
		Way way5=new Way(-1,-1,false);
		Way way6=new Way(-1,1,false);
		Way way7=new Way(0,1,false);
		Way way8=new Way(0,-1,false);
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
