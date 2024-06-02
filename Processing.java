package collection_project_product_management;

import java.util.Scanner;

public class Processing {

	public static void main(String[] args) {

		MenuImplementation obj = new MenuImplementation();

		Scanner sc = new Scanner(System.in);
		int ch = -1;
		do {
			System.out.println("\n1.Add Product." + "\n2. Search for an Product." + "\n3. Show all Product types."
					+ "\n4. Display all Products of the specific type."
					+ "\n5. Edit Product details." + "\n0. Exit");

			ch = sc.nextInt();
			switch (ch) {
			case 1:
				System.out.println("Enter the Product-Type if Exist / if you want new enter");
				String type = sc.next();

				System.out.println("Enter the Product you want to add :");
				System.out.println("Enter the id of product :");
				int id = sc.nextInt();

				System.out.println("Enter the name of the product :");
				String name = sc.next();

				System.out.println("Enter the price :");
				float price = sc.nextFloat();

				obj.add(new ProductType(type), new Product(id, name, price));

				break;

			case 2:
				System.out.println("Enter the productType in which your product present");
				String type1 = sc.next();

				System.out.println("Enter the product you want to search");
				String pro = sc.next();

				obj.getCategoryItem(new ProductType(type1), new Product(pro));

				break;

			case 3:
				obj.AvailableCategory();
				break;

			case 4:
				System.out.println("Enter the productType");
				String type2 = sc.next();
				obj.getProductDetails(new ProductType(type2));
				break;
				
			case 5:
				System.out.println("Enter the productType in which your product present");
				String typee = sc.next();

				System.out.println("Enter the product you want to search");
				String proo = sc.next();

				obj.updateDetails(new ProductType(typee), new Product(proo));

				break;

			case 0:
				System.exit(0);
				break;

			default:
				System.err.println("Enter the valid choice!");
			}

		} while (ch != 0);

	}

}
