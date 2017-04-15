package by.epam.l11.homework;

public interface ViewInterface
{

	void save();

	void load();

	void addProduct(String name, String category, String manufacturerСode, String date, String description);

	void removeProduct(String name);

	void findByText(String substr);

	void findByFieldValue(ProductFields[] f, Object[] value);

	void sortByFiled(ProductFields f);

}