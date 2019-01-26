package com.luobo.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

import com.luobo.dao.DepartmentDao;
import com.luobo.dao.MembersDao;
import com.luobo.model.Department;
import com.luobo.model.Manager;
import com.luobo.model.Members;
import com.luobo.util.StringUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class AddMembersFrm extends JInternalFrame {
	private JTextField membersNameTextField;
	private JTextField membersAgeTextField;
	private JTextField membersContactTextField;
	private JRadioButton membersSexManRadioButton;
	private JRadioButton membersSexFemaleRadioButton;
	private JRadioButton membersSexUnknowRadioButton;
	private JComboBox membersDepartmentComboBox ;
	private JTextField membersPasswordTextField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMembersFrm frame = new AddMembersFrm();
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
	public AddMembersFrm() {
		setTitle("\u6DFB\u52A0\u6210\u5458");
		setBounds(100, 100, 425, 430);
		
		setClosable(true);//关闭界面
		setIconifiable(true);//最小/大化界面
		
		JLabel label = new JLabel("\u6210\u5458\u59D3\u540D:");
		label.setIcon(new ImageIcon(AddMembersFrm.class.getResource("/images/\u7528\u6237\u540D.png")));
		label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		membersNameTextField = new JTextField();
		membersNameTextField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		membersNameTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u6210\u5458\u6027\u522B:");
		label_1.setIcon(new ImageIcon(AddMembersFrm.class.getResource("/images/\u6027\u522B.png")));
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		membersSexManRadioButton = new JRadioButton("\u7537");
		membersSexManRadioButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		membersSexFemaleRadioButton = new JRadioButton("\u5973");
		membersSexFemaleRadioButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		membersSexUnknowRadioButton = new JRadioButton("\u4FDD\u5BC6");
		membersSexUnknowRadioButton.setSelected(true);
		membersSexUnknowRadioButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(membersSexManRadioButton);
		bg.add(membersSexFemaleRadioButton);
		bg.add(membersSexUnknowRadioButton);
		
		JLabel label_2 = new JLabel("\u5E74\u9F84:");
		label_2.setIcon(new ImageIcon(AddMembersFrm.class.getResource("/images/\u5E74\u9F84.png")));
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		membersAgeTextField = new JTextField();
		membersAgeTextField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		membersAgeTextField.setColumns(10);
		
		JLabel label_3 = new JLabel("\u8054\u7CFB\u65B9\u5F0F:");
		label_3.setIcon(new ImageIcon(AddMembersFrm.class.getResource("/images/\u8054\u7CFB\u65B9\u5F0F.png")));
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		membersContactTextField = new JTextField();
		membersContactTextField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		membersContactTextField.setColumns(10);
		
		JLabel label_4 = new JLabel("\u90E8\u95E8:");
		label_4.setIcon(new ImageIcon(AddMembersFrm.class.getResource("/images/\u90E8\u95E8.png")));
		label_4.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JButton button = new JButton("\u786E\u8BA4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				submitMembersAct(ae);
			}
		});
		button.setIcon(new ImageIcon(AddMembersFrm.class.getResource("/images/\u767B\u5F55.png")));
		button.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ag) {
				resetValue(ag);
			}
		});
		button_1.setIcon(new ImageIcon(AddMembersFrm.class.getResource("/images/\u91CD\u7F6E.png")));
		button_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		membersDepartmentComboBox = new JComboBox();
		membersDepartmentComboBox.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JLabel label_5 = new JLabel("\u5BC6\u7801:");
		label_5.setIcon(new ImageIcon(AddMembersFrm.class.getResource("/images/\u5BC6\u7801.png")));
		label_5.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		membersPasswordTextField = new JTextField();
		membersPasswordTextField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		membersPasswordTextField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(75)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(label_5)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(button)
							.addGap(78)
							.addComponent(button_1))
						.addComponent(label_4)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label)
							.addGap(18)
							.addComponent(membersNameTextField))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label_3)
								.addComponent(label_1)
								.addComponent(label_2))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(membersSexManRadioButton)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(membersSexFemaleRadioButton)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(membersSexUnknowRadioButton))
								.addComponent(membersPasswordTextField)
								.addComponent(membersDepartmentComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(membersContactTextField, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
								.addComponent(membersAgeTextField))))
					.addGap(253))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(56)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(membersNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(membersSexManRadioButton)
						.addComponent(membersSexFemaleRadioButton)
						.addComponent(membersSexUnknowRadioButton))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(membersAgeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(membersContactTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(membersDepartmentComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_5)
						.addComponent(membersPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addGap(19))
		);
		getContentPane().setLayout(groupLayout);
		setDepartmentInfo();
		setAuthority();
	}

	protected void submitMembersAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		String membersName = membersNameTextField.getText().toString();
		String membersContact = membersContactTextField.getText().toString();
		String membersPassword = membersPasswordTextField.getText().toString();
		int membersAge = 0;
		if(StringUtils.isEmpty(membersName)){
			JOptionPane.showMessageDialog(this, "社员名不能为空");
			return;
		}
		if(StringUtils.isEmpty(membersPassword)){
			JOptionPane.showMessageDialog(this, "社员密码不能为空");
			return;
		}
		if(StringUtils.isEmpty(membersContact)){
			JOptionPane.showMessageDialog(this, "社员联系方式不能为空");
			return;
		}
		try {
			membersAge = Integer.parseInt(membersAgeTextField.getText().toString());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "社员年龄只能为数字");
			return;
		}
		if(membersAge == 0 || membersAge <0){
			JOptionPane.showMessageDialog(this, "请输入正确的年龄");
			return;
		}
		
		Department department= (Department)membersDepartmentComboBox.getSelectedItem();
		String membersSex = membersSexManRadioButton.isSelected()?membersSexManRadioButton.getText():(membersSexFemaleRadioButton.isSelected()?membersSexFemaleRadioButton.getText():membersSexUnknowRadioButton.getText());
		Members members = new Members();
		members.setName(membersName);
		members.setAge(membersAge);
		members.setContact(membersContact);
		members.setPassword(membersPassword);
		members.setSex(membersSex);
		members.setDepartment_id(department.getId());
		MembersDao membersDao = new MembersDao();
		if(membersDao.addMembers(members)){
			JOptionPane.showMessageDialog(this, "添加成功");
			return;
		}
		else{
			JOptionPane.showMessageDialog(this, "添加失败");
			
		}
		resetValue(ae);
		membersDao.closeDao();
		
	}
	
	private void setDepartmentInfo() {
		DepartmentDao departmentDao = new DepartmentDao();
		List<Department> departmentList = departmentDao
				.getDepartmentList(new Department());
		for (Department department : departmentList) {
			membersDepartmentComboBox.addItem(department);
		}
		departmentDao.closeDao();
	}
	
	protected void resetValue(ActionEvent ag) {
		// TODO Auto-generated method stub
		membersNameTextField.setText("");
		membersAgeTextField.setText("");
		membersContactTextField.setText("");
		membersPasswordTextField.setText("");
		membersSexUnknowRadioButton.setSelected(true);
		membersDepartmentComboBox.setSelectedIndex(0);
	}
	private void setAuthority(){
		if("社团管理员".equals(MainFrm.userType.getName())){
			Manager manager = (Manager)MainFrm.userObject;
			int masterId = manager.getId();
			for(int i=0;i<membersDepartmentComboBox.getItemCount();i++){
				Department dep = (Department)membersDepartmentComboBox.getItemAt(i);
				if(dep.getMasterId()==masterId){
					membersDepartmentComboBox.setSelectedIndex(i);
					break;
				}
			}
			membersDepartmentComboBox.setEnabled(false);
		}
	}
}
