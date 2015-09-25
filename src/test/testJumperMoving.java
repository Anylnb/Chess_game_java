package test;

import static org.junit.Assert.*;

import org.junit.Test;

import chess.Board;
import chess.Position;
import chess.Jumper;
import chess.King;
import chess.Jumper;
import chess.Pawn;

public class testJumperMoving {

	// test for Jumper starting (3,0)
	// moving Vertically
	@Test
	public void ValidJumperVerticalWay() throws Exception {
		Board game = new Board();
		Jumper testP = new Jumper(3, 0, true);
		game.putPiece(testP);

		Position des = new Position(5, 0);
		int res = game.movePiece(testP, des);

		assertEquals(res, 1);
		assertEquals(game.getBoard()[5][0], testP);
		assertEquals(testP.getPieceX(), 5);
		assertEquals(testP.getPieceY(), 0);

	}

	// test for Jumper starting (3,0)
	// moving Horizontally
	@Test
	public void ValidJumperHoriWay() throws Exception {
		Board game = new Board();
		Jumper testP = new Jumper(3, 0, true);
		game.putPiece(testP);

		Position des = new Position(3, 2);
		int res = game.movePiece(testP, des);
		assertEquals(res, 1);
		assertEquals(game.getBoard()[3][2], testP);
		assertEquals(testP.getPieceX(), 3);
		assertEquals(testP.getPieceY(), 2);

	}

	// test for Jumper starting (5,5)
	// moving Diagonally
	@Test
	public void ValidJumperDiagWay() throws Exception {
		Board game = new Board();
		Jumper testP = new Jumper(5, 5, true);
		game.putPiece(testP);

		Position des = new Position(7, 7);
		int res = game.movePiece(testP, des);
		assertEquals(res, 2);
		assertEquals(game.getBoard()[5][5], testP);
		assertEquals(testP.getPieceX(), 5);
		assertEquals(testP.getPieceY(), 5);

	}

	// When the destination is out of bound
	// Nothing happens and the piece stays the same location
	@Test
	public void ValidJumperOffBound() throws Exception {
		Board game = new Board();
		Jumper testP = new Jumper(6, 6, true);
		game.putPiece(testP);

		Position des = new Position(6, 8);
		int res = game.movePiece(testP, des);
		assertEquals(res, 2);
		assertEquals(game.getBoard()[6][6], testP);
		assertEquals(testP.getPieceX(), 6);
		assertEquals(testP.getPieceY(), 6);

	}

	@Test
	public void inValidJumperWay() throws Exception {
		Board game = new Board();
		Jumper testP = new Jumper(5, 5, true);
		game.putPiece(testP);

		Position des = new Position(3, 3);
		int res = game.movePiece(testP, des);
		assertEquals(res, 2);
		assertEquals(game.getBoard()[5][5], testP);
		assertEquals(testP.getPieceX(), 5);
		assertEquals(testP.getPieceY(), 5);

	}

	@Test
	public void ValidJumperBlockedBySameSide() throws Exception {
		Board game = new Board();
		Jumper testP = new Jumper(5, 5, true);
		Pawn blockP = new Pawn(5, 4, true);

		game.putPiece(testP);
		game.putPiece(blockP);

		Position des = new Position(5, 3);
		int res = game.movePiece(testP, des);

		assertEquals(res, 1);
		assertEquals(game.getBoard()[5][3], testP);
		assertEquals(testP.getPieceX(), 5);
		assertEquals(testP.getPieceY(), 3);

	}
	
	@Test
	public void ValidJumperBlockedByRival() throws Exception 
	{
        Board game = new Board();
        Jumper testP = new Jumper(5,5,true);
        Pawn blockP = new Pawn(5,7,false);
        
        game.putPiece(testP);
        game.putPiece(blockP);

        	
        Position des = new Position(5,7);
        int res = game.movePiece(testP, des);
        
        assertEquals(res, 1);
        assertEquals(game.getBoard()[5][7], testP);
        assertEquals(testP.getPieceX(), 5);
        assertEquals(testP.getPieceY(), 7);
 
	}

}
