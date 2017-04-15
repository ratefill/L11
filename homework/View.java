package by.epam.l11.homework;

import java.util.List;

/*
Представление (View)

В обязанности Представления входит отображение данных полученных от Модели. 
Однако, представление не может напрямую влиять на модель. 
Можно говорить, что представление обладает доступом «только на чтение» к данным.

Представление обладает следующими признаками:

>  В представлении реализуется отображение данных, которые получаются от модели любым способом;
>  В некоторых случаях, представление может иметь код, который реализует некоторую бизнес-логику.


Примеры представления: HTML-страница, WPF форма, Windows Form.
*/

public class View implements ViewInterface
{
	private final ControllerInterface ctrl;

	public View(ControllerInterface c)
	{
		super();
		ctrl = c;
	}

	@Override
	public void save()
	{
		ctrl.save();
		System.out.println("DB saved");
	}

	@Override
	public void load()
	{
		ctrl.load();
		System.out.println("DB loaded");
	}

	@Override
	public void addProduct(String name, String category, String manufacturerСode, String date, String description)
	{
		boolean result = ctrl.addProduct(name, category, manufacturerСode, date, description);
		;
		if (result)
		{
			System.out.println("New record added");

		}
		else
		{
			System.out.println("Adding skiped ...");
		}
	};

	@Override
	public void removeProduct(String name)
	{		
		boolean result = ctrl.removeProduct(name);
		
		if (result)
		{
			System.out.println("Product deleted");

		}
		else
		{
			System.out.println("Something going wrong...");
		}		
		
	};

	private void print(List<Product> list)
	{
		for (Product p : list)
		{
			print(p);
		}
	}

	private void print(Product p)
	{
		System.out.println("---------------------------------------------------");
		System.out.println("name: " + p.getName().toString());
		System.out.println("category: " + p.getCategory().toString());
		System.out.println("manufacturerСode: " + p.getManufacturerСode().toString());
		System.out.println("date: " + p.getDate().toString());
		System.out.println("description: " + p.getDescription().toString());
		System.out.println("---------------------------------------------------");
	}

	@Override
	public void findByText(String substr)
	{
		List<Product> list = ctrl.findByText(substr);
		if (list != null)
		{
			print(list);
		}
		else
		{
			System.out.println("Nothing found");
		}
	};

	@Override
	public void findByFieldValue(ProductFields[] f, Object[] value)
	{

		List<Product> list = ctrl.findByFieldValue(f, value);
		if (list != null)
		{
			print(list);
		}
		else
		{
			System.out.println("Nothing found");
		}
	};

	@Override
	public void sortByFiled(ProductFields f)
	{
		ctrl.sortByFiled(f);
		System.out.println("DB sorted");
	};

}
