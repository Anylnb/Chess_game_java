package chess;


/*
 * Class: Chess
 * Description: It is the game driver. Use for testing and running the game.
 */

import java.util.Scanner;

public class Chess {
	public static int gameCounter;
	public static boolean whichSide;
	public static Board game = new Board();
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		gameCounter = 0;
		game.initialBoard();
		Piece[][] gameGrid = game.getBoard();
		int isSuccess = 2;
		int desX = 0;
		int desY = 0;
		

		Scanner s = new Scanner(System.in); 
		whichSide = true;
		
		while (true) 
		{
			//initial movement as failed status
			isSuccess = 2;
			
			// Print the simple grid
			for (int i = 7; i >= 0; i--) 
			{
				for (int j = 0; j < 8; j++) {
					if (gameGrid[j][i] != null)
						System.out.print(gameGrid[j][i].getName());
					else
						System.out.print(".");
				}
				System.out.println(" ");
			}
			
			// User input
			while(isSuccess == 2)
			{
				System.out.println("It is " + convertSide(whichSide) + " turn");
				System.out.println("Input the Piece X");
				int inX = s.nextInt();
				System.out.println("Input the Piece Y");
				int inY = s.nextInt();

				if (!rightSide(inX, inY, game, whichSide))
					continue;

				System.out.println("Input the destination X");
				desX = s.nextInt();
				System.out.println("Input the destination Y");
				desY = s.nextInt();

				// Move Piece
				isSuccess = game.movePiece(gameGrid[inX][inY], new Position(desX, desY));
			}
			//changing turn (W/B)
			gameCounter ++;
			whichSide = !whichSide;

			// Check King after each move
			// Go through every piece on the board.
			
			for(int ci = 0;ci < 8;ci++)
			{
				for (int cj = 0; cj < 8; cj++) 
				{
					if (gameGrid[ci][cj] != null&&!gameGrid[ci][cj].isCheck(game).equals(" ")) 
					{
						System.out.println(gameGrid[ci][cj].isCheck(game) + " King is in check");
					}

				}
			}
			
	
			if (!game.winner.equals("yuki")) 
			{
				System.out.println(game.winner + " WINS!!!");
				break;
			}
		}
	}
				
	
	
	
	public static boolean rightSide (int x, int y, Board tempBoard, boolean side)
	{
		Piece[][] tempGrid = tempBoard.getBoard();
		return tempGrid[x][y].getColorBool() == side;
	}
	
	
	public static String convertSide (boolean temp)
	{
		if(temp)
			return "WHITE";
		else
			return "BLACK";
	}

}
