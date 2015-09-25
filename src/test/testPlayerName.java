package test;

import static org.junit.Assert.*;

import org.junit.Test;

import gui.ChessBoard;

public class testPlayerName {

	@Test
	public void PlayerNameTest() 
	{
		assertEquals(ChessBoard.wPlayerName == null, false );
		assertEquals(ChessBoard.bPlayerName == null, false );
		
	}

}
