package test;

import static org.junit.Assert.*;

import org.junit.Test;

import chess.Board;
import chess.Position;
import chess.King;
import chess.Pawn;

public class testKingMoving {

	//test for King starting (3,0) 
	//moving Vertically
	@Test
	public void ValidKingVerticalWay() throws Exception {
        Board game = new Board();
        King testP = new King(3,0,true);
        game.putPiece(testP);
        
        	Position des = new Position(3,1);
        	int res = game.movePiece(testP, des);
        	//System.out.println (testP.getPieceX() + "yukisan" +testP.getPieceY());
        	assertEquals(res, 1);
        	assertEquals(game.getBoard()[3][1], testP);
        	assertEquals(testP.getPieceX(), 3);
        	assertEquals(testP.getPieceY(), 1);
        
	}
	
	//test for King starting (3,0) 
	//moving Horizontally
	@Test
	public void ValidKingHoriWay() throws Exception {
        Board game = new Board();
        King testP = new King(3,0,true);
        game.putPiece(testP);
        
        	Position des = new Position(2,0);
        	int res = game.movePiece(testP, des);
        	System.out.println (testP.getPieceX() + "yukisan" +testP.getPieceY());
        	assertEquals(res, 1);
        	assertEquals(game.getBoard()[2][0], testP);
        	assertEquals(testP.getPieceX(), 2);
        	assertEquals(testP.getPieceY(), 0);

	}
	
	//test for King starting (5,5) 
	//moving Diagonally
	@Test
	public void ValidKingDiagWay() throws Exception {
        Board game = new Board();
        King testP = new King(5,5,true);
        game.putPiece(testP);

        	Position des = new Position(4,4);
        	int res = game.movePiece(testP, des);
        	//System.out.println (testP.getPieceX() + "yukisan" +testP.getPieceY());
        	assertEquals(res, 1);
        	assertEquals(game.getBoard()[4][4], testP);
        	assertEquals(testP.getPieceX(), 4);
        	assertEquals(testP.getPieceY(), 4);
        
	}
	
	//When the destination is out of bound
	//Nothing happens and the piece stays the same location
	@Test
	public void ValidKingOffBound() throws Exception {
        Board game = new Board();
        King testP = new King(5,5,true);
        game.putPiece(testP);
       
        	Position des = new Position(9,9);
        	int res = game.movePiece(testP, des);
        	assertEquals(res, 2);
        	assertEquals(game.getBoard()[5][5], testP);
        	assertEquals(testP.getPieceX(), 5);
        	assertEquals(testP.getPieceY(), 5);
        
	}
	@Test
	public void inValidKingWay() throws Exception {
        Board game = new Board();
        King testP = new King(5,5,true);
        game.putPiece(testP);

        	Position des = new Position(3,3);
        	int res = game.movePiece(testP, des);
        	//System.out.println (testP.getPieceX() + "yukisan" +testP.getPieceY());
        	assertEquals(res, 2);
        	assertEquals(game.getBoard()[5][5], testP);
        	assertEquals(testP.getPieceX(), 5);
        	assertEquals(testP.getPieceY(), 5);
        
	}
	@Test
	public void ValidKingBlockedBySameSide() throws Exception 
	{
        Board game = new Board();
        King testP = new King(5,5,true);
        Pawn blockP = new Pawn(4,4,true);
        
        game.putPiece(testP);
        game.putPiece(blockP);

        	
        Position des = new Position(4,4);
        int res = game.movePiece(testP, des);
        
        assertEquals(res, 2);
        assertEquals(game.getBoard()[5][5], testP);
        assertEquals(testP.getPieceX(), 5);
        assertEquals(testP.getPieceY(), 5);

	}
	
	@Test
	public void ValidKingBlockedByRival() throws Exception 
	{
        Board game = new Board();
        King testP = new King(5,5,true);
        Pawn blockP = new Pawn(4,4,false);
        
        game.putPiece(testP);
        game.putPiece(blockP);

        	
        Position des = new Position(4,4);
        int res = game.movePiece(testP, des);
        
        assertEquals(res, 1);
        assertEquals(game.getBoard()[4][4], testP);
        assertEquals(testP.getPieceX(), 4);
        assertEquals(testP.getPieceY(), 4);
 
	}
	
	

	
}
