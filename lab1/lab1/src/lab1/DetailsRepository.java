package lab1;

import java.util.ArrayList;

/** Класс-репозиторий DetailsRepository */
public class DetailsRepository {
	ArrayList<Detail> details = new ArrayList<Detail>();
	
	/** Метод getDetails, возвращающий список деталей */
	public ArrayList<Detail> getDetails()
	{
		return details;
	}
	
	/** Метод getLength, возвращающий количество деталей */
	public int getLength()
	{
		return details.size();
	}
	
	/** Метод add, добавляющий деталь в список details */
	public void add(Detail detail)
	{
		details.add(detail);
	}
	
	/** Метод delete, удаляющий деталь из списка details */
	public void delete(int index)
	{
		details.remove(index - 1);
	}
	
	/** Метод change, изменяющий деталь в списке details */
	public void change(int index, Detail detail)
	{
		details.set(index - 1, detail);
	}
}