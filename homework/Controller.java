package by.epam.l11.homework;

import java.util.List;

public class Controller implements ControllerInterface
{
	private final ModelInterface engine;

	public Controller(ModelInterface m)
	{
		super();
		engine = m;
	}

	@Override
	public void save()
	{
		try
		{
			engine.save();
		}
		catch (CustomException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void load()
	{
		try
		{
			engine.load();
		}
		catch (CustomException e)
		{
			e.printStackTrace();			
			
		}
	}

	@Override
	public boolean addProduct(String name, String category, String manufacturerСode, String date, String description)
	{
		Product p = new StoredProduct();
		p.setName(name);
		p.setCategory(category);
		p.setManufacturerСode(manufacturerСode);
		p.setDate(date);
		p.setDescription(description);
		return engine.addProduct(p);
	};

	@Override
	public boolean removeProduct(String name)
	{
		return engine.removeProduct(name);
	};

	@Override
	public List<Product> findByText(String substr)
	{
		return engine.findByText(substr);
	};

	@Override
	public Product findByFieldValue(ProductFields f, Object value)
	{
		return engine.findByFieldValue(f, value);
	};

	@Override
	public List<Product> findByFieldValue(ProductFields[] f, Object[] value)
	{
		return engine.findByFieldValue(f, value);
	};

	@Override
	public void sortByFiled(ProductFields f)
	{
		engine.sortByFiled(f);
	};

}
