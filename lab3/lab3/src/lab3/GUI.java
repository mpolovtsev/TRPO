package lab3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame {
	private JLabel titleLbl = new JLabel();
	private JLabel inputLbl = new JLabel();
	private JLabel outputLbl = new JLabel();
	private JTextField inputTf = new JTextField("", 15);
	private JTextField outputTf = new JTextField("", 15);
	private JButton sortBttn = new JButton();
	
	public GUI()
	{
		this.setTitle("Сортировка массива");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridBagLayout());
		this.setSize(520, 120);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridheight = 1;
		constraints.gridwidth = 3;
		constraints.insets = new Insets(0, 0, 10, 0);
		titleLbl.setText("Сортировка массива");
		titleLbl.setFont(new Font("Verdana", Font.PLAIN, 18));
		this.add(titleLbl, constraints);
		constraints.insets = new Insets(0, 0, 0, 0);
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		constraints.weightx = 1;
		inputLbl.setText("Введите элементы массива:");
		inputLbl.setFont(new Font("Verdana", Font.PLAIN, 12));
		this.add(inputLbl, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		this.add(inputTf, constraints);

		constraints.gridx = 2;
		constraints.gridy = 1;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		sortBttn.setText("Отсортировать");
		sortBttn.setFont(new Font("Verdana", Font.PLAIN, 12));
		sortBttn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String[] arrayStr = inputTf.getText().split(" ");
				double[] arrayDouble = new double[arrayStr.length];
				
				try
				{
					for (int i = 0; i < arrayStr.length; i++)
					{
						arrayDouble[i] = Double.parseDouble(arrayStr[i]); 
					}
				}
				catch (NumberFormatException exeption)
				{
					JOptionPane.showMessageDialog(null, "Некорректные данные.");
					return;
				}
				
				double[] sortedArray = Sort.bucketSort(arrayDouble, 5);
			
				String result = "";
				
				for (double elem : sortedArray)
				{
					result += String.valueOf(elem) + " ";
				}
				
				outputTf.setText(result);
			}
		});
		
		this.add(sortBttn, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		outputLbl.setText("Отсортированный массив:");
		outputLbl.setFont(new Font("Verdana", Font.PLAIN, 12));
		this.add(outputLbl, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 2;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		this.add(outputTf, constraints);
	}
}