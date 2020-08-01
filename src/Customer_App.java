import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Customer_App {

	private JFrame frame;
	private JTextField ID;
	private JPasswordField password;
	private JTextField textField_name;
	private JTextField textField_age;
	private JTextField textField_phone;
	private JTextField textField_birthday;
	private JTextField search;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer_App window = new Customer_App();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Customer_App() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setSize(800,600);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setJMenuBar(menuBar());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		String[][] data = Customer.getCustomer();
		String[] headers = new String[] {"Name","Phone","Gender","Age","Note"};
		
		JPanel mainPanel = new JPanel();
		JPanel tablePanel = new JPanel();
		tablePanel.setBackground(new Color(255, 255, 255));
		tablePanel.setBounds(0, 0, 800, 556);
		tablePanel.setLayout(null);
		JTable table = new JTable(data,headers);
		table.setRowHeight(30);
		table.setFont(new Font("Sanserif",Font.BOLD, 15));
		table.setAlignmentX(0);
		table.setSize(800,400);
		table.setPreferredScrollableViewportSize(new Dimension(800,400));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(41, 73, 715, 420);
		tablePanel.add(scrollPane);
		tablePanel.setVisible(false);
		frame.getContentPane().add(tablePanel);
		
		search = new JTextField();
		search.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		search.setBounds(41, 16, 715, 26);
		search.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		tablePanel.add(search);
		search.setColumns(10);
		
		JButton register = new JButton("Register");
		register.setBounds(610, 505, 117, 29);
		register.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tablePanel.setVisible(false);
				mainPanel.setVisible(true);
			}
			
		});
		tablePanel.add(register);
		search.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				String val = search.getText();
				TableRowSorter<TableModel> trs = new TableRowSorter<>(table.getModel());
				table.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(val));
			}
		});
		
		TableColumnModel columnModels = table.getColumnModel();
		
		
		mainPanel.setBackground(new Color(255, 255, 255));
		mainPanel.setBounds(0, 0, 800, 577);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		mainPanel.setVisible(false);
		
		JLabel lblNewLabel_3 = new JLabel("Main Panel");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 48));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(227, 13, 317, 59);
		mainPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("NAME");
		lblNewLabel_4.setFont(new Font("Lao Sangam MN", Font.PLAIN, 22));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(75, 102, 122, 36);
		mainPanel.add(lblNewLabel_4);
		
		JLabel lblAge = new JLabel("AGE");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setFont(new Font("Lao Sangam MN", Font.PLAIN, 22));
		lblAge.setBounds(75, 199, 122, 36);
		mainPanel.add(lblAge);
		
		JLabel lblGender = new JLabel("GENDER");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("Lao Sangam MN", Font.PLAIN, 22));
		lblGender.setBounds(75, 289, 122, 36);
		mainPanel.add(lblGender);
		
		JLabel lblPhone = new JLabel("PHONE");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setFont(new Font("Lao Sangam MN", Font.PLAIN, 22));
		lblPhone.setBounds(387, 102, 122, 36);
		mainPanel.add(lblPhone);
		
		JLabel lblBirthday = new JLabel("BIRTHDAY");
		lblBirthday.setHorizontalAlignment(SwingConstants.CENTER);
		lblBirthday.setFont(new Font("Lao Sangam MN", Font.PLAIN, 22));
		lblBirthday.setBounds(387, 199, 122, 36);
		mainPanel.add(lblBirthday);
		
		JLabel lblNote = new JLabel("NOTE");
		lblNote.setHorizontalAlignment(SwingConstants.CENTER);
		lblNote.setFont(new Font("Lao Sangam MN", Font.PLAIN, 22));
		lblNote.setBounds(387, 289, 122, 36);
		mainPanel.add(lblNote);
		
		textField_name = new JTextField();
		textField_name.setBackground(new Color(255, 255, 255));
		textField_name.setBounds(198, 102, 177, 45);
		textField_name.setColumns(10);
		textField_name.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		mainPanel.add(textField_name);
		
		textField_age = new JTextField();
		textField_age.setColumns(10);
		textField_age.setBackground(new Color(255, 255, 255));
		textField_age.setBounds(198, 186, 177, 45);
		textField_age.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		mainPanel.add(textField_age);
		
		textField_phone = new JTextField();
		textField_phone.setColumns(10);
		textField_phone.setBackground(new Color(255, 255, 255));
		textField_phone.setBounds(538, 93, 177, 45);
		textField_phone.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		mainPanel.add(textField_phone);
		
		textField_birthday = new JTextField();
		textField_birthday.setColumns(10);
		textField_birthday.setBackground(new Color(255, 255, 255));
		textField_birthday.setBounds(538, 186, 177, 45);
		textField_birthday.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		mainPanel.add(textField_birthday);
		
		JComboBox comboBox_gender = new JComboBox(new String[] {"MALE","FEMALE"});
		comboBox_gender.setBounds(198, 289, 177, 36);
		mainPanel.add(comboBox_gender);
		
		JTextArea textArea_note = new JTextArea();
		textArea_note.setBackground(new Color(255, 255, 255));
		textArea_note.setLineWrap(true);
		textArea_note.setBounds(538, 301, 213, 200);
		textArea_note.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		mainPanel.add(textArea_note);
		
		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nameTxt = textField_name.getText();
				String ageTxt = textField_age.getText();
				String phoneTxt = textField_phone.getText();
				String genderTxt = comboBox_gender.getSelectedItem().toString();
				String noteTxt = textArea_note.getText();
				
				Customer.createCustomer(nameTxt, phoneTxt, genderTxt, ageTxt, noteTxt);
				JOptionPane.showMessageDialog(null,"Data has been saved successfully");
				mainPanel.setVisible(false);
				tablePanel.setVisible(true);
			}
			
		});
		btnNewButton_1.setBounds(329, 405, 117, 29);
		mainPanel.add(btnNewButton_1);
		
		JButton GoToList = new JButton("List");
		GoToList.setBounds(578, 25, 117, 29);
		GoToList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(false);
				tablePanel.setVisible(true);
			}
			
		});
		
		mainPanel.add(GoToList);
		columnModels.getColumn(0).setPreferredWidth(10);
		columnModels.getColumn(1).setPreferredWidth(10);
		columnModels.getColumn(2).setPreferredWidth(10);
		columnModels.getColumn(3).setPreferredWidth(10);
		columnModels.getColumn(4).setPreferredWidth(120);
		
		JPanel welcomePanel = new JPanel();
		welcomePanel.setBackground(new Color(128, 128, 128));
		welcomePanel.setBounds(0, 0, 800, 578);
		frame.getContentPane().add(welcomePanel);
		welcomePanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Log In");
		lblNewLabel.setBounds(286, 95, 195, 66);
		lblNewLabel.setForeground(new Color(255, 215, 0));
		lblNewLabel.setFont(new Font("Chalkboard SE", Font.PLAIN, 46));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomePanel.add(lblNewLabel);
		
		ID = new JTextField();
		ID.setBounds(208, 184, 285, 42);
		ID.setText("Enter ID");
		ID.setToolTipText("");
		welcomePanel.add(ID);
		ID.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(208, 248, 285, 42);
		welcomePanel.add(password);
		
		JLabel lblNewLabel_1 = new JLabel("ID :");
		lblNewLabel_1.setBounds(158, 197, 38, 16);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		welcomePanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password : ");
		lblNewLabel_2.setBounds(116, 261, 80, 16);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		welcomePanel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(514, 198, 128, 81);
		btnNewButton.setIcon(new ImageIcon("/Users/kimgun-yeong/Downloads/white_login.jpg"));
		btnNewButton.setPressedIcon(new ImageIcon("/Users/kimgun-yeong/Downloads/blue_login.jpg"));
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(ID.getText().equals("kenny2009") && Arrays.equals(password.getPassword(),"1234".toCharArray())) {
					welcomePanel.setVisible(false);
					mainPanel.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null,"You failed to login");
				}
			}
		});
		welcomePanel.add(btnNewButton);
	}
	
	public JMenuBar menuBar() {
		JMenuBar bar = new JMenuBar();
		bar.setForeground(new Color(245, 222, 179));
		JMenu fileMenu = new JMenu("File");
		JMenu aboutMenu = new JMenu("About");
		
		bar.add(fileMenu);
		bar.add(aboutMenu);
		
		JMenuItem openFile = new JMenuItem("open");
		JMenuItem exitFile = new JMenuItem("exit");
		fileMenu.add(openFile);
		fileMenu.addSeparator();
		fileMenu.add(exitFile);
		
		exitFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
		return bar;
	}
}
