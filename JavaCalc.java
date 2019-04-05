package Project2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JavaCalc extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private String ops="+";
	private double oprnd1=0;
	
	//creates new font
	Font myFont = new Font("Serif", Font.PLAIN, 20);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JavaCalc frame = new JavaCalc();
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
	public JavaCalc() 
	{
		//creates JFrame and JPanel
		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 365, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.darkGray);
		
		//creates text field at the top of the calculator 
		textField = new JTextField();
		textField.setFont(myFont);
		textField.setEditable(false);
		textField.setBounds(12, 13, 325, 50);
		contentPane.add(textField);
		textField.setColumns(10);
		
	//creates buttons for numbers 0-9
		JButton button = new JButton("1");
		button.setFont(myFont); //sets new font
		button.addActionListener(new MyListener()); //adds MyListener class 
		button.setBounds(12, 90, 60, 40);
		contentPane.add(button);
		
		JButton button_2 = new JButton("2");
		button_2.setFont(myFont);
		button_2.addActionListener(new MyListener());
		button_2.setBounds(100, 90, 60, 40);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("3");
		button_3.setFont(myFont);
		button_3.addActionListener(new MyListener());
		button_3.setBounds(188, 90, 60, 40);
		contentPane.add(button_3);
		
		JButton button_1 = new JButton("4");
		button_1.setFont(myFont);
		button_1.addActionListener(new MyListener());
		button_1.setBounds(12, 146, 60, 40);
		contentPane.add(button_1);
		
		JButton button_4 = new JButton("5");
		button_4.setFont(myFont);
		button_4.addActionListener(new MyListener());
		button_4.setBounds(100, 146, 60, 40);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("6");
		button_5.setFont(myFont);
		button_5.addActionListener(new MyListener());
		button_5.setBounds(188, 146, 60, 40);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("7");
		button_6.setFont(myFont);
		button_6.addActionListener(new MyListener());
		button_6.setBounds(12, 201, 60, 40);
		contentPane.add(button_6);
		
		JButton button_7 = new JButton("8");
		button_7.setFont(myFont);
		button_7.addActionListener(new MyListener());
		button_7.setBounds(100, 201, 60, 40);
		contentPane.add(button_7);
		
		JButton button_8 = new JButton("9");
		button_8.setFont(myFont);
		button_8.addActionListener(new MyListener());
		button_8.setBounds(188, 201, 60, 40);
		contentPane.add(button_8);
		
		JButton button_9 = new JButton("0");
		button_9.setFont(myFont);
		button_9.addActionListener(new MyListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				textField.setText(textField.getText()+((JButton)arg0.getSource()).getText());
				
				//if a number gets divided by 0, set the text in the field to be "Error"
				if(ops=="÷")
				{
					textField.setText("Error"); 
				}
			}
		});
		button_9.setBounds(100, 251, 60, 40);
		contentPane.add(button_9);
		
	//creates buttons for sign operations 
		JButton button_10 = new JButton("+"); //add operation
		button_10.setFont(myFont);
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				ops="+";
				oprnd1=Double.parseDouble(textField.getText());
				textField.setText("");
			}
		});
		button_10.setBounds(276, 90, 60, 40);
		contentPane.add(button_10);
		
		JButton button_11 = new JButton("–"); //subtract operation
		button_11.setFont(myFont);
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				ops="–";
				oprnd1=Double.parseDouble(textField.getText());
				textField.setText("");
			}
		});
		button_11.setBounds(276, 146, 60, 40);
		contentPane.add(button_11);
		
		JButton btnX = new JButton("×"); //multiplication operation
		btnX.setFont(myFont);
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				ops="×";
				oprnd1=Double.parseDouble(textField.getText());
				textField.setText("");
			}
		});
		btnX.setBounds(276, 201, 60, 40);
		contentPane.add(btnX);
		
		JButton button_12 = new JButton("÷"); //division operation
		button_12.setFont(myFont);
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				ops="÷";
				oprnd1=Double.parseDouble(textField.getText());
				textField.setText("");
			}
		});
		button_12.setBounds(276, 251, 60, 40);
		contentPane.add(button_12);
		
		JButton button_13 = new JButton("="); //equals operation
		button_13.setFont(myFont);
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				switch(ops)
				{
					case "+" : //if the operand is +, add the next number entered
						textField.setText("" + (oprnd1 + Double.parseDouble(textField.getText())));
						break;
					case "–": //if the operand is –, subtract the next number entered
						textField.setText("" + (oprnd1 - Double.parseDouble(textField.getText())));
						break;
					case "×" : //if the operand is ×, multiply the next number entered
						textField.setText("" + (oprnd1 * Double.parseDouble(textField.getText())));
						break;
					case "÷" : //if the operand is ÷, divide the next number entered
						textField.setText("" + (oprnd1 / Double.parseDouble(textField.getText())));
						break;
				}
			}
		});
		button_13.setBounds(188, 251, 60, 40);
		contentPane.add(button_13);
		
		//creates clear button
		JButton btnNewButton = new JButton("Clear");
		btnNewButton.setFont(myFont);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				//resets calculator and text field 
				oprnd1 = 0;
				textField.setText("");
				ops = "";
			}
		});
		btnNewButton.setBounds(12, 301, 325, 40);
		contentPane.add(btnNewButton);
	
		//creates button to input decimal values
		JButton btnNewButton2 = new JButton(".");
		btnNewButton2.setFont(myFont);
		btnNewButton2.addActionListener(new MyListener());
		btnNewButton2.setBounds(12, 251, 60, 40);
		contentPane.add(btnNewButton2);
	}
	
	//creates new action listener to implement on all buttons
	class MyListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			//sets text in field to text on selected button
			textField.setText(textField.getText()+((JButton)arg0.getSource()).getText()); 
		}
	}
}
