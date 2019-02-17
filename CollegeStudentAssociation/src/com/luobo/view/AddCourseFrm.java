package com.luobo.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import com.luobo.dao.CourseDao;
import com.luobo.dao.DepartmentDao;
import com.luobo.dao.ManagerDao;
import com.luobo.model.Course;
import com.luobo.model.Department;
import com.luobo.model.Manager;
import com.luobo.model.Members;
import com.luobo.util.StringUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class AddCourseFrm extends JInternalFrame {
	private JTextField courseNameTextField;
	private JTextField courseMaxMembersTextField;
	private JTextField courseTimeTextField;
	private JComboBox courseTeacherComboBox;
	private JComboBox courseDepartmentComboBox;
	private JTextArea courseInfoTextArea;
	private List<Department> departmentList;
	private List<Manager> managerList;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCourseFrm frame = new AddCourseFrm();
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
	public AddCourseFrm() {
		setTitle("\u6DFB\u52A0\u8BFE\u7A0B");
		setBounds(100, 100, 542, 489);
		
		setClosable(true);//关闭界面
		setIconifiable(true);//最小/大化界面
		
		JLabel label = new JLabel("\u8BFE\u7A0B\u540D\u79F0:");
		label.setIcon(new ImageIcon(AddCourseFrm.class.getResource("/images/\u8BFE\u7A0B.png")));
		label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		courseNameTextField = new JTextField();
		courseNameTextField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		courseNameTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u6388\u8BFE\u8001\u5E08:");
		label_1.setIcon(new ImageIcon(AddCourseFrm.class.getResource("/images/\u8D1F\u8D23\u4EBA\u59D3\u540D.png")));
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		courseTeacherComboBox = new JComboBox();
		courseTeacherComboBox.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JLabel label_2 = new JLabel("\u5F00\u8BFE\u90E8\u95E8:");
		label_2.setIcon(new ImageIcon(AddCourseFrm.class.getResource("/images/\u90E8\u95E8.png")));
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		courseDepartmentComboBox = new JComboBox();
		
		JLabel label_3 = new JLabel("\u6700\u5927\u4EBA\u6570:");
		label_3.setIcon(new ImageIcon(AddCourseFrm.class.getResource("/images/\u6700\u5927.png")));
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		courseMaxMembersTextField = new JTextField();
		courseMaxMembersTextField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		courseMaxMembersTextField.setColumns(10);
		
		JLabel label_4 = new JLabel("\u8BFE\u7A0B\u4ECB\u7ECD:");
		label_4.setIcon(new ImageIcon(AddCourseFrm.class.getResource("/images/\u8BFE\u7A0B\u4ECB\u7ECD.png")));
		label_4.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		courseInfoTextArea = new JTextArea();
		courseInfoTextArea.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JButton button = new JButton("\u786E\u8BA4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ag) {
				addCourseAct(ag);
			}
		});
		button.setIcon(new ImageIcon(AddCourseFrm.class.getResource("/images/\u786E\u8BA4.png")));
		button.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ag) {
				resetValue(ag);
			}
		});
		button_1.setIcon(new ImageIcon(AddCourseFrm.class.getResource("/images/\u91CD\u7F6E.png")));
		button_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JLabel label_5 = new JLabel("\u8BFE\u7A0B\u65F6\u95F4:");
		label_5.setIcon(new ImageIcon(AddCourseFrm.class.getResource("/images/\u8BFE\u7A0B\u65F6\u95F4\u8BBE\u7F6E.png")));
		label_5.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		courseTimeTextField = new JTextField();
		courseTimeTextField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		courseTimeTextField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(128)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_5)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_4)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(courseInfoTextArea, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(label_2)
									.addComponent(label)
									.addComponent(label_1))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(courseTeacherComboBox, 0, 140, Short.MAX_VALUE)
									.addComponent(courseNameTextField)
									.addComponent(courseTimeTextField)
									.addComponent(courseDepartmentComboBox, 0, 140, Short.MAX_VALUE)))
							.addGroup(groupLayout.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(label_3)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(courseMaxMembersTextField)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(button)
							.addGap(126)
							.addComponent(button_1)))
					.addGap(82))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(courseNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_5)
						.addComponent(courseTimeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(courseTeacherComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(label_2))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(courseDepartmentComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(courseMaxMembersTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(courseInfoTextArea, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		setDepartment();
		setAuthorize();
	}

	protected void addCourseAct(ActionEvent ag) {
		// TODO Auto-generated method stub
		String courseName = courseNameTextField.getText().toString();
		String courseData = courseTimeTextField.getText().toString();
		String maxUser = courseMaxMembersTextField.getText().toString();
		String courseInfo = courseInfoTextArea.getText().toString();
		int maxUsers = 0;
		if(StringUtils.isEmpty(courseName)){
			JOptionPane.showMessageDialog(this, "课程名不能为空");
			return;
		}
		try {
			maxUsers=Integer.parseInt(maxUser);
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "最大人数只能为数字");
			return;
		}
		if(maxUsers<0){
			JOptionPane.showMessageDialog(this, "最大人数只能为正数");
			return;
		}
		
		Manager manager = (Manager)courseTeacherComboBox.getSelectedItem();
		Department department = (Department)courseDepartmentComboBox.getSelectedItem();
		CourseDao courseDao = new CourseDao();
		Course course = new Course();
		course.setName(courseName);
		course.setDate(courseData);
		course.setMax_user(maxUsers);
		course.setTeacher_id(manager.getId());
		course.setDepartment_id(department.getId());
		course.setInfo(courseInfo);
		if(courseDao.addCourse(course)){
			JOptionPane.showMessageDialog(this, "添加成功");
		}
		else{
			JOptionPane.showMessageDialog(this, "添加失败");
		}
		courseDao.closeDao();
		
	}

	protected void resetValue(ActionEvent ag) {
		// TODO Auto-generated method stub
		courseNameTextField.setText("");
		courseTimeTextField.setText("");
		courseTeacherComboBox.setSelectedIndex(0);
		courseDepartmentComboBox.setSelectedIndex(0);
		courseMaxMembersTextField.setText("");
		courseInfoTextArea.setText("");
	}
	private void setDepartment() {
		DepartmentDao departmentDao = new DepartmentDao();
		ManagerDao managerDao = new ManagerDao();
		managerList = managerDao.getManagerList(new Manager());
		managerDao.closeDao();
		for(Manager manager:managerList){
			courseTeacherComboBox.addItem(manager);
		}
		departmentList = departmentDao.getDepartmentList(new Department());
		departmentDao.closeDao();
		for (Department department : departmentList) {
			courseDepartmentComboBox.addItem(department);
		}
			
	}
	private void setAuthorize(){
		if("社团管理员".equals(MainFrm.userType.getName())){
			Manager manager = (Manager)MainFrm.userObject;
			int masterId = manager.getId();
			for(int i=0;i<courseDepartmentComboBox.getItemCount();i++){
				Department dep = (Department)courseDepartmentComboBox.getItemAt(i);
				if(dep.getMasterId()==masterId){
					courseDepartmentComboBox.setSelectedIndex(i);
					break;
				}
			}
			courseDepartmentComboBox.setEnabled(false);
		}
	}
	
}
