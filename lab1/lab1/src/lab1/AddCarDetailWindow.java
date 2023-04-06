package lab1;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JOptionPane;

public class AddCarDetailWindow extends CarDetailWindow {
	public AddCarDetailWindow()
	{
		this.setTitle("Добавление машинной детали");
		this.setSize(450, 350);
		this.setLocationRelativeTo(null);
		
		titleLbl.setText("Добавление машинной детали");
		titleLbl.setFont(new Font("Verdana", Font.PLAIN, 18));
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 8;
		constraints.gridheight = 1;
		constraints.gridwidth = 2;
		constraints.insets = new Insets(10, 2, 0, 2);
		button.setText("Добавить");
		button.setFont(new Font("Verdana", Font.PLAIN, 12));
		this.add(button, constraints);
		
		button.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				Shape shape = null;
				Material material = null;
				double weight = 0, length = 0, width = 0, height = 0;
				Body body = null;
				
				try
				{
					shape = Shape.valueOf(choiseShapeCb.getSelectedItem().toString().toLowerCase());
					material = Material.valueOf(choiseMaterialCb.getSelectedItem().toString().toLowerCase());
					weight = Double.parseDouble(inputWeightTf.getText());
					length = Double.parseDouble(inputLengthTf.getText());
					width = Double.parseDouble(inputWidthTf.getText());
					height = Double.parseDouble(inputHeightTf.getText());
					body = Body.valueOf(choiseBodyCb.getSelectedItem().toString().toLowerCase());
				}
				catch (NumberFormatException exception)
				{
					JOptionPane.showMessageDialog(null, "Некорректные данные.");
					return;
				}
				
				Detail detail = new CarDetail(shape, material, weight, length, width, height, body);
				
				Main.details.add(detail);
				
				JOptionPane.showMessageDialog(null, "Деталь добавлена.");
			}
		});
	}
}