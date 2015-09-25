package test;

import static org.junit.Assert.*;

import org.junit.Test;

import chess.Chess;

public class whoMovesFirst {

	@Test
	public void testWhiteFirst() 
	{
		if(Chess.gameCounter==1)
		{
			assertEquals(Chess.whichSide, true);
		}
	}


}
