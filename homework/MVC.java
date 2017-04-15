package by.epam.l11.homework;

public class MVC
{

	public static void main(String[] args)
	{
		ModelInterface m =new Model();
		ControllerInterface c = new Controller(m);
		ViewInterface v = new View(c);
		v.load();
		
		
		v.addProduct("кружка", "посуда", "BY", "2017.01.01", "Большая белая кружка для чая");
		v.addProduct("тарелка", "посуда", "BY", "2017.02.01", "кашку кушать");
		v.addProduct("миска", "посуда", "RU", "2017.01.23", "для супа");
		
		v.addProduct("лейс", "чипсы", "RU", "2017.01.23", "норм");
		v.addProduct("онега", "чипсы", "BY", "2017.01.23", "так себе");

		
		System.out.println("------------ищем кружку-------");		
		
		ProductFields[] f = {ProductFields.NAME};
		String[] s = {"кружка"};
		
		v.findByFieldValue(f,s);
		
		
		System.out.println("------------ищем BY--------");		
		
		ProductFields[] f2 = {ProductFields.MANUFACTURERСODE};
		String[] s2 = {"BY"};
		

		System.out.println("------------ищем ''для''--------");		
		v.findByFieldValue(f2,s2);	
		v.findByText("для");
		

		System.out.println("------------ищем по нескольким параметрам--------");		
		
		ProductFields[] f3 = {ProductFields.CATEGORY, ProductFields.MANUFACTURERСODE};
		String[] s3 = {"посуда", "RU"};		
		v.findByFieldValue(f3,s3);
		
		
		System.out.println("------------сортируем по описанию--------");
		v.sortByFiled(ProductFields.DESCRIPTION);
		
		ProductFields[] f4 = {ProductFields.CATEGORY};
		String[] s4 = {"посуда"};
		v.findByFieldValue(f4,s4);
				
		
		
		
		v.save();
		

	}

}
