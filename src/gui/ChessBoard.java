package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import chess.Board;
import chess.Chess;
import chess.Piece;
import chess.Position;

public class ChessBoard extends JFrame implements ActionListener 
{
	
	static ImageIcon hBlack = new ImageIcon("black/knight.png");
	static ImageIcon qBlack = new ImageIcon("black/queen.png");
	static ImageIcon rBlack = new ImageIcon("black/rook.png");
	static ImageIcon kBlack = new ImageIcon("black/king.png");
	static ImageIcon bBlack = new ImageIcon("black/bishop.png");
	static ImageIcon pBlack = new ImageIcon("black/pawn.png");
	static ImageIcon jBlack = new ImageIcon("black/jumper.png");
	static ImageIcon lBlack = new ImageIcon("black/blocker.png");
	
	static ImageIcon hWhite = new ImageIcon("white/knight.png");
	static ImageIcon qWhite = new ImageIcon("white/queen.png");
	static ImageIcon rWhite = new ImageIcon("white/rook.png");
	static ImageIcon kWhite = new ImageIcon("white/king.png");
	static ImageIcon bWhite = new ImageIcon("white/bishop.png");
	static ImageIcon pWhite = new ImageIcon("white/pawn.png");
	static ImageIcon jWhite = new ImageIcon("white/jumper.png");
	static ImageIcon lWhite = new ImageIcon("white/blocker.png");
	
	//static JFrame gameFrame = new JFrame();
	static JButton[][] gridGUI = new JButton[8][8];
	//static JButton[] options = new JButton[8];
	
	static Board tempBoard = new Board();
	
	static int whiteScore = 0;
	static int blackScore = 0;
	public static int firstX = -1;
	public static int firstY = -1;
	public static int secondX = -1;
	public static int secondY = -1;
	public boolean firstSelect = true;
	public boolean firstUndo = true;
	public static boolean isWhiteTurn = true;
	public boolean selectedSide;
	public String selectedRole;
	public static JMenuBar menuBar;
	public static JMenu menuStart;
	static Piece[][] tempBoardGrid = tempBoard.getBoard();
	public static boolean hasStarted  = false;
	public static String wPlayerName = "";
	public static String bPlayerName = "";
	public static int isCustomePiece = -100;
	static JPanel gamePanel = new JPanel();
	
	static JButton startButton = new JButton("New");
	
	static JButton undoButton = new JButton("Undo");
	static JButton endButton = new JButton("End");
	static JButton reportButton = new JButton("Report");

	
	static Piece previousPiece = null;
	
	public ChessBoard() 
	{
		// unlimited row of the Grid
		setLayout(new GridLayout(0, 8));

		int count = 0;
		for(int i = 0; i < gridGUI.length; i++, count++) {
			for(int j = 0; j < gridGUI.length; j++) {
				
				gridGUI[i][j] = new JButton();
				gridGUI[i][j].addActionListener(this);
				if(count % 2 == 0) {
					gridGUI[i][j].setBackground(Color.LIGHT_GRAY);
					gridGUI[i][j].setOpaque(true);
					gridGUI[i][j].setBorderPainted(false);
					//System.out.println("a");
				} else {
					gridGUI[i][j].setBackground(Color.GRAY);
					gridGUI[i][j].setOpaque(true);
					gridGUI[i][j].setBorderPainted(false);
				}
				add(gridGUI[i][j]);
				count++;
			}
		}
		   
		    startButton.addActionListener(this);

		    endButton.addActionListener(this);
		    undoButton.addActionListener(this);
		    reportButton.addActionListener(this);
		    add(startButton);
		    add(endButton);
		    add(undoButton);
		    add(reportButton);

		
	}
	
	/*!
	 * To clear up the pieces on the board and reset.
	 */
	public static void emptyBoard()
	{
		
		//isCustomePiece = -100;
		isWhiteTurn = true;
		firstX = -1;
		firstY = -1;
		int count = 0;
		for(int i = 0; i < gridGUI.length; i++, count++) {
			for(int j = 0; j < gridGUI.length; j++) {
				
				//gridGUI[i][j] = new JButton();
				gridGUI[i][j].setIcon(null);
				if(count % 2 == 0) {
					gridGUI[i][j].setBackground(Color.LIGHT_GRAY);
					gridGUI[i][j].setOpaque(true);
					gridGUI[i][j].setBorderPainted(false);
					//gridGUI[i][j].setIcon(null);
					tempBoardGrid[j][7-i] = null;
		
				} else {
					gridGUI[i][j].setBackground(Color.GRAY);
					gridGUI[i][j].setOpaque(true);
					gridGUI[i][j].setBorderPainted(false);
					//gridGUI[i][j].setIcon(null);
					tempBoardGrid[j][7-i] = null;
				}
				count++;
			}
		}
	}
	
