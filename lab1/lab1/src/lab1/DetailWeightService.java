package lab1;

import java.util.ArrayList;

import lab1.Detail.Shape;

/** Класс DetailWeightService, содержащий методы для работы с весом деталей */
public class DetailWeightService {
	/** Метод getDetailsWeightOfSameShape, возвращающий общий вес деталей с одинаковой формой */
	public static double[] getDetailsWeightOfSameShape(ArrayList<Detail> details)
	{
		double[] weightOfDetails = new double[Shape.values().length];
		
		for (Detail detail : details)
		{	
			switch (detail.getShape())
			{
				case circle:
				{
					weightOfDetails[0] += detail.getWeight();
					break;
				}
				case square:
				{
					weightOfDetails[1] += detail.getWeight();
					break;
				}
				case rectangle:
				{
					weightOfDetails[2] += detail.getWeight();
					break;
				}
				case triangle:
				{
					weightOfDetails[3] += detail.getWeight();
					break;
				}
			}
		}
		
		return weightOfDetails;
	}
}