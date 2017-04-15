package by.epam.l11.example;

public class ThrowsGenerate
{
	static void throwOne() throws IllegalAccessException
	{
		System.out.println("Внутри throwOne.");
		throw new IllegalAccessException("demo");
	}

	public static void main(String args[])
	{
		try
		{
			throwOne();
		}
		catch (IllegalAccessException e)
		{
			System.out.println("Выброс " + e);
		}
	}
}