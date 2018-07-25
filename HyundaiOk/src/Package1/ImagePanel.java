package Package1;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class ImagePanel extends JPanel {

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Image imgbg;

	  int width, height, i;
	  
	 public ImagePanel(int i) {
		// TODO Auto-generated constructor stub
		 Toolkit toolkit = Toolkit.getDefaultToolkit();
	 
		 
		 
		 imgbg=toolkit.getImage("src/Package1/images/bgbg"+i+".jpg");
		 
		 
	 
	 }

	  public void paintComponent(Graphics g) {
	   
		  if(width==0||height==0) {
				
				width = getWidth();
				height = getHeight();
			
				imgbg=imgbg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	  }
		  
		  g.drawImage(imgbg, 0, 0, this);

	}
}