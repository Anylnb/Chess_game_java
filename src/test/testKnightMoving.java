package test;

import static org.junit.Assert.*;

import org.junit.Test;

import chess.Board;
import chess.Position;
import chess.Knight;
import chess.Pawn;

public class testKnightMoving {

	//test for Knight starting (3,0) 
	//moving Vertically
	@Test
	public void ValidKnightVerticalWay() throws Exception {
        Board game = new Board();
        Knight testP = new Knight(3,0,true);
        game.putPiece(testP);
        
		Position des = new Position(3, 1);
		int res = game.movePiece(testP, des);
		// System.out.println (testP.getPieceX() + "yukisan"
		// +testP.getPieceY());
		assertEquals(res, 2);
		assertEquals(game.getBoard()[3][0], testP);
		assertEquals(testP.getPieceX(), 3);
		assertEquals(testP.getPieceY(), 0);
        
	}
	
	//test for Knight starting (3,0) 
	//moving Horizontally
	@Test
	public void ValidKnightHoriWay() throws Exception {
        Board game = new Board();
        Knight testP = new Knight(3,0,true);
        game.putPiece(testP);
        
		Position des = new Position(2, 0);
		int res = game.movePiece(testP, des);
		System.out.println(testP.getPieceX() + "yukisan" + testP.getPieceY());
		assertEquals(res, 2);
		assertEquals(game.getBoard()[3][0], testP);
		assertEquals(testP.getPieceX(), 3);
		assertEquals(testP.getPieceY(), 0);

	}
	
	//test for Knight starting (5,5) 
	//moving Diagonally
	@Test
	public void ValidKnightDiagWay() throws Exception {
		Board game = new Board();
		Knight testP = new Knight(5, 5, true);
		game.putPiece(testP);

		Position des = new Position(4, 4);
		int res = game.movePiece(testP, des);

		assertEquals(res, 2);
		assertEquals(game.getBoard()[5][5], testP);
		assertEquals(testP.getPieceX(), 5);
		assertEquals(testP.getPieceY(), 5);
        
	}
	
	@Test
	public void ValidKnightWay() throws Exception {
		Board game = new Board();
		Knight testP = new Knight(5, 5, true);
		game.putPiece(testP);

		Position des = new Position(6, 3);
		int res = game.movePiece(testP, des);

		assertEquals(res, 1);
		assertEquals(game.getBoard()[6][3], testP);
		assertEquals(testP.getPieceX(), 6);
		assertEquals(testP.getPieceY(), 3);
        
	}
	
	//When the destination is out of bound
	//Nothing happens and the piece stays the same location
	@Test
	public void ValidKnightOffBound() throws Exception {
		Board game = new Board();
		Knight testP = new Knight(5, 5, true);
		game.putPiece(testP);

		Position des = new Position(9, 9);
		int res = game.movePiece(testP, des);
		assertEquals(res, 2);
		assertEquals(game.getBoard()[5][5], testP);
		assertEquals(testP.getPieceX(), 5);
		assertEquals(testP.getPieceY(), 5);
        
	}

	@Test
	public void ValidKnightBlockedBySameSide() throws Exception 
	{
        Board game = new Board();
        Knight testP = new Knight(5,5,true);
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
	
	@Test
	public void ValidKnightBlockedByRival() throws Exception 
	{
        Board game = new Board();
        Knight testP = new Knight(5,5,true);
        Pawn blockP = new Pawn(3,4,false);
        
        game.putPiece(testP);
        game.putPiece(blockP);

        	
        Position des = new Position(3,4);
        int res = game.movePiece(testP, des);
        
        assertEquals(res, 1);
        assertEquals(game.getBoard()[3][4], testP);
        assertEquals(testP.getPieceX(), 3);
        assertEquals(testP.getPieceY(), 4);
 
	}
	
	

	
}
