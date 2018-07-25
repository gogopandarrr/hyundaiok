package Package1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;



public class Foods extends JPanel {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	EtchedBorder eborder;
	BevelBorder border;
	JPanel basic, food1 , inner1, inner2;
	JLabel imgLabel;
	JTextArea txtArea;
	JTextArea[] name= new JTextArea [10];
	JTextArea[] price= new JTextArea [10];
	JTextField txtprice;
	JButton[] addbt = new JButton[10];
	JButton[] packbt = new JButton[10];
	ActListener listener;
	//static List<Object> list = new ArrayList<Object>();

	
	public Foods() {
		// TODO Auto-generated constructor stub
		
		
		
		listener = new ActListener();
		basic = new JPanel();
		basic.setLayout(new GridLayout(0, 1));
		
			
		
		food1 = new JPanel();
		food1.setBackground(Color.WHITE);
		eborder=new EtchedBorder(EtchedBorder.RAISED);
		food1.setBorder(eborder);
		
		//이미지 추가
		ImageIcon icon = new ImageIcon("src/Package1/images/menu1.jpg");
		icon  = new ImageIcon(icon.getImage().getScaledInstance(150, 120, Image.SCALE_SMOOTH));
		imgLabel  = new JLabel();
		imgLabel.setIcon(icon);
		food1.add(imgLabel);
		inner1 = new JPanel();
		inner1.setLayout(new BorderLayout());
		
		//설명 추가
		name[0] = new JTextArea(
				"【전주남부시장식콩나물국밥】",1,20);
		name[0].setFont(new Font("양재인장체M", Font.BOLD,16));
		inner1.add(name[0], BorderLayout.NORTH);
		
		
		txtArea = new JTextArea(
				
				"    -끓이지 않고 부어 내는 방식\r\n" + 
				"    -계란은 수란으로 제공\r\n" + 
				"    -시원하고 개운한 맛"
				,5,20	
				
				);
		txtArea.setEditable(false);
		name[0].setEditable(false);
		inner1.add(txtArea, BorderLayout.CENTER);
		
	
		
		
		inner2 = new JPanel();
		inner2.setLayout(new BorderLayout());
		
		price[0] =new JTextArea(
		"6000" 								
				);
		price[0].setFont(new Font("Goudy Old Style", Font.TRUETYPE_FONT,30));	
		price[0].setEditable(false);
		inner2.add(price[0], BorderLayout.NORTH);
		
		
		addbt[0] = new Buttons(1);
		addbt[0].addActionListener(listener);
		inner2.add(addbt[0], BorderLayout.CENTER);
		
		
		packbt[0] = new Buttons(5);
		packbt[0].addActionListener(listener);
		inner2.add(packbt[0], BorderLayout.SOUTH);
		
		
		
		
		
		
		
		
		
		food1.add(inner1);
		food1.add(inner2);
		basic.add(food1);
		
		
		
		
		
		
		
food1 = new JPanel();
food1.setBackground(Color.WHITE);	
eborder=new EtchedBorder(EtchedBorder.RAISED);
food1.setBorder(eborder);




		//이미지 추가
		icon = new ImageIcon("src/Package1/images/menu2.jpg");
		icon  = new ImageIcon(icon.getImage().getScaledInstance(150, 120, Image.SCALE_SMOOTH));
		imgLabel  = new JLabel();
		imgLabel.setIcon(icon);
		food1.add(imgLabel);
		inner1 = new JPanel();
		inner1.setLayout(new BorderLayout());
		
		//설명 추가
		name[1] = new JTextArea(
				"【끓이는식콩나물국밥】",1,20);
		name[1].setFont(new Font("", Font.BOLD,16));
		inner1.add(name[1], BorderLayout.NORTH);
		
		
		txtArea = new JTextArea(
				
				"    -뚝배기를 펄펄 끓이는 방식\r\n" + 
				"    -식어 가면서 구수하고 걸쭉한 맛\r\n" + 
				"    -계란은 뚝배기속에 넣어서 제공"
					,5,20	
				
				);
		txtArea.setEditable(false);
		name[1].setEditable(false);
		inner1.add(txtArea, BorderLayout.CENTER);
		
	
		
		
		inner2 = new JPanel();
		inner2.setLayout(new BorderLayout());
		
		price[1] =new JTextArea(
		"6000" 				
				
				);
		price[1].setFont(new Font("Goudy Old Style", Font.TRUETYPE_FONT,30));	
		price[1].setEditable(false);
		
		inner2.add(price[1], BorderLayout.NORTH);
		
		addbt[1] =  new Buttons(1);
		addbt[1].addActionListener(listener);
		inner2.add(addbt[1], BorderLayout.CENTER);
		
		packbt[1] = new Buttons(5);
		packbt[1].addActionListener(listener);
		inner2.add(packbt[1], BorderLayout.SOUTH);
		
		
		
		food1.add(inner1);
		food1.add(inner2);
		basic.add(food1);
		
		
		
		
		
		/////////////////////////
		
food1 = new JPanel();
food1.setBackground(Color.WHITE);
eborder=new EtchedBorder(EtchedBorder.RAISED);
food1.setBorder(eborder);




		//이미지 추가
		icon = new ImageIcon("src/Package1/images/menu3.jpg");
		icon  = new ImageIcon(icon.getImage().getScaledInstance(150, 120, Image.SCALE_SMOOTH));
		imgLabel  = new JLabel();
		imgLabel.setIcon(icon);
		food1.add(imgLabel);
		inner1 = new JPanel();
		inner1.setLayout(new BorderLayout());
		
		//설명 추가
		name[2] = new JTextArea(
				"【얼큰돼지국밥】",1,20);
		
		name[2].setFont(new Font("양재인장체M", Font.BOLD,16));

		inner1.add(name[2], BorderLayout.NORTH);
		
		
		txtArea = new JTextArea(
				
				"    -얼큰하고 든든한 고기국밥     \r\n"
				
				
			,5,20	);
		txtArea.setEditable(false);
		name[2].setEditable(false);
		inner1.add(txtArea, BorderLayout.CENTER);
		
	
		
		
		inner2 = new JPanel();
		inner2.setLayout(new BorderLayout());
		
		price[2] =new JTextArea(
		"8000" 				
				
				);
		price[2].setFont(new Font("Goudy Old Style", Font.TRUETYPE_FONT,30));	
		inner2.add(price[2], BorderLayout.NORTH);
		
		addbt[2] =  new Buttons(1);
		addbt[2].addActionListener(listener);
		inner2.add(addbt[2], BorderLayout.CENTER);
		
		packbt[2] = new Buttons(5);
		packbt[2].addActionListener(listener);
		inner2.add(packbt[2], BorderLayout.SOUTH);
		
		food1.add(inner1);
		food1.add(inner2);
		basic.add(food1);
		
	
		
		////////////////////
				
food1 = new JPanel();
food1.setBackground(Color.WHITE);		
eborder=new EtchedBorder(EtchedBorder.RAISED);
food1.setBorder(eborder);

		//이미지 추가
		icon = new ImageIcon("src/Package1/images/menu4.jpg");
		icon  = new ImageIcon(icon.getImage().getScaledInstance(150, 120, Image.SCALE_SMOOTH));
		imgLabel  = new JLabel();
		imgLabel.setIcon(icon);
		food1.add(imgLabel);
		inner1 = new JPanel();
		inner1.setLayout(new BorderLayout());
		
		//설명 추가
		name[3] = new JTextArea(
				"【황태콩나물국밥】",1,20);
		
		name[3].setFont(new Font("양재인장체M", Font.BOLD,16));

		inner1.add(name[3], BorderLayout.NORTH);
		
		
		txtArea = new JTextArea(
				
				"    -황태와 바지락을 넣어 팔팔 끊인 국밥     \r\n"
				
				
			,5,20	);
		txtArea.setEditable(false);
		name[3].setEditable(false);
		inner1.add(txtArea, BorderLayout.CENTER);
		
	
		
		
		inner2 = new JPanel();
		inner2.setLayout(new BorderLayout());
		
		price[3] =new JTextArea(
		"7000" 				
				
				);
		price[3].setFont(new Font("Goudy Old Style", Font.TRUETYPE_FONT,30));	
		inner2.add(price[3], BorderLayout.NORTH);
		
		addbt[3] =  new Buttons(1);
		addbt[3].addActionListener(listener);
		inner2.add(addbt[3], BorderLayout.CENTER);
		
		packbt[3] = new Buttons(5);
		packbt[3].addActionListener(listener);
		inner2.add(packbt[3], BorderLayout.SOUTH);
		
		food1.add(inner1);
		food1.add(inner2);
		basic.add(food1);
		
		
		////////////////////////현대옥 스테이크
		
food1 = new JPanel();
food1.setBackground(Color.WHITE);	
eborder=new EtchedBorder(EtchedBorder.RAISED);
food1.setBorder(eborder);
		//이미지 추가
		icon = new ImageIcon("src/Package1/images/menu5.jpg");
		icon  = new ImageIcon(icon.getImage().getScaledInstance(150, 120, Image.SCALE_SMOOTH));
		imgLabel  = new JLabel();
		imgLabel.setIcon(icon);
		food1.add(imgLabel);
		inner1 = new JPanel();
		inner1.setLayout(new BorderLayout());
		
		//설명 추가
		name[4] = new JTextArea(
				"【현대옥스테이크】",1,20);
		
		name[4].setFont(new Font("양재인장체M", Font.BOLD,16));

		inner1.add(name[4], BorderLayout.NORTH);
		
		
		txtArea = new JTextArea(
				
				
				"    -한우고기와 국내산 돼지고기 사용     \r\n"
				
				
			,5,20	);
		txtArea.setEditable(false);
		name[4].setEditable(false);
		inner1.add(txtArea, BorderLayout.CENTER);
		
	
		
		
		inner2 = new JPanel();
		inner2.setLayout(new BorderLayout());
		
		price[4] =new JTextArea(
		"7000" 				
				
				);
		inner2.add(price[4], BorderLayout.NORTH);
		price[4].setFont(new Font("Goudy Old Style", Font.TRUETYPE_FONT,30));	
		addbt[4] =  new Buttons(1);
		addbt[4].addActionListener(listener);
		inner2.add(addbt[4], BorderLayout.CENTER);
		
		packbt[4] = new Buttons(5);
		packbt[4].addActionListener(listener);
		inner2.add(packbt[4], BorderLayout.SOUTH);
		
		
		food1.add(inner1);
		food1.add(inner2);
		basic.add(food1);
		
		
		
		
		
		
		
		
		
	
		add(basic);
	}
	
		public class ActListener implements ActionListener{
		
		int menuN;
		
		public void actionPerformed(ActionEvent e) {
					
			String packing = new String();
			
			for (int i=0; i< 10; i++) {
				
				if(addbt[i] == e.getSource()) {menuN = i; packing ="매장";}
				else if (packbt[i] == e.getSource()) {menuN = i; packing = "포장";}
				
			}
			
			String foodName = name[menuN].getText();
			String foodPrice = price[menuN].getText();
					
			int p = Integer.parseInt(foodPrice);
			int n =1;
	
			Object[] row = {foodName, n, p, "취소",packing};

			
			EndPanel.addRow(row);
			
			
		}
		
		
		
	}
		
		

	
}
