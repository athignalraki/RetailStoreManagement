//package com.myapp.spring.web.api;
//package com.myapp.spring.web.api;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.mockito.Mockito.doReturn;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.mockito.ArgumentMatchers;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.myapp.spring.model.Product;
//import com.myapp.spring.repository.ProductRepository;
//
//@SpringBootTest
//
//@AutoConfigureMockMvc(addFilters = false)
//public class CartAPITest {
//	
//	@MockBean
//	private ProductRepository repository;
//	
//	@Autowired
//	private MockMvc mockMvc;
//	
//	@Test
//	@DisplayName("Test Product by Name - GET /api/v1/shoppingcart/")
//	public void testGetProductsByName() throws Exception {
//		
//		// Prepare Mock Product
//		Product product = new Product(1,"oneplus",5);
//		product.setProductId(1);
//		
//		// Prepare Mock Service Method
//		
//		doReturn(Optional.of(product)).when(repository).findByProductName(product.getProductName());
//		
//		// Perform GET Request
//		
//		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/shoppingcart/{Name}","oneplus"))
//		// Validate Status should be 200 OK and JSON response received
//		.andExpect(status().isOk())
//		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
//		
//		// Validate Response Body
//		
//		.andExpect(jsonPath("$.productId", is(1)))
//		.andExpect(jsonPath("$.productName", is("Oneplus")))
//		.andExpect(jsonPath("$.quantity", is(5)));
//		
//		
//		
//	}
//	
//	@Test
//	@DisplayName("Test All Products /api/v1/shoppingcart/")
//	public void testGetAllProducts() throws Exception {
//		
//		// Prepare Mock Product
//		Product product1 = new Product(1,"oneplus",5);
//		product1.setProductId(35);
//		
//		Product product2 = new Product(2,"samsung",3);
//		product2.setProductId(36);
//		
//		List<Product> products = new ArrayList<>();
//		products.add(product1);
//		products.add(product2);
//		
//		// Prepare Mock Service Method
//		
//		doReturn(products).when(repository).findAll();
//		
//		// Perform GET Request
//		
//		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/shoppingcart"))
//		// Validate Status should be 200 OK and JSON response received
//		.andExpect(status().isOk())
//		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
//		
//		// Validate Response Body
//		
//		.andExpect(jsonPath("$[0].productId", is(35)))
//		.andExpect(jsonPath("$[0].productName", is("Oneplus")))
//		.andExpect(jsonPath("$[0].quantity", is(5)))
//		
//		
//		.andExpect(jsonPath("$[1].productId", is(36)))
//		.andExpect(jsonPath("$[1].productName", is("samsung")))
//		.andExpect(jsonPath("$[1].quantity", is(3)));
//		
//		
//		
//		
//		
//	}
//}
//	
////	@Test
////	@DisplayName("Test All Products By Price /api/v1/cart/{price}")
////	public void testGetAllProductsByPrice() throws Exception {
////		
////		// Prepare Mock Product
////		Product product1 = new Product(1,"oneplus",5);
////		product1.setProductId(35);
////		
////		Product product2 = new Product(2,"samsung",3);
////		product2.setProductId(36);
////		
////		Product product3 = new Product(3,"redmi",2);
////		product3.setProductId(37);
////		
////		List<Product> products = new ArrayList<>();
////		products.add(product1);
////		products.add(product2);
////		products.add(product3);
////		
////		// Prepare Mock Service Method
////		double price =50000.00;
////		
////		doReturn(Optional.of(products)).when(repository)
////		.findByPriceGreaterThanEqual(price);
////		
////		// Perform GET Request
////		
////		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/cart/findByPrice/{price}",price))
////		// Validate Status should be 200 OK and JSON response received
////		.andExpect(status().isOk())
////		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
////		
////		// Validate Response Body
////		
////		.andExpect(jsonPath("$[0].product_id", is(35)))
////		.andExpect(jsonPath("$[0].product_name", is("Oneplus")))
////		.andExpect(jsonPath("$[0].quantity", is(5)))
////		
////		
////		.andExpect(jsonPath("$[1].product_id", is(36)))
////		.andExpect(jsonPath("$[1].product_name", is("samsung")))
////		.andExpect(jsonPath("$[1].quantity", is(3)))
////		
////		
////		.andExpect(jsonPath("$[2].product_id", is(37)))
////		.andExpect(jsonPath("$[2].product_name", is("redmi")))
////		.andExpect(jsonPath("$[2].quantity", is(2)));
////		
////		
////		
////	}
////	
////	@Test
////	@DisplayName("Test All Products By Name /api/v1/cart")
////	public void testGetAllProductsByName() throws Exception {
////		
////		// Prepare Mock Product
////		Product product1 = new Product(1,"oneplus",5);
////		product1.setProductId(35);
////		
////		Product product2 = new Product(2,"samsung",3);
////		product2.setProductId(36);
////		
////		
////		
////		List<Product> products = new ArrayList<>();
////		products.add(product1);
////		products.add(product2);
////		
////		
////		// Prepare Mock Service Method
////		int quantity = 5;
////		String product_name="Oneplus";
////		
////		doReturn(Optional.of(products)).when(repository)
////		.findByProductNameOrId(product_name, quantity);
////		
////		
////		// Perform GET Request
////		
////		
////		Object product_id;
////		mockMvc.perform(MockMvcRequestBuilders
////				.get("/api/v1/products/findByNameOrId")
////				.queryParam("product_name",product_name)
////				.queryparm("product_id",product_id)
////		// Validate Status should be 200 OK and JSON response received
////		.andExpect(status().isOk())
////		//.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
////		
////		// Validate Response Body
////		
////		.andExpect(jsonPath("$[0].productId", is(35)))
////		.andExpect(jsonPath("$[0].productName", is("samsung")))
////		.andExpect(jsonPath("$[0].quantity", is(3)))
////		
////		
////		.andExpect(jsonPath("$[1].product_id", is(36)))
////		.andExpect(jsonPath("$[1].product_name", is("redmi")))
////		.andExpect(jsonPath("$[1].quantity", is("2")));
////		
////		
////		
////		
////	}
////	
////	
////	
////	
////	@Test
////	@DisplayName("Test Add New Product")
////	public void testAddNewProduct() throws Exception {
////		
////		// Prepare Mock Product
////		Product newproduct = new Product(1,"oneplus",5);
////		
////		Product mockproduct = new Product(2,"samsung",3);
////		mockproduct.setProductId(50);
////		// Prepare Mock Service Method
////		
////		doReturn(mockproduct).when(repository).save(ArgumentMatchers.any());
////		
////		// Perform GET Request
////		
////		mockMvc.perform(post("/api/v1/cart")
////		// Validate Status should be 200 OK and JSON response received
////		
////		.contentType(MediaType.APPLICATION_JSON_VALUE)
////		.content(new ObjectMapper().writeValueAsString(newproduct)))
////		
////		
////		// Validate Response Body
////		.andExpect(status().isCreated())
////		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
////		.andExpect(jsonPath("$.productId", is(50)))
////		.andExpect(jsonPath("$.product_name", is("Oneplus")))
////		.andExpect(jsonPath("$.quantity", is(5)));
////		
////		
////	}
////	@Test
////	@DisplayName("Test Update Existing Product")
////	public void testUpdateExistingProduct() throws Exception {
////		
////		// Prepare Mock Product
////		
////		Product mockproduct = new Product(1,"oneplus",5);
////		
////		Product productToBeUpdated = new Product(2,"samsung",3);
////		productToBeUpdated.setProductId(50);
////		
////		
////		mockproduct.setProductId(50);
////		// Prepare Mock Service Method
////		
////		doReturn(Optional.of(mockproduct)).when(repository).findById(50);
////		
////		doReturn(mockproduct).when(repository).save(ArgumentMatchers.any());
////		
////		// Perform GET Request
////		
////		mockMvc.perform(put("/api/v1/cart/{id}",50)
////		// Validate Status should be 200 OK and JSON response received
////		
////		.contentType(MediaType.APPLICATION_JSON_VALUE)
////		.content(new ObjectMapper().writeValueAsString(productToBeUpdated)))
////		
////		
////		// Validate Response Body
////		.andExpect(status().isCreated())
////		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
////		.andExpect(jsonPath("$.productId", is(50)))
////		.andExpect(jsonPath("$.product_name", is("realme")))
////		.andExpect(jsonPath("$.quantity", is("10")));
////		
////		
////	}
////	
////
////}
