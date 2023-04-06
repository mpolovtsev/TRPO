package lab1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import lab1.Main;

public class DeleteDetailWindow extends JFrame {
	private JLabel titleLbl = new JLabel();
	private JLabel inputIndexLbl = new JLabel();
	private JTextField inputIndexTf = new JTextField("", 12);
	private JButton deleteBttn = new JButton();
	
	public DeleteDetailWindow()
	{
		this.setLayout(new GridBagLayout());
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("Удаление детали");
		this.setSize(450, 150);
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridheight = 1;
		constraints.gridwidth = 3;
		constraints.weightx = 1;
		constraints.insets = new Insets(0, 0, 10, 0);
		titleLbl.setText("Удаление детали");
		titleLbl.setFont(new Font("Verdana", Font.PLAIN, 18));
		this.add(titleLbl, constraints);
		constraints.insets = new Insets(0, 0, 0, 0);
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		constraints.insets = new Insets(10, 0, 0, 0);
		inputIndexLbl.setText("Ввведите номер детали: ");
		inputIndexLbl.setFont(new Font("Verdana", Font.PLAIN, 12));
		this.add(inputIndexLbl, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		this.add(inputIndexTf, constraints);
		
		constraints.gridx = 2;
		constraints.gridy = 1;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		deleteBttn.setText("Удалить");
		deleteBttn.setFont(new Font("Verdana", Font.PLAIN, 12));
		deleteBttn.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e) {
					try
					{
						int index =  Integer.parseInt(inputIndexTf.getText());
						Main.details.delete(index);
					}
					catch (NumberFormatException exeption)
					{
						JOptionPane.showMessageDialog(null, "Введите число.");
						return;
					}
					catch (IndexOutOfBoundsException exeption)
					{
						JOptionPane.showMessageDialog(null, "Детали с таким индексом нет.");
						return;
					}
					
					JOptionPane.showMessageDialog(null, "Деталь удалена.");
				}
			});
		
		this.add(deleteBttn, constraints);
	}
}