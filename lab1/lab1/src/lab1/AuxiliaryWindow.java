package lab1;

import java.awt.*;
import javax.swing.*;

public abstract class AuxiliaryWindow extends JFrame {
	protected JLabel titleLbl = new JLabel();
	protected JLabel choiseShapeLbl = new JLabel();
	protected JComboBox<String> choiseShapeCb = new JComboBox<>();
	protected JLabel choiseMaterialLbl = new JLabel();
	protected JComboBox<String> choiseMaterialCb = new JComboBox<>();
	protected JLabel inputWeightLbl = new JLabel();
	protected JTextField inputWeightTf = new JTextField("", 12);
	protected JLabel inputLengthLbl = new JLabel();
	protected JTextField inputLengthTf = new JTextField("", 12);
	protected JLabel inputWidthLbl = new JLabel();
	protected JTextField inputWidthTf = new JTextField("", 12);
	protected JLabel inputHeightLbl = new JLabel();
	protected JTextField inputHeightTf = new JTextField("", 12);
	protected JButton button = new JButton();
	
	protected AuxiliaryWindow()
	{
		this.setLayout(new GridBagLayout());
		this.setResizable(false);
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridheight = 1;
		constraints.gridwidth = 2;
		constraints.weightx = 1;
		constraints.insets = new Insets(0, 0, 10, 0);
		this.add(titleLbl, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.insets = new Insets(10, 2, 0, 2);
		choiseShapeLbl.setText("Выберите форму детали: ");
		choiseShapeLbl.setFont(new Font("Verdana", Font.PLAIN, 12));
		this.add(choiseShapeLbl, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		choiseShapeCb.addItem("Circle");
		choiseShapeCb.addItem("Square");
		choiseShapeCb.addItem("Rectangle");
		choiseShapeCb.addItem("Triangle");
		this.add(choiseShapeCb, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		choiseMaterialLbl.setText("Выберите материал детали: ");
		choiseMaterialLbl.setFont(new Font("Verdana", Font.PLAIN, 12));
		this.add(choiseMaterialLbl, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 2;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		choiseMaterialCb.addItem("Metallic");
		choiseMaterialCb.addItem("Plastic");
		choiseMaterialCb.addItem("Rubber");
		this.add(choiseMaterialCb, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		inputWeightLbl.setText("Введите вес детали: ");
		inputWeightLbl.setFont(new Font("Verdana", Font.PLAIN, 12));
		this.add(inputWeightLbl, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 3;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		this.add(inputWeightTf, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 4;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		inputLengthLbl.setText("Введите длину детали: ");
		inputLengthLbl.setFont(new Font("Verdana", Font.PLAIN, 12));
		this.add(inputLengthLbl, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 4;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		this.add(inputLengthTf, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 5;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		inputWidthLbl.setText("Введите ширину детали: ");
		inputWidthLbl.setFont(new Font("Verdana", Font.PLAIN, 12));
		this.add(inputWidthLbl, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 5;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		this.add(inputWidthTf, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 6;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		inputHeightLbl.setText("Введите высоту детали: ");
		inputHeightLbl.setFont(new Font("Verdana", Font.PLAIN, 12));
		this.add(inputHeightLbl, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 6;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		this.add(inputHeightTf, constraints);
	}
}