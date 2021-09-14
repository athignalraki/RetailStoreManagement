//package com.myapp.spring.integration;
//import static org.hamcrest.CoreMatchers.is;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Paths;
//import java.util.Arrays;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import com.fasterxml.jackson.core.JsonParseException;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.myapp.spring.model.Cart;
//import com.myapp.spring.repository.ProductRepository;
//
//@SpringBootTest
//
//@AutoConfigureMockMvc(addFilters = false)
//public class ShoppingCartIntegrationTest {
//	
//	@Autowired
//	private ProductRepository repository;
//	
//	@Autowired
//	private MockMvc mockMvc;
//	
//private static File DATA_JSON= Paths.get("src","test","resources","cart.json").toFile();
//	
//	
//	@BeforeEach
//	public void setUp() throws JsonParseException, JsonMappingException, IOException {
//		
//	Cart carts[] = new ObjectMapper().readValue(DATA_JSON, Cart[].class);
//	
//	// save each product to database
//	//Arrays.stream(carts).forEach(repository::save);	
//		
//		
//	}
//	
//	@AfterEach
//	public void cleanUp() {
//		repository.deleteAll();
//		
//	}
//	
//	@Test
//	@DisplayName("Test Product by Name - GET /api/v1/cart/")
//	public void testGetCartByName() throws Exception {
//		
//		
//		// Perform GET Request
//		
//		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/cart/{id}",1))
//		// Validate Status should be 200 OK and JSON response received
//		.andExpect(status().isOk())
//		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
//		
//		// Validate Response Body
//		
//		.andExpect(jsonPath("$.product_id", is(1)))
//		.andExpect(jsonPath("$.product_name", is("Oneplus")))
//		.andExpect(jsonPath("$.quantity", is(5)));
//		
//		
//	}
//	
//	@Test
//	@DisplayName("Test All Products /api/v1/cart/")
//	public void testGetAllCart() throws Exception {
//		
//		
//		
//		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/cart"))
//		// Validate Status should be 200 OK and JSON response received
//		.andExpect(status().isOk())
//		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
//		
//		// Validate Response Body
//		
//		.andExpect(jsonPath("$.product_id", is(2)))
//		.andExpect(jsonPath("$.product_name", is("samsung")))
//		.andExpect(jsonPath("$.quantity", is(3)))
//		
//		
//		
//		
//		
//		.andExpect(jsonPath("$[1].product_id", is(13)))
//		.andExpect(jsonPath("$[1].product_name", is("redmi")))
//		
//		.andExpect(jsonPath("$[1].quantity", is(3)));
//		
//		
//		
//		
//		
//	}
//
//	private void save(Cart cart1) {
//	}
//	
////	//@Test
////	@DisplayName("Test All Products By Price /api/v1/cart/{price}")
////	public void testGetAllProductsByPrice() throws Exception {
////		
////	
////		// Prepare Mock Service Method
////		double price =50000.00;
////		
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
////		.andExpect(jsonPath("$[0].quantity", is(3)))
////		
////		.andExpect(jsonPath("$[1].product_id", is(36)))
////		.andExpect(jsonPath("$[1].product_name", is("Oneplus")))
////		.andExpect(jsonPath("$[1].quantity", is(2)));
////		
////		
////		
////	}
////	
////	//@Test
////	@DisplayName("Test All Products By Price /api/v1/cart?name=&price")
////	public void testGetAllProductsByNameOrPrice() throws Exception {
////		
////		
////		
////		// Prepare Mock Service Method
////		Double price =50000.00;
////		String productName="Oneplus";
////		
////	
////		
////		
////		// Perform GET Request
////		
////		
////		mockMvc.perform(MockMvcRequestBuilders
////				.get("/api/v1/cart/findByPriceOrName")
////				.queryParam("productName",productName)
////				.queryParam("price", price.toString()))
////		// Validate Status should be 200 OK and JSON response received
////		.andExpect(status().isOk())
////		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
////		
////		// Validate Response Body
////		
////		.andExpect(jsonPath("$[0].productId", is(35)))
////		.andExpect(jsonPath("$[0].productName", is("Oneplus")))
////		.andExpect(jsonPath("$[0].description", is("OnePlus9Pro")))
////		.andExpect(jsonPath("$[0].price", is(70000.00)))
////		.andExpect(jsonPath("$[0].starRating", is(4.5)))
////		
////		.andExpect(jsonPath("$[1].productId", is(36)))
////		.andExpect(jsonPath("$[1].productName", is("Oneplus")))
////		.andExpect(jsonPath("$[1].description", is("OnePlus8Pro")))
////		.andExpect(jsonPath("$[1].price", is(60000.00)))
////		.andExpect(jsonPath("$[1].starRating", is(4.5)));
////		
////		
////		
////		
////	}
////	
//	
//	
////	
////	//@Test
////	@DisplayName("Test Add New Cart")
////	public void testAddNewProduct() throws Exception {
////		
////		// Prepare Mock Product
////		Product newproduct = new Product("Oneplus", "OnePlus9Pro", 70000.00, 4.5);
////		
////		Product mockproduct = new Product("Oneplus", "OnePlus9Pro", 70000.00, 4.5);
////		mockproduct.setProductId(50);
//		// Prepare Mock Service Method
//		
//		
//		
//		// Perform GET Request
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
////		.andExpect(jsonPath("$.productName", is("Oneplus")))
////		.andExpect(jsonPath("$.description", is("OnePlus9Pro")))
////		.andExpect(jsonPath("$.price", is(70000.00)))
////		.andExpect(jsonPath("$.starRating", is(4.5)));
////		
////		
////	}
//}
//	
//
//
