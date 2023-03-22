package lab1;

public class CarDetail extends Detail 
{
	String carType;
	
	public CarDetail(String shape, String material, double weight, double length, double width, double height, String carType) 
	{
		super(shape, material, weight, length, width, height);
		this.carType = carType;
	}
	
	public String GetCarType()
	{
		return carType;
	}
	
	public String GetFullInfo()
	{
		String detailInfo =  super.GetFullInfo();
		detailInfo += String.format("Вид машины: %s\n", this.GetCarType());
		
		return detailInfo;
	}
}