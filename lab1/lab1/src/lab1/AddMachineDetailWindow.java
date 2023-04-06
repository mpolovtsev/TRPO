package lab1;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.*;

import javax.swing.JOptionPane;

public class AddMachineDetailWindow extends MachineDetailWindow {
	public AddMachineDetailWindow()
	{
		this.setTitle("Добавление станочной детали");
		this.setSize(450, 335);
		this.setLocationRelativeTo(null);
		
		titleLbl.setText("Добавление станочной детали");
		titleLbl.setFont(new Font("Verdana", Font.PLAIN, 18));
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 7;
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
				
				try
				{
					shape = Shape.valueOf(choiseShapeCb.getSelectedItem().toString().toLowerCase());
					material = Material.valueOf(choiseMaterialCb.getSelectedItem().toString().toLowerCase());
					weight = Double.parseDouble(inputWeightTf.getText());
					length = Double.parseDouble(inputLengthTf.getText());
					width = Double.parseDouble(inputWidthTf.getText());
					height = Double.parseDouble(inputHeightTf.getText());
				}
				catch (NumberFormatException exception)
				{
					JOptionPane.showMessageDialog(null, "Некорректные данные.");
					return;
				}
				
				Detail detail = new MachineDetail(shape, material, weight, length, width, height);
				
				Main.details.add(detail);
				
				JOptionPane.showMessageDialog(null, "Деталь добавлена.");
			}
		});	
	}
}