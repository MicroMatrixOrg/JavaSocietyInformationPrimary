package com.luobo.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.JRadioButton;

import com.luobo.dao.DepartmentDao;
import com.luobo.dao.MembersDao;
import com.luobo.model.Department;
import com.luobo.model.Manager;
import com.luobo.model.Members;
import com.luobo.util.StringUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ManageMembersFrm extends JInternalFrame {
	private JTextField searchNameTextField;
	private JTextField editNameTextField;
	private JTextField editMembersAgeTextField;
	private JTextField editMembersContactTextField;
	private JTextField editMembersPasswordTextField;
	private JTable membersListTable;
	private JRadioButton editMembersManRadioButton;
	private JRadioButton editMembersFemaleRadioButton;
	private JRadioButton editMembersUnknowRadioButton;
	private ButtonGroup memeberSexGroup;
	private JComboBox searchDepartmentNameComboBox;
	private JComboBox editDepartmentComboBox;
	private List<Department> departmentList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageMembersFrm frame = new ManageMembersFrm();
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
	public ManageMembersFrm() {
		setTitle("\u7BA1\u7406\u5B66\u751F");
		setBounds(100, 100, 712, 523);
		
		setClosable(true);//关闭界面
		setIconifiable(true);//最小/大化界面
		
		JLabel label = new JLabel("\u59D3\u540D:");
		label.setIcon(new ImageIcon(ManageMembersFrm.class.getResource("/images/\u7528\u6237\u540D.png")));
		label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		searchNameTextField = new JTextField();
		searchNameTextField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		searchNameTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u90E8\u95E8:");
		label_1.setIcon(new ImageIcon(ManageMembersFrm.class.getResource("/images/\u90E8\u95E8.png")));
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		searchDepartmentNameComboBox = new JComboBox();
		searchDepartmentNameComboBox.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ag) {
				searchAct(ag);
			}
		});
		button.setIcon(new ImageIcon(ManageMembersFrm.class.getResource("/images/\u67E5\u8BE2.png")));
		button.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label_2 = new JLabel("\u59D3\u540D:");
		label_2.setIcon(new ImageIcon(ManageMembersFrm.class.getResource("/images/\u7528\u6237\u540D.png")));
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editNameTextField = new JTextField();
		editNameTextField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		editNameTextField.setColumns(10);
		
		JLabel label_3 = new JLabel("\u6027\u522B:");
		label_3.setIcon(new ImageIcon(ManageMembersFrm.class.getResource("/images/\u6027\u522B.png")));
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JLabel label_4 = new JLabel("\u5E74\u9F84:");
		label_4.setIcon(new ImageIcon(ManageMembersFrm.class.getResource("/images/\u5E74\u9F84.png")));
		label_4.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editMembersAgeTextField = new JTextField();
		editMembersAgeTextField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		editMembersAgeTextField.setColumns(10);
		
		JLabel label_5 = new JLabel("\u90E8\u95E8:");
		label_5.setIcon(new ImageIcon(ManageMembersFrm.class.getResource("/images/\u90E8\u95E8.png")));
		label_5.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editDepartmentComboBox = new JComboBox();
		editDepartmentComboBox.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JLabel label_6 = new JLabel("\u8054\u7CFB\u65B9\u5F0F:");
		label_6.setIcon(new ImageIcon(ManageMembersFrm.class.getResource("/images/\u8054\u7CFB\u65B9\u5F0F.png")));
		label_6.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editMembersContactTextField = new JTextField();
		editMembersContactTextField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		editMembersContactTextField.setColumns(10);
		
		JLabel label_7 = new JLabel("\u5BC6\u7801:");
		label_7.setIcon(new ImageIcon(ManageMembersFrm.class.getResource("/images/\u5BC6\u7801.png")));
		label_7.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editMembersPasswordTextField = new JTextField();
		editMembersPasswordTextField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		editMembersPasswordTextField.setColumns(10);
		
		JButton sumbitButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		sumbitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ag) {
				sumbitEditAct(ag);
			}
		});
		sumbitButton.setIcon(new ImageIcon(ManageMembersFrm.class.getResource("/images/\u786E\u8BA4.png")));
		sumbitButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JButton deleteButton = new JButton("\u5220\u9664\u793E\u5458");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ag) {
				deleteMembersAct(ag);
			}
		});
		deleteButton.setIcon(new ImageIcon(ManageMembersFrm.class.getResource("/images/\u5220 \u9664.png")));
		deleteButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editMembersManRadioButton = new JRadioButton("\u7537");
		editMembersManRadioButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editMembersFemaleRadioButton = new JRadioButton("\u5973");
		editMembersFemaleRadioButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editMembersUnknowRadioButton = new JRadioButton("\u4FDD\u5BC6");
		editMembersUnknowRadioButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		memeberSexGroup = new ButtonGroup();
		memeberSexGroup.add(editMembersFemaleRadioButton);
		memeberSexGroup.add(editMembersManRadioButton);
		memeberSexGroup.add(editMembersUnknowRadioButton);
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(100)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(searchNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(searchDepartmentNameComboBox, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
							.addGap(34)
							.addComponent(button))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(43)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 611, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(30)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_2)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(editNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_3)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(editMembersManRadioButton)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(editMembersFemaleRadioButton)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(editMembersUnknowRadioButton))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_4)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(editMembersAgeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(label_5)
										.addComponent(label_6))
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(3)
											.addComponent(editDepartmentComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(groupLayout.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(editMembersPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(editMembersContactTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
								.addComponent(label_7))
							.addPreferredGap(ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(sumbitButton)
								.addComponent(deleteButton))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addContainerGap(42, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(searchNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(searchDepartmentNameComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addGap(46)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(editNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5)
						.addComponent(editDepartmentComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(sumbitButton))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(label_6)
						.addComponent(editMembersContactTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(editMembersManRadioButton)
						.addComponent(editMembersFemaleRadioButton)
						.addComponent(editMembersUnknowRadioButton))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_4)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(editMembersAgeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_7)
							.addComponent(editMembersPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(deleteButton)))
					.addContainerGap(41, Short.MAX_VALUE))
		);
		
		membersListTable = new JTable();
		membersListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ag) {
				getMembersListAct(ag);
			}
		});
		membersListTable.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		membersListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "name", "sex", "age", "department", "contact", "password"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		membersListTable.getColumnModel().getColumn(1).setPreferredWidth(97);
		membersListTable.getColumnModel().getColumn(4).setPreferredWidth(122);
		membersListTable.getColumnModel().getColumn(5).setPreferredWidth(131);
		membersListTable.getColumnModel().getColumn(6).setPreferredWidth(133);
		scrollPane.setViewportView(membersListTable);
		getContentPane().setLayout(groupLayout);
		setAuthority();
		setTable(new Members());
		setDepartment();
	}

	

	protected void deleteMembersAct(ActionEvent ag) {
		// TODO Auto-generated method stub
		
		int row = membersListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "请选中要修改的数据！");
			return;
		}
		if(JOptionPane.showConfirmDialog(this, "您确定删除么？") != JOptionPane.OK_OPTION){
			return;
		}
		MembersDao membersDao = new MembersDao();
		if(membersDao.deleteMembers(Integer.parseInt(membersListTable.getValueAt(membersListTable.getSelectedRow(), 0).toString()))){
			JOptionPane.showMessageDialog(this, "删除成功！");
		}
		else{
			JOptionPane.showMessageDialog(this, "删除失败！");
		}
		membersDao.closeDao();
		setTable(new Members());
	}

	protected void sumbitEditAct(ActionEvent ag) {
		// TODO Auto-generated method stub
		int row = membersListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "请选中要修改的数据！");
			return;
		}
		String membersName = editNameTextField.getText().toString();
		String membersAge = editMembersAgeTextField.getText().toString();
		String membersPassword = editMembersPasswordTextField.getText().toString();
		String membersContact = editMembersContactTextField.getText().toString();
		int age =0;
		if(StringUtils.isEmpty(membersName)){
			JOptionPane.showMessageDialog(this, "社员姓名不能设置为空");
			return;
		}
		try {
			age = Integer.parseInt(membersAge);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this,"社员年龄只能为数字" );
			return;
		}
		if(age<0||age==0){
			JOptionPane.showMessageDialog(this,"社员年龄不能小于0或者等于0" );
			return;
		}
		if(StringUtils.isEmpty(membersPassword)){
			JOptionPane.showMessageDialog(this, "社员密码不能设置为空");
			return;
		}
		if(StringUtils.isEmpty(membersContact)){
			JOptionPane.showMessageDialog(this, "社员联系方式不能设置为空");
			return;
		}
		DefaultTableModel dft = (DefaultTableModel)membersListTable.getModel();
		int id = Integer.parseInt(dft.getValueAt(membersListTable.getSelectedRow(), 0).toString());
		Members members = new Members();
		members.setId(id);
		members.setName(membersName);
		members.setAge(age);
		members.setPassword(membersPassword);
		members.setContact(membersContact);
		Department dep = (Department) editDepartmentComboBox.getSelectedItem();
		members.setDepartment_id(dep.getId());
		if(editMembersManRadioButton.isSelected())members.setSex(editMembersManRadioButton.getText().toString());
		if(editMembersFemaleRadioButton.isSelected())members.setSex(editMembersFemaleRadioButton.getText().toString());
		if(editMembersUnknowRadioButton.isSelected())members.setSex(editMembersUnknowRadioButton.getText().toString());
		MembersDao membersDao = new MembersDao();
		if(membersDao.changeMembers(members)){
			JOptionPane.showMessageDialog(this, "更新成功！");
		}
		else{
			JOptionPane.showMessageDialog(this, "更新失败！");
		}
		membersDao.closeDao();
		setTable(new Members());
		
	}

	protected void searchAct(ActionEvent ag) {
		// TODO Auto-generated method stub
		Members members =new Members();
		members.setName(searchNameTextField.getText().toString());
		Department department = (Department)searchDepartmentNameComboBox.getSelectedItem();
		members.setDepartment_id(department.getId());
		setTable(members);
	}

	protected void getMembersListAct(MouseEvent ag) {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel)membersListTable.getModel();
		editNameTextField.setText(dft.getValueAt(membersListTable.getSelectedRow(), 1).toString());
		editMembersAgeTextField.setText(dft.getValueAt(membersListTable.getSelectedRow(), 3).toString());
		editMembersContactTextField.setText(dft.getValueAt(membersListTable.getSelectedRow(), 5).toString());
		editMembersPasswordTextField.setText(dft.getValueAt(membersListTable.getSelectedRow(),6).toString());
		String departmentName = dft.getValueAt(membersListTable.getSelectedRow(), 4).toString();
		for(int i = 0; i<editDepartmentComboBox.getItemCount();i++){
			if(departmentName.equals(editDepartmentComboBox.getItemAt(i).toString())){
				editDepartmentComboBox.setSelectedIndex(i);
			}
		}
		String memebersSex = dft.getValueAt(membersListTable.getSelectedRow(), 2).toString();
		memeberSexGroup.clearSelection();
		if(memebersSex.equals(editMembersManRadioButton.getText())) editMembersManRadioButton.setSelected(true);
		if(memebersSex.equals(editMembersFemaleRadioButton.getText())) editMembersFemaleRadioButton.setSelected(true);
		if(memebersSex.equals(editMembersUnknowRadioButton.getText())) editMembersUnknowRadioButton.setSelected(true);
	}
	
	private void setDepartment() {
		DepartmentDao departmentDao = new DepartmentDao();
		departmentList = departmentDao.getDepartmentList(new Department());
		for (Department department : departmentList) {
			searchDepartmentNameComboBox.addItem(department);
			editDepartmentComboBox.addItem(department);
		}
		departmentDao.closeDao();
	}
	private void setTable(Members members){
		DefaultTableModel dft = (DefaultTableModel)membersListTable.getModel();
		dft.setRowCount(0);
		MembersDao membersDao = new MembersDao();
		List<Members> membersList = membersDao.getMembersList(members);
		for (Members me : membersList) {//遍历
			Vector v = new Vector();//
			v.add(me.getId());
			v.add(me.getName());
			v.add(me.getSex());
			v.add(me.getAge());
			v.add(getDepartmnetNameById(me.getDepartment_id()));
			v.add(me.getContact());
			v.add(me.getPassword());
			dft.addRow(v);
		}
		membersDao.closeDao();
	}
	
	private String getDepartmnetNameById(int id){
		DepartmentDao departmentDao = new DepartmentDao();
		departmentList = departmentDao.getDepartmentList(new Department());
		for (Department dp : departmentList) {
			if(dp.getId()==id)
				return dp.getName();
		}
		return "";
	}
	private void setAuthority(){
		if("社团管理员".equals(MainFrm.userType.getName())){
			Manager manager = (Manager)MainFrm.userObject;
			int masterId = manager.getId();
			for(int i=0;i<searchDepartmentNameComboBox.getItemCount();i++){
				Department dep = (Department)searchDepartmentNameComboBox.getItemAt(i);
				if(dep.getMasterId()==masterId){
					searchDepartmentNameComboBox.setSelectedIndex(i);
					break;
				}
			}
			searchDepartmentNameComboBox.setEnabled(false);
			for(int i=0;i<editDepartmentComboBox.getItemCount();i++){
				Department dep = (Department)editDepartmentComboBox.getItemAt(i);
				if(dep.getMasterId()==masterId){
					editDepartmentComboBox.setSelectedIndex(i);
					break;
				}
			}
			editDepartmentComboBox.setEnabled(false);
		}
	}
}
