package com.luobo.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import com.luobo.dao.AdminDao;
import com.luobo.model.Admin;
import com.luobo.util.StringUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangePasswordFrm extends JInternalFrame {
	private JTextField oldPasswordTextField;
	private JTextField newPasswordTextField;
	private JTextField confirmTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
					ChangePasswordFrm frame = new ChangePasswordFrm();
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
	public ChangePasswordFrm() {
		setTitle("\u5BC6\u7801\u4FEE\u6539");
		setBounds(100, 100, 450, 300);
		
		setClosable(true);
		setIconifiable(true);
		
		JLabel label = new JLabel("\u5F53\u524D\u7528\u6237:");
		label.setIcon(new ImageIcon(ChangePasswordFrm.class.getResource("/images/\u7528\u6237\u540D.png")));
		label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JLabel currentUserLblNewLabel = new JLabel("");
		currentUserLblNewLabel.setEnabled(false);
		currentUserLblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JLabel label_1 = new JLabel("\u65E7\u5BC6\u7801:");
		label_1.setIcon(new ImageIcon(ChangePasswordFrm.class.getResource("/images/\u539F\u5BC6\u7801\uFF0F\u65E7\u5BC6\u7801.png")));
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		oldPasswordTextField = new JTextField();
		oldPasswordTextField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		oldPasswordTextField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u65B0\u5BC6\u7801:");
		label_2.setIcon(new ImageIcon(ChangePasswordFrm.class.getResource("/images/\u65B0\u5BC6\u7801.png")));
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		newPasswordTextField = new JTextField();
		newPasswordTextField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		newPasswordTextField.setColumns(10);
		
		JLabel label_3 = new JLabel("\u786E\u8BA4\u5BC6\u7801:");
		label_3.setIcon(new ImageIcon(ChangePasswordFrm.class.getResource("/images/\u786E\u8BA4\u5BC6\u7801.png")));
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		confirmTextField = new JTextField();
		confirmTextField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		confirmTextField.setColumns(10);
		
		JButton confirmButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				submitEdit(ae);
			}
		});
		confirmButton.setIcon(new ImageIcon(ChangePasswordFrm.class.getResource("/images/\u786E\u8BA4.png")));
		confirmButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JButton resetButton = new JButton("\u91CD\u7F6E");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				resetValue(ae);
			}
		});
		resetButton.setIcon(new ImageIcon(ChangePasswordFrm.class.getResource("/images/\u91CD\u7F6E.png")));
		resetButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(76)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(confirmButton)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(resetButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_3)
							.addGap(18)
							.addComponent(confirmTextField))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label_1)
								.addComponent(label)
								.addComponent(label_2))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(currentUserLblNewLabel, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(newPasswordTextField)
									.addComponent(oldPasswordTextField, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)))))
					.addGap(94))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(currentUserLblNewLabel)
							.addGap(47)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(oldPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1)))
						.addComponent(label))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(newPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(confirmTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(confirmButton)
						.addComponent(resetButton))
					.addGap(28))
		);
		getContentPane().setLayout(groupLayout);
		if("系统管理员".equals(MainFrm.userType.getName())){
			Admin admin =(Admin)MainFrm.userObject;
			currentUserLblNewLabel.setText("系统管理员"+admin.getName());
		}
		else if("社团管理员".equals(MainFrm.userType.getName())){
			
		}
		else{
				
		}

	}

	protected void submitEdit(ActionEvent ae) {
		// TODO Auto-generated method stub
		String olderPassword = oldPasswordTextField.getText().toString();
		String newPassword = newPasswordTextField.getText().toString();
		String confirmPassword = confirmTextField.getText().toString();
		if(StringUtils.isEmpty(olderPassword)){
			JOptionPane.showMessageDialog(this, "旧密码不能为空");
		}
		if(StringUtils.isEmpty(newPassword)){
			JOptionPane.showMessageDialog(this, "新密码不能为空");
			return;
		}
		if(StringUtils.isEmpty(confirmPassword)){
			JOptionPane.showMessageDialog(this, "确认密码不能为空");
			return;
		}
		if(!(confirmPassword.equals(newPassword))){
			JOptionPane.showMessageDialog(this, "两次密码不一致");
			return;
		}
		if("系统管理员".equals(MainFrm.userType.getName())){
			AdminDao adminDao = new AdminDao();
			Admin adminTem = new Admin();
			Admin admin =(Admin) MainFrm.userObject;
			adminTem.setName(admin.getName());
			adminTem.setId(admin.getId());
			adminTem.setPassword(olderPassword);
			JOptionPane.showMessageDialog(this, adminDao.changePassword(adminTem,newPassword));
			adminDao.closeDao();//关闭数据库连接
			return;
		}
	}

	protected void resetValue(ActionEvent ae) {
		// TODO Auto-generated method stub
		oldPasswordTextField.setText("");
		newPasswordTextField.setText("");
		confirmTextField.setText("");
	}
}
