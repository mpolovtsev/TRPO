package lab1;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ChangeMachineDetailWindow extends MachineDetailWindow {
	private JLabel inputIndexLbl = new JLabel();
	private JTextField inputIndexTf = new JTextField("", 12);
	
	public ChangeMachineDetailWindow()
	{
		this.setTitle("Изменение станочной детали");
		this.setSize(450, 350);
		this.setLocationRelativeTo(null);
		
		titleLbl.setText("Изменение станочной детали");
		titleLbl.setFont(new Font("Verdana", Font.PLAIN, 18));
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 7;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.insets = new Insets(10, 2, 0, 2);
		inputIndexLbl.setText("Введите номер детали:");
		inputIndexLbl.setFont(new Font("Verdana", Font.PLAIN, 12));
		this.add(inputIndexLbl, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 7;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		this.add(inputIndexTf, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 8;
		constraints.gridheight = 1;
		constraints.gridwidth = 2;
		constraints.fill = 0;
		button.setText("Изменить");
		button.setFont(new Font("Verdana", Font.PLAIN, 12));
		this.add(button, constraints);
		
		button.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				Shape shape = null;
				Material material = null;
				double weight = 0, length = 0, width = 0, height = 0;
				int index = 0;
				
				try
				{
					shape = Shape.valueOf(choiseShapeCb.getSelectedItem().toString().toLowerCase());
					material = Material.valueOf(choiseMaterialCb.getSelectedItem().toString().toLowerCase());
					weight = Double.parseDouble(inputWeightTf.getText());
					length = Double.parseDouble(inputLengthTf.getText());
					width = Double.parseDouble(inputWidthTf.getText());
					height = Double.parseDouble(inputHeightTf.getText());
					index = Integer.parseInt(inputIndexTf.getText());
				}
				catch (NumberFormatException exception)
				{
					JOptionPane.showMessageDialog(null, "Некорректные данные.");
					return;
				}
				
				Detail detail = new MachineDetail(shape, material, weight, length, width, height);
				
				Main.details.change(index, detail);
				
				JOptionPane.showMessageDialog(null, "Деталь изменена.");
			}
		});	
	}
}