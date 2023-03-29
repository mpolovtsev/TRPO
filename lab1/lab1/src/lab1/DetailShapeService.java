package lab1;

import java.util.ArrayList;

/** Класс DetailShapeService, содержащий методы для работы с формой деталей */
public class DetailShapeService {
	/** Метод getDetailWithUniqueShape, возвращающий детали с уникальной формой */
	public static ArrayList<Detail> getDetailWithUniqueShape(ArrayList<Detail> details)
	{
		ArrayList<Detail> detailsWithUniqueShape = new ArrayList<Detail>();
		boolean isUnique;
		
		for (int i = 0; i < details.size(); i++)
		{
			isUnique = true;
			
			for (int j = 0; j < details.size(); j++)
			{
				if (details.get(i).shape == details.get(j).shape && i != j)
				{
					isUnique = false;
					break;
				}
			}
			
			if (isUnique)
			{
				detailsWithUniqueShape.add(details.get(i));
			}
		}
		
		return detailsWithUniqueShape;
	}
}