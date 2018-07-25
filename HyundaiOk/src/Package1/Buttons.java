package Package1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Buttons extends JButton{

	//추가 버튼
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton addb;
	
	public Buttons(int i) {
	
		if(i==1) {
		setPreferredSize(new Dimension(80, 35));
		ImageIcon icon = new ImageIcon("src/Package1/images/button1.png");
		icon  = new ImageIcon(icon.getImage().getScaledInstance(80, 35, Image.SCALE_SMOOTH));
		setIcon(icon);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
		
		
		ImageIcon icon2 = new ImageIcon("src/Package1/images/button2.png");
		icon2  = new ImageIcon(icon2.getImage().getScaledInstance(80, 35, Image.SCALE_SMOOTH));
		setRolloverIcon(icon2);
		
		}
		
		
		if (i==2) {
			
			//setPreferredSize(new Dimension(80, 35));
			ImageIcon icon = new ImageIcon("src/Package1/images/button51.png");
			//icon  = new ImageIcon(icon.getImage().getScaledInstance(80, 35, Image.SCALE_SMOOTH));
			setIcon(icon);
			setBorderPainted(false);
			setContentAreaFilled(false);
			setFocusPainted(false);
			
			
			ImageIcon icon2 = new ImageIcon("src/Package1/images/button52.png");
			//icon2  = new ImageIcon(icon2.getImage().getScaledInstance(80, 35, Image.SCALE_SMOOTH));
			setRolloverIcon(icon2);
			
			
		
	}
		if (i==3) {
			
			//setPreferredSize(new Dimension(80, 35));
			ImageIcon icon = new ImageIcon("src/Package1/images/button61.png");
			//icon  = new ImageIcon(icon.getImage().getScaledInstance(80, 35, Image.SCALE_SMOOTH));
			setIcon(icon);
			setBorderPainted(false);
			setContentAreaFilled(false);
			setFocusPainted(false);
			
			
			ImageIcon icon2 = new ImageIcon("src/Package1/images/button62.png");
			//icon2  = new ImageIcon(icon2.getImage().getScaledInstance(80, 35, Image.SCALE_SMOOTH));
			setRolloverIcon(icon2);
			
		
		
		
		
	}
	if (i==4) {
			
			//setPreferredSize(new Dimension(80, 35));
			ImageIcon icon = new ImageIcon("src/Package1/images/button41.png");
			
			icon = new ImageIcon(icon.getImage().getScaledInstance(60, 50, Image.SCALE_SMOOTH));
			setIcon(icon);
			setBorderPainted(false);
			setContentAreaFilled(false);
			setFocusPainted(false);
			
			
			ImageIcon icon2 = new ImageIcon("src/Package1/images/button42.png");
			icon2  = new ImageIcon(icon2.getImage().getScaledInstance(60, 50, Image.SCALE_SMOOTH));
			setRolloverIcon(icon2);
			
		
		
	}
	
	if(i==5) {
		setPreferredSize(new Dimension(80, 35));
		ImageIcon icon = new ImageIcon("src/Package1/images/button31.png");
		icon  = new ImageIcon(icon.getImage().getScaledInstance(80, 35, Image.SCALE_SMOOTH));
		setIcon(icon);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
		
		
		ImageIcon icon2 = new ImageIcon("src/Package1/images/button32.png");
		icon2  = new ImageIcon(icon2.getImage().getScaledInstance(80, 35, Image.SCALE_SMOOTH));
		setRolloverIcon(icon2);
		
		}
	
}//CON

}