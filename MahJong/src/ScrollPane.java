import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Stack;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("serial")
public class ScrollPane extends JScrollPane{
		
		protected	JPanel[]	discard = new JPanel[2];
		protected	Stack<Tile>	undoStack = new Stack<Tile>();
		private int count = 0;
		
		public ScrollPane()
		{
			setPreferredSize(new Dimension(0, 2 * 100 + 33));

			discard[0] = new JPanel(new FlowLayout(FlowLayout.LEFT));
			discard[1] = new JPanel(new FlowLayout(FlowLayout.LEFT));
			discard[0].setPreferredSize(new Dimension(0, 100));
			discard[1].setPreferredSize(new Dimension(0, 100));

			JPanel	panel = new JPanel(new BorderLayout());
			
			setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			setViewportView(panel);

			panel.add(discard[0], BorderLayout.NORTH);
			panel.add(discard[1], BorderLayout.SOUTH);

			discard[0].setBackground(new Color(254, 205, 33));
			discard[1].setBackground(new Color(254, 205, 33));
			panel.setBackground(new Color(254, 205, 33));
		}

		public void addToUndo(Tile t1, Tile t2){
			
			undoStack.push(t1);
			undoStack.push(t2);
			
			Dimension size = new Dimension(++count * 85, 106);
			
			discard[0].setPreferredSize(size);
			discard[1].setPreferredSize(size);

			discard[0].add(t1, 0);
			discard[1].add(t2, 0);
			
		}
		
		public String toString()
		{
			return "ScrollPane " + count;
		}
		
}
