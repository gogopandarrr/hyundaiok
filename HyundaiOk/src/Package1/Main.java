package Package1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;

public class Main extends JFrame{
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel imgLabel;
	ImageIcon icon;
	BevelBorder border;
	ImagePanel panel;
	public Main() {
		// TODO Auto-generated constructor stub
	
		
		new ServerSender(); 
		
		
		ImagePanel panel = new ImagePanel(0);

	
		
	getContentPane().add(panel, BorderLayout.CENTER);
		
	
	
	//banner.setLayout(new BorderLayout());
	
	getContentPane().setBackground(Color.WHITE);
	//banner.setBackground(new Color(193, 148, 102));
	
	
	
	JScrollPane scroll = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	
	
	//ÅÇ ÆÐ³Î »ý¼º
	JTabbedPane tabs = new JTabbedPane(); 
		
	panel.add(tabs);
	
	add(scroll, BorderLayout.CENTER);
	

	
	Foods tab1 = new Foods();
	Food2 tab2 = new Food2();

	
	try {
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
			| UnsupportedLookAndFeelException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	tabs.addTab("½Ä»ç·ù", tab1);
	tabs.addTab("°çµéÀÌ·ù", tab2);
	
	tabs.setFocusable(false);
	
	JLabel la1 = new JLabel();
	icon = new ImageIcon("src/Package1/images/tab4.png");
	//icon  = new ImageIcon(icon.getImage().getScaledInstance(80, 60, Image.SCALE_SMOOTH));
	la1.setIcon(icon);
	tabs.setTabComponentAt(0, la1);
	
	JLabel la2 = new JLabel();
	icon = new ImageIcon("src/Package1/images/tab5.png");
	//icon  = new ImageIcon(icon.getImage().getScaledInstance(80, 60, Image.SCALE_SMOOTH));
	
	la2.setIcon(icon);
	tabs.setTabComponentAt(1, la2);
	
		
		
		
	
	
	EndPanel endpanel = new EndPanel();
	endpanel.setPreferredSize(new Dimension(600, 230));
	add(endpanel, BorderLayout.SOUTH);
	
	
	
	
	
	setTitle("Çö´ë¿Á ¼¿ÇÁ ÁÖ¹®´ë");
	setBounds(150, 100, 600, 800);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	
	
	
	new KitchenPanel();
	
//	Runnable doNext = new Runnable() {
//		public void run() {
//			
//				new CheckFoodPanel();
//		}
//	};
//	SwingUtilities.invokeLater(doNext);
//	
	}
	
	



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		new Main();
	}

	
	
	
}
