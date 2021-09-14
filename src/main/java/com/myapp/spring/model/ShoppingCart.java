package com.myapp.spring.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonAnyGetter;




@Entity
@Table(name="shoppingcart")
public class ShoppingCart {

	@Transient
	public static String ORDERED = "ordered";

	@Transient
	public static String PENDING = "pending";

	@Id
	
	private String id;

	
	public String status; // pending, ordered

	//@NaturalId(mutable = false)
	public String userName;

	@ElementCollection
	@MapKeyColumn(name="product_key")
	@Column(name="product_value")
	@CollectionTable(name="product_cart",joinColumns = @JoinColumn(name="id"))
	public Map<Integer, Product> products;


	@ElementCollection
	@MapKeyColumn(name="product_qnty")
	@Column(name="product_value")
	@CollectionTable(name="product_cart_qnty")

	public Map<Integer, Integer> productQuantities;

	@Column(name = "last_modified")
	public Date lastModified;

	@Column(name = "ordered_date")
	public Date orderDate;

//total price
	@Column(name = "price")
	public int totalPrice = 0;

	public ShoppingCart() {
	}

	public ShoppingCart(String status, String userName,

			Map<Integer, Product> products,

			Map<Integer, Integer> productQuantities,

			Date orderDate, Date lastModified, int totalPrice) {

		this.status = status;

		this.userName = userName;

		this.products = products;

		this.productQuantities = productQuantities;

		this.orderDate = orderDate;

		this.lastModified = lastModified;

		this.totalPrice = totalPrice;

	}

	public String getId() {

		return this.id;

	}
	
	

	public static String getORDERED() {
		return ORDERED;
	}

	public static void setORDERED(String oRDERED) {
		ORDERED = oRDERED;
	}

	public static String getPENDING() {
		return PENDING;
	}

	public static void setPENDING(String pENDING) {
		PENDING = pENDING;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	//@JsonAnyGetter
	public Map<Integer, Product> getProducts() {
		return products;
	}

	public void setProducts(Map<Integer, Product> products) {
		this.products = products;
	}

	public Map<Integer, Integer> getProductQuantities() {
		return productQuantities;
	}

	public void setProductQuantities(Map<Integer, Integer> productQuantities) {
		this.productQuantities = productQuantities;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void setId(String id) {
		this.id = id;
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