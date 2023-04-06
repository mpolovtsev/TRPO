package lab1;

public class Main
{	
	public static DetailsRepository details = new DetailsRepository();
	
	public static void main(String[] args)
    {
		/** Добавление элементов в объект-репозиторий */
        details.add(new CarDetail(Shape.circle, Material.metallic, 1.2, 14.7, 4.9, 3, Body.coupe));
        details.add(new CarDetail(Shape.square, Material.rubber, 0.1, 5, 5, 0.3, Body.sedan));
        details.add(new CarDetail(Shape.rectangle, Material.plastic, 2.3, 45.7, 34.2, 0.7, Body.crossover));
        details.add(new CarDetail(Shape.triangle, Material.metallic, 0.45, 3.2, 3.2, 0.4, Body.cabriolet));
        details.add(new MachineDetail(Shape.rectangle, Material.metallic, 2, 14, 3, 1.1));
        details.add(new MachineDetail(Shape.circle, Material.metallic, 0.5, 2, 2, 1.2));
        details.add(new MachineDetail(Shape.circle, Material.rubber, 0.1, 5, 5, 0.3));
        details.add(new PhoneDetail(Shape.triangle, Material.rubber, 0.2, 6.3, 3.9, 0.4, Model.apple));
        details.add(new PhoneDetail(Shape.rectangle, Material.rubber, 0.1, 5.1, 11.6, 0.3, Model.lenovo));
       	details.add(new PhoneDetail(Shape.triangle, Material.metallic, 0.2, 1.2, 1.4, 0.3, Model.samsung));
		
		GUI app = new GUI();
		app.setVisible(true);
    }
}