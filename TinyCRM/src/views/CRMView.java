package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import beans.CRMBean;

public abstract class CRMView extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel rootPane;
	private JPanel centerPanel;
	
	// Dynamic Labels
	JLabel indexCountLabel;
	JLabel messagesLabel;
	

	private MouseAdapter leftAdapter;
	private MouseAdapter rightAdapter;
	private MouseAdapter editAdapter;
	private MouseAdapter addAdapter;
	private MouseAdapter deleteAdapter;
	private MouseAdapter saveAdapter;
	
	JButton leftButton;
	JButton rightButton;
	JButton editButton;
	JButton addButton;
	JButton deleteButton;
	JButton saveButton;
	
	public CRMView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 474);
		rootPane = new JPanel();
		rootPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(rootPane);
		rootPane.setLayout(new BorderLayout(0, 0));
		
		JPanel topPanel = new JPanel();
		rootPane.add(topPanel, BorderLayout.NORTH);
		topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		messagesLabel = new JLabel("");
		messagesLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		messagesLabel.setForeground(Color.RED);
		topPanel.add(messagesLabel);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setPreferredSize(new Dimension(0, 10));
		verticalStrut.setMinimumSize(new Dimension(0, 10));
		topPanel.add(verticalStrut);
		
		JPanel panel = new JPanel();
		topPanel.add(panel);
		
		JPanel bottomPanel = new JPanel();
		rootPane.add(bottomPanel, BorderLayout.SOUTH);
		bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		Component leftHorizontalStrutBottom = Box.createHorizontalStrut(20);
		bottomPanel.add(leftHorizontalStrutBottom);
		
		leftButton = new JButton("Left");
		bottomPanel.add(leftButton);
		
		rightButton = new JButton("Right");
		bottomPanel.add(rightButton);
		
		editButton = new JButton("Edit");
		bottomPanel.add(editButton);

		addButton = new JButton("Add");
		bottomPanel.add(addButton);
		
		deleteButton = new JButton("Delete");
		bottomPanel.add(deleteButton);
		
		saveButton = new JButton("Save");
		bottomPanel.add(saveButton);
		
		Component rightHorizontalStrutBottom = Box.createHorizontalStrut(20);
		rightHorizontalStrutBottom.setPreferredSize(new Dimension(50, 0));
		bottomPanel.add(rightHorizontalStrutBottom);
		
		indexCountLabel = new JLabel("0/0");
		indexCountLabel.setForeground(Color.RED);
		bottomPanel.add(indexCountLabel);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		rootPane.add(horizontalStrut_2, BorderLayout.WEST);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		rootPane.add(horizontalStrut_3, BorderLayout.EAST);
	}
	
	public JPanel getCenterPanel() {
		return centerPanel;
	}

	public void setCenterPanel(JPanel centerPanel) {
		this.centerPanel = centerPanel;
		getContentPane().add(centerPanel, BorderLayout.CENTER);
	}

	public JLabel getIndexCountLabel() {
		return indexCountLabel;
	}

	public void setIndexCountLabel(JLabel indexCountLabel) {
		this.indexCountLabel = indexCountLabel;
	}

	public String getMessagesLabel() {
		return messagesLabel.getText();
	}

	public void setMessagesLabel(String text) {
		this.messagesLabel.setText(text);
	}

	public MouseAdapter getLeftAdapter() {
		return leftAdapter;
	}
	
	public void setLeftAdapter(MouseAdapter leftAdapter) {
		leftButton.addMouseListener(leftAdapter);
		this.leftAdapter = leftAdapter;
	}

	public MouseAdapter getRightAdapter() {
		return rightAdapter;
	}

	public void setRightAdapter(MouseAdapter rightAdapter) {
		rightButton.addMouseListener(rightAdapter);
		this.rightAdapter = rightAdapter;
	}

	public MouseAdapter getEditAdapter() {
		return editAdapter;
	}

	public void setEditAdapter(MouseAdapter editAdapter) {
		editButton.addMouseListener(editAdapter);
		this.editAdapter = editAdapter;
	}

	public MouseAdapter getAddAdapter() {
		return addAdapter;
	}

	public void setAddAdapter(MouseAdapter addAdapter) {
		addButton.addMouseListener(addAdapter);
		this.addAdapter = addAdapter;
	}

	public MouseAdapter getDeleteAdapter() {
		return deleteAdapter;
	}

	public void setDeleteAdapter(MouseAdapter deleteAdapter) {
		deleteButton.addMouseListener(deleteAdapter);
		this.deleteAdapter = deleteAdapter;
	}

	public MouseAdapter getSaveAdapter() {
		return saveAdapter;
	}

	public void setSaveAdapter(MouseAdapter saveAdapter) {
		saveButton.addMouseListener(saveAdapter);
		this.saveAdapter = saveAdapter;
	}
	
	public abstract void display(CRMBean bean);
	
	public void updateIndexCount(int index, int count) {
		indexCountLabel.setText(index+1 + "/" + count);
	}
}
