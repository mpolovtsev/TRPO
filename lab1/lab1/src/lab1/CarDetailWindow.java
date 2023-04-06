package lab1;

import java.awt.*;
import javax.swing.*;

public abstract class CarDetailWindow extends AuxiliaryWindow {
	protected JLabel choiseBodyLbl = new JLabel();
	protected JComboBox<String> choiseBodyCb = new JComboBox<>();
	
	public CarDetailWindow()
	{
		super();
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 7;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.insets = new Insets(10, 2, 0, 2);
		choiseBodyLbl.setText("Выберите тип кузова: ");
		choiseBodyLbl.setFont(new Font("Verdana", Font.PLAIN, 12));
		this.add(choiseBodyLbl, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 7;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		choiseBodyCb.addItem("Coupe");
		choiseBodyCb.addItem("Sedan");
		choiseBodyCb.addItem("Crossover");
		choiseBodyCb.addItem("Cabriolet");
		choiseBodyCb.addItem("Pickup");
		this.add(choiseBodyCb, constraints);
	}
}