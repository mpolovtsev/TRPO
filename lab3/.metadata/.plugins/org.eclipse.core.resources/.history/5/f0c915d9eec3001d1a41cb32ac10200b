package lab3;

public class Main {
	public static void main(String[] args)
	{
		double[] array = new double[15];
		int a = -100;
		int b = 100;
		
		for (int i = 0; i < array.length; i++)
			array[i] = Math.round((Math.random() * (b - a) + a) * 100.0) / 100.0;
		
		printArray(array, "Исходный массив:\n");
		
		double[] sortedArray = bucketSort(array, 10);

		printArray(sortedArray, "\nОтсортированный массив:\n");
	}

	public static void printArray(double[] array, String header)
	{
		System.out.println(header);
		
		for (int i = 0; i < array.length; i++)
			System.out.println(array[i]);
	}
	
	public static double[] bucketSort(double[] array, int n)
	{	
		double minElem = findMinElem(array);
		double maxElem = findMaxElem(array);
		
		if (array.length < 2 || minElem == maxElem)
		{
			return array;
		}
		
		double[][] buckets = new double[n][];
		int[] blockSize = calculateBlockSize(array, n);
		
		for (int i = 0; i < buckets.length; i++)
			buckets[i] = new double[blockSize[i]];
		
		int[] addIndex = new int[n];
		int index;
		
		for (int i = 0; i < array.length; i++)
		{
			index = (int)(Math.floor(n * (array[i] - minElem)) / (maxElem - minElem + 1));
			buckets[index][addIndex[index]++] = array[i];
		}
		
		for (double[] bucket : buckets)
			bucket = buckets.length <= 32 ? insertionSort(bucket) : bucketSort(bucket, n);
		
		double[] sortedArray = new double[array.length];
		index = 0;
		
		for (double[] bucket : buckets)
		{
			for (double elem : bucket)
			{
				sortedArray[index] = elem;
				index++;		
			}		
		}
		
		return sortedArray;
	}
	
	public static double findMinElem(double[] array)
	{
		double minElem = array[0];
		
		for (double elem : array)
		{
			if (elem < minElem)
				minElem = elem;
		}
		
		return minElem;
	}
	
	public static double findMaxElem(double[] array)
	{
		double maxElem = array[0];
		
		for (double elem : array)
		{
			if (elem > maxElem)
				maxElem = elem;
		}
		
		return maxElem;
	}
	
	public static int[] calculateBlockSize(double[] array, int n)
	{
		int[] blockSize = new int[n];
		double minElem = findMinElem(array);
		double maxElem = findMaxElem(array);
		int index;
		
		for (int i = 0; i < array.length; i++)
		{
			index = (int)(Math.floor(n * (array[i] - minElem)) / (maxElem - minElem + 1));
			blockSize[index] += 1;
		}
		
		return blockSize;
	}
	
	public static double[] insertionSort(double[] array)
	{
		double elem;
		int index;

		for (int i = 1; i < array.length; i++)
		{
			elem = array[i];
			index = i;
			
			while (index > 0 && elem < array[index - 1])
			{
				array[index] = array[index - 1];
				index--;
			}
			
			array[index] = elem;
		}
		
		return array;
	}
}