package Package1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;



public class EndPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static DefaultTableModel model;
	static JTable table;
	//protected Component list;
	static int total, row;
	static int orderNumber;
	static ArrayList<Integer> prices=new ArrayList<>();
	static JTextField totalText;
	
	
	
	public static void addRow(Object[] row) {
		
		model.addRow(row);
		prices.add((Integer)row[2]);
		totalPrice();
		
		
	}
	public static void totalPrice() {
		
		total = 0;
		for(int i=0; i < table.getRowCount(); i++) {
			
			int n1 = Integer.parseInt(model.getValueAt(i, 2).toString());
			
			total += n1;
		
		}
		
		totalText.setText("총 금액 :  "+total+" 원");
		
	}
	
	
	public EndPanel() {
		// TODO Auto-generated constructor stub
		setLayout(new BorderLayout());
		 
		String[] menu = new String[] {"선택하신 메뉴","수량","가격","","포장"};
		
		
		//테이블 만들기
		model = new DefaultTableModel(menu, 0);
		table = new JTable(model);		
		//셀을 중앙 정렬
		DefaultTableCellRenderer centerR = new DefaultTableCellRenderer();
		centerR.setHorizontalAlignment( JLabel.CENTER );
		
		for(int i =0; i < table.getColumnCount(); i++) {
		table.getColumnModel().getColumn(i).setCellRenderer( centerR );
		
		}		
		//줄높이 설정
		table.setRowHeight(25);
		//칸 넓이 설정
		table.getColumnModel().getColumn(0).setPreferredWidth(130);
		table.getColumnModel().getColumn(1).setPreferredWidth(30);
		table.getColumnModel().getColumn(3).setPreferredWidth(30);		
		//헤더 이동 금지, 길이 변경 금지
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);	
		
		//선 안보이게 하기
		table.setShowVerticalLines(false);
		table.setShowHorizontalLines(false);
		
		//스크롤 생성
		JScrollPane scroll = new JScrollPane(table);
		add(scroll, BorderLayout.CENTER);
		
		
		
		
		//수량 콤보박스
		JComboBox<Integer>combobox = new JComboBox<>();
		for (int i =1; i< 11; i++) {
			
			combobox.addItem(i);
			
		}
		//콤보박스 기본값
		combobox.setSelectedIndex(0);
		
		//콤보박스 액션
		combobox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub


				int row = table.getSelectedRow();
				if (row == -1) {
					
					return;
				}
							
				
				//jtable에서 가격 셀을 integer로 변환
				int n1 = Integer.parseInt(model.getValueAt(row, 1).toString());
				
				model.setValueAt(n1*prices.get(row), row, 2);
				
				totalPrice();
			
			}
		});
		
		
		
		TableColumn orderNum = table.getColumnModel().getColumn(1);
		orderNum.setCellEditor(new DefaultCellEditor(combobox));
		
		
		//취소버튼 만들기
		table.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer());
	    table.getColumnModel().getColumn(3).setCellEditor( new ButtonEditor(new JCheckBox())); 
	 
		//주문 패널
	    ImagePanel orderPanel = new ImagePanel(2);
		
		
		ImageIcon icon = new ImageIcon("src/Package1/images/logo1.png");
		JLabel imgLabel  = new JLabel();
		imgLabel.setIcon(icon);
		imgLabel.setHorizontalAlignment(JLabel.CENTER);
		
		orderPanel.add(imgLabel);
	
		//텍스트 필드
		
		totalText = new JTextField(12);
		totalText.setPreferredSize(new Dimension(20, 50));
		totalText.setFont(new Font("맑은 고딕", Font.BOLD,20));
		totalText.setHorizontalAlignment(JTextField.CENTER);
		totalText.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		totalText.setOpaque(false);
		totalText.setEditable(false);
		totalText.setForeground(Color.WHITE);
		orderPanel.add(totalText);
		
		
		
		
		
		
		
		
		
		
		JButton AllcancelBt = new JButton("전체 취소");
		orderPanel.add(AllcancelBt);
		
		AllcancelBt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
								model.setNumRows(0);
				totalPrice();
				
			}
		});		
		
		
		
		 JButton orderBt = new JButton("주문");
		 orderPanel.add(orderBt);
		orderBt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			
				if(!(model.getRowCount()==0))			orderNumber++;
					
				for (int i=0; i< model.getRowCount(); i++) {
					
					String row2 = table.getValueAt(i, 0)+" "+table.getValueAt(i, 1)+"개 "+"["+table.getValueAt(i, 4)+"]";
					
					
					ServerSender.sendOrder(row2);
					
					
				
				}
				model.setNumRows(0);
				
				
				
			}
		});
		 add(orderPanel, BorderLayout.SOUTH);
		 
		 
	}
	
	
	
	
	//BUTTON RENDERER CLASS
	class ButtonRenderer extends JButton implements TableCellRenderer {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		//CONSTRUCTOR
		  public ButtonRenderer() {
		    setOpaque(true);
		  }

		  @Override
		  public Component getTableCellRendererComponent(JTable table, Object value,
		      boolean isSelected, boolean hasFocus, int row, int column) {
		   
			  if (isSelected) {
			      setForeground(table.getSelectionForeground());
			      setBackground(table.getSelectionBackground());
			    } else{
			      setForeground(table.getForeground());
			      setBackground(UIManager.getColor("Button.background"));
			    }
			    setText( (value ==null) ? "" : value.toString() );
			    return this;
		  }
		}
		
	//BUTTON EDITOR CLASS
	class ButtonEditor extends DefaultCellEditor {
		  /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		protected JButton button;

		  private String label;

		  private boolean isPushed;

		  	int num;	  		  
		  public ButtonEditor(JCheckBox checkBox) {
		    super(checkBox);
		    button = new JButton();
		    button.setOpaque(true);
		    
		    //버튼이 눌려졌을때
		    button.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		       
		    	 
		    	  fireEditingStopped();
		    	 
		    	  
		      }
		    });
		  }

		//OVERRIDE A COUPLE OF METHODS
		  @Override
		  public Component getTableCellEditorComponent(JTable table, Object value,
		      boolean isSelected, int row, int column) {
		  
			 //SET TEXT TO BUTTON,SET CLICKED TO TRUE,THEN RETURN THE BTN OBJECT
			  if (isSelected) {
			      button.setForeground(table.getSelectionForeground());
			      button.setBackground(table.getSelectionBackground());
			    } else{
			      button.setForeground(table.getForeground());
			      button.setBackground(table.getBackground());
			    }  		    
		    label = (value == null) ? "" : value.toString();
		    button.setText(label);
		    isPushed = true;
		    num = row;
		    
		    return button;
		  }

		   //IF BUTTON CELL VALUE CHNAGES,IF CLICKED THAT IS
		   @Override
		  public Object getCellEditorValue() {
		    if (isPushed) {
		     
		    	Runnable doRemoveRow = new Runnable() {
		    		public void run() {
		    			
		    				model.removeRow( num );
		    				totalPrice();
		    		}
		    	};
		    	SwingUtilities.invokeLater(doRemoveRow);
		    			    			    	
				prices.remove(num);
			
		     
		    }
		    //SET IT TO FALSE NOW THAT ITS CLICKED
		    isPushed = false;
		    return new String(label);
		  }

		   @Override
		  public boolean stopCellEditing() {
			//SET CLICKED TO FALSE FIRST
		    isPushed = false;		    
		    return super.stopCellEditing();
		  }

		   @Override
		  protected void fireEditingStopped() {			 
		    super.fireEditingStopped();
		  }
		}

	
	
}
