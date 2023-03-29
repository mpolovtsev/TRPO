package lab1;

/** Класс CarDetail, наследуемый от Detail */
public class CarDetail extends Detail
{
	Body body;
	
	public CarDetail(Shape shape, Material material, double weight, 
			double length, double width, double height, Body body) 
	{
		super(shape, material, weight, length, width, height);
		this.body = body;
	}
	
	public Body getBody()
	{
		return body;
	}
	
	/** Информация о детали */
	@Override
	public String toString()
	{
		String detailInfo =  super.toString();
		detailInfo += String.format("Body: %s", this.getBody());
		
		return detailInfo;
	}
	
	enum Body
	{
		coupe,
		sedan,
		crossover,
		cabriolet,
		pickup,
	}
}