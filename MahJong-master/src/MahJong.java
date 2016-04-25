import java.awt.*;
import java.net.*;
//import java.util.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class MahJong extends JFrame {
	/*All commented out code in this file and in TileStack.java are related to the 
	 * numbered game feature, which I was not able to get working.  It was giving me a 
	 * null pointer error for some reason, and thus had to be commented out to make
	 * everything else functional.  But I did want to show that I at least made some 
	 * attempt to implement it anyways.*/
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Container contain;
	private Help gameRules = new Help("help/rules.html", "Game Rules");
	private Help gameInstructions = new Help("help/instructions.html", "Game Instructions");
	private ImageIcon	image;
	private URL url;
	private Tile first = null;
	private Tile second = null;
	private Tile t1;
	private Tile t2;
	private Fireworks	fw = new Fireworks();
	private JFrame frame = new JFrame();
	private Board b = new Board();
	//private NumberedGame numberedGame = new NumberedGame();
	private ScrollPane scroller = new ScrollPane();
	private Border selected = BorderFactory.createLineBorder(Color.RED);
	private boolean sound = true;
	//private long number;
	//private long promptNumber;
	private int removedCount = 0;
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	
	public MahJong(){
		
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

		addWindowListener(new WindowAdapter()
				{ public void windowClosing(WindowEvent e)
					{ exit(); }
				});
		
		setSize(945, 695);
		setTitle("Mah Jong Solitare");
		setVisible(true);
		
		/*if (JOptionPane.showConfirmDialog(this,
				"Would you like to play a numbered game?", "End Program",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
			
			promptNumber = Integer.parseInt(JOptionPane.showInputDialog("Please Enter the number of the "
					+ "game you would like to play."));
			
			if (promptNumber == numberedGame.number){
				
				numberedGame.setVisible(true);
				
			}
			
		}*/
		
		//else{
		
			add(b);
			//revalidate();
		
		//}
		
	}
	
	private void makeMenu()
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
		restart.setToolTipText("Restart Current Game");
		gameMenu.add(restart);
		restart.addActionListener(new ActionListener()
				{ public void actionPerformed(ActionEvent e)
					{ restart(); }
				});
		
		JMenuItem	number = new JMenuItem("Number", 'N');
		number.setToolTipText("Number This Game");
		gameMenu.add(number);
		number.addActionListener(new ActionListener()
				{ public void actionPerformed(ActionEvent e)
					{ /*number();*/ }
				});
		
		ButtonGroup	group = new ButtonGroup();
		JMenu		soundMenu = new JMenu("Sound");
		soundMenu.setMnemonic('S');
		menuBar.add(soundMenu);

		JRadioButtonMenuItem	on = new JRadioButtonMenuItem("On", true);
		group.add(on);
		soundMenu.add(on);
		on.setToolTipText("Turn Sound On");
		on.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
		on.setMnemonic('O');
		on.addActionListener(new ActionListener()
				{ public void actionPerformed(ActionEvent e)
					{ sound = true;
					fw.sound = true; }
				});
		
		JRadioButtonMenuItem	off = new JRadioButtonMenuItem("Off");
		group.add(off);
		soundMenu.add(off);
		off.setToolTipText("Turn Sound Off");
		off.setAccelerator(KeyStroke.getKeyStroke("ctrl F"));
		off.setMnemonic('F');
		off.addActionListener(new ActionListener()
				{ public void actionPerformed(ActionEvent e)
					{ sound = false;
					fw.sound = false; }
				});
		
		JMenu	moveMenu = new JMenu("Move");
		moveMenu.setMnemonic('M');
		menuBar.add(moveMenu);

		JMenuItem	view = new JMenuItem("View", 'V');
		view.setToolTipText("View Your Moves");
		moveMenu.add(view);
		view.addActionListener(new ActionListener()
				{ public void actionPerformed(ActionEvent e)
					{ JOptionPane.showMessageDialog(null, scroller,
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
					{  gameRules.display(); }
				});
		
		JMenuItem	instructions = new JMenuItem("Instructions", 'I');
		instructions.setToolTipText("Game Rules");
		helpMenu.add(instructions);
		instructions.addActionListener(new ActionListener()
				{ public void actionPerformed(ActionEvent e)
					{  gameInstructions.display(); }
				});
		
	}
	
	public void play(){
		
		if (JOptionPane.showConfirmDialog(this,
				"Do you want to play a new game?", "End Program",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION){
		
			contain = getContentPane();
			contain.removeAll();
			b = new Board();
			contain.add(b);
			validate();
			removedCount = 0;
		
		}
		
	}
	
	public void restart(){
		
		if (JOptionPane.showConfirmDialog(this,
				"Do you want to restart the current game?", "End Program",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION){
			
			while (!scroller.undoStack.empty()) 
				undoMove();
			
		}
	
	}
	
	/*public void number(){
		
		if (JOptionPane.showConfirmDialog(this,
				"Do you want to number this game?", "End Program",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION){
			
			number = numberedGame.seedUsed % 100000;
			numberedGame.number = number;
			setTitle("Game Number" + number);
			
		}
		
	}*/
	
	public void Undo(){
		
		if (JOptionPane.showConfirmDialog(this,
				"Do you want to undo the latest move?", "End Program",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION)
			undoMove();
		
	}
	
	public void exit(){
		
		if (JOptionPane.showConfirmDialog(this,
				"Do you want to exit Mah Jong Solitare?", "End Program",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION)
		System.exit(0);
		
	}
	
	public void undoMove(){
			
			t1 = scroller.undoStack.peek();
			scroller.undoStack.pop();
			t2 = scroller.undoStack.peek();
			scroller.undoStack.pop();
			t1.addMouseListener(b); 
			t2.addMouseListener(b);
			x1 = t1.x;
			y1 = t1.y;
			
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
			
			x2 = t2.x;
			y2 = t2.y;
			
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
			
			t1.setLocation(x1, y1);
			b.add(t1);
			t2.setLocation(x2, y2);
			b.add(t2);
			b.setComponentZOrder(t1, t1.getZOrder());
			b.setComponentZOrder(t2, t2.getZOrder());
			
			revalidate();
			repaint();
			removedCount--;
		
	}
	
	public class Board extends JPanel implements MouseListener{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public Board(){
			
			setLayout(null); //must do "setSize() in Tile
			setBackground(Color.YELLOW);
			makeMenu();
			
			url = Board.class.getResource("images/dragon_bg.png");
			image = new ImageIcon(url);
			image = new ImageIcon(image.getImage().getScaledInstance(655, -1, 
					Image.SCALE_SMOOTH));
		
			Tile t;
			TileStack ts = new TileStack(); //TileStack(false)
			//numberedGame.seedUsed = ts.seedCaptured;
			
			int x;
			int y;
			
			int n1 = 12;
			int n2 = 8;
			int n3 = 10;
			int r1 = 60;
			int r2 = 180;
			int r3 = 120;
			int row = r1;
			int number = n1;
			int bottom = 0;
			int bottomRow = 0;
			boolean repeat = false;
			
			t = ts.stack.remove(ts.stack.size() - 1);
			t.addMouseListener(this);
			t.x = 465;
			t.y = 175;
			x = t.x;
			y = t.y;
			ts.stack.get(ts.stack.size() - 1).top = t;
			ts.stack.get(ts.stack.size() - 2).top = t;
			ts.stack.get(ts.stack.size() - 3).top = t;
			ts.stack.get(ts.stack.size() - 4).top = t;
			t.bottom = ts.stack.get(ts.stack.size() - 1);
			t.bottom2 = ts.stack.get(ts.stack.size() - 2);
			t.bottom3 = ts.stack.get(ts.stack.size() - 3);
			t.bottom4 = ts.stack.get(ts.stack.size() - 4);
			t.setLocation(x, y);
			add(t);
			
			for (int j = 230; j > (230 - (75 * 2)); j -= 75){
				
				if (j == 230)
					bottom = 9;
				else
					bottom += 2;
				
				for (int i = 420; i < (420 + (60 * 2)); i += 60){
				
					t = ts.stack.remove(ts.stack.size() - 1);
					t.addMouseListener(this);
					t.x = i;
					t.y = j;
					x = t.x;
					y = t.y;
					ts.stack.get(ts.stack.size() - bottom).top = t;
					t.bottom = ts.stack.get(ts.stack.size() - bottom);
					t.setLocation(x, y);
					add(t);
				
				}
				
			}
			
			for (int j = 330; j > (330 - (75 * 4)); j -= 75){
				if (j == 330)
					bottom = 23;
				else
					bottom += 2;
				
				for (int i = 340; i < (340 + (60 * 4)); i += 60){
				
					t = ts.stack.remove(ts.stack.size() - 1);
					t.addMouseListener(this);
					t.x = i;
					t.y = j;
					x = t.x;
					y = t.y;
					
					if (i != (340 + (60 * 3))){
						
						ts.stack.get(ts.stack.size() - 1).left = t;
						t.right = ts.stack.get(ts.stack.size() - 1);
						
					}
						
					ts.stack.get(ts.stack.size() - bottom).top = t;
					t.bottom = ts.stack.get(ts.stack.size() - bottom);
					t.setLocation(x, y);
					add(t);
				
				}
				
			}
			
						
			for (int j = 430; j > (430 - (75 * 6)); j -= 75){
			
				bottomRow++;
				
				switch (bottomRow){
					
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
				
				for (int i = 260; i < (260 + (60 * 6)); i += 60){
				
					t = ts.stack.remove(ts.stack.size() - 1);
					t.addMouseListener(this);
					t.x = i;
					t.y = j;
					x = t.x;
					y = t.y;
					
					if (i != (260 + (60 * 5))){
						
						ts.stack.get(ts.stack.size() - 1).left = t;
						t.right = ts.stack.get(ts.stack.size() - 1);
					
					}
					ts.stack.get(ts.stack.size() - bottom).top = t;
					t.bottom = ts.stack.get(ts.stack.size() - bottom);
					t.setLocation(x, y);
					add(t);
				
				}
				
			}
			
			for (int j = 530; j > (530 - (75 * 4)); j -= 75){
				
				if (repeat && row == r1){
					
				 	t = ts.stack.remove(ts.stack.size() - 1);
				 	t.addMouseListener(this);
					t.x = 0;
					t.y = 270;
					x = t.x;
					y = t.y;
					ts.stack.get(ts.stack.size() - 1).left = t;
					t.right = ts.stack.get(ts.stack.size() - 1);
					ts.stack.get(ts.stack.size() - 13).left = t;
					t.right2 = ts.stack.get(ts.stack.size() - 13);
					t.setLocation(x, y);
					add(t);
					
				}
				for (int i = row; i < (row + (60 * number)); i += 60){
					
					t = ts.stack.remove(ts.stack.size() - 1);
					t.addMouseListener(this);
					t.x = i;
					t.y = j;
					x = t.x;
					y = t.y;
					
					if (i != (row + (60 * (number - 1)))){
						
						ts.stack.get(ts.stack.size() - 1).left = t;
						t.right = ts.stack.get(ts.stack.size() - 1);
					
					}

					else if (j == (530 - (75 * 3))){
						
						ts.stack.get(ts.stack.size() - 13).left2 = t;
						t.right = ts.stack.get(ts.stack.size() - 13);
						
					}
					
					
					t.setLocation(x, y);
					add(t);
					
				}
					
				if (row == r1){
					if (!repeat){
						row = r2;
						number = n2;
						continue;
					}
				}
				else if (row == r2){
					row = r3;
					number = n3;
					continue;
				}
				else if (row == r3){
					row = r1;
					number = n1;
					repeat = true;
				}
					
			}
			
			for (int j = 230; j > (230 - (75 * 4)); j -= 75){
				
				for (int i = row; i < (row + (60 * number)); i += 60){
					
					t = ts.stack.remove(ts.stack.size() - 1);
					t.addMouseListener(this);
					t.x = i;
					t.y = j;
					x = t.x;
					y = t.y;
					
					if (i != (row + (60 * (number - 1)))){
					  
						ts.stack.get(ts.stack.size() - 1).left = t;
						t.right = ts.stack.get(ts.stack.size() - 1);
					
					}
					t.setLocation(x, y);
					add(t);
					
				}
				
				if (j == 230){
					
					ts.stack.get(ts.stack.size() - 1).left = t;
					t.right = ts.stack.get(ts.stack.size() - 1);
					
				}
					
				if (repeat && row == r1){
					
				 	t = ts.stack.remove(ts.stack.size() - 1);
				 	t.addMouseListener(this);
				 	t.x = 780;
					t.y = 270;
					x = t.x;
					y = t.y;
					ts.stack.get(ts.stack.size() - 1).left = t;
					t.right = ts.stack.get(ts.stack.size() - 1);
					t.setLocation(x, y);
					add(t);
					
					t = ts.stack.remove(ts.stack.size() - 1);
					t.addMouseListener(this);
					t.x = 840;
					t.y = 270;
					x = t.x;
					y = t.y;
					t.setLocation(x, y);
					add(t);
					
					repeat = false;
					
				}
					
				if (row == r1){
					row = r3;
					number = n3;
					continue;
				}
				else if (row == r3){
					row = r2;
					number = n2;
					continue;
				}
				else if (row == r2){
					row = r1;
					number = n1;
				}
					
			}
			
		}
		
		/*public Board(ArrayList<Tile> stack){
			
			setLayout(null); //must do "setSize() in Tile
			setBackground(Color.YELLOW);
			makeMenu();
			
			url = Board.class.getResource("images/dragon_bg.png");
			image = new ImageIcon(url);
			image = new ImageIcon(image.getImage().getScaledInstance(655, -1, 
					Image.SCALE_SMOOTH));
		
			Tile t;
			
			int x;
			int y;
			
			int n1 = 12;
			int n2 = 8;
			int n3 = 10;
			int r1 = 60;
			int r2 = 180;
			int r3 = 120;
			int row = r1;
			int number = n1;
			int bottom = 0;
			int bottomRow = 0;
			boolean repeat = false;
			
			t = stack.remove(stack.size() - 1);
			t.addMouseListener(this);
			t.x = 465;
			t.y = 175;
			x = t.x;
			y = t.y;
			stack.get(stack.size() - 1).top = t;
			stack.get(stack.size() - 2).top = t;
			stack.get(stack.size() - 3).top = t;
			stack.get(stack.size() - 4).top = t;
			t.bottom = stack.get(stack.size() - 1);
			t.bottom2 = stack.get(stack.size() - 2);
			t.bottom3 = stack.get(stack.size() - 3);
			t.bottom4 = stack.get(stack.size() - 4);
			t.setLocation(x, y);
			add(t);
			
			for (int j = 230; j > (230 - (75 * 2)); j -= 75){
				
				if (j == 230)
					bottom = 9;
				else
					bottom += 2;
				
				for (int i = 420; i < (420 + (60 * 2)); i += 60){
				
					t = stack.remove(stack.size() - 1);
					t.addMouseListener(this);
					t.x = i;
					t.y = j;
					x = t.x;
					y = t.y;
					stack.get(stack.size() - bottom).top = t;
					t.bottom = stack.get(stack.size() - bottom);
					t.setLocation(x, y);
					add(t);
				
				}
				
			}
			
			for (int j = 330; j > (330 - (75 * 4)); j -= 75){
				if (j == 330)
					bottom = 23;
				else
					bottom += 2;
				
				for (int i = 340; i < (340 + (60 * 4)); i += 60){
				
					t = stack.remove(stack.size() - 1);
					t.addMouseListener(this);
					t.x = i;
					t.y = j;
					x = t.x;
					y = t.y;
					
					if (i != (340 + (60 * 3))){
						
						stack.get(stack.size() - 1).left = t;
						t.right = stack.get(stack.size() - 1);
						
					}
						
					stack.get(stack.size() - bottom).top = t;
					t.bottom = stack.get(stack.size() - bottom);
					t.setLocation(x, y);
					add(t);
				
				}
				
			}
			
						
			for (int j = 430; j > (430 - (75 * 6)); j -= 75){
			
				bottomRow++;
				
				switch (bottomRow){
					
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
				
				for (int i = 260; i < (260 + (60 * 6)); i += 60){
				
					t = stack.remove(stack.size() - 1);
					t.addMouseListener(this);
					t.x = i;
					t.y = j;
					x = t.x;
					y = t.y;
					
					if (i != (260 + (60 * 5))){
						
						stack.get(stack.size() - 1).left = t;
						t.right = stack.get(stack.size() - 1);
					
					}
					stack.get(stack.size() - bottom).top = t;
					t.bottom = stack.get(stack.size() - bottom);
					t.setLocation(x, y);
					add(t);
				
				}
				
			}
			
			for (int j = 530; j > (530 - (75 * 4)); j -= 75){
				
				if (repeat && row == r1){
					
				 	t = stack.remove(stack.size() - 1);
				 	t.addMouseListener(this);
					t.x = 0;
					t.y = 270;
					x = t.x;
					y = t.y;
					stack.get(stack.size() - 1).left = t;
					t.right = stack.get(stack.size() - 1);
					stack.get(stack.size() - 13).left = t;
					t.right2 = stack.get(stack.size() - 13);
					t.setLocation(x, y);
					add(t);
					
				}
				for (int i = row; i < (row + (60 * number)); i += 60){
					
					t = stack.remove(stack.size() - 1);
					t.addMouseListener(this);
					t.x = i;
					t.y = j;
					x = t.x;
					y = t.y;
					
					if (i != (row + (60 * (number - 1)))){
						
						stack.get(stack.size() - 1).left = t;
						t.right = stack.get(stack.size() - 1);
					
					}

					else if (j == (530 - (75 * 3))){
						
						stack.get(stack.size() - 13).left2 = t;
						t.right = stack.get(stack.size() - 13);
						
					}
					
					
					t.setLocation(x, y);
					add(t);
					
				}
					
				if (row == r1){
					if (!repeat){
						row = r2;
						number = n2;
						continue;
					}
				}
				else if (row == r2){
					row = r3;
					number = n3;
					continue;
				}
				else if (row == r3){
					row = r1;
					number = n1;
					repeat = true;
				}
					
			}
			
			for (int j = 230; j > (230 - (75 * 4)); j -= 75){
				
				for (int i = row; i < (row + (60 * number)); i += 60){
					
					t = stack.remove(stack.size() - 1);
					t.addMouseListener(this);
					t.x = i;
					t.y = j;
					x = t.x;
					y = t.y;
					
					if (i != (row + (60 * (number - 1)))){
					  
						stack.get(stack.size() - 1).left = t;
						t.right = stack.get(stack.size() - 1);
					
					}
					t.setLocation(x, y);
					add(t);
					
				}
				
				if (j == 230){
					
					stack.get(stack.size() - 1).left = t;
					t.right = stack.get(stack.size() - 1);
					
				}
					
				if (repeat && row == r1){
					
				 	t = stack.remove(stack.size() - 1);
				 	t.addMouseListener(this);
				 	t.x = 780;
					t.y = 270;
					x = t.x;
					y = t.y;
					stack.get(stack.size() - 1).left = t;
					t.right = stack.get(stack.size() - 1);
					t.setLocation(x, y);
					add(t);
					
					t = stack.remove(stack.size() - 1);
					t.addMouseListener(this);
					t.x = 840;
					t.y = 270;
					x = t.x;
					y = t.y;
					t.setLocation(x, y);
					add(t);
					
					repeat = false;
					
				}
					
				if (row == r1){
					row = r3;
					number = n3;
					continue;
				}
				else if (row == r3){
					row = r2;
					number = n2;
					continue;
				}
				else if (row == r2){
					row = r1;
					number = n1;
				}
					
			}
			
		}*/
		
		public void paintComponent(Graphics g){
			
			super.paintComponent(g);
			
			g.drawImage(image.getImage(), 105, 110, this);
			
		}
		
		public boolean removable(Tile inOther){
			
			if (inOther.top == null && (inOther.left == null) || inOther.top == null && 
					(inOther.right == null)) 
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
					
					if (first == null){
						
						first = tile;
						first.setBorder(selected);
						return;
						
					}
					else if (tile == first){		
						
						first.setBorder(null);
						first = null;
						return;
						
					}

					second = tile; 
					
					if (first.matches(second)){
						
						if (first.left == null && first.right != null)
							first.right.left = null;
						else if (first.right == null && first.left != null)
							first.left.right = null;
						
						if (first.bottom != null)
							first.bottom.top = null;
							
						if (first.bottom2 != null && 
								first.bottom3 != null && first.bottom4 != null){
							
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
							
						if (second.bottom2 != null && 
								second.bottom3 != null && second.bottom4 != null){
						
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
						
						scroller.addToUndo(second, first);
						
						first = null;
						second = null;
						
						if (sound){
							
							PlayClip clip = new PlayClip("audio/stone-scraping.wav", true);
							clip.play();
							
						}
						
					}
					
					removedCount++;
					
					if (removedCount == 72){
						
						frame.addWindowListener(new WindowAdapter()
						{	public void windowClosing(WindowEvent event)
						{ frame.setVisible(false); }
						});
						
						frame.setSize(1000, 800);
						frame.add(fw.getPanel());
						frame.setVisible(true);

						fw.setExplosions(0, 1000);
						fw.fire();


						try
						{
							Thread.sleep(10000);
							fw.stop();
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
		
	public static void main(String[] args){
		
		new MahJong();
		
	}

}

//This code would have existed in a file called NumberedGame.java

/*import java.util.*;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class NumberedGame extends JFrame{

	/**
	 * 
	 */
	/*private static final long serialVersionUID = 1L;
	protected long number;
	protected long seedUsed = 0;
	private TileStack ts = new TileStack(true);
	private Random r = new Random(seedUsed);
	private MahJong numberedGame = new MahJong();
	
	public NumberedGame(){
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		setSize(945, 695);
		setTitle("Game Number " + number);
		setVisible(true);
		
		Collections.shuffle(ts.stack, r);
		MahJong.Board newNumberedGame = numberedGame.new Board(ts.stack);
		
		add(newNumberedGame);
		
	}
	
}*/
