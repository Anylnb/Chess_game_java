package test;

import static org.junit.Assert.*;

import org.junit.Test;

import chess.Bishop;
import chess.King;
import chess.Knight;
import chess.Pawn;
import chess.Queen;
import chess.Rook;

public class testConstructor {

	@Test
	public void ValidQueen() throws Exception {
        boolean side = true;
        int x = 3;
        int y = 0;
        Queen testP = new Queen(x,y,side);
        assertEquals(side, testP.getColorBool());
        assertEquals(x, testP.getPieceX());
        assertEquals(y, testP.getPieceY());
	}
	
	@Test
	public void ValidKing() throws Exception {
        boolean side = true;
        int x = 3;
        int y = 0;
        King testP = new King(x,y,side);
        assertEquals(side, testP.getColorBool());
        assertEquals(x, testP.getPieceX());
        assertEquals(y, testP.getPieceY());
	}
	@Test
	public void ValidPawn() throws Exception {
        boolean side = true;
        int x = 3;
        int y = 0;
        Pawn testP = new Pawn(x,y,side);
        assertEquals(side, testP.getColorBool());
        assertEquals(x, testP.getPieceX());
        assertEquals(y, testP.getPieceY());
	}
	@Test
	public void ValidBishop() throws Exception {
        boolean side = true;
        int x = 3;
        int y = 0;
        Bishop testP = new Bishop(x,y,side);
        assertEquals(side, testP.getColorBool());
        assertEquals(x, testP.getPieceX());
        assertEquals(y, testP.getPieceY());
	}
	@Test
	public void ValidKnight() throws Exception {
        boolean side = true;
        int x = 3;
        int y = 0;
        Knight testP = new Knight(x,y,side);
        assertEquals(side, testP.getColorBool());
        assertEquals(x, testP.getPieceX());
        assertEquals(y, testP.getPieceY());
	}
	@Test
	public void ValidRook() throws Exception {
        boolean side = true;
        int x = 3;
        int y = 0;
        Rook testP = new Rook(x,y,side);
        assertEquals(side, testP.getColorBool());
        assertEquals(x, testP.getPieceX());
        assertEquals(y, testP.getPieceY());
	}
	
	

}
