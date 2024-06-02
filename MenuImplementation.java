package collection_project_product_management;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.Scanner;

public class MenuImplementation implements MenuService {

	File file = new File("ProductDataList.txt");
	FileOutputStream fos = null;
	ObjectOutputStream oos = null;
	HashMap<ProductType, ArrayList<Product>> container = null;
	// File input Stream
	FileInputStream fis = null;
	ObjectInputStream ois = null;

	public MenuImplementation() {

		if (!file.exists()) {
			try {
				file.createNewFile();

			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		try {

			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);

		} catch (Exception e) {
			System.out.println("1." + e.getMessage());
		}

		try {

			container = (HashMap<ProductType, ArrayList<Product>>) ois.readObject();
		} catch (Exception e) {
			System.out.println("2." + e.getMessage());
		}

		if (container == null)
			container = new HashMap<ProductType, ArrayList<Product>>();
	}

	// Add method
	@Override
	public void add(ProductType type, Product product) {
		ArrayList<Product> list = new ArrayList<Product>();
		boolean flag = false;
		if (!container.isEmpty()) {
			for (Entry<ProductType, ArrayList<Product>> entry : container.entrySet()) {
				if (entry.getKey().getTypename().equalsIgnoreCase(type.getTypename())) {
					list.addAll(container.get(entry.getKey()));
					list.add(product);
					container.put(entry.getKey(), list);
					flag = true;

				}

			}
			if (flag == false) {
				list.add(product);
				container.put(type, list);
			}
		} else {

			list.add(product);
			container.put(type, list);
		}
		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(container);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\nProduct added......");
	}

	@Override
	public void getCategoryItem(ProductType type, Product product) {

		ArrayList<Product> items = null;
		boolean flag = false;
		if (file.exists()) {
			for (Entry<ProductType, ArrayList<Product>> entry : container.entrySet()) {
				if (entry.getKey().getTypename().equalsIgnoreCase(type.getTypename())) {
					items = entry.getValue();
					Iterator<Product> i1 = items.iterator();
					while (i1.hasNext()) {
						Product p = i1.next();
						if (product.getName().equalsIgnoreCase(p.getName())) {
							System.out.println("\nProduct Available\n");
							System.out.println(p.getId() + " " + p.getName() + " " + p.getPrice());
							flag = true;
							break;
						}
					}

				}
			}
			if (flag == false) {
				System.out.println("\nProduct not available");
			}
		} else {
			System.out.println("No data is available(File not existed)..");
		}

	}

	@Override
	public void updateDetails(ProductType type, Product product) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Product> items = null;

		boolean flag = false;
		for (Entry<ProductType, ArrayList<Product>> entry : container.entrySet()) {
			if (entry.getKey().getTypename().equalsIgnoreCase(type.getTypename())) {
				items = entry.getValue();

				ListIterator<Product> i1 = items.listIterator();
				while (i1.hasNext()) {

					Product p = i1.next();
					if (p.getName().toString().equalsIgnoreCase(product.getName().toString())) {

						System.out.println("Previous details");
						System.out.println("\nName : " + p.getName());
						System.out.println("Id : " + p.getId());
						System.out.println("Price : " + p.getPrice());

						System.out.println("\nEnter new deatils :");
						System.out.println("\nEnter new id : ");
						int id = sc.nextInt();
						System.out.println("Enter the new Name : ");
						String name = sc.next();
						System.out.println("Enter the new Price : ");
						float price = sc.nextFloat();

						i1.set(new Product(id, name, price));

						flag = true;

						try {
							fos = new FileOutputStream(file);
							oos = new ObjectOutputStream(fos);
							oos.writeObject(container);
						} catch (IOException e) {
							e.printStackTrace();

						}
						System.out.println("\nUpdated.....................");

					}

				}
				if (flag == false) {
					System.out.println("\nThis product is not available in database");
				}

			}
		}

	}

	@Override
	public void getProductDetails(ProductType type) {
		ArrayList<Product> items = null;
		boolean flag = false;
		if (file.exists()) {

			if (container.size() == 0) {
				System.out.println("No Product Types are available!!");
			} else {
				for (Entry<ProductType, ArrayList<Product>> entry : container.entrySet()) {

					if (entry.getKey().getTypename().equalsIgnoreCase(type.getTypename())) {
						System.out.println("Products in this Type " + entry.getKey() + " are ");
						items = entry.getValue();
						Iterator<Product> i1 = items.iterator();
						while (i1.hasNext()) {
							Product temp = i1.next();
							System.out.println("\nId is :" + temp.getId() + "\nProduct Name is : " + temp.getName()
									+ "\nProduct price is : " + temp.getPrice());
						}
						flag = true;

					}

				}
				if (flag == false) {
					System.out.println("No products are available...");
				}
			}
		} else {
			System.out.println("No data is available (File not existed)...");
		}

	}

	@Override
	public void AvailableCategory() {

		if (file.exists()) {

			if (container.size() == 0) {
				System.out.println("No Product Types are available!!");

			} else {
				System.out.println("Available Product Types are:-\n");
				for (Entry<ProductType, ArrayList<Product>> entry : container.entrySet()) {

					System.out.println(entry.getKey().getTypename());

				}
			}
		} else {
			System.out.println("No Product Types are available!!");
		}

	}

}
