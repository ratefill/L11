package by.epam.l11.example;

import java.lang.Exception;

public class ExDemo2
{
	public static void main(String[] args)
	{
		ArException arEx = new ArException();
		try
		{
			arEx.myMeth();
		}
		catch (ArithmeticException e)
		{
			System.out.println("Исключение отловлено.");
			System.out.println("Состояние объекта-исключения:");
			System.out.println(e);
		}
		catch (Exception e)
		{
			System.out.println("Другой блок обработки исключения");
		}
	}
}

class ArException
{
	public void myMeth()
	{
		int x;
		int d = 0;
		x = 0;
		d = 4 / x;
	}
}