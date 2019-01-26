package com.luobo.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import com.luobo.dao.ManagerDao;
import com.luobo.model.Manager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddManagerFrm extends JInternalFrame {
	private JTextField managerNameTextField;
	private JTextField managerPasswordTextField;
	private JTextField managerTitleTextField;
	private JTextField managerConcateInfomationTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					AddManagerFrm frame = new AddManagerFrm();
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
	public AddManagerFrm() {
		setTitle("\u6DFB\u52A0\u5E72\u5458");
		setBounds(100, 100, 450, 346);
		
		setClosable(true);
		setIconifiable(true);
		
		JLabel lblNewLabel = new JLabel("\u5E72\u5458\u59D3\u540D:");
		lblNewLabel.setIcon(new ImageIcon(AddManagerFrm.class.getResource("/images/\u7528\u6237\u540D.png")));
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		managerNameTextField = new JTextField();
		managerNameTextField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		managerNameTextField.setColumns(10);
		
		JLabel label = new JLabel("\u5E72\u5458\u5BC6\u7801:");
		label.setIcon(new ImageIcon(AddManagerFrm.class.getResource("/images/\u5BC6\u7801.png")));
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		managerPasswordTextField = new JTextField();
		managerPasswordTextField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		managerPasswordTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u5E72\u5458\u804C\u79F0:");
		label_1.setIcon(new ImageIcon(AddManagerFrm.class.getResource("/images/\u804C\u52A1.png")));
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		managerTitleTextField = new JTextField();
		managerTitleTextField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		managerTitleTextField.setColumns(10);
		
		JButton submitButton = new JButton("\u786E\u8BA4\u6DFB\u52A0");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				submitManagerAct(ae);
			}
		});
		submitButton.setIcon(new ImageIcon(AddManagerFrm.class.getResource("/images/\u786E\u8BA4.png")));
		submitButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JButton resetValuesButton = new JButton("\u91CD\u7F6E");
		resetValuesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ag) {
				resetValue(ag);
			}
		});
		resetValuesButton.setIcon(new ImageIcon(AddManagerFrm.class.getResource("/images/\u91CD\u7F6E.png")));
		resetValuesButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JLabel label_2 = new JLabel("\u8054\u7CFB\u65B9\u5F0F:");
		label_2.setIcon(new ImageIcon(AddManagerFrm.class.getResource("/images/\u8054\u7CFB\u65B9\u5F0F.png")));
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		managerConcateInfomationTextField = new JTextField();
		managerConcateInfomationTextField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		managerConcateInfomationTextField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(83)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(managerConcateInfomationTextField, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(submitButton)
							.addPreferredGap(ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
							.addComponent(resetValuesButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(managerTitleTextField, 172, 172, 172))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(managerPasswordTextField, 172, 172, 172))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(managerNameTextField, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)))
					.addGap(90))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(50)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(managerNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(managerPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(managerTitleTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(managerConcateInfomationTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(resetValuesButton)
						.addComponent(submitButton))
					.addContainerGap(46, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

	protected void submitManagerAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		String managerName = managerNameTextField.getText().toString();
		String managerPassword = managerPasswordTextField.getText().toString();
		String managerTitle = managerTitleTextField.getText().toString();
		String managetConcateInfomation = managerConcateInfomationTextField.getText().toString();
		Manager ma = new Manager();
		ma.setName(managerName);
		ma.setPassword(managerPassword);
		ma.setTitle(managerTitle);
		ma.setContact_infomation(managetConcateInfomation);
		ManagerDao managerDao = new ManagerDao();
		if(managerDao.addManager(ma)){
			JOptionPane.showMessageDialog(this, "Ìí¼Ó³É¹¦");
		}
		else{
			JOptionPane.showMessageDialog(this, "Ìí¼ÓÊ§°Ü");
			return;
		}
	}

	protected void resetValue(ActionEvent ag) {
		// TODO Auto-generated method stub
		managerNameTextField.setText("");
		managerPasswordTextField.setText("");
		managerTitleTextField.setText("");
		managerConcateInfomationTextField.setText("");
	}
}
