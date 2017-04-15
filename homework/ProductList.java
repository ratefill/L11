package by.epam.l11.homework;

import java.util.List;

public interface ProductList
{

	public boolean addProduct(Product p);

	public boolean removeProduct(String name);

	public List<Product> findByText(String substr);

	public Product findByFieldValue(ProductFields f, Object value);

	public List<Product> findByFieldValue(ProductFields[] f, Object[] value) throws Exception;

	public void sortByFiled(ProductFields f);
	
	public boolean exists(Product p);

}