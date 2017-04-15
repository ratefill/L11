package by.epam.l11.homework;

import java.io.*;
import java.util.List;

/*

Модель

Под Моделью, обычно понимается часть содержащая в себе функциональную бизнес-логику приложения. 
Модель должна быть полностью независима от остальных частей продукта. 
Модельный слой ничего не должен знать об элементах дизайна, и каким образом он будет отображаться. 
Достигается результат, позволяющий менять представление данных, 
то как они отображаются, не трогая саму Модель.

Модель обладает следующими признаками:

> Модель — это бизнес-логика приложения;
> Модель обладает знаниями о себе самой и не знает о контроллерах и представлениях;
> Для некоторых проектов модель — это просто слой данных (DAO, база данных, XML-файл);
> Для других проектов модель — это менеджер базы данных, набор объектов или просто логика приложения;

*/

/*Склад
Разработать консольное приложение, работающее с
Товарами в Складе. Каждый Товар это:
Товар(категория, код производителя, дата выпуска,
аннотацию).
Общие пояснения к практическому заданию.
В начале работы приложения данные должны считываться из файла, в
конце работы – сохраняться в файл.
У пользователя должна быть возможность 
1.найти запись по любому параметру 
2. или по группе параметров (группу параметров можно
определить самостоятельно)
3. получить требуемые записи в
отсортированном виде, 
4. найти записи, текстовое поле которой содержит
определенное слово, 
5. а также добавить новую запись.
Правильно обрабатывайте исключительные ситуации.
!!! Попытайтесь при реализации приложения применить шаблон MVC*/

public class Model implements ModelInterface
{
	private String fileName = "d:\\Documents\\JAVA\\src\\by\\epam\\l11\\db.dat";
	private ProductList spl;

	public Model()
	{
		super();
		spl = new StoredProductList();
	}

	@Override
	public void save() throws CustomException
	{
		try
		{
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(spl);

			oos.close();
		}
		catch (IOException e)
		{
			throw new CustomException(e.getMessage());
		}
	}

	@Override
	public void load() throws CustomException
	{
		final File f = new File(fileName);

		try
		{
			if (f.exists())
			{
				
			
			FileInputStream fos = new FileInputStream(fileName);			
			ObjectInputStream oos = new ObjectInputStream(fos);

			spl = (ProductList) oos.readObject();

			oos.close();
			}

		}
		catch (Exception e1)
		{			
			throw new CustomException(e1.getMessage());
		}
	}

	@Override
	public boolean addProduct(Product p)
	{
		return spl.addProduct(p);
	};

	@Override
	public boolean removeProduct(String name)
	{
		return spl.removeProduct(name);
	};

	@Override
	public List<Product> findByText(String substr)
	{
		return spl.findByText(substr);
	};

	@Override
	public Product findByFieldValue(ProductFields f, Object value)
	{
		return spl.findByFieldValue(f, value);
	};

	@Override
	public List<Product> findByFieldValue(ProductFields[] f, Object[] value)
	{
		List<Product> result = null;

		try
		{
			result = spl.findByFieldValue(f, value);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return result;
	};

	@Override
	public void sortByFiled(ProductFields f)
	{
		spl.sortByFiled(f);
	};

}
