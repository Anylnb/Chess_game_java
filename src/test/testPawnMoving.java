package test;

import static org.junit.Assert.*;

import org.junit.Test;

import chess.Board;
import chess.Position;
import chess.Pawn;

public class testPawnMoving {

	//test for Pawn starting (3,0) 
	//moving Vertically
	@Test
	public void ValidPawnVerticalWay() throws Exception {
		Board game = new Board();
		Pawn testP = new Pawn(3, 0, true);
		game.putPiece(testP);

		Position des = new Position(3, 1);
		int res = game.movePiece(testP, des);
		
		assertEquals(res, 1);
		assertEquals(game.getBoard()[3][1], testP);
		assertEquals(testP.getPieceX(), 3);
		assertEquals(testP.getPieceY(), 1);
        
	}
	
	//test for Pawn starting (3,0) 
	//can't move Horizontally
	@Test
	public void ValidPawnHoriWay() throws Exception {
		Board game = new Board();
		Pawn testP = new Pawn(3, 0, true);
		game.putPiece(testP);

		Position des = new Position(2, 0);
		int res = game.movePiece(testP, des);
		assertEquals(res, 2);
		assertEquals(game.getBoard()[3][0], testP);
		assertEquals(testP.getPieceX(), 3);
		assertEquals(testP.getPieceY(), 0);

	}
	
	//test for Pawn starting (5,5) 
	//Kill Diagonally
	@Test
	public void ValidPawnDiagKill() throws Exception {
		Board game = new Board();
		Pawn testP = new Pawn(5, 5, true);
		Pawn eatP = new Pawn(4, 6, false);
		game.putPiece(testP);
		game.putPiece(eatP);

		Position des = new Position(4, 6);
		int res = game.movePiece(testP, des);

		assertEquals(res, 1);
		assertEquals(game.getBoard()[4][6], testP);
		assertEquals(testP.getPieceX(), 4);
		assertEquals(testP.getPieceY(), 6);
        
	}
	
	//test for Pawn starting (5,5) 
	//Can't move Diagonally
	@Test
	public void ValidPawnDiagWay() throws Exception {
		Board game = new Board();
		Pawn testP = new Pawn(5, 5, true);
		game.putPiece(testP);

		Position des = new Position(4, 6);
		int res = game.movePiece(testP, des);

		assertEquals(res, 2);
		assertEquals(game.getBoard()[5][5], testP);
		assertEquals(testP.getPieceX(), 5);
		assertEquals(testP.getPieceY(), 5);
        
	}
	
	
	//When the destination is out of bound
	//Nothing happens and the piece stays the same location
	@Test
	public void ValidPawnOffBound() throws Exception {
		Board game = new Board();
		Pawn testP = new Pawn(7, 7, true);
		game.putPiece(testP);

		Position des = new Position(7, 8);
		int res = game.movePiece(testP, des);
		assertEquals(res, 2);
		assertEquals(game.getBoard()[7][7], testP);
		assertEquals(testP.getPieceX(), 7);
		assertEquals(testP.getPieceY(), 7);
        
	}

	//Nothing happens if the piece is blocked by self side
	@Test
	public void ValidPawnBlockedBySameSide() throws Exception 
	{
        Board game = new Board();
        Pawn testP = new Pawn(5,5,true);
        Pawn blockP = new Pawn(3,4,true);
        
        game.putPiece(testP);
        game.putPiece(blockP);

        	
        Position des = new Position(3,4);
        int res = game.movePiece(testP, des);
        
        assertEquals(res, 2);
        assertEquals(game.getBoard()[5][5], testP);
        assertEquals(testP.getPieceX(), 5);
        assertEquals(testP.getPieceY(), 5);

	}
	
	//Time for killing
	//Move to the location after killing
	@Test
	public void ValidPawnBlockedByRival() throws Exception 
	{
        Board game = new Board();
        Pawn testP = new Pawn(5,5,true);
        Pawn blockP = new Pawn(5,6,false);
        
        game.putPiece(testP);
        game.putPiece(blockP);

        	
        Position des = new Position(5,6);
        int res = game.movePiece(testP, des);
        
        assertEquals(res, 2);
        assertEquals(game.getBoard()[5][5], testP);
        assertEquals(testP.getPieceX(), 5);
        assertEquals(testP.getPieceY(), 5);
 
	}
	
	

	
}
