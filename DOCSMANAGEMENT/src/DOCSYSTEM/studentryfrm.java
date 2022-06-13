package DOCSYSTEM;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class studentryfrm extends JInternalFrame {
	private JTextField sname;
	private JTextField enrollno;
	private JTextField dtecode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentryfrm frame = new studentryfrm();
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
	public studentryfrm() {
		setVisible(true);
		setTitle("Student Entry");
		setResizable(true);
		setBounds(100, 100, 845, 537);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 829, 501);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblStudentEntry = new JLabel("Student Entry");
		lblStudentEntry.setBackground(new Color(245, 245, 245));
		lblStudentEntry.setForeground(new Color(0, 128, 128));
		lblStudentEntry.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentEntry.setFont(new Font("Times New Roman", Font.PLAIN, 34));
		lblStudentEntry.setBounds(36, 26, 736, 49);
		panel.add(lblStudentEntry);
		
		JLabel lblNewLabel = new JLabel("Student Name");
		lblNewLabel.setForeground(new Color(0, 128, 128));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel.setBounds(46, 84, 161, 37);
		panel.add(lblNewLabel);
		
		sname = new JTextField();
		sname.setBackground(new Color(204, 255, 255));
		
		sname.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		sname.setBounds(269, 87, 512, 34);
		panel.add(sname);
		sname.setColumns(10);
		
		JLabel lblEnrollmentNumber = new JLabel("Enrollment Number");
		lblEnrollmentNumber.setForeground(new Color(0, 128, 128));
		lblEnrollmentNumber.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblEnrollmentNumber.setBounds(46, 135, 195, 37);
		panel.add(lblEnrollmentNumber);
		
		enrollno = new JTextField();
		enrollno.setBackground(new Color(204, 255, 255));
		enrollno.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		enrollno.setColumns(10);
		enrollno.setBounds(269, 134, 223, 37);
		panel.add(enrollno);
		
		JLabel lblBranch = new JLabel("Branch");
		lblBranch.setForeground(new Color(0, 128, 128));
		lblBranch.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblBranch.setBounds(46, 285, 195, 37);
		panel.add(lblBranch);
		
		JComboBox yearbox = new JComboBox();
		yearbox.setForeground(new Color(0, 128, 128));
		yearbox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		yearbox.setBackground(Color.WHITE);
		yearbox.setBounds(269, 238, 223, 32);
		panel.add(yearbox);
		yearbox.addItem("Select");
		yearbox.addItem("Direct First Year");
		yearbox.addItem("Direct Second Year");
		
		JComboBox bcbox = new JComboBox();
		bcbox.setBackground(Color.WHITE);
		bcbox.setForeground(new Color(0, 128, 128));
		bcbox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		bcbox.setBounds(269, 288, 223, 32);
		panel.add(bcbox);
		bcbox.addItem("Select");
		bcbox.addItem("CM");
		bcbox.addItem("ME");
		bcbox.addItem("EE");
		bcbox.addItem("E&TC");

	
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setForeground(new Color(0, 128, 128));
		lblCategory.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblCategory.setBounds(46, 335, 127, 37);
		panel.add(lblCategory);
		
		JComboBox ccbox = new JComboBox();
		ccbox.setBackground(Color.WHITE);
		ccbox.setForeground(new Color(0, 128, 128));
		ccbox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		ccbox.setBounds(269, 338, 223, 32);
		panel.add(ccbox);
		ccbox.addItem("Select");
		ccbox.addItem("OPEN");
		ccbox.addItem("OBC");
		ccbox.addItem("NT");
		
		JButton registerbtn = new JButton("Register");
		registerbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			   dcon driverobj=new dcon();
			   Connection conn = null;
			   Statement stmt = null;
			   String sql=null;
			    try {

		            Class.forName(driverobj.DRIVER_NAME).newInstance();
		        } catch (Exception ex) {
		            
		        }
			   try {
				    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/doc?useTimezone=true&serverTimezone=UTC", driverobj.USER_NAME, driverobj.PASSWORD);
				    stmt = conn.createStatement();
				    String value = bcbox.getSelectedItem().toString();
				    String value2 = ccbox.getSelectedItem().toString();
				    String value3 = yearbox.getSelectedItem().toString();
				    sql = "insert into students(NAME,ENROLL,DTECODE,YEAR,BRANCH,CATEGORY) values('"+sname.getText()+"','"+enrollno.getText()+"','"+dtecode.getText()+"','"+value3+"','"+value+"','"+value2+"')";
					 stmt.executeUpdate(sql);	
					 message mass=new message();
					 mass.setVisible(true);
					 stmt.close();
				     conn.close();
				     				      
				      }
				 catch (SQLException ex) {
					 System.out.print(ex);
					 JOptionPane.showMessageDialog(null,"Check Enrollment Number This Number Already Exist");
				    // handle any errors
				}
			}
		});
		registerbtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		registerbtn.setBackground(new Color(204, 204, 255));
		registerbtn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		registerbtn.setBounds(455, 410, 138, 49);
		panel.add(registerbtn);
		
		JButton clearbtn = new JButton("Clear");
		
		clearbtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		clearbtn.setBackground(new Color(204, 204, 255));
		clearbtn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		clearbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sname.setText("");
				enrollno.setText("");
				dtecode.setText("");
				yearbox.setSelectedIndex(0);
				bcbox.setSelectedIndex(0);
				ccbox.setSelectedIndex(0);
			}
		});
		clearbtn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		clearbtn.setBounds(269, 410, 141, 49);
		panel.add(clearbtn);
		
		JLabel lblDteCode = new JLabel("DTE code");
		lblDteCode.setForeground(new Color(0, 128, 128));
		lblDteCode.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblDteCode.setBounds(46, 185, 195, 37);
		panel.add(lblDteCode);
		
		dtecode = new JTextField();
		dtecode.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		dtecode.setColumns(10);
		dtecode.setBackground(new Color(204, 255, 255));
		dtecode.setBounds(269, 184, 223, 37);
		panel.add(dtecode);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setForeground(new Color(0, 128, 128));
		lblYear.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblYear.setBounds(46, 235, 195, 37);
		panel.add(lblYear);
		
		
		
		

	}
}
