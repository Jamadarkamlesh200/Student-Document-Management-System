package DOCSYSTEM;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import net.proteanit.sql.DbUtils;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class docview extends JInternalFrame {
	private JTextField senroll;
	private JTextField idtxt;
	private JTable table;
	
	
	 private JPanel panel_1;
	 private JTextField nametxt;
     String sid1,sid2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					docview frame = new docview();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public docview() {
		getContentPane().setBackground(SystemColor.control);
		setBounds(100, 100, 1001, 759);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		panel.setBounds(0, 0, 985, 262);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblStudentEnrollNo = new JLabel("Student Enroll No");
		lblStudentEnrollNo.setForeground(new Color(0, 128, 128));
		lblStudentEnrollNo.setBounds(29, 68, 170, 34);
		panel.add(lblStudentEnrollNo);
		lblStudentEnrollNo.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		JLabel lblNewLabel = new JLabel("Document View/Search");
		lblNewLabel.setForeground(new Color(0, 128, 128));
		lblNewLabel.setBounds(12, 13, 961, 40);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 34));
		
		senroll = new JTextField();
		senroll.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				searchdata(senroll.getText());
			}
		});
		senroll.setBackground(new Color(204, 255, 255));
		senroll.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		senroll.setBounds(211, 68, 237, 34);
		panel.add(senroll);
		senroll.setColumns(10);
		
		
		JLabel lblBranch = new JLabel("Branch");
		lblBranch.setForeground(new Color(0, 128, 128));
		lblBranch.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblBranch.setBounds(29, 115, 170, 34);
		panel.add(lblBranch);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setForeground(new Color(0, 128, 128));
		lblCategory.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblCategory.setBounds(29, 162, 170, 34);
		panel.add(lblCategory);
		
		JComboBox bcbox = new JComboBox();
		bcbox.setForeground(new Color(0, 128, 128));
		bcbox.setModel(new DefaultComboBoxModel(new String[] {"Select", "CM", "EE", "E&TC", "ME"}));
		bcbox.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		bcbox.setBounds(211, 115, 237, 34);
		panel.add(bcbox);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select", "OPEN", "OBC", "NT"}));
		comboBox.setForeground(new Color(0, 128, 128));
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		comboBox.setBounds(211, 162, 237, 34);
		panel.add(comboBox);
		
		JButton enrollsearchbtn = new JButton("Search");
		enrollsearchbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getdata();
			}
		});
		enrollsearchbtn.setForeground(new Color(0, 128, 128));
		enrollsearchbtn.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		enrollsearchbtn.setBounds(460, 65, 135, 40);
		panel.add(enrollsearchbtn);
		
		JButton bsearchbtn = new JButton("Search");
		bsearchbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			String branch= bcbox.getSelectedItem().toString();
				   dcon driverobj=new dcon();
				   Connection conn = null;
				   Statement stmt =null;
				   ResultSet rs;
				    try {

			            Class.forName(driverobj.DRIVER_NAME).newInstance();
			        } catch (Exception ex) {
			            
			        }
				   try {
					    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/doc?useTimezone=true&serverTimezone=UTC", driverobj.USER_NAME, driverobj.PASSWORD);
					    stmt = conn.createStatement();
					    rs=stmt.executeQuery("select students.NAME,docverify.ENROLL,students.BRANCH,students.CATEGORY,docverify.8thMS,docverify.9thMS,docverify.10thMS,docverify.12thMS,docverify.LC,docverify.CASTE,docverify.INCOME,docverify.NCLC,docverify.PHOTOS,docverify.DOMICILE,docverify.NATIONALITY,docverify.PHC,docverify.PROFORMA,docverify.EIDC,docverify.3COPIES,docverify.AADHAR,docverify.VALIDITY,docverify.BANKCOPY,docverify.GAP,docverify.RATION FROM docverify,students WHERE students.ENROLL=docverify.ENROLL AND students.BRANCH='"+branch+"'");
					    table.setModel(DbUtils.resultSetToTableModel(rs));
					    demo();
						 stmt.close();
					     conn.close();
					     				      
					      }
					 catch (SQLException ex) {
						 System.out.print(ex);
					    
					}
				
			}
		});
		bsearchbtn.setForeground(new Color(0, 128, 128));
		bsearchbtn.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		bsearchbtn.setBounds(460, 112, 135, 40);
		panel.add(bsearchbtn);
		
		JButton csearchbtn = new JButton("Search");
		csearchbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String combo= comboBox.getSelectedItem().toString();
				   dcon driverobj=new dcon();
				   Connection conn = null;
				   Statement stmt =null;
				   ResultSet rs;
				    try {

			            Class.forName(driverobj.DRIVER_NAME).newInstance();
			        } catch (Exception ex) {
			            
			        }
				   try {
					    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/doc?useTimezone=true&serverTimezone=UTC", driverobj.USER_NAME, driverobj.PASSWORD);
					    stmt = conn.createStatement();
					    // String q1="update docverify set 8thMS='"+ms8th+"',9thMS='"+ms9th+"',10thMS='"+ms10th+"',12thMS='"+ms12th+"',LC='"+lc+"',CASTE='"+caste+"',INCOME='"+income+"',NCLC='"+noncreamy+"',PHOTOS='"+passport+"',DOMICILE='"+domicile+"',NATIONALITY='"+nationality+"',PHC='"+phc+"',PROFORMA='"+proforma+"',EIDC='"+eidc+"',3COPIES='"+copy+"',AADHAR='"+aadhar+"',VALIDITY='"+validity+"',BANKCOPY='"+bankpass+"',GAP='"+gap+"',RATION='"+ration+"' where ENROLL="+eenroll.getText();
					    rs=stmt.executeQuery("select students.NAME,docverify.ENROLL,students.BRANCH,students.CATEGORY,docverify.8thMS,docverify.9thMS,docverify.10thMS,docverify.12thMS,docverify.LC,docverify.CASTE,docverify.INCOME,docverify.NCLC,docverify.PHOTOS,docverify.DOMICILE,docverify.NATIONALITY,docverify.PHC,docverify.PROFORMA,docverify.EIDC,docverify.3COPIES,docverify.AADHAR,docverify.VALIDITY,docverify.BANKCOPY,docverify.GAP,docverify.RATION FROM students,docverify WHERE students.ENROLL=docverify.ENROLL AND students.CATEGORY='"+combo+"'");
					    table.setModel(DbUtils.resultSetToTableModel(rs));
					    demo();
						 stmt.close();
					     conn.close();
					     				      
					      }
					 catch (SQLException ex) {
						 System.out.print(ex);
					    
					}
			}
		});
		csearchbtn.setForeground(new Color(0, 128, 128));
		csearchbtn.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		csearchbtn.setBounds(460, 159, 135, 40);
		panel.add(csearchbtn);
		
		JButton clearbtn = new JButton("Clear");
		clearbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				senroll.setText("");
				nametxt.setText("");
				bcbox.setSelectedIndex(0);
				comboBox.setSelectedIndex(0);
				
			}
		});
		clearbtn.setForeground(new Color(0, 128, 128));
		clearbtn.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		clearbtn.setBounds(808, 209, 150, 40);
		panel.add(clearbtn);
		
		nametxt = new JTextField();
		nametxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				searchdataname();
			}
		});
		nametxt.setFont(new Font("Times New Roman", Font.BOLD, 24));
		nametxt.setUI(new JTextFieldHintUI("Search By Name..",Color.GRAY));
		nametxt.setBounds(29, 212, 419, 34);
		panel.add(nametxt);
		nametxt.setColumns(10);
		
		JButton namesbtn = new JButton("Search");
		namesbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				  
				searchdataname();
			}
		});
		namesbtn.setForeground(new Color(0, 128, 128));
		namesbtn.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		namesbtn.setBounds(460, 208, 135, 40);
		panel.add(namesbtn);
		
		JButton exportbtn = new JButton("Export Data");
		exportbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 JFileChooser fileChooser = new JFileChooser();
				 	fileChooser.setDialogTitle("Specify a file to save"); 
				 	File tfile=null;
				 	int userSelection = fileChooser.showSaveDialog(null);
				 	 
				 	if (userSelection == JFileChooser.APPROVE_OPTION) {
				 	    File fileToSave = fileChooser.getSelectedFile();
				 	   tfile=new File(fileToSave.getAbsolutePath().toString()+".xls");
				 	}
				 	int cc=table.getColumnCount();
				 	int cr=table.getRowCount();
				 	try{
				 		  FileWriter excel = new FileWriter(tfile);
				 		  for(int h=0;h<cc;h++)
				 		  {
				 			  excel.write(table.getColumnName(h).toString()+"\t");
				 		  }
				 		  excel.write("\n");
				 		  for(int x=0;x<cr;x++)
				 			{
				 			 
				 				for(int v=0;v<cc;v++)
				 				{
				 				try {				
				 				 excel.write(table.getValueAt(x, v).toString()+"\t");	
				 				}catch(Exception nm)
				 				{
				 					
				 				}
				 				 //	JOptionPane.showMessageDialog(null, inst_tab.getValueAt(x, v).toString());
				 				}
				 				excel.write("\n");
				 			}
				 		excel.close();
				 	}catch(IOException e){ System.out.println(e); }
				 	
				 }
			
		});
		exportbtn.setForeground(new Color(0, 128, 128));
		exportbtn.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		exportbtn.setBounds(607, 209, 181, 40);
		panel.add(exportbtn);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(docview.class.getResource("/ICONS/doc.png")));
		lblNewLabel_1.setBounds(701, 28, 188, 168);
		panel.add(lblNewLabel_1);
		
		
		panel_1 = new JPanel();
		panel_1.setBounds(24, 275, 935, 435);
		getContentPane().add(panel_1);
		int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		panel_1.setLayout(null);
		JScrollPane scrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(0, 0, 935, 435);
		panel_1.add(scrollPane);
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
	   

	}
	//method to search data using name 
	public void searchdataname() {
		
		String name=nametxt.getText();
		   dcon driverobj=new dcon();
		   Connection conn = null;
		   Statement stmt =null;
		   ResultSet rs;
		    try {

	            Class.forName(driverobj.DRIVER_NAME).newInstance();
	        } catch (Exception ex) {
	            
	        }
		   try {
			    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/doc?useTimezone=true&serverTimezone=UTC", driverobj.USER_NAME, driverobj.PASSWORD);
			    stmt = conn.createStatement();
			    // String q1="update docverify set 8thMS='"+ms8th+"',9thMS='"+ms9th+"',10thMS='"+ms10th+"',12thMS='"+ms12th+"',LC='"+lc+"',CASTE='"+caste+"',INCOME='"+income+"',NCLC='"+noncreamy+"',PHOTOS='"+passport+"',DOMICILE='"+domicile+"',NATIONALITY='"+nationality+"',PHC='"+phc+"',PROFORMA='"+proforma+"',EIDC='"+eidc+"',3COPIES='"+copy+"',AADHAR='"+aadhar+"',VALIDITY='"+validity+"',BANKCOPY='"+bankpass+"',GAP='"+gap+"',RATION='"+ration+"' where ENROLL="+eenroll.getText();
			    rs=stmt.executeQuery("select students.NAME,docverify.ENROLL,students.BRANCH,students.CATEGORY,docverify.8thMS,docverify.9thMS,docverify.10thMS,docverify.12thMS,docverify.LC,docverify.CASTE,docverify.INCOME,docverify.NCLC,docverify.PHOTOS,docverify.DOMICILE,docverify.NATIONALITY,docverify.PHC,docverify.PROFORMA,docverify.EIDC,docverify.3COPIES,docverify.AADHAR,docverify.VALIDITY,docverify.BANKCOPY,docverify.GAP,docverify.RATION FROM students,docverify WHERE students.ENROLL=docverify.ENROLL AND students.NAME='"+name+"'");
			    table.setModel(DbUtils.resultSetToTableModel(rs));
			    demo();
				 stmt.close();
			     conn.close();
			     				      
			      }
			 catch (SQLException ex) {
				 System.out.print(ex);
			    
			}
		
	}
	public String getdata()
	   {
		
		
		   String mystr=null;
		   dcon driverobj=new dcon();
		   Connection conn = null;
		   Statement stmt =null;
		   ResultSet rs;
		    try {

	            Class.forName(driverobj.DRIVER_NAME).newInstance();
	        } catch (Exception ex) {
	            
	        }
		   try {
			    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/doc?useTimezone=true&serverTimezone=UTC", driverobj.USER_NAME, driverobj.PASSWORD);
			    stmt = conn.createStatement();
			 //   rs=stmt.executeQuery("SELECT ENROLL,8thMS,9thMS,10thMS,12thMS from docverify WHERE ENROLL="+senroll.getText());
			    rs=stmt.executeQuery("select students.NAME,docverify.ENROLL,students.BRANCH,students.CATEGORY,docverify.8thMS,docverify.9thMS,docverify.10thMS,docverify.12thMS,docverify.LC,docverify.CASTE,docverify.INCOME,docverify.NCLC,docverify.PHOTOS,docverify.DOMICILE,docverify.NATIONALITY,docverify.PHC,docverify.PROFORMA,docverify.EIDC,docverify.3COPIES,docverify.AADHAR,docverify.VALIDITY,docverify.BANKCOPY,docverify.GAP,docverify.RATION FROM students,docverify WHERE students.ENROLL=docverify.ENROLL AND students.ENROLL="+senroll.getText());
			    table.setModel(DbUtils.resultSetToTableModel(rs));
			    Font f = new Font("Times new Roman", Font.BOLD, 18);
			     JTableHeader header = table.getTableHeader();
			     header.setFont(f);
			     demo();
				 stmt.close();
			     conn.close();
			     				      
			      }
			 catch (SQLException ex) {
				 System.out.print(ex);
			    
			}
			     
	   return mystr;
	   }
	
	public void searchdata(String data)
	   {
		
		
		 String mystr=null;
		 dcon driverobj=new dcon();
		 Connection conn = null;
		 Statement stmt =null;
		    try {

	            Class.forName(driverobj.DRIVER_NAME).newInstance();
	        } catch (Exception ex) {
	            
	        }
		   try {
			    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/doc?useTimezone=true&serverTimezone=UTC", driverobj.USER_NAME, driverobj.PASSWORD);
			    stmt = conn.createStatement();
			    ResultSet rs=stmt.executeQuery("select students.NAME,docverify.ENROLL,students.BRANCH,students.CATEGORY,docverify.8thMS,docverify.9thMS,docverify.10thMS,docverify.12thMS,docverify.LC,docverify.CASTE,docverify.INCOME,docverify.NCLC,docverify.PHOTOS,docverify.DOMICILE,docverify.NATIONALITY,docverify.PHC,docverify.PROFORMA,docverify.EIDC,docverify.3COPIES,docverify.AADHAR,docverify.VALIDITY,docverify.BANKCOPY,docverify.GAP,docverify.RATION FROM students,docverify WHERE students.ENROLL=docverify.ENROLL AND docverify.ENROLL like '"+data+"%'");
			   table.setModel(DbUtils.resultSetToTableModel(rs));
			   demo();
				 stmt.close();
			     conn.close();
			     				      
			      }
			 catch (SQLException ex) {
				 System.out.print(ex);
			    
			}
			     
	   }
	public void demo()
	{
		Font f = new Font("Times new Roman", Font.BOLD, 20);
	     JTableHeader header = table.getTableHeader();
	     header.setFont(f);
	    table.setRowHeight(26);
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    table.getColumnModel().getColumn(0).setPreferredWidth(200);
	    table.getColumnModel().getColumn(1).setPreferredWidth(150);
	    table.getColumnModel().getColumn(2).setPreferredWidth(100);
	    table.getColumnModel().getColumn(3).setPreferredWidth(120);
	    table.getColumnModel().getColumn(4).setPreferredWidth(100);
	    table.getColumnModel().getColumn(5).setPreferredWidth(100);
	    table.getColumnModel().getColumn(6).setPreferredWidth(100);
	    table.getColumnModel().getColumn(7).setPreferredWidth(100);
	    table.getColumnModel().getColumn(8).setPreferredWidth(100);
	    table.getColumnModel().getColumn(9).setPreferredWidth(100);
	    table.getColumnModel().getColumn(10).setPreferredWidth(100);
	    table.getColumnModel().getColumn(11).setPreferredWidth(100);
	    table.getColumnModel().getColumn(12).setPreferredWidth(100);
	    table.getColumnModel().getColumn(13).setPreferredWidth(120);
	    table.getColumnModel().getColumn(14).setPreferredWidth(140);
	    table.getColumnModel().getColumn(15).setPreferredWidth(100);
	    table.getColumnModel().getColumn(16).setPreferredWidth(120);
	    table.getColumnModel().getColumn(17).setPreferredWidth(100);
	    table.getColumnModel().getColumn(18).setPreferredWidth(100);
	    table.getColumnModel().getColumn(19).setPreferredWidth(100);
	    table.getColumnModel().getColumn(20).setPreferredWidth(120);
	    table.getColumnModel().getColumn(21).setPreferredWidth(120);
	    table.getColumnModel().getColumn(22).setPreferredWidth(100);
	    table.getColumnModel().getColumn(23).setPreferredWidth(100);
	}
}
