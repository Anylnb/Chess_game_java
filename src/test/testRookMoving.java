package test;

import static org.junit.Assert.*;

import org.junit.Test;

import chess.Board;
import chess.Pawn;
import chess.Position;
import chess.Rook;

public class testRookMoving {

	//test for Rook starting (3,0) 
	//moving Vertically
	@Test
	public void ValidRookVerticalWay() throws Exception {
        Board game = new Board();
        Rook testP = new Rook(3,0,true);
        game.putPiece(testP);
        for(int i = 1;i<8;i++)
        {
        	Position des = new Position(3,i);
        	int res = game.movePiece(testP, des);
        	//System.out.println (testP.getPieceX() + "yukisan" +testP.getPieceY());
        	assertEquals(res, 1);
        	assertEquals(game.getBoard()[3][i], testP);
        	assertEquals(testP.getPieceX(), 3);
        	assertEquals(testP.getPieceY(), i);
        }
	}
	
	//test for Rook starting (3,0) 
	//moving Horizontally
	@Test
	public void ValidRookHoriWay() throws Exception {
        Board game = new Board();
        Rook testP = new Rook(3,0,true);
        game.putPiece(testP);
        for(int i = 1;i<8;i++)
        {
        	Position des = new Position(i,0);
        	int res = game.movePiece(testP, des);
        	//System.out.println (testP.getPieceX() + "yukisan" +testP.getPieceY());
        	assertEquals(res, 1);
        	assertEquals(game.getBoard()[i][0], testP);
        	assertEquals(testP.getPieceX(), i);
        	assertEquals(testP.getPieceY(), 0);
        }
	}
	
	//test for Rook starting (3,0) 
	//moving Diagonally
	@Test
	public void ValidRookDiagWay() throws Exception {
        Board game = new Board();
        Rook testP = new Rook(5,5,true);
        game.putPiece(testP);
        for(int i = 0;i<8;i++)
        {
        	Position des = new Position(i,i);
        	int res = game.movePiece(testP, des);
        	//System.out.println (testP.getPieceX() + "yukisan" +testP.getPieceY());
        	assertEquals(res, 2);
        	assertEquals(game.getBoard()[5][5], testP);
        	assertEquals(testP.getPieceX(), 5);
        	assertEquals(testP.getPieceY(), 5);
        }
	}
	
	//When the destination is out of bound
	//Nothing happens and the piece stays the same location
	@Test
	public void ValidRookOffBound() throws Exception {
        Board game = new Board();
        Rook testP = new Rook(5,5,true);
        game.putPiece(testP);
       
        	Position des = new Position(9,9);
        	int res = game.movePiece(testP, des);
        	assertEquals(res, 2);
        	assertEquals(game.getBoard()[5][5], testP);
        	assertEquals(testP.getPieceX(), 5);
        	assertEquals(testP.getPieceY(), 5);
        
	}
	@Test
	public void ValidRookBlockedBySameSide() throws Exception 
	{
        Board game = new Board();
        Rook testP = new Rook(5,5,true);
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
	public void ValidRookBlockedByRival() throws Exception 
	{
        Board game = new Board();
        Rook testP = new Rook(5,5,true);
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
