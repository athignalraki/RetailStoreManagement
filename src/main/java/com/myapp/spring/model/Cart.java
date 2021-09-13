package com.myapp.spring.model;

import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cart")
public class Cart {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	@NotNull
    @Column(name = "productId",unique=true, nullable = false)
	private Integer productId;
	
	@Column(name = "productName")
	private String productName;

	@Column(name = "QUANTITY")
	private Integer quantity;

	

	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public Cart(@NotNull Integer producId, @NotNull String productName, @NotNull Integer quantity) {
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(productId, productName, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Cart))
			return false;
		Cart other = (Cart) obj;
		return Objects.equals(productId, other.productId) && Objects.equals(productName, other.productName)
				&& Objects.equals(quantity, other.quantity);
	}

	
	
}
