package DOCSYSTEM;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Point;

import javax.swing.SwingConstants;
import javax.swing.JList;
import java.awt.Color;
import java.awt.Component;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.Dimension;

public class Main extends JFrame {

	private JPanel contentPane;
	private JDesktopPane mywin;
	private JButton sebtn;
	private JButton dvbtn;
	private JButton vdbtn;
	studentryfrm sefrm;
	docverify dvfrm;
	docview docvfrm;
	public static boolean statsefrm=false;
	public static boolean docverifyfrm=false;
	public static boolean docviewfrm=false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setContinuousLayout(true);
		splitPane.setBounds(0, 0, 1400, 965);
		contentPane.add(splitPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		splitPane.setLeftComponent(panel);
		
		sebtn = new JButton("Student Entry");
		sebtn.setBounds(12, 156, 195, 39);
		sebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			   if(statsefrm==false) {
				sefrm = new studentryfrm();	
			    statsefrm=true;
				mywin.add(sefrm);
				sefrm.show();
			   }
			   if(docverifyfrm==true)
				{
					mywin.remove(dvfrm);
					docverifyfrm=false;
				}
			   if(docviewfrm==true)
				{
					mywin.remove(docvfrm);
					docviewfrm=false;
				}
				
			   
			}
		});
		sebtn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		sebtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				sebtn.setBackground(Color.cyan);
				sebtn.setFont(new Font("Times New Roman", Font.PLAIN, 26));
				
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				sebtn.setBackground(Color.WHITE);
				sebtn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
			}
		});
		panel.setLayout(null);
		sebtn.setBorder(null);
		sebtn.setBackground(Color.WHITE);
		sebtn.setForeground(Color.BLUE);
		panel.add(sebtn);
		
		dvbtn = new JButton("Document Verify");
		dvbtn.setBounds(12, 208, 195, 39);
		dvbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(docverifyfrm==false) {
					dvfrm = new docverify();	
					docverifyfrm=true;
					mywin.add(dvfrm);
					dvfrm.show();
				  }
				if(statsefrm==true)
				{
					mywin.remove(sefrm);
					statsefrm=false;
				}
				if(docviewfrm==true)
				{
					mywin.remove(docvfrm);
					docviewfrm=false;
				}
				
				
				
			}
		});
		dvbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				dvbtn.setBackground(Color.cyan);
				dvbtn.setFont(new Font("Times New Roman", Font.PLAIN, 26));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				dvbtn.setBackground(Color.WHITE);
				dvbtn.setFont(new Font("Times New Roman", Font.PLAIN, 22));	
			}
		});
		dvbtn.setForeground(Color.BLUE);
		dvbtn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		dvbtn.setBorder(null);
		dvbtn.setBackground(Color.WHITE);
		panel.add(dvbtn);
		
		vdbtn = new JButton("View Document");
		vdbtn.setBounds(12, 260, 195, 39);
		vdbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(docviewfrm==false) {
					docvfrm = new docview();	
					docviewfrm=true;
					mywin.add(docvfrm);
					docvfrm.show();
				  }
				if(statsefrm==true)
				{
					mywin.remove(sefrm);
					statsefrm=false;
				}
				if(docverifyfrm==true)
				{
					mywin.remove(dvfrm);
					docverifyfrm=false;
				}
				
			}
		});
		vdbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				vdbtn.setBackground(Color.cyan);
				vdbtn.setFont(new Font("Times New Roman", Font.PLAIN, 26));
				}
			@Override
			public void mouseExited(MouseEvent arg0) {
				vdbtn.setBackground(Color.WHITE);
				vdbtn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
				}
		});
		vdbtn.setForeground(Color.BLUE);
		vdbtn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		vdbtn.setBorder(null);
		vdbtn.setBackground(Color.WHITE);
		panel.add(vdbtn);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Main.class.getResource("/ICONS/logodo.png")));
		label.setBounds(38, 13, 130, 130);
		panel.add(label);
		
		mywin = new JDesktopPane();
		mywin.setAutoscrolls(true);
		splitPane.setRightComponent(mywin);
		mywin.setLayout(null);
		splitPane.setDividerLocation(220);
		BasicSplitPaneUI op=(BasicSplitPaneUI) splitPane.getUI();
		BasicSplitPaneDivider divider=op.getDivider();
		divider.setEnabled(false);
		
		//code for genrate frame center
		Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int iCoordX = (objDimension.width - this.getWidth()) / 2;
        int iCoordY = (objDimension.height - this.getHeight()) / 2;
        this.setLocation(iCoordX, iCoordY); 
			
		}
}
