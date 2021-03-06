package DOCSYSTEM;

import java.awt.EventQueue;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.border.MatteBorder;

import org.jdom.Text;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.FontSelector;
import com.itextpdf.text.pdf.PdfWriter;


import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class docverify extends JInternalFrame {
	private JTextField eenroll;
	private JTextField dtecode;
	private JCheckBox copiesbox;
	private JCheckBox ms8thbox;
	private JCheckBox ms9thbox;
	private JCheckBox ms10thbox;
	private JCheckBox ms12thbox;
	private JCheckBox lcbox;
	private JCheckBox castebox;
	private JCheckBox incomebox;
	private JCheckBox NCLbox;
	private JCheckBox photobox;
	private JCheckBox domicilebox;
	private JCheckBox nationbox;
	private JCheckBox PHCbox;
	private JCheckBox proformabox;
	private JCheckBox elementarybox;
	private JCheckBox aadharbox;
	private JCheckBox validitybox;
	private JCheckBox bankpassbox;
	private JCheckBox GAPbox;
	private JCheckBox rationbox;
	String sid1,name1, dtecode1, branch1, year1, category1;
	private JScrollPane scrollPane;
	private JPanel panel_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					docverify frame = new docverify();
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
	public docverify() {
		setFont(new Font("Dialog", Font.PLAIN, 22));
		setBounds(100, 100, 1020, 1000);
		getContentPane().setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1004, 183);
		getContentPane().add(panel);
		panel.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		panel.setBackground(SystemColor.text);
		panel.setLayout(null);
		
		JLabel lblDocumentVerify = new JLabel("Document Verify");
		lblDocumentVerify.setForeground(new Color(0, 128, 128));
		lblDocumentVerify.setHorizontalAlignment(SwingConstants.CENTER);
		lblDocumentVerify.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblDocumentVerify.setBounds(227, 1, 523, 49);
		panel.add(lblDocumentVerify);
		
		JLabel lblEnterEnrollmentNumber = new JLabel("Enter Enrollment Number ");
		lblEnterEnrollmentNumber.setBackground(SystemColor.text);
		lblEnterEnrollmentNumber.setForeground(new Color(0, 0, 128));
		lblEnterEnrollmentNumber.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblEnterEnrollmentNumber.setBounds(12, 63, 280, 36);
		panel.add(lblEnterEnrollmentNumber);
		
		eenroll = new JTextField();
		eenroll.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		eenroll.setBackground(new Color(102, 205, 170));
		eenroll.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		eenroll.setBackground(UIManager.getColor("Button.highlight"));
		eenroll.setBounds(304, 65, 237, 36);
		panel.add(eenroll);
		eenroll.setColumns(10);
		
		JLabel lblDid = new JLabel("DTE Code");
		lblDid.setForeground(new Color(0, 0, 128));
		lblDid.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblDid.setBackground(Color.WHITE);
		lblDid.setBounds(22, 115, 129, 36);
		panel.add(lblDid);
		
		dtecode = new JTextField();
		dtecode.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		dtecode.setColumns(10);
		dtecode.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		dtecode.setBackground(Color.WHITE);
		dtecode.setBounds(304, 114, 239, 36);
		panel.add(dtecode);
		
		JButton viewbtn = new JButton("View");
		viewbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
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
					   
					   
					    ResultSet rs=stmt.executeQuery("select * from docverify where ENROLL="+eenroll.getText());
					    if(rs.next()==true)
					    {
					    	eenroll.setText(rs.getString(1));
					    	dtecode.setText(rs.getString(2));
					    	String s="Submitted";
					    	if(s.equals(rs.getString(3))) {
					    		ms8thbox.setSelected(true);
					    	}
					    	if(s.equals(rs.getString(4))) {
					    		ms9thbox.setSelected(true);
					    	}
					    	if(s.equals(rs.getString(5))) {
					    		ms10thbox.setSelected(true);
					    	}
					    	if(s.equals(rs.getString(6))) {
					    		ms12thbox.setSelected(true);
					    	}
					    	if(s.equals(rs.getString(7))) {
					    		lcbox.setSelected(true);
					    	}
					    	if(s.equals(rs.getString(8))) {
					    		castebox.setSelected(true);
					    	}
					    	if(s.equals(rs.getString(9))) {
					    		incomebox.setSelected(true);
					    	}
					    	if(s.equals(rs.getString(10))) {
					    		NCLbox.setSelected(true);
					    	}
					    	if(s.equals(rs.getString(11))) {
					    		photobox.setSelected(true);
					    	}
					    	if(s.equals(rs.getString(12))) {
					    		domicilebox.setSelected(true);
					    	}
					    	if(s.equals(rs.getString(13))) {
					    		nationbox.setSelected(true);
					    	}
					    	if(s.equals(rs.getString(14))) {
					    		PHCbox.setSelected(true);
					    	}
					    	if(s.equals(rs.getString(15))) {
					    		proformabox.setSelected(true);
					    	}
					    	if(s.equals(rs.getString(16))) {
					    		elementarybox.setSelected(true);
					    	}
					    	if(s.equals(rs.getString(17))) {
					    		copiesbox.setSelected(true);
					    	}
					    	if(s.equals(rs.getString(18))) {
					    		aadharbox.setSelected(true);
					    	}
					    	if(s.equals(rs.getString(19))) {
					    		validitybox.setSelected(true);
					    	}
					    	if(s.equals(rs.getString(20))) {
					    		bankpassbox.setSelected(true);
					    	}
					    	if(s.equals(rs.getString(21))) {
					    		GAPbox.setSelected(true);
					    	}
					    	if(s.equals(rs.getString(22))) {
					    		rationbox.setSelected(true);
					    	}
					    	
		                   //other method to fetch data into database to direct set combobox selected
					    	
						   /* ms8thbox.setSelected(Boolean.parseBoolean(rs.getString(3)));
							ms9thbox.setSelected(Boolean.parseBoolean(rs.getString(4)));
							ms10thbox.setSelected(Boolean.parseBoolean(rs.getString(5)));
							ms12thbox.setSelected(Boolean.parseBoolean(rs.getString(6)));
					    	*/
					    	
					    }
					 
						 stmt.close();
					     conn.close();
					     				      
					      }
					 catch (SQLException ex) {
						 System.out.print(ex);
					    
					}
				
			}
		});
		viewbtn.setForeground(new Color(0, 0, 128));
		viewbtn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		viewbtn.setBounds(602, 60, 115, 42);
		panel.add(viewbtn);
		
		JButton updatebtn = new JButton("Update");
		updatebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dcon driverobj=new dcon();
				   Connection conn = null;
				   Statement stmt =null;
				    String enroll=eenroll.getText();
				    String ms8th="Not Submitted";
				    String ms9th="Not Submitted";
				    String ms10th="Not Submitted";
				    String ms12th="Not Submitted";
				    String lc="Not Submitted";
				    String caste="Not Submitted";
				    String income="Not Submitted";
				    String noncreamy="Not Submitted";
				    String passport="Not Submitted";
				    String domicile="Not Submitted";
				    String nationality="Not Submitted";
				    String phc="Not Submitted";
				    String proforma="Not Submitted";
				    String eidc="Not Submitted";
				    String copy="Not Submitted";
				    String aadhar="Not Submitted";
				    String validity="Not Submitted";
				    String bankpass="Not Submitted";
				    String gap="Not Submitted";
				    String ration="Not Submitted";
				    //check selected 
				    if(ms8thbox.isSelected()==true) {
				    	ms8th="Submitted";
				    }
				    if(ms9thbox.isSelected()==true) {
				    	ms9th="Submitted";
				    }
				    if(ms10thbox.isSelected()==true) {
				    	ms10th="Submitted";
				    }
				    if(ms12thbox.isSelected()==true) {
				    	ms12th="Submitted";
				    }
				    if(lcbox.isSelected()==true) {
				    	lc="Submitted";
				    }
				    if(castebox.isSelected()==true) {
				    	caste="Submitted";
				    }
				    if(incomebox.isSelected()==true) {
				    	income="Submitted";
				    }
				    if(NCLbox.isSelected()==true) {
				    	noncreamy="Submitted";
				    }
				    if(photobox.isSelected()==true) {
				    	passport="Submitted";
				    }
				    if(domicilebox.isSelected()==true) {
				    	domicile="Submitted";
				    }
				    if(nationbox.isSelected()==true) {
				    	nationality="Submitted";
				    }
				    if(PHCbox.isSelected()==true) {
				    	phc="Submitted";
				    }
				    if(proformabox.isSelected()==true) {
				    	proforma="Submitted";
				    }
				    if(elementarybox.isSelected()==true) {
				    	eidc="Submitted";
				    }
				    if(copiesbox.isSelected()==true) {
				    	copy="Submitted";
				    }
				    if(aadharbox.isSelected()==true) {
				    	aadhar="Submitted";
				    }
				    if(validitybox.isSelected()==true) {
				    	validity="Submitted";
				    }
				    if(bankpassbox.isSelected()==true) {
				    	bankpass="Submitted";
				    }
				    if(GAPbox.isSelected()==true) {
				    	gap="Submitted";
				    }
				    if(rationbox.isSelected()==true) {
				    	ration="Submitted";
				    }
				   
				    String q1="update docverify set 8thMS='"+ms8th+"',9thMS='"+ms9th+"',10thMS='"+ms10th+"',12thMS='"+ms12th+"',LC='"+lc+"',CASTE='"+caste+"',INCOME='"+income+"',NCLC='"+noncreamy+"',PHOTOS='"+passport+"',DOMICILE='"+domicile+"',NATIONALITY='"+nationality+"',PHC='"+phc+"',PROFORMA='"+proforma+"',EIDC='"+eidc+"',3COPIES='"+copy+"',AADHAR='"+aadhar+"',VALIDITY='"+validity+"',BANKCOPY='"+bankpass+"',GAP='"+gap+"',RATION='"+ration+"' where ENROLL="+eenroll.getText();
			//	   String q="update docverify set 8thMS='"+ms8th+"',9thMS='"+ms9th+"',10thMS='"+ms10th+"',12thMS='"+ms12th+"',LC='"+lc+"',CASTE='"+caste+"',INCOME='"+income+"',NCLC='"+noncreamy+"',PHOTOS='"+passport+"',DOMICILE='"+domicile+"',NATIONALITY='"+nationality+"',PHC='"+phc+"',PROFORMA='"+proforma+"',EIDC='"+eidc+"',3COPIES='"+copy+"',AADHAR='"+aadhar+"',VALIDITY='"+validity+"',BANKCOPY='"+bankpass+"',GAP='"+gap+"',RATION='"+ration+"',where ENROLL="+eenroll.getText();
				  
				    	
			          try {
						Class.forName(driverobj.DRIVER_NAME).newInstance();
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				   
			       
				 try {
					    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/doc?useTimezone=true&serverTimezone=UTC", driverobj.USER_NAME, driverobj.PASSWORD);
					    stmt = conn.createStatement();
					   stmt.executeUpdate(q1);
					   message m=new message();
					   m.setVisible(true);
                       
						 stmt.close();
					     conn.close();
					     				      
					  }
					 catch (SQLException ex) {
						 System.out.print(ex);
					 }
			}
		});
		updatebtn.setForeground(new Color(0, 0, 128));
		updatebtn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		updatebtn.setBounds(729, 60, 115, 42);
		panel.add(updatebtn);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0,184, 1004, 797);
		getContentPane().add(panel_1);
		panel_1.setBackground(SystemColor.control);
		panel_1.setLayout(null);
		
		ms8thbox = new JCheckBox("8th MarkSheet");
		ms8thbox.setBackground(SystemColor.text);
		ms8thbox.setForeground(new Color(0, 0, 128));
		ms8thbox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
			}
		});
		ms8thbox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		ms8thbox.setBounds(24, 48, 443, 42);
		panel_1.add(ms8thbox);
		
		JLabel lblNewLabel = new JLabel("Document List");
		lblNewLabel.setForeground(new Color(0, 128, 128));
		lblNewLabel.setBorder(new EmptyBorder(0, 0, 0, 0));
		lblNewLabel.setBackground(Color.CYAN);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel.setBounds(38, 0, 892, 37);
		panel_1.add(lblNewLabel);
		
		lcbox = new JCheckBox("Original Leaving Certificate(L.C)");
		lcbox.setBackground(SystemColor.text);
		lcbox.setForeground(new Color(0, 0, 128));
		lcbox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lcbox.setBounds(24, 273, 443, 42);
		panel_1.add(lcbox);
		
		castebox = new JCheckBox("Caste Certificate(If applicable)");
		castebox.setBackground(SystemColor.text);
		castebox.setForeground(new Color(0, 0, 128));
		castebox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		castebox.setBounds(24, 330, 443, 42);
		panel_1.add(castebox);
		
		JButton dprintbtn = new JButton("Report");
		dprintbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dcon driverobj=new dcon();
				   Connection conn = null;
				   Statement stmt =null;
				   ResultSet rs;
				   String ms8th="No";
				    String ms9th="No";
				    String ms10th="No";
				    String ms12th="No";
				    String lc="No";
				    String caste="No";
				    String income="No";
				    String noncreamy="No";
				    String passport="No";
				    String domicile="No";
				    String nationality="No";
				    String phc="No";
				    String proforma="No";
				    String eidc="No";
				    String copy="No";
				    String aadhar="No";
				    String validity="No";
				    String bankpass="No";
				    String gap="No";
				    String ration="No";
				    //check selected 
				    if(ms8thbox.isSelected()==true) {
				    	ms8th="Yes";
				    }
				    if(ms9thbox.isSelected()==true) {
				    	ms9th="Yes";
				    }
				    if(ms10thbox.isSelected()==true) {
				    	ms10th="Yes";
				    }
				    if(ms12thbox.isSelected()==true) {
				    	ms12th="Yes";
				    }
				    if(lcbox.isSelected()==true) {
				    	lc="Yes";
				    }
				    if(castebox.isSelected()==true) {
				    	caste="Yes";
				    }
				    if(incomebox.isSelected()==true) {
				    	income="Yes";
				    }
				    if(NCLbox.isSelected()==true) {
				    	noncreamy="Yes";
				    }
				    if(photobox.isSelected()==true) {
				    	passport="Yes";
				    }
				    if(domicilebox.isSelected()==true) {
				    	domicile="Yes";
				    }
				    if(nationbox.isSelected()==true) {
				    	nationality="Yes";
				    }
				    if(PHCbox.isSelected()==true) {
				    	phc="Yes";
				    }
				    if(proformabox.isSelected()==true) {
				    	proforma="Yes";
				    }
				    if(elementarybox.isSelected()==true) {
				    	eidc="Yes";
				    }
				    if(copiesbox.isSelected()==true) {
				    	copy="Yes";
				    }
				    if(aadharbox.isSelected()==true) {
				    	aadhar="Yes";
				    }
				    if(validitybox.isSelected()==true) {
				    	validity="Yes";
				    }
				    if(bankpassbox.isSelected()==true) {
				    	bankpass="Yes";
				    }
				    if(GAPbox.isSelected()==true) {
				    	gap="Yes";
				    }
				    if(rationbox.isSelected()==true) {
				    	ration="Yes";
				    }
				  
				    try {

			            Class.forName(driverobj.DRIVER_NAME).newInstance();
			        } catch (Exception ex) {
			            
			        }
				   try {
					    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/doc?useTimezone=true&serverTimezone=UTC", driverobj.USER_NAME, driverobj.PASSWORD);
					    stmt = conn.createStatement();
					    rs=stmt.executeQuery("SELECT SID,NAME,DTECODE,BRANCH,YEAR,CATEGORY from students WHERE ENROLL="+eenroll.getText());
					    if(rs.next()==true)
					    {
					    	sid1=rs.getString(1);
					    	name1=rs.getString(2);
					    	dtecode1=rs.getString(3);
					    	year1=rs.getString(5);
					    	category1=rs.getString(6);
					    }
					  
						 stmt.close();
					     conn.close();
					     				      
					      }
					 catch (SQLException ex) {
						 System.out.print(ex);
					    
					}
				   //code for pdf
				   Document document = new Document();
			        try {

			            PdfWriter.getInstance(document, new FileOutputStream(new File("H:"+eenroll.getText()+".pdf")));

			            document.open();
			           
			            Paragraph pid1 = new Paragraph("Ahinsa Polytechnic Document Report",FontFactory.getFont(FontFactory.TIMES_ROMAN, 26f));
			            pid1.setAlignment(Element.ALIGN_CENTER);
			            document.add(pid1);
			            
			            Paragraph pida = new Paragraph();
			            pida.add("\n");
			            document.add(pida);
			           
			            //dtecode1, branch1, year1, category1;
			            Paragraph pid01 = new Paragraph();
			          	pid01.add("STUDENT DOCUMENT ID          : "+sid1);
			            document.add(pid01);
			            
			            Paragraph e000 = new Paragraph();
			          	e000.add("ENROLL NUMBER                      : "+eenroll.getText());
			            document.add(e000);
			           
			            Paragraph pid02= new Paragraph();
			            pid02.add("NAME                                           : "+name1);
			            document.add(pid02);
			            
			            Paragraph pid03 = new Paragraph();
			            pid03.add("DTENUMBER                              : "+dtecode1);
			            document.add(pid03);
			            
			            Paragraph pid04 = new Paragraph();
			            pid04.add("BRANCH                                      : "+branch1);
			            document.add(pid04);

			            Paragraph pid05= new Paragraph();
			            pid05.add("YEAR                                           : "+year1);
			            document.add(pid05);
			            
			            Paragraph pid06= new Paragraph();
			            pid06.add("CATEGORY                                 : "+category1);
			            document.add(pid06);
			            
			            DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			            LocalDateTime now=LocalDateTime.now();
			            Paragraph pid0= new Paragraph();
			            pid0.add("Date : "+dtf.format(now));
			            pid0.setAlignment(Element.ALIGN_RIGHT);
			            document.add(pid0);
			          //  document.add(new Paragraph(new Date.toString()));
			          
			            Paragraph pid07 = new Paragraph();
			            pid07.add("==========================================================================\n");
			            document.add(pid07);
			            
			            Paragraph pid08= new Paragraph();
			            pid08.add("  01)  8th MarkSheet                                                                : "+ms8th);
			            document.add(pid08);
			            Paragraph pid09= new Paragraph();
			            pid09.add("  02)  9th MarkSheet                                                                : "+ms9th);
			            document.add(pid09);
			            Paragraph pid10= new Paragraph();
			            pid10.add("  03)  10th MarkSheet                                                              : "+ms10th);
			            document.add(pid10);
			            Paragraph pid11= new Paragraph();
			            pid11.add("  04)  12th MarkSheet                                                              : "+ms12th);
			            document.add(pid11);  
			            Paragraph pid12= new Paragraph();
			            pid12.add("  05)  Original Leaving Certificate(LC)                                     : "+lc);
			            document.add(pid12);
			            Paragraph pid13= new Paragraph();
			            pid13.add("  06)  Caste Certificate                                                            : "+caste);
			            document.add(pid13);
			            Paragraph pid14= new Paragraph();
			            pid14.add("  07)  Income Certificate                                                          : "+income);
			            document.add(pid14);
			            Paragraph pid15= new Paragraph();
			            pid15.add("  08)  Non Creamy Layer Certificate                                        : "+noncreamy);
			            document.add(pid15);
			            Paragraph pid16= new Paragraph();
			            pid16.add("  09)  Passport Photo                                                               : "+passport);
			            document.add(pid16);
			            Paragraph pid17= new Paragraph();
			            pid17.add("  10)  Domicile Certificate                                                         : "+domicile);
			            document.add(pid17);
			            Paragraph pid18= new Paragraph();
			            pid18.add("  11)  Nationality                                                                       : "+nationality);
			            document.add(pid18);
			            Paragraph pid19= new Paragraph();
			            pid19.add("  12)  Physically Handicap Certificate                                      : "+phc);
			            document.add(pid19);
			            Paragraph pid20= new Paragraph();
			            pid20.add("  13)  Proforma Z                                                                      : "+proforma);
			            document.add(pid20);
			            Paragraph pid21= new Paragraph();
			            pid21.add("  14)  Elementary Or Intermediate Drawing Certificate            : "+eidc);
			            document.add(pid21);
			            Paragraph pid22= new Paragraph();
			            pid22.add("  15)  Xerox Copies Set                                                            : "+copy);
			            document.add(pid22);
			            Paragraph pid23= new Paragraph();
			            pid23.add("  16)  Aadhar Card                                                                   : "+aadhar);
			            document.add(pid23);
			            Paragraph pid24= new Paragraph();
			            pid24.add("  17)  Validity Certificate                                                           : "+validity);
			            document.add(pid24);
			            Paragraph pid25= new Paragraph();
			            pid25.add("  18)  Bank Passbook Xerox Copy                                           : "+bankpass);
			            document.add(pid25);
			            Paragraph pid26= new Paragraph();
			            pid26.add("  19)  GAP Certificate                                                               : "+gap);
			            document.add(pid26);
			            Paragraph pid27= new Paragraph();
			            pid27.add("  20)  Ration Card Xerox                                                          : "+ration);
			            document.add(pid27);
			    
			            Paragraph pid= new Paragraph();
			            pid.add("\n\n\n\n\n\n\n\n\n");
			            document.add(pid);
			            Paragraph pid200= new Paragraph("Signature Of DOC Verifier",FontFactory.getFont(FontFactory.COURIER_BOLD, 14f));
			            pid200.setAlignment(Element.ALIGN_RIGHT);
			            document.add(pid200);
			            
			             //close
			            document.close();
			           // System.out.println("Done");

			        } catch (FileNotFoundException | DocumentException e) {
			            e.printStackTrace();
			        } catch (IOException e) {
			            e.printStackTrace();
			        }
			        delay(1000);
			        try {
			        	Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler "+"H:\\"+eenroll.getText()+".pdf");
			        }catch(Exception e){
			        	JOptionPane.showMessageDialog(null, "Check File Details");
			        }
			}

			private void delay(int i) {
				// TODO Auto-generated method stub
				i=i+10;
			}
		});
		dprintbtn.setForeground(new Color(0, 0, 128));
		dprintbtn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		dprintbtn.setBounds(452, 733, 115, 42);
		panel_1.add(dprintbtn);
		
		incomebox = new JCheckBox("Income Certificate");
		incomebox.setBackground(SystemColor.text);
		incomebox.setForeground(new Color(0, 0, 128));
		incomebox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		incomebox.setBounds(24, 386, 443, 42);
		panel_1.add(incomebox);
		
		NCLbox = new JCheckBox("Non Creamy Layer Certificate(OBC,SBC,NT,VJ)");
		NCLbox.setForeground(new Color(0, 0, 128));
		NCLbox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		NCLbox.setBackground(Color.WHITE);
		NCLbox.setBounds(24, 443, 443, 42);
		panel_1.add(NCLbox);
		
		PHCbox = new JCheckBox("Physically Handicap Certificate(If applicable)");
		PHCbox.setForeground(new Color(0, 0, 128));
		PHCbox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		PHCbox.setBackground(Color.WHITE);
		PHCbox.setBounds(24, 671, 443, 42);
		panel_1.add(PHCbox);
		
		photobox = new JCheckBox("Passport Size Photograph(5)");
		photobox.setForeground(new Color(0, 0, 128));
		photobox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		photobox.setBackground(Color.WHITE);
		photobox.setBounds(24, 499, 443, 42);
		panel_1.add(photobox);
		
		domicilebox = new JCheckBox("Domicile Certificate");
		domicilebox.setForeground(new Color(0, 0, 128));
		domicilebox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		domicilebox.setBackground(Color.WHITE);
		domicilebox.setBounds(24, 558, 443, 42);
		panel_1.add(domicilebox);
		
		nationbox = new JCheckBox("Nationality");
		nationbox.setForeground(new Color(0, 0, 128));
		nationbox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		nationbox.setBackground(Color.WHITE);
		nationbox.setBounds(24, 613, 443, 42);
		panel_1.add(nationbox);
		
		elementarybox = new JCheckBox("Elementary or Intermediate Drawing Certificate(If applicable)");
		elementarybox.setForeground(new Color(0, 0, 128));
		elementarybox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		elementarybox.setBackground(Color.WHITE);
		elementarybox.setBounds(491, 100, 489, 42);
		panel_1.add(elementarybox);
		
		copiesbox = new JCheckBox("3 Set of Photo Copies of above Documents");
		copiesbox.setForeground(new Color(0, 0, 128));
		copiesbox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		copiesbox.setBackground(Color.WHITE);
		copiesbox.setBounds(491, 158, 489, 42);
		panel_1.add(copiesbox);
		
		aadharbox = new JCheckBox("Aadhar Card");
		aadharbox.setForeground(new Color(0, 0, 128));
		aadharbox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		aadharbox.setBackground(Color.WHITE);
		aadharbox.setBounds(491, 215, 489, 42);
		panel_1.add(aadharbox);
		
		bankpassbox = new JCheckBox("Bank Passbook Xerox Copy");
		bankpassbox.setForeground(new Color(0, 0, 128));
		bankpassbox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		bankpassbox.setBackground(Color.WHITE);
		bankpassbox.setBounds(491, 328, 489, 42);
		panel_1.add(bankpassbox);
		
		validitybox = new JCheckBox("Validity Certificate");
		validitybox.setForeground(new Color(0, 0, 128));
		validitybox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		validitybox.setBackground(Color.WHITE);
		validitybox.setBounds(491, 271, 489, 42);
		panel_1.add(validitybox);
		
		GAPbox = new JCheckBox("GAP Certificate(If aaplicable)");
		GAPbox.setForeground(new Color(0, 0, 128));
		GAPbox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GAPbox.setBackground(Color.WHITE);
		GAPbox.setBounds(491, 384, 489, 42);
		panel_1.add(GAPbox);
		
		rationbox = new JCheckBox("Ration Card Xerox");
		rationbox.setForeground(new Color(0, 0, 128));
		rationbox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rationbox.setBackground(Color.WHITE);
		rationbox.setBounds(491, 443, 489, 42);
		panel_1.add(rationbox);
		
		proformabox = new JCheckBox("Proforma Z");
		proformabox.setForeground(new Color(0, 0, 128));
		proformabox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		proformabox.setBackground(Color.WHITE);
		proformabox.setBounds(493, 45, 487, 42);
		panel_1.add(proformabox);
		
		ms12thbox = new JCheckBox("12th MarkSheet");
		ms12thbox.setForeground(new Color(0, 0, 128));
		ms12thbox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		ms12thbox.setBackground(Color.WHITE);
		ms12thbox.setBounds(24, 218, 443, 42);
		panel_1.add(ms12thbox);
		
		ms10thbox = new JCheckBox("10th MarkSheet");
		ms10thbox.setForeground(new Color(0, 0, 128));
		ms10thbox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		ms10thbox.setBackground(Color.WHITE);
		ms10thbox.setBounds(24, 161, 443, 42);
		panel_1.add(ms10thbox);
		
		ms9thbox = new JCheckBox("9th MarkSheet");
		ms9thbox.setForeground(new Color(0, 0, 128));
		ms9thbox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		ms9thbox.setBackground(Color.WHITE);
		ms9thbox.setBounds(24, 103, 443, 42);
		panel_1.add(ms9thbox);
		
		JButton savebtn = new JButton("Save");
		savebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			//assign variable's
			String enroll=eenroll.getText();
			String dteno=dtecode.getText();
		    //get selectd checkboxes
		    String ms8th="Not Submitted";
		    String ms9th="Not Submitted";
		    String ms10th="Not Submitted";
		    String ms12th="Not Submitted";
		    String lc="Not Submitted";
		    String caste="Not Submitted";
		    String income="Not Submitted";
		    String noncreamy="Not Submitted";
		    String passport="Not Submitted";
		    String domicile="Not Submitted";
		    String nationality="Not Submitted";
		    String phc="Not Submitted";
		    String proforma="Not Submitted";
		    String eidc="Not Submitted";
		    String copy="Not Submitted";
		    String aadhar="Not Submitted";
		    String validity="Not Submitted";
		    String bankpass="Not Submitted";
		    String gap="Not Submitted";
		    String ration="Not Submitted";
		    //check selected 
		    if(ms8thbox.isSelected()==true) {
		    	ms8th="Submitted";
		    }
		    if(ms9thbox.isSelected()==true) {
		    	ms9th="Submitted";
		    }
		    if(ms10thbox.isSelected()==true) {
		    	ms10th="Submitted";
		    }
		    if(ms12thbox.isSelected()==true) {
		    	ms12th="Submitted";
		    }
		    if(lcbox.isSelected()==true) {
		    	lc="Submitted";
		    }
		    if(castebox.isSelected()==true) {
		    	caste="Submitted";
		    }
		    if(incomebox.isSelected()==true) {
		    	income="Submitted";
		    }
		    if(NCLbox.isSelected()==true) {
		    	noncreamy="Submitted";
		    }
		    if(photobox.isSelected()==true) {
		    	passport="Submitted";
		    }
		    if(domicilebox.isSelected()==true) {
		    	domicile="Submitted";
		    }
		    if(nationbox.isSelected()==true) {
		    	nationality="Submitted";
		    }
		    if(PHCbox.isSelected()==true) {
		    	phc="Submitted";
		    }
		    if(proformabox.isSelected()==true) {
		    	proforma="Submitted";
		    }
		    if(elementarybox.isSelected()==true) {
		    	eidc="Submitted";
		    }
		    if(copiesbox.isSelected()==true) {
		    	copy="Submitted";
		    }
		    if(aadharbox.isSelected()==true) {
		    	aadhar="Submitted";
		    }
		    if(validitybox.isSelected()==true) {
		    	validity="Submitted";
		    }
		    if(bankpassbox.isSelected()==true) {
		    	bankpass="Submitted";
		    }
		    if(GAPbox.isSelected()==true) {
		    	gap="Submitted";
		    }
		    if(rationbox.isSelected()==true) {
		    	ration="Submitted";
		    }
  
				   dcon driverobj=new dcon();
				   Connection conn = null;
				   PreparedStatement pst =null;
				   String q="insert into docverify value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				    try {

			            Class.forName(driverobj.DRIVER_NAME).newInstance();
			        } catch (Exception ex) {
			            
			        }
				   try {
					    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/doc?useTimezone=true&serverTimezone=UTC", driverobj.USER_NAME, driverobj.PASSWORD);
					  
					    pst = conn.prepareStatement(q);
					    pst.setString(1,enroll);
					    pst.setString(2,dteno);
					    pst.setString(3,ms8th);
					    pst.setString(4,ms9th);
					    pst.setString(5,ms10th);
					    pst.setString(6,ms12th);
					    pst.setString(7,lc);
					    pst.setString(8,caste);
					    pst.setString(9,income);
					    pst.setString(10,noncreamy);
					    pst.setString(11,passport);
					    pst.setString(12,domicile);
					    pst.setString(13,nationality);
					    pst.setString(14,phc);
					    pst.setString(15,proforma);
					    pst.setString(16,eidc);
					    pst.setString(17,copy);
					    pst.setString(18,aadhar);
					    pst.setString(19,validity);
					    pst.setString(20,bankpass);
					    pst.setString(21,gap);
					    pst.setString(22,ration);
					    
					    pst.executeUpdate();	
						 message mass=new message();
						 mass.setVisible(true);
					    	
						 pst.close();
					     conn.close();
					    }			      
					  
					 catch (SQLException ex) {
						 System.out.print(ex);
						 JOptionPane.showMessageDialog(null,"Check Enrollment Number This Number Already Exist");
					    
					}
			}
		});
		savebtn.setForeground(new Color(0, 0, 128));
		savebtn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		savebtn.setBounds(294, 733, 115, 42);
		panel_1.add(savebtn);
		
		JButton dclearbtn = new JButton("Clear");
		dclearbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    clear();
			}
		});
		dclearbtn.setForeground(new Color(0, 0, 128));
		dclearbtn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		dclearbtn.setBounds(604, 733, 115, 42);
		panel_1.add(dclearbtn);
	
	}
	public void clear()
	{
		eenroll.setText("");
		dtecode.setText("");
		ms8thbox.setSelected(false);
		ms9thbox.setSelected(false);
		ms10thbox.setSelected(false);
		ms12thbox.setSelected(false);
		lcbox.setSelected(false);
		castebox.setSelected(false);
		incomebox.setSelected(false);
		NCLbox.setSelected(false);
		photobox.setSelected(false);
		domicilebox.setSelected(false);
		nationbox.setSelected(false);
		PHCbox.setSelected(false);
		proformabox.setSelected(false);
		elementarybox.setSelected(false);
		copiesbox.setSelected(false);
		aadharbox.setSelected(false);
		validitybox.setSelected(false);
		bankpassbox.setSelected(false);
		GAPbox.setSelected(false);
		rationbox.setSelected(false);
	}
	
}
