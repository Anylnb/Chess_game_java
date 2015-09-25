package chess;

import java.util.ArrayList;

public class Queen extends Piece{
	
	public Queen (int curr_x, int curr_y, boolean side)
	{
		x=curr_x;
		y=curr_y;
		white=side;
		name="Q";
		//wayList = new ArrayList<Way>();
	}
	public void getWay(Board tempBoard)
	{
		Way way1=new Way(1,0,true);
		Way way2=new Way(-1,0,true);
		Way way3=new Way(1,1,true);
		Way way4=new Way(1,-1,true);
		Way way5=new Way(-1,-1,true);
		Way way6=new Way(-1,1,true);
		Way way7=new Way(0,1,true);
		Way way8=new Way(0,-1,true);
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
/*	public void getAllWay()
	{
		getWay();
		boolean unlimited=wayList.get(0).unlimited;
		allPosList = new ArrayList<Position>();
		for(int i = 0;i<wayList.size();i++)
		{
			if(unlimited)
			{
				while(true)
				{
					Position temp=new Position(x, y);
					temp.x+=wayList.get(i).x;
					temp.y+=wayList.get(i).y;
					Piece tempPiece = isOccupiedWith(board,temp);
					
					//check if it is out of bound or has same color piece blocking the way
					//if yes, break
					if(tempPiece.white==white)
					{
						continue;
					}
					if(outBound(temp)) 
					{
						break;
					}
					allPosList.add(temp);
					
					
				}
			}
			else
			{
				Position temp=new Position(x, y);
				temp.x+=wayList.get(i).x;
				temp.y+=wayList.get(i).y;
				Piece tempPiece = isOccupiedWith(board,temp);
				
				//check if it is out of bound or has same color piece blocking the way
				//if yes, break
				if(tempPiece.white==white)
				{
					continue;
				}
				if(outBound(temp)) 
				{
					break;
				}
				allPosList.add(temp);
			}
		}
		
		
	}*/
	

	
	

}
