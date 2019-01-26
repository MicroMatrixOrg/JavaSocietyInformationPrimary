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
import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.luobo.dao.DepartmentDao;
import com.luobo.dao.ManagerDao;
import com.luobo.model.Department;
import com.luobo.model.Manager;
import com.luobo.util.FilterComboBox;
import com.luobo.util.StringUtils;
import com.luobo.util.TimeSet;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddDepartmentFrm extends JInternalFrame {
	private JTextField departmentNameTextField;
	private JTextField departmentInfoTextField;
	private JTextField contactTextField;
	private JTextField createdTimeTextField;
	private FilterComboBox masterComboBox;
	private JTextField masterTitletextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddDepartmentFrm frame = new AddDepartmentFrm();
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
	public AddDepartmentFrm() {
		setTitle("\u6DFB\u52A0\u90E8\u95E8");
		setBounds(100, 100, 658, 576);
		
		setClosable(true);
		setIconifiable(true);
		
		JLabel label = new JLabel("\u90E8\u95E8\u540D\u79F0:");
		label.setIcon(new ImageIcon(AddDepartmentFrm.class.getResource("/images/\u90E8\u95E8.png")));
		label.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		
		departmentNameTextField = new JTextField();
		departmentNameTextField.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		departmentNameTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u90E8\u95E8\u4FE1\u606F:");
		label_1.setIcon(new ImageIcon(AddDepartmentFrm.class.getResource("/images/\u90E8\u95E8\u4FE1\u606F.png")));
		label_1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		
		departmentInfoTextField = new JTextField();
		departmentInfoTextField.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		departmentInfoTextField.setColumns(10);
		
		JButton button = new JButton("\u786E\u8BA4\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				addDepartment(ae);
			}
		});
		button.setIcon(new ImageIcon(AddDepartmentFrm.class.getResource("/images/\u786E\u8BA4.png")));
		button.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ag) {
				resetValues(ag);
			}
		});
		button_1.setIcon(new ImageIcon(AddDepartmentFrm.class.getResource("/images/\u91CD\u7F6E.png")));
		button_1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		
		JLabel label_2 = new JLabel("\u8D1F\u8D23\u4EBA:");
		label_2.setIcon(new ImageIcon(AddDepartmentFrm.class.getResource("/images/\u8D1F\u8D23\u4EBA\u59D3\u540D.png")));
		label_2.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		
		JLabel lblNewLabel = new JLabel("\u8054\u7CFB\u65B9\u5F0F:");
		lblNewLabel.setIcon(new ImageIcon(AddDepartmentFrm.class.getResource("/images/\u8054\u7CFB\u65B9\u5F0F.png")));
		lblNewLabel.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		
		contactTextField = new JTextField();
		contactTextField.setEditable(false);
		contactTextField.setText("");
		contactTextField.setForeground(Color.LIGHT_GRAY);
		contactTextField.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		contactTextField.setColumns(10);
		
		JLabel label_3 = new JLabel("\u5EFA\u7ACB\u65F6\u95F4:");
		label_3.setIcon(new ImageIcon(AddDepartmentFrm.class.getResource("/images/\u6210\u7ACB\u65E5\u671F.png")));
		label_3.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		
		createdTimeTextField = new JTextField();
		createdTimeTextField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ae) {
				createdTimeTextField.setCaretPosition(0);
			}
		});
		createdTimeTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ae) {
				if(createdTimeTextField.getForeground()!=Color.BLACK){
					if(createdTimeTextField.getText().equals("xxxx-xx-xx")){
						createdTimeTextField.setText("");
					}
				}
				createdTimeTextField.setForeground(Color.BLACK);
			}
			@Override
			public void keyReleased(KeyEvent ae) {
				if(createdTimeTextField.getText().isEmpty()==true){
					createdTimeTextField.setText("xxxx-xx-xx");
					createdTimeTextField.setCaretPosition(0);
					createdTimeTextField.setForeground(new java.awt.Color(204,204,204));
				}
			}
		});
		createdTimeTextField.setForeground(Color.LIGHT_GRAY);
		createdTimeTextField.setText("xxxx-xx-xx");
		createdTimeTextField.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		createdTimeTextField.setColumns(10);
		
		masterComboBox = new FilterComboBox(Arrays.asList());
		masterComboBox.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		
		masterTitletextField = new JTextField();
		masterTitletextField.setEditable(false);
		masterTitletextField.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		masterTitletextField.setColumns(10);
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(72)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(label)
							.addComponent(label_2)
							.addComponent(lblNewLabel)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_1)
								.addComponent(label_3)))
						.addComponent(button))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(masterComboBox, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(createdTimeTextField, Alignment.LEADING)
								.addComponent(contactTextField, Alignment.LEADING)
								.addComponent(departmentNameTextField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(masterTitletextField, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(departmentInfoTextField, GroupLayout.PREFERRED_SIZE, 328, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(133, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(463, Short.MAX_VALUE)
					.addComponent(button_1)
					.addGap(98))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(58)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(departmentNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(masterComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(masterTitletextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(contactTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(createdTimeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1)
						.addComponent(departmentInfoTextField, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button))
					.addGap(60))
		);
		getContentPane().setLayout(groupLayout);
		setMaster();
		masterTitle();
	}

	protected void addDepartment(ActionEvent ae) {
		// TODO Auto-generated method stub
		String departmentName = departmentNameTextField.getText().toString();
		String departmentInfo = departmentInfoTextField.getText().toString();
		String createTime = createdTimeTextField.getText().toString();
		
		if(StringUtils.isEmpty(departmentName)||StringUtils.isEmpty(departmentInfo)||StringUtils.isEmpty(createTime)){
			JOptionPane.showMessageDialog(this, "≤ø√≈√˚≥∆°¢¡™œµ∑Ω Ω°¢≤ø√≈Ω®¡¢ ±º‰°¢≤ø√≈ºÚΩÈ«ÎÃÓ–¥ÕÍ’˚");
			return;
		}
		
		Manager manager = (Manager)machMasterId();
		Department departmentTem = new Department();
		departmentTem.setName(departmentName);
		departmentTem.setCreateday(createTime);
		departmentTem.setContact(manager.getContact_infomation());
		departmentTem.setMasterId(manager.getId());
		departmentTem.setModificationTime(Timestamp.valueOf(TimeSet.currentDate()));
		departmentTem.setInfo(departmentInfo);
		DepartmentDao departmentDao = new DepartmentDao();
		if(departmentDao.addDepartment(departmentTem)){
			JOptionPane.showMessageDialog(this, "ÃÌº”≥…π¶");
		}
		else{
			JOptionPane.showMessageDialog(this, "ÃÌº” ß∞‹");
			return;
		}
		departmentDao.closeDao();
	}
	
	private void setMaster() {
		// TODO Auto-generated method stub
		ManagerDao managerDao = new ManagerDao();
		List<Manager> managerList=managerDao.getManagerList(new Manager());
		for (Manager manager : managerList) {
			masterComboBox.addItem(manager.toString());
		}
	    managerDao.closeDao();
	}
	
	private Object machMasterId(){
		ManagerDao managerDao = new ManagerDao();
		Manager maTem = new Manager();
		maTem=null;
		List<Manager> managerList=managerDao.getManagerList(new Manager());
		for (Manager manager : managerList) {
			if(manager.toString().equals(masterComboBox.getSelectedItem().toString())){
				maTem = manager;
				return maTem;
			}
		}
		managerDao.closeDao();
		return maTem;
	}
	private void masterTitle(){
		masterComboBox.addItemListener(new java.awt.event.ItemListener(){
        	public void itemStateChanged(java.awt.event.ItemEvent e){
        		if(e.getStateChange() == ItemEvent.SELECTED){
        			Manager ma = (Manager)machMasterId();
        			masterTitletextField.setText(ma.getTitle());
        			contactTextField.setText(ma.getContact_infomation());
        		}
        	}
        });
		
	}
	protected void resetValues(ActionEvent ag) {
		// TODO Auto-generated method stub
		Manager manager = (Manager)machMasterId();
		departmentNameTextField.setText("");
		masterComboBox.setSelectedIndex(0);
		createdTimeTextField.setForeground(Color.LIGHT_GRAY);
		createdTimeTextField.setText("xxxx-xx-xx");
		contactTextField.setText(manager.getContact_infomation());
		contactTextField.setForeground(Color.LIGHT_GRAY);
		departmentInfoTextField.setText("");
	}
}
