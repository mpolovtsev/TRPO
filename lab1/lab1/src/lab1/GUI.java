package lab1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;


public class GUI extends JFrame {
	private JLabel titleLbl = new JLabel();
	private JLabel choiseDetailTypeLbl = new JLabel();
	private JComboBox<String> choiseDetailTypeCb = new JComboBox<>();
	private JButton addBttn = new JButton();
	private JButton changeBttn = new JButton();
	private JButton deleteBttn = new JButton();
	private JLabel choiseOperationLbl = new JLabel();
	private JButton amountOfDetailsBttn = new JButton();
	private JButton totalWeightBttn = new JButton();
	private JButton uniqueDetailBttn = new JButton();
	
	public GUI()
	{
		this.setTitle("Работа с деталями");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridBagLayout());
		this.setSize(650, 150);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridheight = 1;
		constraints.gridwidth = 5;
		constraints.weightx = 1;
		constraints.insets = new Insets(0, 2, 10, 2);
		titleLbl.setText("Работа с деталями");
		titleLbl.setFont(new Font("Verdana", Font.PLAIN, 18));
		this.add(titleLbl, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		choiseDetailTypeLbl.setText("Выберите тип детали:");
		choiseDetailTypeLbl.setFont(new Font("Verdana", Font.PLAIN, 12));
		this.add(choiseDetailTypeLbl, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		choiseDetailTypeCb.addItem("Машинная");
		choiseDetailTypeCb.addItem("Станочная");
		choiseDetailTypeCb.addItem("Телефонная");
		this.add(choiseDetailTypeCb, constraints);
		
		constraints.gridx = 2;
		constraints.gridy = 1;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		addBttn.setText("Добавить");
		addBttn.setFont(new Font("Verdana", Font.PLAIN, 12));
		addBttn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				JFrame frame = null;
				
				String typeOfDetail = choiseDetailTypeCb.getSelectedItem().toString();
				
				switch (typeOfDetail)
				{
					case "Машинная":
						frame = new AddCarDetailWindow();
						break;
					case "Станочная":
						frame = new AddMachineDetailWindow();
						break;
					case "Телефонная":
						frame = new AddPhoneDetailWindow();
						break;
				}
				
				frame.setVisible(true);
			}
		});
		
		this.add(addBttn, constraints);
		
		constraints.gridx = 3;
		constraints.gridy = 1;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		changeBttn.setText("Изменить");
		changeBttn.setFont(new Font("Verdana", Font.PLAIN, 12));
		changeBttn.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e) {
					JFrame frame = null;
					
					String typeOfDetail = choiseDetailTypeCb.getSelectedItem().toString();
					
					switch (typeOfDetail)
					{
						case "Машинная":
							frame = new ChangeCarDetailWindow();
							break;
						case "Станочная":
							frame = new ChangeMachineDetailWindow();
							break;
						case "Телефонная":
							frame = new ChangePhoneDetailWindow();
							break;
					}
					
					frame.setVisible(true);					
				}		
			});
		
		this.add(changeBttn, constraints);
		
		constraints.gridx = 4;
		constraints.gridy = 1;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		deleteBttn.setText("Удалить");
		deleteBttn.setFont(new Font("Verdana", Font.PLAIN, 12));
		deleteBttn.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e) {
					JFrame frame = new DeleteDetailWindow();
					frame.setVisible(true);
				}
			});
		
		this.add(deleteBttn, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		choiseOperationLbl.setText("Выберите операцию:");
		choiseOperationLbl.setFont(new Font("Verdana", Font.PLAIN, 12));
		this.add(choiseOperationLbl, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 2;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		amountOfDetailsBttn.setText("Количество");
		amountOfDetailsBttn.setFont(new Font("Verdana", Font.PLAIN, 12));
		amountOfDetailsBttn.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e) {
					int amount = Main.details.getLength();
					JOptionPane.showMessageDialog(null, String.format("Количество деталей: %d", amount));
				}
			});

		this.add(amountOfDetailsBttn, constraints);
		
		
		constraints.gridx = 2;
		constraints.gridy = 2;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		totalWeightBttn.setText("Общий вес");
		totalWeightBttn.setFont(new Font("Verdana", Font.PLAIN, 12));
		totalWeightBttn.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e) {
					if (Main.details.getLength() == 0)
					{
						JOptionPane.showMessageDialog(null, "Нет деталей.");
						return;
					}
						
					double[] detailsWeightOfSameShape = DetailWeightService.getDetailsWeightOfSameShape(Main.details.details);
					String message = String.format("\nОбщий вес круглых деталей: %.2f\nОбщий вес квадратных деталей: %.2f\n"
    	            		+ "Общий вес прямоугольных деталей: %.2f\nОбщий вес треугольных деталей: %.2f\n", 
    	            		detailsWeightOfSameShape[0], detailsWeightOfSameShape[1], detailsWeightOfSameShape[2], detailsWeightOfSameShape[3]);
					
					JOptionPane.showMessageDialog(null, message);
				}
			});

		this.add(totalWeightBttn, constraints);
		
		constraints.gridx = 3;
		constraints.gridy = 2;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		uniqueDetailBttn.setText("Уник. деталь");
		uniqueDetailBttn.setFont(new Font("Verdana", Font.PLAIN, 12));
		uniqueDetailBttn.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e) {
					ArrayList<Detail> detailsWithUniqueShape = DetailShapeService.getDetailWithUniqueShape(Main.details.details);
   		         
	   				 if (detailsWithUniqueShape.size() != 0)
	   		         {
	   					String message = "";
	   					
	   		            for (Detail detail : detailsWithUniqueShape)
	   		            {
	   		            	message += detail.toString() + "\n";
	   		            }
	   		            
	   		            JOptionPane.showMessageDialog(null, message);
	   		         }
	   		         else
	   		         {
	   		        	JOptionPane.showMessageDialog(null, "Среди всех деталей нет детали с уникальной формой.");
	   		         }
				}
			});

		this.add(uniqueDetailBttn, constraints);
	}	
}