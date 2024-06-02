package collection_project_product_management;

import java.util.Scanner;

public class Processing {

	public static void main(String[] args) {

		MenuImplementation obj = new MenuImplementation();

		Scanner sc = new Scanner(System.in);
		int ch = -1;
		do {
			System.out.println("\n1.Add Product." +
					"\n2. Search for a Product." +
					"\n3. Show all Product types." +
					"\n4. Display all Products of the specific type." +
					"\n5. Edit Product details." +
					"\n0. Exit");

			ch = sc.nextInt();
			sc.nextLine();
			switch (ch) {
				case 1:
					System.out.println("Enter the Product-Type if Exist / if you want new enter");
					String type = sc.nextLine();

					System.out.println("Enter the Product you want to add:");
					System.out.println("Enter the id of product:");
					int id = sc.nextInt();
					sc.nextLine(); // Consume newline left-over

					System.out.println("Enter the name of the product:");
					String name = sc.nextLine();

					System.out.println("Enter the price:");
					float price = sc.nextFloat();
					sc.nextLine(); // Consume newline left-over

					obj.add(new ProductType(type), new Product(id, name, price));

					break;

				case 2:
					System.out.println("Enter the productType in which your product is present");
					String type1 = sc.nextLine();

					System.out.println("Enter the product you want to search");
					String pro = sc.nextLine();

					obj.getCategoryItem(new ProductType(type1), new Product(pro));

					break;

				case 3:
					obj.AvailableCategory();
					break;

				case 4:
					System.out.println("Enter the productType");
					String type2 = sc.nextLine();
					obj.getProductDetails(new ProductType(type2));
					break;

				case 5:
					System.out.println("Enter the productType in which your product is present");
					String typee = sc.nextLine();

					System.out.println("Enter the product you want to search");
					String proo = sc.nextLine();

					obj.updateDetails(new ProductType(typee), new Product(proo));

					break;

				case 0:
					System.out.println("Exiting...");
					sc.close();
					System.exit(0);
					break;

				default:
					System.err.println("Enter a valid choice!");
					break;
			}

		} while (ch != 0);

	}
}
