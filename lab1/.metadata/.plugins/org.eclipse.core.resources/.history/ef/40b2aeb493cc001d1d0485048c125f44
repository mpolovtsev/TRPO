package lab1;

public class PhoneDetail extends Detail 
{
	String model;
	
	public PhoneDetail(String shape, String material, double weight, double length, double width, double height, String model) 
	{
		super(shape, material, weight, length, width, height);
		this.model = model;
	}
	
	public String GetModel()
	{
		return model;
	}
	
	public String GetFullInfo()
	{
		String detailInfo =  super.GetFullInfo();
		detailInfo += String.format("Модель телефона: %s\n", this.GetModel());
		
		return detailInfo;
	}
}