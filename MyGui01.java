import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;


class MyCanvas extends JComponent implements MouseListener{
	int x;
	int y;
	//constructor
	MyCanvas() {
		addMouseListener(this); //this guys also serves as mouse listener
	}
	protected void paintComponent(Graphics g){
		g.drawOval(x,y,20,20); //x,y.width,height
	}
	
		public void mouseClicked(MouseEvent ev){
			//store the click location in x and y
			x = ev.getX();
			y = ev.getY();
			repaint(); //request to be painted
		}
		public void mouseEntered(MouseEvent ev){
		
		}
		public void mouseExited(MouseEvent ev){
			
		}
		public void mousePressed(MouseEvent ev){
		
		}
		public void mouseReleased(MouseEvent ev){
		
		}
	
}
class MyGui {
	JButton click;
	JLabel label;
	int count;
	//inner class that handles button click
	class ClickHandler implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			if(ev.getSource() == click) {
				count = count +1; //increment the counter
				label.setText("Count = "+count);
			}
		}
	}
	//constructor
	MyGui() {
		//let's make gui and controls
		
		//create the top level window
		JFrame frame = new JFrame();
		//a container at the top
		JPanel north = new JPanel();
		//here is a button
		click = new JButton("Click me");
		//now add the buton to the panel
		north.add(click);
		//add panel to the frame
		frame.add(north, BorderLayout.NORTH);
		
		//register event handler to the button
		ClickHandler handler = new ClickHandler();
		click.addActionListener(handler);
		
		//add a label at the bottom
		//make a JLabel
		label = new JLabel("Count = 0");
		//make a panel to hold the label
		JPanel south = new JPanel();
		south.add(label);
		//add the panel with label to the frame
		frame.add(south, BorderLayout.SOUTH);
		
		//add canvas to draw a circle
		MyCanvas canvas = new MyCanvas();
		frame.add(canvas, BorderLayout.CENTER);
		
		//make the app terminate when window closes
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//set frame sixe to 400 pixels
		frame.setSize(400,400);
		//make our frame visible
		frame.setVisible(true);
	}
}

class MyGuiTester {
	public static void main(String[] args) {
		//make our GUI by calling the constructor
		 new MyGui();
	} 
}
