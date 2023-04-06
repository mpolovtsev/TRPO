package lab1;
/** Абстрактный класс Detail */
public abstract class Detail
{
	protected Shape shape;
	protected Material material;
	protected double weight;
	protected double length;
	protected double width;
	protected double height;
	
	public Detail(Shape shape, Material material, double weight, 
			double length, double width, double height)
	{
		this.shape = shape;
		this.material = material;
		this.weight = weight;
		this.length = length;
		this.width = width;
		this.height = height;
	}
	
	public Shape getShape()
	{
		return shape;
	}
	
	public Material getMaterial()
	{
		return material;
	}
	
	public double getWeight()
	{
		return weight;
	}
	
	public double getLength()
	{
		return length;
	}
	
	public double getWidth()
	{
		return width;
	}
	
	public double getHeight()
	{
		return height;
	}

	// Информация о детали
	@Override
	public String toString()
	{
		String detailType;
		
		if (this instanceof CarDetail)
			 detailType = "car detail";
		else if (this instanceof MachineDetail)
			detailType = "machine detail";
		else
			detailType = "phone detail";
		
		String detailInfo = String.format("\nDetail: %s\nShape: %s\nMaterial: %s\nWeight: %s\nLength: %s\nWidth: %s\n"
				+ "Height: %s\n", detailType, this.getShape(), this.getMaterial(), this.getWeight(), this.getLength(), 
				this.getWidth(), this.getHeight());
		
		return detailInfo;
	}
}

enum Shape
{
	circle,
	square,
	rectangle,
	triangle
}

enum Material
{
	metallic,
	plastic,
	rubber
}