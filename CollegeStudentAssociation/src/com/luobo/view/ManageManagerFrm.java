package com.luobo.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.luobo.dao.ManagerDao;
import com.luobo.model.Department;
import com.luobo.model.Manager;
import com.luobo.model.Members;
import com.luobo.util.StringUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

public class ManageManagerFrm extends JInternalFrame {
	private JTextField searchNameTextField;
	private JTable managerListTable;
	private JTextField editNameTextField;
	private JTextField editPasswordTextField;
	private JTextField editTitleTextField;
	private JTextField editContactInfomationTextField;
	private JButton deleteButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageManagerFrm frame = new ManageManagerFrm();
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
	public ManageManagerFrm() {
		setTitle("\u5E72\u5458\u5217\u8868");
		setBounds(100, 100, 650, 510);
		
		setClosable(true);
		setIconifiable(true);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("\u5E72\u5458\u59D3\u540D:");
		label.setIcon(new ImageIcon(ManageManagerFrm.class.getResource("/images/\u7528\u6237\u540D.png")));
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		searchNameTextField = new JTextField();
		searchNameTextField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		searchNameTextField.setColumns(10);
		
		JButton button = new JButton("\u67E5\u627E");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ag) {
				searchNameAct(ag);
			}
		});
		button.setIcon(new ImageIcon(ManageManagerFrm.class.getResource("/images/\u67E5\u8BE2.png")));
		button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JLabel label_1 = new JLabel("\u59D3\u540D:");
		label_1.setIcon(new ImageIcon(ManageManagerFrm.class.getResource("/images/\u7528\u6237\u540D.png")));
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		editNameTextField = new JTextField();
		editNameTextField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		editNameTextField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u5BC6\u7801:");
		label_2.setIcon(new ImageIcon(ManageManagerFrm.class.getResource("/images/\u5BC6\u7801.png")));
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		editPasswordTextField = new JTextField();
		editPasswordTextField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		editPasswordTextField.setColumns(10);
		
		JLabel label_3 = new JLabel("\u804C\u52A1:");
		label_3.setIcon(new ImageIcon(ManageManagerFrm.class.getResource("/images/\u804C\u52A1.png")));
		label_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		editTitleTextField = new JTextField();
		editTitleTextField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		editTitleTextField.setColumns(10);
		
		JButton button_1 = new JButton("\u786E\u8BA4\u4FEE\u6539");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				submitManagerAct(ae);
			}
		});
		button_1.setIcon(new ImageIcon(ManageManagerFrm.class.getResource("/images/\u786E\u8BA4.png")));
		button_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		deleteButton = new JButton("\u5220\u9664");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				deleteManagerAct(ae);
			}
		});
		deleteButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		deleteButton.setIcon(new ImageIcon(ManageManagerFrm.class.getResource("/images/\u5220 \u9664.png")));
		
		JLabel label_4 = new JLabel("\u8054\u7CFB\u65B9\u5F0F:");
		label_4.setIcon(new ImageIcon(ManageManagerFrm.class.getResource("/images/\u8054\u7CFB\u65B9\u5F0F.png")));
		label_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		editContactInfomationTextField = new JTextField();
		editContactInfomationTextField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		editContactInfomationTextField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(62)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(button_1)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(deleteButton))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label_2)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(editPasswordTextField))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label_1)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(editNameTextField, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label_3)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(editTitleTextField, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label_4)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(editContactInfomationTextField, 0, 0, Short.MAX_VALUE))))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(87)
							.addComponent(label)
							.addGap(18)
							.addComponent(searchNameTextField, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
							.addGap(87)
							.addComponent(button))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(40)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 489, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(96, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(searchNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label)
						.addComponent(button))
					.addGap(32)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(editNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3)
						.addComponent(editTitleTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(editPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4)
						.addComponent(editContactInfomationTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(deleteButton))
					.addGap(24))
		);
		
		managerListTable = new JTable();
		managerListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ag) {
				selectTableRow(ag);
			}
		});
		managerListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "name", "password", "title", "concact_infomation"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		managerListTable.getColumnModel().getColumn(0).setPreferredWidth(71);
		managerListTable.getColumnModel().getColumn(1).setPreferredWidth(119);
		managerListTable.getColumnModel().getColumn(2).setPreferredWidth(153);
		managerListTable.getColumnModel().getColumn(3).setPreferredWidth(109);
		managerListTable.getColumnModel().getColumn(4).setPreferredWidth(193);
		scrollPane.setViewportView(managerListTable);
		getContentPane().setLayout(groupLayout);
		setAuthority();
	}

	protected void submitManagerAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		int row = managerListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "ÇëÑ¡ÖÐÒªÐÞ¸ÄµÄÊý¾Ý£¡");
			return;
		}
		String managerName = editNameTextField.getText().toString();
		String managerPassword = editPasswordTextField.getText().toString();
		String managerTitle = editTitleTextField.getText().toString();
		String managerContactInfomation = editContactInfomationTextField.getText().toString();
		if(StringUtils.isEmpty(managerName)){
			JOptionPane.showMessageDialog(this, "ÇëÌîÐ´¸ÉÔ±ÐÕÃû£¡");
			return;
		}
		if(StringUtils.isEmpty(managerPassword)){
			JOptionPane.showMessageDialog(this, "ÇëÌîÐ´ÃÜÂë£¡");
			return;
		}
		if(StringUtils.isEmpty(managerTitle)){
			JOptionPane.showMessageDialog(this, "ÇëÌîÐ´Ö°Îñ£¡");
			return;
		}
		if(StringUtils.isEmpty(managerContactInfomation)){
			JOptionPane.showMessageDialog(this, "ÇëÌîÐ´ÁªÏµ·½Ê½£¡");
			return;
		}
		DefaultTableModel dft = (DefaultTableModel)managerListTable.getModel();
		int id = Integer.parseInt(dft.getValueAt(managerListTable.getSelectedRow(), 0).toString());
		Manager manager = new Manager();
		manager.setName(managerName);
		manager.setPassword(managerPassword);
		manager.setTitle(managerTitle);
		manager.setContact_infomation(managerContactInfomation);
		manager.setId(id);
		ManagerDao managerDao = new ManagerDao();
		if(managerDao.changeManager(manager)){
			JOptionPane.showMessageDialog(this, "¸üÐÂ³É¹¦£¡");
		}else{
			JOptionPane.showMessageDialog(this, "¸üÐÂÊ§°Ü£¡");
		}
		managerDao.closeDao();
		setTable(new Manager());
	}

	protected void deleteManagerAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		int row = managerListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "ÇëÑ¡ÖÐÒªÉ¾³ýµÄÊý¾Ý£¡");
			return;
		}
		if(JOptionPane.showConfirmDialog(this, "ÄúÈ·¶¨É¾³ýÃ´£¿") != JOptionPane.OK_OPTION){
			return;
		}
		ManagerDao managerDao = new ManagerDao();
		if(managerDao.deleteManager(Integer.parseInt(managerListTable.getValueAt(row, 0).toString()))){
			JOptionPane.showMessageDialog(this, "É¾³ý³É¹¦£¡");
		}else{
			JOptionPane.showMessageDialog(this, "É¾³ýÊ§°Ü£¡");
		}
		managerDao.closeDao();
		setTable(new Manager());
	}

	protected void selectTableRow(MouseEvent ag) {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel)managerListTable.getModel();
		editNameTextField.setText(dft.getValueAt(managerListTable.getSelectedRow(), 1).toString());
		editPasswordTextField.setText(dft.getValueAt(managerListTable.getSelectedRow(), 2).toString());
		editTitleTextField.setText(dft.getValueAt(managerListTable.getSelectedRow(), 3).toString());
		editContactInfomationTextField.setText(dft.getValueAt(managerListTable.getSelectedRow(), 4).toString());
		
	}

	protected void searchNameAct(ActionEvent ag) {
		// TODO Auto-generated method stub
		Manager manager = new Manager();
		manager.setName(searchNameTextField.getText().toString());
		setTable(manager);
	}
	private void setTable(Manager manager){
		DefaultTableModel dft = (DefaultTableModel) managerListTable.getModel();
		dft.setRowCount(0);
		ManagerDao managerDao = new ManagerDao();
		List<Manager> managerList = managerDao.getManagerList(manager);
		for (Manager m : managerList) {
			Vector v = new Vector();
			v.add(m.getId());
			v.add(m.getName());
			v.add(m.getPassword());
			v.add(m.getTitle());
			v.add(m.getContact_infomation());
			dft.addRow(v);
		}
		managerDao.closeDao();
	}
	private void setAuthority(){
		if("ÉçÍÅ¹ÜÀíÔ±".equals(MainFrm.userType.getName())){
			Manager manager = (Manager)MainFrm.userObject;
			searchNameTextField.setText(manager.getName());
			searchNameTextField.setEnabled(false);
			deleteButton.setEnabled(false);
			editTitleTextField.setEnabled(false);
			setTable(manager);
		}
		else{
			setTable(new Manager());
		}
			
	}
}
