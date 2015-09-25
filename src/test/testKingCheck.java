package test;

import static org.junit.Assert.*;

import org.junit.Test;

import chess.Board;
import chess.King;
import chess.Knight;
import chess.Position;

public class testKingCheck {

	@Test
	//Check King
	public void kingCheck() 
	{
		Board game = new Board();
        Knight testP = new Knight(3,0,true);
        King testK = new King(1,4,false);
        game.putPiece(testP);
        game.putPiece(testK);
        
        	Position des = new Position(2,2);
        	int res = game.movePiece(testP, des);
        	
        	assertEquals(res, 1);
        	assertEquals(game.getBoard()[2][2], testP);
        	assertEquals(testP.getPieceX(), 2);
        	assertEquals(testP.getPieceY(), 2);
        	assertEquals(testP.isCheck(game), testK.getColor());
	}
	
	@Test
	//Check who wins
	public void whiteWins() 
	{
		Board game = new Board();
		Knight testP = new Knight(3, 0, true);
		King testK = new King(2, 2, false);
		game.putPiece(testP);
		game.putPiece(testK);

		Position des = new Position(2, 2);
		int res = game.movePiece(testP, des);

		assertEquals(res, 0);

		assertEquals(game.winner, testP.getColor());
	}

}
