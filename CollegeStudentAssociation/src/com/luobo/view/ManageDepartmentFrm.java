package com.luobo.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.luobo.dao.DepartmentDao;
import com.luobo.dao.ManagerDao;
import com.luobo.model.Department;
import com.luobo.model.Manager;
import com.luobo.util.StringUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JComboBox;

public class ManageDepartmentFrm extends JInternalFrame {
	private JTextField searchDepartmentNameTextField;
	private JTable departmentListTable;
	private JTextField editDepartmentNameTextField;
	private JTextField editDepartmentInfoTextField;
	private JTextField editContactTextField;
	private JTextField editCreatedTimeTextField;
	private List<Manager> managerList;
	private JTextField masterTitletextField;
	private JComboBox masterComboBox;
	private JButton deleteDepartmentButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageDepartmentFrm frame = new ManageDepartmentFrm();
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
	public ManageDepartmentFrm() {
		setTitle("\u90E8\u95E8\u7BA1\u7406");
		setBounds(100, 100, 857, 624);
		
		setClosable(true);//¹Ø±Õ½çÃæ
		setIconifiable(true);//×îÐ¡/´ó»¯½çÃæ
		
		JLabel label = new JLabel("\u90E8\u95E8\u540D\u79F0:");
		label.setIcon(new ImageIcon(ManageDepartmentFrm.class.getResource("/images/\u90E8\u95E8.png")));
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		searchDepartmentNameTextField = new JTextField();
		searchDepartmentNameTextField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		searchDepartmentNameTextField.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ag) {
				searchDepartmentName(ag);
			}
		});
		button.setIcon(new ImageIcon(ManageDepartmentFrm.class.getResource("/images/\u67E5\u8BE2.png")));
		button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label_1 = new JLabel("\u90E8\u95E8\u540D\u79F0:");
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		label_1.setIcon(new ImageIcon(ManageDepartmentFrm.class.getResource("/images/\u90E8\u95E8.png")));
		
		editDepartmentNameTextField = new JTextField();
		editDepartmentNameTextField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		editDepartmentNameTextField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u90E8\u95E8\u7B80\u4ECB:");
		label_2.setIcon(new ImageIcon(ManageDepartmentFrm.class.getResource("/images/\u90E8\u95E8\u4FE1\u606F.png")));
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		editDepartmentInfoTextField = new JTextField();
		editDepartmentInfoTextField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		editDepartmentInfoTextField.setColumns(10);
		
		JButton submitButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ag) {
				submitEditDepartment(ag);
			}
		});
		submitButton.setIcon(new ImageIcon(ManageDepartmentFrm.class.getResource("/images/\u786E\u8BA4.png")));
		submitButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JButton resetValuebutton = new JButton("\u91CD\u7F6E");
		resetValuebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ag) {
				resetValue(ag);
			}
		});
		resetValuebutton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		resetValuebutton.setIcon(new ImageIcon(ManageDepartmentFrm.class.getResource("/images/\u91CD\u7F6E.png")));
		
		deleteDepartmentButton = new JButton("\u5220\u9664\u90E8\u95E8");
		deleteDepartmentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ag) {
				deleteDepartment(ag);
			}
		});
		deleteDepartmentButton.setIcon(new ImageIcon(ManageDepartmentFrm.class.getResource("/images/\u5220 \u9664.png")));
		deleteDepartmentButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JLabel label_3 = new JLabel("\u8D1F\u8D23\u4EBA:");
		label_3.setIcon(new ImageIcon(ManageDepartmentFrm.class.getResource("/images/\u8D1F\u8D23\u4EBA\u59D3\u540D.png")));
		label_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JLabel label_4 = new JLabel("\u8054\u7CFB\u65B9\u5F0F:");
		label_4.setIcon(new ImageIcon(ManageDepartmentFrm.class.getResource("/images/\u8054\u7CFB\u65B9\u5F0F.png")));
		label_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		editContactTextField = new JTextField();
		editContactTextField.setEditable(false);
		editContactTextField.setForeground(Color.GRAY);
		editContactTextField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		editContactTextField.setColumns(10);
		
		JLabel label_5 = new JLabel("\u6210\u7ACB\u65E5\u671F:");
		label_5.setIcon(new ImageIcon(ManageDepartmentFrm.class.getResource("/images/\u6210\u7ACB\u65E5\u671F.png")));
		label_5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		editCreatedTimeTextField = new JTextField();
		editCreatedTimeTextField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ag) {
				editCreatedTimeTextField.setCaretPosition(0);
			}
		});
		editCreatedTimeTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ag) {
				if(editCreatedTimeTextField.getForeground()!=Color.BLACK){
					if(editCreatedTimeTextField.getText().equals("1911-04-29")){
						editCreatedTimeTextField.setText("");
					}
				}
				editCreatedTimeTextField.setForeground(Color.BLACK);
			}
			@Override
			public void keyReleased(KeyEvent ae) {
				if(editCreatedTimeTextField.getText().isEmpty()==true){
					editCreatedTimeTextField.setText("1911-04-29");
					editCreatedTimeTextField.setCaretPosition(0);
					editCreatedTimeTextField.setForeground(new java.awt.Color(204,204,204));
				}
			}
		});
		editCreatedTimeTextField.setForeground(Color.LIGHT_GRAY);
		editCreatedTimeTextField.setText("1911-04-29");
		editCreatedTimeTextField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		editCreatedTimeTextField.setColumns(10);
		
		masterComboBox = new JComboBox();
		masterComboBox.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		masterTitletextField = new JTextField();
		masterTitletextField.setEditable(false);
		masterTitletextField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		masterTitletextField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(67)
							.addComponent(label)
							.addGap(18)
							.addComponent(searchDepartmentNameTextField, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(button))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(53)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 729, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(label_3)
										.addComponent(label_1)
										.addComponent(label_4)
										.addComponent(label_5))
									.addGap(16)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
												.addComponent(editContactTextField)
												.addComponent(editDepartmentNameTextField, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
												.addComponent(editCreatedTimeTextField))
											.addGap(18)
											.addComponent(label_2))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(masterComboBox, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(masterTitletextField, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)))
									.addGap(25)
									.addComponent(editDepartmentInfoTextField, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(resetValuebutton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(deleteDepartmentButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(submitButton, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))))))
					.addContainerGap(59, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(47)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(searchDepartmentNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addGap(29)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_1)
								.addComponent(editDepartmentNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(submitButton)
								.addComponent(label_2))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(deleteDepartmentButton)
								.addComponent(label_3)
								.addComponent(masterComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(masterTitletextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(resetValuebutton)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(label_4)
									.addComponent(editContactTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(25)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_5)
								.addComponent(editCreatedTimeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(editDepartmentInfoTextField, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)))
					.addGap(146))
		);
		
		departmentListTable = new JTable();
		departmentListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ag) {
				getDepartmnetList(ag);
			}
		});
		departmentListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "name", "master", "contact", "info", "createday", "modification_time"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		departmentListTable.getColumnModel().getColumn(1).setPreferredWidth(90);
		departmentListTable.getColumnModel().getColumn(2).setPreferredWidth(108);
		departmentListTable.getColumnModel().getColumn(3).setPreferredWidth(122);
		departmentListTable.getColumnModel().getColumn(4).setPreferredWidth(127);
		departmentListTable.getColumnModel().getColumn(5).setPreferredWidth(160);
		departmentListTable.getColumnModel().getColumn(6).setPreferredWidth(141);
		departmentListTable.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		scrollPane.setViewportView(departmentListTable);
		getContentPane().setLayout(groupLayout);
		setAuthority();
		//setTable(new Department());
		
	}

	protected void deleteDepartment(ActionEvent ag) {
		// TODO Auto-generated method stub
		if(JOptionPane.showConfirmDialog(this, "ÄúÈ·ÈÏÉ¾³ýÂð£¿") != JOptionPane.OK_OPTION){
			return;
		}
		int index=departmentListTable.getSelectedRow();
		if(index == -1){
			JOptionPane.showMessageDialog(this,"Î´Ñ¡ÖÐ");
			return;
		}
		else{
			DefaultTableModel dft =(DefaultTableModel)departmentListTable.getModel();
			int id = Integer.parseInt(dft.getValueAt(departmentListTable.getSelectedRow(), 0).toString());
			DepartmentDao depDao = new DepartmentDao();
			if(depDao.deleteDepartment(id)){
				JOptionPane.showMessageDialog(this, "É¾³ý³É¹¦");
			}else{
				JOptionPane.showMessageDialog(this, "É¾³ýÊ§°Ü");
			}
			setTable(new Department());
			depDao.closeDao();
		}
	}

	protected void searchDepartmentName(ActionEvent ag) {
		// TODO Auto-generated method stub
		Department dep = new Department();
		String departmentName = searchDepartmentNameTextField.getText().toString();
		dep.setName(departmentName);
		setTable(dep);
	}

	protected void submitEditDepartment(ActionEvent ag) {
		// TODO Auto-generated method stub
		int index = departmentListTable.getSelectedRow();
		if(index<0){
			JOptionPane.showMessageDialog(this, "Î´Ñ¡ÖÐ");
			return;
		}
		DefaultTableModel dft =(DefaultTableModel)departmentListTable.getModel();
		String departmentName = dft.getValueAt(departmentListTable.getSelectedRow(), 1).toString();
		String departmentMasterContact = dft.getValueAt(departmentListTable.getSelectedRow(), 3).toString();
		String departmentInfo = dft.getValueAt(departmentListTable.getSelectedRow(), 4).toString();
		String departmentCreateTime = dft.getValueAt(departmentListTable.getSelectedRow(), 5).toString();
		String editDepartmentName = editDepartmentNameTextField.getText().toString();
		String editDepartmentMasterContact = editContactTextField.getText().toString();
		String editDepartmentInfo = editDepartmentInfoTextField.getText().toString();
		String editDepartmentCreatedTime = editCreatedTimeTextField.getText().toString();
		if(StringUtils.isEmpty(editDepartmentName)){
			JOptionPane.showMessageDialog(this,"²¿ÃÅÃû³Æ²»ÄÜÐÞ¸ÄÎª¿Õ");
			return;
		}
		if(StringUtils.isEmpty(editDepartmentMasterContact)){
			JOptionPane.showMessageDialog(this,"ÁªÏµ·½Ê½²»ÄÜÐÞ¸ÄÎª¿Õ");
			return;
		}
		if(StringUtils.isEmpty(editDepartmentCreatedTime)){
			JOptionPane.showMessageDialog(this,"²¿ÃÅ½¨Á¢ÈÕÆÚ²»ÄÜÐÞ¸ÄÎª¿Õ");
			return;
		}
		if(StringUtils.isEmpty(editDepartmentInfo)){
			JOptionPane.showMessageDialog(this,"²¿ÃÅ¼ò½é²»ÄÜÐÞ¸ÄÎª¿Õ");
			return;
		}
		/*if(departmentName.equals(editDepartmentName) && departmentInfo.equals(editDepartmentInfo)){
			JOptionPane.showMessageDialog(this,"Äú²¢Î´×öÈÎºÎÐÞ¸Ä");
			return;
		}*/
		int id = Integer.parseInt(dft.getValueAt(departmentListTable.getSelectedRow(), 0).toString());
		Manager ma = (Manager)masterComboBox.getSelectedItem();
		Department dep = new Department();
		dep.setId(id);
		dep.setName(editDepartmentName);
		dep.setMasterId(ma.getId());
		dep.setContact(editDepartmentMasterContact);
		dep.setCreateday(editDepartmentCreatedTime);
		dep.setInfo(editDepartmentInfo);
		DepartmentDao depDao = new DepartmentDao();
		
		if(depDao.editDepartment(dep)){
			JOptionPane.showMessageDialog(this, "ÐÞ¸Ä³É¹¦");
		}
		else{
			JOptionPane.showMessageDialog(this, "ÐÞ¸ÄÊ§°Ü");
			return ;
		}
		setTable(new Department());
	}

	protected void getDepartmnetList(MouseEvent ag) {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel)departmentListTable.getModel();
		editDepartmentNameTextField.setText(dft.getValueAt(departmentListTable.getSelectedRow(), 1).toString());
		editContactTextField.setText(dft.getValueAt(departmentListTable.getSelectedRow(),3 ).toString());
		editDepartmentInfoTextField.setText(dft.getValueAt(departmentListTable.getSelectedRow(), 4).toString());
		editCreatedTimeTextField.setText(dft.getValueAt(departmentListTable.getSelectedRow(),5 ).toString());
		String masterName = dft.getValueAt(departmentListTable.getSelectedRow(), 2).toString();
		for(int i=0;i<masterComboBox.getItemCount();i++){
			if(masterName.equals(masterComboBox.getItemAt(i).toString())){
				masterComboBox.setSelectedIndex(i);
			}
		}
	}

	protected void resetValue(ActionEvent ag) {
		// TODO Auto-generated method stub
		editDepartmentNameTextField.setText("");
		masterComboBox.setSelectedIndex(0);
		editCreatedTimeTextField.setText("1911-04-29");
		editDepartmentInfoTextField.setText("");
	}
	
	private void setTable(Department dep){
		DefaultTableModel dft = (DefaultTableModel)departmentListTable.getModel();
		dft.setRowCount(0);
		DepartmentDao depDao = new DepartmentDao();
		List<Department> depList = depDao.getDepartmentList(dep);
		for(Department depTem:depList){
			Vector ve = new Vector();
			ve.add(depTem.getId());
			ve.add(depTem.getName());
			ve.add(getMasterNameById(depTem.getMasterId()));
			ve.add(depTem.getContact());
			ve.add(depTem.getInfo());
			ve.add(depTem.getCreateday());
			ve.add(depTem.getModificationTime());
			dft.addRow(ve);
		}
		depDao.closeDao();
		setMaster();
		masterTitle();
	}
	private String getMasterNameById(int id){
		String name = "";
		ManagerDao managerDao = new ManagerDao();
		managerList = managerDao.getManagerList(new Manager());
		for(Manager ma :managerList){
			if(ma.getId() == id){
				return ma.getName();
			}
		}
		return name;
	}
	
	private void setMaster() {
		// TODO Auto-generated method stub
		ManagerDao managerDao = new ManagerDao();
		List<Manager> managerList=managerDao.getManagerList(new Manager());
		for (Manager manager : managerList) {
			masterComboBox.addItem(manager);
			editContactTextField.setText(manager.getContact_infomation());
		}
	    managerDao.closeDao();
	}
	
	private void masterTitle(){
		masterComboBox.addItemListener(new java.awt.event.ItemListener(){
        	public void itemStateChanged(java.awt.event.ItemEvent e){
        		if(e.getStateChange() == ItemEvent.SELECTED){
        			Manager ma = (Manager)masterComboBox.getSelectedItem();
        			masterTitletextField.setText(ma.getTitle());
        		}
        	}
        });
	}
	private void setAuthority(){
		if("ÉçÍÅ¹ÜÀíÔ±".equals(MainFrm.userType.getName())){
			Manager manager = (Manager)MainFrm.userObject;
			DepartmentDao departmentDao = new DepartmentDao();
			int masterId = manager.getId();
			String masterName = getMasterNameById(masterId);
			List<Department> departmentList = departmentDao.getDepartmentList(new Department());
			for(Department department:departmentList){
				if(department.getMasterId() == masterId){
					searchDepartmentNameTextField.setText(department.getName());
					break;
				}
			}
			searchDepartmentNameTextField.setEnabled(false);
			for(int i=0;i<masterComboBox.getItemCount();i++){
				Manager ma = (Manager)masterComboBox.getItemAt(i);
				if(masterName.equals(ma.getName())){
					masterComboBox.setSelectedIndex(i);
					break;
				}
			}
			departmentDao.closeDao();
			editDepartmentNameTextField.setEnabled(false);
			masterComboBox.setEnabled(false);
			masterTitle();
			deleteDepartmentButton.setEnabled(false);
	}
  }
}
