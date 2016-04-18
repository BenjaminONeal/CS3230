import java.awt.*;
import java.net.*;
//import java.util.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class MahJong extends JFrame 
{
	private JFrame frame = new JFrame();
	private ImageIcon image;
	private URL url;
	private Tile first = null;
	private Tile second = null;
	private Tile t1;
	private Tile t2;
	private Board board = new Board();
	private Border selected = BorderFactory.createLineBorder(Color.RED);
	private int removedCount = 0;
	
	
	public MahJong()
	{	
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){exit();}});
		setSize(950, 700);
		setTitle("Mah Jong Solitare");
		setVisible(true);
		add(board);
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