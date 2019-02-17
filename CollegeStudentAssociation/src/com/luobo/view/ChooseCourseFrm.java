package com.luobo.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;

import com.luobo.dao.SelectedCourseDao;
import com.luobo.dao.CourseDao;
import com.luobo.dao.DepartmentDao;
import com.luobo.dao.ManagerDao;
import com.luobo.dao.MembersDao;
import com.luobo.model.Course;
import com.luobo.model.Department;
import com.luobo.model.Manager;
import com.luobo.model.Members;
import com.luobo.model.SelectCourse;
import com.luobo.util.StringUtils;

import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import javax.swing.ImageIcon;

public class ChooseCourseFrm extends JInternalFrame {
	private JTable courseInfoListTable;
	private JComboBox membersNameComboBox;
	private JComboBox courseComboBox;
	private JComboBox departmentNameComboBox;
	private JComboBox editCourseComboBox;
	private JLabel currentDepartment;
	private JLabel currentUserNamelblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseCourseFrm frame = new ChooseCourseFrm();
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
	public ChooseCourseFrm() {
		setTitle("\u9009\u8BFE\u754C\u9762");
		setBounds(100, 100, 863, 576);

		setClosable(true);// 关闭界面
		setIconifiable(true);// 最小/大化界面

		JLabel label = new JLabel("\u793E\u5458\u59D3\u540D:");
		label.setIcon(new ImageIcon(ChooseCourseFrm.class.getResource("/images/\u7528\u6237\u540D.png")));
		label.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		JLabel label_1 = new JLabel("\u90E8\u95E8:");
		label_1.setIcon(new ImageIcon(ChooseCourseFrm.class.getResource("/images/\u90E8\u95E8.png")));
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		departmentNameComboBox = new JComboBox();
		departmentNameComboBox.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		JLabel label_2 = new JLabel("\u8BFE\u7A0B:");
		label_2.setIcon(new ImageIcon(ChooseCourseFrm.class.getResource("/images/\u8BFE\u7A0B.png")));
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		courseComboBox = new JComboBox();
		courseComboBox.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		JButton button = new JButton("\u786E\u8BA4\u9009\u8BFE");
		button.setIcon(new ImageIcon(ChooseCourseFrm.class.getResource("/images/\u786E\u8BA4.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ag) {
				chooseCourseAct(ag);
			}
		});
		button.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		JScrollPane scrollPane = new JScrollPane();

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u4FEE\u8BE5\u9009\u8BFE",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));

		membersNameComboBox = new JComboBox();
		membersNameComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ic) {
				memberChangeAct(ic);
			}
		});
		membersNameComboBox.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(43)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(membersNameComboBox, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(departmentNameComboBox, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(courseComboBox, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
							.addGap(41)
							.addComponent(button))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(62)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 685, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(73)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 664, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(75, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(label_1)
						.addComponent(departmentNameComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2)
						.addComponent(courseComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button)
						.addComponent(membersNameComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(49)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);

		JLabel label_3 = new JLabel("\u793E\u5458\u59D3\u540D:");
		label_3.setIcon(new ImageIcon(ChooseCourseFrm.class.getResource("/images/\u7528\u6237\u540D.png")));
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		currentUserNamelblNewLabel = new JLabel("");
		currentUserNamelblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		JLabel lblNewLabel = new JLabel("\u8BFE\u7A0B:");
		lblNewLabel.setIcon(new ImageIcon(ChooseCourseFrm.class.getResource("/images/\u8BFE\u7A0B.png")));
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		editCourseComboBox = new JComboBox();
		editCourseComboBox.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		JLabel label_4 = new JLabel("\u90E8\u95E8:");
		label_4.setIcon(new ImageIcon(ChooseCourseFrm.class.getResource("/images/\u90E8\u95E8.png")));
		label_4.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		JButton button_1 = new JButton("\u4FEE\u6539\u8BFE\u7A0B");
		button_1.setIcon(new ImageIcon(ChooseCourseFrm.class.getResource("/images/\u4FEE\u6539.png")));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ag) {
				editSelectedCourseAct(ag);
			}
		});
		button_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		JButton button_2 = new JButton("\u9000\u9009\u8BFE\u7A0B");
		button_2.setIcon(new ImageIcon(ChooseCourseFrm.class.getResource("/images/\u505C\u9000-\u9009\u4E2D.png")));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ag) {
				dropCourseAct(ag);
			}
		});
		button_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		currentDepartment = new JLabel();
		currentDepartment.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(currentUserNamelblNewLabel)
									.addContainerGap(563, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(158)
											.addComponent(lblNewLabel)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(editCourseComboBox, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
										.addComponent(currentDepartment, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(button_2)
										.addComponent(button_1))
									.addGap(50))))
						.addComponent(label_4)))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(currentUserNamelblNewLabel)
						.addComponent(lblNewLabel)
						.addComponent(editCourseComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1))
					.addGap(28)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(button_2)
						.addComponent(currentDepartment, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(55, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);

		courseInfoListTable = new JTable();
		courseInfoListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ag) {
				setSelectCourseTable(ag);
			}
		});
		courseInfoListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"name", "member's id", "department", "department's id", "course", "course's id"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		courseInfoListTable.getColumnModel().getColumn(1).setPreferredWidth(107);
		courseInfoListTable.getColumnModel().getColumn(2).setPreferredWidth(122);
		courseInfoListTable.getColumnModel().getColumn(3).setPreferredWidth(110);
		courseInfoListTable.getColumnModel().getColumn(4).setPreferredWidth(125);
		courseInfoListTable.getColumnModel().getColumn(5).setPreferredWidth(91);
		courseInfoListTable.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		scrollPane.setViewportView(courseInfoListTable);
		getContentPane().setLayout(groupLayout);
		setCourse();
		setDepartment();
		setMembers();
		setAuthority();
	}

	protected void memberChangeAct(ItemEvent ic) {
		// TODO Auto-generated method stub
		if(ic.getStateChange() == ItemEvent.SELECTED){
			initMembers();
		}
	}

	protected void dropCourseAct(ActionEvent ag) {
		// TODO Auto-generated method stub
		int row = courseInfoListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "请选中要修改的数据！");
			return;
		}
		if(JOptionPane.showConfirmDialog(this, "您确定退选吗？") != JOptionPane.OK_OPTION){
			return;
		}
		Course course = (Course) editCourseComboBox.getSelectedItem();
		DefaultTableModel dft = (DefaultTableModel)courseInfoListTable.getModel();
		int member_id =Integer.parseInt(dft.getValueAt(courseInfoListTable.getSelectedRow(), 1).toString()); 
		int course_id =Integer.parseInt(dft.getValueAt(courseInfoListTable.getSelectedRow(), 5).toString());
		SelectedCourseDao selectedCourseDao = new SelectedCourseDao();
		CourseDao courseDao = new CourseDao();
		if(selectedCourseDao.deleteSelectedCourse(member_id,course_id)){
			if(courseDao.updateSelectNum(course.getId(), -1)){
				JOptionPane.showMessageDialog(this, "退选成功！");
			}
			else{
				JOptionPane.showMessageDialog(this, "退选成功！，但数据并未更新成功");
			}
			
		}
		else{
			JOptionPane.showMessageDialog(this, "退选失败！");
		}
		courseDao.closeDao();
		selectedCourseDao.closeDao();
		initMembers();
	}

	protected void editSelectedCourseAct(ActionEvent ag) {
		// TODO Auto-generated method stub
		int row = courseInfoListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "请选中要修改的数据！");
			return;
		}
		DefaultTableModel dft = (DefaultTableModel)courseInfoListTable.getModel();
		int id =Integer.parseInt(dft.getValueAt(courseInfoListTable.getSelectedRow(), 1).toString()); 
		SelectCourse selectCourse = new SelectCourse();
		int department_id = Integer.parseInt(dft.getValueAt(courseInfoListTable.getSelectedRow(), 3).toString());
		Course course = (Course) editCourseComboBox.getSelectedItem();
		selectCourse.setMember_id(id);
		selectCourse.setDepartment_id(department_id);
		selectCourse.setCourse_id(course.getId());
		SelectedCourseDao selectedCourseDao = new SelectedCourseDao();
		CourseDao courseDao = new CourseDao();
		if(!courseDao.selectEnable(course.getId())){
			JOptionPane.showMessageDialog(this, "该课程人数已满，无法选择");
			return;
		}
		if(selectedCourseDao.isSelected(selectCourse)){
			JOptionPane.showMessageDialog(this, "该课程已经选过，无法选择");
			return;
		}
		
		if(selectedCourseDao.changeSelectedCourse(selectCourse)){
			JOptionPane.showMessageDialog(this, "修改成功！");
		}
		else{
			JOptionPane.showMessageDialog(this, "修改失败！");
		}
		courseDao.closeDao();
		selectedCourseDao.closeDao();
		getSelectCourse(new SelectCourse());
		initMembers();
	}

	protected void chooseCourseAct(ActionEvent ag) {
		// TODO Auto-generated method stub
		SelectCourse selectCourse = new SelectCourse();
		Members members = (Members) membersNameComboBox.getSelectedItem();
		Department department = (Department) departmentNameComboBox.getSelectedItem();
		Course course = (Course) courseComboBox.getSelectedItem();
		selectCourse.setMember_id(members.getId());
		selectCourse.setDepartment_id(department.getId());
		selectCourse.setCourse_id(course.getId());
		CourseDao courseDao = new CourseDao();
		if(!courseDao.selectEnable(course.getId())){
			JOptionPane.showMessageDialog(this, "该课程人数已满，无法选择");
			return;
		}
		SelectedCourseDao chooseCourseDao = new SelectedCourseDao();
		if(chooseCourseDao.isSelected(selectCourse)){
			JOptionPane.showMessageDialog(this, "该课程已经选过，无法选择");
			return;
		}
		if(StringUtils.isEmpty(members.getName())){
			JOptionPane.showMessageDialog(this, "未选择社团成员");
			return;
		}
		if(chooseCourseDao.addChooser(selectCourse)){
			if(courseDao.updateSelectNum(course.getId(),1)){
				JOptionPane.showMessageDialog(this, "选课成功");
			}
			else{
				JOptionPane.showMessageDialog(this, "选课成功,课程信息更新失败");
				return;
			}
		}
		else{
			JOptionPane.showMessageDialog(this, "选课失败");
		}
		courseDao.closeDao();
		chooseCourseDao.closeDao();
		initMembers();
	}

	protected void setSelectCourseTable(MouseEvent ag) {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel) courseInfoListTable
				.getModel();
		currentUserNamelblNewLabel.setText(dft.getValueAt(
				courseInfoListTable.getSelectedRow(), 0).toString());
		String departmentName = dft.getValueAt(
				courseInfoListTable.getSelectedRow(), 2).toString();
		currentDepartment.setText(departmentName);
		String courseName = dft.getValueAt(
				courseInfoListTable.getSelectedRow(), 4).toString();
		for (int i = 0; i < editCourseComboBox.getItemCount(); i++) {
			if (courseName.equals(editCourseComboBox.getItemAt(i).toString())) {
				editCourseComboBox.setSelectedIndex(i);
			}
		}
	}

	private void setMembers() {
		departmentNameComboBox.addItemListener(new java.awt.event.ItemListener(){
	        public void itemStateChanged(java.awt.event.ItemEvent e){
	        	if(e.getStateChange() == ItemEvent.SELECTED){
	        		Department department = (Department)departmentNameComboBox.getSelectedItem();
	        		MembersDao membersDao = new MembersDao();
	        		List<Members> memberList = membersDao.getMembersListByDepartMentId(department.getId());
	        		membersNameComboBox.removeAllItems();
	        		for(Members members:memberList){
	        			membersNameComboBox.addItem(members);
	        		}
	        	}
	        }
	     });
		
	}

	private void setCourse() {
		CourseDao courseDao = new CourseDao();
		List<Course> courseList = courseDao.getCourseList(new Course());
		for (Course course : courseList) {
			courseComboBox.addItem(course);
			editCourseComboBox.addItem(course);
		}
		courseDao.closeDao();
	}

	private void setDepartment() {
		DepartmentDao departmentDao = new DepartmentDao();
		List<Department> departmentList = departmentDao
				.getDepartmentList(new Department());
		for (Department department : departmentList) {
			departmentNameComboBox.addItem(department);
		}
		departmentDao.closeDao();
	}
	
	
	private void getSelectCourse(SelectCourse selectCourse) {
		DefaultTableModel dft = (DefaultTableModel) courseInfoListTable.getModel();
		dft.setRowCount(0);
		SelectedCourseDao chooseCourseDao = new SelectedCourseDao();
		List<SelectCourse> selectCoursesList = chooseCourseDao.getChooseList(selectCourse);
		for (SelectCourse sc : selectCoursesList) {// 遍历
			Vector v = new Vector();//
			v.add(memberNameById(sc.getMember_id()));
			v.add(sc.getMember_id());
			v.add(departmentNameById(sc.getDepartment_id()));
			v.add(sc.getDepartment_id());
			v.add(courseNameById(sc.getCourse_id()));
			v.add(sc.getCourse_id());
			dft.addRow(v);
		}
		chooseCourseDao.closeDao();
	}

	private String memberNameById(int id) {
		MembersDao membersDao = new MembersDao();
		List<Members> membersList = membersDao.getMembersList(new Members());
		membersDao.closeDao();
		for (Members me : membersList) {
			if (me.getId() == id)
				return me.getName();
		}

		return "";
	}

	private String departmentNameById(int id) {
		DepartmentDao departmentDao = new DepartmentDao();
		List<Department> courseList = departmentDao.getDepartmentList(new Department());
		departmentDao.closeDao();
		for (Department de : courseList) {
			if (de.getId() == id)
				return de.getName();
		}

		return "";
	}

	private String courseNameById(int id) {
		CourseDao courseDao = new CourseDao();
		List<Course> courseList = courseDao.getCourseList(new Course());
		courseDao.closeDao();
		for (Course cu : courseList) {
			if (cu.getId() == id)
				return cu.getName();
		}

		return "";
	}
	private void initMembers(){
		Members members = (Members) membersNameComboBox.getSelectedItem();
		SelectCourse selectCourse = new SelectCourse();
		selectCourse.setMember_id(members.getId());
		getSelectCourse(selectCourse);
	}
	private void setAuthority(){
		if("社团成员".equals(MainFrm.userType.toString())){
			Members members = (Members)MainFrm.userObject;
			DepartmentDao  departmentDao = new DepartmentDao();
			int memberDepartment_id = members.getDepartment_id();
			int member_id = members.getId();
			List<Department> departmentList = departmentDao.getDepartmentList(new Department());
			for(int i=0;i<departmentNameComboBox.getItemCount();i++){
				Department department = (Department) departmentNameComboBox.getItemAt(i);
				if(department.getId() == memberDepartment_id){
					departmentNameComboBox.setSelectedIndex(i);
				}
			}
			departmentNameComboBox.setEnabled(false);
			for(int i=0;i<membersNameComboBox.getItemCount();i++){
				Members me =(Members) membersNameComboBox.getItemAt(i);
				if(me.getId()==member_id){
					membersNameComboBox.setSelectedIndex(i);
				}
			}
			membersNameComboBox.setEnabled(false);
		}
	}
}
