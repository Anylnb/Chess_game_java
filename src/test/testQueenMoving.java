package test;

import static org.junit.Assert.*;

import org.junit.Test;

import chess.Board;
import chess.Pawn;
import chess.Position;
import chess.Queen;

public class testQueenMoving {

	// test for Queen starting (3,0)
	// moving Vertically
	@Test
	public void ValidQueenVerticalWay() throws Exception {
		Board game = new Board();
		Queen testP = new Queen(3, 0, true);
		game.putPiece(testP);
		
		for (int i = 1; i < 8; i++) {
			Position des = new Position(3, i);
			int res = game.movePiece(testP, des);
			// System.out.println (testP.getPieceX() + "yukisan"
			// +testP.getPieceY());
			assertEquals(res, 1);
			assertEquals(game.getBoard()[3][i], testP);
			assertEquals(testP.getPieceX(), 3);
			assertEquals(testP.getPieceY(), i);
		}
	}

	// test for Queen starting (3,0)
	// moving Horizontally
	@Test
	public void ValidQueenHoriWay() throws Exception {
		Board game = new Board();
		Queen testP = new Queen(3, 0, true);
		game.putPiece(testP);
		
		for (int i = 1; i < 8; i++) {
			Position des = new Position(i, 0);
			int res = game.movePiece(testP, des);
			// System.out.println (testP.getPieceX() + "yukisan"
			// +testP.getPieceY());
			assertEquals(res, 1);
			assertEquals(game.getBoard()[i][0], testP);
			assertEquals(testP.getPieceX(), i);
			assertEquals(testP.getPieceY(), 0);
		}
	}

	// test for Queen starting (3,0)
	// moving Diagonally
	@Test
	public void ValidQueenDiagWay() throws Exception {
		Board game = new Board();
		Queen testP = new Queen(5, 5, true);
		game.putPiece(testP);
		
		for (int i = 0; i < 8; i++) {
			Position des = new Position(i, i);
			int res = game.movePiece(testP, des);
			
			assertEquals(res, 1);
			assertEquals(game.getBoard()[i][i], testP);
			assertEquals(testP.getPieceX(), i);
			assertEquals(testP.getPieceY(), i);
		}
	}

	// When the destination is out of bound
	// Nothing happens and the piece stays the same location
	@Test
	public void ValidQueenOffBound() throws Exception {
		Board game = new Board();
		Queen testP = new Queen(5, 5, true);
		game.putPiece(testP);

		Position des = new Position(9, 9);
		int res = game.movePiece(testP, des);
		assertEquals(res, 2);
		assertEquals(game.getBoard()[5][5], testP);
		assertEquals(testP.getPieceX(), 5);
		assertEquals(testP.getPieceY(), 5);

	}

	@Test
	public void ValidQueenBlockedBySameSide() throws Exception {
		Board game = new Board();
		Queen testP = new Queen(5, 5, true);
		Pawn blockP = new Pawn(3, 3, true);

		game.putPiece(testP);
		game.putPiece(blockP);

		Position des = new Position(3, 3);
		int res = game.movePiece(testP, des);

		assertEquals(res, 2);
		assertEquals(game.getBoard()[5][5], testP);
		assertEquals(testP.getPieceX(), 5);
		assertEquals(testP.getPieceY(), 5);

	}

	@Test
	public void ValidQueenBlockedByRival() throws Exception {
		Board game = new Board();
		Queen testP = new Queen(5, 5, true);
		Pawn blockP = new Pawn(3, 3, false);

		game.putPiece(testP);
		game.putPiece(blockP);

		Position des = new Position(3, 3);
		int res = game.movePiece(testP, des);

		assertEquals(res, 1);
		assertEquals(game.getBoard()[3][3], testP);
		assertEquals(testP.getPieceX(), 3);
		assertEquals(testP.getPieceY(), 3);

	}

}
