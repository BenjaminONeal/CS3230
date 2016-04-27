import java.awt.*;
import java.net.*;
//import java.util.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class MahJong extends JFrame
{
	private static final long serialVersionUID = 1L;

	private Container container;
	private ImageIcon imageIcon;
	private URL url;

	private Tile first = null;
	private Tile second = null;
	private Tile tile1;
	private Tile tile2;
	private int xCoord1;
	private int yCoord1;
	private int xCoord2;
	private int yCoord2;

	private JFrame frame = new JFrame();
	private Board board= new Board();
	private ScrollPane scrollPane = new ScrollPane();
	private Border selectedTile = BorderFactory.createLineBorder(Color.RED);
	
	private boolean sound = true;
	private Fireworks fireworks = new Fireworks();
	private Help helpRules = new Help("help/rules.html", "Game Rules");
	private Help helpInstructions = new Help("help/instructions.html", "Game Instructions");
	private int removedCount = 0;
	
	public MahJong()
	{	
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter()
				{ public void windowClosing(WindowEvent e)
					{ exit(); }
				});
		setSize(945, 695);
		setTitle("Mah Jong Solitare");
		setVisible(true);		
		add(board);
	}
	
	private void drawMenu()
	{
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu gameMenu = new JMenu("Game");
		gameMenu.setMnemonic('D');
		menuBar.add(gameMenu);

		JMenuItem play = new JMenuItem("Play", 'P');
		play.setToolTipText("Start New Game");
		gameMenu.add(play);
		play.addActionListener(new ActionListener()
				{ public void actionPerformed(ActionEvent e)
					{ play(); }
				});

		JMenuItem restart = new JMenuItem("Restart", 'R');
		restart.setToolTipText("Restart Current Game");
		gameMenu.add(restart);
		restart.addActionListener(new ActionListener()
				{ public void actionPerformed(ActionEvent e)
					{ restart(); }
				});
		
		JMenuItem quit = new JMenuItem("Quit", 'Q');
		restart.setToolTipText("Quit the game");
		gameMenu.add(quit);
		quit.addActionListener(new ActionListener()
			{ public void actionPerformed(ActionEvent e)
				{ exit(); }
			});
		
		ButtonGroup	group = new ButtonGroup();
		JMenu soundMenu = new JMenu("Sound");
		soundMenu.setMnemonic('S');
		menuBar.add(soundMenu);

		JRadioButtonMenuItem soundOn = new JRadioButtonMenuItem("On", true);
		group.add(soundOn);
		soundMenu.add(soundOn);
		soundOn.setToolTipText("Turn Sound On");
		soundOn.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
		soundOn.setMnemonic('O');
		soundOn.addActionListener(new ActionListener()
				{ public void actionPerformed(ActionEvent e)
					{ sound = true;
					fireworks.sound = true; }
				});
		
		JRadioButtonMenuItem soundOff = new JRadioButtonMenuItem("Off");
		group.add(soundOff);
		soundMenu.add(soundOff);
		soundOff.setToolTipText("Turn Sound Off");
		soundOff.setAccelerator(KeyStroke.getKeyStroke("ctrl F"));
		soundOff.setMnemonic('F');
		soundOff.addActionListener(new ActionListener()
				{ public void actionPerformed(ActionEvent e)
					{ sound = false;
					fireworks.sound = false; }
				});
		
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
			
		JMenu	helpMenu = new JMenu("Help");
		helpMenu.setMnemonic('H');
		menuBar.add(helpMenu);

		JMenuItem	rules = new JMenuItem("Rules", 'R');
		rules.setToolTipText("Game Rules");
		helpMenu.add(rules);
		rules.addActionListener(new ActionListener()
				{ public void actionPerformed(ActionEvent e)
					{  helpRules.display(); }
				});
		
		JMenuItem	instructions = new JMenuItem("Instructions", 'I');
		instructions.setToolTipText("Game Rules");
		helpMenu.add(instructions);
		instructions.addActionListener(new ActionListener()
				{ public void actionPerformed(ActionEvent e)
					{  helpInstructions.display(); }
				});	
	}
	
	public void play()
	{	
		if (JOptionPane.showConfirmDialog(this,
				"Do you want to play a new game?", "End Program",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION)
		{		
			container = getContentPane();
			container.removeAll();
			board = new Board();
			container.add(board);
			validate();
			removedCount = 0;
		}
	}
	
	public void restart()
	{	
		if (JOptionPane.showConfirmDialog(this, 
				"Do you want to restart the game?", "Restart Game",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION)
		{
			while (!scrollPane.undoStack.empty()) 
				undoMove();	
		}
	}
	
	public void Undo()
	{
		if (JOptionPane.showConfirmDialog(this,
				"Do you want to undo the last move?", "Undo Move",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION)
		{
			undoMove();
		}
	}
	
	public void exit()
	{
		if (JOptionPane.showConfirmDialog(this,
				"Do you want to exit Mah Jong?", "Exit MahJong",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION)
		{
			System.exit(0);
		}
	}
	
	public void undoMove()
	{		
		tile1 = scrollPane.undoStack.peek();
		scrollPane.undoStack.pop();
		tile2 = scrollPane.undoStack.peek();
		scrollPane.undoStack.pop();
		tile1.addMouseListener(board); 
		tile2.addMouseListener(board);
		xCoord1 = tile1.xCoord;
		yCoord1 = tile1.yCoord;
			
		if (tile1.left == null && tile1.right != null)
			tile1.right.left = tile1;
		else if (tile1.right == null && tile1.left != null)
			tile1.left.right = tile1;
			
		if (tile1.bottom != null)
			tile1.bottom.top = tile1;
				
		if (tile1.bottom2 != null && tile1.bottom3 != null && tile1.bottom4 != null)
		{	
				tile1.bottom2.top = tile1;
				tile1.bottom3.top = tile1;
				tile1.bottom4.top = tile1;
		}
			
		if (tile1.left2 == null && tile1.right2 != null)
			tile1.right2.left = tile1;
		else if (tile1.right2 == null && tile1.left2 != null)
			tile1.left2.right = tile1;
			
		xCoord2 = tile2.xCoord;
		yCoord2 = tile2.yCoord;
			
		if (tile2.left == null && tile2.right != null)
			tile2.right.left = tile2;
		else if (tile2.right == null && tile2.left != null)
			tile2.left.right = tile2;
			
		if (tile2.bottom != null)
			tile2.bottom.top = tile2;
				
		if (tile2.bottom2 != null && tile2.bottom3 != null && tile2.bottom4 != null)
		{
			tile2.bottom2.top = tile2;
			tile2.bottom3.top = tile2;
			tile2.bottom4.top = tile2;					
		}
				
		if (tile2.left2 == null && tile2.right2 != null)
			tile2.right2.left = tile2;
		else if (tile2.right2 == null && tile2.left2 != null)
			tile2.left2.right = tile2;
			
		tile1.setLocation(xCoord1, yCoord1);
		board.add(tile1);
		tile2.setLocation(xCoord2, yCoord2);
		board.add(tile2);
		board.setComponentZOrder(tile1, tile1.getZOrder());
		board.setComponentZOrder(tile2, tile2.getZOrder());

		revalidate();
		repaint();
		removedCount--;
	}
	
	public class Board extends JPanel implements MouseListener
	{
		private static final long serialVersionUID = 1L;
		public Board()
		{
			setLayout(null);
			setBackground(Color.YELLOW);
			drawMenu();
			
			url = Board.class.getResource("images/dragon_bg.png");
			imageIcon = new ImageIcon(url);
			imageIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(655, -1, Image.SCALE_SMOOTH));
		
			Tile t;
			TileStack ts = new TileStack();
			
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
			
			t = ts.tileStack.remove(ts.tileStack.size() - 1);
			t.addMouseListener(this);
			t.xCoord = 465;
			t.yCoord = 175;
			x = t.xCoord;
			y = t.yCoord;
			ts.tileStack.get(ts.tileStack.size() - 1).top = t;
			ts.tileStack.get(ts.tileStack.size() - 2).top = t;
			ts.tileStack.get(ts.tileStack.size() - 3).top = t;
			ts.tileStack.get(ts.tileStack.size() - 4).top = t;
			t.bottom = ts.tileStack.get(ts.tileStack.size() - 1);
			t.bottom2 = ts.tileStack.get(ts.tileStack.size() - 2);
			t.bottom3 = ts.tileStack.get(ts.tileStack.size() - 3);
			t.bottom4 = ts.tileStack.get(ts.tileStack.size() - 4);
			t.setLocation(x, y);
			add(t);
			
			for (int j = 230; j > (230 - (75 * 2)); j -= 75)
			{	
				if (j == 230)
					bottom = 9;
				else
					bottom += 2;
				
				for (int i = 420; i < (420 + (60 * 2)); i += 60)
				{
					t = ts.tileStack.remove(ts.tileStack.size() - 1);
					t.addMouseListener(this);
					t.xCoord = i;
					t.yCoord = j;
					x = t.xCoord;
					y = t.yCoord;
					ts.tileStack.get(ts.tileStack.size() - bottom).top = t;
					t.bottom = ts.tileStack.get(ts.tileStack.size() - bottom);
					t.setLocation(x, y);
					add(t);
				}
			}
			
			for (int j = 330; j > (330 - (75 * 4)); j -= 75)
			{
				if (j == 330)
					bottom = 23;
				else
					bottom += 2;
				
				for (int i = 340; i < (340 + (60 * 4)); i += 60){
				
					t = ts.tileStack.remove(ts.tileStack.size() - 1);
					t.addMouseListener(this);
					t.xCoord = i;
					t.yCoord = j;
					x = t.xCoord;
					y = t.yCoord;
					
					if (i != (340 + (60 * 3)))
					{	
						ts.tileStack.get(ts.tileStack.size() - 1).left = t;
						t.right = ts.tileStack.get(ts.tileStack.size() - 1);	
					}
						
					ts.tileStack.get(ts.tileStack.size() - bottom).top = t;
					t.bottom = ts.tileStack.get(ts.tileStack.size() - bottom);
					t.setLocation(x, y);
					add(t);
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
					t = ts.tileStack.remove(ts.tileStack.size() - 1);
					t.addMouseListener(this);
					t.xCoord = i;
					t.yCoord = j;
					x = t.xCoord;
					y = t.yCoord;
					
					if (i != (260 + (60 * 5)))
					{	
						ts.tileStack.get(ts.tileStack.size() - 1).left = t;
						t.right = ts.tileStack.get(ts.tileStack.size() - 1);
					}
					ts.tileStack.get(ts.tileStack.size() - bottom).top = t;
					t.bottom = ts.tileStack.get(ts.tileStack.size() - bottom);
					t.setLocation(x, y);
					add(t);
				}
			}
			
			for (int j = 530; j > (530 - (75 * 4)); j -= 75)
			{	
				if (repeat && row == row1)
				{
				 	t = ts.tileStack.remove(ts.tileStack.size() - 1);
				 	t.addMouseListener(this);
					t.xCoord = 0;
					t.yCoord = 270;
					x = t.xCoord;
					y = t.yCoord;
					ts.tileStack.get(ts.tileStack.size() - 1).left = t;
					t.right = ts.tileStack.get(ts.tileStack.size() - 1);
					ts.tileStack.get(ts.tileStack.size() - 13).left = t;
					t.right2 = ts.tileStack.get(ts.tileStack.size() - 13);
					t.setLocation(x, y);
					add(t);
				}
				for (int i = row; i < (row + (60 * number)); i += 60)
				{
					t = ts.tileStack.remove(ts.tileStack.size() - 1);
					t.addMouseListener(this);
					t.xCoord = i;
					t.yCoord = j;
					x = t.xCoord;
					y = t.yCoord;
					
					if (i != (row + (60 * (number - 1))))
					{	
						ts.tileStack.get(ts.tileStack.size() - 1).left = t;
						t.right = ts.tileStack.get(ts.tileStack.size() - 1);
					
					}
					else if (j == (530 - (75 * 3)))
					{	
						ts.tileStack.get(ts.tileStack.size() - 13).left2 = t;
						t.right = ts.tileStack.get(ts.tileStack.size() - 13);	
					}
					
					t.setLocation(x, y);
					add(t);
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
					t = ts.tileStack.remove(ts.tileStack.size() - 1);
					t.addMouseListener(this);
					t.xCoord = i;
					t.yCoord = j;
					x = t.xCoord;
					y = t.yCoord;
					
					if (i != (row + (60 * (number - 1))))
					{  
						ts.tileStack.get(ts.tileStack.size() - 1).left = t;
						t.right = ts.tileStack.get(ts.tileStack.size() - 1);
					}
					t.setLocation(x, y);
					add(t);
				}
				if (j == 230)
				{	
					ts.tileStack.get(ts.tileStack.size() - 1).left = t;
					t.right = ts.tileStack.get(ts.tileStack.size() - 1);	
				}
					
				if (repeat && row == row1)
				{	
				 	t = ts.tileStack.remove(ts.tileStack.size() - 1);
				 	t.addMouseListener(this);
				 	t.xCoord = 780;
					t.yCoord = 270;
					x = t.xCoord;
					y = t.yCoord;
					ts.tileStack.get(ts.tileStack.size() - 1).left = t;
					t.right = ts.tileStack.get(ts.tileStack.size() - 1);
					t.setLocation(x, y);
					add(t);
					
					t = ts.tileStack.remove(ts.tileStack.size() - 1);
					t.addMouseListener(this);
					t.xCoord = 840;
					t.yCoord = 270;
					x = t.xCoord;
					y = t.yCoord;
					t.setLocation(x, y);
					add(t);
					
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
			g.drawImage(imageIcon.getImage(), 105, 110, this);
		}
		
		public boolean removable(Tile inOther)
		{	
			if ((inOther.top == null && inOther.left == null) || (inOther.top == null && inOther.right == null))	
				return true;
			else
				return false;	
		}
		
		public void mousePressed(MouseEvent e)
		{
			Tile tile = (Tile)e.getSource();
			
			if (e.getButton() == MouseEvent.BUTTON1)
			{
				if (removable(tile))
				{	
					if (first == null)
					{	
						first = tile;
						first.setBorder(selectedTile);
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
							first.right.left = null;
						else if (first.right == null && first.left != null)
							first.left.right = null;
						
						if (first.bottom != null)
							first.bottom.top = null;
							
						if (first.bottom2 != null && first.bottom3 != null && first.bottom4 != null)
						{	
							first.bottom2.top = null;
							first.bottom3.top = null;
							first.bottom4.top = null;
						}
						
						if (first.left2 == null && first.right2 != null)
							first.right2.left = null;
						else if (first.right2 == null && first.left2 != null)
							first.left2.right = null;
						
						if (second.left == null && second.right != null)
							second.right.left = null;
						else if (second.right == null && second.left != null)
							second.left.right = null;
						
						if (second.bottom != null)
							second.bottom.top = null;
							
						if (second.bottom2 != null && second.bottom3 != null && second.bottom4 != null)
						{
							second.bottom2.top = null;
							second.bottom3.top = null;
							second.bottom4.top = null;				
						}
							
						if (second.left2 == null && second.right2 != null)
							second.right2.left = null;
						else if (second.right2 == null && second.left2 != null)
							second.left2.right = null;
						 
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
						
						if (sound)
						{	
							PlayClip clip = new PlayClip("audio/stone-scraping.wav", true);
							clip.play();	
						}
					}
					
					removedCount++;
					
					if (removedCount == 72)
					{	
						frame.addWindowListener(new WindowAdapter()
							{ public void windowClosing(WindowEvent event)
							{ frame.setVisible(false); }
						});
						
						frame.setSize(1000, 800);
						frame.add(fireworks.getPanel());
						frame.setVisible(true);

						fireworks.setExplosions(0, 1000);
						fireworks.fire();

						try
						{
							Thread.sleep(10000);
							fireworks.stop();
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