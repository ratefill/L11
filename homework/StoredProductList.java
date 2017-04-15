package by.epam.l11.homework;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class StoredProductList implements ProductList, Serializable
{
	private static final long serialVersionUID = 3340753392605836081L;
	
	private List<Product> pl;

	public StoredProductList()
	{
		pl = new ArrayList<Product>();
	}

	@Override
	public boolean addProduct(Product p)
	{	
		boolean result;
		if (!exists(p))
		{
			result=pl.add(p);
		}
		else
			result=false;
		return result;
	};
	
	@Override	
	public boolean exists(Product p)
	{
		boolean result = false;
		if ( p!=null && findByFieldValue(ProductFields.NAME, p.getName())!=null )
		{
			result=true;
		};
		return result;
	};

	@Override
	public boolean removeProduct(String name)
	{
		boolean result = false;
		Product p = findByFieldValue(ProductFields.NAME, name);
		if (p != null)
		{
			result = pl.remove(p);
		}
		return result;
	};

	@Override
	public List<Product> findByText(String substr)
	{
		List<Product> result = new ArrayList<Product>();

		for (Product p: pl)
		{
			if (p.getDescription().contains(substr))
			{
				result.add(p);
				// break;
			}			
		}
		return result;
	}

	private boolean compareByFiledValue(Product p, ProductFields f, Object value)
	{
		boolean result = false;
		switch (f)
		{
		case NAME:
			if (p.getName().equals(value))
			{
				result = true;
			}
			break;
		case CATEGORY:
			if (p.getCategory().equals(value))
			{
				result = true;
			}
			break;
		case MANUFACTURERСODE:
			if (p.getManufacturerСode().equals(value))
			{
				result = true;
			}
			break;
		case DATE:
			if (p.getDate().equals(value))
			{
				result = true;
			}
			break;
		case DESCRIPTION:
			if (p.getDescription().equals(value))
			{
				result = true;
			}

			break;
		}
		return result;
	}

	@Override
	public Product findByFieldValue(ProductFields f, Object value)
	{
		Product result = null;
		Product p;

		for (int i = 0; i < pl.size(); i++)
		{
			p = pl.get(i);
			if (compareByFiledValue(p, f, value))
			{
				result = p;
				break;
			}
		}
		return result;
	}

	@Override
	public List<Product> findByFieldValue(ProductFields[] f, Object[] value) throws Exception
	{
		if (f.length != value.length)
		{
			throw new Exception("Массив полей и их значений не совпадают по длине");
		}

		List<Product> result = new ArrayList<Product>();

		Product p;
		boolean ok;

		for (int i = 0; i < pl.size(); i++)
		{
			p = pl.get(i);

			ok = true;
			for (int j = 0; j < f.length; j++)
			{
				if (!compareByFiledValue(p, f[j], value[j]))
				{
					ok = false;
					break;
				}
			}
			if (ok)
			{
				result.add(p);
			}
		}
		return result;
	}

	@Override
	public void sortByFiled(ProductFields f)
	{
		pl.sort(new Comparator<Product>() {
			@Override
			public int compare(Product p1, Product p2)
			{
				int result=-1;
				switch (f)
				{
				case NAME:
				{
					result= (p1.getName().compareTo(p2.getName()));
					break;
				}
				case CATEGORY:
				{
					result= (p1.getName().compareTo(p2.getName()));
					break;
				}				
				case MANUFACTURERСODE:
				{
					result= (p1.getName().compareTo(p2.getName()));
					break;
				}
				case DATE:
				{
					result= (p1.getName().compareTo(p2.getName()));
					break;
				}
				case DESCRIPTION:
				{
					result= (p1.getName().compareTo(p2.getName()));
					break;
				}
				}				
				
				
				return result;
			}
		});
	}

}
