package DOCSYSTEM;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField uname;
	private JPasswordField pname;
	private JButton lbtn;
	private JLabel lblNewLabel_1;
	        Main frame2 ;
	       

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setUndecorated(true);
		setVisible(true);
		setResizable(false);
		//ImageIcon icon=new ImageIcon("/ICONS/logodo.png");
		//setIconImage(icon.getImage());
		
		JLayeredPane layeredPane = new JLayeredPane();
		getContentPane().add(layeredPane, BorderLayout.WEST);
		setBounds(100, 100, 600, 312);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ahinsa Polytechnic");
		lblNewLabel.setBackground(new Color(72, 209, 204));
		lblNewLabel.setForeground(new Color(0, 128, 128));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(187, 23, 348, 49);
		contentPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setForeground(new Color(0, 128, 128));
		lblUserName.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblUserName.setBounds(242, 95, 120, 32);
		contentPane.add(lblUserName);
		
		uname = new JTextField();
		uname.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		uname.setBounds(352, 95, 230, 35);
		contentPane.add(uname);
		uname.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(0, 128, 128));
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblPassword.setBounds(242, 158, 98, 36);
		contentPane.add(lblPassword);
		
		pname = new JPasswordField();
		pname.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		pname.setBounds(352, 159, 230, 35);
		contentPane.add(pname);
		
		lbtn = new JButton("Login");
		lbtn.setForeground(new Color(0, 128, 128));
		lbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String user="Ahinsa";
				String pass="1475"; 
				String u=uname.getText();
				char[] input = pname.getPassword();
                String p = new String(input);
				if(user.equals(u))
				{
					    if(pass.equals(p)) {
							setVisible(false);
							frame2 = new Main();
							frame2.show();
							}
							else {
								JOptionPane.showMessageDialog(null,"Please Check Password");
							}
					
				}
				else {
					JOptionPane.showMessageDialog(null,"Please Check UserName");
				}
			}
		});
		lbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lbtn.setBackground(Color.cyan);
				lbtn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lbtn.setBackground(new Color(144, 238, 144));
				lbtn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
			}
		});
		lbtn.setBackground(new Color(144, 238, 144));
		lbtn.setBorder(null);
		lbtn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbtn.setBounds(404, 243, 120, 35);
		contentPane.add(lbtn);
		
		JButton exitbtn = new JButton("Exit");
		exitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		exitbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				exitbtn.setBackground(Color.cyan);
				exitbtn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				exitbtn.setBackground(new Color(144, 238, 144));
				exitbtn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
			}
		});
		exitbtn.setForeground(new Color(0, 128, 128));
		exitbtn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		exitbtn.setBorder(null);
		exitbtn.setBackground(new Color(144, 238, 144));
		exitbtn.setBounds(242, 243, 120, 35);
		contentPane.add(exitbtn);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/ICONS/loginIcon.png")));
		lblNewLabel_1.setBounds(23, 52, 200, 200);
		contentPane.add(lblNewLabel_1);
		
		Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int iCoordX = (objDimension.width - this.getWidth()) / 2;
        int iCoordY = (objDimension.height - this.getHeight()) / 2;
        this.setLocation(iCoordX, iCoordY); 
	}
}
