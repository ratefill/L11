package by.epam.l11.example;

public class ThrowTwice
{
	public static void main(String args[])
	{
		try
		{
			int a = 2;//args.length;
			try
			{
				if (a == 1)
				{
					a = a / (a - a);
				}
				if (a == 2)
				{
					int с[] = { 1 };
					с[42] = 99;
				}
			}
			catch (ArrayIndexOutOfBoundsException e)
			{
				System.out.println("Индекс выходит за границу массива: " + e);
				throw e;
				// or // throw new // ArithmeticException(“Исключение в
				// catch.");
			}
			int b = 42 / a;
			System.out.println("a = " + a);
		}
		catch (ArithmeticException e)
		{
			System.out.println("Деление на ноль: " + e);
		}
		catch (Exception e)
		{
			System.out.println("Общий обработчик.");
		}
	}
}
