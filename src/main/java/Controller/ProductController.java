package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Entity.Product;
import Service.ProductService;

@RestController

public class ProductController {

	@Autowired
	private ProductService service;
	
	@PostMapping("/addproduct")
	public Product addProduct(@RequestBody Product product) {
		return service.saveProduct(product);	
	}
	
	@PostMapping("/addproducts")
	public List<Product> addAllProducts(@RequestBody List<Product> products) {
		return service.saveProducts(products);
		
	}
	
	@GetMapping("/products")
	public List<Product> findAllProducts() {
		return service.getAllProducts();
	}
	
	
	@GetMapping("/product/{id}")
	public Product findProductById(@PathVariable int id) {
		return service.getProductById(id);
	}
	

	@DeleteMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id) {
    	return service.deleteProductById(id);
    }
	
}
