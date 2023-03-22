package lab1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
    {
		ArrayList<Detail> details = new ArrayList<Detail>();
    	
    	// Создание объектов
    	
        try
        {
        	details.add(new CarDetail("круг", "металл", 12, 10, 10, 8, "грузовая"));
        	details.add(new CarDetail("квадрат", "металл", 11, 7, 12, 8, "грузовая"));
        	details.add(new CarDetail("прямоугольник", "металл", 10, 13.9, 20, 9, "легковая"));
        	details.add(new MachineDetail("квадрат", "металл", 12, 10, 19, 9));
        	details.add(new MachineDetail("квадрат", "металл", 12, 10, 10.1, 8));
        	details.add(new MachineDetail("куб", "металл", 13, 14, 8.1, 8.5));
        	details.add(new PhoneDetail("квадрат", "металл", 12, 10, 10, 8, "грузовая"));
        	details.add(new PhoneDetail("прямоугольник", "металл", 12, 10, 10, 8, "грузовая"));
        	details.add(new PhoneDetail("квадрат", "металл", 12, 10, 10.5, 8, "грузовая"));
        	details.add(new PhoneDetail("куб", "металл", 14, 11, 9, 8.1, "грузовая"));
            
            // Общий вес деталей, имеющих одинаковую форму
            double[] totalWeight = Detail.GetTotalWeight(details);
            System.out.println(String.format("\nОбщий вес машинных деталей: %.2f\nОбщий вес станочных деталей: %.2f\n"
            		+ "Общий вес телефонных деталей: %.2f", totalWeight[0], totalWeight[1], totalWeight[2]));
            
            // Количество деталей
            System.out.println(String.format("\nКоличество деталей: %s", details.size()));
            
            
            // Полная информация по конкретной детали из всех имеющихся
            System.out.print(Detail.GetUnique(details));
        }
        catch (java.util.InputMismatchException e)
        {
        	System.out.println("Ошибка: неверный формат ввода.");
        }
    }
}

// GetFullname -> ToString
// Статические методы Detail вынести в отдельный обслуживающий класс
// Документация