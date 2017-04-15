package by.epam.l11.example;

import java.io.FileInputStream;
import java.io.IOException;

public class TryWithResources
{
	public static void main(String[] args)
	{
		String filePath = "";// args[0];
		try (FileInputStream in = new FileInputStream(filePath))
		{
			int data = 0;
			while ((data = in.read()) != -1)
			{
				System.out.print("Data: " + data);
			}
		}
		catch (IOException e)
		{
			System.out.println("Error: " + e.getMessage());
		}
	}
}
