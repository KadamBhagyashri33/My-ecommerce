package com.productservicecatalog.productservicecatalog.vo;

public class ProductVO {

	private Long id;
	private String productName;
	private Long price;
	private String description;
	private String category;
	private int availability;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getAvailability() {
		return availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}
	@Override
	public String toString() {
		return "ProductVO [id=" + id + ", productName=" + productName + ", price=" + price + ", description="
				+ description + ", category=" + category + ", availability=" + availability + "]";
	}


}


