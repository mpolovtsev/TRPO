package lab1;

import java.util.ArrayList;
import java.util.Scanner;

import lab1.CarDetail.Body;
import lab1.Detail.Material;
import lab1.Detail.Shape;
import lab1.PhoneDetail.Model;

public class Main
{
	public static void main(String[] args)
    {
		Scanner in = new Scanner(System.in);
		/** Создание объекта репозитория */
		DetailsRepository detailsRepository = new DetailsRepository();
        
        /** Добавление элементов в объект-репозиторий */
        detailsRepository.add(new CarDetail(Shape.circle, Material.metallic, 1.2, 14.7, 4.9, 3, Body.coupe));
        detailsRepository.add(new CarDetail(Shape.square, Material.rubber, 0.1, 5, 5, 0.3, Body.sedan));
        detailsRepository.add(new CarDetail(Shape.rectangle, Material.plastic, 2.3, 45.7, 34.2, 0.7, Body.crossover));
        detailsRepository.add(new CarDetail(Shape.triangle, Material.metallic, 0.45, 3.2, 3.2, 0.4, Body.cabriolet));
        detailsRepository.add(new MachineDetail(Shape.rectangle, Material.metallic, 2, 14, 3, 1.1));
        detailsRepository.add(new MachineDetail(Shape.circle, Material.metallic, 0.5, 2, 2, 1.2));
        detailsRepository.add(new MachineDetail(Shape.circle, Material.rubber, 0.1, 5, 5, 0.3));
        detailsRepository.add(new PhoneDetail(Shape.triangle, Material.rubber, 0.2, 6.3, 3.9, 0.4, Model.apple));
        detailsRepository.add(new PhoneDetail(Shape.rectangle, Material.rubber, 0.1, 5.1, 11.6, 0.3, Model.lenovo));
       	detailsRepository.add(new PhoneDetail(Shape.triangle, Material.metallic, 0.2, 1.2, 1.4, 0.3, Model.samsung));
        	
        boolean flag = true;
        
        try
        {
        	while (flag)
        	{
        		/** Вывод меню */
        		System.out.println("\n1. Add detail;");
        		System.out.println("2. Delete detail;");
        		System.out.println("3. Change detail;");
        		System.out.println("4. Display the number of details;");
        		System.out.println("5. Display the total weight of details containing the same shape;");
        		System.out.println("6. Display a detail that differs in it's shape;");
        		System.out.println("7. Exit;");	
        		System.out.print("Your choise: ");
        		int point = in.nextInt();
        		in.nextLine();
        		
        		switch (point)
        		{
        			case 1:
        				Detail newDetail = InputDetail();
        				
        				if (newDetail != null)
        				{
        					detailsRepository.add(newDetail);
        				}
        				
        				break;
        			case 2:
        				System.out.print("\nEnter the detail number: ");
        				int deleteNumber = in.nextInt();
        				
        				try
        				{
        					detailsRepository.delete(deleteNumber);
        				}
        				catch (java.lang.IndexOutOfBoundsException e)
        				{
        					System.out.println("Error: Invalid detail number.");	
        				}
        				
        				break;
        			case 3:
        				System.out.print("\nEnter the detail number: ");
        				int changeNumber = in.nextInt();
        				
        				Detail changedDetail = InputDetail();
        				
        				if (changedDetail != null)
        				{
        					try
        					{
        						detailsRepository.change(changeNumber, changedDetail);
        					}
        					catch (java.lang.IndexOutOfBoundsException e)
            				{
            					System.out.println("Error: Invalid detail number.");	
            				}
        				}
        
        				break;
        			case 4:
        				System.out.println(String.format("\nAmount of details: %d", detailsRepository.getLength()));
        				
        				break;
        			case 5:
        				double[] detailsWeightOfSameShape = DetailWeightService.getDetailsWeightOfSameShape(detailsRepository.details);
        	            System.out.println(String.format("\nTotal weight of circle details: %.2f\nTotal weight of square details: %.2f\n"
        	            		+ "Total weight of rectangle details: %.2f\nTotal weight of triangle details: %.2f\n", 
        	            		detailsWeightOfSameShape[0], detailsWeightOfSameShape[1], detailsWeightOfSameShape[2], detailsWeightOfSameShape[3]));
        	            
        				break;
        			case 6:
        				 ArrayList<Detail> detailsWithUniqueShape = DetailShapeService.getDetailWithUniqueShape(detailsRepository.details);
        		         
        				 if (detailsWithUniqueShape.size() != 0)
        		         {
        		            for (Detail detail : detailsWithUniqueShape)
        		            {
        		            	System.out.println(detail.toString() + "\n");
        		            }
        		         }
        		         else
        		         {
        		            System.out.println("Among all parts there is no part with a unique shape.");
        		         }
        		            
        		         break;
        			case 7:
        				flag = false;
        		}
        	}
        }
        catch (java.util.InputMismatchException e)
        {
        	System.out.println("Error: Invalid input format.");
        }
    }
	
	/** Метод InputDetail, реализующий ввод детали */
	public static Detail InputDetail()
	{
		Scanner in = new Scanner(System.in);
		Detail detail = null;
		
		try
		{
			System.out.print("\nEnter the detail type: ");
			DetailType detailType = DetailType.valueOf(in.nextLine().replaceAll("\\s", "").toLowerCase());
			System.out.print("Enter the shape: ");
			Shape shape = Shape.valueOf(in.nextLine().trim().toLowerCase());
			System.out.print("Enter the material: ");
			Material material = Material.valueOf(in.nextLine().trim().toLowerCase());
			System.out.print("Enter the weigth: ");
			double weight = in.nextDouble();
			System.out.print("Enter the length: ");
			double length = in.nextDouble();
			System.out.print("Enter the width: ");
			double width = in.nextDouble();
			System.out.print("Enter the height: ");
			double height = in.nextDouble();
			in.nextLine();
			
			switch (detailType)
			{
				case cardetail:
					System.out.print("Enter the car body: ");
					Body body = Body.valueOf(in.nextLine().trim().toLowerCase());
					detail = new CarDetail(shape, material, weight, length, width, height, body);
					break;
				case machinedetail:
					detail = new MachineDetail(shape, material, weight, length, width, height);
					break;
				case phonedetail:
					System.out.print("Enter the phone model: ");
					Model model = Model.valueOf(in.nextLine().trim().toLowerCase());
					detail = new PhoneDetail(shape, material, weight, length, width, height, model);
					break;
			}
		}
		catch (java.util.InputMismatchException e)
        {
        	System.out.println("Error: invalid input format.");
        }
		catch (java.lang.IllegalArgumentException e)
		{
			System.out.println("Error: this type doesn't exist.");
		}
		
		return detail;
	}
	
	enum DetailType
	{
		cardetail,
		machinedetail,
		phonedetail
	}
}