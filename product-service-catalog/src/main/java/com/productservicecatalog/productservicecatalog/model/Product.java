package com.productservicecatalog.productservicecatalog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private Long id;

	@Column
	@NotNull(message = "Please enter product name")
	private String productName;

	@Column
	@NotNull(message = "Please enter price")
	private Long price;

	@Column
	private String description;

	@Column
	private String category;

	@Column
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
		return "Product [id=" + id + ", productName=" + productName + ", price=" + price + ", description="
				+ description + ", category=" + category + ", availability=" + availability + "]";
	}

}
