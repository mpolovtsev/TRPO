package lab1;

/** Класс PhoneDetail, наследуемый от Detail */
public class PhoneDetail extends Detail 
{
	Model model;
	
	public PhoneDetail(Shape shape, Material material, double weight, 
			double length, double width, double height, Model model) 
	{
		super(shape, material, weight, length, width, height);
		this.model = model;
	}
	
	public Model getModel()
	{
		return model;
	}
	
	/** Информация о детали */
	@Override
	public String toString()
	{
		String detailInfo =  super.toString();
		detailInfo += String.format("Model: %s", this.getModel());
		
		return detailInfo;
	}
	
	enum Model
	{
		apple,
		samsung,
		poco,
		xiaomi,
		lenovo
	}
}