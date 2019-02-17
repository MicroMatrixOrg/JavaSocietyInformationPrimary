package com.luobo.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.luobo.dao.DepartmentDao;
import com.luobo.dao.MembersDao;
import com.luobo.model.Department;

public class ImportDataFrm extends JInternalFrame {
	
	private JComboBox departmentNameComboBox;
	private List<Department> departmentList;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImportDataFrm frame = new ImportDataFrm();
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
	public ImportDataFrm() {
		setTitle("\u6570\u636E\u64CD\u4F5C");
		setBounds(100, 100, 450, 300);
		
		setClosable(true);//πÿ±’ΩÁ√Ê
		setIconifiable(true);//◊Ó–°/¥ÛªØΩÁ√Ê
		
		JLabel label = new JLabel("\u90E8\u95E8\u540D:");
		label.setIcon(new ImageIcon(ImportDataFrm.class.getResource("/images/\u90E8\u95E8.png")));
		label.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		
		departmentNameComboBox = new JComboBox();
		departmentNameComboBox.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		
		JButton button = new JButton("\u5BFC\u51FA");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ag) {
				importDepartment(ag);
			}
		});
		button.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		button.setIcon(new ImageIcon(ImportDataFrm.class.getResource("/images/\u5BFC\u51FAExcel.png")));
		
		JButton button_1 = new JButton("\u5168\u90E8\u5BFC\u51FA");
		button_1.setIcon(new ImageIcon(ImportDataFrm.class.getResource("/images/\u5BFC\u51FA\u90E8\u95E8.png")));
		button_1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(70)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(button)
							.addGap(63)
							.addComponent(button_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label)
							.addGap(18)
							.addComponent(departmentNameComboBox, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(131, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(65)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(departmentNameComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addGap(56))
		);
		getContentPane().setLayout(groupLayout);
		setDepartment();
	}

	protected void importDepartment(ActionEvent ag) {
		// TODO Auto-generated method stub
		
		
	}
	private void setDepartment() {
		DepartmentDao departmentDao = new DepartmentDao();
		departmentList = departmentDao.getDepartmentList(new Department());
		for (Department department : departmentList) {
			departmentNameComboBox.addItem(department);
		}
		departmentDao.closeDao();
	}
}
