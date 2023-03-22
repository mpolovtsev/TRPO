package lab1;

import java.util.ArrayList;

public abstract class Detail
{
	protected String shape;
	protected String material;
	protected double weight;
	protected double length;
	protected double width;
	protected double height;
	
	public Detail(String shape, String material, double weight, double length, double width, double height)
	{
		this.shape = shape;
		this.material = material;
		this.weight = weight < 0 ? 0 : weight;
		this.length = length < 0 ? 0 : length;
		this.width = width < 0 ? 0 : width;
		this.height = height < 0 ? 0 : height;
	}
	
	public String GetShape()
	{
		return shape;
	}
	
	public String GetMaterial()
	{
		return material;
	}
	
	public double GetWeight()
	{
		return weight;
	}
	
	public double GetLength()
	{
		return length;
	}
	
	public double GetWidth()
	{
		return width;
	}
	
	public double GetHeight()
	{
		return height;
	}

	public static double[] GetTotalWeight(ArrayList<Detail> details)
	{
		double weightOfCarDetails = 0;
		double weightOfMachineDetails = 0;
		double weightOfPhoneDetails = 0;
		
		for (Detail detail : details)
		{	
			if (detail instanceof CarDetail)
				weightOfCarDetails += detail.GetWeight();
			else if (detail instanceof MachineDetail)
				weightOfMachineDetails += detail.GetWeight();
			else
				weightOfPhoneDetails += detail.GetWeight();
		}
		
		return new double[] { weightOfCarDetails, weightOfMachineDetails, weightOfPhoneDetails };
	}
	
	public String GetFullInfo()
	{
		String detailType;
		
		if (this instanceof CarDetail)
			 detailType = "машинная";
		else if (this instanceof MachineDetail)
			detailType = "станочная";
		else
			detailType = "телефонная";
		
		String detailInfo = String.format("\nДеталь: %s\nФорма: %s\nМатериал: %s\nВес: %s\nДлина: %s\nШирина: %s\n"
				+ "Высота: %s\n", detailType, this.GetShape(), this.GetMaterial(), this.GetWeight(), this.GetLength(), 
				this.GetWidth(), this.GetHeight());
		
		return detailInfo;
	}
	
	public static String GetUnique(ArrayList<Detail> details)
	{
		boolean isUnique = true;
		String result = "Уникальных деталей не найдено."; 
			
		for (int i = 0; i < details.size(); i++)
		{
			for (int j = 0; j < details.size(); j++)
			{
				if (details.get(i).GetShape() == details.get(j).GetShape() && i != j)
				{
					isUnique = false;
				}
			}
				
			if (isUnique)
			{
				result = details.get(i).GetFullInfo();
				break;
			}
		}
		
		return result;
	}
}