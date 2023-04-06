package lab1;

import java.awt.*;
import javax.swing.*;

public abstract class PhoneDetailWindow extends AuxiliaryWindow {
	protected JLabel choiseModelLbl = new JLabel();
	protected JComboBox<String> choiseModelCb = new JComboBox<>();
	
	public PhoneDetailWindow()
	{
		super();
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 7;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.insets = new Insets(10, 2, 0, 2);
		choiseModelLbl.setText("Выберите модель телефона: ");
		choiseModelLbl.setFont(new Font("Verdana", Font.PLAIN, 12));
		this.add(choiseModelLbl, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 7;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		choiseModelCb.addItem("Apple");
		choiseModelCb.addItem("Samsung");
		choiseModelCb.addItem("Poco");
		choiseModelCb.addItem("Xiaomi");
		choiseModelCb.addItem("Lenovo");
		this.add(choiseModelCb, constraints);
	}
}