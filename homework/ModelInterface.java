package by.epam.l11.homework;

import java.util.List;

public interface ModelInterface
{

	void save() throws CustomException;

	void load() throws CustomException;

	boolean addProduct(Product p);

	boolean removeProduct(String name);

	List<Product> findByText(String substr);

	Product findByFieldValue(ProductFields f, Object value);

	List<Product> findByFieldValue(ProductFields[] f, Object[] value);

	void sortByFiled(ProductFields f);

}