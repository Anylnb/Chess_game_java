package chess;

/*
 * Class: Piece
 * Description: Piece is an abstract class. 
 * It is the parent class of six types of pieces.
 * It has the main function to calculate 
 * all the possible valid location that one piece can move.
 */

import java.util.ArrayList;

public abstract class Piece 
{
	public String name;
	public int x;
	public int y;
	public boolean white; // false if you are black
	public ArrayList<Way> wayList;
	public ArrayList<Position> allPosList;
	public int counter;
	

	/*!
	 * 
	 * @param pos
	 * @return If the position is out of bound.
	 */
	public boolean outBound(Position pos)
	{		
		return pos.x<0||pos.x>7||pos.y>7||pos.y<0;
	}
	
	/*!
	 * Abstract function for storing directions that different piece can move.
	 * @param tempBoard
	 */
	public abstract void getWay(Board tempBoard);
	
	/*!
	 * Get all the possible location to go next.
	 * @param tempBoard
	 */
	public void getAllWay(Board tempBoard)
	{

		boolean unlimited=wayList.get(0).unlimited;
		allPosList = new ArrayList<Position>();
		for(int i = 0;i<wayList.size();i++)
		{
			//Deal with piece that can only move unlimited grid.
			if(unlimited)
			{
				Position temp=new Position(x, y);
				while(true)
				{
					
					temp.x+=wayList.get(i).x;
					temp.y+=wayList.get(i).y;
					
					//Check if it is out of bound.
					//If yes, stop checking the current direction.
					if(outBound(temp)) 
					{
						break;
					}
					
					//Read the piece in the given location (temp)
					Piece tempPiece = Board.isOccupiedWith(tempBoard,temp);
					
					//The location is empty so we can move there. 
					//Store the location in the array.
					if(tempPiece==null)
					{
						allPosList.add(new Position(temp.x,temp.y));
					}
					//It is not empty
					else
					{
						// If it is my side piece, I stop checking the
						// direction.
						if (tempPiece.white == white) {
							break;

						}
						// See the rival piece. Get ready for killing.
						if (tempPiece.white != white) {
							// Able to move after killing
							allPosList.add(new Position(temp.x, temp.y));
						}
					}		
				}
			}
			//Deal with piece that can only move limited grid.
			else
			{
				Position temp=new Position(x, y);

				temp.x+=wayList.get(i).x;
				temp.y+=wayList.get(i).y;

				//Out of Bound
				//Move to next direction
				if(outBound(temp)) 
				{
					continue;
				}
				
				Piece tempPiece = Board.isOccupiedWith(tempBoard,temp);
				
				if(tempPiece==null)
				{
					allPosList.add(new Position(temp.x,temp.y));
				}
				else
				{
					//Blocked by self side piece
					//Change a direction
					if (tempPiece.white == white) {
						continue;
					}
					//Killing
					if (tempPiece.white != white) {
						allPosList.add(new Position(temp.x, temp.y));
					}
				}
			}
		}
	}
	
	/*!
	 * Check the certain position.
	 * @param temp
	 * @param tempBoard
	 * @return 0 if the king is going to be kill.
	 *		   1 if the destination is valid to move
	 *		   2 if the destination is invalid to move
	 */
	public int isValid(Position temp, Board tempBoard)
	{
		getWay(tempBoard);

		for (int i = 0; i < allPosList.size(); i++) 
		{
			
			Piece tempPiece = Board.isOccupiedWith(tempBoard, allPosList.get(i));

			if ((tempPiece != null) && tempPiece.getName().equals("K")
					&& !(tempPiece.getColor().equals(this.getColor()))) 
			{
				// King died
				return 0;
			}
			if (allPosList.get(i).x == temp.x && allPosList.get(i).y == temp.y)
			{
				//Valid 
				return 1; 
			}
		}
		//Invalid
		return 2; 
	}
	
	/*!
	 * See if the King is in check
	 * @param tempBoard
	 * @return "WHITE" if White King is in check
	 *		   "BLACK" if Black King is in check
	 *	       " " 	 if No One ons in check
	 */

	public String isCheck(Board tempBoard)
	{
		
		getWay(tempBoard);
		for(int i = 0;i<allPosList.size();i++)
		{
			Piece tempPiece = Board.isOccupiedWith(tempBoard,allPosList.get(i));
			
			if((tempPiece!=null)&&
					tempPiece.getName().equals("K")&&
					!(tempPiece.getColor().equals(this.getColor())))
			{
				System.out.println("dying");
				return tempPiece.getColor(); //check
			}
		}
		return " ";
	}
	
	//  GET ATTRIBUTES FUNCTIONS
	
	public int getPieceX()
	{
		return this.x;
	}
	
	public int getPieceY()
	{
		return this.y;
	}
	
	public String getName()
	{
		if(this.name!=null)
			return this.name;
		else
			return " ";
	}
	
	public String getColor()
	{
		if(this.white)
			return "WHITE";
		else
			return "BLACK";
	}
	
	public boolean getColorBool()
	{
		return this.white;
	}

}
