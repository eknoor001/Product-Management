package collection_project_product_management;

public interface MenuService {
	
	void AvailableCategory();
	
	void add(ProductType type, Product product);

	void getCategoryItem(ProductType type,Product product);
	
	void updateDetails(ProductType type,Product product);
	
	void getProductDetails(ProductType type);

	

	

}
