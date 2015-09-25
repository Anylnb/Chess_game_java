package test;

import static org.junit.Assert.*;

import org.junit.Test;

import chess.Board;
import chess.King;
import chess.Position;
import chess.Queen;
import chess.Blocker;
import chess.Pawn;

public class testBlockerMoving {


	// test for Blocker starting (3,0)
	// moving Horizontally
	@Test
	public void ValidBlockerHoriWay() throws Exception {
		Board game = new Board();
		Blocker testP = new Blocker(3, 0, true);
		game.putPiece(testP);
		
		for (int i = 1; i < 8; i++) {
			Position des = new Position(i, 0);
			int res = game.movePiece(testP, des);

			assertEquals(res, 1);
			assertEquals(game.getBoard()[i][0], testP);
			assertEquals(testP.getPieceX(), i);
			assertEquals(testP.getPieceY(), 0);
		}
	}
	//test for Blocker starting (3,0) 
	//moving Vertically
	@Test
	public void ValidBlockergVerticalWay() throws Exception {
        Board game = new Board();
        Blocker testP = new Blocker(3,0,true);
        game.putPiece(testP);
        
        	Position des = new Position(3,1);
        	int res = game.movePiece(testP, des);
        	assertEquals(res, 1);
        	assertEquals(game.getBoard()[3][1], testP);
        	assertEquals(testP.getPieceX(), 3);
        	assertEquals(testP.getPieceY(), 1);
        
	}
	//test for Blocker starting (5,5) 
	//moving Diagonally
	@Test
	public void ValidBlockerDiagWay() throws Exception {
        Board game = new Board();
        Blocker testP = new Blocker(5,5,true);
        game.putPiece(testP);

		Position des = new Position(4, 4);
		int res = game.movePiece(testP, des);

		assertEquals(res, 2);
		assertEquals(game.getBoard()[5][5], testP);
		assertEquals(testP.getPieceX(), 5);
		assertEquals(testP.getPieceY(), 5);
        
	}

	
	//When the destination is out of bound
	//Nothing happens and the piece stays the same location
	@Test
	public void ValidBlockerOffBound() throws Exception {
        Board game = new Board();
        Blocker testP = new Blocker(7,7,true);
        game.putPiece(testP);

		Position des = new Position(7, 8);
		int res = game.movePiece(testP, des);
		assertEquals(res, 2);
		assertEquals(game.getBoard()[7][7], testP);
		assertEquals(testP.getPieceX(), 7);
		assertEquals(testP.getPieceY(), 7);
        
	}
	@Test
	public void inValidBlockerWay() throws Exception {
        Board game = new Board();
        Blocker testP = new Blocker(5,5,true);
        game.putPiece(testP);

		Position des = new Position(3, 3);
		int res = game.movePiece(testP, des);

		assertEquals(res, 2);
		assertEquals(game.getBoard()[5][5], testP);
		assertEquals(testP.getPieceX(), 5);
		assertEquals(testP.getPieceY(), 5);
        
	}
	@Test
	public void ValidBlockerBlockedBySameSide() throws Exception 
	{
        Board game = new Board();
        Blocker testP = new Blocker(5,5,true);
        Pawn blockP = new Pawn(5,4,true);
        
        game.putPiece(testP);
        game.putPiece(blockP);

        	
        Position des = new Position(5,4);
        int res = game.movePiece(testP, des);
        
        assertEquals(res, 2);
        assertEquals(game.getBoard()[5][5], testP);
        assertEquals(testP.getPieceX(), 5);
        assertEquals(testP.getPieceY(), 5);

	}
	

	@Test
	public void ValidBlockerBlockedByRival() throws Exception 
	{
        Board game = new Board();
        Blocker testP = new Blocker(5,5,true);
        Pawn blockP = new Pawn(5,4,false);
        
        game.putPiece(testP);
        game.putPiece(blockP);

        	
        Position des = new Position(5,4);
        int res = game.movePiece(testP, des);
        
        assertEquals(res, 1);
        assertEquals(game.getBoard()[5][4], testP);
        assertEquals(testP.getPieceX(), 5);
        assertEquals(testP.getPieceY(), 4);
 
	}
	

	
}
