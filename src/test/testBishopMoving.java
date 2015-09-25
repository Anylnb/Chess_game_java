package test;

import static org.junit.Assert.*;

import org.junit.Test;

import chess.Board;
import chess.Pawn;
import chess.Position;
import chess.Bishop;

public class testBishopMoving {

	//test for Bishop starting (3,0) 
	//Can't move Vertically
	@Test
	public void ValidBishopVerticalWay() throws Exception {
        Board game = new Board();
        Bishop testP = new Bishop(3,0,true);
        game.putPiece(testP);
        for(int i = 1;i<8;i++)
        {
        	Position des = new Position(3,i);
        	int res = game.movePiece(testP, des);

        	assertEquals(res, 2);
        	assertEquals(game.getBoard()[3][0], testP);
        	assertEquals(testP.getPieceX(), 3);
        	assertEquals(testP.getPieceY(), 0);
        }
	}
	
	//test for Bishop starting (3,0) 
	//Can't move Horizontally
	@Test
	public void ValidBishopHoriWay() throws Exception {
        Board game = new Board();
        Bishop testP = new Bishop(3,0,true);
        game.putPiece(testP);
        for(int i = 1;i<8;i++)
        {
        	Position des = new Position(i,0);
        	int res = game.movePiece(testP, des);

        	assertEquals(res, 2);
        	assertEquals(game.getBoard()[3][0], testP);
        	assertEquals(testP.getPieceX(), 3);
        	assertEquals(testP.getPieceY(), 0);
        }
	}
	
	//test for Bishop starting (3,0) 
	//moving Diagonally
	@Test
	public void ValidBishopDiagWay() throws Exception {
        Board game = new Board();
        Bishop testP = new Bishop(5,5,true);
        game.putPiece(testP);
        for(int i = 0;i<8;i++)
        {
        	Position des = new Position(i,i);
        	int res = game.movePiece(testP, des);

        	assertEquals(res, 1);
        	assertEquals(game.getBoard()[i][i], testP);
        	assertEquals(testP.getPieceX(), i);
        	assertEquals(testP.getPieceY(), i);
        }
	}
	
	//When the destination is out of bound
	//Nothing happens and the piece stays the same location
	@Test
	public void ValidBishopOffBound() throws Exception {
        Board game = new Board();
        Bishop testP = new Bishop(5,5,true);
        game.putPiece(testP);
       
        	Position des = new Position(9,9);
        	int res = game.movePiece(testP, des);
        	assertEquals(res, 2);
        	assertEquals(game.getBoard()[5][5], testP);
        	assertEquals(testP.getPieceX(), 5);
        	assertEquals(testP.getPieceY(), 5);
        
	}
	
	//Nothing happens if the piece is blocked by self side
	@Test
	public void ValidBishopBlockedBySameSide() throws Exception 
	{
        Board game = new Board();
        Bishop testP = new Bishop(5,5,true);
        Pawn blockP = new Pawn(3,3,true);
        
        game.putPiece(testP);
        game.putPiece(blockP);

        	
        Position des = new Position(3,3);
        int res = game.movePiece(testP, des);
        
        assertEquals(res, 2);
        assertEquals(game.getBoard()[5][5], testP);
        assertEquals(testP.getPieceX(), 5);
        assertEquals(testP.getPieceY(), 5);

	}
	
	//Time for killing
	//Move to the location after killing
	@Test
	public void ValidBishopBlockedByRival() throws Exception 
	{
        Board game = new Board();
        Bishop testP = new Bishop(5,5,true);
        Pawn blockP = new Pawn(3,3,false);
        
        game.putPiece(testP);
        game.putPiece(blockP);

        	
        Position des = new Position(3,3);
        int res = game.movePiece(testP, des);
        
        assertEquals(res, 1);
        assertEquals(game.getBoard()[3][3], testP);
        assertEquals(testP.getPieceX(), 3);
        assertEquals(testP.getPieceY(), 3);
 
	}
	
	

	
}
