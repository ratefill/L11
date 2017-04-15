package by.epam.l11.homework;

import java.io.Serializable;

public class StoredProduct implements Product, Comparable<Product>, Serializable
{
	private static final long serialVersionUID = 8679904773783173426L;
	
	private String name;// продукт (уникальное поле)
	private String category; // категория
	private String manufacturerСode;// код производителя
	private String date;// дата выпуска
	private String description;// аннотацию

	@Override
	public String getName()
	{
		return name;
	}

	@Override
	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public String getCategory()
	{
		return category;
	}

	@Override
	public void setCategory(String category)
	{
		this.category = category;
	}

	@Override
	public String getManufacturerСode()
	{
		return manufacturerСode;
	}

	@Override
	public void setManufacturerСode(String manufacturerСode)
	{
		this.manufacturerСode = manufacturerСode;
	}

	@Override
	public String getDate()
	{
		return date;
	}

	@Override
	public void setDate(String date)
	{
		this.date = date;
	}

	@Override
	public String getDescription()
	{
		return description;
	}

	@Override
	public void setDescription(String description)
	{
		this.description = description;
	}

	public int compareTo(Product p)
	{
		return this.name.compareTo(p.getName());
	} 
	


}
