package com.myapp.spring.model;

import java.util.Date;
import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="cart")
public class Cart {

	public static String ORDERED = "ordered";

	public static String PENDING = "pending";

	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "status")
	public String status; // pending, ordered

	@Column(name = "username")
	public String userName;

	@Column(name = "products")
	public HashMap<Integer, Product> products;

	@Column(name = "quantity")
	public HashMap<Integer, Integer> productQuantities;


//total price
	@Column(name = "price")
	public int totalPrice = 0;

	public Cart() {
	}

	public Cart(String status, String userName,

			HashMap<Integer, Product> products,

			HashMap<Integer, Integer> productQuantities,

			Date orderDate, Date lastModified, int totalPrice) {

		this.status = status;

		this.userName = userName;

		this.products = products;

		this.productQuantities = productQuantities;

		this.totalPrice = totalPrice;

	}

	public String getId() {

		return this.id;

	}

	public Product getProductFromId(String productId) {

		return this.products.get(productId);

	}

	public void addProduct(Product product) {

//Check if the product is in the HashMap

		Product fromCart = this.products.get(product.getProductId());

		if (fromCart == null) {

			this.products.put(product.getProductId(), product);

		}

	}

	public void addProductQuantity(Product product) {

		Integer productId = product.getProductId();

		if (this.productQuantities.containsKey(productId)) {

			int quantity = this.productQuantities.get(productId);

			quantity++;

			this.productQuantities.put(productId, quantity);

		}

		else {

// init the product quantities if key not found

			this.productQuantities.put(productId, 1);

		}

		this.totalPrice += product.getPrice();

	}

	public void removeProduct(Integer productId) {

		if (this.products.containsKey(productId)) {

			this.products.remove(productId);

		}

	}

	public void removeProductQuantity(Product product) {

		Integer productId = product.getProductId();

		if (this.productQuantities.containsKey(productId)) {

			int quantity = this.productQuantities.get(productId);

			quantity--;

//remove datas from the HashMaps when quantity is too low

			if (quantity < 1) {

				this.productQuantities.remove(productId);

				this.removeProduct(productId);

			}

			else {

				this.productQuantities.put(productId, quantity);

			}

			this.totalPrice -= product.getPrice();
		}

	}

}