package collection_project_product_management;

import java.io.Serializable;

public class ProductType implements Serializable{

	private String typename;

	public ProductType() {
		super();
	}

	public ProductType(String typename) {
		super();
		this.typename = typename;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	@Override
	public String toString() {
		return "ProductType [typename=" + typename + "]";
	}
	
//	@Override
//	public boolean equals(Object obj) {
//		System.out.println("hloooo");
//		if(obj == null)
//			return false;
//		if(obj == this)
//			return true;
//		return this.getTypename().equals(((ProductType)obj).getTypename());
//	}

}
