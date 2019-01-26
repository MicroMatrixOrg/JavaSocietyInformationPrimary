package com.luobo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import com.luobo.dao.AdminDao;
import com.luobo.dao.ManagerDao;
import com.luobo.dao.MembersDao;
import com.luobo.model.Admin;
import com.luobo.model.Manager;
import com.luobo.model.Members;
import com.luobo.model.UserType;
import com.luobo.util.FilterComboBox;
import com.luobo.util.MusicDemo;
import com.luobo.util.StringUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Arrays;

public class LoginFrm extends JFrame {

	private JPanel contentPane;
	private JTextField userNametextField;
	private JPasswordField userPasswordField;
	private JComboBox userTypeComboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();//调用美化的库
					LoginFrm frame = new LoginFrm();
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
	public LoginFrm() {
		
		setTitle("\u767B\u5F55\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		setLocationRelativeTo(null);//让窗体剧居中
		
		JLabel lblNewLabel = new JLabel("\u8BA1\u7B97\u673A\u793E\u56E2\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/\u5FBD\u7AE0.jpg")));
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 18));
		
		JLabel label = new JLabel("\u7528\u6237\u540D:");
		label.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/\u7528\u6237\u540D.png")));
		label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		userNametextField = new JTextField();
		userNametextField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		userNametextField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u5BC6    \u7801:");
		label_1.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/\u5BC6\u7801.png")));
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JLabel label_2 = new JLabel("\u7528\u6237\u7C7B\u578B:");
		label_2.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/\u7528\u6237\u7C7B\u578B.png")));
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		userPasswordField = new JPasswordField();
		userPasswordField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		
		userTypeComboBox = new JComboBox(new DefaultComboBoxModel(new UserType[] {UserType.ADMIN, UserType.MANGER, UserType.MEMBER}));
		userTypeComboBox.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JButton LoginButton = new JButton("\u767B\u5F55");
		LoginButton.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/\u767B\u5F55.png")));
		LoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ag) {
				loginAc(ag);
			}
		});
		LoginButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JButton resetButton = new JButton("\u91CD\u7F6E");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				resetValue(ae);
			}
		});
		resetButton.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/\u91CD\u7F6E.png")));
		resetButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(143)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label)
								.addComponent(label_1)
								.addComponent(label_2))
							.addGap(22)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(userTypeComboBox, 0, 166, Short.MAX_VALUE)
								.addComponent(userPasswordField, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
								.addComponent(userNametextField, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))))
					.addGap(122))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(152)
					.addComponent(LoginButton)
					.addGap(106)
					.addComponent(resetButton)
					.addContainerGap(143, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(userNametextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(userPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(userTypeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(LoginButton)
						.addComponent(resetButton))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		//new MusicDemo();// 背景音乐
	}

	protected void loginAc(ActionEvent ag) {
		// TODO Auto-generated method stub
		String userName = userNametextField.getText().toString();
		String userPassword = userPasswordField.getText().toString();
		UserType userType = (UserType)userTypeComboBox.getSelectedItem();
		if(StringUtils.isEmpty(userName)||StringUtils.isEmpty(userPassword)){
			JOptionPane.showMessageDialog(this, "用户名或密码不能为空");
			return;
		}
		if("系统管理员".equals(userType.getName())){
			Admin admin = new Admin();
			AdminDao adminDao = new AdminDao();
			Admin adminTem = new Admin();
			adminTem.setName(userName);
			adminTem.setPassword(userPassword);
			admin = adminDao.login(adminTem);
			adminDao.closeDao();
			if(admin == null ){
				JOptionPane.showMessageDialog(this, "用户名或密码错误");
				return;
			}
			JOptionPane.showMessageDialog(this, "欢迎"+userType.getName()+admin.getName()+"登录本系统");
			this.dispose();
			MainFrm  mainFrm = new MainFrm(userType,admin);
			mainFrm.setVisible(true);
			mainFrm.setExtendedState(mainFrm.MAXIMIZED_BOTH);//打开最大化设置
			/*new MainFrm(userType,admin).setVisible(true);*/
			
		}
		else if("社团管理员".equals(userType.getName())){
			Manager manager = new Manager();
			ManagerDao managerDao = new ManagerDao();
			Manager managerTem = new Manager();
			managerTem.setName(userName);
			managerTem.setPassword(userPassword);
			manager = managerDao.login(managerTem);
			managerDao.closeDao();
			if(manager == null ){
				JOptionPane.showMessageDialog(this, "用户名或密码错误");
				return;
			}
			JOptionPane.showMessageDialog(this, "欢迎"+userType.getName()+manager.getName()+"登录本系统");
			this.dispose();
			MainFrm  mainFrm = new MainFrm(userType,manager);
			mainFrm.setVisible(true);
			mainFrm.setExtendedState(mainFrm.MAXIMIZED_BOTH);//打开最大化设置
		}
		else{
			Members members = new Members();
			MembersDao membersDao = new MembersDao();
			Members membersTem = new Members();
			membersTem.setName(userName);
			membersTem.setPassword(userPassword);
			members = membersDao.login(membersTem);
			membersDao.closeDao();
			if(members == null ){
				JOptionPane.showMessageDialog(this, "用户名或密码错误");
				return;
			}
			JOptionPane.showMessageDialog(this, "欢迎"+userType.getName()+members.getName()+"登录本系统");
			this.dispose();
			MainFrm  mainFrm = new MainFrm(userType,members);
			mainFrm.setVisible(true);
			mainFrm.setExtendedState(mainFrm.MAXIMIZED_BOTH);//打开最大化设置
		}
		
	}

	protected void resetValue(ActionEvent ae) {
		// TODO Auto-generated method stub
		userNametextField.setText("");
		userPasswordField.setText("");
		userTypeComboBox.setSelectedIndex(0);
	}
		
}
