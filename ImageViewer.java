import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import javax.imageio.*;

class ImageViewer {
	JButton open;
	JButton close;
	Image image;
	MyCanvas canvas;
	JTextField greeting;
	JButton apply;
	String greet= "";
	
	//Event handler for two buttons we have
	class ClickHandler implements ActionListener{
		public void actionPerformed(ActionEvent ev) {
			if (ev.getSource()==open){
				//open a file chooser dialog
				//then open an image to display
				JFileChooser chooser = new JFileChooser();
				int returnVal = chooser.showOpenDialog(null);
					if(returnVal == JFileChooser.APPROVE_OPTION) {
					File file = chooser.getSelectedFile();
					try{
						image = ImageIO.read(file);
						if(image == null){
							JOptionPane.showMessageDialog(null, "Failed to open " + file.getName());
						}
					} catch(IOException ex) {
						JOptionPane.showMessageDialog(null, "Failed to open " + file.getName());
				}
			}	
			canvas.repaint();
			}else if(ev.getSource()==close){
				image = null;
				canvas.repaint();
			}else if(ev.getSource()==apply){
				//get the string from TextField and assign it 
				//to greeting string
				greet = greeting.getText();
				canvas.repaint();
			}
		}
	}
	//we need to create our custom JComponent so that
	//we can override paintComponent to display the image
	class MyCanvas extends JComponent {
		protected void paintComponent(Graphics g){
			
			if(image != null) {
				g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
				//draw the greeting string here
				g.setFont(new Font("TimesRoman", Font.PLAIN, 32));
				g.setColor(Color.YELLOW);
				g.drawString(greet, 50, 50);
			}
		}
	}
	
	//constructor - make GUI here.
	ImageViewer(){
		JFrame frame = new JFrame();
		JPanel north = new JPanel(); //host two buttons
		open = new JButton("Open");
		close = new JButton("Close");
		north.add(open);
		north.add(close);
		
		//register event handler to the buttons
		ClickHandler handler = new ClickHandler();
		open.addActionListener(handler);
		close.addActionListener(handler);
		
		//make our viewr canvas
		canvas = new MyCanvas();
		frame.add(canvas, BorderLayout.CENTER);
		
		//populate the bottom panel
		JPanel south = new JPanel();
		greeting = new JTextField(20);
		apply = new JButton("Apply");
		south.add(greeting);
		south.add(apply);
		frame.add(south, BorderLayout.SOUTH);
		apply.addActionListener(handler);
		
		frame.add(north, BorderLayout.NORTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,400);
		frame.setVisible(true);
	}
}

class ImageViewerTester{
	public static void main(String[] args){
		new ImageViewer();
		
	}
}