	/*!
	 * Initial pieces on the board
	 * @param tempB
	 */
	public static void initialPieceImg(Board tempB)
	{
		Board.initialBoard();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (tempBoardGrid[j][i] != null)
					gridGUI[7 - i][j].setIcon(getImg(tempBoardGrid[j][i]));
			}
		}
	}
	
	/*!
	 * Create Dialogs at the beginning of the game.
	 */
	public static void gameStartDialog()
	{

		while(wPlayerName != null && wPlayerName.length() <=0 )
		{
			wPlayerName = (String)JOptionPane.showInputDialog(
	                null,
	                "What's the White side's name?\n",
	                "Name", JOptionPane.PLAIN_MESSAGE,
	                null,
	                null,
	                null);
		}
		
		
		while(bPlayerName != null && bPlayerName.length() <=0 )
		{
			bPlayerName = (String)JOptionPane.showInputDialog(
	                null,
	                "What's the Black side's name?\n",
	                "Name", JOptionPane.PLAIN_MESSAGE,
	                null,
	                null,
	                null);
			if(bPlayerName.equals(wPlayerName))
			{
				bPlayerName = new String("");
			}
		}

		isCustomePiece = JOptionPane.showConfirmDialog(
			    null,
			    "Would you like to use customized pieces?",
			    "Customized Piece",
			    JOptionPane.YES_NO_OPTION);
		
	}
	
	/*!
	 * Put piece on a specific position of the chess board.
	 * @param x
	 * @param y
	 * @param imggg
	 */
	public static void setPiece(int x, int y, ImageIcon imggg)
	{
		gridGUI[x][7-y].setIcon(imggg);
	}
	
	/*!
	 * Getter for JButton 2D array.
	 * @return The 2D array of the JButton
	 */
	public static JButton[][] getGridGUI ()
	{
		return gridGUI;
	}
	
	/*!
	 * Helper function to return the icon of the input piece
	 * @param temp
	 * @return the icon of the temp piece
	 */
	public static ImageIcon getImg(Piece temp)
	{
		ImageIcon res = new ImageIcon();
		if (temp.getColorBool()) {
			switch (temp.getName()) {
			case "Q":
				res = qWhite;
				break;
			case "H":
				res = hWhite;
				break;
			case "K":
				res = kWhite;
				break;
			case "R":
				res = rWhite;
				break;
			case "B":
				res = bWhite;
				break;
			case "P":
				res = pWhite;
				break;
			case "L":
				res = lWhite;
				break;
			case "J":
				res = jWhite;
				break;
			}
		}
		else
		{
			switch (temp.getName()) {
			case "Q":
				res = qBlack;
				break;
			case "H":
				res = hBlack;
				break;
			case "K":
				res = kBlack;
				break;
			case "R":
				res = rBlack;
				break;
			case "B":
				res = bBlack;
				break;
			case "P":
				res = pBlack;
				break;
			case "L":
				res = lBlack;
				break;
			case "J":
				res = jBlack;
				break;
			}
		}
		return res;
	}
	

	/*!
	 * 
	 * To get the piece on the GUI position
	 * @param guiX
	 * @param guiY
	 * @return piece on the GUI position
	 */
	public Piece getGUIPiece(int guiX, int guiY)
	{
		if(tempBoardGrid[guiY][7-guiX] != null)
			return tempBoardGrid[guiY][7-guiX];
		return null;
	}
	
	/*!
	 * 
	 * Add the piece to the GUI
	 * @param addP
	 * @param guiX
	 * @param guiY
	 */
	public void addGUIPiece(Piece addP, int guiX, int guiY)
	{
		gridGUI[guiX][guiY].setIcon(getImg(addP));
		tempBoardGrid[guiY][7-guiX] = addP;
		addP.x = guiY;
		addP.y = 7-guiX;
	}
	
	/*!
	 * 
	 * Remove the piece from GUI
	 * @param guiX
	 * @param guiY
	 */
	public void removeGUIPiece(int guiX, int guiY)
	{
		
		getGridGUI()[guiX][guiY].setIcon(null);
		tempBoardGrid[guiY][7-guiX] = null;
	}
	
	/*!
	 * Action Listener for all the buttons
	 */
	public void actionPerformed(ActionEvent evt) 
	{
		int tempX = -1;
		int tempY = -1;
		JButton temp = (JButton) evt.getSource();

		for (int i = 0;i < 8 ; i++)
		{
			for(int j = 0; j<8 ; j++)
			{
				//check the button user clicked
				if(getGridGUI()[i][j] == temp)
				{
					tempX = i;
					tempY = j;
					break;
				}
			}
		}
		//restart button
		if(temp == startButton)
		{
			int wGiveUp = JOptionPane.NO_OPTION;
			int bGiveUp = JOptionPane.NO_OPTION;
			if(firstX!=-1 && (wGiveUp = JOptionPane.showConfirmDialog(
				    null,
				    wPlayerName + " ,Would you like to restart?",
				    "Restart?",
				    JOptionPane.YES_NO_OPTION)) == JOptionPane.YES_OPTION)
			{
				
				bGiveUp  = JOptionPane.showConfirmDialog(
					    null,
					    bPlayerName + " ,Would you like to restart?",
					    "Restart?",
					    JOptionPane.YES_NO_OPTION);
			}
			if((firstX == -1 || (wGiveUp == JOptionPane.YES_OPTION && bGiveUp == JOptionPane.YES_OPTION)))
			{

					emptyBoard();
					initialPieceImg(tempBoard);
					
			}

		}
		else if(temp == endButton)
		{
			if(firstX != -1)
			{
				if (isWhiteTurn)
					blackScore+=2;
				else
					whiteScore+=2;
			}
			emptyBoard();
		}
		else if(temp == undoButton)
		{
			if (firstUndo) 
			{
				addGUIPiece(getGUIPiece(secondX, secondY), firstX, firstY);
				gridGUI[secondX][secondY].setIcon(null);
				if(previousPiece!=null)
				{
					//System.out.println(previousPiece.getColor() + " yuki ");
					
					addGUIPiece(previousPiece, secondX, secondY);
					
				}
				tempBoardGrid[secondY][7 - secondX] = previousPiece;
				secondX = firstX;
				secondY = firstY;
				isWhiteTurn = !isWhiteTurn;
				firstUndo = false;
			}
		}
		else if(temp == reportButton)
		{
			JOptionPane.showMessageDialog(null,
				    "White - "+ wPlayerName + " :" + whiteScore + "\n Black - "+ bPlayerName + " :" + blackScore,
				    "Score Report",
				    JOptionPane.PLAIN_MESSAGE);
		}
		else
		{
			
			Piece selectedPiece = getGUIPiece(tempX, tempY);
			if (firstSelect) {
				if (selectedPiece != null && selectedPiece.getColorBool() == isWhiteTurn) {
					selectedPiece = getGUIPiece(tempX, tempY);
					selectedSide = selectedPiece.getColorBool();
					selectedRole = selectedPiece.getName();
					firstX = tempX;
					firstY = tempY;
					firstSelect = false;
					//System.out.println(
							//selectedRole + " yuki save me " + selectedSide + " " + selectedPiece.x + selectedPiece.y);
				} else {
					JOptionPane.showMessageDialog(null, "Invalid Selection! Please try again.", "Inane error",
							JOptionPane.ERROR_MESSAGE);
				}
			} else {
				selectedPiece = getGUIPiece(firstX, firstY);
				//System.out.println(selectedPiece.x + " " + selectedPiece.y);
				previousPiece = getGUIPiece(tempX, tempY);
				int moveRes = tempBoard.movePiece(selectedPiece, new Position(tempY, 7 - tempX));
				String whoIsChecked = Board.checkedKing(tempBoard);

				if (moveRes == 1) {
					addGUIPiece(selectedPiece, tempX, tempY);
					getGridGUI()[firstX][firstY].setIcon(null);
					tempBoardGrid[firstY][7 - firstX] = null;
					secondX = tempX;
					secondY = tempY;
					isWhiteTurn = !isWhiteTurn;
					if (!whoIsChecked.equals(""))
						JOptionPane.showMessageDialog(null, whoIsChecked + " King is In Check!", "Inane warning",
								JOptionPane.WARNING_MESSAGE);

				}
				if (moveRes == 2) {
					JOptionPane.showMessageDialog(null, "Invalid Move! Please try again.", "Inane error",
							JOptionPane.ERROR_MESSAGE);
				}
				if (moveRes == 0) {
					JOptionPane.showMessageDialog(null, tempBoard.winner + " Win!", "Inane warning",
							JOptionPane.WARNING_MESSAGE);
					if (tempBoard.winner.equals("WHITE"))
						whiteScore++;
					if (tempBoard.winner.equals("BLACK"))
						blackScore++;
					emptyBoard();
				}

				firstSelect = true;
				firstUndo = true;

			}
		}
		
	}

	
	public static void main(String[] args) {
		
		JFrame chessBoarder = new ChessBoard();
		gameStartDialog();
		
		chessBoarder.add(gamePanel);

		chessBoarder.setTitle("Chess Game: White - " + wPlayerName + " vs Black - " + bPlayerName);
		chessBoarder.setLocation(300, 200);
		chessBoarder.setSize(450, 450);
		
		chessBoarder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		chessBoarder.setVisible(true);

		

	}
	
	
	
	
	
	
	
	
	
	
	
	
}