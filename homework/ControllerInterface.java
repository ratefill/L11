package by.epam.l11.homework;

import java.util.List;

public interface ControllerInterface
{

	void save();

	void load();

	boolean addProduct(String name, String category, String manufacturerСode, String date, String description);

	boolean removeProduct(String name);

	List<Product> findByText(String substr);

	Product findByFieldValue(ProductFields f, Object value);

	List<Product> findByFieldValue(ProductFields[] f, Object[] value);

	void sortByFiled(ProductFields f);

}