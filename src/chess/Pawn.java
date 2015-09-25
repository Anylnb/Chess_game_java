package chess;

import java.util.ArrayList;

public class Pawn extends Piece
{
	
	public Pawn (int curr_x, int curr_y, boolean side)
	{
		x=curr_x;
		y=curr_y;
		white=side;
		name= new String("P");
		counter=0;
	}
	public void getWay(Board tempBoard)
	{
		Way way1=new Way(0,1,false);
		Way way2=new Way(1,1,false);//NE
		Way way3=new Way(-1,1,false);//NW
		Way way4=new Way(0,2,false);
		Way way5=new Way(1,0,false);//E
		Way way6=new Way(-1,0,false);//W
		
		//Direction for Black Pawn
		if(!white)
		{
			way1=new Way(0,-1,false);
			way2=new Way(-1,-1,false);
			way3=new Way(1,-1,false);
			way4=new Way(0,-2,false);
		}

		wayList=new ArrayList<Way>();
		wayList.add(way1);
		wayList.add(way2);
		wayList.add(way3);
		wayList.add(way4);
		wayList.add(way5);
		wayList.add(way6);
		getPawnAllWay(tempBoard);
	}
	
	//Check if the Pawn has been moved yet
	public boolean hasMoved() 
	{
		
		if(this.white)
		{
			if(this.y==1&&this.x>=0&&this.x<8)
			{
				counter=0;
				return false;
			}
		}
		else
		{
			if(this.y==6&&this.x>=0&&this.x<8)
			{
				counter=0;
				return false;
			}
		}
		return true;
	}
	
	public void getPawnAllWay(Board tempBoard)
	{
		

		allPosList = new ArrayList<Position>();
		
		//Check if it is the first move
		if(!hasMoved())
		{
			Position temp1=new Position(x, y);
			//Move 2 grids is possible
			temp1.x+=wayList.get(3).x;
			temp1.y+=wayList.get(3).y;
			Piece tempPiece1 = Board.isOccupiedWith(tempBoard, temp1);
			
			if(tempPiece1==null)
			{
				allPosList.add(temp1);
			}
		}
		
		Position temp=new Position(x, y);
		temp.x+=wayList.get(0).x;
		temp.y+=wayList.get(0).y;
		
		if (!outBound(temp)) 
		{

			Piece tempPiece = Board.isOccupiedWith(tempBoard, temp);

			if (tempPiece == null) 
			{
				allPosList.add(temp);
			}
		}
		
		//Cross Killing
		for(int i = 0;i<3;i++)
		{
			Position tempEatingPos = new Position(x,y);
			tempEatingPos.x+=wayList.get(i+1).x;
			tempEatingPos.y+=wayList.get(i+1).y;
			
			if(outBound(tempEatingPos))
			{
				continue;
			}
			Piece tempEatingPiece = Board.isOccupiedWith(tempBoard,tempEatingPos);
				

				if(tempEatingPiece==null) 
				{
					continue;
				}
				
				//Kill it!
				if(tempEatingPiece.white!=white)
				{
					allPosList.add(new Position(tempEatingPos.x,tempEatingPos.y));
				}
				
			//special (crossing) eating!!!	
			/*Position tempPassingPos = new Position(x,y);
			tempPassingPos.x+=wayList.get(i+4).x;
			tempPassingPos.y+=wayList.get(i+4).y;
			Piece tempPassingPiece = Board.isOccupiedWith(tempBoard,tempEatingPos);
			
			if(tempPassingPiece==null||outBound(tempPassingPos))
			{
				break;
			}
			if(tempPassingPiece.white!=this.white)
			{
				//Board.removePiece(tempBoard, tempPassingPos);
				allPosList.add(new Position(tempPassingPos.x,tempPassingPos.y));
			}*/
			
		 }
		
		
	}

}
