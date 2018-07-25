package Package1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;




public class ServerSender extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField txttop, txtmiddle, txtbottom;
	ServerThread serverthread;

	
	static DataInputStream dis;
	static DataOutputStream dos;
	
	public ServerSender() {
	
	
		ImagePanel mainPanel = new ImagePanel(9);

		mainPanel.setLayout(new GridLayout(0,1));
		add(mainPanel);
		
		txttop = new JTextField();
		txttop.setEditable(false);
		txttop.setOpaque(false);
		txttop.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txttop.setFont(new Font("��������üM", Font.BOLD,20));
		mainPanel.add(txttop);
		
		txtmiddle = new JTextField(20);
		txtmiddle.setEditable(false);
		txtmiddle.setOpaque(false);
		txtmiddle.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtmiddle.setFont(new Font("�޸տ�����", Font.BOLD,50));
		txtmiddle.setHorizontalAlignment(JTextField.CENTER);
		mainPanel.add(txtmiddle);
		
		
		
		
		txtbottom = new JTextField(20);
		txtbottom.setEditable(false);
		txtbottom.setOpaque(false);
		txtbottom.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtbottom.setFont(new Font("��������üM", Font.BOLD,20));
		txtbottom.setForeground(Color.WHITE);
		txtbottom.setHorizontalAlignment(JTextField.RIGHT);
		mainPanel.add(txtbottom);
		
		
		
		
		setTitle("���� ��ȣ â");
		setBounds(750,650,300,250);
		setVisible(true);
		
		
		serverthread = new ServerThread();
		serverthread.setDaemon(true);
		serverthread.start();
	
		
	
	}
	
	public static void sendOrder(String row2) {
		
			new Thread() {   
			
			public void run() {
				
				if(dos==null) return;
			try {
								
				dos.writeUTF(row2);
								
				dos.flush();
			
				
			} catch (Exception e) {	}
	
			}
				
		}.start();
		
		
	}
	
	class ServerThread extends Thread{
		
		@Override
		public void run() {


			try {
				@SuppressWarnings("resource")
				ServerSocket serverSocket = new ServerSocket(10002);
				txttop.setText("���� ���");					
				Socket socket = serverSocket.accept();							
				txttop.setText("���� �غ� ��...");				
								
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();				
				dis = new DataInputStream(is);
				dos = new DataOutputStream(os);				
			
				while(true) {
					String msg = dis.readUTF(); //Ŭ���̾�Ʈ�� �޼����� ������ �б�
					txttop.setText("�ֹ���ȣ : \n");
					txtmiddle.setText(" "+msg+"��\n");
					txtbottom.setText("������ ���Խ��ϴ�.\n");			
				}				
				
			} catch (IOException e) {
			
				txtmiddle.setText("���� ����");
				txtmiddle.setForeground(Color.RED);
				txttop.setText("");
				txtbottom.setText("");
				
				e.printStackTrace();
			}
			
			
			
			
			
			
			
			
		}
		
		
		
		
		
	}
	
	
	
	
	
}
