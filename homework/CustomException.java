package by.epam.l11.homework;

public class CustomException extends Exception
{
	private static final long serialVersionUID = 7211610624816141197L;

	CustomException(String message)
	{
		super(message);	
	}
}