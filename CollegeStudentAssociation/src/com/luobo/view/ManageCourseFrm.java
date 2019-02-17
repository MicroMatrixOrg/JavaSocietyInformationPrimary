package com.luobo.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Color;

import javax.swing.JTextArea;

import com.luobo.dao.CourseDao;
import com.luobo.dao.DepartmentDao;
import com.luobo.dao.ManagerDao;
import com.luobo.dao.MembersDao;
import com.luobo.model.Course;
import com.luobo.model.Department;
import com.luobo.model.Manager;
import com.luobo.model.Members;
import com.luobo.util.StringUtils;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class ManageCourseFrm extends JInternalFrame {
	private JTextField courseNameTextField;
	private JTable courseListTable;
	private JTextField editCourseNameTextField;
	private JTextField editMaxUserTextField;
	private JTextField editStartingTextField;
	private JComboBox editDepartmentComboBox;
	private JComboBox editTeacherComboBox;
	private JTextArea editInfoTextArea;
	private List<Department> departmentList;
	private List<Manager> managerList;
	private JComboBox courseDepartmentcomboBox;
	private JComboBox teacherComboBox ;
	private JButton editCourseButton;
	private JButton deleteCourseButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageCourseFrm frame = new ManageCourseFrm();
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
	public ManageCourseFrm() {
		setTitle("\u8BFE\u7A0B\u7BA1\u7406");
		setBounds(100, 100, 811, 630);
		
		setClosable(true);//¹Ø±Õ½çÃæ
		setIconifiable(true);//×îÐ¡/´ó»¯½çÃæ
		
		JLabel lblNewLabel = new JLabel("\u8BFE\u7A0B\u540D\u79F0:");
		lblNewLabel.setIcon(new ImageIcon(ManageCourseFrm.class.getResource("/images/\u8BFE\u7A0B.png")));
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		courseNameTextField = new JTextField();
		courseNameTextField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		courseNameTextField.setColumns(10);
		
		courseDepartmentcomboBox = new JComboBox();
		courseDepartmentcomboBox.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1 = new JLabel("\u90E8\u95E8:");
		lblNewLabel_1.setIcon(new ImageIcon(ManageCourseFrm.class.getResource("/images/\u90E8\u95E8.png")));
		lblNewLabel_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JLabel label = new JLabel("\u6559\u5E08:");
		label.setIcon(new ImageIcon(ManageCourseFrm.class.getResource("/images/\u8BFE\u7A0B\u987E\u95EE.png")));
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		teacherComboBox = new JComboBox();
		teacherComboBox.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JButton searchButton = new JButton("\u641C\u7D22");
		searchButton.setIcon(new ImageIcon(ManageCourseFrm.class.getResource("/images/\u67E5\u8BE2.png")));
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ag) {
				searchCourseAct(ag);
			}
		});
		searchButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u8BFE\u7A0B\u4FE1\u606F\u7F16\u8F91", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(32)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(courseNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(courseDepartmentcomboBox, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(teacherComboBox, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addComponent(searchButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(42)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 663, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(52, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(courseNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(courseDepartmentcomboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label)
						.addComponent(teacherComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchButton))
					.addGap(28)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel label_1 = new JLabel("\u8BFE\u7A0B\u540D:");
		label_1.setIcon(new ImageIcon(ManageCourseFrm.class.getResource("/images/\u8BFE\u7A0B.png")));
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		editCourseNameTextField = new JTextField();
		editCourseNameTextField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		editCourseNameTextField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u6559\u5E08:");
		label_2.setIcon(new ImageIcon(ManageCourseFrm.class.getResource("/images/\u8BFE\u7A0B\u987E\u95EE.png")));
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JLabel label_3 = new JLabel("\u90E8\u95E8:");
		label_3.setIcon(new ImageIcon(ManageCourseFrm.class.getResource("/images/\u90E8\u95E8.png")));
		label_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		editDepartmentComboBox = new JComboBox();
		editDepartmentComboBox.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		editTeacherComboBox = new JComboBox();
		editTeacherComboBox.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JLabel label_4 = new JLabel("\u6700\u5927\u4EBA\u6570:");
		label_4.setIcon(new ImageIcon(ManageCourseFrm.class.getResource("/images/\u6700\u5927.png")));
		label_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		editMaxUserTextField = new JTextField();
		editMaxUserTextField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		editMaxUserTextField.setColumns(10);
		
		JLabel label_5 = new JLabel("\u5F00\u8BFE\u65E5\u671F:");
		label_5.setIcon(new ImageIcon(ManageCourseFrm.class.getResource("/images/\u6210\u7ACB\u65E5\u671F.png")));
		label_5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		editStartingTextField = new JTextField();
		editStartingTextField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		editStartingTextField.setColumns(10);
		
		JLabel label_6 = new JLabel("\u8BFE\u7A0B\u7B80\u4ECB:");
		label_6.setIcon(new ImageIcon(ManageCourseFrm.class.getResource("/images/\u8BFE\u7A0B\u4ECB\u7ECD.png")));
		label_6.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		editInfoTextArea = new JTextArea();
		editInfoTextArea.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		
		editCourseButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		editCourseButton.setIcon(new ImageIcon(ManageCourseFrm.class.getResource("/images/\u786E\u8BA4.png")));
		editCourseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ag) {
				submitEditAct(ag);
			}
		});
		editCourseButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		deleteCourseButton = new JButton("\u5220\u9664\u8BFE\u7A0B");
		deleteCourseButton.setIcon(new ImageIcon(ManageCourseFrm.class.getResource("/images/\u5220 \u9664.png")));
		deleteCourseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ag) {
				deleteCourseAct(ag);
			}
		});
		deleteCourseButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1)
						.addComponent(label_2)
						.addComponent(label_3))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(editDepartmentComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(editTeacherComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(editCourseNameTextField))
					.addGap(45)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_4)
							.addGap(18)
							.addComponent(editMaxUserTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
							.addComponent(editCourseButton))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_5)
							.addGap(18)
							.addComponent(editStartingTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
							.addComponent(deleteCourseButton))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_6)
							.addGap(18)
							.addComponent(editInfoTextArea, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)))
					.addGap(28))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_1)
								.addComponent(editCourseNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_4)
								.addComponent(editMaxUserTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_2)
								.addComponent(editTeacherComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_5)
								.addComponent(editStartingTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(label_3)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
									.addComponent(editDepartmentComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(label_6)
									.addComponent(editInfoTextArea, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(20)
							.addComponent(editCourseButton)
							.addGap(27)
							.addComponent(deleteCourseButton)))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		courseListTable = new JTable();
		courseListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ae) {
				setCourseList(ae);
			}
		});
		courseListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "name", "teacher", "max_user", "department", "selected_man", "starting", "info"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		courseListTable.getColumnModel().getColumn(0).setPreferredWidth(71);
		courseListTable.getColumnModel().getColumn(1).setPreferredWidth(84);
		courseListTable.getColumnModel().getColumn(2).setPreferredWidth(88);
		courseListTable.getColumnModel().getColumn(3).setPreferredWidth(98);
		courseListTable.getColumnModel().getColumn(4).setPreferredWidth(97);
		courseListTable.getColumnModel().getColumn(5).setPreferredWidth(114);
		courseListTable.getColumnModel().getColumn(6).setPreferredWidth(104);
		courseListTable.getColumnModel().getColumn(7).setPreferredWidth(197);
		courseListTable.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		scrollPane.setViewportView(courseListTable);
		getContentPane().setLayout(groupLayout);
		setTable(new Course());
		setTeacher();
		setDepartment();
	}

	protected void deleteCourseAct(ActionEvent ag) {
		// TODO Auto-generated method stub
		int row = courseListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "ÇëÑ¡ÖÐÒªÐÞ¸ÄµÄÊý¾Ý£¡");
			return;
		}
		if(JOptionPane.showConfirmDialog(this, "ÄúÈ·¶¨É¾³ýÃ´£¿") != JOptionPane.OK_OPTION){
			return;
		}
		CourseDao courseDao = new CourseDao();
		if(courseDao.deleteCourse(Integer.parseInt(courseListTable.getValueAt(courseListTable.getSelectedRow(), 0).toString()))){
			JOptionPane.showMessageDialog(this, "É¾³ý³É¹¦£¡");
		}
		else{
			JOptionPane.showMessageDialog(this, "É¾³ýÊ§°Ü£¡");
		}
		courseDao.closeDao();
		setTable(new Course());
	}

	protected void submitEditAct(ActionEvent ag) {
		// TODO Auto-generated method stub
		int row = courseListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "ÇëÑ¡ÖÐÒªÐÞ¸ÄµÄÊý¾Ý£¡");
			return;
		}
		String courseName = editCourseNameTextField.getText().toString();
		String max_User = editMaxUserTextField.getText().toString();
		String starting = editStartingTextField.getText().toString();
		String courseInfo = editInfoTextArea.getText().toString();
		int maxUser = 0 ;
		if(StringUtils.isEmpty(max_User)){
			JOptionPane.showMessageDialog(this, "×î´óÈËÊý±ØÐëÉèÖÃ£¡");
			return;
		}
		try {
			maxUser = Integer.parseInt(max_User);
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "ÇëÊäÈëÊý×Ö£¡");
			return;
		}
		if(maxUser<0){
			JOptionPane.showMessageDialog(this, "ÇëÊäÈëÕýÕûÊý£¡");
			return;
		}
		if(StringUtils.isEmpty(courseName)){
			JOptionPane.showMessageDialog(this, "¿Î³ÌÃû²»ÄÜÎª¿Õ£¡");
			return;
		}
		if(StringUtils.isEmpty(starting)){
			JOptionPane.showMessageDialog(this, "ÉÏ¿ÎÊ±¼ä²»ÄÜÎª¿Õ£¡");
			return;
		}
		DefaultTableModel dft = (DefaultTableModel)courseListTable.getModel();
		int id = Integer.parseInt(dft.getValueAt(courseListTable.getSelectedRow(), 0).toString());
		Manager manager = (Manager)editTeacherComboBox.getSelectedItem();
		Department department = (Department)editDepartmentComboBox.getSelectedItem();
		Course course = new Course();
		course.setId(id);
		course.setName(courseName);
		course.setTeacher_id(manager.getId());
		course.setDepartment_id(department.getId());
		course.setMax_user(maxUser);
		course.setDate(starting);
		course.setInfo(courseInfo);
		CourseDao courseDao = new CourseDao();
		if(courseDao.changeCourse(course)){
			JOptionPane.showMessageDialog(this, "ÐÞ¸Ä³É¹¦£¡");
		}
		else{
			JOptionPane.showMessageDialog(this, "ÐÞ¸ÄÊ§°Ü£¡");
		}
		courseDao.closeDao();
		setTable(new Course());
	}

	protected void searchCourseAct(ActionEvent ag) {
		// TODO Auto-generated method stub
		Course course = new Course();
		String courseName = courseNameTextField.getText().toString();
		Manager manager = (Manager)teacherComboBox.getSelectedItem();
		int teacher_id = manager.getId();
		Department department = (Department)courseDepartmentcomboBox.getSelectedItem();
		int department_id = department.getId();
		course.setName(courseName);
		course.setTeacher_id(teacher_id);
		course.setDepartment_id(department_id);
		setTable(course);
	}

	protected void setCourseList(MouseEvent ae) {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel)courseListTable.getModel();
		editCourseNameTextField.setText(dft.getValueAt(courseListTable.getSelectedRow(), 1).toString());
		editMaxUserTextField.setText(dft.getValueAt(courseListTable.getSelectedRow(), 3).toString());
		editStartingTextField.setText(dft.getValueAt(courseListTable.getSelectedRow(), 6).toString());
		editInfoTextArea.setText(dft.getValueAt(courseListTable.getSelectedRow(),7).toString());
		String departmentName = dft.getValueAt(courseListTable.getSelectedRow(), 4).toString();
		for(int i = 0; i<editDepartmentComboBox.getItemCount();i++){
			if(departmentName.equals(editDepartmentComboBox.getItemAt(i).toString())){
				editDepartmentComboBox.setSelectedIndex(i);
			}
		}
		String teacherName = dft.getValueAt(courseListTable.getSelectedRow(), 2).toString();
		for(int i = 0 ;i<editTeacherComboBox.getItemCount();i++){
			if(teacherName.equals(editTeacherComboBox.getItemAt(i).toString())){
				editTeacherComboBox.setSelectedIndex(i);
			}
		}
	}
	private void setTable(Course course){
		DefaultTableModel dft = (DefaultTableModel)courseListTable.getModel();
		dft.setRowCount(0);
		CourseDao courseDao = new CourseDao();
		List<Course> courseList = courseDao.getCourseList(course);
		for (Course co : courseList) {//±éÀú
			Vector v = new Vector();//
			v.add(co.getId());
			v.add(co.getName());
			v.add(getTeacherNameById(co.getTeacher_id()));
			v.add(co.getMax_user());
			v.add(getDepartmnetNameById(co.getDepartment_id()));
			v.add(co.getSelected_man());
			v.add(co.getDate());
			v.add(co.getInfo());
			dft.addRow(v);
		}
		courseDao.closeDao();
	}
	private String getDepartmnetNameById(int id){
		DepartmentDao departmentDao = new DepartmentDao();
		departmentList = departmentDao.getDepartmentList(new Department());
		departmentDao.closeDao();
		for (Department dp : departmentList) {
			if(dp.getId()==id)
				return dp.getName();
		}
		
		return "";
	}
	private String getTeacherNameById(int id){
		ManagerDao ManagerDao = new ManagerDao();
		managerList = ManagerDao.getManagerList(new Manager());
		ManagerDao.closeDao();
		for (Manager ma : managerList) {
			if(ma.getId()==id)
				return ma.getName();
		}
		
		return "";
	}
	private void setDepartment(){
		DepartmentDao departmentDao = new DepartmentDao();
		departmentList = departmentDao.getDepartmentList(new Department());
		for (Department department : departmentList) {
			courseDepartmentcomboBox.addItem(department);
			editDepartmentComboBox.addItem(department);
		}
		departmentDao.closeDao();
	}
	private void setTeacher(){
		ManagerDao managerDao = new ManagerDao();
		managerList = managerDao.getManagerList(new Manager());
		for(Manager manager:managerList){
			teacherComboBox.addItem(manager);
			editTeacherComboBox.addItem(manager);
		}
		managerDao.closeDao();
	}
}
