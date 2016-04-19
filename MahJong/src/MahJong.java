import java.awt.*;
import java.net.*;
//import java.util.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class MahJong extends JFrame 
{
	private JFrame frame = new JFrame();
	private Container container;
	private ImageIcon image;
	private ScrollPane scrollPane = new ScrollPane();
	private URL url;
	private Tile first = null;
	private Tile second = null;
	private Tile t1;
	private Tile t2;
	private Board board = new Board();
	private Border selected = BorderFactory.createLineBorder(Color.RED);
	private int removedCount = 0;

	private int xCoord1;
	private int yCoord1;
	private int xCoord2;
	private int yCoord2;
	
	
	public MahJong()
	{	
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){exit();}});
		setSize(950, 700);
		setTitle("Mah Jong Solitare");
		setVisible(true);
		add(board);
	}
	
	public void drawMenu()
	{
		JMenuBar	menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu	gameMenu = new JMenu("Game");
		gameMenu.setMnemonic('D');
		menuBar.add(gameMenu);

		JMenuItem	play = new JMenuItem("Play", 'P');
		play.setToolTipText("Start New Game");
		gameMenu.add(play);
		play.addActionListener(new ActionListener()
				{ public void actionPerformed(ActionEvent e)
					{ play(); }
				});

		JMenuItem	restart = new JMenuItem("Restart", 'R');
		restart.setToolTipText("Restart Game");
		gameMenu.add(restart);
		restart.addActionListener(new ActionListener()
				{ public void actionPerformed(ActionEvent e)
					{ restart(); }
				});

		JMenuItem quit = new JMenuItem("Quit", 'Q');
		quit.setToolTipText("Quit Game");
		gameMenu.add(quit);
		quit.addActionListener(new ActionListener()
			{ public void actionPerformed(ActionEvent e)
				{ exit(); }
			});
		
//		ButtonGroup	group = new ButtonGroup();
//		JMenu		soundMenu = new JMenu("Sound");
//		soundMenu.setMnemonic('S');
//		menuBar.add(soundMenu);
//
//		JRadioButtonMenuItem	on = new JRadioButtonMenuItem("On", true);
//		group.add(on);
//		soundMenu.add(on);
//		on.setToolTipText("Turn Sound On");
//		on.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
//		on.setMnemonic('O');
//		on.addActionListener(new ActionListener()
//				{ public void actionPerformed(ActionEvent e)
//					{ sound = true;
//					fw.sound = true; }
//				});
//		
//		JRadioButtonMenuItem	off = new JRadioButtonMenuItem("Off");
//		group.add(off);
//		soundMenu.add(off);
//		off.setToolTipText("Turn Sound Off");
//		off.setAccelerator(KeyStroke.getKeyStroke("ctrl F"));
//		off.setMnemonic('F');
//		off.addActionListener(new ActionListener()
//				{ public void actionPerformed(ActionEvent e)
//					{ sound = false;
//					fw.sound = false; }
//				});
		
		JMenu	moveMenu = new JMenu("Move");
		moveMenu.setMnemonic('M');
		menuBar.add(moveMenu);

		JMenuItem	view = new JMenuItem("View", 'V');
		view.setToolTipText("View Your Moves");
		moveMenu.add(view);
		view.addActionListener(new ActionListener()
				{ public void actionPerformed(ActionEvent e)
					{ JOptionPane.showMessageDialog(null, scrollPane,
							"Removed Tiles", JOptionPane.PLAIN_MESSAGE); }
				});
		
		JMenuItem	undo = new JMenuItem("Undo", 'U');
		undo.setToolTipText("Undo Last Move");
		moveMenu.add(undo);
		undo.addActionListener(new ActionListener()
				{public void actionPerformed(ActionEvent e)
				{ Undo(); }
		
				});
			
//		JMenu	helpMenu = new JMenu("Help");
//		helpMenu.setMnemonic('H');
//		menuBar.add(helpMenu);
//
//		JMenuItem	rules = new JMenuItem("Rules", 'R');
//		rules.setToolTipText("Game Rules");
//		helpMenu.add(rules);
//		rules.addActionListener(new ActionListener()
//				{ public void actionPerformed(ActionEvent e)
//					{  gameRules.display(); }
//				});
//		
//		JMenuItem	instructions = new JMenuItem("Instructions", 'I');
//		instructions.setToolTipText("Game Rules");
//		helpMenu.add(instructions);
//		instructions.addActionListener(new ActionListener()
//				{ public void actionPerformed(ActionEvent e)
//					{  gameInstructions.display(); }
//				});
	}
	
	public void play()
	{	
		if (JOptionPane.showConfirmDialog(this,
				"Do you want to play a new game?", "End Program",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION){
		
			container = getContentPane();
			container.removeAll();
			board = new Board();
			container.add(board);
			validate();
			removedCount = 0;
		}
	}
	
	public void Undo()
	{
		if (JOptionPane.showConfirmDialog(this,
				"Do you want to undo the latest move?", "End Program",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION)
			undoMove();	
	}
	
	public void undoMove()
	{
		t1 = scrollPane.undoStack.peek();
		scrollPane.undoStack.pop();
		t2 = scrollPane.undoStack.peek();
		scrollPane.undoStack.pop();
		t1.addMouseListener(board); 
		t2.addMouseListener(board);
		xCoord1 = t1.x;
		yCoord1 = t1.y;
		
		if (t1.left == null && t1.right != null)
			t1.right.left = t1;
		else if (t1.right == null && t1.left != null)
			t1.left.right = t1;
		
		if (t1.bottom != null)
			t1.bottom.top = t1;
			
		if (t1.bottom2 != null && 
				t1.bottom3 != null && t1.bottom4 != null){
			
			t1.bottom2.top = t1;
			t1.bottom3.top = t1;
			t1.bottom4.top = t1;
			
		}
		
		if (t1.left2 == null && t1.right2 != null)
			t1.right2.left = t1;
		else if (t1.right2 == null && t1.left2 != null)
			t1.left2.right = t1;
		
		xCoord2 = t2.x;
		yCoord2 = t2.y;
		
		if (t2.left == null && t2.right != null)
			t2.right.left = t2;
		else if (t2.right == null && t2.left != null)
			t2.left.right = t2;
		
		if (t2.bottom != null)
			t2.bottom.top = t2;
			
		if (t2.bottom2 != null && 
				t2.bottom3 != null && t2.bottom4 != null){
		
			t2.bottom2.top = t2;
			t2.bottom3.top = t2;
			t2.bottom4.top = t2;
						
		}
			
		if (t2.left2 == null && t2.right2 != null)
			t2.right2.left = t2;
		else if (t2.right2 == null && t2.left2 != null)
			t2.left2.right = t2;
		
		t1.setLocation(xCoord1, yCoord1);
		board.add(t1);
		t2.setLocation(xCoord2, yCoord2);
		board.add(t2);
		board.setComponentZOrder(t1, t1.getZOrder());
		board.setComponentZOrder(t2, t2.getZOrder());
		
		revalidate();
		repaint();
		removedCount--;
	
	}
	
	public void restart(){	
		if (JOptionPane.showConfirmDialog(this,
				"Do you want to restart the current game?", "Restart Game",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION){
			while (!scrollPane.undoStack.empty()) 
				undoMove();
		}
	}
	
	public void exit()
	{
		if (JOptionPane.showConfirmDialog(this, "Do you want to exit the MahJong game?", "End Game",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION)
			System.exit(0);
	}
	
	public class Board extends JPanel implements MouseListener
	{
		private static final long serialVersionUID = 1L;
		public Board()
		{	
			setLayout(null);
			setBackground(Color.YELLOW);
			drawMenu();
		
			Tile tile;
			TileStack tileStack = new TileStack();
			
			int x;
			int y;
			
			int num1 = 12;
			int num2 = 8;
			int num3 = 10;

			int row1 = 60;
			int row2 = 180;
			int row3 = 120;

			int row = row1;
			int number = num1;

			int bottom = 0;
			int bottomRow = 0;

			boolean repeat = false;
			
			tile = tileStack.stack.remove(tileStack.stack.size() - 1);
			tile.addMouseListener(this);

			tile.x = 470;
			tile.y = 180;
			x = tile.x;
			y = tile.y;

			tileStack.stack.get(tileStack.stack.size() - 1).top = tile;
			tileStack.stack.get(tileStack.stack.size() - 2).top = tile;
			tileStack.stack.get(tileStack.stack.size() - 3).top = tile;
			tileStack.stack.get(tileStack.stack.size() - 4).top = tile;

			tile.bottom = tileStack.stack.get(tileStack.stack.size() - 1);
			tile.bottom2 = tileStack.stack.get(tileStack.stack.size() - 2);
			tile.bottom3 = tileStack.stack.get(tileStack.stack.size() - 3);
			tile.bottom4 = tileStack.stack.get(tileStack.stack.size() - 4);
			tile.setLocation(x, y);
			add(tile);
			
			for (int j = 230; j > (230 - (75 * 2)); j -= 75)
			{	
				if (j == 230)
					bottom = 9;
				else
					bottom += 2;
				
				for (int i = 420; i < (420 + (60 * 2)); i += 60)
				{	
					tile = tileStack.stack.remove(tileStack.stack.size() - 1);
					tile.addMouseListener(this);
					tile.x = i;
					tile.y = j;
					x = tile.x;
					y = tile.y;
					tileStack.stack.get(tileStack.stack.size() - bottom).top = tile;
					tile.bottom = tileStack.stack.get(tileStack.stack.size() - bottom);
					tile.setLocation(x, y);
					add(tile);
				}
			}
			
			for (int j = 330; j > (330 - (75 * 4)); j -= 75)
			{
				if (j == 330)
					bottom = 23;
				else
					bottom += 2;
				
				for (int i = 340; i < (340 + (60 * 4)); i += 60)
				{
					tile = tileStack.stack.remove(tileStack.stack.size() - 1);
					tile.addMouseListener(this);
					tile.x = i;
					tile.y = j;
					x = tile.x;
					y = tile.y;
					
					if (i != (340 + (60 * 3)))
					{	
						tileStack.stack.get(tileStack.stack.size() - 1).left = tile;
						tile.right = tileStack.stack.get(tileStack.stack.size() - 1);	
					}
					tileStack.stack.get(tileStack.stack.size() - bottom).top = tile;
					tile.bottom = tileStack.stack.get(tileStack.stack.size() - bottom);
					tile.setLocation(x, y);
					add(tile);
				}
			}
					
			for (int j = 430; j > (430 - (75 * 6)); j -= 75)
			{
				bottomRow++;	
				switch (bottomRow)
				{
					case 1:
						bottom = 49;
						break;
					case 2:
						bottom += 3;
						break;
					case 3:
						bottom += 6;
						break;
					case 4:
						bottom += 6;
						break;
					case 5:
						bottom += 7;
						break;
					case 6:
						bottom += 3;	
					}
				
				for (int i = 260; i < (260 + (60 * 6)); i += 60)
				{
					tile = tileStack.stack.remove(tileStack.stack.size() - 1);
					tile.addMouseListener(this);
					tile.x = i;
					tile.y = j;
					x = tile.x;
					y = tile.y;
					
					if (i != (260 + (60 * 5)))
					{	
						tileStack.stack.get(tileStack.stack.size() - 1).left = tile;
						tile.right = tileStack.stack.get(tileStack.stack.size() - 1);
					}
					tileStack.stack.get(tileStack.stack.size() - bottom).top = tile;
					tile.bottom = tileStack.stack.get(tileStack.stack.size() - bottom);
					tile.setLocation(x, y);
					add(tile);
				}
			}
			
			for (int j = 530; j > (530 - (75 * 4)); j -= 75)
			{	
				if (repeat && row == row1)
				{	
				 	tile = tileStack.stack.remove(tileStack.stack.size() - 1);
				 	tile.addMouseListener(this);
					tile.x = 0;
					tile.y = 270;
					x = tile.x;
					y = tile.y;
					tileStack.stack.get(tileStack.stack.size() - 1).left = tile;
					tile.right = tileStack.stack.get(tileStack.stack.size() - 1);
					tileStack.stack.get(tileStack.stack.size() - 13).left = tile;
					tile.right2 = tileStack.stack.get(tileStack.stack.size() - 13);
					tile.setLocation(x, y);
					add(tile);	
				}
				for (int i = row; i < (row + (60 * number)); i += 60)
				{
					tile = tileStack.stack.remove(tileStack.stack.size() - 1);
					tile.addMouseListener(this);
					tile.x = i;
					tile.y = j;
					x = tile.x;
					y = tile.y;
					
					if (i != (row + (60 * (number - 1))))
					{	
						tileStack.stack.get(tileStack.stack.size() - 1).left = tile;
						tile.right = tileStack.stack.get(tileStack.stack.size() - 1);
					}

					else if (j == (530 - (75 * 3)))
					{	
						tileStack.stack.get(tileStack.stack.size() - 13).left2 = tile;
						tile.right = tileStack.stack.get(tileStack.stack.size() - 13);	
					}
					tile.setLocation(x, y);
					add(tile);
				}
					
				if (row == row1)
				{
					if (!repeat)
					{
						row = row2;
						number = num2;
						continue;
					}
				}
				else if (row == row2)
				{
					row = row3;
					number = num3;
					continue;
				}
				else if (row == row3)
				{
					row = row1;
					number = num1;
					repeat = true;
				}	
			}
			
			for (int j = 230; j > (230 - (75 * 4)); j -= 75)
			{	
				for (int i = row; i < (row + (60 * number)); i += 60)
				{	
					tile = tileStack.stack.remove(tileStack.stack.size() - 1);
					tile.addMouseListener(this);
					tile.x = i;
					tile.y = j;
					x = tile.x;
					y = tile.y;
					
					if (i != (row + (60 * (number - 1))))
					{  
						tileStack.stack.get(tileStack.stack.size() - 1).left = tile;
						tile.right = tileStack.stack.get(tileStack.stack.size() - 1);
					}
					tile.setLocation(x, y);
					add(tile);
				}
				
				if (j == 230)
				{	
					tileStack.stack.get(tileStack.stack.size() - 1).left = tile;
					tile.right = tileStack.stack.get(tileStack.stack.size() - 1);	
				}

				if (repeat && row == row1)
				{
				 	tile = tileStack.stack.remove(tileStack.stack.size() - 1);
				 	tile.addMouseListener(this);
				 	tile.x = 780;
					tile.y = 270;
					x = tile.x;
					y = tile.y;
					tileStack.stack.get(tileStack.stack.size() - 1).left = tile;
					tile.right = tileStack.stack.get(tileStack.stack.size() - 1);
					tile.setLocation(x, y);
					add(tile);
					
					tile = tileStack.stack.remove(tileStack.stack.size() - 1);
					tile.addMouseListener(this);
					tile.x = 840;
					tile.y = 270;
					x = tile.x;
					y = tile.y;
					tile.setLocation(x, y);
					add(tile);
					repeat = false;
				}
					
				if (row == row1)
				{
					row = row3;
					number = num3;
					continue;
				}
				else if (row == row3)
				{
					row = row2;
					number = num2;
					continue;
				}
				else if (row == row2)
				{
					row = row1;
					number = num1;
				}		
			}	
		}
		
		public void paintComponent(Graphics g)
		{	
			super.paintComponent(g);
			//g.drawImage(image.getImage(), 105, 110, this);	
		}
		
		public boolean removable(Tile t)
		{
			if (t.top == null && (t.left == null) || t.top == null && 
					(t.right == null)) 
				return true;
			else
				return false;
		}
		
		public void mousePressed(MouseEvent e)
		{
			Tile tile = (Tile)e.getSource();
			
			if (e.getButton() == MouseEvent.BUTTON1)
			{
				if (removable(tile)){
					
					if (first == null)
					{	
						first = tile;
						first.setBorder(selected);
						return;	
					}
					else if (tile == first)
					{			
						first.setBorder(null);
						first = null;
						return;
					}

					second = tile; 
					
					if (first.matches(second))
					{	
						if (first.left == null && first.right != null)
						{
							first.right.left = null;
						}
						else if (first.right == null && first.left != null)
						{
							first.left.right = null;
						}
						
						if (first.bottom != null)
							first.bottom.top = null;

						if (first.bottom2 != null && first.bottom3 != null && first.bottom4 != null)
						{	
							first.bottom2.top = null;
							first.bottom3.top = null;
							first.bottom4.top = null;	
						}
						
						if (first.left2 == null && first.right2 != null)
						{
							first.right2.left = null;
						}
						else if (first.right2 == null && first.left2 != null)
						{
							first.left2.right = null;
						}
						
						if (second.left == null && second.right != null)
						{
							second.right.left = null;
						}
						else if (second.right == null && second.left != null)
						{
							second.left.right = null;
						}
						
						if (second.bottom != null)
							second.bottom.top = null;
							
						if (second.bottom2 != null && second.bottom3 != null && second.bottom4 != null)
						{
							second.bottom2.top = null;
							second.bottom3.top = null;
							second.bottom4.top = null;				
						}
							
						if (second.left2 == null && second.right2 != null)
						{
							second.right2.left = null;
						}
						else if (second.right2 == null && second.left2 != null)
						{
							second.left2.right = null;
						}
						
						first.removeMouseListener(this);
						second.removeMouseListener(this);
						first.setBorder(null);
						
						second.setZOrder();
						remove(second);
						first.setZOrder();
						remove(first);
						repaint();
						
						scrollPane.addToUndo(second, first);
												
						first = null;
						second = null;						
					}
					
					removedCount++;
					
					if (removedCount == 72)//end of game - winner!
					{	
						frame.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent event)
							{frame.setVisible(false);}});
						
						frame.setSize(1000, 900);
						frame.setVisible(true);

						try
						{
							Thread.sleep(10000);
						}
						catch (InterruptedException ie) {}
					}
				}
			}
		}

		public void mouseClicked(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
	}
		
	public static void main(String[] args)
	{	
		new MahJong();	
	}
}