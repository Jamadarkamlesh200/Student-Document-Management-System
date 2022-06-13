package DOCSYSTEM;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;

public class message extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					message frame = new message();
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
	public message() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 443, 169);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(127, 255, 212), 2));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 441, 168);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton okbtn = new JButton("OK");
		okbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		okbtn.setForeground(new Color(0, 0, 0));
		okbtn.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		okbtn.setBackground(new Color(0, 255, 255));
		okbtn.setBorder(null);
		okbtn.setBounds(200, 124, 92, 31);
		panel.add(okbtn);
		
		JLabel lbl = new JLabel("Successful");
		lbl.setForeground(new Color(30, 144, 255));
		lbl.setFont(new Font("Baskerville Old Face", Font.PLAIN, 40));
		lbl.setBounds(200, 51, 188, 53);
		panel.add(lbl);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(message.class.getResource("/ICONS/msg.png")));
		label.setBounds(55, 24, 100, 100);
		panel.add(label);
		Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int iCoordX = (objDimension.width - this.getWidth()) / 2;
        int iCoordY = (objDimension.height - this.getHeight()) / 2;
        this.setLocation(iCoordX, iCoordY); 
	}
}
