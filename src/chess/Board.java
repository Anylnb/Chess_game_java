package chess;

import javax.swing.JOptionPane;

import gui.ChessBoard;

/*
 * Class: Board
 * Description: Use 2D array to store Pieces on the chess board. 
 * Contain other helper functions to run the game.
 */


public class Board 
{
	public static Piece[][] grid;
	public String winner;
	
	public Board()
	{
		grid = new Piece[8][8];
		winner = new String("yuki");
	}
	
	public static Piece[][] getBoard()
	{
		return grid;
	}
	
	//Place 32 pieces into the Grid 
	public static boolean initialBoard()
	{
		// white side
		grid[3][0] = new Queen(3, 0, true);
		grid[1][0] = new Knight(1, 0, true);
		grid[6][0] = new Knight(6, 0, true);
		grid[0][0] = new Rook(0, 0, true);
		grid[7][0] = new Rook(7, 0, true);
		grid[2][0] = new Bishop(2, 0, true);
		grid[5][0] = new Bishop(5, 0, true);
		grid[4][0] = new King(4, 0, true);

		// Black side
		grid[3][7] = new Queen(3, 7, false);
		grid[1][7] = new Knight(1, 7, false);
		grid[6][7] = new Knight(6, 7, false);
		grid[0][7] = new Rook(0, 7, false);
		grid[7][7] = new Rook(7, 7, false);
		grid[2][7] = new Bishop(2, 7, false);
		grid[5][7] = new Bishop(5, 7, false);
		grid[4][7] = new King(4, 7, false);
		
		
		for (int i = 0; i < 8; i++) 
		{
			grid[i][1] = new Pawn(i, 1, true);
			grid[i][6] = new Pawn(i, 6, false);
		}
		
		for (int i = 2; i < 6; i++) 
		{
			for (int j = 0; j < 8; j++) {
				grid[j][i] = null;
			}
		}
		//grid[6][5] = new Bishop(6,5,true);
		
		if(ChessBoard.isCustomePiece == JOptionPane.YES_OPTION)
		{
			grid[0][1] = new Jumper(0, 1, true);
			grid[0][6] = new Jumper(0, 6, false);
			grid[7][1] = new Blocker(7, 1, true);
			grid[7][6] = new Blocker(7, 6, false);
		}
		return true;
				
	}
	
	public int movePiece(Piece temp, Position desPos)
	{
		int currX = temp.x;
		int currY = temp.y;
		Position origPos = new Position (currX, currY);
		int validity = temp.isValid(desPos,this);
		if(validity==0)
		{
			//The king is killed
			this.winner = temp.getColor();
		}
		if(validity<2)
		{
			
			//update piece attributes
			temp.x=desPos.x;
			temp.y=desPos.y;

			//update board
			grid[temp.x][temp.y]=temp;
			
			
			removePiece(this, origPos);
			
		}
		return validity;
	}
	
	public static String checkedKing (Board tempBoard)
	{
		for(int ci = 0;ci < 8;ci++)
		{
			for (int cj = 0; cj < 8; cj++) 
			{
				if (grid[ci][cj] != null&&!grid[ci][cj].isCheck(tempBoard).equals(" ")) 
				{
					System.out.println(grid[ci][cj].isCheck(tempBoard) + " King is in check");
					return grid[ci][cj].isCheck(tempBoard);
				}

			}
		}
		return "";
	}
	
	//Return the piece is currently on the location
	public static Piece isOccupiedWith(Board tempBoard, Position tempPos)
	{
		Piece[][] tempGrid = tempBoard.getBoard();
		int tempX = tempPos.x;
		int tempY = tempPos.y;
		if(tempGrid[tempX][tempY]==null)
			return null;
		return tempGrid[tempX][tempY];
		
	}
	
	//Helper function to place a piece on the grid
	public boolean putPiece(Piece temp)
	{
		Piece[][] tempGrid = this.getBoard();
		int x = temp.x;
		int y = temp.y;
		if(tempGrid[x][y]==null)
		{
			tempGrid[x][y] = temp;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//Remove helper function
	public static void removePiece(Board tempBoard, Position tempPos)
	{
		Piece[][] tempGrid = tempBoard.getBoard();
		
		tempGrid[tempPos.x][tempPos.y] = null;
		
	}
	
	/*
	public boolean wKingDied()
	{
		Piece[][] tempGrid = this.getBoard();
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				if(tempGrid[j][i].getName().equals("K")&&tempGrid[j][i].getColor().equals("WHITE"))
					return false;
			}
		}
		return true;
	}
	public boolean bKingDied()
	{
		Piece[][] tempGrid = this.getBoard();
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				if(tempGrid[j][i].getName().equals("K")&&tempGrid[j][i].getColor().equals("BLACK"))
					return false;
			}
		}
		return true;
	}
	*/
}
