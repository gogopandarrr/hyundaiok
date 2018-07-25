package Package1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class KitchenPanel extends JFrame {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
ImagePanel Top, Middle, Bottom;
Buttons backbt, cancelbt, donebt;


Socket socket;




static DataInputStream dis;
static DataOutputStream dos;
static JTextField times;
static DefaultTableModel model2;
static JTable table2;

static JTextField txtarea;


public KitchenPanel() {
	// TODO Auto-generated constructor stub
	


	
	
	
	// 탑패널
	
	Top = new ImagePanel(2);
	Top.setLayout(new BorderLayout());
	add(Top, BorderLayout.NORTH);

	
//	backbt = new Buttons(4);
//	Top.add(backbt, BorderLayout.WEST);
//	
	
	
	
	///알람 테스트필드
	txtarea = new JTextField(20);
	txtarea.setOpaque(false);
	txtarea.setBorder(javax.swing.BorderFactory.createEmptyBorder());
	txtarea.setHorizontalAlignment(JTextField.CENTER);
	txtarea.setForeground(Color.WHITE);
	txtarea.setFont(new Font("굴림", Font.TRUETYPE_FONT,12));
	Top.add(txtarea,BorderLayout.NORTH);
	
	
	//로고 부착
	ImageIcon icon = new ImageIcon("src/Package1/images/logo1.png");
	JLabel imgLabel  = new JLabel();
	imgLabel.setIcon(icon);
	imgLabel.setHorizontalAlignment(JLabel.CENTER);
	Top.add(imgLabel, BorderLayout.EAST);
	
	
	//시간 부착
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
	long ct = System.currentTimeMillis();
	//시간
	times = new JTextField();
	
	times.setOpaque(false);
	times.setBorder(javax.swing.BorderFactory.createEmptyBorder());
	times.setHorizontalAlignment(JTextField.LEFT);
	times.setForeground(Color.WHITE);
	times.setFont(new Font("돋음", Font.TRUETYPE_FONT,12));	
	Top.add(times, BorderLayout.SOUTH);
	
	Realtime timethread = new Realtime();
	timethread.start();
	
	
	// 중간패널
	
	Middle = new ImagePanel(2);
	add(Middle, BorderLayout.CENTER);
	

	
	String[] menu = {"주문번호","주문내역"};
	
	model2 = new DefaultTableModel(menu, 0);
	JTable table2 = new JTable(model2);
	DefaultTableCellRenderer centerCell = new DefaultTableCellRenderer();
	centerCell.setHorizontalAlignment(JLabel.CENTER);
	
	
	
	for(int i=0; i< table2.getColumnCount(); i++) {
		
		table2.getColumnModel().getColumn(i).setCellRenderer(centerCell);
		
	}
	table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	table2.setRowHeight(25);
	table2.getColumnModel().getColumn(0).setPreferredWidth(60);
	table2.getColumnModel().getColumn(1).setPreferredWidth(280);

	
	table2.getTableHeader().setReorderingAllowed(false);
	table2.getTableHeader().setResizingAllowed(false);
	
	table2.setShowVerticalLines(false);
	table2.setShowHorizontalLines(false);
	

	JScrollPane sp = new JScrollPane(table2);	
	sp.setPreferredSize(new Dimension(370, 300));
	Middle.add(sp);




	
//아래 패널
Bottom = new ImagePanel(5);
add(Bottom, BorderLayout.SOUTH);

cancelbt = new Buttons(2);
Bottom.add(cancelbt);
cancelbt.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		int delrow = table2.getSelectedRow();
		
		
		// 다중 드래그 삭제
		 while (delrow != -1)
         {
             int modelRow = table2.convertRowIndexToModel( delrow );
             model2.removeRow( modelRow );
             delrow = table2.getSelectedRow();
         }
		
		
    				

    	
		
	}
});



donebt = new Buttons(3);
Bottom.add(donebt);
donebt.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		ArrayList<Integer>sameNum = new ArrayList<>();
		
		//주문번호 같은 값가진 줄들 번호 추출해서 리스트에 추가.
	for(int i=0; i < table2.getRowCount(); i++) {
		
		int delrow = table2.getSelectedRow();
	
		
		
		if(delrow==-1)return;	
		else if (table2.getValueAt(i,0).equals(table2.getValueAt(delrow,0))) {

		sameNum.add(i);
		
		sendDoneNumber(table2.getValueAt(delrow,0).toString());
			
	}//if
	
	
	}//.for

	//리스트에 저장된 줄번호를 역순으로 삭제 (그래야 에러안남)
for(int t = sameNum.size()-1; t >=0; t--) {
		

		model2.removeRow(sameNum.get(t));
		
		
	}//for2
	
	






	}
});




setTitle("주방 주문 목록창");
setBounds(750, 100, 400, 550);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);


ReciverThread thread = new ReciverThread();
thread.setDaemon(true);
thread.start();

}



//TCP 클라이언트 스레드
class ReciverThread extends Thread{
	
	@Override
	public void run() {


		try {
			socket =new Socket("127.0.0.1",10002);									
			txtarea.setText("서버에 접속했습니다.\n");
			txtarea.setCaretPosition(txtarea.getText().length());					
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());			
							
			while(true) {			
				String order = dis.readUTF();				 
				Object[] obj = {EndPanel.orderNumber, order};
				model2.addRow(obj);				
			}			
		} catch (IOException e) {	
			txtarea.setText("연결이 실패하였습니다.");
			txtarea.setCaretPosition(txtarea.getText().length());

			e.printStackTrace();
		}
		
	
		
	}
	
}//thread

public static void sendDoneNumber(String doneNumber) {
	
	new Thread() {   
	
	public void run() {
		
		if(dos==null) return;
	try {
						
		dos.writeUTF(doneNumber);
						
		dos.flush();
		
		

		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		
	}
	}
	
	
}.start();


}


//실시간 시간 스레드
class Realtime extends Thread{

public void run(){
      while(true){
           Calendar cal = Calendar.getInstance();
           String now = cal.get(Calendar.YEAR)+"년"+
                   (cal.get(Calendar.MONTH)+1)+"월"+
                   cal.get(Calendar.DATE)+"일"+
                   cal.get(Calendar.HOUR)+"시"+
                  cal.get(Calendar.MINUTE)+"분"+
                  cal.get(Calendar.SECOND)+"초";
           
           times.setText(now);
          
           try{
               Thread.sleep(1000);
           }catch(InterruptedException e){
               e.printStackTrace();
           }
       }
}

}//real


}//class

